/**
 * Copyright 2017 Florida Institute for Human and Machine Cognition (IHMC)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package us.ihmc.rtps.impl.fastRTPS;

import java.io.IOException;
import java.nio.ByteBuffer;

import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.attributes.PublisherAttributes;
import us.ihmc.pubsub.attributes.TopicAttributes.TopicKind;
import us.ihmc.pubsub.common.Guid;
import us.ihmc.pubsub.common.MatchingInfo;
import us.ihmc.pubsub.common.SerializedPayload;
import us.ihmc.pubsub.publisher.Publisher;
import us.ihmc.pubsub.publisher.PublisherListener;

class FastRTPSPublisher implements Publisher
{
   private final Object destructorLock = new Object(); 

   private NativePublisherImpl impl;
   private final FastRTPSPublisherAttributes attributes;
   private final TopicDataType<Object> topicDataType;
   private final PublisherListener listener;
   private final SerializedPayload payload;
   private TopicAttributes fastRTPSAttributes;
   private ThroughputControllerDescriptor throughputController;
   private final Guid guid = new Guid();

   private final ByteBuffer keyBuffer = ByteBuffer.allocateDirect(16);
   private final NativePublisherListenerImpl nativeListenerImpl = new NativePublisherListenerImpl();

   private class NativePublisherListenerImpl extends NativePublisherListener
   {
      private final MatchingInfo matchingInfo = new MatchingInfo();

      @Override
      public void onWriterMatched(MatchingStatus status, long guidHigh, long guidLow)
      {
         try
         {
            if (listener != null)
            {
               matchingInfo.getGuid().fromPrimitives(guidHigh, guidLow);
               matchingInfo.setStatus(MatchingInfo.MatchingStatus.values[status.swigValue()]);
               listener.onPublicationMatched(FastRTPSPublisher.this, matchingInfo);
            }
         }
         catch (Throwable e)
         {
            e.printStackTrace();
         }
      }
   }

   @SuppressWarnings("unchecked")
   FastRTPSPublisher(TopicDataType<?> topicDataTypeIn, FastRTPSPublisherAttributes attributes, PublisherListener listener,
                            NativeParticipantImpl participant)
         throws IOException, IllegalArgumentException
   {
      synchronized (destructorLock)
      {
         LocatorList_t unicastLocatorList = new LocatorList_t();
         FastRTPSCommonFunctions.convertToCPPLocatorList(attributes.getUnicastLocatorList(), unicastLocatorList);
         LocatorList_t multicastLocatorList = new LocatorList_t();
         FastRTPSCommonFunctions.convertToCPPLocatorList(attributes.getMulticastLocatorList(), multicastLocatorList);
         LocatorList_t outLocatorList = new LocatorList_t();
         FastRTPSCommonFunctions.convertToCPPLocatorList(attributes.getOutLocatorList(), outLocatorList);

         if (!unicastLocatorList.isValid())
         {
            throw new IllegalArgumentException("Unicast Locator List for Publisher contains invalid Locator");
         }
         if (!multicastLocatorList.isValid())
         {
            throw new IllegalArgumentException(" Multicast Locator List for Publisher contains invalid Locator");
         }
         if (!outLocatorList.isValid())
         {
            throw new IllegalArgumentException("Output Locator List for Publisher contains invalid Locator");
         }

         this.attributes = attributes;
         this.topicDataType = (TopicDataType<Object>) topicDataTypeIn.newInstance();
         this.listener = listener;
         this.payload = new SerializedPayload(topicDataType.getTypeSize());

         fastRTPSAttributes = attributes.createFastRTPSTopicAttributes();
         throughputController = attributes.createTroughputControllerDescriptor();

         WriterQos qos = attributes.getQos().getWriterQos();
         if (!qos.checkQos() || !fastRTPSAttributes.checkQos())
         {
            throw new IllegalArgumentException("Invalid QoS settings");
         }

         impl = new NativePublisherImpl(attributes.getEntityID(), attributes.getUserDefinedID(), topicDataType.getTypeSize(),
                                        MemoryManagementPolicy_t.swigToEnum(attributes.getHistoryMemoryPolicy().ordinal()), fastRTPSAttributes, qos, attributes.getTimes(), unicastLocatorList, multicastLocatorList,
                                        outLocatorList, throughputController, participant, nativeListenerImpl);
         if (!impl.createPublisher()) // Create publisher after assigning impl to avoid callbacks with impl being unassigned
         {
            throw new IOException("Cannot create publisher");
         }
         guid.fromPrimitives(impl.getGuidHigh(), impl.getGuidLow());

         unicastLocatorList.delete();
         multicastLocatorList.delete();
         outLocatorList.delete();
      }
   }

   @Override
   public void write(Object data) throws IOException
   {
      synchronized(destructorLock)
      {
         if(impl == null)
         {
            throw new IOException("This publisher has been removed from the domain");
         }
         
         serializeMessage(data);
         impl.write(payload.getData(), payload.getLength(), payload.getEncapsulation(), keyBuffer, keyBuffer.position());
      }
   }

   private void serializeMessage(Object data) throws IOException
   {
      if (attributes.getTopic().getTopicKind() == TopicKind.WITH_KEY)
      {
         keyBuffer.clear();
         topicDataType.getKey(data, keyBuffer);
      }
  
      payload.getData().clear();
      topicDataType.serialize(data, payload);
   }
   
   @Override
   public void dispose(Object data) throws IOException
   {
      synchronized(destructorLock)
      {
         if(impl == null)
         {
            throw new IOException("This publisher has been removed from the domain");
         }

         serializeMessage(data);
         impl.dispose(payload.getData(), payload.getLength(), payload.getEncapsulation(), keyBuffer, keyBuffer.position());
      }
   }

   @Override
   public void unregister(Object data) throws IOException
   {
      synchronized(destructorLock)
      {
         if(impl == null)
         {
            throw new IOException("This publisher has been removed from the domain");
         }

         serializeMessage(data);
         impl.unregister(payload.getData(), payload.getLength(), payload.getEncapsulation(), keyBuffer, keyBuffer.position());
      }
   }

   @Override
   public void dispose_and_unregister(Object data) throws IOException
   {
      synchronized(destructorLock)
      {
         if(impl == null)
         {
            throw new IOException("This publisher has been removed from the domain");
         }

         serializeMessage(data);
         impl.dispose_and_unregister(payload.getData(), payload.getLength(), payload.getEncapsulation(), keyBuffer, keyBuffer.position());
      }
   }

   @Override
   public Guid getGuid()
   {
      return guid;
   }

   @Override
   public PublisherAttributes getAttributes()
   {
      return attributes;
   }

   void delete()
   {
      synchronized(destructorLock)
      {
         impl.delete();
         nativeListenerImpl.delete();
         fastRTPSAttributes.delete();
         throughputController.delete();
         impl = null;
      }
   }

   @Override
   public void finalize()
   {
      delete();
   }

   @Override
   public int removeAllChange() throws IOException
   {
      synchronized(destructorLock)
      {
         if(impl == null)
         {
            throw new IOException("This publisher has been removed from the domain");
         }
         
         int removed = impl.removeAllChange();
         if (removed >= 0)
         {
            return removed;
         }
         else
         {
            throw new IOException("Cannot remove all changes");
         }
      }
   }

   public TopicDataType<?> getTopicDataType()
   {
      return topicDataType;
   }

   @Override
   public boolean isAvailable()
   {
      synchronized(destructorLock)
      {
         return impl != null;
      }
   }
}

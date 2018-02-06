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

import us.ihmc.idl.CDR;
import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.attributes.SubscriberAttributes;
import us.ihmc.pubsub.common.ChangeKind;
import us.ihmc.pubsub.common.Guid;
import us.ihmc.pubsub.common.MatchingInfo;
import us.ihmc.pubsub.common.SampleIdentity;
import us.ihmc.pubsub.common.SampleInfo;
import us.ihmc.pubsub.common.SerializedPayload;
import us.ihmc.pubsub.common.Time;
import us.ihmc.pubsub.subscriber.Subscriber;
import us.ihmc.pubsub.subscriber.SubscriberListener;

class FastRTPSSubscriber implements Subscriber
{
   private final Object destructorLock = new Object(); 


   // We use synchronization objects here because ReentrantLocks allocate memory
   private final Object newMessageNotification = new Object();
   private long unreadCountForMessageNotification = 0;
   
   private NativeSubscriberImpl impl;

   private final FastRTPSSubscriberAttributes attributes;
   private final TopicDataType<Object> topicDataType;
   private final Object topicData;
   private final SubscriberListener listener;
   private final SerializedPayload payload;
   private TopicAttributes fastRTPSAttributes;
   private final Guid guid = new Guid();
   private final MatchingInfo matchingInfo = new MatchingInfo();
   

   private final ByteBuffer keyBuffer = ByteBuffer.allocateDirect(16);

   private final SampleInfoMarshaller sampleInfoMarshaller = new SampleInfoMarshaller();

   private final TopicKind_t topicKind;
   private final OwnershipQosPolicyKind ownershipQosPolicyKind;

   private final NativeSubscriberListenerImpl nativeListenerImpl = new NativeSubscriberListenerImpl();

   private class NativeSubscriberListenerImpl extends NativeSubscriberListener
   {
      @Override
      public void onReaderMatched(MatchingStatus status, long guidHigh, long guidLow)
      {
         try
         {
            if (listener != null)
            {
               matchingInfo.getGuid().fromPrimitives(guidHigh, guidLow);
               matchingInfo.setStatus(MatchingInfo.MatchingStatus.values[status.swigValue()]);
               listener.onSubscriptionMatched(FastRTPSSubscriber.this, matchingInfo);
            }
         }
         catch (Throwable e)
         {
            e.printStackTrace();
         }
      }

      @Override
      public void onNewCacheChangeAdded()
      {
         try
         {
            synchronized(newMessageNotification)
            {
               unreadCountForMessageNotification = impl.getUnreadCount();
               newMessageNotification.notifyAll();
            }
            
            if (listener != null)
            {
               listener.onNewDataMessage(FastRTPSSubscriber.this);
            }

         }
         catch (Throwable e)
         {
            e.printStackTrace();
         }
      }

      @Override
      public boolean getKey(long cacheChangePtr, short encoding, int dataLength)
      {
         impl.getData(cacheChangePtr, payload.getData().capacity(), payload.getData());
         preparePayload(encoding, dataLength);
         if (!topicDataType.isGetKeyDefined())
         {
            return false;
         }
         try
         {
            topicDataType.deserialize(payload, topicData);
         }
         catch (IOException e)
         {
            return false;
         }
         keyBuffer.clear();
         topicDataType.getKey(topicData, keyBuffer);
         keyBuffer.flip();
         impl.updateKey(cacheChangePtr, keyBuffer);

         return true;
      }

   }

   private void preparePayload(short encapsulation, int dataLength)
   {
      payload.getData().clear();
      payload.setEncapsulation(encapsulation);
      
      // Compatibility for older versions of FastRTPS that do not include encapsulation in the payload size
      if(CDR.getTypeSize(dataLength) <= payload.getMax_size())
      {
         dataLength = CDR.getTypeSize(dataLength);
      }
      
      payload.setLength(dataLength);         
      payload.getData().limit(dataLength);

   }

   @SuppressWarnings("unchecked")
   FastRTPSSubscriber(TopicDataType<?> topicDataTypeIn, FastRTPSSubscriberAttributes attributes, SubscriberListener listener,
                      NativeParticipantImpl participantImpl)
         throws IOException
   {

      LocatorList_t unicastLocatorList = new LocatorList_t();
      FastRTPSCommonFunctions.convertToCPPLocatorList(attributes.getUnicastLocatorList(), unicastLocatorList);
      LocatorList_t multicastLocatorList = new LocatorList_t();
      FastRTPSCommonFunctions.convertToCPPLocatorList(attributes.getMulticastLocatorList(), multicastLocatorList);
      LocatorList_t outLocatorList = new LocatorList_t();
      FastRTPSCommonFunctions.convertToCPPLocatorList(attributes.getOutLocatorList(), outLocatorList);
      
      
      
      
      if (!unicastLocatorList.isValid())
      {
         throw new IllegalArgumentException("Unicast Locator List for Subscriber contains invalid Locator");
      }
      if (!multicastLocatorList.isValid())
      {
         throw new IllegalArgumentException(" Multicast Locator List for Subscriber contains invalid Locator");
      }
      if (!outLocatorList.isValid())
      {
         throw new IllegalArgumentException("Output Locator List for Subscriber contains invalid Locator");
      }

      ReaderQos qos = attributes.getQos().getReaderQos();
      this.attributes = attributes;
      this.topicDataType = (TopicDataType<Object>) topicDataTypeIn.newInstance();
      this.topicData = topicDataType.createData();
      this.listener = listener;
      this.payload = new SerializedPayload(topicDataType.getTypeSize());
      this.topicKind = TopicKind_t.swigToEnum(attributes.getTopic().getTopicKind().ordinal());
      this.ownershipQosPolicyKind = qos.getM_ownership().getKind();

      fastRTPSAttributes = attributes.createFastRTPSTopicAttributes();

      if (!qos.checkQos() || !fastRTPSAttributes.checkQos())
      {
         throw new IllegalArgumentException("Invalid QoS settings");
      }

      impl = new NativeSubscriberImpl(attributes.getEntityID(), attributes.getUserDefinedID(), topicDataType.getTypeSize(),
                                      MemoryManagementPolicy_t.swigToEnum(attributes.getHistoryMemoryPolicy().ordinal()), fastRTPSAttributes, qos,
                                      attributes.getTimes(), unicastLocatorList, multicastLocatorList, outLocatorList, attributes.isExpectsInlineQos(), participantImpl,
                                      nativeListenerImpl);

      guid.fromPrimitives(impl.getGuidHigh(), impl.getGuidLow());
      
      // Register reader after impl has been assigned, this avoids race conditions due to impl being null during a callback
      impl.registerReader(fastRTPSAttributes, qos);
      
      unicastLocatorList.delete();
      multicastLocatorList.delete();
      outLocatorList.delete();
   }

   @Override
   public Guid getGuid()
   {
      return guid;
   }

   @Override
   public void waitForUnreadMessage(int timeoutInMilliseconds) throws InterruptedException
   {
      synchronized (newMessageNotification)
      {
         synchronized(destructorLock)
         {
            if(impl == null)
            {
               throw new RuntimeException("This subscriber has been removed from the domain");
            }
            unreadCountForMessageNotification = impl.getUnreadCount();
         }
         
         long startTime = System.nanoTime();
         int timeRemaining = timeoutInMilliseconds;
         
         while (unreadCountForMessageNotification == 0 && timeRemaining > 0)
         {
            newMessageNotification.wait(timeoutInMilliseconds);
            timeRemaining -= (System.nanoTime() - startTime) / 1000000;
         }
      }
   }

   private void updateSampleInfo(SampleInfoMarshaller marshaller, SampleInfo info, ByteBuffer keyBuffer)
   {
      
      info.setDataLength(marshaller.getDataLength());
      info.setOwnershipStrength(marshaller.getOwnershipStrength());
      info.setSampleKind(ChangeKind.values[marshaller.getChangeKind()]);

      Time time = info.getSourceTimestamp();
      time.setSeconds(marshaller.getTime_seconds());
      time.setFraction(marshaller.getTime_fraction());

      SampleIdentity id = info.getSampleIdentity();
      id.getGuid().fromPrimitives(marshaller.getSampleIdentity_GuidHigh(), marshaller.getSampleIdentity_GuidLow());
      id.getSequenceNumber().set(marshaller.getSampleIdentity_sequenceNumberHigh(), marshaller.getSampleIdentity_sequenceNumberLow());

      SampleIdentity relatedId = info.getRelatedSampleIdentity();
      relatedId.getGuid().fromPrimitives(marshaller.getRelatedSampleIdentity_GuidHigh(), marshaller.getRelatedSampleIdentity_GuidLow());
      relatedId.getSequenceNumber().set(marshaller.getRelatedSampleIdentity_sequenceNumberHigh(), marshaller.getRelatedSampleIdentity_sequenceNumberLow());

   }

   @Override
   public boolean readNextData(Object data, SampleInfo info) throws IOException
   {
      synchronized(destructorLock)
      {
         if(impl == null)
         {
            throw new IOException("This subscriber has been removed from the domain");
         }
         
         boolean ret = false;
         impl.lock();
         {
            long cacheChange = impl.readnextData(payload.getData().capacity(), payload.getData(), sampleInfoMarshaller, topicKind, ownershipQosPolicyKind);
            if (cacheChange != 0)
            {
               if (sampleInfoMarshaller.getChangeKind() == ChangeKind_t.ALIVE.swigValue())
               {
                  preparePayload(sampleInfoMarshaller.getEncapsulation(), sampleInfoMarshaller.getDataLength());
                  topicDataType.deserialize(payload, data);
               }
   
               if (sampleInfoMarshaller.getUpdateKey())
               {
                  keyBuffer.clear();
                  topicDataType.getKey(data, keyBuffer);
                  keyBuffer.flip();
                  impl.updateKey(cacheChange, keyBuffer);
               }
               else
               {
                  sampleInfoMarshaller.getInstanceHandleValue(keyBuffer);
                  keyBuffer.clear();
               }
               if (info != null)
               {
                  updateSampleInfo(sampleInfoMarshaller, info, keyBuffer);
               }
               ret = true;
            }
            else
            {
               ret = false;
            }
         }
         impl.unlock();
         return ret;
      }
   }

   @Override
   public boolean takeNextData(Object data, SampleInfo info) throws IOException
   {
      synchronized(destructorLock)
      {
         if(impl == null)
         {
            throw new IOException("This subscriber has been removed from the domain");
         }
         
         boolean ret = false;
         impl.lock();
         {
            long cacheChange = impl.takeNextData(payload.getData().capacity(), payload.getData(), sampleInfoMarshaller, topicKind, ownershipQosPolicyKind);
            if (cacheChange != 0)
            {
   
               if (sampleInfoMarshaller.getChangeKind() == ChangeKind_t.ALIVE.swigValue())
               {
                  preparePayload(sampleInfoMarshaller.getEncapsulation(), sampleInfoMarshaller.getDataLength());
                  topicDataType.deserialize(payload, data);
               }
   
               if (sampleInfoMarshaller.getUpdateKey())
               {
                  keyBuffer.clear();
                  topicDataType.getKey(data, keyBuffer);
                  keyBuffer.flip();
                  impl.updateKey(cacheChange, keyBuffer);
               }
               else
               {
                  sampleInfoMarshaller.getInstanceHandleValue(keyBuffer);
                  keyBuffer.clear();
               }
               if (info != null)
               {
                  updateSampleInfo(sampleInfoMarshaller, info, keyBuffer);
               }
   
               impl.remove_change_sub_swig(cacheChange);
               ret = true;
            }
         }
         impl.unlock();
         return ret;
      }
   }

   @Override
   public SubscriberAttributes getAttributes()
   {
      return attributes;
   }

   @Override
   public boolean isInCleanState()
   {
      synchronized(destructorLock)
      {
         if(impl == null)
         {
            throw new RuntimeException("This subscriber has been removed from the domain");
         }
         return impl.isInCleanState();
      }
   }

   void delete()
   {
      synchronized(destructorLock)
      {
         impl.delete();
         fastRTPSAttributes.delete();
         nativeListenerImpl.delete();
         impl = null;
      }
   }

   TopicDataType<Object> getTopicDataType()
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

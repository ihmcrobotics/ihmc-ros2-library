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
package us.ihmc.pubsub.impl.fastRTPS;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.UUID;

import com.eprosima.xmlschemas.fastrtps_profiles.TopicKindType;

import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.attributes.PublisherAttributes;
import us.ihmc.pubsub.common.Guid;
import us.ihmc.pubsub.common.MatchingInfo;
import us.ihmc.pubsub.common.SerializedPayload;
import us.ihmc.pubsub.publisher.Publisher;
import us.ihmc.pubsub.publisher.PublisherListener;
import us.ihmc.rtps.impl.fastRTPS.NativeParticipantImpl;
import us.ihmc.rtps.impl.fastRTPS.NativePublisherImpl;
import us.ihmc.rtps.impl.fastRTPS.NativePublisherListener;

class FastRTPSPublisher implements Publisher
{
   private final Object destructorLock = new Object(); 

   private NativePublisherImpl impl;
   private final PublisherAttributes attributes;
   private final TopicDataType<Object> topicDataType;
   private final PublisherListener listener;
   private final SerializedPayload payload;
   private final Guid guid = new Guid();

   private final ByteBuffer keyBuffer = ByteBuffer.allocateDirect(16);
   private final NativePublisherListenerImpl nativeListenerImpl = new NativePublisherListenerImpl();

   private class NativePublisherListenerImpl extends NativePublisherListener
   {
      private final MatchingInfo matchingInfo = new MatchingInfo();

      @Override
      public void onWriterMatched(int matchingStatus, long guidHigh, long guidLow)
      {
         try
         {
            if (listener != null)
            {
               matchingInfo.getGuid().fromPrimitives(guidHigh, guidLow);
               matchingInfo.setStatus(MatchingInfo.MatchingStatus.values[matchingStatus]);
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
   FastRTPSPublisher(TopicDataType<?> topicDataTypeIn, PublisherAttributes attributes, PublisherListener listener,
                     NativeParticipantImpl participant)
         throws IOException, IllegalArgumentException
   {
      synchronized (destructorLock)
      {

         this.attributes = attributes;
         this.topicDataType = (TopicDataType<Object>) topicDataTypeIn.newInstance();
         this.listener = listener;
         this.payload = new SerializedPayload(topicDataType.getTypeSize());

         String profileName = UUID.randomUUID().toString();
         String profileXML = attributes.marshall(profileName);

         impl = new NativePublisherImpl(participant, nativeListenerImpl);
         if (!impl.createPublisher(profileName, profileXML, profileXML.length())) // Create publisher after assigning impl to avoid callbacks with impl being unassigned
         {
            throw new IOException("Cannot create publisher");
         }
         guid.fromPrimitives(impl.getGuidHigh(), impl.getGuidLow());
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
      if (attributes.getTopicKind() == TopicKindType.WITH_KEY)
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

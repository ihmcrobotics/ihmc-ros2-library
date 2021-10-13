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
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.UUID;

import com.eprosima.xmlschemas.fastrtps_profiles.*;
import us.ihmc.idl.CDR;
import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.attributes.OwnerShipPolicyKind;
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
import us.ihmc.rtps.impl.fastRTPS.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

class FastRTPSSubscriber<T> implements Subscriber<T>
{
   private final Object destructorLock = new Object(); 
  
   private NativeSubscriberImpl impl;

   private final SubscriberAttributes attributes;
   private final TopicDataType<T> topicDataType;
   private final SubscriberListener<T> listener;
   private final SerializedPayload payload;
   private final Guid guid = new Guid();
   private final MatchingInfo matchingInfo = new MatchingInfo();
   
   private final ByteBuffer keyBuffer = ByteBuffer.allocateDirect(16);

   private final SampleInfoMarshaller sampleInfoMarshaller = new SampleInfoMarshaller();

   private final NativeSubscriberListenerImpl nativeListenerImpl = new NativeSubscriberListenerImpl();

   private class NativeSubscriberListenerImpl extends NativeSubscriberListener
   {
      @Override
      public void onSubscriptionMatched(int matchingStatus, long guidHigh, long guidLow)
      {
         try
         {
            if (listener != null)
            {
               matchingInfo.getGuid().fromPrimitives(guidHigh, guidLow);
               matchingInfo.setStatus(MatchingInfo.MatchingStatus.values[matchingStatus]);
               listener.onSubscriptionMatched(FastRTPSSubscriber.this, matchingInfo);
            }
         }
         catch (Throwable e)
         {
            e.printStackTrace();
         }
      }

      @Override
      public void onNewDataMessage()
      {
         try
         {
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

   FastRTPSSubscriber(TopicDataType<T> topicDataTypeIn, SubscriberAttributes attrs, SubscriberListener<T> listener,
                      NativeParticipantImpl participantImpl)
         throws IOException
   {
      synchronized (destructorLock)
      {

         this.attributes = attrs;
         this.topicDataType = topicDataTypeIn.newInstance();
         this.listener = listener;
         /*
          * Fast-RTPS can pad messages to 4 byte boundries. Adding 3 to the typesize will make sure the message fits.
          *
          * See
          * https://github.com/eProsima/Fast-RTPS/blob/095d657e117381fd7f6b611a0db216b7df942354/src/cpp/subscriber/SubscriberImpl.cpp#L46
          */
         this.payload = new SerializedPayload(topicDataType.getTypeSize() + 3 /* Possible alignment */);

         String profileName = UUID.randomUUID().toString();

         Dds dds = new Dds();

         ProfilesType profilesType = new ProfilesType();
         SubscriberProfileType subscriberProfile = new SubscriberProfileType();
         profilesType.getLibrarySettingsOrTransportDescriptorsOrParticipant().add(new JAXBElement<>(new QName(FastRTPSDomain.FAST_DDS_XML_NAMESPACE, FastRTPSDomain.FAST_DDS_SUBSCRIBER), SubscriberProfileType.class, subscriberProfile));
         subscriberProfile.setProfileName(profileName);
         dds.getProfiles().add(profilesType);


         //TOPIC
         TopicAttributesType topicAttributesType = new TopicAttributesType();
         topicAttributesType.setDataType(attrs.getTopicDataType().getName());
         topicAttributesType.setName(attrs.getTopicName());

         HistoryQosPolicyType historyQosPolicyType = new HistoryQosPolicyType();
         historyQosPolicyType.setDepth(attrs.getHistoryDepth());
         switch(attrs.getHistoryQosPolicyKind())
         {
            case KEEP_ALL_HISTORY_QOS:
               historyQosPolicyType.setKind(HistoryQosKindType.KEEP_ALL);
               break;
            case KEEP_LAST_HISTORY_QOS:
               historyQosPolicyType.setKind(HistoryQosKindType.KEEP_LAST);
               break;
         }
         topicAttributesType.setHistoryQos(historyQosPolicyType);
         //TOPIC END
         subscriberProfile.setTopic(topicAttributesType);

         //QOS
         ReaderQosPoliciesType readerQosPoliciesType = new ReaderQosPoliciesType();

         OwnershipQosPolicyType ownershipQosPolicyType = new OwnershipQosPolicyType();


         switch(attrs.getOwnerShipPolicyKind())
         {
            case SHARED_OWNERSHIP_QOS:
               ownershipQosPolicyType.setKind(OwnershipQosKindType.SHARED);
               break;
            case EXCLUSIVE_OWNERSHIP_QOS:
               ownershipQosPolicyType.setKind(OwnershipQosKindType.EXCLUSIVE);
               break;
            default:
               break;

         }
         //readerQosPoliciesType.setOwnership(ownershipQosPolicyType);

         DurabilityQosPolicyType durabilityQosPolicyType = new DurabilityQosPolicyType();
         switch(attrs.getDurabilityKind())
         {
            case PERSISTENT_DURABILITY_QOS:
               durabilityQosPolicyType.setKind(DurabilityQosKindType.PERSISTENT);
               break;
            case TRANSIENT_DURABILITY_QOS:
               durabilityQosPolicyType.setKind(DurabilityQosKindType.TRANSIENT);
               break;
            case TRANSIENT_LOCAL_DURABILITY_QOS:
               durabilityQosPolicyType.setKind(DurabilityQosKindType.TRANSIENT_LOCAL);
               break;
            case VOLATILE_DURABILITY_QOS:
               durabilityQosPolicyType.setKind(DurabilityQosKindType.VOLATILE);
               break;
         }
         readerQosPoliciesType.setDurability(durabilityQosPolicyType);

         ReliabilityQosPolicyType reliabilityQosPolicyType = new ReliabilityQosPolicyType();
         switch(attrs.getReliabilityKind())
         {
            case RELIABLE:
               reliabilityQosPolicyType.setKind(ReliabilityQosKindType.RELIABLE);
               break;
            case BEST_EFFORT:
               reliabilityQosPolicyType.setKind(ReliabilityQosKindType.BEST_EFFORT);
               break;
         }
         readerQosPoliciesType.setReliability(reliabilityQosPolicyType);


         if(attrs.getPartitions() != null && !attrs.getPartitions().isEmpty())
         {
            PartitionQosPolicyType partitionQosPolicyType = new PartitionQosPolicyType();
            NameVectorType nameVectorType = new NameVectorType();
            attrs.getPartitions().forEach(s -> nameVectorType.getName().add(s));
            partitionQosPolicyType.setNames(nameVectorType);
            readerQosPoliciesType.setPartition(partitionQosPolicyType);
         }

         //QOS END
         subscriberProfile.setQos(readerQosPoliciesType);

         StringWriter writer = new StringWriter();

         try
         {
            JAXBContext context = JAXBContext.newInstance(Dds.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(dds, writer);
         } catch (JAXBException e )
         {
            throw new IOException("Colud not marshal XML", e);
         }

         impl = new NativeSubscriberImpl(participantImpl, nativeListenerImpl);

         String data = writer.toString();

         if (!impl.createSubscriber(profileName, data, data.length())) // Create subscriber after assigning impl to avoid callbacks with impl being unassigned
         {
            throw new IOException("Cannot create subscriber with data: \n" + data);
         }
         guid.fromPrimitives(impl.getGuidHigh(), impl.getGuidLow());
      }
   }

   @Override
   public Guid getGuid()
   {
      return guid;
   }

   @Override
   public void waitForUnreadMessage(int timeoutInMilliseconds)
   {
      synchronized(destructorLock)
      {
         if(impl == null)
         {
            throw new RuntimeException("This subscriber has been removed from the domain");
         }
         impl.waitForUnreadMessage();
      }
   }

   private void updateSampleInfo(SampleInfoMarshaller marshaller, SampleInfo info, ByteBuffer keyBuffer)
   {
      marshaller.getInstanceHandleValue(keyBuffer);
      keyBuffer.clear();
      
      info.setDataLength(marshaller.getDataLength());
      info.setOwnershipStrength(marshaller.getOwnershipStrength());
      info.setSampleKind(ChangeKind.values[marshaller.getChangeKind()]);

      Time time = info.getSourceTimestamp();
      time.setSeconds(marshaller.getTime_seconds());
      time.set(marshaller.getTime_nsec());

      SampleIdentity id = info.getSampleIdentity();
      id.getGuid().fromPrimitives(marshaller.getSampleIdentity_GuidHigh(), marshaller.getSampleIdentity_GuidLow());
      id.getSequenceNumber().set(marshaller.getSampleIdentity_sequenceNumberHigh(), marshaller.getSampleIdentity_sequenceNumberLow());

      SampleIdentity relatedId = info.getRelatedSampleIdentity();
      relatedId.getGuid().fromPrimitives(marshaller.getRelatedSampleIdentity_GuidHigh(), marshaller.getRelatedSampleIdentity_GuidLow());
      relatedId.getSequenceNumber().set(marshaller.getRelatedSampleIdentity_sequenceNumberHigh(), marshaller.getRelatedSampleIdentity_sequenceNumberLow());
   }

   @Override
   public boolean readNextData(T data, SampleInfo info)
   {
      synchronized(destructorLock)
      {
         if(impl == null)
         {
            System.err.println("This subscriber has been removed from the domain");
            return false;
         }         
         
         if(impl.readnextData(payload.getData().capacity(), payload.getData(), sampleInfoMarshaller))
         {
            if (info != null)
            {
               updateSampleInfo(sampleInfoMarshaller, info, keyBuffer);
            }
            preparePayload(sampleInfoMarshaller.getEncapsulation(), sampleInfoMarshaller.getDataLength());
            try
            {
               topicDataType.deserialize(payload, data);
            }
            catch (IOException e)
            {
               e.printStackTrace();
               return false;
            }
            return true;
         }
         else
         {
            return false;
         }
      }
   }

   @Override
   public T readNextData()
   {
      return readNextData(null);
   }

   @Override
   public T readNextData(SampleInfo info)
   {
      T nextData = topicDataType.createData();
      if (readNextData(nextData, info))
         return nextData;
      else
         return null;
   }

   @Override
   public boolean takeNextData(T data, SampleInfo info)
   {
      synchronized(destructorLock)
      {
         if(impl == null)
         {
            System.err.println("This subscriber has been removed from the domain");
            return false;
         }         
         
         if(impl.takeNextData(payload.getData().capacity(), payload.getData(), sampleInfoMarshaller))
         {
            if (info != null)
            {
               updateSampleInfo(sampleInfoMarshaller, info, keyBuffer);
            }
            preparePayload(sampleInfoMarshaller.getEncapsulation(), sampleInfoMarshaller.getDataLength());
            try
            {
               topicDataType.deserialize(payload, data);
            }
            catch (IOException e)
            {
               e.printStackTrace();
               return false;
            }
            return true;
         }
         else
         {
            return false;
         }
      }
   }

   @Override
   public T takeNextData()
   {
      return takeNextData(null);
   }

   @Override
   public T takeNextData(SampleInfo info)
   {
      T nextData = topicDataType.createData();
      if (takeNextData(nextData, info))
         return nextData;
      else
         return null;
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
         nativeListenerImpl.delete();
         impl = null;
      }
   }

   TopicDataType<T> getTopicDataType()
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

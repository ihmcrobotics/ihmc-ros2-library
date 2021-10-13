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
import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.attributes.PublisherAttributes;
import us.ihmc.pubsub.attributes.ThroughputControllerDescriptor;
import us.ihmc.pubsub.attributes.TopicAttributes;
import us.ihmc.pubsub.attributes.TopicAttributes.TopicKind;
import us.ihmc.pubsub.common.Guid;
import us.ihmc.pubsub.common.MatchingInfo;
import us.ihmc.pubsub.common.SerializedPayload;
import us.ihmc.pubsub.publisher.Publisher;
import us.ihmc.pubsub.publisher.PublisherListener;
import us.ihmc.rtps.impl.fastRTPS.NativeParticipantImpl;
import us.ihmc.rtps.impl.fastRTPS.NativePublisherImpl;
import us.ihmc.rtps.impl.fastRTPS.NativePublisherListener;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

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

         Dds dds = new Dds();

         ProfilesType profilesType = new ProfilesType();
         PublisherProfileType publisherProfile = new PublisherProfileType();
         profilesType.getLibrarySettingsOrTransportDescriptorsOrParticipant()
                     .add(new JAXBElement<>(
                           new QName(FastRTPSDomain.FAST_DDS_XML_NAMESPACE,
                                     FastRTPSDomain.FAST_DDS_PUBLISHER),
                           PublisherProfileType.class,
                           publisherProfile));
         publisherProfile.setProfileName(profileName);
         dds.getProfiles().add(profilesType);


         //TOPIC
         TopicAttributesType topicAttributesType = new TopicAttributesType();
         topicAttributesType.setDataType(attributes.getTopicDataType().getName());
         topicAttributesType.setName(attributes.getTopicName());

         HistoryQosPolicyType historyQosPolicyType = new HistoryQosPolicyType();
         historyQosPolicyType.setDepth(attributes.getHistoryDepth());
         switch(attributes.getHistoryQosPolicyKind())
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
         publisherProfile.setTopic(topicAttributesType);

         //QOS
         WriterQosPoliciesType writerQosPoliciesType = new WriterQosPoliciesType();

         DurabilityQosPolicyType durabilityQosPolicyType = new DurabilityQosPolicyType();
         switch(attributes.getDurabilityKind())
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
         writerQosPoliciesType.setDurability(durabilityQosPolicyType);

         ReliabilityQosPolicyType reliabilityQosPolicyType = new ReliabilityQosPolicyType();
         switch(attributes.getReliabilityKind())
         {
            case RELIABLE:
               reliabilityQosPolicyType.setKind(ReliabilityQosKindType.RELIABLE);
               break;
            case BEST_EFFORT:
               reliabilityQosPolicyType.setKind(ReliabilityQosKindType.BEST_EFFORT);
               break;
         }
         writerQosPoliciesType.setReliability(reliabilityQosPolicyType);

         if(attributes.getLifespan() != null)
         {
            LifespanQosPolicyType lifespanQosPolicyType = new LifespanQosPolicyType();
            DurationType dt = new DurationType();
            dt.getContent().add(new JAXBElement<>(new QName(FastRTPSDomain.FAST_DDS_XML_NAMESPACE, FastRTPSDomain.FAST_DDS_NANOSEC),
                                                  Long.class,
                                                  attributes.getLifespan().getNanoseconds()));
            dt.getContent().add(new JAXBElement<>(new QName(FastRTPSDomain.FAST_DDS_XML_NAMESPACE, FastRTPSDomain.FAST_DDS_SEC),
                                                  Integer.class,
                                                  attributes.getLifespan().getSeconds()));
            lifespanQosPolicyType.setDuration(dt);
            writerQosPoliciesType.setLifespan(lifespanQosPolicyType);
         }


         if(attributes.getPartitions() != null && !attributes.getPartitions().isEmpty())
         {
            PartitionQosPolicyType partitionQosPolicyType = new PartitionQosPolicyType();
            NameVectorType nameVectorType = new NameVectorType();
            attributes.getPartitions().forEach(s -> nameVectorType.getName().add(s));
            partitionQosPolicyType.setNames(nameVectorType);
            writerQosPoliciesType.setPartition(partitionQosPolicyType);
         }

         PublishModeQosPolicyType publishModeQosPolicyType = new PublishModeQosPolicyType();
         switch(attributes.getPublishModeKind())
         {
            case SYNCHRONOUS_PUBLISH_MODE:
               publishModeQosPolicyType.setKind(PublishModeQosKindType.SYNCHRONOUS);
               break;
            case ASYNCHRONOUS_PUBLISH_MODE:
               publishModeQosPolicyType.setKind(PublishModeQosKindType.ASYNCHRONOUS);
               break;
         }
         writerQosPoliciesType.setPublishMode(publishModeQosPolicyType);
         //QOS END
         publisherProfile.setQos(writerQosPoliciesType);

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

         String data = writer.toString();

         impl = new NativePublisherImpl(participant, nativeListenerImpl);
         if (!impl.createPublisher(profileName, data, data.length())) // Create publisher after assigning impl to avoid callbacks with impl being unassigned
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
      if (attributes.getTopicKind() == TopicKind.WITH_KEY)
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

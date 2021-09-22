/**
 * Copyright 2017 Florida Institute for Human and Machine Cognition (IHMC) Licensed under the Apache
 * License, Version 2.0 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package us.ihmc.rtps.impl.fastRTPS;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.UUID;

import com.eprosima.xmlschemas.fastrtps_profiles.*;
import com.eprosima.xmlschemas.fastrtps_profiles.RemoteServerAttributes;

import org.apache.commons.lang3.SystemUtils;

import us.ihmc.commons.thread.ThreadTools;
import us.ihmc.log.LogTools;
import us.ihmc.pubsub.Domain;
import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.attributes.*;
import us.ihmc.pubsub.attributes.PublisherAttributes;
import us.ihmc.pubsub.attributes.SubscriberAttributes;
import us.ihmc.pubsub.common.LogLevel;
import us.ihmc.pubsub.participant.Participant;
import us.ihmc.pubsub.participant.ParticipantListener;
import us.ihmc.pubsub.publisher.Publisher;
import us.ihmc.pubsub.publisher.PublisherListener;
import us.ihmc.pubsub.subscriber.Subscriber;
import us.ihmc.pubsub.subscriber.SubscriberListener;
import us.ihmc.tools.nativelibraries.NativeLibraryLoader;

import javax.xml.bind.*;
import javax.xml.namespace.QName;

public class FastRTPSDomain implements Domain
{
   public static final String FAST_DDS_DISCOVERY_CONFIGURABLE_PREFIX = "44.53.%02X.5f.45.50.52.4f.53.49.4d.41";
   public static final String FAST_DDS_XML_NAMESPACE = "http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles";
   public static final String FAST_DDS_METATRAFFIC_UNICAST_LOCATOR_LIST = "metatrafficUnicastLocatorList";
   public static final String FAST_DDS_PARTICIPANT = "participant";
   public static final String FAST_DDS_PUBLISHER = "publisher";
   public static final String FAST_DDS_NANOSEC = "nanosec";
   public static final String FAST_DDS_SEC = "sec";

   private final ArrayList<FastRTPSParticipant> participants = new ArrayList<>();

   private static boolean useSystemFastRTPS = false;
   private static FastRTPSDomain instance = null;

   public static synchronized FastRTPSDomain getInstance(boolean useSystemFastRTPS)
   {
      if (instance == null)
      {
         FastRTPSDomain.useSystemFastRTPS = useSystemFastRTPS;
         instance = new FastRTPSDomain(useSystemFastRTPS);
      }

      if(FastRTPSDomain.useSystemFastRTPS != useSystemFastRTPS)
      {
         if(useSystemFastRTPS)
         {
            throw new RuntimeException("Loading FastRTPS using the system FastRTPS library, but the builtin FastRTPS library is already loaded.");
         }
         else
         {
            throw new RuntimeException("Loading FastRTPS using the builtin FastRTPS library, but the system FastRTPS library is already loaded.");
         }
      }

      return instance;
   }

   private FastRTPSDomain(boolean useSystemFastRTPS)
   {
      try
      {
         if(useSystemFastRTPS)
         {
            System.loadLibrary("FastRTPSWrapper");
         }
         else
         {
            NativeLibraryLoader.loadLibrary("us.ihmc.rtps.impl.fastRTPS", "FastRTPSWrapper");

            // Force initialization of the FastRTPS class by setting the log level. This allows early bailout if there are linking errors.
            FastRTPSJNI.LogLevel_setLogLevel(0);
         }
      }
      catch (UnsatisfiedLinkError e)
      {
         if (SystemUtils.IS_OS_WINDOWS)
         {
            throw new UnsatisfiedLinkError("Cannot load library, make sure to install Microsoft Visual C++ 2019 Redistributable (x64) (https://aka.ms/vs/16/release/vc_redist.x64.exe). "
                  + e.getMessage());
         }
         else
         {
            throw e;
         }
      }
      Runtime.getRuntime().addShutdownHook(new Thread(() ->
      {
         LogTools.info("FastRTPS domain is going down.");
         stopAll();
         // It appears that without a small sleep, the printout does not show up.
         ThreadTools.sleep(10);
      }, "IHMCPubSub-FastRTPSDomain-StopAll"));
   }

   @Override
   public synchronized Participant createParticipant(ParticipantAttributes participantAttributes, ParticipantListener participantListener) throws IOException
   {
      FastRTPSParticipant participant = new FastRTPSParticipant(participantAttributes, participantListener);
      participants.add(participant);
      return participant;
   }

   @Override public Participant createParticipant(String xmlProfileData, ParticipantListener participantListener) throws IOException
   {
      FastRTPSParticipant participant = new FastRTPSParticipant(xmlProfileData, "INMEM_PARTICIPANT", participantListener);
      participants.add(participant);
      return participant;
   }

   @Override public Participant createParticipant(ParticipantAttributes2 att, ParticipantListener participantListener) throws IOException
   {
      String profileName = UUID.randomUUID().toString();

      Dds dds = new Dds();

      ProfilesType profilesType = new ProfilesType();
      ParticipantProfileType participantProfile = new ParticipantProfileType();
      profilesType.getLibrarySettingsOrTransportDescriptorsOrParticipant().add(new JAXBElement<>(new QName(FAST_DDS_XML_NAMESPACE,FAST_DDS_PARTICIPANT), ParticipantProfileType.class, participantProfile));
      participantProfile.setProfileName(profileName);
      dds.getProfiles().add(profilesType);

      participantProfile.setDomainId(att.getDomainId());

      RtpsParticipantAttributesType rtps = new RtpsParticipantAttributesType();
      rtps.setName(att.getName());
      participantProfile.setRtps(rtps);


      BuiltinAttributesType builtin = new BuiltinAttributesType();

      DurationType dt = new DurationType();
      dt.getContent().add(new JAXBElement<>(new QName(FAST_DDS_XML_NAMESPACE,FAST_DDS_NANOSEC),
                                            Long.class,
                                            att.getDiscoveryLeaseDuration().getNanoseconds()));
      dt.getContent().add(new JAXBElement<>(new QName(FAST_DDS_XML_NAMESPACE, FAST_DDS_SEC),
                                            Integer.class,
                                            att.getDiscoveryLeaseDuration().getSeconds()));

      DiscoverySettingsType discoverySettingsType = new DiscoverySettingsType();
      discoverySettingsType.setLeaseDuration(dt);
      if (att.isDiscoveryServerEnabled())
      {
         DiscoveryServerList discoveryServerList = new DiscoveryServerList();
         discoverySettingsType.setDiscoveryProtocol(DiscoveryProtocol.CLIENT);

         RemoteServerAttributes remoteServerAttributes = new RemoteServerAttributes();
         LocatorListType locatorListType = new LocatorListType();
         LocatorType locatorType = new LocatorType();
         Udpv4LocatorType udpv4LocatorType = new Udpv4LocatorType();
         udpv4LocatorType.setAddress(att.getDiscoveryServerAddress());
         udpv4LocatorType.setPort(att.getDiscoveryServerPort());
         locatorType.setUdpv4(udpv4LocatorType);
         locatorListType.getLocator().add(locatorType);

         remoteServerAttributes.getContent().add(new JAXBElement<>(new QName(FAST_DDS_XML_NAMESPACE,FAST_DDS_METATRAFFIC_UNICAST_LOCATOR_LIST),
                                                                   LocatorListType.class,
                                                                   locatorListType));

         remoteServerAttributes.setPrefix(String.format(FAST_DDS_DISCOVERY_CONFIGURABLE_PREFIX, att.getDiscoveryServerId()));
         discoveryServerList.getRemoteServer().add(remoteServerAttributes);
         discoverySettingsType.setDiscoveryServersList(discoveryServerList);
      }
      builtin.setDiscoveryConfig(discoverySettingsType);
      rtps.setBuiltin(builtin);
      StringWriter writer = new StringWriter();

      try
      {
         JAXBContext context = JAXBContext.newInstance(Dds.class);
         Marshaller m = context.createMarshaller();
         m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
         m.marshal(dds, writer);
         System.out.println(writer.toString());
      } catch (JAXBException e )
      {
         throw new IOException("Colud not marshal XML", e);
      }

      FastRTPSParticipant participant = new FastRTPSParticipant(writer.toString(), profileName, participantListener);
      participants.add(participant);
      return participant;
   }

   @Override
   public synchronized Publisher createPublisher(Participant participant, PublisherAttributes publisherAttributes, PublisherListener listener)
         throws IOException, IllegalArgumentException
   {
      Publisher publisher = null;

      for (int i = 0; i < participants.size(); i++)
      {
         if (participants.get(i) == participant)
         {
            publisher = participants.get(i).createPublisher(publisherAttributes, listener);
            break;
         }
      }

      if (publisher == null)
      {
         throw new IllegalArgumentException("Participant is not part of this domain.");
      }

      ThreadTools.sleep(1);

      return publisher;
   }

   @Override public Publisher createPublisher(Participant participant, PublisherAttributes2 att, TopicDataType<?> topicDataTypeIn, PublisherListener listener)
         throws IOException, IllegalArgumentException
   {
      String profileName = UUID.randomUUID().toString();

      Dds dds = new Dds();

      ProfilesType profilesType = new ProfilesType();
      PublisherProfileType publisherProfile = new PublisherProfileType();
      profilesType.getLibrarySettingsOrTransportDescriptorsOrParticipant().add(new JAXBElement<>(new QName(FAST_DDS_XML_NAMESPACE,FAST_DDS_PUBLISHER), PublisherProfileType.class, publisherProfile));
      publisherProfile.setProfileName(profileName);
      dds.getProfiles().add(profilesType);


      //TOPIC
      TopicAttributesType topicAttributesType = new TopicAttributesType();
      topicAttributesType.setDataType(topicDataTypeIn.getName());
      topicAttributesType.setName(att.getTopicName());

      HistoryQosPolicyType historyQosPolicyType = new HistoryQosPolicyType();
      historyQosPolicyType.setDepth(att.getHistoryDepth());
      switch(att.getHistoryQosPolicyKind())
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
      switch(att.getDurabilityKind())
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
      switch(att.getReliabilityKind())
      {
         case RELIABLE:
            reliabilityQosPolicyType.setKind(ReliabilityQosKindType.RELIABLE);
            break;
         case BEST_EFFORT:
            reliabilityQosPolicyType.setKind(ReliabilityQosKindType.BEST_EFFORT);
            break;
      }
      writerQosPoliciesType.setReliability(reliabilityQosPolicyType);

      if(att.getLifespan() != null)
      {
         LifespanQosPolicyType lifespanQosPolicyType = new LifespanQosPolicyType();
         DurationType dt = new DurationType();
         dt.getContent().add(new JAXBElement<>(new QName(FAST_DDS_XML_NAMESPACE,FAST_DDS_NANOSEC),
                                               Long.class,
                                               att.getLifespan().getNanoseconds()));
         dt.getContent().add(new JAXBElement<>(new QName(FAST_DDS_XML_NAMESPACE, FAST_DDS_SEC),
                                               Integer.class,
                                               att.getLifespan().getSeconds()));
         lifespanQosPolicyType.setDuration(dt);
         writerQosPoliciesType.setLifespan(lifespanQosPolicyType);
      }


      if(att.getPartitions() != null)
      {
         PartitionQosPolicyType partitionQosPolicyType = new PartitionQosPolicyType();
         NameVectorType nameVectorType = new NameVectorType();
         System.out.println(nameVectorType.getName());
         att.getPartitions().forEach(s -> nameVectorType.getName().add(s));
         partitionQosPolicyType.setNames(nameVectorType);
         writerQosPoliciesType.setPartition(partitionQosPolicyType);
      }

      PublishModeQosPolicyType publishModeQosPolicyType = new PublishModeQosPolicyType();
      switch(att.getPublishModeKind())
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
         System.out.println(writer.toString());
      } catch (JAXBException e )
      {
         throw new IOException("Colud not marshal XML", e);
      }

      Publisher publisher = null;

      for (int i = 0; i < participants.size(); i++)
      {
         if (participants.get(i) == participant)
         {
            publisher = participants.get(i).createPublisher(profileName, writer.toString(), topicDataTypeIn, listener);
            break;
         }
      }

      if (publisher == null)
      {
         throw new IllegalArgumentException("Participant is not part of this domain.");
      }

      ThreadTools.sleep(1);

      return publisher;
   }

   @Override public Publisher createPublisher(Participant participant, String profile, String XMLConfigData, TopicDataType<?> topicDataTypeIn, PublisherListener listener)
         throws IOException, IllegalArgumentException
   {
      Publisher publisher = null;

      for (int i = 0; i < participants.size(); i++)
      {
         if (participants.get(i) == participant)
         {
            publisher = participants.get(i).createPublisher(profile, XMLConfigData, topicDataTypeIn, listener);
            break;
         }
      }

      if (publisher == null)
      {
         throw new IllegalArgumentException("Participant is not part of this domain.");
      }

      ThreadTools.sleep(1);

      return publisher;
   }

   @Override
   public synchronized Subscriber createSubscriber(Participant participant, SubscriberAttributes subscriberAttributes, SubscriberListener listener)
         throws IOException, IllegalArgumentException
   {
      for (int i = 0; i < participants.size(); i++)
      {
         if (participants.get(i) == participant)
         {
            return participants.get(i).createSubscriber(subscriberAttributes, listener);
         }
      }
      throw new IllegalArgumentException("Participant is not part of this domain.");
   }

   @Override public Subscriber createSubscriber(Participant participant, SubscriberAttributes2 att, TopicDataType<?> topicDataTypeIn, SubscriberListener listener)
         throws IOException, IllegalArgumentException
   {
      String profileName = UUID.randomUUID().toString();

      Dds dds = new Dds();

      ProfilesType profilesType = new ProfilesType();
      PublisherProfileType publisherProfile = new PublisherProfileType();
      profilesType.getLibrarySettingsOrTransportDescriptorsOrParticipant().add(new JAXBElement<>(new QName(FAST_DDS_XML_NAMESPACE,FAST_DDS_PUBLISHER), PublisherProfileType.class, publisherProfile));
      publisherProfile.setProfileName(profileName);
      dds.getProfiles().add(profilesType);


      //TOPIC
      TopicAttributesType topicAttributesType = new TopicAttributesType();
      topicAttributesType.setDataType(topicDataTypeIn.getName());
      topicAttributesType.setName(att.getTopicName());

      HistoryQosPolicyType historyQosPolicyType = new HistoryQosPolicyType();
      historyQosPolicyType.setDepth(att.getHistoryDepth());
      switch(att.getHistoryQosPolicyKind())
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
      switch(att.getDurabilityKind())
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
      switch(att.getReliabilityKind())
      {
         case RELIABLE:
            reliabilityQosPolicyType.setKind(ReliabilityQosKindType.RELIABLE);
            break;
         case BEST_EFFORT:
            reliabilityQosPolicyType.setKind(ReliabilityQosKindType.BEST_EFFORT);
            break;
      }
      writerQosPoliciesType.setReliability(reliabilityQosPolicyType);


      if(att.getPartitions() != null)
      {
         PartitionQosPolicyType partitionQosPolicyType = new PartitionQosPolicyType();
         NameVectorType nameVectorType = new NameVectorType();
         System.out.println(nameVectorType.getName());
         att.getPartitions().forEach(s -> nameVectorType.getName().add(s));
         partitionQosPolicyType.setNames(nameVectorType);
         writerQosPoliciesType.setPartition(partitionQosPolicyType);
      }

      //QOS END
      publisherProfile.setQos(writerQosPoliciesType);

      StringWriter writer = new StringWriter();

      try
      {
         JAXBContext context = JAXBContext.newInstance(Dds.class);
         Marshaller m = context.createMarshaller();
         m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
         m.marshal(dds, writer);
         System.out.println(writer.toString());
      } catch (JAXBException e )
      {
         throw new IOException("Colud not marshal XML", e);
      }

      Subscriber subscriber = null;

      for (int i = 0; i < participants.size(); i++)
      {
         if (participants.get(i) == participant)
         {
            subscriber = participants.get(i).createSubscriber(profileName, writer.toString(), topicDataTypeIn, listener);
            break;
         }
      }

      if (subscriber == null)
      {
         throw new IllegalArgumentException("Participant is not part of this domain.");
      }

      ThreadTools.sleep(1);

      return subscriber;
   }

   @Override public Subscriber createSubscriber(Participant participant, String profile, String XMLConfigData, TopicDataType<?> topicDataTypeIn, SubscriberListener listener)
         throws IOException, IllegalArgumentException
   {
      for (int i = 0; i < participants.size(); i++)
      {
         if (participants.get(i) == participant)
         {
            return participants.get(i).createSubscriber(profile, XMLConfigData, topicDataTypeIn, listener);
         }
      }
      throw new IllegalArgumentException("Participant is not part of this domain.");
   }

   @Override
   public synchronized boolean removeParticipant(Participant participant)
   {
      for (int i = 0; i < participants.size(); i++)
      {
         if (participants.get(i) == participant)
         {
            participants.get(i).delete();
            participants.remove(i);
            return true;
         }
      }

      return false;
   }

   @Override
   public synchronized boolean removePublisher(Publisher publisher)
   {
      for (int i = 0; i < participants.size(); i++)
      {
         if (participants.get(i).getGuid().getGuidPrefix().equals(publisher.getGuid().getGuidPrefix()))
         {
            return participants.get(i).removePublisher(publisher);
         }
      }
      return false;
   }

   @Override
   public synchronized boolean removeSubscriber(Subscriber subscriber)
   {
      for (int i = 0; i < participants.size(); i++)
      {
         if (participants.get(i).getGuid().getGuidPrefix().equals(subscriber.getGuid().getGuidPrefix()))
         {
            return participants.get(i).removeSubscriber(subscriber);
         }
      }
      return false;
   }

   @Override
   public synchronized TopicDataType<?> getRegisteredType(Participant participant, String typeName)
   {
      for (int i = 0; i < participants.size(); i++)
      {
         if (participants.get(i) == participant)
         {
            return participants.get(i).getRegisteredType(typeName);
         }
      }
      return null;
   }

   @Override
   public synchronized void registerType(Participant participant, TopicDataType<?> topicDataType) throws IllegalArgumentException
   {
      for (int i = 0; i < participants.size(); i++)
      {
         if (participants.get(i) == participant)
         {
            participants.get(i).registerType(topicDataType);
            return;
         }
      }
      throw new IllegalArgumentException("Participant is not part of this domain.");
   }

   @Override
   public synchronized void unregisterType(Participant participant, String typeName) throws IOException
   {
      for (int i = 0; i < participants.size(); i++)
      {
         if (participants.get(i) == participant)
         {
            participants.get(i).unregisterType(typeName);
            return;
         }
      }
      throw new IllegalArgumentException("Participant is not part of this domain.");
   }

   @Override
   public synchronized void stopAll()
   {
      for (int i = participants.size() - 1; i >= 0; i--)
      {
         removeParticipant(participants.get(i));
      }
   }

   @Override
   public FastRTPSSubscriberAttributes createSubscriberAttributes()
   {
      return new FastRTPSSubscriberAttributes();
   }

   @Override
   public FastRTPSPublisherAttributes createPublisherAttributes()
   {
      return new FastRTPSPublisherAttributes();
   }

   @Override
   public FastRTPSParticipantAttributes createParticipantAttributes()
   {
      return new FastRTPSParticipantAttributes();
   }

   @Override
   public void setLogLevel(LogLevel level)
   {
      us.ihmc.rtps.impl.fastRTPS.LogLevel.setLogLevel(level.getLevel());
   }
}

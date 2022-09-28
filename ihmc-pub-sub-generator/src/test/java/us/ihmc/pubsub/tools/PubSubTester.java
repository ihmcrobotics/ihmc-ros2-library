package us.ihmc.pubsub.tools;

import static us.ihmc.pubsub.tools.PublishSubscribeTools.systemDomain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Supplier;

import com.eprosima.xmlschemas.fastrtps_profiles.DurabilityQosKindType;
import com.eprosima.xmlschemas.fastrtps_profiles.HistoryQosKindType;
import com.eprosima.xmlschemas.fastrtps_profiles.PublishModeQosKindType;
import com.eprosima.xmlschemas.fastrtps_profiles.ReliabilityQosKindType;

import us.ihmc.communication.packets.Packet;
import us.ihmc.idl.generated.test.IDLElementTestPubSubType;
import us.ihmc.pubsub.Domain;
import us.ihmc.pubsub.DomainFactory;
import us.ihmc.pubsub.DomainFactory.PubSubImplementation;
import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.attributes.ParticipantAttributes;
import us.ihmc.pubsub.attributes.PublisherAttributes;
import us.ihmc.pubsub.attributes.SubscriberAttributes;
import us.ihmc.pubsub.common.LogLevel;
import us.ihmc.pubsub.common.Time;
import us.ihmc.pubsub.participant.Participant;
import us.ihmc.pubsub.publisher.Publisher;
import us.ihmc.pubsub.subscriber.Subscriber;

public class PubSubTester<P extends Packet>
{
   public Domain domain;
   public Subscriber subscriber;
   public Publisher publisher;

   public ArrayList<MessageCallback<P>> callbacks = new ArrayList<>();

   public PubSubTester(Supplier<P> msgTypeSupplier) throws IOException
   {
      this(PubSubImplementation.FAST_RTPS, msgTypeSupplier);
   }

   public PubSubTester(PubSubImplementation pubSubImplementation, Supplier<P> msgTypeSupplier) throws IOException
   {
      domain = DomainFactory.getDomain(pubSubImplementation);

      domain.setLogLevel(LogLevel.INFO);

      ParticipantAttributes attributes = ParticipantAttributes.create()
        .domainId(systemDomain())
        .discoveryLeaseDuration(Time.Infinite)
        .name("PubSubTester");

      Participant participant = domain.createParticipant(attributes, new ParticipantListenerImpl());

      IDLElementTestPubSubType dataType = new IDLElementTestPubSubType();
      domain.registerType(participant, dataType);

      PublisherAttributes genericPublisherAttributes = PublisherAttributes.create()
       .topicDataType(dataType)
       .topicName("pubsubtest")
       .reliabilityKind(ReliabilityQosKindType.RELIABLE)
       .durabilityKind(DurabilityQosKindType.VOLATILE)
       .historyQosPolicyKind(HistoryQosKindType.KEEP_LAST)
       .historyDepth(1)
       .publishModeKind(PublishModeQosKindType.ASYNCHRONOUS);

      P data = msgTypeSupplier.get();
      TopicDataType<P> topicDataType = (TopicDataType<P>) data.getPubSubTypePacket().get();

      SubscriberAttributes subscriberAttributes = SubscriberAttributes.create()
       .topicDataType(topicDataType)
       .topicName("pubsubtest")
       .reliabilityKind(ReliabilityQosKindType.RELIABLE)
       .durabilityKind(DurabilityQosKindType.VOLATILE)
       .historyQosPolicyKind(HistoryQosKindType.KEEP_ALL);

      subscriber = domain.createSubscriber(participant, subscriberAttributes, new SubscriberListenerImpl(data,callbacks));

      publisher = domain.createPublisher(participant, genericPublisherAttributes, new PublisherListenerImpl());
   }
}
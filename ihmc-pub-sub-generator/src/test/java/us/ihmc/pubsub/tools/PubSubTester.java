package us.ihmc.pubsub.tools;

import us.ihmc.communication.packets.Packet;
import us.ihmc.idl.generated.test.IDLElementTestPubSubType;
import us.ihmc.pubsub.Domain;
import us.ihmc.pubsub.DomainFactory;
import us.ihmc.pubsub.DomainFactory.PubSubImplementation;
import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.attributes.*;
import us.ihmc.pubsub.attributes.HistoryQosPolicy.HistoryQosPolicyKind;
import us.ihmc.pubsub.common.LogLevel;
import us.ihmc.pubsub.common.Time;
import us.ihmc.pubsub.participant.Participant;
import us.ihmc.pubsub.publisher.Publisher;
import us.ihmc.pubsub.subscriber.Subscriber;

import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Supplier;

import static us.ihmc.pubsub.tools.PublishSubscribeTools.systemDomain;

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

      ParticipantAttributes attributes = domain.createParticipantAttributes();
      attributes.setDomainId(systemDomain());
      attributes.setLeaseDuration(Time.Infinite);
      attributes.setName("PubSubTester");

      Participant participant = domain.createParticipant(attributes, new ParticipantListenerImpl());

      IDLElementTestPubSubType dataType = new IDLElementTestPubSubType();
      domain.registerType(participant, dataType);

      PublisherAttributes publisherAttributes = domain.createPublisherAttributes(participant, dataType, "pubsubtest", ReliabilityKind.RELIABLE);
      publisherAttributes.getQos().setDurabilityKind(DurabilityKind.VOLATILE_DURABILITY_QOS);
      publisherAttributes.getTopic().getHistoryQos().setKind(HistoryQosPolicyKind.KEEP_LAST_HISTORY_QOS);
      publisherAttributes.getTopic().getHistoryQos().setDepth(1);
      publisherAttributes.getQos().setPublishMode(PublishModeKind.ASYNCHRONOUS_PUBLISH_MODE);

      P data = msgTypeSupplier.get();
      TopicDataType<P> topicDataType = (TopicDataType<P>) data.getPubSubTypePacket().get();

      SubscriberAttributes subscriberAttributes = domain.createSubscriberAttributes(participant, topicDataType, "pubsubtest", ReliabilityKind.RELIABLE);
      subscriberAttributes.getTopic().getHistoryQos().setDepth(1);
      subscriberAttributes.getQos().setDurabilityKind(DurabilityKind.VOLATILE_DURABILITY_QOS);
      subscriberAttributes.getTopic().getHistoryQos().setKind(HistoryQosPolicyKind.KEEP_ALL_HISTORY_QOS);

      subscriber = domain.createSubscriber(participant, subscriberAttributes, new SubscriberListenerImpl(data,callbacks));

      publisher = domain.createPublisher(participant, publisherAttributes, new PublisherListenerImpl());
   }
}
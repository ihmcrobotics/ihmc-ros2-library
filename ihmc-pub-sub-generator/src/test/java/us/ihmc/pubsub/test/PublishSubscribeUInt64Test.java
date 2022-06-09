package us.ihmc.pubsub.test;

import org.junit.jupiter.api.Test;
import us.ihmc.idl.generated.test.StatusMessage;
import us.ihmc.idl.generated.test.StatusMessagePubSubType;
import us.ihmc.pubsub.Domain;
import us.ihmc.pubsub.DomainFactory;
import us.ihmc.pubsub.DomainFactory.PubSubImplementation;
import us.ihmc.pubsub.attributes.*;
import us.ihmc.pubsub.attributes.HistoryQosPolicy.HistoryQosPolicyKind;
import us.ihmc.pubsub.common.LogLevel;
import us.ihmc.pubsub.common.MatchingInfo;
import us.ihmc.pubsub.common.SampleInfo;
import us.ihmc.pubsub.common.Time;
import us.ihmc.pubsub.participant.Participant;
import us.ihmc.pubsub.participant.ParticipantDiscoveryInfo;
import us.ihmc.pubsub.participant.ParticipantListener;
import us.ihmc.pubsub.publisher.Publisher;
import us.ihmc.pubsub.publisher.PublisherListener;
import us.ihmc.pubsub.subscriber.Subscriber;
import us.ihmc.pubsub.subscriber.SubscriberListener;

import java.io.IOException;
import java.util.Collections;

public class PublishSubscribeUInt64Test
{
   @Test// timeout = 30000
   public void testPublishSubscribeUInt32() throws IOException
   {
      Domain domain = DomainFactory.getDomain(PubSubImplementation.FAST_RTPS);

      domain.setLogLevel(LogLevel.INFO);

      ParticipantAttributes attributes = ParticipantAttributes.create()
        .domainId(215)
        .discoveryLeaseDuration(Time.Infinite)
        .name("StatusTest");

      Participant participant = domain.createParticipant(attributes, new ParticipantListenerImpl());

      StatusMessagePubSubType dataType = new StatusMessagePubSubType();
      domain.registerType(participant, dataType);

      GenericPublisherAttributes genericPublisherAttributes = GenericPublisherAttributes.builder()
                                                                   .topicDataType(dataType)
                                                                   .topicName("Status")
                                                                   .reliabilityKind(ReliabilityKind.RELIABLE)
                                                                   .partitions(Collections.singletonList("us/ihmc"))
                                                                   .durabilityKind(DurabilityKind.TRANSIENT_LOCAL_DURABILITY_QOS)
                                                                   .historyQosPolicyKind(HistoryQosPolicyKind.KEEP_LAST_HISTORY_QOS)
                                                                   .historyDepth(50)
                                                                   .publishModeKind(PublishModeKind.ASYNCHRONOUS_PUBLISH_MODE)
                                                                   .build();

      StatusMessagePubSubType dataType2 = new StatusMessagePubSubType();

      GenericSubscriberAttributes genericSubscriberAttributes = GenericSubscriberAttributes.builder()
                                                                      .topicDataType(dataType2)
                                                                      .topicName("Status")
                                                                      .reliabilityKind(ReliabilityKind.RELIABLE)
                                                                      .partitions(Collections.singletonList("us/ihmc"))
                                                                      .durabilityKind(DurabilityKind.TRANSIENT_LOCAL_DURABILITY_QOS)
                                                                      .historyQosPolicyKind(HistoryQosPolicyKind.KEEP_ALL_HISTORY_QOS)
                                                                      .build();

      Subscriber subscriber = domain.createSubscriber(participant, genericSubscriberAttributes, new SubscriberListenerImpl());

      Publisher publisher = domain.createPublisher(participant, genericPublisherAttributes, new PublisherListenerImpl());

      StatusMessage msg = new StatusMessage();
      msg.setPause(false);
      msg.setSequenceId(0);

      int i = 0;
      for (; i < 10; i++)
      {
         try
         {
            msg.setPause(i % 2 == 0);
            msg.setSequenceId(i);
            publisher.write(msg);

            System.out.println("Publishing: " + msg.toString());
            Thread.sleep(1000);
            ++i;
         }
         catch (InterruptedException e)
         {
         }
      }
   }

   private class SubscriberListenerImpl implements SubscriberListener
   {
      private final StatusMessage data = new StatusMessage();
      private final SampleInfo info = new SampleInfo();

      @Override
      public void onNewDataMessage(Subscriber subscriber)
      {
         if (subscriber.takeNextData(data, info))
         {
            System.out.println("Received: " + data.toString());
         }
      }

      @Override
      public void onSubscriptionMatched(Subscriber subscriber, MatchingInfo info)
      {
         System.out.println("New publisher matched");
         System.out.println("Status: " + info.getStatus());
         System.out.println("Guid: " + info.getGuid().toString());
      }
   }

   private class ParticipantListenerImpl implements ParticipantListener
   {
      @Override
      public void onParticipantDiscovery(Participant participant, ParticipantDiscoveryInfo info)
      {
         System.out.println("New participant discovered");
         System.out.println("Status: " + info.getStatus());
         System.out.println("Guid: " + info.getGuid().toString());
         System.out.println("Name: " + info.getName());
      }
   }

   private class PublisherListenerImpl implements PublisherListener
   {
      @Override
      public void onPublicationMatched(Publisher publisher, MatchingInfo info)
      {
         System.out.println("New subscriber matched");
         System.out.println("Status: " + info.getStatus());
         System.out.println("Guid: " + info.getGuid().toString());
      }
   }
}

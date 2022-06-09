package us.ihmc.pubsub.test;

import java.io.IOException;
import java.util.Collections;

import us.ihmc.idl.generated.chat.ChatMessage;
import us.ihmc.idl.generated.chat.ChatMessagePubSubType;
import us.ihmc.pubsub.Domain;
import us.ihmc.pubsub.DomainFactory;
import us.ihmc.pubsub.DomainFactory.PubSubImplementation;
import us.ihmc.pubsub.attributes.DurabilityKind;
import us.ihmc.pubsub.attributes.GenericSubscriberAttributes;
import us.ihmc.pubsub.attributes.HistoryQosPolicy.HistoryQosPolicyKind;
import us.ihmc.pubsub.attributes.ParticipantAttributes;
import us.ihmc.pubsub.attributes.ReliabilityKind;
import us.ihmc.pubsub.common.LogLevel;
import us.ihmc.pubsub.common.MatchingInfo;
import us.ihmc.pubsub.common.SampleInfo;
import us.ihmc.pubsub.common.Time;
import us.ihmc.pubsub.participant.Participant;
import us.ihmc.pubsub.participant.ParticipantDiscoveryInfo;
import us.ihmc.pubsub.participant.ParticipantListener;
import us.ihmc.pubsub.subscriber.Subscriber;
import us.ihmc.pubsub.subscriber.SubscriberListener;

public class CreateSubscriptionUnderLoad
{
   static int counter;
   
   public CreateSubscriptionUnderLoad() throws IOException
   {
      Domain domain = DomainFactory.getDomain(PubSubImplementation.FAST_RTPS);

      domain.setLogLevel(LogLevel.INFO);

      ParticipantAttributes attributes = ParticipantAttributes.create()
            .domainId(215).discoveryLeaseDuration(Time.Infinite).name("CreateSubscriptionProcessDuringAggressivePublishTest");

      Participant participant = domain.createParticipant(attributes, new ParticipantListenerImpl());

      ChatMessagePubSubType dataType = new ChatMessagePubSubType();
      domain.registerType(participant, dataType);

      GenericSubscriberAttributes genericSubscriberAttributes = GenericSubscriberAttributes.builder()
                                                                      .topicDataType(dataType)
                                                                      .namespace("segfault_trigger")
                                                                      .reliabilityKind(ReliabilityKind.RELIABLE)
                                                                      .partitions(Collections.singletonList("us/ihmc"))
                                                                      .historyQosPolicyKind(HistoryQosPolicyKind.KEEP_ALL_HISTORY_QOS)
                                                                      .durabilityKind(DurabilityKind.VOLATILE_DURABILITY_QOS)
                                                                      .historyDepth(1)
                                                                      .build();

      Subscriber subscriber = domain.createSubscriber(participant, genericSubscriberAttributes, new SubscriberListenerImpl());
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

   private class SubscriberListenerImpl implements SubscriberListener
   {
      private final ChatMessage data = new ChatMessage();
      private final SampleInfo info = new SampleInfo();

      @Override
      public void onNewDataMessage(Subscriber subscriber)
      {
         if (subscriber.takeNextData(data, info))
         {
            counter += data.getMsg().length(); // Make sure it doesn't get optimized out
            
            if (counter % 10000 == 0)
            System.out.println(data.getSender().toString() + ": " + data.getMsg().toString());
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

   public static void main(String[] args) throws IOException, InterruptedException
   {
      new CreateSubscriptionUnderLoad();
      Thread.currentThread().join();
   }
}

package us.ihmc.pubsub.test;

import java.io.IOException;
import java.util.Collections;

import us.ihmc.idl.generated.chat.ChatMessage;
import us.ihmc.idl.generated.chat.ChatMessagePubSubType;
import us.ihmc.pubsub.Domain;
import us.ihmc.pubsub.DomainFactory;
import us.ihmc.pubsub.DomainFactory.PubSubImplementation;
import us.ihmc.pubsub.attributes.*;
import us.ihmc.pubsub.attributes.HistoryQosPolicy.HistoryQosPolicyKind;
import us.ihmc.pubsub.common.LogLevel;
import us.ihmc.pubsub.common.MatchingInfo;
import us.ihmc.pubsub.common.Time;
import us.ihmc.pubsub.participant.Participant;
import us.ihmc.pubsub.participant.ParticipantDiscoveryInfo;
import us.ihmc.pubsub.participant.ParticipantListener;
import us.ihmc.pubsub.publisher.Publisher;
import us.ihmc.pubsub.publisher.PublisherListener;

public class AggressivePublisher
{
   public AggressivePublisher() throws IOException
   {
      Domain domain = DomainFactory.getDomain(PubSubImplementation.FAST_RTPS);

      domain.setLogLevel(LogLevel.INFO);

      GenericParticipantAttributes attributes = GenericParticipantAttributes.builder()
                                                              .domainId(215)
                                                              .discoveryLeaseDuration(Time.Infinite)
                                                              .name("AggressivePublisher")
                                                              .build();

      Participant participant = domain.createParticipant(attributes, new ParticipantListenerImpl());

      ChatMessagePubSubType dataType = new ChatMessagePubSubType();
      domain.registerType(participant, dataType);

      // Mimic ROS 2 default settings

      GenericPublisherAttributes genericPublisherAttributes = GenericPublisherAttributes.builder()
                                                                   .topicDataType(dataType)
                                                                   .topicName("segfault_trigger")
                                                                   .reliabilityKind(ReliabilityKind.RELIABLE)
                                                                   .partitions(Collections.singletonList("us/ihmc"))
                                                                   .durabilityKind(DurabilityKind.VOLATILE_DURABILITY_QOS)
                                                                   .historyQosPolicyKind(HistoryQosPolicyKind.KEEP_LAST_HISTORY_QOS)
                                                                   .historyDepth(1)
                                                                   .publishModeKind(PublishModeKind.ASYNCHRONOUS_PUBLISH_MODE)
                                                                   .build();

      Publisher publisher = domain.createPublisher(participant, genericPublisherAttributes, new PublisherListenerImpl());

      ChatMessage msg = new ChatMessage();
      msg.setSender("Java");
      String longMessage = "AReallyLongStringIGuessOkayMaybeItsNotLikeThatLongButWhateverItGetsTheJobDoneMaybe";
      msg.setMsg(longMessage);

      int i = 0;
      while (true)
      {
         msg.setSender("Hello World " + (i++));
         msg.setMsg(longMessage);
         publisher.write(msg);
         
         // Publish as fast as possible
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

   public static void main(String[] args) throws IOException
   {
      new AggressivePublisher();
   }
}

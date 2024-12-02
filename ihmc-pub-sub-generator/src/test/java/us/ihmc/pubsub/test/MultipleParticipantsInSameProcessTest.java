package us.ihmc.pubsub.test;

import com.eprosima.xmlschemas.fastrtps_profiles.DurabilityQosKindPolicyType;
import com.eprosima.xmlschemas.fastrtps_profiles.HistoryQosKindPolicyType;
import com.eprosima.xmlschemas.fastrtps_profiles.ReliabilityQosKindPolicyType;
import org.junit.jupiter.api.Test;
import us.ihmc.idl.generated.chat.ChatMessage;
import us.ihmc.idl.generated.chat.ChatMessagePubSubType;
import us.ihmc.log.LogTools;
import us.ihmc.pubsub.Domain;
import us.ihmc.pubsub.DomainFactory;
import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.attributes.ParticipantProfile;
import us.ihmc.pubsub.attributes.PublisherAttributes;
import us.ihmc.pubsub.attributes.SubscriberAttributes;
import us.ihmc.pubsub.common.MatchingInfo;
import us.ihmc.pubsub.common.Time;
import us.ihmc.pubsub.participant.Participant;
import us.ihmc.pubsub.publisher.Publisher;
import us.ihmc.pubsub.subscriber.Subscriber;
import us.ihmc.pubsub.subscriber.SubscriberListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

public class MultipleParticipantsInSameProcessTest
{
   private class SubscriberListenerImpl implements SubscriberListener
   {
      AtomicInteger counter;

      public SubscriberListenerImpl(AtomicInteger counter)
      {
         this.counter = counter;
      }

      @Override
      public void onNewDataMessage(Subscriber subscriber)
      {
         ChatMessage chatMessage = (ChatMessage) subscriber.takeNextData();
         assertEquals(Integer.parseInt(chatMessage.getMsgAsString()), this.counter.getAndIncrement());
      }

      @Override
      public void onSubscriptionMatched(Subscriber subscriber, MatchingInfo info)
      {

      }
   }

   @Test
   public void testMulitpleParticipantsInSameProcess() throws IOException, InterruptedException
   {
      AtomicInteger counter = new AtomicInteger();

      Domain domain = DomainFactory.getDomain();

      try
      {
         TopicDataType<ChatMessage> topicDataType = new ChatMessagePubSubType();

         PublisherAttributes genericPublisherAttributes = PublisherAttributes.create()
                                                                             .topicDataType(topicDataType)
                                                                             .topicName("Status")
                                                                             .reliabilityKind(ReliabilityQosKindPolicyType.RELIABLE)
                                                                             .partitions(Collections.singletonList("us/ihmc"))
                                                                             .durabilityKind(DurabilityQosKindPolicyType.TRANSIENT_LOCAL)
                                                                             .historyQosPolicyKind(HistoryQosKindPolicyType.KEEP_LAST)
                                                                             .historyDepth(10);

         SubscriberAttributes subscriberAttributes = SubscriberAttributes.create()
                                                                         .topicDataType(topicDataType)
                                                                         .topicName("Status")
                                                                         .reliabilityKind(ReliabilityQosKindPolicyType.RELIABLE)
                                                                         .partitions(Collections.singletonList("us/ihmc"))
                                                                         .durabilityKind(DurabilityQosKindPolicyType.TRANSIENT_LOCAL)
                                                                         .historyQosPolicyKind(HistoryQosKindPolicyType.KEEP_ALL);

         List<Participant> participants = new ArrayList<>();
         for (int i = 1; i <= 100; i++)
         {
            ParticipantProfile participantProfile = ParticipantProfile.create()
                                                                      .domainId(217)
                                                                      .useOnlyIntraProcessDelivery()
                                                                      .discoveryLeaseDuration(Time.Infinite)
                                                                      .name("StatusTest" + i);
            Participant participant = domain.createParticipant(participantProfile);
            participants.add(participant);
         }
         LogTools.info("Created {} participants", participants.size());

         List<Publisher> publishers = new ArrayList<>();
         for (Participant participant : participants)
            publishers.add(domain.createPublisher(participant, genericPublisherAttributes, null));
         LogTools.info("Created {} publishers", publishers.size());

         Subscriber subscriber = domain.createSubscriber(participants.get(0), subscriberAttributes, new SubscriberListenerImpl(counter));

         // Publish one message from each publisher in each participant
         Thread thread = new Thread(() ->
         {
            AtomicInteger msgCounter = new AtomicInteger();
            for (Publisher publisher : publishers)
            {
               try
               {
                  ChatMessage msg = new ChatMessage();
                  msg.setMsg(String.valueOf(msgCounter.getAndIncrement()));
                  publisher.write(msg);
                  Thread.sleep(20L); // Sleep a bit so Fast-DDS can deliver the message.
               }
               catch (IOException | InterruptedException e)
               {
                  e.printStackTrace();
               }
            }
         });
         thread.start();
         thread.join();

         assertEquals(100, counter.get());
      }
      finally
      {
         domain.stopAll();
      }
   }
}

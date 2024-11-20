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
   public void TestMulitpleParticipantsInSameProcess() throws IOException, InterruptedException
   {
      AtomicInteger counter = new AtomicInteger(0);

      Domain domain = DomainFactory.getDomain();

      try
      {
         TopicDataType topicDataType = new ChatMessagePubSubType();

         PublisherAttributes genericPublisherAttributes = PublisherAttributes.create().topicDataType(topicDataType).topicName("Status")
                                                                             .reliabilityKind(ReliabilityQosKindPolicyType.RELIABLE)
                                                                             .partitions(Collections.singletonList("us/ihmc"))
                                                                             .durabilityKind(DurabilityQosKindPolicyType.TRANSIENT_LOCAL)
                                                                             .historyQosPolicyKind(HistoryQosKindPolicyType.KEEP_LAST).historyDepth(10);

         SubscriberAttributes subscriberAttributes = SubscriberAttributes.create().topicDataType(topicDataType).topicName("Status")
                                                                         .reliabilityKind(ReliabilityQosKindPolicyType.RELIABLE)
                                                                         .partitions(Collections.singletonList("us/ihmc"))
                                                                         .durabilityKind(DurabilityQosKindPolicyType.TRANSIENT_LOCAL)
                                                                         .historyQosPolicyKind(HistoryQosKindPolicyType.KEEP_ALL);

         List<Participant> participants = new ArrayList<>();
         for (int i = 1; i <= 100; i++)
         {
            ParticipantProfile participantProfile = ParticipantProfile.create().domainId(217).discoveryLeaseDuration(Time.Infinite).name("StatusTest" + i).useOnlySharedMemoryTransport();
            participantProfile.useOnlySharedMemoryTransport();
            Participant participant = domain.createParticipant(participantProfile);
            LogTools.info("Creating participant #" + i);
            participants.add(participant);
         }

         List<Publisher> publishers = new ArrayList<>();

         for (int i = 0; i < participants.size(); i++)
         {
            publishers.add(domain.createPublisher(participants.get(i), genericPublisherAttributes, null));
            LogTools.info("Creating publisher #" + (i + 1));
         }

         Subscriber subscriber = domain.createSubscriber(participants.get(0), subscriberAttributes, new SubscriberListenerImpl(counter));

         //publish one message from each publisher in each participant
         Thread thread = new Thread(() ->
         {
            AtomicInteger msgCounter = new AtomicInteger();
            for (Publisher publisher : publishers)
            {
               try
               {
                  ChatMessage msg = new ChatMessage();
                  msg.setMsg(String.valueOf(msgCounter.get()));
                  publisher.write(msg);
                  Thread.sleep(5L); // Sleep a bit so FastDDS can deliver the message.
                  msgCounter.incrementAndGet();
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

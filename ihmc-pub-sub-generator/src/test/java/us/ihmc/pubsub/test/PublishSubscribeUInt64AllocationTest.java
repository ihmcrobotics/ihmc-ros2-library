package us.ihmc.pubsub.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.eprosima.xmlschemas.fastrtps_profiles.DurabilityQosKindType;
import com.eprosima.xmlschemas.fastrtps_profiles.HistoryQosKindType;
import com.eprosima.xmlschemas.fastrtps_profiles.PublishModeQosKindType;
import com.eprosima.xmlschemas.fastrtps_profiles.ReliabilityQosKindType;

import us.ihmc.commons.PrintTools;
import us.ihmc.commons.allocations.AllocationProfiler;
import us.ihmc.commons.allocations.AllocationRecord;
import us.ihmc.idl.generated.test.StatusMessage;
import us.ihmc.idl.generated.test.StatusMessagePubSubType;
import us.ihmc.log.LogTools;
import us.ihmc.pubsub.Domain;
import us.ihmc.pubsub.DomainFactory;
import us.ihmc.pubsub.DomainFactory.PubSubImplementation;
import us.ihmc.pubsub.attributes.ParticipantAttributes;
import us.ihmc.pubsub.attributes.PublisherAttributes;
import us.ihmc.pubsub.attributes.SubscriberAttributes;
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

public class PublishSubscribeUInt64AllocationTest
{
   public static final int NUMBER_OF_MESSAGES_TO_SEND = 30;

   @Tag("allocation")
   @Test// timeout = 30000
   public void testPublishSubscribeUInt32AllocationsFastRTPS() throws IOException
   {
      runAllocationTest(PubSubImplementation.FAST_RTPS);
   }

   @Disabled // intraprocess does not need to be allocation-free for now - @dcalvert
   @Tag("allocation")
   @Test// timeout = 30000
   public void testPublishSubscribeUInt32AllocationsIntraprocess() throws IOException
   {
      runAllocationTest(PubSubImplementation.INTRAPROCESS);
   }

   public void runAllocationTest(PubSubImplementation pubSubImplementation) throws IOException
   {
      AllocationProfiler allocationProfiler = new AllocationProfiler();

      Domain domain = DomainFactory.getDomain(pubSubImplementation);

      domain.setLogLevel(LogLevel.INFO);

      ParticipantAttributes attributes = ParticipantAttributes.create()
        .domainId(215)
        .discoveryLeaseDuration(Time.Infinite)
        .name("StatusTest");

      Participant participant = domain.createParticipant(attributes, new ParticipantListenerImpl());

      StatusMessagePubSubType dataType = new StatusMessagePubSubType();
      domain.registerType(participant, dataType);

      PublisherAttributes genericPublisherAttributes = PublisherAttributes.create()
       .topicDataType(dataType)
       .topicName("Status")
       .reliabilityKind(ReliabilityQosKindType.RELIABLE)
       .partitions(Collections.singletonList("us/ihmc"))
       .durabilityKind(pubSubImplementation == PubSubImplementation.INTRAPROCESS ?
                             DurabilityQosKindType.VOLATILE
                             : DurabilityQosKindType.TRANSIENT_LOCAL)
       .historyQosPolicyKind(HistoryQosKindType.KEEP_LAST)
       .historyDepth(50)
       .publishModeKind(PublishModeQosKindType.ASYNCHRONOUS);

      StatusMessagePubSubType dataType2 = new StatusMessagePubSubType();

      SubscriberAttributes subscriberAttributes = SubscriberAttributes.create()
       .topicDataType(dataType2)
       .topicName("Status")
       .reliabilityKind(ReliabilityQosKindType.RELIABLE)
       .partitions(Collections.singletonList("us/ihmc"))
       .durabilityKind(DurabilityQosKindType.VOLATILE)
       .historyQosPolicyKind(HistoryQosKindType.KEEP_ALL);

      SubscriberListenerImpl subscriberListener = new SubscriberListenerImpl();
      Subscriber subscriber = domain.createSubscriber(participant, subscriberAttributes, subscriberListener);

      Publisher publisher = domain.createPublisher(participant, genericPublisherAttributes, new PublisherListenerImpl());

      StatusMessage msg = new StatusMessage();
      msg.setPause(false);
      msg.setSequenceId(0);

      publishNMessages(publisher, msg, 1); // warmup

      allocationProfiler.startRecordingAllocations(); // start recording

      publishNMessages(publisher, msg, NUMBER_OF_MESSAGES_TO_SEND);

      allocationProfiler.stopRecordingAllocations();  // stop recording

      for (StatusMessage message : subscriberListener.receivedMessages)
      {
         if (message != null)
            PrintTools.info(this, "Message received: " + message.toString());
      }

      List<AllocationRecord> allocations = allocationProfiler.pollAllocations();

      String message = "";
      for (AllocationRecord allocation : allocations)
      {
         message += allocation.toString() + "\n";
      }
      System.out.println(message);

      assertTrue(allocations.size() == 0, "allocated " + allocations.size() + ": \n" + message);
   }

   private void publishNMessages(Publisher publisher, StatusMessage msg, int numberOfMessagesToSend) throws IOException
   {
      int i = 0;
      for (; i < numberOfMessagesToSend; i++)
      {
         try
         {
            msg.setPause(i % 2 == 0);
            msg.setSequenceId(i);
            publisher.write(msg);

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
      private final SampleInfo info = new SampleInfo();
      public final StatusMessage[] receivedMessages = new StatusMessage[NUMBER_OF_MESSAGES_TO_SEND];
      {
         for (int i = 0; i < NUMBER_OF_MESSAGES_TO_SEND; i++)
         {
            receivedMessages[i] = new StatusMessage();
         }
      }
      public int i = 0;

      @Override
      public void onNewDataMessage(Subscriber subscriber)
      {
         if (subscriber.takeNextData(receivedMessages[i++], info))
         {
            // do nothing, success
         }
      }

      @Override
      public void onSubscriptionMatched(Subscriber subscriber, MatchingInfo info)
      {
         LogTools.debug("New publisher matched");
         LogTools.debug("Status: " + info.getStatus());
         LogTools.debug("Guid: " + info.getGuid().toString());
      }
   }

   private class ParticipantListenerImpl implements ParticipantListener
   {
      @Override
      public void onParticipantDiscovery(Participant participant, ParticipantDiscoveryInfo info)
      {
         LogTools.debug("New participant discovered");
         LogTools.debug("Status: " + info.getStatus());
         LogTools.debug("Guid: " + info.getGuid().toString());
         LogTools.debug("Name: " + info.getName());
      }
   }

   private class PublisherListenerImpl implements PublisherListener
   {
      @Override
      public void onPublicationMatched(Publisher publisher, MatchingInfo info)
      {
         LogTools.debug("New subscriber matched");
         LogTools.debug("Status: " + info.getStatus());
         LogTools.debug("Guid: " + info.getGuid().toString());
      }
   }
}

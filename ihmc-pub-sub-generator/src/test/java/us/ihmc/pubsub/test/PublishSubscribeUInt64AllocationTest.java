package us.ihmc.pubsub.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import us.ihmc.commons.PrintTools;
import us.ihmc.commons.allocations.AllocationProfiler;
import us.ihmc.commons.allocations.AllocationRecord;
import us.ihmc.idl.generated.test.StatusMessage;
import us.ihmc.idl.generated.test.StatusMessagePubSubType;
import us.ihmc.log.LogTools;
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
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

      ParticipantAttributes attributes = domain.createParticipantAttributes();
      attributes.setDomainId(215);
      attributes.setLeaseDuration(Time.Infinite);
      attributes.setName("StatusTest");

      Participant participant = domain.createParticipant(attributes, new ParticipantListenerImpl());

      StatusMessagePubSubType dataType = new StatusMessagePubSubType();
      domain.registerType(participant, dataType);

      PublisherAttributes publisherAttributes = domain.createPublisherAttributes(participant, dataType, "Status", ReliabilityKind.RELIABLE, "us/ihmc");
      publisherAttributes.getQos().setDurabilityKind(pubSubImplementation == PubSubImplementation.INTRAPROCESS ?
                                                           DurabilityKind.VOLATILE_DURABILITY_QOS
                                                           : DurabilityKind.TRANSIENT_LOCAL_DURABILITY_QOS);
      publisherAttributes.getTopic().getHistoryQos().setKind(HistoryQosPolicyKind.KEEP_LAST_HISTORY_QOS);
      publisherAttributes.getTopic().getHistoryQos().setDepth(50);
      publisherAttributes.getQos().setPublishMode(PublishModeKind.ASYNCHRONOUS_PUBLISH_MODE);

      StatusMessagePubSubType dataType2 = new StatusMessagePubSubType();

      SubscriberAttributes subscriberAttributes = domain.createSubscriberAttributes(participant, dataType2, "Status", ReliabilityKind.RELIABLE, "us/ihmc");
      subscriberAttributes.getQos().setDurabilityKind(pubSubImplementation == PubSubImplementation.INTRAPROCESS ?
                                                            DurabilityKind.VOLATILE_DURABILITY_QOS
                                                            : DurabilityKind.VOLATILE_DURABILITY_QOS);
      subscriberAttributes.getTopic().getHistoryQos().setKind(HistoryQosPolicyKind.KEEP_ALL_HISTORY_QOS);

      SubscriberListenerImpl subscriberListener = new SubscriberListenerImpl();
      Subscriber subscriber = domain.createSubscriber(participant, subscriberAttributes, subscriberListener);

      Publisher publisher = domain.createPublisher(participant, publisherAttributes, new PublisherListenerImpl());

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

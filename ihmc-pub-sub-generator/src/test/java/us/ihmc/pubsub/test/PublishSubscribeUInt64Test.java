package us.ihmc.pubsub.test;

import com.eprosima.xmlschemas.fastrtps_profiles.DurabilityQosKindPolicyType;
import com.eprosima.xmlschemas.fastrtps_profiles.HistoryQosKindPolicyType;
import com.eprosima.xmlschemas.fastrtps_profiles.ReliabilityQosKindPolicyType;
import org.junit.jupiter.api.Test;
import us.ihmc.idl.generated.test.StatusMessage;
import us.ihmc.idl.generated.test.StatusMessagePubSubType;
import us.ihmc.pubsub.Domain;
import us.ihmc.pubsub.DomainFactory;
import us.ihmc.pubsub.attributes.ParticipantProfile;
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

import java.io.IOException;
import java.util.Collections;

public class PublishSubscribeUInt64Test
{
   @Test // timeout = 30000
   public void testPublishSubscribeUInt32() throws IOException
   {
      Domain domain = DomainFactory.getDomain();

      try
      {
         domain.setLogLevel(LogLevel.INFO);

         ParticipantProfile attributes = ParticipantProfile.create()
                                                           .domainId(219)
                                                           .discoveryLeaseDuration(Time.Infinite)
                                                           .useOnlySharedMemoryTransport()
                                                           .name("StatusTest");

         Participant participant = domain.createParticipant(attributes, new ParticipantListenerImpl());

         StatusMessagePubSubType dataType = new StatusMessagePubSubType();
         domain.registerType(participant, dataType);

         PublisherAttributes genericPublisherAttributes = PublisherAttributes.create().topicDataType(dataType).topicName("Status")
                                                                             .reliabilityKind(ReliabilityQosKindPolicyType.RELIABLE)
                                                                             .partitions(Collections.singletonList("us/ihmc"))
                                                                             .durabilityKind(DurabilityQosKindPolicyType.TRANSIENT_LOCAL)
                                                                             .historyQosPolicyKind(HistoryQosKindPolicyType.KEEP_LAST).historyDepth(50);

         StatusMessagePubSubType dataType2 = new StatusMessagePubSubType();

         SubscriberAttributes subscriberAttributes = SubscriberAttributes.create().topicDataType(dataType2).topicName("Status")
                                                                         .reliabilityKind(ReliabilityQosKindPolicyType.RELIABLE)
                                                                         .partitions(Collections.singletonList("us/ihmc"))
                                                                         .durabilityKind(DurabilityQosKindPolicyType.TRANSIENT_LOCAL)
                                                                         .historyQosPolicyKind(HistoryQosKindPolicyType.KEEP_LAST).historyDepth(50);

         Subscriber subscriber = domain.createSubscriber(participant, subscriberAttributes, new SubscriberListenerImpl());

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
      finally
      {
         domain.stopAll();
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

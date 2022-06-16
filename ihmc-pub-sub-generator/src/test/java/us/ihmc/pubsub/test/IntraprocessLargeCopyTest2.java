package us.ihmc.pubsub.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.gradle.internal.impldep.org.apache.commons.lang.mutable.MutableInt;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import com.eprosima.xmlschemas.fastrtps_profiles.DurabilityQosKindType;
import com.eprosima.xmlschemas.fastrtps_profiles.HistoryQosKindType;
import com.eprosima.xmlschemas.fastrtps_profiles.PublishModeQosKindType;
import com.eprosima.xmlschemas.fastrtps_profiles.ReliabilityQosKindType;

import us.ihmc.idl.generated.test.BigMessage;
import us.ihmc.idl.generated.test.BigMessagePubSubType;
import us.ihmc.pubsub.Domain;
import us.ihmc.pubsub.DomainFactory;
import us.ihmc.pubsub.DomainFactory.PubSubImplementation;
import us.ihmc.pubsub.attributes.DDSConversionTools;
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

/**
 *  Create a publisher and subscriber in this thread and send 20 messages with up to 100,000 longs.
 *
 *  Assert to not get any IndexOutOfBoundsExceptions and also to receive at least 9 messages.
 */
public class IntraprocessLargeCopyTest2
{
   @Test
   @Timeout(10)// timeout = 10000
   public void testRepeatedLargeCopiesInFastRTPSCallbacks() throws IOException, InterruptedException
   {
      Random random = new Random(981239012380L);

      PubSubImplementation impl = PubSubImplementation.FAST_RTPS;
      
      performCopyTest(random, impl);
   }
   
   @Test// timeout = 10000
   @Timeout(10)
   public void testRepeatedLargeCopiesInIntraprocessCallbacks() throws IOException, InterruptedException
   {
      Random random = new Random(981239012380L);

      PubSubImplementation impl = PubSubImplementation.INTRAPROCESS;
      
      performCopyTest(random, impl);
   }

   private void performCopyTest(Random random, PubSubImplementation impl) throws InterruptedException, IOException
   {
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

      PrintStream systemErr = System.err;

      System.setErr(new PrintStream(byteArrayOutputStream));

      // create one subscriber
      CountDownLatch messagesReceived = new CountDownLatch(20);
      Runnable subscriberCloser = createSubscriber(impl, messagesReceived);

      // create one publisher
      Runnable publisherCloser = createPublisherAndPublishABunch(impl, random);


      System.err.flush();

      System.setErr(systemErr);
      
      System.err.println(byteArrayOutputStream.toString());

      // capture all the output for analysis
      assertFalse(byteArrayOutputStream.toString().contains("IndexOutOfBoundsException"),
                                                   "Standard error contains java.lang.IndexOutOfBoundsException");

      // make sure to receive at least 9 of 20 messages
      assertTrue(messagesReceived.await(10, TimeUnit.SECONDS), "Timeout waiting for message receive");
      
      subscriberCloser.run();
      publisherCloser.run();
   }
   
   
   private ParticipantAttributes createParticipantAttributes(String name) throws UnknownHostException
   {
      return ParticipantAttributes.create()
            .domainId(215)
            .discoveryLeaseDuration(Time.Infinite)
            .name(name)
            .bindToAddressRestrictions(true, Arrays.asList(InetAddress.getByName("127.0.0.1")));
   }

   private Runnable createPublisherAndPublishABunch(PubSubImplementation impl, Random random) throws IOException
   {
      Domain domain = DomainFactory.getDomain(impl);

      domain.setLogLevel(LogLevel.INFO);

      ParticipantAttributes attributes = createParticipantAttributes("StatusTest");

      Participant participant = domain.createParticipant(attributes, new ParticipantListenerImpl());

      BigMessagePubSubType dataType = new BigMessagePubSubType();
      domain.registerType(participant, dataType);
      
      System.out.println(dataType.getTypeSize());

      PublisherAttributes genericPublisherAttributes = PublisherAttributes.create()
       .topicDataType(dataType)
       .topicName("Status")
       .reliabilityKind(ReliabilityQosKindType.RELIABLE)
       .partitions(Collections.singletonList("us/ihmc"))
       .durabilityKind(impl == PubSubImplementation.INTRAPROCESS ?
                             DurabilityQosKindType.VOLATILE
                             : DurabilityQosKindType.TRANSIENT_LOCAL)
       .historyQosPolicyKind(HistoryQosKindType.KEEP_LAST)
       .historyDepth(20)
       .maxBlockingTime(DDSConversionTools.createTime(100.0));

      Publisher publisher = domain.createPublisher(participant, genericPublisherAttributes, new PublisherListenerImpl());
      publishABunch(publisher, random);
      
      
      return () ->
      {
         domain.removePublisher(publisher);
         domain.removeParticipant(participant);
      };
      
      
   }

   private Runnable createSubscriber(PubSubImplementation impl, CountDownLatch messagesReceived) throws IOException
   {
      Domain domain = DomainFactory.getDomain(impl);

      domain.setLogLevel(LogLevel.INFO);

      ParticipantAttributes attributes = createParticipantAttributes("StatusTest");

      Participant participant = domain.createParticipant(attributes, new ParticipantListenerImpl());

      BigMessagePubSubType dataType = new BigMessagePubSubType();
      domain.registerType(participant, dataType);

      BigMessagePubSubType dataType2 = new BigMessagePubSubType();

      SubscriberAttributes subscriberAttributes = SubscriberAttributes.create()
       .topicDataType(dataType2)
       .topicName("Status")
       .reliabilityKind(ReliabilityQosKindType.RELIABLE)
       .partitions(Collections.singletonList("us/ihmc"))
       .durabilityKind(impl == PubSubImplementation.INTRAPROCESS ?
                             DurabilityQosKindType.VOLATILE
                             : DurabilityQosKindType.TRANSIENT_LOCAL)
       .historyQosPolicyKind(HistoryQosKindType.KEEP_ALL);

      Subscriber subscriber = domain.createSubscriber(participant, subscriberAttributes, new SubscriberListenerImpl(messagesReceived));
      
      return () ->
      {
         domain.removeSubscriber(subscriber);
         domain.removeParticipant(participant);
      };
   }

   private void publishABunch(Publisher publisher, Random random) throws IOException
   {
      for (int i = 0; i < 20; i++)
      {
         BigMessage bigMessage = new BigMessage();
         int randomSize = random.nextInt(100000); // randomly fill to the initial size declared in the .msg

         bigMessage.setId(i);
         for (int j = 0; j < randomSize; j++)
         {
            bigMessage.getLargeSequence().add().setHello(i + j);
         }
         
         publisher.write(bigMessage);
         System.out.println("write " + i);
      }
   }

   private class SubscriberListenerImpl implements SubscriberListener
   {
      private final BigMessage data = new BigMessage();
      private final SampleInfo info = new SampleInfo();
      private final CountDownLatch messagesReceived;
      int i = 0;

      public SubscriberListenerImpl(CountDownLatch messagesReceived)
      {
         this.messagesReceived = messagesReceived;
      }
      
      @Override
      public void onNewDataMessage(Subscriber subscriber)
      {
         if (subscriber.takeNextData(data, info))
         {
            try
            {
               Thread.sleep(100);
            }
            catch (InterruptedException e)
            {
               e.printStackTrace();
            }
            BigMessage copied = new BigMessage();
            copied.set(data);
            System.out.println("Received: " + i++ + " Copied id: " + copied.getId() + " size: " + copied.getLargeSequence().size());
            messagesReceived.countDown();
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

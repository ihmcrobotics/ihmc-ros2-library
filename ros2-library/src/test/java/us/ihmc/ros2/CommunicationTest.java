package us.ihmc.ros2;

import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ros_msgs.msg.dds.TwoNum;
import ros_msgs.msg.dds.TwoNumPubSubType;
import us.ihmc.commons.thread.ThreadTools;
import us.ihmc.pubsub.Domain;
import us.ihmc.pubsub.DomainFactory;
import us.ihmc.pubsub.DomainFactory.PubSubImplementation;
import us.ihmc.util.PeriodicNonRealtimeThreadScheduler;

import java.time.Duration;

public class CommunicationTest
{
   @Test// timeout = 5000
   public void testSimpleIntraProcessCommunication()
   {
      testSimpleCommunication(PubSubImplementation.INTRAPROCESS);
   }

   @Test// timeout = 5000
   public void testSimpleRealRTPSCommunicationDefaultRosVersion()
   {
      testSimpleCommunication(PubSubImplementation.FAST_RTPS);
   }

   @Test// timeout = 5000
   public void testSimpleRealRTPSCommunicationArdent()
   {
      testSimpleCommunication(PubSubImplementation.FAST_RTPS);
   }

   @Test// timeout = 5000
   public void testSimpleRealRTPSCommunicationBouncy()
   {
      testSimpleCommunication(PubSubImplementation.FAST_RTPS);
   }

   private void testSimpleCommunication(PubSubImplementation pubSubImplementation)
   {
      Assertions.assertTimeoutPreemptively(Duration.ofSeconds(5), () ->
      {
         Pair<Integer, Integer> messagesReceived = new MutablePair<>();
         try
         {
            Domain domain = DomainFactory.getDomain(pubSubImplementation);
            String name = "ROS2CommunicationTest";
            ROS2Node node = new ROS2Node(domain, name);
            TwoNumPubSubType topicDataType = new TwoNumPubSubType();
            ROS2PublisherBasics<TwoNum> publisher = node.createPublisher(topicDataType, "/chatter");

            messagesReceived.setValue(0);

            node.createSubscription(topicDataType, subscriber ->
            {
               TwoNum message = new TwoNum();
               System.out.println("Incoming message...");
               if (subscriber.takeNextData(message, null))
               {
                  System.out.println("Received: " + message.getStr1());
                  messagesReceived.setValue(messagesReceived.getValue() + 1);
               }
            }, "/chatter");

            for (int i = 0; i < 11; i++)
            {
               TwoNum message = new TwoNum();
               message.getStr1().append("Hello world: " + i);
               System.out.println("Publishing: " + message.getStr1());
               publisher.publish(message);
               System.out.println("Published: " + message.getStr1());
            }
         }
         catch (Exception e)
         {
            e.printStackTrace();
         }

         while (messagesReceived.getValue() < 5)
            Thread.yield();
      });
   }

   @Test// timeout = 5000
   public void testSimpleRealRTPSCommunicationAndDestroy()
   {
      Assertions.assertTimeoutPreemptively(Duration.ofSeconds(5), () ->
      {
         Pair<Integer, Integer> messagesReceived = new MutablePair<>();
         try
         {
            Domain domain = DomainFactory.getDomain(PubSubImplementation.FAST_RTPS);
            ROS2Node node = new ROS2Node(domain, "ROS2CommunicationTest");
            TwoNumPubSubType topicDataType = new TwoNumPubSubType();
            ROS2PublisherBasics<TwoNum> publisher = node.createPublisher(topicDataType, "/chatter");

            messagesReceived.setValue(0);

            node.createSubscription(topicDataType, subscriber ->
            {
               TwoNum message = new TwoNum();
               System.out.println("Incoming message...");
               if (subscriber.takeNextData(message, null))
               {
                  System.out.println("Received: " + message.getStr1());
                  messagesReceived.setValue(messagesReceived.getValue() + 1);
               }
            }, "/chatter");

            for (int i = 0; i < 11; i++)
            {
               TwoNum message = new TwoNum();
               message.getStr1().append("Hello world: " + i);
               System.out.println("Publishing: " + message.getStr1());
               publisher.publish(message);
               System.out.println("Published: " + message.getStr1());
            }

            ThreadTools.sleepSeconds(1.0);

            node.destroy();
         }
         catch (Exception e)
         {
            e.printStackTrace();
         }

         while (messagesReceived.getValue() < 5)
            Thread.yield();
      });
   }

   @Test// timeout = 5000
   public void testSimpleIntraProcessCommunicationRealtime()
   {
      Assertions.assertTimeoutPreemptively(Duration.ofSeconds(5), () ->
      {
         Pair<Integer, Integer> messagesReceived = new MutablePair<>();
         try
         {
            Domain domain = DomainFactory.getDomain(PubSubImplementation.INTRAPROCESS);
            RealtimeROS2Node node = new RealtimeROS2Node(domain, PeriodicNonRealtimeThreadScheduler::new, "ROS2CommunicationTest", "/us/ihmc");
            TwoNumPubSubType topicDataType = new TwoNumPubSubType();
            ROS2PublisherBasics<TwoNum> publisher = node.createPublisher(topicDataType, "/chatter");

            messagesReceived.setValue(0);

            QueuedROS2Subscription<TwoNum> subscription = node.createQueuedSubscription(topicDataType, "/chatter");

            node.spin();

            for (int i = 0; i < 11; i++)
            {
               TwoNum message = new TwoNum();
               message.getStr1().append("Hello world: " + i);
               System.out.println("Publishing: " + message.getStr1());
               boolean success = publisher.publish(message);
               System.out.println("Published: success: " + success + " content: " + message.getStr1());
            }

            TwoNum incomingMessage = new TwoNum();
            while (!subscription.poll(incomingMessage))
               ;
            System.out.println("Received: " + incomingMessage.getStr1());
            messagesReceived.setValue(messagesReceived.getValue() + 1);

            while (messagesReceived.getValue() < 10)
            {
               boolean pollSuccess = subscription.poll(incomingMessage);
               if (pollSuccess)
               {
                  System.out.println("Received: " + incomingMessage.getStr1());
                  messagesReceived.setValue(messagesReceived.getValue() + 1);
               }
               else
               {
                  System.out.println("No messages in queue.");
               }
            }
         }
         catch (Exception e)
         {
            e.printStackTrace();
         }
      });
   }
}

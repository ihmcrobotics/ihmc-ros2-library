package us.ihmc.ros2;

import org.gradle.internal.impldep.org.junit.Assume;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assumptions.*;
import std_msgs.msg.dds.ByteMultiArray;
import us.ihmc.commons.thread.ThreadTools;
import us.ihmc.ros2.ROS2NodeBuilder.SpecialTransportMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

public class ROS2SubscriptionTest
{
   private static final Random RANDOM = new Random(349473937);
   private static final ByteMultiArray BIG_MESSAGE = generateBigMessage(100);

   @Test
   public void testRaceCondition() throws InterruptedException
   {
      final int subscriberCount = 2;
      final int messagesToPublish = 10000;
      final int expectedMessageCount = subscriberCount * messagesToPublish;

      ROS2Topic<ByteMultiArray> topic = new ROS2Topic<>().withType(ByteMultiArray.class).withSuffix("test_topic").withQoS(ROS2QosProfile.RELIABLE());
      ROS2NodeBuilder nodeBuilder = new ROS2NodeBuilder().specialTransportMode(SpecialTransportMode.UDPV4_ONLY).useSharedMemory(false);

      // Build publisher node and publisher
      ROS2Node publisherNode = nodeBuilder.build("publisher_node");
      ROS2Publisher<ByteMultiArray> publisher = publisherNode.createPublisher(topic);
      AtomicInteger totalPublishedMessages = new AtomicInteger();

      // Build subscribers and message listener
      List<ROS2Node> subscriberNodes = new ArrayList<>();
      Map<ROS2Node, ROS2Subscription<ByteMultiArray>> subscriptions = new HashMap<>();
      AtomicInteger totalReceivedMessages = new AtomicInteger();
      for (int i = 0; i < subscriberCount; i++)
         subscriberNodes.add(nodeBuilder.build("subscriber_node_" + i)); // TODO: ROS2NodeBuilder bug? Doesn't update the name when it prints
      Set<String> subscribersThatGotData = new HashSet<>();
      for (ROS2Node subscriberNode : subscriberNodes)
      {
         subscriptions.put(subscriberNode, subscriberNode.createSubscription(topic, subscriber ->
         {
            totalReceivedMessages.incrementAndGet();
            subscribersThatGotData.add(subscriber.getGuid().toString());
         }));
      }

      Thread publisherThread = new Thread(() ->
      {
         for (int i = 0; i < messagesToPublish; i++)
         {
            publisher.publish(BIG_MESSAGE);
            totalPublishedMessages.incrementAndGet();
            ThreadTools.sleep(1);
         }
      });

//      Thread stopThread = new Thread(() ->
//      {
//         while (totalPublishedMessages.get() <= messagesToPublish)
//         {
//            ThreadTools.sleep(1);
//            subscriptions.forEach((ros2Node, subscription) -> subscription.remove());
//         }
//      });

      publisherThread.start();
      publisherThread.join();

      // Check that all the subscribers got data
      assertEquals(subscriberCount, subscribersThatGotData.size());
      // Check that all the messages were received by all the subscribers
      assertEquals(expectedMessageCount, totalReceivedMessages.get());

      // Destroy subscriptions and subscriber nodes
      subscriptions.forEach((subscriberNode, subscription) -> subscription.remove());
      for (ROS2Node subscriberNode : subscriberNodes)
         subscriberNode.destroy();

      // Destroy publisher and publisher node
      publisher.remove();
      publisherNode.destroy();
   }

   @RepeatedTest(500)
   public void testPublishSubscribe()
   {
      int messagesToPublish = 10;

      AtomicInteger receivedData = new AtomicInteger(0);

      ROS2Topic<ByteMultiArray> topic = new ROS2Topic<>().withType(ByteMultiArray.class).withSuffix("test_topic");//.withQoS(ROS2QosProfile.RELIABLE());
      ROS2NodeBuilder builder = new ROS2NodeBuilder().specialTransportMode(SpecialTransportMode.UDPV4_ONLY);
      ROS2Node publisherNode = builder.build("publisher_node");
      ROS2Node subscriberNode = builder.build("subscriber_node");

      ROS2Publisher<ByteMultiArray> publisher = publisherNode.createPublisher(topic);
      ROS2Subscription<ByteMultiArray> subscription = subscriberNode.createSubscription(topic, subscriber ->
      {
         synchronized (receivedData)
         {
            if (receivedData.incrementAndGet() == messagesToPublish)
               receivedData.notify();
         }
      });

      for (int i = 0; i < messagesToPublish; ++i)
      {
         publisher.publish(BIG_MESSAGE);
      }

      synchronized (receivedData)
      {
         if (receivedData.get() != messagesToPublish)
         {
            try
            {
               receivedData.wait(5000);
            }
            catch (InterruptedException interruptedException)
            {
               throw new RuntimeException(interruptedException);
            }
         }
      }

      assertEquals(messagesToPublish, receivedData.get());

      publisher.remove();
      subscription.remove();
      publisherNode.destroy();
      subscriberNode.destroy();
   }

   @Test
   public void testRemoveDeadlock()
   {
      ROS2Topic<ByteMultiArray> topic = new ROS2Topic<>().withType(ByteMultiArray.class).withSuffix("test_topic").withQoS(ROS2QosProfile.BEST_EFFORT());
      ROS2NodeBuilder builder = new ROS2NodeBuilder().specialTransportMode(SpecialTransportMode.UDPV4_ONLY);
      ROS2Node publisherNode = builder.build("publisher_node");
      ROS2Node subscriberNode = builder.build("subscriber_node");

      ROS2Publisher<ByteMultiArray> publisher = publisherNode.createPublisher(topic);

      Thread removeThread = ThreadTools.startAThread(() ->
      {
         int threadCount = 1000;
         List<Thread> threads = new ArrayList<>();
         for (int i = 0; i < threadCount; ++i)
         {
            threads.add(ThreadTools.startAThread(() ->
            {
               ThreadTools.park(RANDOM.nextDouble(0.1));

               ROS2Subscription<ByteMultiArray> subscription = subscriberNode.createSubscription(topic, subscriber ->
               {
                  ByteMultiArray data = subscriber.takeNextData();
                  System.out.println(data);
               });

               ThreadTools.park(RANDOM.nextDouble(0.1));

               System.out.println("Removing " + Thread.currentThread().getName());
               subscription.remove();
               System.out.println("Removed " + Thread.currentThread().getName());
            }, "thread_" + i));
         }

         for (int i = 0; i < threadCount; ++i)
         {
            System.out.println("Joining " + i);
            try
            {
               threads.get(i).join();
            }
            catch (InterruptedException e)
            {
               throw new RuntimeException(e);
            }
         }
      }, "remove_thread");

      Thread publishThread = ThreadTools.startAThread(() ->
      {
         while (removeThread.isAlive())
         {
            ThreadTools.park(RANDOM.nextDouble(0.1));
            publisher.publish(BIG_MESSAGE);
         }
      }, "publishThread");

      try
      {
         removeThread.join();
         publishThread.join();
      }
      catch (InterruptedException interruptedException)
      {
         throw new RuntimeException(interruptedException);
      }

      publisher.remove();
      publisherNode.destroy();
      subscriberNode.destroy();
   }

   private static ByteMultiArray generateBigMessage(int size)
   {
      byte[] randomBytes = new byte[size];
      RANDOM.nextBytes(randomBytes);
      ByteMultiArray msg = new ByteMultiArray();
      msg.getData().add(randomBytes);
      return msg;
   }
}

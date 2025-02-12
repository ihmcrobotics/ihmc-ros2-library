package us.ihmc.ros2;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Timeout;
import std_msgs.msg.dds.ByteMultiArray;
import us.ihmc.commons.thread.ThreadTools;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

public class ROS2SubscriptionTest
{
   private static final Random RANDOM = new Random(349473937);
   private static final ByteMultiArray BIG_MESSAGE = generateBigMessage(100);

   @RepeatedTest(500)
   public void testPublishSubscribe()
   {
      int messagesToPublish = 10;

      AtomicInteger receivedData = new AtomicInteger(0);

      ROS2Topic<ByteMultiArray> topic = new ROS2Topic<>().withType(ByteMultiArray.class).withSuffix("test_topic");
      ROS2NodeBuilder builder = new ROS2NodeBuilder();
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

   @RepeatedTest(10)
   @Timeout(15)
   public void testRemoveDeadlock()
   {
      ROS2Topic<ByteMultiArray> topic = new ROS2Topic<>().withType(ByteMultiArray.class).withSuffix("test_topic");
      ROS2NodeBuilder builder = new ROS2NodeBuilder();
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
               });

               ThreadTools.park(RANDOM.nextDouble(0.1));

               subscription.remove();
               subscription.remove(); // Call remove() multiple times for better test coverage
            }, "thread_" + i));
         }

         for (int i = 0; i < threadCount; ++i)
         {
            try
            {
               threads.get(i).join();
            }
            catch (InterruptedException e)
            {
               throw new RuntimeException(e);
            }
         }
      }, "removeThread");

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

package us.ihmc.ros2;

import org.junit.jupiter.api.RepeatedTest;
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
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

public class ROS2SubscriptionTest
{
   private static final Random RANDOM = new Random(349473937);
   private static final ByteMultiArray BIG_MESSAGE = generateBigMessage(100);

   @RepeatedTest(50)
   public void testRaceCondition() throws InterruptedException
   {
      final int subscriberCount = 2;
      final int messagesToPublish = 100;

      ROS2Topic<ByteMultiArray> topic = new ROS2Topic<>().withType(ByteMultiArray.class).withSuffix("test_topic").withQoS(ROS2QosProfile.RELIABLE());
      ROS2NodeBuilder nodeBuilder = new ROS2NodeBuilder().specialTransportMode(SpecialTransportMode.UDPV4_ONLY).useSharedMemory(false);

      // Build publisher node and publisher
      ROS2Node publisherNode = nodeBuilder.build("publisher_node");
      ROS2Publisher<ByteMultiArray> publisher = publisherNode.createPublisher(topic);

      // Build subscribers and message listener
      List<ROS2Node> subscriberNodes = new ArrayList<>();
      Map<ROS2Node, ROS2Subscription<ByteMultiArray>> subscriptions = new HashMap<>();
      AtomicInteger totalReceivedMessages = new AtomicInteger();
      for (int i = 0; i < subscriberCount; i++)
         subscriberNodes.add(nodeBuilder.build("subscriber_node_" + i)); // TODO: ROS2NodeBuilder bug? Doesn't update the name when it prints
      Set<String> subscribersThatGotData = new HashSet<>();
      NewMessageListener<ByteMultiArray> messageListener = subscriber ->
      {
         totalReceivedMessages.incrementAndGet();
         subscribersThatGotData.add(subscriber.getGuid().toString());
      };
      for (ROS2Node subscriberNode : subscriberNodes)
         subscriptions.put(subscriberNode, subscriberNode.createSubscription(topic, messageListener));

      Thread publisherThread = new Thread(() ->
      {
         for (int i = 0; i < messagesToPublish; i++)
         {
            publisher.publish(BIG_MESSAGE);
         }
      });

      publisherThread.start();
      publisherThread.join();

      // Wait some time for the subscriber callback to run
      // The messages have to go over the network interface, etc
      ThreadTools.park(0.1);

      // Check that all the subscribers got data
      assertEquals(subscriberCount, subscribersThatGotData.size());
      // Check that all the messages were received by all the subscribers
      int expectedMessageCount = subscriberCount * messagesToPublish;
      assertEquals(expectedMessageCount, totalReceivedMessages.get());

      // Destroy subscriptions and subscriber nodes
      subscriptions.forEach((subscriberNode, subscription) -> subscription.remove());
      for (ROS2Node subscriberNode : subscriberNodes)
         subscriberNode.destroy();

      // Destroy publisher and publisher node
      publisher.remove();
      publisherNode.destroy();
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

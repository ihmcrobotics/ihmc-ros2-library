package us.ihmc.ros2;

import org.junit.jupiter.api.RepeatedTest;
import std_msgs.msg.dds.ByteMultiArray;
import us.ihmc.commons.thread.ThreadTools;
import us.ihmc.ros2.ROS2NodeBuilder.SpecialTransportMode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

public class ROS2SubscriptionTest
{
   private static final Random RANDOM = new Random(100);

   @RepeatedTest(50)
   public void testRaceCondition() throws InterruptedException
   {
      final int subscriberCount = 3;
      final int messagesToPublish = 100;
      final int messageSizeBytes = 100; // TODO: make larger

      ROS2Topic<ByteMultiArray> topic = new ROS2Topic<>().withType(ByteMultiArray.class).withSuffix("test_topic").withQoS(ROS2QosProfile.RELIABLE());
      ROS2NodeBuilder nodeBuilder = new ROS2NodeBuilder().specialTransportMode(SpecialTransportMode.UDPV4_ONLY).useSharedMemory(false);

      // Build publisher node and publisher
      ROS2Node publisherNode = nodeBuilder.build("publisher_node");
      ROS2Publisher<ByteMultiArray> publisher = publisherNode.createPublisher(topic);

      // Build subscribers and message listener
      List<ROS2Node> subscriberNodes = new ArrayList<>();
      AtomicInteger totalReceivedMessages = new AtomicInteger();
      for (int i = 0; i < subscriberCount; i++)
         subscriberNodes.add(nodeBuilder.build("subscriber_node_" + i)); // TODO: ROS2NodeBuilder bug? Doesn't update the name when it prints
      NewMessageListener<ByteMultiArray> messageListener = subscriber -> totalReceivedMessages.incrementAndGet();
      for (ROS2Node subscriberNode : subscriberNodes)
         subscriberNode.createSubscription(topic, messageListener);

      Thread publisherThread = new Thread(() ->
      {
         for (int i = 0; i < messagesToPublish; i++)
         {
            ByteMultiArray msg = generateBigMessage(messageSizeBytes);
            publisher.publish(msg);
         }
      });

      publisherThread.start();
      publisherThread.join();

      // Wait some time for the subscriber callback to run
      // The messages have to go over the network interface, etc
      ThreadTools.park(1.0);

      int expectedMessageCount = subscriberCount * messagesToPublish;
      assertEquals(expectedMessageCount, totalReceivedMessages.get());

      for (ROS2Node subscriberNode : subscriberNodes)
         subscriberNode.destroy();
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

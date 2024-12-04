/*
 * Copyright 2017 Florida Institute for Human and Machine Cognition (IHMC)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package us.ihmc.ros2.example.realtime;

import org.apache.commons.lang3.SystemUtils;
import std_msgs.msg.dds.Int64;
import std_msgs.msg.dds.Int64PubSubType;
import us.ihmc.log.LogTools;
import us.ihmc.ros2.QueuedROS2Subscription;
import us.ihmc.ros2.ROS2NodeBuilder;
import us.ihmc.ros2.ROS2Publisher;
import us.ihmc.ros2.ROS2QosProfile;
import us.ihmc.ros2.RealtimeROS2Node;
import us.ihmc.util.PeriodicNonRealtimeThreadSchedulerFactory;
import us.ihmc.util.PeriodicRealtimeThreadSchedulerFactory;
import us.ihmc.util.PeriodicThreadSchedulerFactory;

/**
 * Java version of the ROS2 demo listener.
 *
 * To test, start a ROS2 talker using
 *
 * ros2 run demo_nodes_cpp talker -- -t chatter
 *
 * @author Jesper Smith
 */
public class RealtimeROS2PublishSubscribeExample
{
   private ROS2Publisher<Int64> publisher;
   private QueuedROS2Subscription<Int64> subscription;

   public RealtimeROS2PublishSubscribeExample()
   {
      RealtimeROS2Node node;
      try
      {
         node = setupNode(SystemUtils.IS_OS_LINUX);
         node.spin(); // start the realtime node thread
      }
      catch (RuntimeException e)
      {
         LogTools.error(e.getMessage());
         LogTools.warn("Using non-realtime.");

         node = setupNode(false);
         node.spin(); // start the realtime node thread
      }

      Int64 message = new Int64();
      for (int i = 0; i < 10; i++)
      {
         message.setData(i);
         publisher.publish(message);
         System.out.println("Sending: " + message);
      }

      Int64 incomingMessage = new Int64();
      while (!subscription.poll(incomingMessage))
         ; // just waiting for the first message
      System.out.println("Receiving: " + incomingMessage); // first message
      int i = 1;
      while (i < 10)
      {
         if (subscription.poll(incomingMessage))
         {
            System.out.println("Receiving: " + incomingMessage);
            i++;
         }
         else
         {
            // no available messages
         }
      }
      System.out.println("Received all messages!");
      
      node.destroy();
   }

   /**
    * Realtime threads only work on Linux.
    * See https://github.com/ihmcrobotics/ihmc-realtime to setup realtime threads.
    */
   private RealtimeROS2Node setupNode(boolean useRealtimeThread)
   {
      PeriodicThreadSchedulerFactory threadFactory = useRealtimeThread ?
            new PeriodicRealtimeThreadSchedulerFactory(20) :
            new PeriodicNonRealtimeThreadSchedulerFactory();

      RealtimeROS2Node node = new ROS2NodeBuilder().buildRealtime("RealtimeROS2PublishSubscribeExample", threadFactory);
      publisher = node.createPublisher(new Int64PubSubType(), "/example", ROS2QosProfile.KEEP_HISTORY(3), 10);
      subscription = node.createQueuedSubscription(new Int64PubSubType(), "/example", ROS2QosProfile.KEEP_HISTORY(3), 10);

      return node;
   }

   public static void main(String[] args)
   {
      new RealtimeROS2PublishSubscribeExample();
   }
}

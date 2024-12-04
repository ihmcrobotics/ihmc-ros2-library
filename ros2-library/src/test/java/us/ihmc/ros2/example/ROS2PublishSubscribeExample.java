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
package us.ihmc.ros2.example;

import std_msgs.msg.dds.Int64;
import us.ihmc.ros2.ROS2Node;
import us.ihmc.ros2.ROS2NodeBuilder;
import us.ihmc.ros2.ROS2Publisher;
import us.ihmc.ros2.ROS2Topic;

import java.io.IOException;

/**
 * Java ROS 2 simple publisher and subscriber example
 *
 * @author Jesper Smith
 */
public class ROS2PublishSubscribeExample
{
   public static void main(String[] args) throws IOException, InterruptedException
   {
      ROS2Node node = new ROS2NodeBuilder().build("publish_subscribe_example");
      ROS2Topic<Int64> topic = new ROS2Topic<>().withType(Int64.class).withSuffix("example");
      node.createSubscription2(topic, message -> System.out.println("Received data: " + message.getData()));

      ROS2Publisher<Int64> publisher = node.createPublisher(topic);
      Int64 message = new Int64();
      for (int i = 0; i < 10; i++)
      {
         message.setData(i);
         publisher.publish(message);
         Thread.sleep(1000);
      }

      Thread.currentThread().join(); // keep thread alive to receive more messages
   }
}

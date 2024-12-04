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

import us.ihmc.ros2.ROS2Node;
import us.ihmc.ros2.ROS2NodeBuilder;
import us.ihmc.ros2.ROS2Publisher;

import java.io.IOException;

/**
 * Java version of the ROS2 demo listener.
 *
 * To test, start a ROS2 talker using
 *
 *    ROS_DOMAIN_ID=112 ros2 topic echo /chatter
 *
 * @author Jesper Smith
 *
 */
public class ROS2TalkerExample
{
   public static void main(String[] args) throws IOException, InterruptedException
   {
      ROS2Node node = new ROS2NodeBuilder().domainId(112)
                                           .namespace("/us/ihmc")
                                           .build("talker_example");
      ROS2Publisher<std_msgs.msg.dds.String> publisher = node.createPublisher(new std_msgs.msg.dds.StringPubSubType(), "/chatter");
      std_msgs.msg.dds.String message = new std_msgs.msg.dds.String();
      for (int i = 0; i < 1000000000; i++)
      {
         message.setData("Hello " + i);
         System.out.println("Publishing: " + message.getData());
         publisher.publish(message);
         Thread.sleep(1000);
      }

      Thread.currentThread().join(); // keep thread alive to receive more messages
   }
}

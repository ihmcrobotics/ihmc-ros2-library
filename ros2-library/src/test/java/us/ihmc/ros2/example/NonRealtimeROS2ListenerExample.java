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

import us.ihmc.pubsub.DomainFactory;
import us.ihmc.pubsub.DomainFactory.PubSubImplementation;
import us.ihmc.ros2.ROS2Node;

import java.io.IOException;

/**
 * Java version of the ROS2 demo listener.
 * 
 * To test, start a ROS2 talker using 
 * 
 *    ros2 run demo_nodes_cpp talker -- -t chatter
 * 
 * @author Jesper Smith
 *
 */
public class NonRealtimeROS2ListenerExample
{
   public static void main(String[] args) throws IOException, InterruptedException
   {
      ROS2Node node = new ROS2Node(DomainFactory.getDomain(PubSubImplementation.FAST_RTPS), "NonRealtimeROS2ChatterExample", "/us/ihmc", 112);
      node.createSubscription(new std_msgs.msg.dds.StringPubSubType(), subscriber -> {
         std_msgs.msg.dds.String message = new std_msgs.msg.dds.String();
         if (subscriber.takeNextData(message, null))
         {
            System.out.println(message.getData());
         }
      }, "/chatter");

      Thread.currentThread().join(); // keep thread alive to receive more messages
   }
}

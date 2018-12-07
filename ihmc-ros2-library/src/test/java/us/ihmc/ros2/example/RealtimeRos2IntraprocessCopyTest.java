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

import org.apache.commons.lang3.SystemUtils;
import org.junit.jupiter.api.Test;
import ros_msgs.msg.dds.BigNumSequence;
import ros_msgs.msg.dds.BigNumSequencePubSubType;
import ros_msgs.msg.dds.Num;
import us.ihmc.pubsub.DomainFactory.PubSubImplementation;
import us.ihmc.ros2.RealtimeRos2Node;
import us.ihmc.ros2.RealtimeRos2Publisher;
import us.ihmc.ros2.RealtimeRos2Subscription;
import us.ihmc.util.PeriodicNonRealtimeThreadSchedulerFactory;
import us.ihmc.util.PeriodicRealtimeThreadSchedulerFactory;
import us.ihmc.util.PeriodicThreadSchedulerFactory;

import java.io.IOException;
import java.util.Random;

/**
 *  This test is mostly incomplete and doesn't test much
 *  other than regression and integration.
 *
 *  The IntraprocessCopy tests in pub-sub do the real testing that
 *  this was supposed to do.
 *
 * @author Duncan Calvert
 */
public class RealtimeRos2IntraprocessCopyTest
{
   public static final int NUMBER_OF_MESSAGES_TO_SEND = 20;

   @Test// timeout = 300000
   public void testIntraprocessCopy() throws IOException, InterruptedException
   {
      Random random = new Random(892141240123L);

      PeriodicThreadSchedulerFactory threadFactory = SystemUtils.IS_OS_LINUX ? // realtime threads only work on linux
            new PeriodicRealtimeThreadSchedulerFactory(20) :           // see https://github.com/ihmcrobotics/ihmc-realtime
            new PeriodicNonRealtimeThreadSchedulerFactory();                   // to setup realtime threads
      RealtimeRos2Node node = new RealtimeRos2Node(PubSubImplementation.INTRAPROCESS, threadFactory, "RealtimeRos2IntraprocessCopyTest", "/us/ihmc");
      RealtimeRos2Publisher<BigNumSequence> publisher = node.createPublisher(new BigNumSequencePubSubType(), "/example");
      RealtimeRos2Subscription<BigNumSequence> subscription = node.createQueuedSubscription(new BigNumSequencePubSubType(), "/example");

      node.spin(); // start the realtime node thread

      for (int i = 0; i < NUMBER_OF_MESSAGES_TO_SEND; i++)
      {
         BigNumSequence message = new BigNumSequence();
         Num e = new Num();
         int randomSize = random.nextInt(10000);
         for (int j = 0; j < randomSize; j++)
         {
            e.setDoubleTest(i + j);
            message.getLargeSequence().add().set(e);
         }
         publisher.publish(message);
         System.out.println("Sending: " +  i + " sendSize: " + message.getLargeSequence().size());
      }

      BigNumSequence incomingMessage = new BigNumSequence();
      while (!subscription.poll(incomingMessage))
         ; // just waiting for the first message
      int i = 1;
      while (i < 10)
      {
         if (subscription.poll(incomingMessage))
         {
            System.out.println("Receiving: " + i + " copiedSize: " + incomingMessage.getLargeSequence().size());
            i++;
         }
         else
         {
            // no available messages
         }
      }
   }
}

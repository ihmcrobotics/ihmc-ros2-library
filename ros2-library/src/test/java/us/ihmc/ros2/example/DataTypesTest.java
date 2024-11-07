package us.ihmc.ros2.example;

import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;
import ros_msgs.msg.dds.Num;
import ros_msgs.msg.dds.NumPubSubType;
import us.ihmc.pubsub.DomainFactory;
import us.ihmc.pubsub.DomainFactory.PubSubImplementation;
import us.ihmc.pubsub.common.SampleInfo;
import us.ihmc.ros2.ROS2Node;
import us.ihmc.ros2.ROS2PublisherBasics;

import static us.ihmc.robotics.Assert.*;

public class DataTypesTest
{
   @Test// timeout = 30000
   public void testAllDoubleValuesGetAcross()
   {
      Pair<Integer, Integer> messagesReceived = new MutablePair<>();

      int NUMBER_OF_MESSAGES_TO_SEND = 10;
      try
      {
         ROS2Node node = new ROS2Node(DomainFactory.getDomain(PubSubImplementation.INTRAPROCESS), "ROS2CommunicationTest");
         NumPubSubType topicDataType = new NumPubSubType();
         ROS2PublisherBasics<Num> publisher = node.createPublisher(topicDataType, "/chatter");

         messagesReceived.setValue(0);

         node.createSubscription(topicDataType, subscriber -> {
            Num message = new Num();
            System.out.println("Incoming message...");
            if (subscriber.takeNextData(message, new SampleInfo()))
            {
               switch (messagesReceived.getValue())
               {
               case 0:
                  assertEquals("Wasn't NaN", Double.NaN, message.getDoubleTest(), 0.0);
                  break;
               case 1:
                  assertEquals("Wasn't MAX_VALUE", Double.MAX_VALUE, message.getDoubleTest(), 0.0);
                  break;
               case 2:
                  assertEquals("Wasn't MIN_VALUE", Double.MIN_VALUE, message.getDoubleTest(), 0.0);
                  break;
               case 3:
                  assertEquals("Wasn't MAX_EXPONENT", Double.MAX_EXPONENT, message.getDoubleTest(), 0.0);
                  break;
               case 4:
                  assertEquals("Wasn't MIN_EXPONENT", Double.MIN_EXPONENT, message.getDoubleTest(), 0.0);
                  break;
               case 5:
                  assertEquals("Wasn't MIN_NORMAL", Double.MIN_NORMAL, message.getDoubleTest(), 0.0);
                  break;
               case 6:
                  assertEquals("Wasn't POSITIVE_INFINITY", Double.POSITIVE_INFINITY, message.getDoubleTest(), 0.0);
                  break;
               case 7:
                  assertEquals("Wasn't NEGATIVE_INFINITY", Double.NEGATIVE_INFINITY, message.getDoubleTest(), 0.0);
                  break;
               default:
                  break;
               }
               System.out.println("Received: " + message.getDoubleTest());

               messagesReceived.setValue(messagesReceived.getValue() + 1);
            }
         }, "/chatter");

         for (int i = 0; i < NUMBER_OF_MESSAGES_TO_SEND; i++)
         {
            Num message = new Num();
            switch (i)
            {
            case 0:
               message.setDoubleTest(Double.NaN);
               break;
            case 1:
               message.setDoubleTest(Double.MAX_VALUE);
               break;
            case 2:
               message.setDoubleTest(Double.MIN_VALUE);
               break;
            case 3:
               message.setDoubleTest(Double.MAX_EXPONENT);
               break;
            case 4:
               message.setDoubleTest(Double.MIN_EXPONENT);
               break;
            case 5:
               message.setDoubleTest(Double.MIN_NORMAL);
               break;
            case 6:
               message.setDoubleTest(Double.POSITIVE_INFINITY);
               break;
            case 7:
               message.setDoubleTest(Double.NEGATIVE_INFINITY);
               break;
            default:
               break;
            }
            System.out.println("Publishing: " + message.getDoubleTest());
            publisher.publish(message);
            System.out.println("Published: " + message.getDoubleTest());
         }
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }

      while (messagesReceived.getValue() < NUMBER_OF_MESSAGES_TO_SEND)
         Thread.yield();

      assertEquals("all messages not received", NUMBER_OF_MESSAGES_TO_SEND, (int) messagesReceived.getValue());
   }
}

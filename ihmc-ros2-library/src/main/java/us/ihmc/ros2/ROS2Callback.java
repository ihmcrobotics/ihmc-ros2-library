package us.ihmc.ros2;

import us.ihmc.log.LogTools;
import us.ihmc.pubsub.subscriber.Subscriber;

import java.util.function.Consumer;

/**
 * Callback listener to non-null reception of a message on a ROS 2 topic.
 *
 * @param <T> messageType
 * @deprecated Use {@link ROS2NodeInterface#createSubscription} instead
 */
public class ROS2Callback<T>
{
   private final Consumer<T> messageCallback;
   private final ROS2Subscription<T> subscription;

   public ROS2Callback(ROS2NodeInterface ros2Node, ROS2Topic<T> topic, Consumer<T> messageCallback)
   {
      this(ros2Node, topic.getType(), topic.getName(), topic.getQoS(), messageCallback);
   }

   public ROS2Callback(ROS2NodeInterface ros2Node, Class<T> messageType, ROS2Topic<?> topic, Consumer<T> messageCallback)
   {
      this(ros2Node, messageType, topic.withTypeName(messageType).toString(), topic.getQoS(), messageCallback);
   }

   public ROS2Callback(ROS2NodeInterface ros2Node, Class<T> messageType, String topicName, ROS2QosProfile qosProfile, Consumer<T> messageCallback)
   {
      this.messageCallback = messageCallback;

      subscription = ros2Node.createSubscription(ROS2TopicNameTools.newMessageTopicDataTypeInstance(messageType),
                                                 this::nullOmissionCallback,
                                                 topicName,
                                                 qosProfile);
   }

   private void nullOmissionCallback(Subscriber<T> subscriber)
   {
      T incomingData = subscriber.takeNextData();
      if (incomingData != null)
      {
         messageCallback.accept(incomingData);
      }
      else
      {
         LogTools.warn("Received null from takeNextData()");
      }
   }

   public void destroy()
   {
      if (subscription != null)
      {
         subscription.remove();
      }
   }
}

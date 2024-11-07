package us.ihmc.ros2;

import us.ihmc.pubsub.Domain;
import us.ihmc.pubsub.subscriber.Subscriber;

/**
 * A ROS 2 compatible subscription
 * @param <T> the data type
 */
public class ROS2Subscription<T>
{
   private final Domain domain;
   private final Subscriber<T> subscriber;

   ROS2Subscription(Domain domain, Subscriber<T> subscriber)
   {
      this.domain = domain;
      this.subscriber = subscriber;
   }

   public void remove()
   {
      domain.removeSubscriber(subscriber);
   }
}

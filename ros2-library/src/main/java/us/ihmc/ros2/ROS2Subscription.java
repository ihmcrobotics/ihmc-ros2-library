package us.ihmc.ros2;

import us.ihmc.pubsub.Domain;
import us.ihmc.pubsub.subscriber.Subscriber;

/**
 * A ROS 2 compatible subscription
 * // TODO: Rename to ROS2Subscriber
 *
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

   // TODO: ROS2Subscription should extend FastRTPSSubscriber
   public Subscriber<T> getSubscriber()
   {
      return subscriber;
   }

   // TODO: Remove domain from ROS2Subscription
   public Domain getDomain()
   {
      return domain;
   }
}

package us.ihmc.ros2;

import us.ihmc.pubsub.common.MatchingInfo;
import us.ihmc.pubsub.subscriber.Subscriber;
import us.ihmc.pubsub.subscriber.SubscriberListener;

@FunctionalInterface
public interface NewMessageListener<T> extends SubscriberListener<T>
{
   /**
    * Virtual function to be implemented by the user containing the actions to be performed when a new data message is received.
    *
    * @param subscriber
    */
   void onNewDataMessage(Subscriber<T> subscriber);

   default void onSubscriptionMatched(Subscriber<T> subscriber, MatchingInfo info)
   {
      // do nothing
   }
}

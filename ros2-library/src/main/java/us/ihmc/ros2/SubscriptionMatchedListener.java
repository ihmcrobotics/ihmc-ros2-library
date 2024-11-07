package us.ihmc.ros2;

import us.ihmc.pubsub.common.MatchingInfo;
import us.ihmc.pubsub.subscriber.Subscriber;

@FunctionalInterface
public interface SubscriptionMatchedListener<T>
{
   /**
    * Virtual method to be called when the subscriber is matched with a new Writer (or unmatched);
    * i.e., when a writer publishing in the same topic is discovered
    */
   void onSubscriptionMatched(Subscriber<T> subscriber, MatchingInfo info);
}

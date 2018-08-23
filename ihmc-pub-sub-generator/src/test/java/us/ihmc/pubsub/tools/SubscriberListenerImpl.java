package us.ihmc.pubsub.tools;

import us.ihmc.pubsub.common.MatchingInfo;
import us.ihmc.pubsub.common.SampleInfo;
import us.ihmc.pubsub.subscriber.Subscriber;
import us.ihmc.pubsub.subscriber.SubscriberListener;

import java.util.ArrayList;

public class SubscriberListenerImpl<T> implements SubscriberListener
{
   private final T data;
   private final SampleInfo info = new SampleInfo();
   private ArrayList<MessageCallback<T>> callbacks;

   public SubscriberListenerImpl(T data, ArrayList<MessageCallback<T>> callbacks)
   {
      this.data = data;
      this.callbacks = callbacks;
   }

   @Override
   public void onNewDataMessage(Subscriber subscriber)
   {
      if (subscriber.takeNextData(data, info))
      {
         for (MessageCallback<T> callback : callbacks)
            callback.callback(data, info);
      }
   }

   @Override
   public void onSubscriptionMatched(Subscriber subscriber, MatchingInfo info)
   {
      System.out.println("New publisher matched");
      System.out.println("Status: " + info.getStatus());
      System.out.println("Guid: " + info.getGuid().toString());
   }
}

package us.ihmc.pubsub.stats;

import us.ihmc.pubsub.subscriber.Subscriber;

public class SubscriberStats
{
   private final Subscriber subscriber;
   private long numberOfReceivedMessages = 0;

   public SubscriberStats(Subscriber subscriber)
   {
      this.subscriber = subscriber;
   }

   public void recordMessageReceived()
   {
      ++numberOfReceivedMessages;
   }

   public Subscriber getSubscriber()
   {
      return subscriber;
   }

   public long getNumberOfReceivedMessages()
   {
      return numberOfReceivedMessages;
   }
}

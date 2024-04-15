package us.ihmc.pubsub.stats;

import us.ihmc.pubsub.subscriber.Subscriber;

public class SubscriberStats extends CommonStats
{
   private final Subscriber<?> subscriber;

   public SubscriberStats(Subscriber<?> subscriber)
   {
      this.subscriber = subscriber;
   }

   public void recordMessageReceived()
   {
      recordEvent();
   }

   public void recordPayloadSize(int payloadSize)
   {
      registerPayload(subscriber.getAttributes(), payloadSize);
   }

   public Subscriber<?> getSubscriber()
   {
      return subscriber;
   }

   public long getNumberOfReceivedMessages()
   {
      return getNumberOfEvents();
   }

   public double getReceiveFrequency()
   {
      return getEventFrequency();
   }
}

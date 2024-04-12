package us.ihmc.pubsub.stats;

import us.ihmc.pubsub.subscriber.Subscriber;

public class SubscriberStats
{
   private final Subscriber<?> subscriber;
   private long numberOfReceivedMessages = 0;
   private long largestMessageSize = 0;
   private long currentMessageSize = 0;
   private long numberOfReceivedBytes = 0;
   private final PubSubRateCalculator receiveFrequency = new PubSubRateCalculator();
   private final PubSubRateCalculator bandwidthCalculator = new PubSubRateCalculator();

   public SubscriberStats(Subscriber<?> subscriber)
   {
      this.subscriber = subscriber;
   }

   public void recordMessageReceived()
   {
      ++numberOfReceivedMessages;
   }

   public void recordPayloadSize(int payloadSize)
   {
      currentMessageSize = payloadSize;

      if (payloadSize > largestMessageSize)
      {
         if (payloadSize > PublisherStats.HIGH_PAYLOAD_LIMIT)
            PubSubStatsTools.printLargePayloadWarning(subscriber.getAttributes(), payloadSize);

         largestMessageSize = payloadSize;
      }

      numberOfReceivedBytes += payloadSize;
   }

   public Subscriber<?> getSubscriber()
   {
      return subscriber;
   }

   public long getNumberOfReceivedMessages()
   {
      return numberOfReceivedMessages;
   }

   public long getLargestMessageSize()
   {
      return largestMessageSize;
   }

   public long getCurrentMessageSize()
   {
      return currentMessageSize;
   }

   public double getReceiveFrequency()
   {
      return receiveFrequency.finiteDifference(numberOfReceivedMessages);
   }

   public double getBandwidth()
   {
      return bandwidthCalculator.finiteDifference(numberOfReceivedBytes);
   }
}

package us.ihmc.pubsub.stats;

import us.ihmc.pubsub.publisher.Publisher;

public class PublisherStats
{
   /**
    * We have observed issues when messages are larger than this.
    */
   public static final int HIGH_PAYLOAD_LIMIT = 250000;

   private final Publisher publisher;
   private long numberOfPublishedMessages = 0;
   private long largestMessageSize = 0;
   private long currentMessageSize = 0;
   private long numberOfPublishedBytes = 0;
   private final PubSubRateCalculator publishFrequencyCalculator = new PubSubRateCalculator();
   private final PubSubRateCalculator bandwidthCalculator = new PubSubRateCalculator();
   private double publishFrequency = 0.0;
   private double bandwidth = 0.0;

   public PublisherStats(Publisher publisher)
   {
      this.publisher = publisher;
   }

   public void recordPublication(int payloadSize)
   {
      currentMessageSize = payloadSize;

      if (payloadSize > largestMessageSize)
      {
         if (payloadSize > HIGH_PAYLOAD_LIMIT)
            PubSubStatsTools.printLargePayloadWarning(publisher.getAttributes(), payloadSize);

         largestMessageSize = payloadSize;
      }

      ++numberOfPublishedMessages;
      numberOfPublishedBytes += payloadSize;
   }

   /** This should be called at a periodic rate. */
   public void update()
   {
      publishFrequency = publishFrequencyCalculator.finiteDifference(numberOfPublishedMessages);
      bandwidth = bandwidthCalculator.finiteDifference(numberOfPublishedBytes);
   }

   public Publisher getPublisher()
   {
      return publisher;
   }

   public long getNumberOfPublishedMessages()
   {
      return numberOfPublishedMessages;
   }

   public long getLargestMessageSize()
   {
      return largestMessageSize;
   }

   public long getCurrentMessageSize()
   {
      return currentMessageSize;
   }

   public double getPublishFrequency()
   {
      return publishFrequency;
   }

   public double getBandwidth()
   {
      return bandwidth;
   }
}

package us.ihmc.pubsub.stats;

import us.ihmc.log.LogTools;
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
   private long latestMessageSize = 0;
   private long numberOfPublishedBytes = 0;
   private final PubSubRateCalculator publishFrequency = new PubSubRateCalculator();
   private final PubSubRateCalculator bandwidthCalculator = new PubSubRateCalculator();

   public PublisherStats(Publisher publisher)
   {
      this.publisher = publisher;
   }

   public void recordPublication(int payloadSize)
   {
      latestMessageSize = payloadSize;

      if (payloadSize > largestMessageSize)
      {
         if (payloadSize > HIGH_PAYLOAD_LIMIT)
            LogTools.warn("Message payload is high for topic: %s Type: %s Size: %.2f kB"
                                .formatted(publisher.getAttributes().getHumanReadableTopicName(),
                                           publisher.getAttributes().getHumanReadableTopicDataTypeName(),
                                           payloadSize / 1000.0));
         largestMessageSize = payloadSize;
      }

      ++numberOfPublishedMessages;
      numberOfPublishedBytes += payloadSize;
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

   public long getLatestMessageSize()
   {
      return latestMessageSize;
   }

   public double getPublishFrequency()
   {
      return publishFrequency.finiteDifference(numberOfPublishedMessages);
   }

   public double getBandwidth()
   {
      return bandwidthCalculator.finiteDifference(numberOfPublishedBytes);
   }
}

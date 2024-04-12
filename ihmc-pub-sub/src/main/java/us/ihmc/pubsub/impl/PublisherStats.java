package us.ihmc.pubsub.impl;

import us.ihmc.pubsub.publisher.Publisher;

public class PublisherStats
{
   private final Publisher publisher;
   private long numberOfPublishedMessages = 0;
   private long largestMessageSize = 0;
   private long latestMessageSize = 0;

   public PublisherStats(Publisher publisher)
   {
      this.publisher = publisher;
   }

   public void recordPublication(int payloadSize)
   {
      latestMessageSize = payloadSize;

      if (payloadSize > largestMessageSize)
         largestMessageSize = payloadSize;

      ++numberOfPublishedMessages;
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
}

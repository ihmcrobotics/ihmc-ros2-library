package us.ihmc.pubsub.stats;

import us.ihmc.pubsub.publisher.Publisher;

public class PublisherStats extends CommonStats
{
   private final Publisher publisher;

   public PublisherStats(Publisher publisher)
   {
      this.publisher = publisher;
   }

   public void recordPublication(int payloadSize)
   {
      recordEvent();
      registerPayload(publisher.getAttributes(), payloadSize);
   }

   public Publisher getPublisher()
   {
      return publisher;
   }

   public long getNumberOfPublishedMessages()
   {
      return getNumberOfEvents();
   }

   public double getPublishFrequency()
   {
      return getEventFrequency();
   }
}

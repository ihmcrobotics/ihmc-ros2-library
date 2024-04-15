package us.ihmc.pubsub.stats;

import us.ihmc.pubsub.participant.Participant;
import us.ihmc.pubsub.publisher.Publisher;

public class PublisherStats extends CommonStats
{
   private final Publisher publisher;

   public PublisherStats(Participant participant, Publisher publisher)
   {
      super(participant);

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

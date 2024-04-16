package us.ihmc.pubsub.stats;

import us.ihmc.pubsub.participant.Participant;
import us.ihmc.pubsub.publisher.Publisher;
import us.ihmc.pubsub.subscriber.Subscriber;

import java.util.TreeSet;

public class ParticipantStats
{
   private final Participant participant;
   private final TreeSet<Publisher> publishers = new TreeSet<>(PubSubStats.PUBS_BY_TOPIC_NAME);
   private final TreeSet<Subscriber<?>> subscribers = new TreeSet<>(PubSubStats.SUBS_BY_TOPIC_NAME);

   public ParticipantStats(Participant participant)
   {
      this.participant = participant;
   }

   public Participant getParticipant()
   {
      return participant;
   }

   public void registerPublisher(Publisher publisher)
   {
      publishers.add(publisher);
   }

   public void registerSubscriber(Subscriber<?> subscriber)
   {
      subscribers.add(subscriber);
   }

   public TreeSet<Publisher> getPublishers()
   {
      return publishers;
   }

   public TreeSet<Subscriber<?>> getSubscribers()
   {
      return subscribers;
   }
}

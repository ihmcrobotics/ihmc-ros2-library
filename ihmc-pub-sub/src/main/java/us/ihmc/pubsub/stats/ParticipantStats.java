package us.ihmc.pubsub.stats;

import us.ihmc.pubsub.participant.Participant;
import us.ihmc.pubsub.publisher.Publisher;
import us.ihmc.pubsub.subscriber.Subscriber;

import java.util.Comparator;
import java.util.TreeSet;

public class ParticipantStats
{
   private final Participant participant;
   private final TreeSet<Publisher> publishers = new TreeSet<>(Comparator.comparing(o -> o.getAttributes().getHumanReadableTopicName()));
   private final TreeSet<Subscriber<?>> subscribers = new TreeSet<>(Comparator.comparing(o -> o.getAttributes().getHumanReadableTopicName()));

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

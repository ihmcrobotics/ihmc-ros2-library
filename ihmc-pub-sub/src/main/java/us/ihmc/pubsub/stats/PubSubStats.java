package us.ihmc.pubsub.stats;

import us.ihmc.pubsub.participant.Participant;
import us.ihmc.pubsub.publisher.Publisher;
import us.ihmc.pubsub.subscriber.Subscriber;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

public class PubSubStats
{
   public static final Comparator<Publisher> PUBS_BY_TOPIC_NAME = Comparator.<Publisher, String>comparing(o -> o.getAttributes().getHumanReadableTopicName())
                                                                            .thenComparing(Object::hashCode);
   public static final Comparator<Subscriber<?>> SUBS_BY_TOPIC_NAME = Comparator.<Subscriber<?>, String>comparing(o -> o.getAttributes().getHumanReadableTopicName())
                                                                            .thenComparing(Object::hashCode);

   public static volatile long NUMBER_OF_PUBLISHED_MESSAGES = 0;
   public static volatile long NUMBER_OF_MATCHED_SUBSCRIPTIONS = 0;
   public static volatile long NUMBER_OF_RECEIVED_MESSAGES = 0;
   public static volatile long LARGEST_MESSAGE_SIZE = 0;

   public static final HashMap<Participant, ParticipantStats> PARTICIPANT_STATS = new HashMap<>();
   public static final HashMap<Publisher, PublisherStats> PUBLISHER_STATS = new HashMap<>();
   public static final HashMap<Subscriber<?>, SubscriberStats> SUBSCRIBER_STATS = new HashMap<>();
   public static final HashSet<Subscriber<?>> matchedSubscriberBuffer = new HashSet<>();

   public static void registerParticipant(Participant participant)
   {
      PARTICIPANT_STATS.put(participant, new ParticipantStats(participant));
   }

   public static void registerPublisher(Participant participant, Publisher publisher)
   {
      PARTICIPANT_STATS.get(participant).registerPublisher(publisher);
      PUBLISHER_STATS.put(publisher, new PublisherStats(participant, publisher));
   }

   public static void registerSubscriber(Participant participant, Subscriber<?> subscriber)
   {
      PARTICIPANT_STATS.get(participant).registerSubscriber(subscriber);

      SubscriberStats subscriberStats = new SubscriberStats(participant, subscriber);

      if (matchedSubscriberBuffer.remove(subscriber))
         subscriberStats.recordMatched();

      SUBSCRIBER_STATS.put(subscriber, subscriberStats);
   }

   public static void recordMatchedSubscription(Subscriber<?> subscriber)
   {
      ++NUMBER_OF_MATCHED_SUBSCRIPTIONS;

      SubscriberStats subscriberStats = SUBSCRIBER_STATS.get(subscriber);

      // Sometimes the subscription will match before registerSubscriber is called
      if (subscriberStats != null)
         subscriberStats.recordMatched();
      else
         matchedSubscriberBuffer.add(subscriber);
   }

   public static void recordPublication(Publisher publisher, int payloadLength)
   {
      ++NUMBER_OF_PUBLISHED_MESSAGES;

      PUBLISHER_STATS.get(publisher).recordPublication(payloadLength);

      if (payloadLength > LARGEST_MESSAGE_SIZE)
         LARGEST_MESSAGE_SIZE = payloadLength;
   }

   public static void recordMessageReceived(Subscriber<?> subscriber)
   {
      ++NUMBER_OF_RECEIVED_MESSAGES;

      SUBSCRIBER_STATS.get(subscriber).recordMessageReceived();
   }

   public static void recordMessageConsumed(Subscriber<?> subscriber, int payloadLength)
   {
      SUBSCRIBER_STATS.get(subscriber).recordPayloadSize(payloadLength);
   }

   public static void markParticipantRemoved(Participant participant)
   {
      PARTICIPANT_STATS.get(participant).markRemoved();
   }

   public static void markPublisherRemoved(Publisher publisher)
   {
      PUBLISHER_STATS.get(publisher).markRemoved();
   }

   public static void markSubscriberRemoved(Subscriber<?> subscriber)
   {
      SUBSCRIBER_STATS.get(subscriber).markRemoved();
   }
}

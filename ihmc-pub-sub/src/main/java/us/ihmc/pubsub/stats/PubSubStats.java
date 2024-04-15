package us.ihmc.pubsub.stats;

import us.ihmc.pubsub.participant.Participant;
import us.ihmc.pubsub.publisher.Publisher;
import us.ihmc.pubsub.subscriber.Subscriber;

import java.util.Comparator;
import java.util.TreeMap;

public class PubSubStats
{
   public static volatile long NUMBER_OF_PUBLISHED_MESSAGES = 0;
   public static volatile long NUMBER_OF_MATCHED_SUBSCRIPTIONS = 0;
   public static volatile long NUMBER_OF_RECEIVED_MESSAGES = 0;
   public static volatile long LARGEST_MESSAGE_SIZE = 0;

   public static final TreeMap<Participant, ParticipantStats> PARTICIPANT_STATS = new TreeMap<>(Comparator.comparing(o -> o.getAttributes().getName()));
   public static final TreeMap<Publisher, PublisherStats> PUBLISHER_STATS = new TreeMap<>(Comparator.comparing(o -> o.getAttributes().getHumanReadableTopicName()));
   public static final TreeMap<Subscriber<?>, SubscriberStats> SUBSCRIBER_STATS = new TreeMap<>(Comparator.comparing(o -> o.getAttributes().getHumanReadableTopicName()));

   public static void registerParticipant(Participant participant)
   {
      PARTICIPANT_STATS.put(participant, new ParticipantStats(participant));
   }

   public static void registerPublisher(Participant participant, Publisher publisher)
   {
      PubSubStats.PARTICIPANT_STATS.get(participant).registerPublisher(publisher);
      PubSubStats.PUBLISHER_STATS.put(publisher, new PublisherStats(publisher));
   }

   public static void registerSubscriber(Participant participant, Subscriber<?> subscriber)
   {
      PubSubStats.PARTICIPANT_STATS.get(participant).registerSubscriber(subscriber);
      PubSubStats.SUBSCRIBER_STATS.put(subscriber, new SubscriberStats(subscriber));
   }

   public static void recordMatchedSubscription()
   {
      ++PubSubStats.NUMBER_OF_MATCHED_SUBSCRIPTIONS;
   }

   public static void recordPublication(Publisher publisher, int payloadLength)
   {
      ++NUMBER_OF_PUBLISHED_MESSAGES;

      PUBLISHER_STATS.get(publisher).recordPublication(payloadLength);

      if (payloadLength > PubSubStats.LARGEST_MESSAGE_SIZE)
         PubSubStats.LARGEST_MESSAGE_SIZE = payloadLength;
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
}

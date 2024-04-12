package us.ihmc.pubsub.stats;

import us.ihmc.pubsub.publisher.Publisher;
import us.ihmc.pubsub.subscriber.Subscriber;

import java.util.HashMap;

public class PubSubStats
{
   public static volatile long NUMBER_OF_PARTICIPANTS_CREATED = 0;
   public static volatile long NUMBER_OF_PUBLISHED_MESSAGES = 0;
   public static volatile long NUMBER_OF_MATCHED_SUBSCRIPTIONS = 0;
   public static volatile long NUMBER_OF_RECEIVED_MESSAGES = 0;
   public static volatile long LARGEST_MESSAGE_SIZE = 0;

   public static final HashMap<Publisher, PublisherStats> PUBLISHER_STATS = new HashMap<>();
   public static final HashMap<Subscriber, SubscriberStats> SUBSCRIBER_STATS = new HashMap<>();
}

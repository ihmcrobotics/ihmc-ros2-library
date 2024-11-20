package us.ihmc.ros2;

import us.ihmc.log.LogTools;
import us.ihmc.pubsub.Domain;
import us.ihmc.pubsub.DomainFactory;
import us.ihmc.pubsub.DomainFactory.PubSubImplementation;
import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.attributes.ParticipantProfile;
import us.ihmc.pubsub.attributes.PublisherAttributes;
import us.ihmc.pubsub.attributes.SubscriberAttributes;
import us.ihmc.pubsub.common.MatchingInfo;
import us.ihmc.pubsub.common.Time;
import us.ihmc.pubsub.participant.Participant;
import us.ihmc.pubsub.publisher.Publisher;
import us.ihmc.pubsub.subscriber.Subscriber;

import java.io.IOException;
import java.net.InetAddress;
import java.util.function.Consumer;

/**
 * An implementation of a ROS2 compatible node. This node can be used to create ROS2
 * compatible publishers and subscribers.
 *
 * @author Jesper Smith
 * @author Duncan Calvert
 */
public class ROS2Node
{
   static int DEFAULT_QUEUE_SIZE = 10;

   public static final String DEFAULT_NAMESPACE = "/us/ihmc";

   private Domain domain;
   private Participant participant;

   private final String nodeName;
   private final String namespace;

   /**
    * Create a ROS2Node
    * @param domain                 DDS domain to use. Use DomainFactory.getDomain(implementation)
    * @param name                   Name of the ROS 2 node
    * @param namespace              Namespace of the ROS 2 node
    * @param attributes             ParticipantAttributes for the domain
    */
   public ROS2Node(Domain domain, String name, String namespace, ParticipantProfile attributes)
   {
      this.domain = domain;

      ROS2TopicNameTools.checkNodename(name);
      ROS2TopicNameTools.checkNamespace(namespace);

      this.nodeName = name;
      this.namespace = namespace;

      attributes.name(name);
      try
      {
         participant = domain.createParticipant(attributes);
      }
      catch (IOException ioException)
      {
         throw new RuntimeException(ioException);
      }
   }

   /**
    * Create a ROS2Node with the default namespace
    * @param pubSubImplementation  The implementation to use.
    * @param name                   Name of the ROS 2 node
    */
   public ROS2Node(PubSubImplementation pubSubImplementation, String name)
   {
      this(DomainFactory.getDomain(pubSubImplementation), name);
   }

   /**
    * Create a ROS2Node with the default namespace
    * @param pubSubImplementation   The implementation to use.
    * @param name                   Name of the ROS 2 node
    * @param domainId               Desired ROS domain ID
    * @param addressRestriction     Restrict network traffic to the given addresses. When provided, it
    *                               should describe one of the addresses of the computer hosting this node.
    *                               Optional.
    */
   public ROS2Node(PubSubImplementation pubSubImplementation, String name, int domainId, InetAddress... addressRestriction)
   {
      this(DomainFactory.getDomain(pubSubImplementation), name, DEFAULT_NAMESPACE, domainId, addressRestriction);
   }

   /**
    * Create a ROS2Node with the default namespace
    * @param domain                 DDS domain to use. Use DomainFactory.getDomain(implementation)
    * @param name                   Name of the ROS 2 node
    */
   public ROS2Node(Domain domain, String name)
   {
      this(domain, name, "", domainFromEnvironment(), useSHMFromEnvironment());
   }

   /**
    * Create a ROS2Node
    * @param domain                 DDS domain to use. Use DomainFactory.getDomain(implementation)
    * @param name                   Name of the ROS 2 node
    * @param namespace              Namespace of the ROS 2 node
    * @param domainId               Desired ROS domain ID
    * @param addressRestriction     Restrict network traffic to the given addresses. When provided, it
    *                               should describe one of the addresses of the computer hosting this node.
    *                               Optional.
    */
   public ROS2Node(Domain domain, String name, String namespace, int domainId, InetAddress... addressRestriction)
   {
      this(domain, name, namespace, domainId, useSHMFromEnvironment(), addressRestriction);
   }

   /**
    * Create a ROS2Node
    * @param domain                 DDS domain to use. Use DomainFactory.getDomain(implementation)
    * @param name                   Name of the ROS 2 node
    * @param namespace              Namespace of the ROS 2 node
    * @param domainId               Desired ROS domain ID
    * @param useSharedMemory    Enable shared memory transport if true
    * @param addressRestriction     Restrict network traffic to the given addresses. When provided, it
    *                               should describe one of the addresses of the computer hosting this node.
    *                               Optional.
    */
   public ROS2Node(Domain domain, String name, String namespace, int domainId, boolean useSharedMemory, InetAddress... addressRestriction)
   {
      this(domain, name, namespace, createParticipantAttributes(domainId, useSharedMemory, addressRestriction));
   }

   /**
    * Create a new ROS 2 compatible publisher in this Node
    *
    * @param topicDataType       The topic data type of the message
    * @param publisherAttributes Publisher attributes created with @see{createPublisherAttributes}
    * @return a ROS 2 publisher
    */
   public <T> ROS2Publisher<T> createPublisher(TopicDataType<T> topicDataType, PublisherAttributes publisherAttributes)
   {
      TopicDataType<?> registeredType = domain.getRegisteredType(participant, topicDataType.getName());
      if (registeredType == null)
      {
         domain.registerType(participant, topicDataType);
      }

      Publisher publisher;
      try
      {
         publisher = domain.createPublisher(participant, publisherAttributes);
      }
      catch (IOException ioException)
      {
         throw new RuntimeException(ioException);
      }

      return new ROS2Publisher<>(domain, publisher);
   }

   /**
    * Create a new ROS 2 compatible publisher in this node.
    *
    * @param topic topic
    * @return a ROS 2 publisher
    */
   public <T> ROS2Publisher<T> createPublisher(ROS2Topic<T> topic)
   {
      return createPublisher(topic.getType(), topic.getName(), topic.getQoS());
   }

   /**
    * Create a new ROS 2 compatible publisher in this node.
    * This call makes a publisher with the default settings.
    *
    * @param topicDataType The topic data type of the message
    * @param topicName     Name for the topic
    * @return a ROS 2 publisher
    */
   public <T> ROS2Publisher<T> createPublisher(TopicDataType<T> topicDataType, String topicName)
   {
      return createPublisher(topicDataType, topicName, ROS2QosProfile.DEFAULT());
   }

   /**
    * Create a new ROS 2 compatible publisher in this node.
    *
    * @param messageType   The type of the message
    * @param topicName     Name for the topic
    * @return a ROS 2 publisher
    */
   public <T> ROS2Publisher<T> createPublisher(Class<T> messageType, String topicName)
   {
      return createPublisher(messageType, topicName, ROS2QosProfile.DEFAULT());
   }

   /**
    * Create a new ROS 2 compatible publisher in this node.
    *
    * @param messageType   The type of the message
    * @param topicName     Name for the topic
    * @param qosProfile    ROS 2 qos profile
    * @return a ROS 2 publisher
    */
   public <T> ROS2Publisher<T> createPublisher(Class<T> messageType, String topicName, ROS2QosProfile qosProfile)
   {
      TopicDataType<T> topicDataType = ROS2TopicNameTools.newMessageTopicDataTypeInstance(messageType);
      return createPublisher(topicDataType, createPublisherAttributes(topicDataType, topicName, qosProfile));
   }

   /**
    * Create a new ROS 2 compatible publisher in this node.
    *
    * @param topicDataType The topic data type of the message
    * @param topicName     Name for the topic
    * @param qosProfile    ROS 2 qos profile
    * @return a ROS 2 publisher
    */
   public <T> ROS2Publisher<T> createPublisher(TopicDataType<T> topicDataType, String topicName, ROS2QosProfile qosProfile)
   {
      return createPublisher(topicDataType, createPublisherAttributes(topicDataType, topicName, qosProfile));
   }

   public <T> PublisherAttributes createPublisherAttributes(TopicDataType<T> topicDataType, String topicName, ROS2QosProfile qosProfile)
   {

      PublisherAttributes publisherAttributes = PublisherAttributes.create()
                                                                   .topicDataType(topicDataType)
                                                                   .reliabilityKind(qosProfile.getReliabilityKind())
                                                                   .heartBeatPeriod(new Time(0, (long) (0.1 * 1e9))) // Approximately 100ms
                                                                   .durabilityKind(qosProfile.getDurabilityKind())
                                                                   .historyDepth(qosProfile.getHistoryDepth())
                                                                   .historyQosPolicyKind(qosProfile.getHistoryKind());

      ROS2TopicNameTools.assignNameAndPartitionsToAttributes(publisherAttributes, namespace, nodeName, topicName, qosProfile.isAvoidRosNamespaceConventions());
      return publisherAttributes;
   }

   /**
    * Create a new realtime subscription. Incoming messages are stored in a queue of depth queueSize
    * and can be polled by the realtime thread. The queueSize should weigh memory requirements of the
    * message vs the chance to lose incoming messages because the queue is full.
    *
    * @param topicDataType        Data type to subscribe to
    * @param subscriberAttributes Attributes for this topic, created
    *                             using @see{createSubscriberAttributes}
    * @param queueSize            Depth of the subscription queue (10 would be a good size for small
    *                             messages)
    * @return a realtime-safe ROS 2 subscriber
    */
   public <T> QueuedROS2Subscription<T> createQueuedSubscription(TopicDataType<T> topicDataType, SubscriberAttributes subscriberAttributes, int queueSize)
   {
      RealtimeROS2SubscriptionListener<T> listener = new RealtimeROS2SubscriptionListener<>(topicDataType, queueSize);
      ROS2Subscription<T> subscriber = createSubscription(topicDataType, listener, subscriberAttributes);
      return new QueuedROS2Subscription<T>(subscriber, listener);
   }

   /**
    * Create a new realtime subscription with default qos profile and queue depth. Incoming messages
    * are stored in a queue of depth queueSize and can be polled by the realtime thread. This function
    * will allocate a queue of depth 10.
    *
    * @param topicDataType Data type to subscribe to
    * @param topicName     Topic name
    * @return A realtime-safe ROS 2 subscriber
    */
   public <T> QueuedROS2Subscription<T> createQueuedSubscription(TopicDataType<T> topicDataType, String topicName)
   {
      return createQueuedSubscription(topicDataType, topicName, ROS2QosProfile.DEFAULT(), DEFAULT_QUEUE_SIZE);
   }

   /**
    * Create a new realtime subscription. Incoming messages are stored in a queue of depth queueSize
    * and can be polled by the realtime thread. The queueSize should weigh memory requirements of the
    * message vs the chance to lose incoming messages because the queue is full.
    *
    * @param topic topic
    * @return a realtime-safe ROS 2 subscriber
    */
   public <T> QueuedROS2Subscription<T> createQueuedSubscription(ROS2Topic<T> topic)
   {
      return createQueuedSubscription(topic, DEFAULT_QUEUE_SIZE);
   }

   /**
    * Create a new realtime subscription. Incoming messages are stored in a queue of depth queueSize
    * and can be polled by the realtime thread. The queueSize should weigh memory requirements of the
    * message vs the chance to lose incoming messages because the queue is full.
    *
    * @param topic topic
    * @param queueSize     Depth of the subscription queue (10 would be a good size for small messages)
    * @return a realtime-safe ROS 2 subscriber
    */
   public <T> QueuedROS2Subscription<T> createQueuedSubscription(ROS2Topic<T> topic, int queueSize)
   {
      return createQueuedSubscription(topic.getType(), topic.getName(), topic.getQoS(), queueSize);
   }

   /**
    * Create a new realtime subscription. Incoming messages are stored in a queue of depth queueSize
    * and can be polled by the realtime thread. The queueSize should weigh memory requirements of the
    * message vs the chance to lose incoming messages because the queue is full.
    *
    * @param messageType   The type of the message
    * @param topicName     Topic name
    * @param qosProfile    Desired ros qos profile
    * @param queueSize     Depth of the subscription queue (10 would be a good size for small messages)
    * @return a realtime-safe ROS 2 subscriber
    */
   public <T> QueuedROS2Subscription<T> createQueuedSubscription(Class<T> messageType, String topicName, ROS2QosProfile qosProfile, int queueSize)
   {
      TopicDataType<T> topicDataType = ROS2TopicNameTools.newMessageTopicDataTypeInstance(messageType);
      return createQueuedSubscription(topicDataType, createSubscriberAttributes(topicName, topicDataType, qosProfile), queueSize);
   }

   /**
    * Create a new realtime subscription. Incoming messages are stored in a queue of depth queueSize
    * and can be polled by the realtime thread. The queueSize should weigh memory requirements of the
    * message vs the chance to lose incoming messages because the queue is full.
    *
    * @param topicDataType Data type to subscribe to
    * @param topicName     Topic name
    * @param qosProfile    Desired ros qos profile
    * @param queueSize     Depth of the subscription queue (10 would be a good size for small messages)
    * @return a realtime-safe ROS 2 subscriber
    */
   public <T> QueuedROS2Subscription<T> createQueuedSubscription(TopicDataType<T> topicDataType, String topicName, ROS2QosProfile qosProfile, int queueSize)
   {
      return createQueuedSubscription(topicDataType, createSubscriberAttributes(topicName, topicDataType, qosProfile), queueSize);
   }

   /**
    * Create subscriber attributes for a topic
    *
    * @param topicName     Topic Name
    * @param <T>           Data type of the topic
    * @param topicDataType Data type serializer of the topic
    * @param qosProfile    Initial ROS 2 qos profile
    * @return PublisherAttributes for createPublisher
    */
   public <T> SubscriberAttributes createSubscriberAttributes(String topicName, TopicDataType<T> topicDataType, ROS2QosProfile qosProfile)
   {
      SubscriberAttributes subscriberAttributes = SubscriberAttributes.create()
                                                                      .topicDataType(topicDataType)
                                                                      .topicName(topicName)
                                                                      .reliabilityKind(qosProfile.getReliabilityKind())
                                                                      .durabilityKind(qosProfile.getDurabilityKind())
                                                                      .historyDepth(qosProfile.getHistoryDepth())
                                                                      .historyQosPolicyKind(qosProfile.getHistoryKind());

      ROS2TopicNameTools.assignNameAndPartitionsToAttributes(subscriberAttributes, namespace, nodeName, topicName, qosProfile.isAvoidRosNamespaceConventions());

      return subscriberAttributes;
   }

   /**
    * Create a new ROS 2 compatible subscription.
    *
    * @param topicDataType        The topic data type of the message
    * @param subscriberListener   Listener for new messages
    * @param subscriberAttributes Attributes for this topic, created
    *                             using @see{createSubscriberAttributes}
    */
   public <T> ROS2Subscription<T> createSubscription(TopicDataType<T> topicDataType,
                                                     NewMessageListener<T> subscriberListener,
                                                     SubscriberAttributes subscriberAttributes)
   {
      TopicDataType<?> registeredType = domain.getRegisteredType(participant, topicDataType.getName());
      if (registeredType == null)
      {
         domain.registerType(participant, topicDataType);
      }

      Subscriber<T> subscriber;
      try
      {
         subscriber = domain.createSubscriber(participant, subscriberAttributes, subscriberListener);
      }
      catch (IOException ioException)
      {
         throw new RuntimeException(ioException);
      }

      return new ROS2Subscription<T>(domain, subscriber);
   }

   /**
    * Create a new ROS 2 compatible subscription. This call can be used to make a ROS 2 topic with the
    * default qos profile.
    *
    * @param topicDataType      The topic data type of the message
    * @param newMessageListener New message listener
    * @param topicName          Name for the topic
    * @return a ROS 2 subscription
    */
   public <T> ROS2Subscription<T> createSubscription(TopicDataType<T> topicDataType, NewMessageListener<T> newMessageListener, String topicName)
   {
      return createSubscription(topicDataType, newMessageListener, topicName, ROS2QosProfile.DEFAULT());
   }

   /**
    * Create a new ROS 2 compatible subscription. This call can be used to make a ROS 2 topic with the
    * default qos profile.
    *
    * @param topicDataType      The topic data type of the message
    * @param newMessageListener New message listener
    * @param topicName          Name for the topic
    * @return a ROS 2 subscription
    */
   public <T> ROS2Subscription<T> createSubscription(TopicDataType<T> topicDataType,
                                                      NewMessageListener<T> newMessageListener,
                                                      String topicName,
                                                      ROS2QosProfile qosProfile)
   {
      return createSubscription(topicDataType, newMessageListener, createSubscriberAttributes(topicName, topicDataType, qosProfile));
   }

   /**
    * Create a new ROS 2 compatible subscription. This call can be used to make a ROS 2 topic with the
    * default qos profile.
    * Note: This method generates garbage!
    *
    * @param topic                       The topic
    * @param messageCallback             Message listener that gives the taken message directly
    * @return a ROS 2 subscription
    */
   public <T> ROS2Subscription<T> createSubscription2(ROS2Topic<T> topic, Consumer<T> messageCallback)
   {
      TopicDataType<T> topicDataType = ROS2TopicNameTools.newMessageTopicDataTypeInstance(topic.getType());
      return createSubscription(topicDataType, new NewMessageListener<T>()
      {
         @Override
         public void onNewDataMessage(Subscriber<T> subscriber)
         {
            T incomingData = subscriber.takeNextData();
            if (incomingData != null)
            {
               messageCallback.accept(incomingData);
            }
            else
            {
               LogTools.warn("Received null from takeNextData()");
            }
         }

         @Override
         public void onSubscriptionMatched(Subscriber<T> subscriber, MatchingInfo info)
         {
            // Do nothing
         }
      }, createSubscriberAttributes(topic.getName(), topicDataType, topic.getQoS()));
   }

   /**
    * Create a new ROS 2 compatible subscription. This call can be used to make a ROS 2 topic with the
    * default qos profile.
    *
    * @param topic                       The topic
    * @param newMessageListener          New message listener
    * @return a ROS 2 subscription
    */
   public <T> ROS2Subscription<T> createSubscription(ROS2Topic<T> topic,
                                                      NewMessageListener<T> newMessageListener)
   {
      return createSubscription(topic.getType(), newMessageListener, topic.getName(), topic.getQoS());
   }

   /**
    * Create a new ROS 2 compatible subscription. This call can be used to make a ROS 2 topic with the
    * default qos profile.
    *
    * @param topic                       The topic
    * @param newMessageListener          New message listener
    * @param subscriptionMatchedListener Subscription matched listener
    * @return a ROS 2 subscription
    */
   public <T> ROS2Subscription<T> createSubscription(ROS2Topic<T> topic,
                                                      NewMessageListener<T> newMessageListener,
                                                      SubscriptionMatchedListener<T> subscriptionMatchedListener)
   {
      return createSubscription(topic.getType(), newMessageListener, subscriptionMatchedListener, topic.getName(), topic.getQoS());
   }

   /**
    * Create a new ROS 2 compatible subscription. This call can be used to make a ROS 2 topic with the
    * default qos profile.
    *
    * @param messageType                 The type of the message
    * @param newMessageListener          New message listener
    * @return a ROS 2 subscription
    */
   public <T> ROS2Subscription<T> createSubscription(Class<T> messageType,
                                                      NewMessageListener<T> newMessageListener,
                                                      String topicName)
   {
      return createSubscription(messageType, newMessageListener, topicName, ROS2QosProfile.DEFAULT());
   }

   /**
    * Create a new ROS 2 compatible subscription. This call can be used to make a ROS 2 topic with the
    * default qos profile.
    *
    * @param messageType                 The type of the message
    * @param newMessageListener          New message listener
    * @return a ROS 2 subscription
    */
   public <T> ROS2Subscription<T> createSubscription(Class<T> messageType,
                                                      NewMessageListener<T> newMessageListener,
                                                      String topicName,
                                                      ROS2QosProfile qosProfile)
   {
      TopicDataType<T> topicDataType = ROS2TopicNameTools.newMessageTopicDataTypeInstance(messageType);
      return createSubscription(topicDataType, newMessageListener, topicName, qosProfile);
   }

   /**
    * Create a new ROS 2 compatible subscription. This call can be used to make a ROS 2 topic with the
    * default qos profile.
    *
    * @param messageType                 The type of the message
    * @param newMessageListener          New message listener
    * @param subscriptionMatchedListener Subscription matched listener
    * @return a ROS 2 subscription
    */
   public <T> ROS2Subscription<T> createSubscription(Class<T> messageType,
                                                      NewMessageListener<T> newMessageListener,
                                                      SubscriptionMatchedListener<T> subscriptionMatchedListener,
                                                      String topicName,
                                                      ROS2QosProfile qosProfile)
   {
      TopicDataType<T> topicDataType = ROS2TopicNameTools.newMessageTopicDataTypeInstance(messageType);
      return createSubscription(topicDataType, newMessageListener, subscriptionMatchedListener, topicName, qosProfile);
   }

   /**
    * Create a new ROS 2 compatible subscription. This call can be used to make a ROS 2 topic with the
    * default qos profile.
    *
    * @param topicDataType               The topic data type of the message
    * @param newMessageListener          New message listener
    * @param subscriptionMatchedListener Subscription matched listener
    * @param topicName                   Name for the topic
    * @param qosProfile                  ROS 2 qos Profile
    * @return a ROS 2 subscription
    */
   public <T> ROS2Subscription<T> createSubscription(TopicDataType<T> topicDataType,
                                                      NewMessageListener<T> newMessageListener,
                                                      SubscriptionMatchedListener<T> subscriptionMatchedListener,
                                                      String topicName,
                                                      ROS2QosProfile qosProfile)
   {
      return createSubscription(topicDataType, new NewMessageListener<T>()
      {
         @Override
         public void onNewDataMessage(Subscriber<T> subscriber)
         {
            newMessageListener.onNewDataMessage(subscriber);
         }

         @Override
         public void onSubscriptionMatched(Subscriber<T> subscriber, MatchingInfo info)
         {
            subscriptionMatchedListener.onSubscriptionMatched(subscriber, info);
         }
      }, createSubscriberAttributes(topicName, topicDataType, qosProfile));
   }

   public String getName()
   {
      return nodeName;
   }

   public String getNamespace()
   {
      return namespace;
   }

   /**
    * Destroys this node. This effectively removes this node's {@code Participant} from the domain and clears the internal
    * references to these two. After calling this method, this node becomes unusable, i.e. publisher or subscriber can no longer
    * be created.
    */
   public void destroy()
   {
      if (domain != null)
      {
         LogTools.info("Shutting down ROS2 node " + nodeName);

         try
         {
            domain.removeParticipant(participant);
         }
         catch (IllegalArgumentException e)
         {
            if (!e.getMessage().contains("This participant is not registered with this domain")) // just means a race condition that is okay
            {
               throw e;
            }
         }
         domain = null;
      }

      participant = null;
   }

   public static ParticipantProfile createParticipantAttributes(int domainId, boolean useSharedMemory, InetAddress... addressRestriction)
   {
      ParticipantProfile participantAttributes = ParticipantProfile.create().domainId(domainId);

      participantAttributes.useBuiltinTransports(false);

      if (useSharedMemory)
      {
         participantAttributes.addSharedMemoryTransport();
      }

      participantAttributes.addUDPv4Transport(addressRestriction);

      return participantAttributes;
   }

   public static boolean useSHMFromEnvironment()
   {
      String disableSharedMemoryTransportEnv = System.getenv("ROS_DISABLE_SHARED_MEMORY_TRANSPORT");
      if (disableSharedMemoryTransportEnv != null && (disableSharedMemoryTransportEnv.equalsIgnoreCase("true")
                                                      || disableSharedMemoryTransportEnv.equals("1")))
      {
         LogTools.info("Shared memory transport is disabled via environment variable ROS_DISABLE_SHARED_MEMORY_TRANSPORT");
         return false;
      }
      else
      {
         return true;
      }
   }

   public static int domainFromEnvironment()
   {
      String rosDomainId = System.getenv("ROS_DOMAIN_ID");

      int rosDomainIdAsInteger = 0; // default to 0

      if (rosDomainId != null)
      {
         rosDomainId = rosDomainId.trim();
         try
         {
            rosDomainIdAsInteger = Integer.parseInt(rosDomainId);
         }
         catch (NumberFormatException e)
         {
            LogTools.warn("Environment variable ROS_DOMAIN_ID cannot be parsed as an integer: {}", rosDomainId);
         }
      }

      LogTools.info("ROS_DOMAIN_ID environment variable is {}.", rosDomainIdAsInteger);
      LogTools.info("Nodes created without a specified domain ID will use ROS_DOMAIN_ID.");

      return rosDomainIdAsInteger;
   }
}

package us.ihmc.ros2;

import us.ihmc.log.LogTools;
import us.ihmc.pubsub.Domain;
import us.ihmc.pubsub.DomainFactory;
import us.ihmc.pubsub.DomainFactory.PubSubImplementation;
import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.attributes.ParticipantProfile;
import us.ihmc.pubsub.attributes.PublisherAttributes;
import us.ihmc.pubsub.attributes.SubscriberAttributes;
import us.ihmc.pubsub.common.Time;
import us.ihmc.pubsub.participant.Participant;
import us.ihmc.pubsub.publisher.Publisher;
import us.ihmc.pubsub.subscriber.Subscriber;

import java.io.IOException;
import java.net.InetAddress;

/**
 * An implementation of a ROS2 compatible node. This node can be used to create ROS2
 * compatible publishers and subscribers.
 *
 * @author Jesper Smith
 * @author Duncan Calvert
 */
public class ROS2Node implements ROS2NodeInterface
{
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
      this(domain, name, "", ROS2NodeInterface.domainFromEnvironment(), ROS2NodeInterface.useSHMFromEnvironment());
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
      this(domain, name, namespace, domainId, ROS2NodeInterface.useSHMFromEnvironment(), addressRestriction);
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
      this(domain, name, namespace, ROS2NodeInterface.createParticipantAttributes(domainId, useSharedMemory, addressRestriction));
   }

   /**
    * Create a new ROS 2 compatible publisher in this Node
    *
    * @param topicDataType       The topic data type of the message
    * @param publisherAttributes Publisher attributes created with @see{createPublisherAttributes}
    * @return a ROS 2 publisher
    */
   @Override
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
    * {@inheritDoc}
    */
   @Override
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
    * {@inheritDoc}
    */
   @Override
   public <T> QueuedROS2Subscription<T> createQueuedSubscription(TopicDataType<T> topicDataType, SubscriberAttributes subscriberAttributes, int queueSize)
   {
      RealtimeROS2SubscriptionListener<T> listener = new RealtimeROS2SubscriptionListener<>(topicDataType, queueSize);
      ROS2Subscription<T> subscriber = createSubscription(topicDataType, listener, subscriberAttributes);
      return new QueuedROS2Subscription<T>(subscriber, listener);
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
   @Override
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
    * {@inheritDoc}
    */
   @Override
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
    * {@inheritDoc}
    */
   @Override
   public String getName()
   {
      return nodeName;
   }

   /**
    * {@inheritDoc}
    */
   @Override
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
}

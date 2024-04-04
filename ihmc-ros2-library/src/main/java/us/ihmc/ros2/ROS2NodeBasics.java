package us.ihmc.ros2;

import com.eprosima.xmlschemas.fastrtps_profiles.TopicKindType;
import us.ihmc.log.LogTools;
import us.ihmc.pubsub.Domain;
import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.attributes.ParticipantAttributes;
import us.ihmc.pubsub.attributes.PublisherAttributes;
import us.ihmc.pubsub.attributes.SubscriberAttributes;
import us.ihmc.pubsub.common.Time;
import us.ihmc.pubsub.participant.Participant;
import us.ihmc.pubsub.publisher.Publisher;
import us.ihmc.pubsub.subscriber.Subscriber;

import java.io.IOException;

/**
 * Internal class to share implementation between intra and inter process ROS2 nodes.
 *
 * @author Jesper Smith
 * @author Duncan Calvert
 */
class ROS2NodeBasics implements ROS2NodeInterface
{
   public static final String DEFAULT_NAMESPACE = "/us/ihmc";

   private Domain domain;
   private Participant participant;

   private final String nodeName;
   private final String namespace;

   /**
    * Create a new ROS 2 node.
    *
    * @param domain     DDS domain to use
    * @param name       Name for the node
    * @param namespace  Namespace for the ros node i.e. DDS partition
    * @param attributes Participant attributes to configure the node
    */
   ROS2NodeBasics(Domain domain, String name, String namespace, ParticipantAttributes attributes)
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
                                                                   .topicKind(topicDataType.isGetKeyDefined() ? TopicKindType.WITH_KEY : TopicKindType.NO_KEY)
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
                                                                      .topicKind(topicDataType.isGetKeyDefined() ?
                                                                                       TopicKindType.WITH_KEY :
                                                                                       TopicKindType.NO_KEY)
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

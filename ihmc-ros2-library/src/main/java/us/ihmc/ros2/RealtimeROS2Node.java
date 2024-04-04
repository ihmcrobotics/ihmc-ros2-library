package us.ihmc.ros2;

import us.ihmc.pubsub.Domain;
import us.ihmc.pubsub.DomainFactory;
import us.ihmc.pubsub.DomainFactory.PubSubImplementation;
import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.attributes.ParticipantAttributes;
import us.ihmc.pubsub.attributes.PublisherAttributes;
import us.ihmc.pubsub.attributes.SubscriberAttributes;
import us.ihmc.util.PeriodicNonRealtimeThreadSchedulerFactory;
import us.ihmc.util.PeriodicThreadScheduler;
import us.ihmc.util.PeriodicThreadSchedulerFactory;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * A Realtime-safe implementation of ROS2Node. Lock-free publishing and subscribing is provided
 * using lock-free buffers.
 *
 * @author Jesper Smith
 */
public class RealtimeROS2Node implements ROS2NodeInterface
{
   public static final int DEFAULT_THREAD_PERIOD_MICROSECONDS = 1000;

   private final ROS2NodeBasics node;

   private final ArrayList<QueuedROS2Publisher<?>> publishers = new ArrayList<>();

   private final ReentrantLock startupLock = new ReentrantLock();
   private final PeriodicThreadScheduler scheduler;
   private boolean spinning = false;
   private TimeUnit threadPeriodUnit = TimeUnit.MICROSECONDS;
   private long threadPeriod = DEFAULT_THREAD_PERIOD_MICROSECONDS;

   /**
    * Create a new realtime ROS 2 node with non-realtime thread with the default namespace.
    *
    * @param pubSubImplementation   The implementation to use.
    * @param name                   Name of the ROS 2 node
    * @param domainId               Desired ROS domain ID
    * @param addressRestriction     Restrict network traffic to the given addresses. When provided, it
    *                               should describe one of the addresses of the computer hosting this node.
    *                               Optional.
    */
   public RealtimeROS2Node(PubSubImplementation pubSubImplementation, String name, int domainId, InetAddress... addressRestriction)
   {
      this(DomainFactory.getDomain(pubSubImplementation),
           new PeriodicNonRealtimeThreadSchedulerFactory(),
           name,
           ROS2NodeBasics.DEFAULT_NAMESPACE,
           domainId,
           addressRestriction);
   }

   /**
    * Create a new realtime ROS 2 node with the default namespace.
    *
    * @param pubSubImplementation  The implementation to use.
    * @param threadFactory         Thread factory for the publisher. Either
    *                              PeriodicRealtimeThreadSchedulerFactory or
    *                              PeriodicNonRealtimeThreadSchedulerFactory depending on the application
    * @param name                  Name of the ROS 2 node
    * @param domainId              Desired ROS domain ID
    * @param addressRestriction    Restrict network traffic to the given addresses. When provided, it
    *                              should describe one of the addresses of the computer hosting this node.
    *                              Optional.
    */
   public RealtimeROS2Node(PubSubImplementation pubSubImplementation,
                           PeriodicThreadSchedulerFactory threadFactory,
                           String name,
                           int domainId,
                           InetAddress... addressRestriction)
   {
      this(DomainFactory.getDomain(pubSubImplementation), threadFactory, name, ROS2NodeBasics.DEFAULT_NAMESPACE, domainId, addressRestriction);
   }

   /**
    * Create a new realtime ROS 2 node
    *
    * @param domain        DDS domain to use. Use DomainFactory.getDomain(implementation)
    * @param threadFactory Thread factory for the publisher. Either
    *                      PeriodicRealtimeThreadSchedulerFactory or
    *                      PeriodicNonRealtimeThreadSchedulerFactory depending on the application
    * @param name          Name of the ROS 2 node
    * @param namespace     Namespace of the ROS 2 node
    */
   public RealtimeROS2Node(Domain domain, PeriodicThreadSchedulerFactory threadFactory, String name, String namespace)
   {
      this(domain, threadFactory, name, namespace, ROS2NodeInterface.domainFromEnvironment(), ROS2NodeInterface.useSHMFromEnvironment());
   }

   /**
    * Create a new realtime ROS 2 node
    *
    * @param domain             DDS domain to use. Use DomainFactory.getDomain(implementation)
    * @param threadFactory      Thread factory for the publisher. Either
    *                           PeriodicRealtimeThreadSchedulerFactory or
    *                           PeriodicNonRealtimeThreadSchedulerFactory depending on the application
    * @param name               Name of the ROS 2 node
    * @param namespace          Namespace of the ROS 2 node
    * @param domainId           Desired ROS domain ID
    * @param addressRestriction Restrict network traffic to the given addresses. When provided, it
    *                           should describe one of the addresses of the computer hosting this node.
    *                           Optional.
    */
   public RealtimeROS2Node(Domain domain,
                           PeriodicThreadSchedulerFactory threadFactory,
                           String name,
                           String namespace,
                           int domainId,
                           InetAddress... addressRestriction)
   {
      this(domain, threadFactory, name, namespace, domainId, ROS2NodeInterface.useSHMFromEnvironment(), addressRestriction);
   }
   
   /**
    * Create a new realtime ROS 2 node
    *
    * @param domain             DDS domain to use. Use DomainFactory.getDomain(implementation)
    * @param threadFactory      Thread factory for the publisher. Either
    *                           PeriodicRealtimeThreadSchedulerFactory or
    *                           PeriodicNonRealtimeThreadSchedulerFactory depending on the application
    * @param name               Name of the ROS 2 node
    * @param namespace          Namespace of the ROS 2 node
    * @param domainId           Desired ROS domain ID
    * @param useSharedMemory    Enable shared memory transport if true
    * @param addressRestriction Restrict network traffic to the given addresses. When provided, it
    *                           should describe one of the addresses of the computer hosting this node.
    *                           Optional.
    */
   public RealtimeROS2Node(Domain domain,
                           PeriodicThreadSchedulerFactory threadFactory,
                           String name,
                           String namespace,
                           int domainId,
                           boolean useSharedMemory,
                           InetAddress... addressRestriction)
   {
      this(domain, threadFactory, name, namespace, ROS2NodeInterface.createParticipantAttributes(domainId, useSharedMemory, addressRestriction));
   }

   /**
    * Create a new realtime ROS 2 node
    *
    * @param domain        DDS domain to use. Use DomainFactory.getDomain(implementation)
    * @param threadFactory Thread factory for the publisher. Either
    *                      PeriodicRealtimeThreadSchedulerFactory or
    *                      PeriodicNonRealtimeThreadSchedulerFactory depending on the application
    * @param name          Name of the ROS 2 node
    * @param namespace     Namespace of the ROS 2 node
    * @param attributes    ParticipantAttributes for the domain
    */
   public RealtimeROS2Node(Domain domain, PeriodicThreadSchedulerFactory threadFactory, String name, String namespace, ParticipantAttributes attributes)
   {

      this.node = new ROS2NodeBasics(domain, name, namespace, attributes);
      this.scheduler = threadFactory.createPeriodicThreadScheduler("RealtimeNode_" + namespace + "/" + name);
   }
   
   /**
    * Adjust the desired thread period from the default (1000 microseconds)
    * 
    * This could be useful if a faster response is desired, or to reduce load on the CPU.
    * 
    * @param period
    * @param unit
    */
   public void setThreadPeriod(long period, TimeUnit unit)
   {
      startupLock.lock();
      try
      {
         if(spinning)
         {
            throw new RuntimeException("Cannot set the thread period while the node is spinning.");
         }
         
         this.threadPeriod = period;
         this.threadPeriodUnit = unit;
      }
      finally
      {
         startupLock.unlock();
      }
   }
   
   @Override
   public <T> QueuedROS2Publisher<T> createPublisher(TopicDataType<T> topicDataType, PublisherAttributes publisherAttributes)
   {
      return createPublisher(topicDataType, publisherAttributes, DEFAULT_QUEUE_SIZE);
   }

   public <T> QueuedROS2Publisher<T> createPublisher(TopicDataType<T> topicDataType, String topicName, ROS2QosProfile qosProfile, int queueSize)
   {
      return createPublisher(topicDataType, createPublisherAttributes(topicDataType, topicName, qosProfile), queueSize);
   }

   public <T> QueuedROS2Publisher<T> createPublisher(TopicDataType<T> topicDataType, PublisherAttributes publisherAttributes, int queueSize)
   {
      startupLock.lock();
      try
      {
         if (spinning)
         {
            throw new RuntimeException("Cannot add publishers to a RealtimeROS2Node that is already spinning");
         }
         ROS2Publisher<T> rosPublisher = node.createPublisher(topicDataType, publisherAttributes);
         QueuedROS2Publisher<T> realtimePublisher = new QueuedROS2Publisher<>(topicDataType, rosPublisher, queueSize);
         publishers.add(realtimePublisher);
         return realtimePublisher;
      }
      finally
      {
         startupLock.unlock();
      }
   }

   @Override
   public <T> QueuedROS2Subscription<T> createQueuedSubscription(TopicDataType<T> topicDataType, SubscriberAttributes subscriberAttributes, int queueSize)
   {
      return node.createQueuedSubscription(topicDataType, subscriberAttributes, queueSize);
   }
   
   public void spin()
   {
      startupLock.lock();
      if (spinning)
      {
         startupLock.unlock();
         throw new RuntimeException("This RealtimeROS2Node is already spinning");
      }
      spinning = true;
      scheduler.schedule(this::realtimeNodeThread, threadPeriod, threadPeriodUnit);
      startupLock.unlock();
   }

   private void realtimeNodeThread()
   {
      for (int i = 0; i < publishers.size(); i++)
      {
         publishers.get(i).spin();
      }
   }

   public void stopSpinning()
   {
      scheduler.shutdown();
      startupLock.lock();
      spinning = false;
      startupLock.unlock();
   }

   public void destroy()
   {
      if (spinning)
         stopSpinning();
      node.destroy();
   }

   public String getName()
   {
      return node.getName();
   }

   public String getNamespace()
   {
      return node.getNamespace();
   }

   @Override
   public <T> ROS2Subscription<T> createSubscription(TopicDataType<T> topicDataType,
                                                     NewMessageListener<T> subscriberListener,
                                                     SubscriberAttributes subscriberAttributes)
   {
      return node.createSubscription(topicDataType, subscriberListener, subscriberAttributes);
   }

   @Override
   public <T> SubscriberAttributes createSubscriberAttributes(String topicName, TopicDataType<T> topicDataType, ROS2QosProfile qosProfile)
   {
      return node.createSubscriberAttributes(topicName, topicDataType, qosProfile);
   }

   @Override
   public <T> PublisherAttributes createPublisherAttributes(TopicDataType<T> topicDataType, String topicName, ROS2QosProfile qosProfile)
   {
      return node.createPublisherAttributes(topicDataType, topicName, qosProfile);
   }
}

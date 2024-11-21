package us.ihmc.ros2;

import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.attributes.ParticipantProfile;
import us.ihmc.pubsub.attributes.PublisherAttributes;
import us.ihmc.util.PeriodicThreadScheduler;
import us.ihmc.util.PeriodicThreadSchedulerFactory;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * A Realtime-safe implementation of ROS2Node. Lock-free publishing and subscribing is provided
 * using lock-free buffers.
 *
 * @author Jesper Smith
 */
public class RealtimeROS2Node extends ROS2Node
{
   public static final int DEFAULT_THREAD_PERIOD_MICROSECONDS = 1000;

   private final ArrayList<QueuedROS2Publisher<?>> publishers = new ArrayList<>();

   private final ReentrantLock startupLock = new ReentrantLock();
   private final PeriodicThreadScheduler scheduler;
   private boolean spinning = false;
   private TimeUnit threadPeriodUnit = TimeUnit.MICROSECONDS;
   private long threadPeriod = DEFAULT_THREAD_PERIOD_MICROSECONDS;

   protected RealtimeROS2Node(String name, String namespace, ParticipantProfile attributes, PeriodicThreadSchedulerFactory threadFactory)
   {
      super(name, namespace, attributes);
      this.scheduler = threadFactory.createPeriodicThreadScheduler("RealtimeNode_" + namespace + "/" + name);
   }
   
   /**
    * Adjust the desired thread period from the default (1000 microseconds)
    * This could be useful if a faster response is desired, or to reduce load on the CPU.
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
         ROS2Publisher<T> rosPublisher = super.createPublisher(topicDataType, publisherAttributes);
         QueuedROS2Publisher<T> realtimePublisher = new QueuedROS2Publisher<>(topicDataType, rosPublisher, queueSize);
         publishers.add(realtimePublisher);
         return realtimePublisher;
      }
      finally
      {
         startupLock.unlock();
      }
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

   @Override
   public void destroy()
   {
      if (spinning)
         stopSpinning();
      super.destroy();
   }

   public static RealtimeROS2Node create(String name)
   {
      return null;
   }
}

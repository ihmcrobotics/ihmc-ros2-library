package us.ihmc.ros2;

import us.ihmc.commons.time.Stopwatch;
import us.ihmc.concurrent.ConcurrentRingBuffer;
import us.ihmc.log.LogTools;
import us.ihmc.pubsub.TopicDataType;

/**
 * Publisher Node safe for use in a realtime thread. This publisher uses a queue to buffer messages
 * until the next spin. Lockless synchronization is used for the queue.
 *
 * @author Jesper Smith
 * @param <T> the data type to publish
 */
public class QueuedROS2Publisher<T> extends ROS2Publisher<T>
{
   private final TopicDataType<T> topicDataType;
   private final ConcurrentRingBuffer<T> concurrentRingBuffer;
   private final Stopwatch throttleStopwatch = new Stopwatch().start();
   private long errorCount = 0;
   private int numberOfExceptions = 0;

   QueuedROS2Publisher(TopicDataType<T> topicDataType, ROS2Publisher<T> rosPublisher, int queueDepth)
   {
      super(rosPublisher.getDomain(), rosPublisher.getPublisher());

      this.topicDataType = topicDataType.newInstance();
      concurrentRingBuffer = new ConcurrentRingBuffer<>(topicDataType::createData, queueDepth);
   }

   /**
    * Put new data in the queue to be published on the next spin This function does not block and is
    * realtime-safe.
    *
    * @param data data to publish
    * @return true if there was space in the queue, false if no space is left
    */
   @Override
   public boolean publish(T data)
   {
      try
      {
         T next = concurrentRingBuffer.next();
         if (next != null)
         {
            topicDataType.copy(data, next);
            concurrentRingBuffer.commit();
            return true;
         }
         else
         {
            if (throttleStopwatch.totalElapsed() > 1.0)
            {
               errorCount++;
               throttleStopwatch.reset();
               LogTools.error("No space left in concurrent ring buffer. Buffer capacity: {} Topic: {} Occurence #: {}",
                              concurrentRingBuffer.getCapacity(),
                              getPublisher().getAttributes().getTopicName(),
                              errorCount);
            }
            return false;
         }
      }
      catch (Exception exception)
      {
         if (numberOfExceptions < 6)
         {
            exception.printStackTrace();
            numberOfExceptions++;

            if (numberOfExceptions >= 6)
            {

               LogTools.error("Stopping to print exceptions after 5.");
            }
         }

         return false;
      }
   }

   void spin()
   {
      if (concurrentRingBuffer.poll())
      {
         T next;
         while ((next = concurrentRingBuffer.read()) != null)
         {
            super.publish(next);
         }
         concurrentRingBuffer.flush();
      }
   }

   @Override
   public void remove()
   {
      // Remove not necessarily defined for a realtime node
   }
}

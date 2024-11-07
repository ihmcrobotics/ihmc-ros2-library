package us.ihmc.ros2;

import us.ihmc.concurrent.ConcurrentRingBuffer;
import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.subscriber.Subscriber;

/**
 * Helper listener for the realtime subscription. This class moves all incoming messages in the
 * queue if there is space available.
 *
 * @author Jesper Smith
 * @param <T>
 */
class RealtimeROS2SubscriptionListener<T> implements NewMessageListener<T>
{
   private final T data;
   private final ConcurrentRingBuffer<T> messageQueue;
   private final TopicDataType<T> topicDataTypeForCallback;
   private final TopicDataType<T> topicDataTypeForPoll;

   RealtimeROS2SubscriptionListener(TopicDataType<T> topicDataType, int queueDepth)
   {
      this.data = topicDataType.createData();
      this.messageQueue = new ConcurrentRingBuffer<>(topicDataType::createData, queueDepth);
      this.topicDataTypeForCallback = topicDataType.newInstance();
      this.topicDataTypeForPoll = topicDataType.newInstance();
   }

   boolean poll(T data)
   {
      if (messageQueue.poll())
      {
         T next = messageQueue.read();
         topicDataTypeForPoll.copy(next, data);
         messageQueue.flush();
         return true;
      }
      else
      {
         return false;
      }
   }
   
   boolean peek(T data)
   {
      if(messageQueue.poll())
      {
         T next = messageQueue.peek();
         topicDataTypeForPoll.copy(next, data);
         return true;
      }
      else
      {
         return false;
      }
   }

   boolean flushAndGetLatest(T data)
   {
      if (messageQueue.poll())
      {
         T latest = null;
         T next;
         while ((next = messageQueue.read()) != null)
         {
            latest = next;
         }
         topicDataTypeForPoll.copy(latest, data);
         messageQueue.flush();
         return true;
      }
      else
      {
         return false;
      }
   }

   @Override
   public void onNewDataMessage(Subscriber<T> subscriber)
   {
      if (subscriber.takeNextData(data, null))
      {
         T next = messageQueue.next();
         if (next != null)
         {
            topicDataTypeForCallback.copy(data, next);
            messageQueue.commit();
         }
      }
   }


}
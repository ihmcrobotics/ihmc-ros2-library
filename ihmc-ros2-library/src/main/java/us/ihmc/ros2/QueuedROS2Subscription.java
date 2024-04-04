package us.ihmc.ros2;

/**
 * Incoming messages are stored in a queue and can be polled in a non-blocking manner.
 *
 * @param <T> data type
 */
public class QueuedROS2Subscription<T> extends ROS2Subscription<T>
{
   private final RealtimeROS2SubscriptionListener<T> listener;
   private final ROS2Subscription<T> subscriber;

   QueuedROS2Subscription(ROS2Subscription<T> subscriber, RealtimeROS2SubscriptionListener<T> listener)
   {
      super(null, null);
      this.subscriber = subscriber;
      this.listener = listener;
   }

   /**
    * Get the next message in the queue. After calling this function the message is removed from the
    * queue. This function does not block and is realtime-safe.
    *
    * @param data Object to store the data in if data is available; if no data is available this object
    *             does not get modified
    * @return true if a new message was available, false otherwise
    */
   public boolean poll(T data)
   {
      return listener.poll(data);
   }

   /**
    * Get the latest message in the queue and discard all others. After calling this function the queue
    * is empty. This function does not block and is realtime-safe.
    *
    * @param data Object to store the data in if data is available; if no data is available this object
    *             does not get modified
    * @return true if a new message was available, false otherwise
    */
   public boolean flushAndGetLatest(T data)
   {
      return listener.flushAndGetLatest(data);
   }
   
   
   /**
    * Peek at the latest data, without removing the message from the queue. 
    * This function does not block and is realtime-safe.
    *
    * @param data Object to store the data in if data is available; if no data is available this object
    *             does not get modified
    * @return true if a new message was available, false otherwise
    */
   public boolean peek(T data)
   {
      return listener.peek(data);
   }

   @Override
   public void remove()
   {
      subscriber.remove();
   }
}

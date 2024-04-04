package us.ihmc.ros2;

import us.ihmc.log.LogTools;
import us.ihmc.pubsub.Domain;
import us.ihmc.pubsub.publisher.Publisher;

/**
 * A ROS 2 compatible publisher
 *
 * @param <T> the data type
 */
public class ROS2Publisher<T> implements ROS2PublisherBasics<T>
{
   private static final int NUMBER_OF_EXCEPTIONS_TO_PRINT = 5;
   private int numberOfExceptions = 0;

   private final Domain domain;
   private final Publisher publisher;

   ROS2Publisher(Domain domain, Publisher publisher)
   {
      this.domain = domain;
      this.publisher = publisher;
   }

   @Override
   public synchronized boolean publish(T data)
   {
      try
      {
         if (publisher.isAvailable())
         {
            publisher.write(data);
            return true;
         }
         else
         {
            throw new Exception("Failed to publish message. Type: " + data.getClass().getSimpleName());
         }
      }
      catch (Exception exception)
      {
         if (numberOfExceptions <= NUMBER_OF_EXCEPTIONS_TO_PRINT)
         {
            LogTools.error(exception.getMessage());

            if (++numberOfExceptions > NUMBER_OF_EXCEPTIONS_TO_PRINT)
            {
               LogTools.error("Stopping to print exceptions after {}.", NUMBER_OF_EXCEPTIONS_TO_PRINT);
            }
         }

         return false;
      }
   }

   @Override
   public void remove()
   {
      domain.removePublisher(publisher);
   }

   Publisher getPublisher()
   {
      return publisher;
   }

   Domain getDomain()
   {
      return domain;
   }
}

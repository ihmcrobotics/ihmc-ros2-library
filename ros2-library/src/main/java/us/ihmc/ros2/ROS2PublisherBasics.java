package us.ihmc.ros2;

public interface ROS2PublisherBasics<T>
{
   /**
    * Publish data to the ROS 2 domain.
    *
    * @param data Data to publisher
    * @return true if published, false if not published
    */
   boolean publish(T data);

   /**
    * Remove this publisher from the ROS 2 domain.
    */
   void remove();
}

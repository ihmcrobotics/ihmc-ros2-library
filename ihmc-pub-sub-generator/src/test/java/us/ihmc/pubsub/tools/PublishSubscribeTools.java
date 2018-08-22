package us.ihmc.pubsub.tools;

public class PublishSubscribeTools
{
   public static int systemDomain()
   {
      String ros_domain_id = System.getenv("ROS_DOMAIN_ID");

      if (ros_domain_id != null)
      {
         try
         {
            return Integer.valueOf(ros_domain_id);
         }
         catch (NumberFormatException e)
         {
            // return default below
         }
      }

      return 215;
   }
}
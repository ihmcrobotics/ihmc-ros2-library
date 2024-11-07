package us.ihmc.ros2;

import com.eprosima.xmlschemas.fastrtps_profiles.DurabilityQosKindPolicyType;
import com.eprosima.xmlschemas.fastrtps_profiles.HistoryQosKindPolicyType;
import com.eprosima.xmlschemas.fastrtps_profiles.ReliabilityQosKindPolicyType;
import us.ihmc.log.LogTools;

import java.util.Objects;

/**
 * ROS2 QoS profile settings Provides a quick way to set the ROS2 QoS settings. Provided options are
 * - History KEEP_LAST or KEEP_ALL
 * - Size default history depth (aka size)
 * - Reliability RELIABLE or BEST EFFORT
 * - Durability VOLATILE or TRANSIENT_LOCAL
 * - avoidRosNamespaceConventions Use the Node name directly for communication with pure RTPS/DDS nodes
 *
 * @author Jesper Smith
 */
public class ROS2QosProfile
{
   /**
    * The default QOS mode is BEST_EFFORT because we think it can actually
    * result in a more reliable setup in practice. This setting may be changed
    * by setting the environment variable "ROS_DEFAULT_QOS" to "RELIABLE" or
    * "BEST_EFFORT".
    */
   public static ROS2QosProfile DEFAULT()
   {
      String defaultQoS = System.getenv("ROS_DEFAULT_QOS");

      if (defaultQoS != null && defaultQoS.trim().equalsIgnoreCase("reliable"))
      {
         LogTools.info("Topics with unspecified QoS will use RELIABLE.");
         return RELIABLE();
      }
      else
      {
         LogTools.info("Topics with unspecified QoS will use BEST_EFFORT.");
         return BEST_EFFORT();
      }
   }

   public static ROS2QosProfile RELIABLE()
   {
      int depth = 1;
      return new ROS2QosProfile(HistoryQosKindPolicyType.KEEP_LAST, depth, ReliabilityQosKindPolicyType.RELIABLE, DurabilityQosKindPolicyType.VOLATILE, false);
   }

   public static ROS2QosProfile KEEP_HISTORY(int depth)
   {
      return new ROS2QosProfile(HistoryQosKindPolicyType.KEEP_LAST, depth, ReliabilityQosKindPolicyType.RELIABLE, DurabilityQosKindPolicyType.TRANSIENT_LOCAL, false);
   }

   public static ROS2QosProfile BEST_EFFORT()
   {
      int depth = 1;
      return new ROS2QosProfile(HistoryQosKindPolicyType.KEEP_LAST, depth, ReliabilityQosKindPolicyType.BEST_EFFORT, DurabilityQosKindPolicyType.VOLATILE, false);
   }

   private final HistoryQosKindPolicyType historyKind;
   private final int historyDepth;
   private final ReliabilityQosKindPolicyType reliabilityKind;
   private final DurabilityQosKindPolicyType durabilityKind;
   private final boolean avoidRosNamespaceConventions;

   public ROS2QosProfile(HistoryQosKindPolicyType historyKind,
                         int historyDepth,
                         ReliabilityQosKindPolicyType reliabilityKind,
                         DurabilityQosKindPolicyType durabilityKind,
                         boolean avoidRosNamespaceConventions)
   {
      this.historyKind = historyKind;
      this.historyDepth = historyDepth;
      this.reliabilityKind = reliabilityKind;
      this.durabilityKind = durabilityKind;
      this.avoidRosNamespaceConventions = avoidRosNamespaceConventions;
   }

   public HistoryQosKindPolicyType getHistoryKind()
   {
      return historyKind;
   }

   public int getHistoryDepth()
   {
      return historyDepth;
   }

   public ReliabilityQosKindPolicyType getReliabilityKind()
   {
      return reliabilityKind;
   }

   public DurabilityQosKindPolicyType getDurabilityKind()
   {
      return durabilityKind;
   }

   public boolean isAvoidRosNamespaceConventions()
   {
      return avoidRosNamespaceConventions;
   }

   @Override
   public boolean equals(Object other)
   {
      if (this == other)
         return true;
      if (other == null || getClass() != other.getClass())
         return false;

      ROS2QosProfile otherQoS = (ROS2QosProfile) other;
      boolean equals = historyKind == otherQoS.historyKind;
      equals &= historyDepth == otherQoS.historyDepth;
      equals &= reliabilityKind == otherQoS.reliabilityKind;
      equals &= durabilityKind == otherQoS.durabilityKind;
      equals &= avoidRosNamespaceConventions == otherQoS.avoidRosNamespaceConventions;
      return equals;
   }

   @Override
   public int hashCode()
   {
      return Objects.hash(historyKind, historyDepth, reliabilityKind, durabilityKind, avoidRosNamespaceConventions);
   }
}

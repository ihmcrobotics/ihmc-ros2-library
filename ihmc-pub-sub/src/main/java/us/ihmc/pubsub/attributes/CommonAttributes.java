package us.ihmc.pubsub.attributes;

import com.eprosima.xmlschemas.fastrtps_profiles.*;
import com.eprosima.xmlschemas.fastrtps_profiles.PartitionQosPolicyType.Names;
import us.ihmc.log.LogTools;
import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.common.Time;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class CommonAttributes<T extends CommonAttributes<T>>
{
   private TopicDataType<?> topicDataType;

   protected final TopicElementType topicElementType = new TopicElementType();

   protected final HistoryQosPolicyType historyQosPolicyType = new HistoryQosPolicyType();
   protected final DurabilityQosPolicyType durabilityQosPolicyType = new DurabilityQosPolicyType();
   protected final ReliabilityQosPolicyType reliabilityQosPolicyType = new ReliabilityQosPolicyType();

   public CommonAttributes()
   {
      // Set useful defaults
      historyDepth(10);
      historyQosPolicyKind(HistoryQosKindPolicyType.KEEP_LAST);
      durabilityKind(DurabilityQosKindPolicyType.VOLATILE);
      reliabilityKind(ReliabilityQosKindPolicyType.RELIABLE);

      topicElementType.setHistoryQos(historyQosPolicyType);
   }

   @SuppressWarnings("unchecked")
   private T self()
   {
      return (T) this;
   }

   public T topicDataType(TopicDataType<?> topicDataType)
   {
      this.topicDataType = topicDataType;
      topicElementType.setDataType(topicDataType.getName());
      return self();
   }

   public TopicDataType<?> getTopicDataType()
   {
      return topicDataType;
   }

   public T topicName(String name)
   {
      topicElementType.setName(name);
      return self();
   }

   public String getTopicName()
   {
      return topicElementType.getName();
   }

   public T historyDepth(long depth)
   {
      historyQosPolicyType.setDepth(depth);
      return self();
   }

   public long getHistoryDepth()
   {
      return historyQosPolicyType.getDepth();
   }

   public T historyQosPolicyKind(HistoryQosKindPolicyType kind)
   {
      historyQosPolicyType.setKind(kind);
      return self();
   }

   public HistoryQosKindPolicyType getHistoryQosPolicyKind()
   {
      return historyQosPolicyType.getKind();
   }

   public T durabilityKind(DurabilityQosKindPolicyType kind)
   {
      durabilityQosPolicyType.setKind(kind);
      return self();
   }

   public DurabilityQosKindPolicyType getDurabilityKind()
   {
      return durabilityQosPolicyType.getKind();
   }

   public T reliabilityKind(ReliabilityQosKindPolicyType kind)
   {
      reliabilityQosPolicyType.setKind(kind);
      return self();
   }

   public ReliabilityQosKindPolicyType getReliabilityKind()
   {
      return reliabilityQosPolicyType.getKind();
   }

   public T maxBlockingTime(Time time)
   {
      reliabilityQosPolicyType.setMaxBlockingTime(DDSConversionTools.timeToDurationType(time));
      return self();
   }

   public Time getMaxBlockingTime()
   {
      return DDSConversionTools.durationTypeToTime(reliabilityQosPolicyType.getMaxBlockingTime());
   }

   protected abstract void setPartitionQosPolicyType(PartitionQosPolicyType partitionQosPolicyType);

   protected abstract PartitionQosPolicyType getPartitionQosPolicyType();

   public T partitions(List<String> partitions)
   {
      if (partitions != null && !partitions.isEmpty())
      {
         PartitionQosPolicyType partitionQosPolicyType = new PartitionQosPolicyType();
         PartitionQosPolicyType.Names names = new Names();
         names.getName().addAll(partitions);
         partitionQosPolicyType.setNames(names);
         setPartitionQosPolicyType(partitionQosPolicyType);
      }

      return self();
   }

   public List<String> getPartitions()
   {
      if (getPartitionQosPolicyType() == null)
      {
         return Collections.emptyList();
      }
      else
      {
         return new ArrayList<>(getPartitionQosPolicyType().getNames().getName());
      }
   }

   public T ownershipPolicyKind(OwnershipQosKindPolicyType kind)
   {
      LogTools.warn("OwnershipQosPolicy not supported");
      return self();
   }

   public OwnershipQosKindPolicyType getOwnerShipPolicyKind()
   {
      return null;
   }

   protected abstract void setLifespanQosPolicyType(LifespanQosPolicyType lifespanQosPolicyType);
   protected abstract LifespanQosPolicyType getLifespanQosPolicyType();

   public T lifespan(Time lifespan)
   {
      LifespanQosPolicyType lifespanQosPolicyType = new LifespanQosPolicyType();
      lifespanQosPolicyType.setDuration(DDSConversionTools.timeToDurationType(lifespan));
      setLifespanQosPolicyType(lifespanQosPolicyType);
      return self();
   }

   public Time getLifespan()
   {
      if (getLifespanQosPolicyType() != null)
      {
         return DDSConversionTools.durationTypeToTime(getLifespanQosPolicyType().getDuration());
      }
      else
      {
         return null;
      }
   }
}

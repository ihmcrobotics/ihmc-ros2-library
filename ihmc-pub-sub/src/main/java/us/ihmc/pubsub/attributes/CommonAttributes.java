package us.ihmc.pubsub.attributes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.eprosima.xmlschemas.fastrtps_profiles.DurabilityQosKindType;
import com.eprosima.xmlschemas.fastrtps_profiles.DurabilityQosPolicyType;
import com.eprosima.xmlschemas.fastrtps_profiles.HistoryQosKindType;
import com.eprosima.xmlschemas.fastrtps_profiles.HistoryQosPolicyType;
import com.eprosima.xmlschemas.fastrtps_profiles.LifespanQosPolicyType;
import com.eprosima.xmlschemas.fastrtps_profiles.NameVectorType;
import com.eprosima.xmlschemas.fastrtps_profiles.OwnershipQosKindType;
import com.eprosima.xmlschemas.fastrtps_profiles.OwnershipQosPolicyType;
import com.eprosima.xmlschemas.fastrtps_profiles.PartitionQosPolicyType;
import com.eprosima.xmlschemas.fastrtps_profiles.ReliabilityQosKindType;
import com.eprosima.xmlschemas.fastrtps_profiles.ReliabilityQosPolicyType;
import com.eprosima.xmlschemas.fastrtps_profiles.TopicAttributesType;
import com.eprosima.xmlschemas.fastrtps_profiles.TopicKindType;

import us.ihmc.log.LogTools;
import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.common.Time;

public abstract class CommonAttributes<T extends CommonAttributes<T>>
{
   private TopicDataType<?> topicDataType;

   protected final TopicAttributesType topicAttributesType = new TopicAttributesType();

   protected final HistoryQosPolicyType historyQosPolicyType = new HistoryQosPolicyType();
   protected final DurabilityQosPolicyType durabilityQosPolicyType = new DurabilityQosPolicyType();
   protected final ReliabilityQosPolicyType reliabilityQosPolicyType = new ReliabilityQosPolicyType();

   public CommonAttributes()
   {
      topicAttributesType.setHistoryQos(historyQosPolicyType);

      // Set useful defaults
      historyDepth(10);
      historyQosPolicyKind(HistoryQosKindType.KEEP_LAST);
      durabilityKind(DurabilityQosKindType.VOLATILE);
      reliabilityKind(ReliabilityQosKindType.RELIABLE);
      topicKind(TopicKindType.NO_KEY);
   }

   @SuppressWarnings("unchecked")
   private T self()
   {
      return (T) this;
   }

   public T topicDataType(TopicDataType<?> topicDataType)
   {
      this.topicDataType = topicDataType;
      topicAttributesType.setDataType(topicDataType.getName());
      return self();
   }

   public TopicDataType<?> getTopicDataType()
   {
      return topicDataType;
   }

   public T topicKind(TopicKindType kind)
   {
      topicAttributesType.setKind(kind);
      return self();
   }

   public TopicKindType getTopicKind()
   {
      return topicAttributesType.getKind();
   }

   public T topicName(String name)
   {
      topicAttributesType.setName(name);
      return self();
   }
   
   

   public String getTopicName()
   {
      return topicAttributesType.getName();
   }

   public T historyDepth(int depth)
   {
      historyQosPolicyType.setDepth(depth);
      return self();
   }

   public int getHistoryDepth()
   {
      return historyQosPolicyType.getDepth();
   }

   public T historyQosPolicyKind(HistoryQosKindType kind)
   {
      historyQosPolicyType.setKind(kind);
      return self();
   }

   public HistoryQosKindType getHistoryQosPolicyKind()
   {
      return historyQosPolicyType.getKind();
   }

   public T durabilityKind(DurabilityQosKindType kind)
   {
      durabilityQosPolicyType.setKind(kind);
      return self();
   }

   public DurabilityQosKindType getDurabilityKind()
   {
      return durabilityQosPolicyType.getKind();
   }

   public T reliabilityKind(ReliabilityQosKindType kind)
   {
      reliabilityQosPolicyType.setKind(kind);
      return self();
   }

   public ReliabilityQosKindType getReliabilityKind()
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
         NameVectorType nameVectorType = new NameVectorType();
         partitions.forEach(s -> nameVectorType.getName().add(s));
         partitionQosPolicyType.setNames(nameVectorType);
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

   public T ownershipPolicyKind(OwnershipQosKindType kind)
   {
      LogTools.warn("OwnershipQosPolicy not supported");
      return self();
   }

   public OwnershipQosKindType getOwnerShipPolicyKind()
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

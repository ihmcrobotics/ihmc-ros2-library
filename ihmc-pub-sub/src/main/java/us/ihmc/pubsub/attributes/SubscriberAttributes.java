package us.ihmc.pubsub.attributes;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import us.ihmc.pubsub.TopicDataType;

import java.util.Collections;
import java.util.List;

@Data
@Builder
public class SubscriberAttributes
{
   String topicName;
   TopicDataType topicDataType;

   @Builder.Default
   OwnerShipPolicyKind ownerShipPolicyKind = OwnerShipPolicyKind.SHARED_OWNERSHIP_QOS;

   @Builder.Default
   TopicAttributes.TopicKind topicKind = TopicAttributes.TopicKind.NO_KEY;

   int userDefinedId;
   String namespace;
   HistoryQosPolicy.HistoryQosPolicyKind historyQosPolicyKind;
   int historyDepth;
   DurabilityKind durabilityKind;
   ReliabilityKind reliabilityKind;

   @Builder.Default
   List<String> partitions = Collections.emptyList();

   public boolean publisherMatches(PublisherAttributes publisher)
   {
      if (!getTopicName().equals(publisher.getTopicName()))
         return false;

      if (!getTopicDataType().getClass().equals(publisher.getTopicDataType().getClass()))
         return false;

      if (getOwnerShipPolicyKind() != publisher.getOwnerShipPolicyKind())
         return false;

      if (publisher.getReliabilityKind() == ReliabilityKind.BEST_EFFORT && getReliabilityKind() == ReliabilityKind.RELIABLE)
         return false;

      if (publisher.getDurabilityKind() == DurabilityKind.TRANSIENT_LOCAL_DURABILITY_QOS
            && getDurabilityKind() == DurabilityKind.VOLATILE_DURABILITY_QOS)
         return false;

      if (this.getPartitions().isEmpty() && publisher.getPartitions().isEmpty())
      {
         return true;
      }
      else
      {
         for (String partition : getPartitions())
         {
            for (String subPartition : publisher.getPartitions())
            {
               if (partition.equals(subPartition))
               {
                  return true;
               }
            }
         }
      }

      return false;
   }
}

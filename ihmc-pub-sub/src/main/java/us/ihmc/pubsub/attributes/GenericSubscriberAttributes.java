package us.ihmc.pubsub.attributes;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import us.ihmc.pubsub.TopicDataType;

import java.util.Collections;
import java.util.List;

@Data
@Builder
public class GenericSubscriberAttributes implements SubscriberAttributes
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
}

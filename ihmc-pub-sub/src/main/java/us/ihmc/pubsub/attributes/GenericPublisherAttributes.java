package us.ihmc.pubsub.attributes;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.common.Time;
import us.ihmc.pubsub.participant.Participant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@Builder
public class GenericPublisherAttributes implements PublisherAttributes
{
   String topicName;
   TopicDataType topicDataType;
   TopicAttributes.TopicKind topicKind;
   @Builder.Default
   OwnerShipPolicyKind ownerShipPolicyKind = OwnerShipPolicyKind.SHARED_OWNERSHIP_QOS;
   String namespace;
   ReliabilityKind reliabilityKind;
   DurabilityKind durabilityKind;
   HistoryQosPolicy.HistoryQosPolicyKind historyQosPolicyKind;
   int historyDepth;
   PublishModeKind publishModeKind;

   @Builder.Default
   List<String> partitions = Collections.emptyList();

   long heartBeatPeriodNsec;
   Time lifespan;
   int userDefinedId;


}

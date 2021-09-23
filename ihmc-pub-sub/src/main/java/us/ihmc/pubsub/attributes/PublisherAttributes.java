package us.ihmc.pubsub.attributes;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.common.Time;
import us.ihmc.pubsub.participant.Participant;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class PublisherAttributes
{
   String topicName;
   TopicDataType topicDataType;
   TopicAttributes.TopicKind topicKind;
   OwnerShipPolicyKind ownerShipPolicyKind;
   String namespace;
   ReliabilityKind reliabilityKind;
   DurabilityKind durabilityKind;
   HistoryQosPolicy.HistoryQosPolicyKind historyQosPolicyKind;
   int historyDepth;
   PublishModeKind publishModeKind;
   List<String> partitions;
   long heartBeatPeriodNsec;
   Time lifespan;
   int userDefinedId;
}

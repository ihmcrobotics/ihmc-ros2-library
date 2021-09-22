package us.ihmc.pubsub.attributes;

import lombok.Builder;
import lombok.Data;
import us.ihmc.pubsub.common.Time;
import us.ihmc.pubsub.participant.Participant;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class PublisherAttributes2
{
   String topicName;
   String namespace;
   ReliabilityKind reliabilityKind;
   DurabilityKind durabilityKind;
   HistoryQosPolicy.HistoryQosPolicyKind historyQosPolicyKind;
   int historyDepth;
   PublishModeKind publishModeKind;
   List<String> partitions;
   long heartBeatPeriodNsec;
   Time lifespan;
}

package us.ihmc.pubsub.attributes;

import lombok.Builder;
import lombok.Data;
import us.ihmc.pubsub.participant.Participant;

import java.util.List;

@Data
@Builder
public class SubscriberAttributes2
{
   String topicName;
   String namespace;
   HistoryQosPolicy.HistoryQosPolicyKind historyQosPolicyKind;
   int historyDepth;
   DurabilityKind durabilityKind;
   ReliabilityKind reliabilityKind;
   List<String> partitions;
}

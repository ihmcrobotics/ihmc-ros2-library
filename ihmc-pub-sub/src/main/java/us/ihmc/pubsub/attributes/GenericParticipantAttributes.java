package us.ihmc.pubsub.attributes;

import lombok.Builder;
import lombok.Data;
import us.ihmc.pubsub.common.Time;

@Data
@Builder
public class GenericParticipantAttributes implements ParticipantAttributes
{
   int domainId;
   String name;
   Time discoveryLeaseDuration;
   boolean discoveryServerEnabled;
   boolean useStaticDiscovery;
   int discoveryServerId;
   String discoveryServerAddress;
   @Builder.Default
   long discoveryServerPort = 11811;
}

package us.ihmc.pubsub.attributes;

import lombok.Builder;
import lombok.Data;
import us.ihmc.pubsub.common.Time;

import java.net.InetAddress;

@Data
@Builder
public class ParticipantAttributes2
{
   long domainId;
   String name;
   Time discoveryLeaseDuration;
   boolean discoveryServerEnabled;
   int discoveryServerId;
   String discoveryServerAddress;
   @Builder.Default
   long discoveryServerPort = 11811;
}

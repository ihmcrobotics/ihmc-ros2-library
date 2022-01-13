package us.ihmc.pubsub.attributes;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;
import us.ihmc.pubsub.common.Time;

import java.net.InetAddress;
import java.util.List;

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
   @Singular List<InetAddress> bindToAddressRestrictions;
   @Builder.Default
   long discoveryServerPort = 11811;
}

package us.ihmc.pubsub.impl.fastRTPS;

import com.eprosima.xmlschemas.fastrtps_profiles.Dds;
import us.ihmc.pubsub.attributes.GenericParticipantAttributes;
import us.ihmc.pubsub.attributes.ParticipantAttributes;

public class FastRTPSParticipantAttributes implements ParticipantAttributes {

    String profileName;
    Dds dds;
    GenericParticipantAttributes genericParticipantAttributes;

    FastRTPSParticipantAttributes(GenericParticipantAttributes genericParticipantAttributes, Dds dds, String profileName){
        this.dds = dds;
        this.genericParticipantAttributes = genericParticipantAttributes;
        this.profileName = profileName;
    }

    @Override
    public int getDomainId() {
        return genericParticipantAttributes.getDomainId();
    }

    public Dds getDds(){
        return dds;
    }
}

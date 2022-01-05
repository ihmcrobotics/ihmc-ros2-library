package us.ihmc.pubsub.impl.fastRTPS;

import com.eprosima.xmlschemas.fastrtps_profiles.Dds;
import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.attributes.GenericPublisherAttributes;
import us.ihmc.pubsub.attributes.PublisherAttributes;
import us.ihmc.pubsub.attributes.TopicAttributes;

public class FastRTPSPublisherAttributes implements PublisherAttributes {

    GenericPublisherAttributes genericPublisherAttributes;
    Dds dds;
    String profileName;

    FastRTPSPublisherAttributes(GenericPublisherAttributes genericPublisherAttributes, Dds dds, String profileName){
        this.genericPublisherAttributes = genericPublisherAttributes;
        this.dds = dds;
        this.profileName = profileName;

    }
    @Override
    public TopicDataType getTopicDataType() {
        return genericPublisherAttributes.getTopicDataType();
    }

    @Override
    public String getTopicName() {
        return genericPublisherAttributes.getTopicName();
    }

    @Override
    public int getUserDefinedId() {
        return genericPublisherAttributes.getUserDefinedId();
    }

    @Override
    public TopicAttributes.TopicKind getTopicKind() {
        return genericPublisherAttributes.getTopicKind();
    }

    public Dds getDds(){
        return dds;
    }
}

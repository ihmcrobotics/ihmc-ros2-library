package us.ihmc.pubsub.impl.fastRTPS;

import com.eprosima.xmlschemas.fastrtps_profiles.Dds;
import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.attributes.GenericSubscriberAttributes;
import us.ihmc.pubsub.attributes.SubscriberAttributes;
import us.ihmc.pubsub.attributes.TopicAttributes;

public class FastRTPSSubscriberAttributes implements SubscriberAttributes {

    GenericSubscriberAttributes genericSubscriberAttributes;
    Dds dds;
    String profileName;

    FastRTPSSubscriberAttributes(GenericSubscriberAttributes genericSubscriberAttributes, Dds dds, String profileName){
        this.genericSubscriberAttributes = genericSubscriberAttributes;
        this.dds = dds;
        this. profileName = profileName;
    }

    @Override
    public TopicDataType getTopicDataType() {
        return genericSubscriberAttributes.getTopicDataType();
    }

    @Override
    public String getTopicName() {
        return genericSubscriberAttributes.getTopicName();
    }

    @Override
    public int getUserDefinedId() {
        return genericSubscriberAttributes.getUserDefinedId();
    }

    @Override
    public TopicAttributes.TopicKind getTopicKind() {
        return genericSubscriberAttributes.getTopicKind();
    }
}

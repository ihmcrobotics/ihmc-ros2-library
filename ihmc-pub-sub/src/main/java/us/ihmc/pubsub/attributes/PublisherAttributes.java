package us.ihmc.pubsub.attributes;

import us.ihmc.pubsub.TopicDataType;

public interface PublisherAttributes {
    public TopicDataType getTopicDataType();
    public String getTopicName();
    public int getUserDefinedId();
    public TopicAttributes.TopicKind getTopicKind();
}

package us.ihmc.pubsub.attributes;

import us.ihmc.pubsub.TopicDataType;

public interface SubscriberAttributes {
    public TopicDataType getTopicDataType();
    public String getTopicName();
    public int getUserDefinedId();
    public TopicAttributes.TopicKind getTopicKind();
}

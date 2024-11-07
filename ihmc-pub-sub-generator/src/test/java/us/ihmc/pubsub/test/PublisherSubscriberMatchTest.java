package us.ihmc.pubsub.test;

import com.eprosima.xmlschemas.fastrtps_profiles.DurabilityQosKindPolicyType;
import com.eprosima.xmlschemas.fastrtps_profiles.ReliabilityQosKindPolicyType;
import org.junit.jupiter.api.Test;
import us.ihmc.idl.generated.chat.ChatMessagePubSubType;
import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.attributes.PublisherAttributes;
import us.ihmc.pubsub.attributes.SubscriberAttributes;
import us.ihmc.pubsub.impl.intraprocess.IntraProcessUtil;

import static org.junit.jupiter.api.Assertions.*;

public class PublisherSubscriberMatchTest
{
   @Test
   public void TestMatchingAttributes()
   {
      TopicDataType topicDataType = new ChatMessagePubSubType();

      SubscriberAttributes subscriberAttributes = SubscriberAttributes.create()
       .topicName("TOPIC")
       .topicDataType(topicDataType)
       .reliabilityKind(ReliabilityQosKindPolicyType.RELIABLE)
       .durabilityKind(DurabilityQosKindPolicyType.VOLATILE);

      PublisherAttributes genericPublisherAttributes = PublisherAttributes.create()
       .topicName("TOPIC")
       .topicDataType(topicDataType)
       .reliabilityKind(ReliabilityQosKindPolicyType.RELIABLE)
       .durabilityKind(DurabilityQosKindPolicyType.VOLATILE);

      assertTrue(IntraProcessUtil.subscriberPublisherMatches(subscriberAttributes, genericPublisherAttributes));
   }
}

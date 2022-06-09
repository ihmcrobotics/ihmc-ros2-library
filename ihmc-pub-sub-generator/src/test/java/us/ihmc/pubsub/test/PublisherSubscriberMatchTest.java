package us.ihmc.pubsub.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.eprosima.xmlschemas.fastrtps_profiles.DurabilityQosKindType;
import com.eprosima.xmlschemas.fastrtps_profiles.ReliabilityQosKindType;

import us.ihmc.idl.generated.chat.ChatMessagePubSubType;
import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.attributes.PublisherAttributes;
import us.ihmc.pubsub.attributes.SubscriberAttributes;
import us.ihmc.pubsub.impl.intraprocess.IntraProcessUtil;

public class PublisherSubscriberMatchTest
{

   @Test
   public void TestMatchingAttributes()
   {
      TopicDataType topicDataType = new ChatMessagePubSubType();

      SubscriberAttributes subscriberAttributes = SubscriberAttributes.create()
       .topicName("TOPIC")
       .topicDataType(topicDataType)
       .reliabilityKind(ReliabilityQosKindType.RELIABLE)
       .durabilityKind(DurabilityQosKindType.VOLATILE);

      PublisherAttributes genericPublisherAttributes = PublisherAttributes.create()
       .topicName("TOPIC")
       .topicDataType(topicDataType)
       .reliabilityKind(ReliabilityQosKindType.RELIABLE)
       .durabilityKind(DurabilityQosKindType.VOLATILE);

      assertTrue(IntraProcessUtil.subscriberPublisherMatches(subscriberAttributes, genericPublisherAttributes));

   }
}

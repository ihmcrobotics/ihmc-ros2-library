package us.ihmc.pubsub.test;

import org.junit.jupiter.api.Test;
import us.ihmc.idl.generated.chat.ChatMessagePubSubType;
import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.attributes.DurabilityKind;
import us.ihmc.pubsub.attributes.PublisherAttributes;
import us.ihmc.pubsub.attributes.ReliabilityKind;
import us.ihmc.pubsub.attributes.SubscriberAttributes;
import us.ihmc.pubsub.impl.intraprocess.IntraProcessUtil;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PublisherSubscriberMatchTest
{

   @Test
   public void TestMatchingAttributes()
   {
      TopicDataType topicDataType = new ChatMessagePubSubType();

      SubscriberAttributes subscriberAttributes = SubscriberAttributes.builder()
                                                                      .topicName("TOPIC")
                                                                      .topicDataType(topicDataType)
                                                                      .reliabilityKind(ReliabilityKind.RELIABLE)
                                                                      .durabilityKind(DurabilityKind.VOLATILE_DURABILITY_QOS)
                                                                      .build();

      PublisherAttributes publisherAttributes = PublisherAttributes.builder()
                                                                   .topicName("TOPIC")
                                                                   .topicDataType(topicDataType)
                                                                   .reliabilityKind(ReliabilityKind.RELIABLE)
                                                                   .durabilityKind(DurabilityKind.VOLATILE_DURABILITY_QOS)
                                                                   .build();

      assertTrue(IntraProcessUtil.subscriberPublisherMatches(subscriberAttributes, publisherAttributes));

   }
}

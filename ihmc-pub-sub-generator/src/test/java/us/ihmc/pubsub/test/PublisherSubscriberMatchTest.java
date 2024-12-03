package us.ihmc.pubsub.test;

import com.eprosima.xmlschemas.fastrtps_profiles.DurabilityQosKindPolicyType;
import com.eprosima.xmlschemas.fastrtps_profiles.ReliabilityQosKindPolicyType;
import org.junit.jupiter.api.Test;
import us.ihmc.idl.generated.chat.ChatMessagePubSubType;
import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.attributes.PublisherAttributes;
import us.ihmc.pubsub.attributes.SubscriberAttributes;

import static org.junit.jupiter.api.Assertions.*;

public class PublisherSubscriberMatchTest
{
   @Test
   public void testMatchingAttributes()
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

      assertTrue(subscriberPublisherMatches(subscriberAttributes, genericPublisherAttributes));
   }

   private static boolean subscriberPublisherMatches(SubscriberAttributes subscriberAttributes, PublisherAttributes publisherAttributes)
   {
      if (!subscriberAttributes.getTopicName().equals(publisherAttributes.getTopicName()))
         return false;

      if (!subscriberAttributes.getTopicDataType().getClass().equals(publisherAttributes.getTopicDataType().getClass()))
         return false;

      if (subscriberAttributes.getOwnerShipPolicyKind() != publisherAttributes.getOwnerShipPolicyKind())
         return false;

      if (publisherAttributes.getReliabilityKind() == ReliabilityQosKindPolicyType.BEST_EFFORT && subscriberAttributes.getReliabilityKind() == ReliabilityQosKindPolicyType.RELIABLE)
         return false;

      if (publisherAttributes.getDurabilityKind() == DurabilityQosKindPolicyType.TRANSIENT_LOCAL
          && subscriberAttributes.getDurabilityKind() == DurabilityQosKindPolicyType.VOLATILE)
         return false;

      if (subscriberAttributes.getPartitions().isEmpty() && publisherAttributes.getPartitions().isEmpty())
      {
         return true;
      }
      else
      {
         for (String partition : subscriberAttributes.getPartitions())
         {
            for (String subPartition : publisherAttributes.getPartitions())
            {
               if (partition.equals(subPartition))
               {
                  return true;
               }
            }
         }
      }

      return false;
   }
}

package us.ihmc.pubsub.impl.intraprocess;

import us.ihmc.pubsub.attributes.DurabilityKind;
import us.ihmc.pubsub.attributes.PublisherAttributes;
import us.ihmc.pubsub.attributes.ReliabilityKind;
import us.ihmc.pubsub.attributes.SubscriberAttributes;

public class IntraProcessUtil {
    public static boolean subscriberPublisherMatches(SubscriberAttributes subscriberAttributes, PublisherAttributes publisherAttributes)
    {
        if (!subscriberAttributes.getTopicName().equals(publisherAttributes.getTopicName()))
            return false;

        if (!subscriberAttributes.getTopicDataType().getClass().equals(publisherAttributes.getTopicDataType().getClass()))
            return false;

        if (subscriberAttributes.getOwnerShipPolicyKind() != publisherAttributes.getOwnerShipPolicyKind())
            return false;

        if (publisherAttributes.getReliabilityKind() == ReliabilityKind.BEST_EFFORT && subscriberAttributes.getReliabilityKind() == ReliabilityKind.RELIABLE)
            return false;

        if (publisherAttributes.getDurabilityKind() == DurabilityKind.TRANSIENT_LOCAL_DURABILITY_QOS
                && subscriberAttributes.getDurabilityKind() == DurabilityKind.VOLATILE_DURABILITY_QOS)
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

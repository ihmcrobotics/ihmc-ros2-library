package us.ihmc.pubsub.impl.intraprocess;

import us.ihmc.pubsub.attributes.GenericPublisherAttributes;
import us.ihmc.pubsub.attributes.GenericSubscriberAttributes;
import us.ihmc.pubsub.attributes.DurabilityKind;
import us.ihmc.pubsub.attributes.ReliabilityKind;

public class IntraProcessUtil {
    public static boolean subscriberPublisherMatches(GenericSubscriberAttributes genericSubscriberAttributes, GenericPublisherAttributes genericPublisherAttributes)
    {
        if (!genericSubscriberAttributes.getTopicName().equals(genericPublisherAttributes.getTopicName()))
            return false;

        if (!genericSubscriberAttributes.getTopicDataType().getClass().equals(genericPublisherAttributes.getTopicDataType().getClass()))
            return false;

        if (genericSubscriberAttributes.getOwnerShipPolicyKind() != genericPublisherAttributes.getOwnerShipPolicyKind())
            return false;

        if (genericPublisherAttributes.getReliabilityKind() == ReliabilityKind.BEST_EFFORT && genericSubscriberAttributes.getReliabilityKind() == ReliabilityKind.RELIABLE)
            return false;

        if (genericPublisherAttributes.getDurabilityKind() == DurabilityKind.TRANSIENT_LOCAL_DURABILITY_QOS
                && genericSubscriberAttributes.getDurabilityKind() == DurabilityKind.VOLATILE_DURABILITY_QOS)
            return false;

        if (genericSubscriberAttributes.getPartitions().isEmpty() && genericPublisherAttributes.getPartitions().isEmpty())
        {
            return true;
        }
        else
        {
            for (String partition : genericSubscriberAttributes.getPartitions())
            {
                for (String subPartition : genericPublisherAttributes.getPartitions())
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

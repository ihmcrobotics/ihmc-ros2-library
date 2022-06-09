package us.ihmc.pubsub.impl.intraprocess;

import com.eprosima.xmlschemas.fastrtps_profiles.DurabilityQosKindType;
import com.eprosima.xmlschemas.fastrtps_profiles.ReliabilityQosKindType;

import us.ihmc.pubsub.attributes.PublisherAttributes;
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

        if (publisherAttributes.getReliabilityKind() == ReliabilityQosKindType.BEST_EFFORT && subscriberAttributes.getReliabilityKind() == ReliabilityQosKindType.RELIABLE)
            return false;

        if (publisherAttributes.getDurabilityKind() == DurabilityQosKindType.TRANSIENT_LOCAL
                && subscriberAttributes.getDurabilityKind() == DurabilityQosKindType.VOLATILE)
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

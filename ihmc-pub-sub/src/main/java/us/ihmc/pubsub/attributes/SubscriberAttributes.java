package us.ihmc.pubsub.attributes;

import com.eprosima.xmlschemas.fastrtps_profiles.*;
import us.ihmc.pubsub.impl.fastRTPS.FastRTPSDomain;

import java.io.IOException;

public class SubscriberAttributes extends CommonAttributes<SubscriberAttributes>
{
   private final SubscriberProfileType subscriberProfile = new SubscriberProfileType();

   public SubscriberAttributes()
   {
      DataReaderQosPoliciesType dataReaderQosPoliciesType = new DataReaderQosPoliciesType();
      dataReaderQosPoliciesType.setDurability(durabilityQosPolicyType);
      dataReaderQosPoliciesType.setReliability(reliabilityQosPolicyType);
      subscriberProfile.setQos(dataReaderQosPoliciesType);

      subscriberProfile.setTopic(topicElementType);
   }

   public static SubscriberAttributes create()
   {
      return new SubscriberAttributes();
   }

   public SubscriberAttributes userDefinedId(short id)
   {
      subscriberProfile.setUserDefinedID(id);
      return this;
   }

   public short getUserDefinedId()
   {
      return subscriberProfile.getUserDefinedID();
   }

   public String marshall(String profileName) throws IOException
   {
      subscriberProfile.setProfileName(profileName);

      ProfilesType profilesType = new ProfilesType();
      profilesType.getDomainparticipantFactoryOrParticipantOrDataWriter().add(subscriberProfile);

      return FastRTPSDomain.marshalProfile(profilesType);
   }

   @Override
   protected void setPartitionQosPolicyType(PartitionQosPolicyType partitionQosPolicyType)
   {
      subscriberProfile.getQos().setPartition(partitionQosPolicyType);
   }

   @Override
   protected PartitionQosPolicyType getPartitionQosPolicyType()
   {
      return subscriberProfile.getQos().getPartition();
   }

   @Override
   protected void setLifespanQosPolicyType(LifespanQosPolicyType lifespanQosPolicyType)
   {
      subscriberProfile.getQos().setLifespan(lifespanQosPolicyType);
   }

   @Override
   protected LifespanQosPolicyType getLifespanQosPolicyType()
   {
      return subscriberProfile.getQos().getLifespan();
   }
}

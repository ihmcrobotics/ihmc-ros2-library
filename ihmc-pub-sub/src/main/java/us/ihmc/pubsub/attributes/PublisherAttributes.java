package us.ihmc.pubsub.attributes;

import com.eprosima.xmlschemas.fastrtps_profiles.*;
import us.ihmc.pubsub.common.Time;
import us.ihmc.pubsub.impl.fastRTPS.FastRTPSDomain;

import java.io.IOException;

public class PublisherAttributes extends CommonAttributes<PublisherAttributes>
{
   private final PublisherProfileType publisherProfile = new PublisherProfileType();

   public PublisherAttributes()
   {
      DataWriterQosPoliciesType dataWriterQosPoliciesType = new DataWriterQosPoliciesType();
      dataWriterQosPoliciesType.setDurability(durabilityQosPolicyType);
      dataWriterQosPoliciesType.setReliability(reliabilityQosPolicyType);
      publisherProfile.setQos(dataWriterQosPoliciesType);

      publisherProfile.setTopic(topicElementType);
   }

   public static PublisherAttributes create()
   {
      return new PublisherAttributes();
   }

   /**
    * Get the raw XML profile, to allow access to all settings
    * 
    * @return
    */
   public PublisherProfileType getProfile()
   {
      return publisherProfile;
   }

   public PublisherAttributes publishModeKind(PublishModeQosKindPolicyType kind)
   {
      PublishModeQosPolicyType publishModeQosPolicyType = new PublishModeQosPolicyType();
      publishModeQosPolicyType.setKind(kind);
      publisherProfile.getQos().setPublishMode(publishModeQosPolicyType);

      return this;
   }

   public PublisherAttributes userDefinedId(short id)
   {
      publisherProfile.setUserDefinedID(id);
      return this;
   }

   public short getUserDefinedId()
   {
      return publisherProfile.getUserDefinedID();
   }

   public PublisherAttributes heartBeatPeriod(Time hearbeat)
   {
      if(publisherProfile.getTimes() == null)
      {
         publisherProfile.setTimes(new WriterTimesType());
      }
      
      publisherProfile.getTimes().setHeartbeatPeriod(DDSConversionTools.timeToDurationType(hearbeat));

      return this;
   }
   

   public String marshall(String profileName) throws IOException
   {
      publisherProfile.setProfileName(profileName);

      ProfilesType profilesType = new ProfilesType();
      profilesType.getDomainparticipantFactoryOrParticipantOrDataWriter().add(publisherProfile);

      return FastRTPSDomain.marshalProfile(profilesType);
   }

   @Override
   protected void setPartitionQosPolicyType(PartitionQosPolicyType partitionQosPolicyType)
   {
      publisherProfile.getQos().setPartition(partitionQosPolicyType);
   }

   @Override
   protected PartitionQosPolicyType getPartitionQosPolicyType()
   {
      return publisherProfile.getQos().getPartition();
   }

   @Override
   protected void setLifespanQosPolicyType(LifespanQosPolicyType lifespanQosPolicyType)
   {
      publisherProfile.getQos().setLifespan(lifespanQosPolicyType);
   }

   @Override
   protected LifespanQosPolicyType getLifespanQosPolicyType()
   {
      return publisherProfile.getQos().getLifespan();
   }
}

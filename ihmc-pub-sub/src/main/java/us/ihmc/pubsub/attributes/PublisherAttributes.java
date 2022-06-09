package us.ihmc.pubsub.attributes;

import java.io.IOException;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import com.eprosima.xmlschemas.fastrtps_profiles.LifespanQosPolicyType;
import com.eprosima.xmlschemas.fastrtps_profiles.PartitionQosPolicyType;
import com.eprosima.xmlschemas.fastrtps_profiles.ProfilesType;
import com.eprosima.xmlschemas.fastrtps_profiles.PublishModeQosKindType;
import com.eprosima.xmlschemas.fastrtps_profiles.PublishModeQosPolicyType;
import com.eprosima.xmlschemas.fastrtps_profiles.PublisherProfileType;
import com.eprosima.xmlschemas.fastrtps_profiles.WriterQosPoliciesType;

import us.ihmc.pubsub.impl.fastRTPS.FastRTPSDomain;

public class PublisherAttributes extends CommonAttributes<PublisherAttributes>
{
   private final PublisherProfileType publisherProfile = new PublisherProfileType();

   public PublisherAttributes()
   {
      publisherProfile.setTopic(topicAttributesType);

      WriterQosPoliciesType writerQosPoliciesType = new WriterQosPoliciesType();
      writerQosPoliciesType.setDurability(durabilityQosPolicyType);
      writerQosPoliciesType.setReliability(reliabilityQosPolicyType);
      publisherProfile.setQos(writerQosPoliciesType);

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



   public PublisherAttributes publishModeKind(PublishModeQosKindType kind)
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
   
   

   public String marshall(String profileName) throws IOException
   {
      ProfilesType profilesType = new ProfilesType();
      profilesType.getLibrarySettingsOrTransportDescriptorsOrParticipant()
                  .add(new JAXBElement<>(new QName(FastRTPSDomain.FAST_DDS_XML_NAMESPACE, FastRTPSDomain.FAST_DDS_PUBLISHER),
                                         PublisherProfileType.class,
                                         publisherProfile));
      publisherProfile.setProfileName(profileName);

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

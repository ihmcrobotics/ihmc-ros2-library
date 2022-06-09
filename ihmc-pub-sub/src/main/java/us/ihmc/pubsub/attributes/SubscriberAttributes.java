package us.ihmc.pubsub.attributes;

import java.io.IOException;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import com.eprosima.xmlschemas.fastrtps_profiles.LifespanQosPolicyType;
import com.eprosima.xmlschemas.fastrtps_profiles.PartitionQosPolicyType;
import com.eprosima.xmlschemas.fastrtps_profiles.ProfilesType;
import com.eprosima.xmlschemas.fastrtps_profiles.ReaderQosPoliciesType;
import com.eprosima.xmlschemas.fastrtps_profiles.SubscriberProfileType;

import us.ihmc.pubsub.impl.fastRTPS.FastRTPSDomain;

public class SubscriberAttributes extends CommonAttributes<SubscriberAttributes>
{
   private final SubscriberProfileType subscriberProfile = new SubscriberProfileType();

   public SubscriberAttributes()
   {
      subscriberProfile.setTopic(topicAttributesType);

      ReaderQosPoliciesType readerQosPoliciesType = new ReaderQosPoliciesType();
      readerQosPoliciesType.setDurability(durabilityQosPolicyType);
      readerQosPoliciesType.setReliability(reliabilityQosPolicyType);
      subscriberProfile.setQos(readerQosPoliciesType);
   }

   public static SubscriberAttributes builder()
   {
      return new SubscriberAttributes();
   }

   public SubscriberAttributes build()
   {
      return this;
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
      ProfilesType profilesType = new ProfilesType();
      profilesType.getLibrarySettingsOrTransportDescriptorsOrParticipant()
                  .add(new JAXBElement<>(new QName(FastRTPSDomain.FAST_DDS_XML_NAMESPACE, FastRTPSDomain.FAST_DDS_SUBSCRIBER),
                                         SubscriberProfileType.class,
                                         subscriberProfile));
      subscriberProfile.setProfileName(profileName);

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

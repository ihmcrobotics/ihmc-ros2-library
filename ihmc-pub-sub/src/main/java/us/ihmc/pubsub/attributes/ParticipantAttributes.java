package us.ihmc.pubsub.attributes;

import java.io.IOException;
import java.net.InetAddress;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import com.eprosima.xmlschemas.fastrtps_profiles.BuiltinAttributesType;
import com.eprosima.xmlschemas.fastrtps_profiles.DiscoveryProtocol;
import com.eprosima.xmlschemas.fastrtps_profiles.DiscoveryServerList;
import com.eprosima.xmlschemas.fastrtps_profiles.DiscoverySettingsType;
import com.eprosima.xmlschemas.fastrtps_profiles.DurationType;
import com.eprosima.xmlschemas.fastrtps_profiles.EDPType;
import com.eprosima.xmlschemas.fastrtps_profiles.LocatorListType;
import com.eprosima.xmlschemas.fastrtps_profiles.LocatorType;
import com.eprosima.xmlschemas.fastrtps_profiles.ParticipantProfileType;
import com.eprosima.xmlschemas.fastrtps_profiles.ProfilesType;
import com.eprosima.xmlschemas.fastrtps_profiles.RemoteServerAttributes;
import com.eprosima.xmlschemas.fastrtps_profiles.RtpsParticipantAttributesType;
import com.eprosima.xmlschemas.fastrtps_profiles.Udpv4LocatorType;

import us.ihmc.pubsub.common.Time;
import us.ihmc.pubsub.impl.fastRTPS.FastRTPSDomain;

public class ParticipantAttributes
{
   private final ParticipantProfileType participantProfile = new ParticipantProfileType();

   public ParticipantAttributes()
   {
      // Create default elements for participant profile
      RtpsParticipantAttributesType rtps = new RtpsParticipantAttributesType();
      BuiltinAttributesType builtin = new BuiltinAttributesType();
      DiscoverySettingsType discoverySettingsType = new DiscoverySettingsType();

      participantProfile.setRtps(rtps);
      rtps.setBuiltin(builtin);
      builtin.setDiscoveryConfig(discoverySettingsType);

      // Set default discovery duration
      discoveryLeaseDuration(Time.Infinite);
   }
   
   /**
    * Helper function to use a builder-like approach
    * 
    * @return new intance of ParticipantAttributes
    */
   public static ParticipantAttributes create()
   {
      return new ParticipantAttributes();
   }
   
   /**
    * Direct access to the participant profile. This allows the user to access all settings
    * 
    * @return Participant profile XML structure
    */
   public ParticipantProfileType getProfile()
   {
      return participantProfile;
   }

   public ParticipantAttributes domainId(int id)
   {
      participantProfile.setDomainId((long) id);
      return this;
   }

   public int getDomainId()
   {
      return participantProfile.getDomainId().intValue();
   }

   public ParticipantAttributes name(String name)
   {
      participantProfile.getRtps().setName(name);
      return this;
   }

   public String getName()
   {
      return participantProfile.getRtps().getName();
   }

   public ParticipantAttributes discoveryLeaseDuration(Time discoveryLeaseDuration)
   {
      DurationType dt = new DurationType();
      dt.getContent()
        .add(new JAXBElement<>(new QName(FastRTPSDomain.FAST_DDS_XML_NAMESPACE, FastRTPSDomain.FAST_DDS_NANOSEC),
                               Long.class,
                               discoveryLeaseDuration.getNanoseconds()));
      dt.getContent()
        .add(new JAXBElement<>(new QName(FastRTPSDomain.FAST_DDS_XML_NAMESPACE, FastRTPSDomain.FAST_DDS_SEC),
                               Integer.class,
                               discoveryLeaseDuration.getSeconds()));

      participantProfile.getRtps().getBuiltin().getDiscoveryConfig().setLeaseDuration(dt);
      return this;
   }

   public ParticipantAttributes discoveryServer(String discoveryServerAddress, int discoveryServerId)
   {
      return discoveryServer(discoveryServerAddress, discoveryServerId, 11811);
   }

   public ParticipantAttributes discoveryServer(String discoveryServerAddress, int discoveryServerId, int discoveryServerPort)
   {
      DiscoverySettingsType discoverySettingsType = participantProfile.getRtps().getBuiltin().getDiscoveryConfig();
      DiscoveryServerList discoveryServerList = new DiscoveryServerList();
      discoverySettingsType.setDiscoveryProtocol(DiscoveryProtocol.CLIENT);

      RemoteServerAttributes remoteServerAttributes = new RemoteServerAttributes();
      LocatorListType locatorListType = new LocatorListType();
      LocatorType locatorType = new LocatorType();
      Udpv4LocatorType udpv4LocatorType = new Udpv4LocatorType();
      udpv4LocatorType.setAddress(discoveryServerAddress);
      udpv4LocatorType.setPort((long) discoveryServerPort);
      locatorType.setUdpv4(udpv4LocatorType);
      locatorListType.getLocator().add(locatorType);

      remoteServerAttributes.getContent()
                            .add(new JAXBElement<>(new QName(FastRTPSDomain.FAST_DDS_XML_NAMESPACE, FastRTPSDomain.FAST_DDS_METATRAFFIC_UNICAST_LOCATOR_LIST),
                                                   LocatorListType.class,
                                                   locatorListType));

      remoteServerAttributes.setPrefix(String.format(FastRTPSDomain.FAST_DDS_DISCOVERY_CONFIGURABLE_PREFIX, discoverySettingsType));
      discoveryServerList.getRemoteServer().add(remoteServerAttributes);
      discoverySettingsType.setDiscoveryServersList(discoveryServerList);

      return this;
   }

   public ParticipantAttributes bindToAddressRestrictions(List<InetAddress> bindToAddressRestrictions)
   {
      if (bindToAddressRestrictions != null && !bindToAddressRestrictions.isEmpty())
      {
         LocatorListType locatorList = new LocatorListType();
         for (InetAddress addr : bindToAddressRestrictions)
         {
            LocatorType locator = new LocatorType();
            Udpv4LocatorType udpv4locator = new Udpv4LocatorType();
            udpv4locator.setAddress(addr.getHostAddress());
            locator.setUdpv4(udpv4locator);
            locatorList.getLocator().add(locator);
         }
         participantProfile.getRtps().setDefaultUnicastLocatorList(locatorList);
      }
      
      return this;
   }
   


   public boolean isUseStaticDiscovery()
   {
      return participantProfile.getRtps().getBuiltin().getDiscoveryConfig().getEDP() == EDPType.STATIC;
   }
   
   public ParticipantAttributes useStaticDiscovery(boolean useStaticDiscovery)
   {
      participantProfile.getRtps().getBuiltin().getDiscoveryConfig().setEDP(useStaticDiscovery ? EDPType.STATIC : EDPType.SIMPLE);
      return this;
   }

   /**
    * Marshall this profile to a XML structure
    * 
    * @param profileName Unique name for this profile
    * @return XML representation of this profile
    * @throws IOException 
    */
   public String marshall(String profileName) throws IOException
   {
      ProfilesType profilesType = new ProfilesType();
      profilesType.getLibrarySettingsOrTransportDescriptorsOrParticipant()
                  .add(new JAXBElement<>(new QName(FastRTPSDomain.FAST_DDS_XML_NAMESPACE, FastRTPSDomain.FAST_DDS_PARTICIPANT),
                                         ParticipantProfileType.class,
                                         participantProfile));
      participantProfile.setProfileName(profileName);
      
      return FastRTPSDomain.marshalProfile(profilesType);
   }
}

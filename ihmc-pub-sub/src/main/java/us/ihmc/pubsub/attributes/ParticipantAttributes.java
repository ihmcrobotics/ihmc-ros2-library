package us.ihmc.pubsub.attributes;

import java.io.IOException;
import java.net.InetAddress;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import com.eprosima.xmlschemas.fastrtps_profiles.BuiltinAttributesType;
import com.eprosima.xmlschemas.fastrtps_profiles.DiscoveryProtocol;
import com.eprosima.xmlschemas.fastrtps_profiles.DiscoveryServerList;
import com.eprosima.xmlschemas.fastrtps_profiles.DiscoverySettingsType;
import com.eprosima.xmlschemas.fastrtps_profiles.EDPType;
import com.eprosima.xmlschemas.fastrtps_profiles.LocatorListType;
import com.eprosima.xmlschemas.fastrtps_profiles.LocatorType;
import com.eprosima.xmlschemas.fastrtps_profiles.ParticipantProfileType;
import com.eprosima.xmlschemas.fastrtps_profiles.ProfilesType;
import com.eprosima.xmlschemas.fastrtps_profiles.RemoteServerAttributes;
import com.eprosima.xmlschemas.fastrtps_profiles.RtpsParticipantAttributesType;
import com.eprosima.xmlschemas.fastrtps_profiles.RtpsTransportDescriptorType;
import com.eprosima.xmlschemas.fastrtps_profiles.StringListType;
import com.eprosima.xmlschemas.fastrtps_profiles.TransportDescriptorListType;
import com.eprosima.xmlschemas.fastrtps_profiles.Udpv4LocatorType;

import us.ihmc.pubsub.common.Time;
import us.ihmc.pubsub.impl.fastRTPS.FastRTPSDomain;

public class ParticipantAttributes
{
   private final ParticipantProfileType participantProfile = new ParticipantProfileType();
   private final TransportDescriptorListType transportDescriptors = new TransportDescriptorListType();

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

      participantProfile.getRtps().getBuiltin().getDiscoveryConfig().setLeaseDuration(DDSConversionTools.timeToDurationType(discoveryLeaseDuration));
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
   
   
   /**
    * Add a transport to use with this participant and register it to this participant
    * 
    * 
    * @param transport
    * @return
    */
   public ParticipantAttributes addTransport(RtpsTransportDescriptorType transport)
   {
      transportDescriptors.getTransportDescriptor().add(transport);
      
      if(participantProfile.getRtps().getUserTransports() == null)
      {
         participantProfile.getRtps().setUserTransports(new StringListType());
      }
      participantProfile.getRtps().getUserTransports().getId().add(transport.getTransportId());
      
      return this;
   }
   
   /**
    * Add a shared memory transport to this participant.
    * 
    * By setting useBuiltinTransports to false, you can use only a shared memory transport
    *  
    * @return
    */
   public ParticipantAttributes addSharedMemoryTransport()
   {
      String transportName = UUID.randomUUID().toString();
      RtpsTransportDescriptorType transportDescriptor = new RtpsTransportDescriptorType();
      transportDescriptor.setTransportId(transportName);
      transportDescriptor.setType("SHM");
      
      addTransport(transportDescriptor);
      
      return this;
   }
   
   public ParticipantAttributes useBuiltinTransports(boolean useBuiltinTransports)
   {
      participantProfile.getRtps().setUseBuiltinTransports(useBuiltinTransports);
      return this;
   }
   
   public boolean isUseBuiltinTransports()
   {
      return participantProfile.getRtps().isUseBuiltinTransports();
   }
   
   /**
    * Helper function to disable all transports and use only the shared memory transport
    * @return
    */
   public ParticipantAttributes useOnlySharedMemoryTransport()
   {
      useBuiltinTransports(false);
      addSharedMemoryTransport();
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
      .add(new JAXBElement<>(new QName(FastRTPSDomain.FAST_DDS_XML_NAMESPACE, FastRTPSDomain.FAST_DDS_TRANSPORT),
                             TransportDescriptorListType.class,
                             transportDescriptors));
      
      profilesType.getLibrarySettingsOrTransportDescriptorsOrParticipant()
                  .add(new JAXBElement<>(new QName(FastRTPSDomain.FAST_DDS_XML_NAMESPACE, FastRTPSDomain.FAST_DDS_PARTICIPANT),
                                         ParticipantProfileType.class,
                                         participantProfile));

      participantProfile.setProfileName(profileName);
      
      
      /*
       * There is a bug in the generation of teh xsd, and inside userTranports, the list spits out <id> tags instead of <transport_id> tags. 
       * This uses a horrible regex to fix that. Hopefully there are no "other" <id> tags
       */
      String profileXML =FastRTPSDomain.marshalProfile(profilesType); 
      profileXML = Pattern.compile("<id>(.*)<\\/id>").matcher(profileXML).replaceAll("<transport_id>$1<\\/transport_id>");

      return profileXML;
   }
}

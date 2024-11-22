package us.ihmc.pubsub.attributes;

import com.eprosima.xmlschemas.fastrtps_profiles.BuiltinAttributesType;
import com.eprosima.xmlschemas.fastrtps_profiles.Dds;
import com.eprosima.xmlschemas.fastrtps_profiles.DiscoveryProtocolType;
import com.eprosima.xmlschemas.fastrtps_profiles.DiscoveryServersListType;
import com.eprosima.xmlschemas.fastrtps_profiles.DiscoverySettingsType;
import com.eprosima.xmlschemas.fastrtps_profiles.EDPType;
import com.eprosima.xmlschemas.fastrtps_profiles.LibrarySettingsType;
import com.eprosima.xmlschemas.fastrtps_profiles.LocatorListType;
import com.eprosima.xmlschemas.fastrtps_profiles.LocatorListType.Locator;
import com.eprosima.xmlschemas.fastrtps_profiles.ParticipantProfileType;
import com.eprosima.xmlschemas.fastrtps_profiles.ParticipantProfileType.Rtps;
import com.eprosima.xmlschemas.fastrtps_profiles.ParticipantProfileType.Rtps.UserTransports;
import com.eprosima.xmlschemas.fastrtps_profiles.ProfilesType;
import com.eprosima.xmlschemas.fastrtps_profiles.RemoteServerAttributesType;
import com.eprosima.xmlschemas.fastrtps_profiles.TransportDescriptorListType;
import com.eprosima.xmlschemas.fastrtps_profiles.TransportDescriptorType;
import com.eprosima.xmlschemas.fastrtps_profiles.TransportDescriptorType.InterfaceWhiteList;
import com.eprosima.xmlschemas.fastrtps_profiles.Udpv4LocatorType;
import jakarta.xml.bind.JAXBElement;
import us.ihmc.pubsub.common.Time;
import us.ihmc.pubsub.impl.fastRTPS.FastRTPSDomain;

import javax.xml.namespace.QName;
import java.io.IOException;
import java.net.InetAddress;
import java.util.UUID;

public class ParticipantProfile
{
   private final ParticipantProfileType participantProfile = new ParticipantProfileType();
   private final TransportDescriptorListType transportDescriptors = new TransportDescriptorListType();
   private final LibrarySettingsType librarySettings = new LibrarySettingsType();

   public ParticipantProfile()
   {
      // Create default elements for participant profile
      BuiltinAttributesType builtin = new BuiltinAttributesType();
      DiscoverySettingsType discoverySettingsType = new DiscoverySettingsType();
      builtin.setDiscoveryConfig(discoverySettingsType);

      participantProfile.setRtps(new Rtps());
      participantProfile.getRtps().setBuiltin(builtin);

      // Set default discovery duration
      discoveryLeaseDuration(Time.Infinite);

      useIntraProcessDelivery(true);
   }

   /**
    * Helper function to use a builder-like approach
    *
    * @return new intance of ParticipantAttributes
    */
   public static ParticipantProfile create()
   {
      return new ParticipantProfile();
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

   public ParticipantProfile domainId(int id)
   {
      participantProfile.setDomainId(id);
      return this;
   }

   public int getDomainId()
   {
      return getProfile().getDomainId();
   }

   public ParticipantProfile name(String name)
   {
      participantProfile.getRtps().setName(name);
      return this;
   }

   public String getName()
   {
      return participantProfile.getRtps().getName();
   }

   public ParticipantProfile discoveryLeaseDuration(Time discoveryLeaseDuration)
   {
      participantProfile.getRtps().getBuiltin().getDiscoveryConfig().setLeaseDuration(DDSConversionTools.timeToDurationType(discoveryLeaseDuration));
      return this;
   }

   public ParticipantProfile discoveryServer(String discoveryServerAddress, int discoveryServerId)
   {
      return discoveryServer(discoveryServerAddress, discoveryServerId, FastRTPSDomain.DEFAULT_DISCOVERY_SERVER_PORT);
   }

   public ParticipantProfile discoveryServer(String discoveryServerAddress, int discoveryServerId, int discoveryServerPort)
   {
      if (discoveryServerId < 0 || discoveryServerId > 255)
      {
         throw new RuntimeException("Invalid discovery server ID");
      }

      if (discoveryServerPort < 0 || discoveryServerPort > 65535)
      {
         throw new RuntimeException("Invalid discovery server port");
      }

      DiscoverySettingsType discoverySettingsType = participantProfile.getRtps().getBuiltin().getDiscoveryConfig();
      discoverySettingsType.setDiscoveryProtocol(DiscoveryProtocolType.CLIENT);

      LocatorListType locatorListType = new LocatorListType();
      LocatorListType.Locator locatorType = new Locator();
      Udpv4LocatorType udpv4LocatorType = new Udpv4LocatorType();
      udpv4LocatorType.setAddress(discoveryServerAddress);
      udpv4LocatorType.setPort(discoveryServerPort);
      locatorType.getUdpv4().add(udpv4LocatorType);
      locatorListType.getLocator().add(locatorType);

      RemoteServerAttributesType remoteServerAttributes = new RemoteServerAttributesType();
      remoteServerAttributes.getContent()
                            .add(new JAXBElement<>(new QName(FastRTPSDomain.FAST_DDS_XML_NAMESPACE, FastRTPSDomain.FAST_DDS_METATRAFFIC_UNICAST_LOCATOR_LIST),
                                                   LocatorListType.class,
                                                   locatorListType));
      remoteServerAttributes.setPrefix(String.format(FastRTPSDomain.FAST_DDS_DISCOVERY_CONFIGURABLE_PREFIX, discoveryServerId));

      DiscoveryServersListType discoveryServerList = participantProfile.getRtps().getBuiltin().getDiscoveryConfig().getDiscoveryServersList();
      discoveryServerList.getRemoteServer().add(remoteServerAttributes);

      discoverySettingsType.setDiscoveryServersList(discoveryServerList);

      return this;
   }

   /**
    * Add transport to use with this participant and register it to this participant
    */
   public ParticipantProfile addTransport(TransportDescriptorType transport)
   {
      // Add to transport_descriptors if it doesn't exist
      {
         boolean existsInTransportDescriptors = false;
         for (TransportDescriptorType transportDescriptorType : transportDescriptors.getTransportDescriptor())
         {
            if (transportDescriptorType.getTransportId().equals(transport.getTransportId()))
            {
               existsInTransportDescriptors = true;
               break;
            }
         }
         if (!existsInTransportDescriptors)
            transportDescriptors.getTransportDescriptor().add(transport);
      }

      // Create userTransports if it doesn't exist
      if (participantProfile.getRtps().getUserTransports() == null)
         participantProfile.getRtps().setUserTransports(new UserTransports());

      // Add to userTransports if it doesn't exist
      {
         boolean existsInUserTransports = false;
         for (String transportId : participantProfile.getRtps().getUserTransports().getTransportId())
         {
            if (transportId.equals(transport.getTransportId()))
            {
               existsInUserTransports = true;
               break;
            }
         }
         if (!existsInUserTransports)
            participantProfile.getRtps().getUserTransports().getTransportId().add(transport.getTransportId());
      }

      return this;
   }

   /**
    * Add a shared memory transport to this participant.
    * By setting useBuiltinTransports to false, you can use only a shared memory transport
    */
   public ParticipantProfile addSharedMemoryTransport()
   {
      TransportDescriptorType transportDescriptor = new TransportDescriptorType();
      transportDescriptor.setTransportId(UUID.randomUUID().toString());
      transportDescriptor.setType("SHM");

      addTransport(transportDescriptor);

      return this;
   }

   public ParticipantProfile addUDPv4Transport(InetAddress... addressRestriction)
   {
      TransportDescriptorType udp4Transport = new TransportDescriptorType();
      udp4Transport.setTransportId(UUID.randomUUID().toString());
      udp4Transport.setType("UDPv4");

      // Apply address restrictions
      // Check for null on the first element, to make sure passing in null works as usual -> no address restrictions
      if (addressRestriction != null && addressRestriction.length > 0 && addressRestriction[0] != null)
      {
         TransportDescriptorType.InterfaceWhiteList addressWhitelist = new InterfaceWhiteList();

         for (InetAddress addr : addressRestriction)
         {
            JAXBElement<String> addressElement = new JAXBElement<>(new QName(FastRTPSDomain.FAST_DDS_XML_NAMESPACE, "address"),
                                                                   String.class,
                                                                   addr.getHostAddress());
            addressWhitelist.getAddressOrInterface().add(addressElement);
         }

         udp4Transport.setInterfaceWhiteList(addressWhitelist);
      }

      addTransport(udp4Transport);

      return this;
   }

   /**
    * Helper function to disable all transports and use only the shared memory transport
    * Discovery will not work between nodes that have other transports enabled. Only use this with exclusively
    * shm-only nodes.
    */
   public ParticipantProfile useOnlySharedMemoryTransport()
   {
      useBuiltinTransports(false);

      if (participantProfile.getRtps().getUserTransports() == null)
         participantProfile.getRtps().setUserTransports(new UserTransports());

      participantProfile.getRtps().getUserTransports().getTransportId().clear();

      // Find the SHM transport
      boolean shmTransportFound = false;
      for (TransportDescriptorType transportDescriptorType : transportDescriptors.getTransportDescriptor())
      {
         if (transportDescriptorType.getType().equals("SHM"))
         {
            addTransport(transportDescriptorType);
            shmTransportFound = true;
            break;
         }
      }

      if (!shmTransportFound)
         addSharedMemoryTransport();

      return this;
   }

   public ParticipantProfile useOnlyUDPv4Transport(InetAddress... addressRestriction)
   {
      useBuiltinTransports(false);

      if (participantProfile.getRtps().getUserTransports() == null)
         participantProfile.getRtps().setUserTransports(new UserTransports());

      participantProfile.getRtps().getUserTransports().getTransportId().clear();

      // Find the UDPv4 transport
      boolean udpv4TransportFound = false;
      for (TransportDescriptorType transportDescriptorType : transportDescriptors.getTransportDescriptor())
      {
         if (transportDescriptorType.getType().equals("UDPv4"))
         {
            addTransport(transportDescriptorType);
            udpv4TransportFound = true;
            break;
         }
      }

      if (!udpv4TransportFound)
         addUDPv4Transport(addressRestriction);

      return this;
   }

   public ParticipantProfile useOnlyIntraProcessDelivery()
   {
      useBuiltinTransports(false);

      if (participantProfile.getRtps().getUserTransports() == null)
         participantProfile.getRtps().setUserTransports(new UserTransports());

      participantProfile.getRtps().getUserTransports().getTransportId().clear();

      // Intra-process delivery requires at least 1 transport.
      // Use shared memory to not bind to any network interface.
      addSharedMemoryTransport();

      useIntraProcessDelivery(true);

      return this;
   }

   public ParticipantProfile useBuiltinTransports(boolean useBuiltinTransports)
   {
      participantProfile.getRtps().setUseBuiltinTransports(useBuiltinTransports);
      return this;
   }

   public boolean isUseBuiltinTransports()
   {
      return participantProfile.getRtps().isUseBuiltinTransports();
   }

   // https://fast-dds.docs.eprosima.com/en/v2.14.3/fastdds/xml_configuration/library_settings.html#intra-process-delivery-xml-profile
   public ParticipantProfile useIntraProcessDelivery(boolean intraProcessDelivery)
   {
      librarySettings.setIntraprocessDelivery(intraProcessDelivery ? "FULL" : "OFF");
      return this;
   }

   public boolean isUseStaticDiscovery()
   {
      return participantProfile.getRtps().getBuiltin().getDiscoveryConfig().getEDP() == EDPType.STATIC;
   }

   public ParticipantProfile useStaticDiscovery(boolean useStaticDiscovery)
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
      participantProfile.setProfileName(profileName);

      Dds dds = new Dds();

      ProfilesType profilesType = new ProfilesType();
      profilesType.getDomainparticipantFactoryOrParticipantOrDataWriter().add(transportDescriptors);
      profilesType.getDomainparticipantFactoryOrParticipantOrDataWriter().add(participantProfile);

      dds.setProfiles(profilesType);
      dds.setLibrarySettings(librarySettings);

      String profileXML = FastRTPSDomain.marshallProfile(dds);
      for (StackTraceElement ste : Thread.currentThread().getStackTrace()) {
         System.out.println(ste);
      }

      // profileXML = Pattern.compile("<id>(.*)<\\/id>").matcher(profileXML).replaceAll("<transport_id>$1<\\/transport_id>");

      return profileXML;
   }
}

package us.ihmc.pubsub.attributes;

import com.eprosima.xmlschemas.fastrtps_profiles.*;
import com.eprosima.xmlschemas.fastrtps_profiles.LocatorListType.Locator;
import com.eprosima.xmlschemas.fastrtps_profiles.ParticipantProfileType.Rtps;
import com.eprosima.xmlschemas.fastrtps_profiles.TransportDescriptorType.InterfaceWhiteList;
import us.ihmc.pubsub.common.Time;
import us.ihmc.pubsub.impl.fastRTPS.FastRTPSDomain;

import jakarta.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import java.io.IOException;
import java.net.InetAddress;
import java.util.List;
import java.util.UUID;

public class ParticipantProfile
{
   private final ParticipantProfileType profileType = new ParticipantProfileType();
   private final TransportDescriptorListType transportDescriptors = new TransportDescriptorListType();

   public ParticipantProfile()
   {
      // Create default elements for participant profile
      BuiltinAttributesType builtin = new BuiltinAttributesType();
      DiscoverySettingsType discoverySettingsType = new DiscoverySettingsType();

      profileType.setRtps(new Rtps());
      profileType.getRtps().setBuiltin(builtin);
      builtin.setDiscoveryConfig(discoverySettingsType);

      // Set default discovery duration
      discoveryLeaseDuration(Time.Infinite);
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
      return profileType;
   }

   public ParticipantProfile domainId(int id)
   {
      profileType.setDomainId(id);
      return this;
   }

   public int getDomainId()
   {
      return getProfile().getDomainId();
   }

   public ParticipantProfile name(String name)
   {
      profileType.getRtps().setName(name);
      return this;
   }

   public String getName()
   {
      return profileType.getRtps().getName();
   }

   public ParticipantProfile discoveryLeaseDuration(Time discoveryLeaseDuration)
   {
      profileType.getRtps().getBuiltin().getDiscoveryConfig().setLeaseDuration(DDSConversionTools.timeToDurationType(discoveryLeaseDuration));
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
      
      DiscoverySettingsType discoverySettingsType = profileType.getRtps().getBuiltin().getDiscoveryConfig();
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

      DiscoveryServersListType discoveryServerList = profileType.getRtps().getBuiltin().getDiscoveryConfig().getDiscoveryServersList();
      discoveryServerList.getRemoteServer().add(remoteServerAttributes);

      discoverySettingsType.setDiscoveryServersList(discoveryServerList);

      return this;
   }

   /**
    * Bind this participant to only the addresses in bindToAddressRestrictions
    * 
    * Functionality, this will create a new UDPv4 transport with the whitelist set to "bindToAddressRestrictions". Optionally, a shared memory transport will be added as well.
    * useBuiltinTransports will be set to false 
    * 
    * @param addSharedMemoryTransport Enabled shared memory communication by adding a shared memory transport to this participant.
    * @param bindToAddressRestrictions Limit the scope of this participant to the list of hosts. If null or empty, the participant will not be able to communicate.
    * @return
    */
   public ParticipantProfile bindToAddressRestrictions(boolean addSharedMemoryTransport, List<InetAddress> bindToAddressRestrictions)
   {
      useBuiltinTransports(false);

      if (addSharedMemoryTransport)
      {
         addSharedMemoryTransport();  
      }
      
      if (bindToAddressRestrictions != null && !bindToAddressRestrictions.isEmpty())
      {
         // Create a new UDP transport,
         String transportName = UUID.randomUUID().toString();
         TransportDescriptorType transportDescriptor = new TransportDescriptorType();
         transportDescriptor.setTransportId(transportName);
         transportDescriptor.setType("UDPv4");

         TransportDescriptorType.InterfaceWhiteList addressWhitelist = new InterfaceWhiteList();

         for (InetAddress addr : bindToAddressRestrictions)
         {
            JAXBElement<String> addressElement = new JAXBElement<>(new QName(FastRTPSDomain.FAST_DDS_XML_NAMESPACE, "address"), String.class, addr.getHostAddress());
            addressWhitelist.getAddressOrInterface().add(addressElement);
         }
         
         transportDescriptor.setInterfaceWhiteList(addressWhitelist);
         addTransport(transportDescriptor);
      }
      
      return this;
   }

   /**
    * Add a transport to use with this participant and register it to this participant
    * 
    * @param transport
    * @return
    */
   public ParticipantProfile addTransport(TransportDescriptorType transport)
   {
      transportDescriptors.getTransportDescriptor().add(transport);
      
      if(profileType.getRtps().getUserTransports() == null)
      {
         profileType.getRtps().setUserTransports(new ParticipantProfileType.Rtps.UserTransports());
      }
      profileType.getRtps().getUserTransports().getTransportId().add(transport.getTransportId());
      
      return this;
   }
   
   /**
    * Add a shared memory transport to this participant.
    * 
    * By setting useBuiltinTransports to false, you can use only a shared memory transport
    *  
    * @return
    */
   public ParticipantProfile addSharedMemoryTransport()
   {
      String transportName = UUID.randomUUID().toString();
      TransportDescriptorType transportDescriptor = new TransportDescriptorType();
      transportDescriptor.setTransportId(transportName);
      transportDescriptor.setType("SHM");
      
      addTransport(transportDescriptor);
      
      return this;
   }
   
   public ParticipantProfile useBuiltinTransports(boolean useBuiltinTransports)
   {
      profileType.getRtps().setUseBuiltinTransports(useBuiltinTransports);
      return this;
   }
   
   public boolean isUseBuiltinTransports()
   {
      return profileType.getRtps().isUseBuiltinTransports();
   }
   
   /**
    * Helper function to disable all transports and use only the shared memory transport
    * @return
    */
   public ParticipantProfile useOnlySharedMemoryTransport()
   {
      useBuiltinTransports(false);
      addSharedMemoryTransport();
      return this;
   }

   public boolean isUseStaticDiscovery()
   {
      return profileType.getRtps().getBuiltin().getDiscoveryConfig().getEDP() == EDPType.STATIC;
   }
   
   public ParticipantProfile useStaticDiscovery(boolean useStaticDiscovery)
   {
      profileType.getRtps().getBuiltin().getDiscoveryConfig().setEDP(useStaticDiscovery ? EDPType.STATIC : EDPType.SIMPLE);
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
      profileType.setProfileName(profileName);

      ProfilesType profilesType = new ProfilesType();
      profilesType.getDomainparticipantFactoryOrParticipantOrDataWriter().add(transportDescriptors);
      profilesType.getDomainparticipantFactoryOrParticipantOrDataWriter().add(profileType);

      String profileXML =FastRTPSDomain.marshalProfile(profilesType);
//      profileXML = Pattern.compile("<id>(.*)<\\/id>").matcher(profileXML).replaceAll("<transport_id>$1<\\/transport_id>");

      return profileXML;
   }
}

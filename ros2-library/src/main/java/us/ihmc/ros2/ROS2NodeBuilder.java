package us.ihmc.ros2;

import com.eprosima.xmlschemas.fastrtps_profiles.ParticipantProfileType.Rtps.UserTransports;
import com.eprosima.xmlschemas.fastrtps_profiles.TransportDescriptorType;
import us.ihmc.log.LogTools;
import us.ihmc.pubsub.attributes.ParticipantProfile;
import us.ihmc.ros2.SubnetUtils.SubnetInfo;
import us.ihmc.util.PeriodicNonRealtimeThreadSchedulerFactory;
import us.ihmc.util.PeriodicThreadSchedulerFactory;

import javax.annotation.Nullable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.Stack;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * A builder to construct {@link ROS2Node}, {@link RealtimeROS2Node}.
 * <p>
 * Basic usage:
 *
 * <pre>{@code
 *    ROS2Node node = new ROS2Builder().build("Node");
 *    RealtimeROS2Node realtimeSHMOnlyNode = new ROS2NodeBuilder().specialTransportMode(SpecialTransportMode.SHARED_MEMORY_ONLY).buildRealtime("SHMNode");
 * }</pre>
 * </p>
 */
public class ROS2NodeBuilder
{
   private static final int UNSET_DOMAIN_ID = -1;
   private static final String DEFAULT_NAMESPACE = "/us/ihmc";

   /**
    * Used to denote that a ROS2Node should be set-up with a special mode of transport.
    * These are custom use case specific modes.
    */
   public enum SpecialTransportMode
   {
      /**
       * SHARED_MEMORY_ONLY enables only the Shared Memory Transport. Participants communicate directly through memory on the host system.
       * Temporary files are written to disk (on Linux in /dev/shm, on Windows in %APPDATA%\Local\Temp) to assist with facilitating this mode of transport.
       * This mode is NOT compatible with mixed-transports, e.g. a participant with SHM and UDPv4 transports.
       * Documentation: <a href="https://fast-dds.docs.eprosima.com/en/v2.14.3/fastdds/transport/shared_memory/shared_memory.html">Shared Memory Transport</a>
       */
      SHARED_MEMORY_ONLY,
      /**
       * UDPV4_LOOPBACK_ADDRESS_ONLY enables only the UDP Transport on the loopback address. Useful for mixed-DDS implementations where you only want local
       * communication, e.g. CycloneDDS and FastDDS communicating only locally.
       * Documentation <a href="https://fast-dds.docs.eprosima.com/en/v2.14.3/fastdds/transport/udp/udp.html">UDP Transport</a>
       */
      UDPV4_LOOPBACK_ADDRESS_ONLY,
      /**
       * UDPV4_ONLY enables only the UDP Transport with no special address restrictions. Useful for debugging or testing, not super practical in most
       * applications.
       * Documentation <a href="https://fast-dds.docs.eprosima.com/en/v2.14.3/fastdds/transport/udp/udp.html">UDP Transport</a>
       */
      UDPV4_ONLY,
      /**
       * INTRAPROCESS_ONLY attempts to force Publishers to directly call reception functions of Subscribers.
       * This mode still enables a shared memory (SHM) transport, as there has to be one fallback transport on a Participant.
       * This mode is especially useful for unit testing and single-process applications.
       * This mode does not bind to any network address, unless SHM transport was unable to initialize.
       * This mode is NOT compatible with mixed-transports, e.g. a participant with SHM and UDPv4 transports.
       * Documentation: <a href="https://fast-dds.docs.eprosima.com/en/v2.14.3/fastdds/transport/intraprocess.html#intraprocess-delivery">Intra-process
       * delivery</a>
       */
      INTRAPROCESS_ONLY
   }

   private int domainId = UNSET_DOMAIN_ID;
   private String namespace = DEFAULT_NAMESPACE;
   private boolean useSharedMemory = true;
   private InetAddress[] addressRestriction = null;
   private boolean parseEnvironment = true;
   private boolean parseProperties = true;
   private boolean parseNetworkParametersConfig = true;
   @Nullable
   private SpecialTransportMode specialTransportMode;

   private final transient StringJoiner buildPrintout = new StringJoiner("\n\t\t");

   public ROS2NodeBuilder domainId(int domainId)
   {
      this.domainId = domainId;
      return this;
   }

   public ROS2NodeBuilder namespace(String namespace)
   {
      this.namespace = namespace;
      return this;
   }

   public ROS2NodeBuilder useSharedMemory(boolean useSharedMemory)
   {
      this.useSharedMemory = useSharedMemory;
      return this;
   }

   public ROS2NodeBuilder addressRestriction(InetAddress... addressRestriction)
   {
      this.addressRestriction = addressRestriction;
      return this;
   }

   public ROS2NodeBuilder parseEnvironment(boolean parseEnvironment)
   {
      this.parseEnvironment = parseEnvironment;
      return this;
   }

   public ROS2NodeBuilder parseProperties(boolean parseProperties)
   {
      this.parseProperties = parseProperties;
      return this;
   }

   public ROS2NodeBuilder parseNetworkParametersConfig(boolean parseNetworkParametersConfig)
   {
      this.parseNetworkParametersConfig = parseNetworkParametersConfig;
      return this;
   }

   public ROS2NodeBuilder specialTransportMode(@Nullable SpecialTransportMode specialTransportMode)
   {
      this.specialTransportMode = specialTransportMode;
      return this;
   }

   public ROS2Node build(String name)
   {
      buildPrintout.add("Building ROS2Node: " + name);
      return new ROS2Node(name, namespace, buildProfile(), specialTransportMode);
   }

   public RealtimeROS2Node buildRealtime(String name)
   {
      return buildRealtime(name, new PeriodicNonRealtimeThreadSchedulerFactory());
   }

   public RealtimeROS2Node buildRealtime(String name, PeriodicThreadSchedulerFactory threadFactory)
   {
      buildPrintout.add("Building RealtimeROS2Node: " + name);
      return new RealtimeROS2Node(name, namespace, buildProfile(), specialTransportMode, threadFactory);
   }

   private ParticipantProfile buildProfile()
   {
      ParticipantProfile profile = ParticipantProfile.create();

      // Set up ROS Domain ID
      {
         if (domainIDValid(domainId))
         {
            buildPrintout.add("Using a programmatically set ROS Domain ID: " + domainId);
         }
         else
         {
            // Try to find a ROS Domain ID
            domainId = findDomainID();

            // If a valid domain ID was not found automatically
            if (!domainIDValid(domainId))
            {
               domainId = 100;

               buildPrintout.add("Unable to find any ROS Domain ID");
               buildPrintout.add(
                     "You can set a ROS Domain ID via: system property (ros.domain.id), environment variable (ROS_DOMAIN_ID), RTPSDomainID in IHMCNetworkParameters.ini");
               buildPrintout.add("Using a default ROS Domain ID: " + domainId);
            }
         }

         profile.domainId(domainId);
      }

      // Check namespace and print if it was changed
      {
         if (!namespace.equals(DEFAULT_NAMESPACE))
         {
            buildPrintout.add("Namespace: " + namespace);
         }
      }

      // Set up transports
      {
         profile.useBuiltinTransports(false);

         if (useSharedMemory)
            profile.addSharedMemoryTransport();

         if (addressRestriction != null)
            buildPrintout.add("Using a programmatically set address restriction");
         else
            addressRestriction = findAddressRestriction();

         profile.addUDPv4Transport(addressRestriction);

         boolean runningInCI = (System.getenv("GITHUB_ACTIONS") != null)
                               || (System.getenv("RUNNING_ON_CONTINUOUS_INTEGRATION_SERVER") != null)
                               || (System.getProperty("runningOnCIServer") != null);
         if (runningInCI)
         {
            buildPrintout.add("Detected running from CI. Using INTRAPROCESS_ONLY SpecialTransportMode");

            specialTransportMode = SpecialTransportMode.INTRAPROCESS_ONLY;
         }

         if (specialTransportMode != null)
         {
            switch (specialTransportMode)
            {
               case SHARED_MEMORY_ONLY -> profile.useOnlySharedMemoryTransport();
               case UDPV4_LOOPBACK_ADDRESS_ONLY ->
               {
                  InetAddress loopbackAddress = InetAddress.getLoopbackAddress();

                  addressRestriction = new InetAddress[] {loopbackAddress};
               }
               case UDPV4_ONLY -> profile.useOnlyUDPv4Transport(addressRestriction);
               case INTRAPROCESS_ONLY -> profile.useOnlyIntraProcessDelivery();
            }
         }

         List<String> addresses = new ArrayList<>();
         for (InetAddress inetAddress : addressRestriction)
            addresses.add(inetAddress.getHostAddress());
         buildPrintout.add("Address restriction: " + String.join(", ", addresses));
      }

      // Print the current transports and delivery methods
      {
         if (specialTransportMode != null)
            buildPrintout.add("Special transport mode: " + specialTransportMode.name());

         StringBuilder printout = new StringBuilder();

         StringJoiner transportsString = new StringJoiner(", ");
         UserTransports transports = profile.getProfile().getRtps().getUserTransports();
         if (transports != null)
            for (TransportDescriptorType transportDescriptorType : profile.getTransportDescriptors().getTransportDescriptor())
               if (transports.getTransportId().contains(transportDescriptorType.getTransportId()))
                  transportsString.add(transportDescriptorType.getType());

         printout.append("Enabled transports: ");
         printout.append(transportsString);

         buildPrintout.add(printout.toString());

         if (profile.getLibrarySettings().getIntraprocessDelivery() != null)
         {
            String intraProcessMode = profile.getLibrarySettings().getIntraprocessDelivery();
            buildPrintout.add("Intra-process delivery mode: " + intraProcessMode);
         }
      }

      LogTools.info(buildPrintout.toString());

      return profile;
   }

   /**
    * Find a value from the environment from several different places, where the places have some priority.
    * Priority order: IHMCNetworkParameters.ini, Java System Property, system environment
    *
    * @param environmentKey       Key from system environment
    * @param propertiesKey        Key from Java System Properties
    * @param networkParametersKey Key from ~/.ihmc/IHMCNetworkParameters.ini properties file
    * @return the value found for the most-prioritized key
    */
   private String findValueForField(String environmentKey, String propertiesKey, String networkParametersKey)
   {
      Stack<Map.Entry<String, String>> possibleValues = new Stack<>();

      if (parseEnvironment && !environmentKey.isEmpty())
      {
         if (System.getenv(environmentKey) != null)
         {
            possibleValues.push(Map.entry(environmentKey, System.getenv(environmentKey)));
         }
      }

      if (parseProperties && !propertiesKey.isEmpty())
      {
         if (System.getProperty(propertiesKey) != null)
         {
            possibleValues.push(Map.entry("-D" + propertiesKey, System.getProperty(propertiesKey)));
         }
      }

      if (parseNetworkParametersConfig && !networkParametersKey.isEmpty())
      {
         File networkParametersFile = new File(System.getProperty("user.home"), ".ihmc/IHMCNetworkParameters.ini");
         Properties properties = new Properties();
         try (FileInputStream inputStream = new FileInputStream(networkParametersFile))
         {
            properties.load(inputStream);

            if (properties.getProperty(networkParametersKey) != null)
            {
               possibleValues.push(Map.entry("(IHMCNetworkParameters.ini) " + networkParametersKey, properties.getProperty(networkParametersKey)));
            }
         }
         catch (IOException e)
         {
            if (!(e instanceof FileNotFoundException))
               LogTools.error(e);
         }
      }

      if (!possibleValues.empty())
      {
         StringJoiner printout = new StringJoiner(" <- ");
         for (int i = possibleValues.size() - 1; i >= 0; i--)
         {
            Entry<String, String> possibleValue = possibleValues.get(i);
            printout.add(possibleValue.getKey() + "=" + possibleValue.getValue());
         }

         buildPrintout.add("Found ROS 2 property: " + printout);
      }

      return !possibleValues.isEmpty() ? possibleValues.peek().getValue() : null;
   }

   private int findDomainID()
   {
      int domainID = UNSET_DOMAIN_ID;

      String valueForField = findValueForField("ROS_DOMAIN_ID", "ros.domain.id", "RTPSDomainID");

      if (valueForField != null)
      {
         try
         {
            domainID = Integer.parseInt(valueForField.trim());
         }
         catch (NumberFormatException e)
         {
            LogTools.error("Unable to parse ROS Domain ID");
         }
      }

      return domainID;
   }

   private InetAddress[] findAddressRestriction()
   {
      String valueForField = findValueForField("ROS_ADDRESS_RESTRICTION", "ros.address.restriction", "RTPSSubnet");

      return convertToInetAddressArray(valueForField != null ? valueForField : "127.0.0.1/8");
   }

   protected static boolean domainIDValid(int domainID)
   {
      return domainID >= 0 && domainID <= 232;
   }

   /**
    * Convert IP address CSV to InetAddress array
    *
    * @param restrictionHostString A list of IP addresses separated by comma in CIDR format. E.g. "127.0.0.1/8, 0.0.0.0/24"
    * @return The array of InetAddresses representing the CSV list
    */
   protected static InetAddress[] convertToInetAddressArray(String restrictionHostString)
   {
      Set<InetAddress> foundAddressRestrictions = new HashSet<>();

      String[] restrictionHostList = restrictionHostString.split("\\s*,\\s*");

      List<InterfaceAddress> interfaceAddresses;
      try
      {
         interfaceAddresses = Collections.list(NetworkInterface.getNetworkInterfaces())
                                         .stream()
                                         .flatMap(networkInterface -> networkInterface.getInterfaceAddresses().stream())
                                         .collect(Collectors.toList());
      }
      catch (SocketException e)
      {
         throw new RuntimeException(e);
      }

      for (String restrictionHost : restrictionHostList)
      {
         SubnetInfo restrictionSubnetInfo = new SubnetUtils(restrictionHost.trim()).getInfo();

         for (InterfaceAddress interfaceAddress : interfaceAddresses)
         {
            InetAddress address = interfaceAddress.getAddress();

            if (address instanceof Inet4Address)
            {
               short netmaskAsShort = interfaceAddress.getNetworkPrefixLength();

               String interfaceHost = address.getHostAddress();
               SubnetInfo interfaceSubnetInfo = new SubnetUtils(interfaceHost + "/" + netmaskAsShort).getInfo();

               boolean inRange;
               if (System.getProperty("os.name").toLowerCase().contains("win"))
               {
                  inRange = interfaceSubnetInfo.isInRange(restrictionSubnetInfo.getAddress()); // This worked on Windows, but not Linux: Doug
               }
               else // Linux and others
               {
                  // This works on Linux. Does not work on Windows. Not tested on Mac.
                  inRange = restrictionSubnetInfo.isInRange(interfaceSubnetInfo.getAddress());
               }

               if (inRange)
               {
                  foundAddressRestrictions.add(address);
               }
            }
         }
      }

      InetAddress[] addressRestrictions = new InetAddress[foundAddressRestrictions.size()];

      return foundAddressRestrictions.toArray(addressRestrictions);
   }
}

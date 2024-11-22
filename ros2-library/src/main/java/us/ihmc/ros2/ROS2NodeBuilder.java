package us.ihmc.ros2;

import us.ihmc.log.LogTools;
import us.ihmc.pubsub.attributes.ParticipantProfile;
import us.ihmc.util.PeriodicNonRealtimeThreadSchedulerFactory;
import us.ihmc.util.PeriodicThreadSchedulerFactory;

import javax.annotation.Nullable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Stack;
import java.util.StringJoiner;

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

   public enum SpecialTransportMode
   {
      SHARED_MEMORY_ONLY, LOOPBACK_ADDRESS_ONLY, UDPV4_ONLY
   }

   private int domainId = UNSET_DOMAIN_ID;
   private String namespace = "/us/ihmc";
   private boolean useSharedMemory = true;
   private InetAddress[] addressRestriction = null;

   private boolean parseEnvironment = true;
   private boolean parseProperties = true;
   private boolean parseNetworkParametersConfig = true;

   @Nullable
   private SpecialTransportMode specialTransportMode;

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
      return new ROS2Node(name, namespace, buildProfile());
   }

   public RealtimeROS2Node buildRealtime(String name)
   {
      return buildRealtime(name, new PeriodicNonRealtimeThreadSchedulerFactory());
   }

   public RealtimeROS2Node buildRealtime(String name, PeriodicThreadSchedulerFactory threadFactory)
   {
      return new RealtimeROS2Node(name, namespace, buildProfile(), threadFactory);
   }

   private ParticipantProfile buildProfile()
   {
      ParticipantProfile profile = ParticipantProfile.create();

      // Set up ROS Domain ID
      {
         if (domainIDValid(domainId))
         {
            LogTools.info("Using a programmatically set ROS Domain ID: {}", domainId);
         }
         else
         {
            // Try to find a ROS Domain ID
            domainId = findDomainID();

            // If a valid domain ID was not found automatically
            if (!domainIDValid(domainId))
            {
               domainId = 0;

               LogTools.error("Unable to find any ROS Domain ID");
               LogTools.error(
                     "You can set a ROS Domain ID via: system property (ros.domain.id), environment variable (ROS_DOMAIN_ID), RTPSDomainID in IHMCNetworkParameters.ini");
               LogTools.error("Using a default ROS Domain ID: {}", domainId);
            }
         }

         profile.domainId(domainId);
      }

      // Set up transports
      {
         profile.useBuiltinTransports(false);

         if (useSharedMemory)
            profile.addSharedMemoryTransport();

         profile.addUDPv4Transport(addressRestriction);

         if (specialTransportMode != null)
         {
            switch (specialTransportMode)
            {
               case SHARED_MEMORY_ONLY -> profile.useOnlySharedMemoryTransport();
               case LOOPBACK_ADDRESS_ONLY ->
               {
                  InetAddress loopbackAddress = InetAddress.getLoopbackAddress();

                  addressRestriction = new InetAddress[] {loopbackAddress};
               }
               case UDPV4_ONLY -> profile.useOnlyUDPv4Transport(addressRestriction);
            }
         }
      }

      // Print the current transports

      return profile;
   }

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

         LogTools.info("ROS Domain ID: {}", printout.toString());
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
            domainID = Integer.parseInt(valueForField);
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
      String valueForField = findValueForField("ROS_USE_SHARED_MEMORY", "ros.use.shared.memory", "");

      if (valueForField != null)
      {

      }

      return null;
   }

   protected static boolean domainIDValid(int domainID)
   {
      return domainID >= 0 && domainID <= 232;
   }
}

package us.ihmc.ros2;

import us.ihmc.log.LogTools;
import us.ihmc.pubsub.attributes.ParticipantProfile;
import us.ihmc.util.PeriodicNonRealtimeThreadSchedulerFactory;
import us.ihmc.util.PeriodicThreadSchedulerFactory;

import javax.annotation.Nullable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Properties;

public class ROS2NodeBuilder
{
   public enum TransportSpecial
   {
      SHARED_MEMORY_ONLY, LOOPBACK_ADDRESS_ONLY, UDPV4_ONLY
   }

   private static final int UNSET_DOMAIN_ID = -1;

   private int domainId = UNSET_DOMAIN_ID;
   private String namespace = "/us/ihmc";
   private boolean useSharedMemory = true;
   private InetAddress[] addressRestriction;

   private boolean parseProperties = true;
   private boolean parseEnvironment = true;
   private boolean parseNetworkParametersConfig = true;

   @Nullable
   private TransportSpecial transportSpecial;

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

   public ROS2NodeBuilder parseProperties(boolean parseProperties)
   {
      this.parseProperties = parseProperties;
      return this;
   }

   public ROS2NodeBuilder parseEnvironment(boolean parseEnvironment)
   {
      this.parseEnvironment = parseEnvironment;
      return this;
   }

   public ROS2NodeBuilder parseNetworkParametersConfig(boolean parseNetworkParametersConfig)
   {
      this.parseNetworkParametersConfig = parseNetworkParametersConfig;
      return this;
   }

   public ROS2NodeBuilder transportSpecial(TransportSpecial transportSpecial)
   {
      this.transportSpecial = transportSpecial;
      return this;
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
            domainId = findDomainID(parseNetworkParametersConfig, parseProperties, parseEnvironment);

            // If a valid domain ID was not found automatically
            if (!domainIDValid(domainId))
            {
               domainId = 0;

               LogTools.warn("Unable to find any ROS Domain ID");
               LogTools.warn(
                     "You can set a ROS Domain ID via: system property (ROS_DOMAIN_ID), environment variable (ROS_DOMAIN_ID), RTPSDomainID in IHMCNetworkParameters.ini");
               LogTools.warn("Using a default ROS Domain ID of {}", domainId);
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

         if (transportSpecial != null)
         {
            switch (transportSpecial)
            {
               case SHARED_MEMORY_ONLY ->
               {
                  profile.useOnlySharedMemoryTransport();
               }
               case LOOPBACK_ADDRESS_ONLY ->
               {
                  InetAddress loopbackAddress = InetAddress.getLoopbackAddress();

                  addressRestriction = new InetAddress[] {loopbackAddress};
               }
               case UDPV4_ONLY ->
               {
                  profile.useOnlyUDPv4Transport(addressRestriction);
               }
            }
         }
      }

      // Print the current transports

      return profile;
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

   protected static boolean domainIDValid(int domainID)
   {
      return domainID >= 0 && domainID <= 232;
   }

   /**
    * Find the ROS Domain ID from either:
    *    - IHMCNetworkParameters.ini
    *    - System property
    *    - Environment variable
    * prioritized in that order
    */
   protected static int findDomainID(boolean parseNetworkParametersConfig, boolean parseProperties, boolean parseEnvironment)
   {
      int domainID = UNSET_DOMAIN_ID;

      // Find domain ID from IHMCNetworkParameters.ini
      if (parseNetworkParametersConfig)
      {
         File networkParametersFile = new File(System.getProperty("user.home"), ".ihmc/IHMCNetworkParameters.ini");
         Properties properties = new Properties();
         try (FileInputStream inputStream = new FileInputStream(networkParametersFile))
         {
            properties.load(inputStream);

            String domainIDProperty = properties.getProperty("RTPSDomainID");

            if (domainIDProperty != null)
            {
               try
               {
                  domainID = Integer.parseInt(domainIDProperty);
               }
               catch (NumberFormatException e)
               {
                  // Ignore
               }
            }
         }
         catch (IOException e)
         {
            // Ignore
         }

         if (domainIDValid(domainID))
         {
            LogTools.info("Found ROS Domain ID from IHMCNetworkParameters.ini: {}", domainID);
            return domainID;
         }
      }

      // Find domain ID from properties
      if (parseProperties)
      {
         String domainIDProperty = System.getProperty("ROS_DOMAIN_ID");

         try
         {
            domainID = Integer.parseInt(domainIDProperty);
         }
         catch (NumberFormatException e)
         {
            // Ignore
         }

         if (domainIDValid(domainID))
         {
            LogTools.info("Found ROS Domain ID from system parameters ROS_DOMAIN_ID: {}", domainID);
            return domainID;
         }
      }

      // Find domain ID from environment
      if (parseEnvironment)
      {
         String domainIDEnv = System.getenv("ROS_DOMAIN_ID");

         try
         {
            domainID = Integer.parseInt(domainIDEnv);
         }
         catch (NumberFormatException e)
         {
            // Ignore
         }

         if (domainIDValid(domainID))
         {
            LogTools.info("Found ROS Domain ID from environment ROS_DOMAIN_ID:{}", domainID);
            return domainID;
         }
      }

      return domainID;
   }
}

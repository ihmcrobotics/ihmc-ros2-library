/**
 * Copyright 2017 Florida Institute for Human and Machine Cognition (IHMC)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package us.ihmc.rtps.impl.fastRTPS;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import us.ihmc.pubsub.attributes.Locator;
import us.ihmc.pubsub.attributes.Locator.Kind;
import us.ihmc.pubsub.attributes.ParticipantAttributes;
import us.ihmc.pubsub.common.Time;

public class FastRTPSParticipantAttributes extends ParticipantAttributes
{
   private final RTPSParticipantAttributes rtps = new RTPSParticipantAttributes();
   private final BuiltinAttributes builtin = rtps.getBuiltin();
   private final DiscoverySettings discoveryConfig = builtin.getDiscovery_config();
   private final Time_t time = new Time_t();
   
   private int domainId = 0;
   
   FastRTPSParticipantAttributes()
   {
      super();
   }

   /**
    * @return Implementation specific representation of the underlying RTPS layer attributes. 
    */
   @SuppressWarnings("unchecked")
   public RTPSParticipantAttributes rtps()
   {
      return rtps;
   }

   @Override
   public void setName(String name)
   {
      rtps().setName(name);
   }

   @Override
   public void setDomainId(int domain)
   {
      this.domainId = domain;
   }
   
   public int getDomainId()
   {
      return domainId;
   }

   @Override
   public void setLeaseDuration(Time time)
   {
      this.time.setSeconds(time.getSeconds());
      this.time.setNanosec(time.getNanoseconds());
      discoveryConfig.setLeaseDuration(this.time);
   }
   
   public void bindToAddress(InetAddress... addresses)
   {
      for(InetAddress address : addresses)
      {
         Locator locator = new Locator();
         Locator_t locatorN = new Locator_t();
         if(address instanceof Inet4Address)
         {
            locator.setKind(Kind.LOCATOR_KIND_UDPv4);
            locator.setIPv4Adress(address);

            FastRTPSCommonFunctions.convertToCPPLocator(locator, locatorN);           
         }
         else
         {
            throw new RuntimeException("Only IPv4 addresses are tested and supported");
         }
         
         rtps.getDefaultUnicastLocatorList().push_back(locatorN);
      }
   }

   public void delete()
   {
      rtps().delete();
      time.delete();
   }
   
   public void finalize()
   {
      delete();
   }

   @Override
   public void enableDiscoveryServer(int serverId, List<Locator> unicastLocators)
   {

      DiscoverySettings discovery_config = rtps().getBuiltin().getDiscovery_config();
      discovery_config.setDiscoveryProtocol(DiscoveryProtocol_t.CLIENT);
      
      
      RemoteServerAttributes attr = new RemoteServerAttributes();
      FastRTPSCommonFunctions.convertToCPPLocatorList(unicastLocators, attr.getMetatrafficUnicastLocatorList());
      
      FastRTPS.setRemoteServerAttributesDefaultGUIDPrefix(attr, serverId);
      
      FastRTPS.pushRemoteServerAttributes(discovery_config.getM_DiscoveryServers(), attr);
      
   }

   @Override
   public void enableDiscoveryServer(int serverId, InetAddress serverAddress)
   {
      Locator locator = new Locator();
      locator.setPort(FastRTPS.getDEFAULT_ROS2_SERVER_PORT());
      locator.setIPv4Adress(serverAddress);
      
      System.out.println(Arrays.toString(serverAddress.getAddress()));
      
      List<Locator> locatorList = new ArrayList<>();
      locatorList.add(locator);
      
      enableDiscoveryServer(serverId, locatorList);

   }
}

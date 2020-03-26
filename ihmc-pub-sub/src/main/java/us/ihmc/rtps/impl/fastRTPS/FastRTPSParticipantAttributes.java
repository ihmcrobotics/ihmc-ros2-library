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
      builtin.setDomainId(domain);
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
}

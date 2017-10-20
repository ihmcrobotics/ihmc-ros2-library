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

import us.ihmc.pubsub.attributes.ParticipantAttributes;
import us.ihmc.pubsub.common.Time;

public class FastRTPSParticipantAttributes extends ParticipantAttributes
{
   private final RTPSParticipantAttributes rtps = new RTPSParticipantAttributes();
   private final BuiltinAttributes builtin = rtps.getBuiltin();
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
      this.time.setFraction(time.getFraction());
      builtin.setLeaseDuration(this.time);
   }
   
   public void bindToAddress(InetAddress... addresses)
   {
      for(InetAddress address : addresses)
      {
         Locator_t locator = new Locator_t();
         if(address instanceof Inet4Address)
         {
            locator.setKind(FastRTPSCommonFunctions.LOCATOR_KIND_UDPv4);
            locator.set_IP4_address(address.getHostAddress());
         }
         else
         {
            throw new RuntimeException("Only IPv4 addresses are tested and supported");
         }
         rtps.getDefaultOutLocatorList().push_back(locator);
         rtps.getDefaultUnicastLocatorList().push_back(locator);
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

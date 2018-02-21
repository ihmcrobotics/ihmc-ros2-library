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
package us.ihmc.pubsub.attributes;

import java.net.Inet4Address;
import java.net.InetAddress;

import us.ihmc.pubsub.common.Time;

/**
 * Class ParticipantAttributes, used by the user to define the attributes of a Participant.
 * 
 * @param <T>
 * 
 * @author Jesper Smith
 */
public abstract class ParticipantAttributes
{
   
   
   protected ParticipantAttributes()
   {
   }
   
   
   /**
    * Get implementation specific representation of the underlying RTPS layer attributes.
    * 
    * Implementations:
    *    FastRTPS: us.ihmc.rtps.impl.fastRTPS.RTPSParticipantAttributes
    * 
    * @return Implementation specific representation of the underlying RTPS layer attributes. 
    */
   public abstract <T> T rtps();
   
   /**
    * Convenience function to set the participant name in an implementation agnostic manner
    * 
    * @param name
    */
   public abstract void setName(String name);
   
   /**
    * Convenience function to set the participant domain id in an implementation agnostic manner
    * 
    * @param domain
    */
   public abstract void setDomainId(int domain);
   
   /**
    * Convenience function to set the participant lease duration an implementation agnostic manner
    * 
    * @param time
    */
   public abstract void setLeaseDuration(Time time);
   
   /**
    * Binds this participant to only the addresses given as parameters
    * 
    * By default the participant binds to all network interfaces on the computer
    * 
    * @param addresses one or more local network addresses to bind to
    */
   public abstract void bindToAddress(InetAddress... addresses);
   
   
   public void bindToLocalhost()
   {
      bindToAddress(Inet4Address.getLoopbackAddress());
   }
}

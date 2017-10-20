/*
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
package us.ihmc.pubsub.impl.intraprocess;

import java.net.InetAddress;

import us.ihmc.pubsub.attributes.ParticipantAttributes;
import us.ihmc.pubsub.common.Time;

public class IntraProcessParticipantAttributes extends ParticipantAttributes
{
   private String name;
   private long domain;
   private Time leaseDuration;
   
   IntraProcessParticipantAttributes()
   {
      // TODO Auto-generated constructor stub
   }
   
   
   @Override
   public <T> T rtps()
   {
      return null;
   }

   @Override
   public void setName(String name)
   {
      this.name = name;
   }

   @Override
   public void setDomainId(long domain)
   {
      this.domain = domain;
   }

   @Override
   public void setLeaseDuration(Time time)
   {
      this.leaseDuration = time;
   }

   @Override
   public void bindToAddress(InetAddress... addresses)
   {
      System.err.println("TODO: Implement JRTPSParticipantAttributes.bindToAddress");
   }

   long getDomain()
   {
      return domain;
   }

   void setDomain(long domain)
   {
      this.domain = domain;
   }

   String getName()
   {
      return name;
   }

   Time getLeaseDuration()
   {
      return leaseDuration;
   }
   
   

}
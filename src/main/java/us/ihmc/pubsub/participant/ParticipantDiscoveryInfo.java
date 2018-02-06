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
package us.ihmc.pubsub.participant;

import us.ihmc.pubsub.common.DiscoveryStatus;
import us.ihmc.pubsub.common.Guid;

/**
 * Class ParticipantDiscoveryInfo, provided to the user with information regarding a Discovered Participant.
 * 
 * @author Jesper Smith
 *
 */
public class ParticipantDiscoveryInfo
{
   protected final Guid guid;
   protected DiscoveryStatus status;
   protected String name;
   
   protected ParticipantDiscoveryInfo()
   {
      this.guid = new Guid();
   }
   
   public ParticipantDiscoveryInfo(String name, Guid guid, DiscoveryStatus status)
   {
      this.name = name;
      this.guid = guid;
      this.status = status;
   }
   
   
   /**
    * Associated GUID.
    * 
    * This method does not allocate memory
    * 
    * @return Guid
    */
   public Guid getGuid()
   {
      return guid;
   }
   
   /**
    * Status
    * 
    * This method does not allocate memory
    * 
    * @return status
    */
   public DiscoveryStatus getStatus()
   {
      return status;
   }
   
   /**
    * Associated participant name
    * 
    * This method allocates a new java.util.String.
    * 
    * @return participant name
    */
   public String getName()
   {
      return name;
   }
   
}

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

import java.io.IOException;

import us.ihmc.pubsub.attributes.ParticipantAttributes;
import us.ihmc.pubsub.common.Guid;

/**
 * Class Participant used to group Publishers and Subscribers into a single working unit
 * 
 * @author Jesper Smith
 *
 */
public interface Participant
{
   /**
    * Get the GUID_t of the associated RTPSParticipant.
    *
    * This method does not allocate memory. 
    *
    * @return Guid
    */
   public Guid getGuid();
   
   /**
    * Get the ParticipantAttributes.
    * 
    * To access implementation specific features, cast the ParticipantAttributes to their implementation specific version.
    * 
    * This method does not allocate memory
    * 
    * @return ParticipantAttributes.
    */
   public ParticipantAttributes getAttributes();
   
   
   /**
    * Register a publisher and a subscriber endpoint discovery listener to this participant.
    * 
    *  This functionality is exposed to create debugging and visualization tools for an RTPS network. It is not guaranteed that all implementations support this method.
    *  
    *  This method can result in memory being allocated in the endpoint discovery listener calls.
    *  
    * @param publisherEndpointDiscoveryListener Listener for the publisher endpoint discovery protocol
    * @param subscriberEndpointDiscoveryListener Listener for the subscriber endpoint discovery protocol
    * 
    * @throws IOException when the Endpoint Discovery protocol is not used.
    */
   public void registerEndpointDiscoveryListeners(PublisherEndpointDiscoveryListener publisherEndpointDiscoveryListener, SubscriberEndpointDiscoveryListener subscriberEndpointDiscoveryListener) throws IOException;
   
   /**
    * 
    * @param target_topic Topic name to query
    * @return the number of local publishers registered to target_topic
    */
   public int get_no_publisher(String target_topic);
   
   /**
    * 
    * @param target_topic Topic name to query
    * @return the number of local subscribers registered to the target_topic
    */
   public int get_no_subscribers(String target_topic);
   
   /**
    * Checks if this publisher is available to read and write data from and to the domain 
    * 
    * This method does not allocate memory
    * 
    * @return true if this participant is available
    */
   public boolean isAvailable();
}

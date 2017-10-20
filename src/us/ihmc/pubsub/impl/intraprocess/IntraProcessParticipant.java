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

import java.io.IOException;

import us.ihmc.pubsub.attributes.ParticipantAttributes;
import us.ihmc.pubsub.common.DiscoveryStatus;
import us.ihmc.pubsub.common.Guid;
import us.ihmc.pubsub.participant.Participant;
import us.ihmc.pubsub.participant.PublisherEndpointDiscoveryListener;
import us.ihmc.pubsub.participant.SubscriberEndpointDiscoveryListener;

public class IntraProcessParticipant implements Participant
{

   @Override
   public Guid getGuid()
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public ParticipantAttributes getAttributes()
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public void registerEndpointDiscoveryListeners(PublisherEndpointDiscoveryListener publisherEndpointDiscoveryListener,
                                                  SubscriberEndpointDiscoveryListener subscriberEndpointDiscoveryListener)
         throws IOException
   {
      // TODO Auto-generated method stub

   }

   @Override
   public int get_no_publisher(String target_topic)
   {
      // TODO Auto-generated method stub
      return 0;
   }

   @Override
   public int get_no_subscribers(String target_topic)
   {
      // TODO Auto-generated method stub
      return 0;
   }

   @Override
   public boolean isAvailable()
   {
      // TODO Auto-generated method stub
      return false;
   }

   public void notifyParticipantListener(IntraProcessParticipant participant, DiscoveryStatus discoveredRtpsparticipant)
   {
      // TODO Auto-generated method stub
      
   }

   public void notifySubscriberDiscoveryListener(IntraProcessSubscriber subscriber)
   {
   }

   public void notifyPublisherDiscoveryListener(IntraProcessPublisher publisher)
   {
   }

}

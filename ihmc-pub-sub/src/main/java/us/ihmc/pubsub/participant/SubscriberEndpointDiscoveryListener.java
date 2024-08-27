/**
 * Copyright 2024 Florida Institute for Human and Machine Cognition (IHMC)
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

import us.ihmc.pubsub.common.Guid;

/**
 * Listener for the subscriber endpoint discovery protocol
 * 
 * @author Jesper Smith
 *
 */
public interface SubscriberEndpointDiscoveryListener
{
   /**
    * Callback for a new topic change event.
    */
   void subscriberTopicChange(boolean isAlive, Guid guid, boolean expectsInlineQos, 
                              Guid participantGuid, String typeName, String topicName, int userDefinedId);
}

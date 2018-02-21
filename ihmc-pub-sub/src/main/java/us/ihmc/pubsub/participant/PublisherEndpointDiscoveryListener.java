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

import java.util.ArrayList;

import us.ihmc.pubsub.attributes.Locator;
import us.ihmc.pubsub.attributes.TopicAttributes.TopicKind;
import us.ihmc.pubsub.attributes.WriterQosHolder;
import us.ihmc.pubsub.common.Guid;

/**
 * Listener for the publisher endpoint discovery protocol
 * 
 * @author Jesper Smith
 *
 */
public interface PublisherEndpointDiscoveryListener
{

   /**
    * Callback for a new topic change event.
    *
    * 
    * @param isAlive
    * @param guid
    * @param unicastLocatorList
    * @param multicastLocatorList
    * @param participantGuid
    * @param typeName
    * @param topicName
    * @param userDefinedId
    * @param typeMaxSerialized
    * @param topicKind
    * @param writerQosHolder holds implementation specific version of the WriterQos attributes. Cast to the implementation specific datatype. Only valid till this method returns.
    */
   void publisherTopicChange(boolean isAlive, Guid guid, ArrayList<Locator> unicastLocatorList, ArrayList<Locator> multicastLocatorList,
                             Guid participantGuid, String typeName, String topicName, int userDefinedId, long typeMaxSerialized, TopicKind topicKind,
                             WriterQosHolder writerQosHolder);

}

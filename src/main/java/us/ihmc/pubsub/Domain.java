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
package us.ihmc.pubsub;

import java.io.IOException;

import us.ihmc.pubsub.attributes.ParticipantAttributes;
import us.ihmc.pubsub.attributes.PublishModeKind;
import us.ihmc.pubsub.attributes.PublisherAttributes;
import us.ihmc.pubsub.attributes.ReliabilityKind;
import us.ihmc.pubsub.attributes.SubscriberAttributes;
import us.ihmc.pubsub.attributes.TopicAttributes.TopicKind;
import us.ihmc.pubsub.common.LogLevel;
import us.ihmc.pubsub.common.Time;
import us.ihmc.pubsub.participant.Participant;
import us.ihmc.pubsub.participant.ParticipantListener;
import us.ihmc.pubsub.publisher.Publisher;
import us.ihmc.pubsub.publisher.PublisherListener;
import us.ihmc.pubsub.subscriber.Subscriber;
import us.ihmc.pubsub.subscriber.SubscriberListener;

/**
 * Class Domain, use to interact with the Publisher Subscriber API of the IHMC Java RTPS API.
 * 
 * 
 * @author Jesper Smith
 *
 */
public interface Domain
{
   /**
    * Set the log level of the underlying implementation. 
    * 
    * The log is implementation specific.
    * 
    * @param level LogLevel to log at
    * 
    */
   public void setLogLevel(LogLevel level);
   
   /**
    * Create a Participant.
    * 
    * This method may allocate memory and is thread-safe
    * 
    * @param att Participant Attributes. Implementation specific specific participant attributes, see {@link #createParticipantAttributes() createParticipantAttributes}.
    * @param participantListener. Listener for newly discovered participants. Can be null
    * 
    * @return Participant handle
    * 
    * @throws IOException If no participant can be made
    * 
    */
   public Participant createParticipant(ParticipantAttributes att, ParticipantListener participantListener) throws IOException;
   
   /**
    * Create a Participant without a listener.
    * 
    * This method may allocate memory and is thread-safe
    * 
    * @param att Participant Attributes. Implementation specific specific participant attributes, see {@link #createParticipantAttributes() createParticipantAttributes}.
    * @param participantListener. Listener for newly discovered participants. Can be null
    * 
    * @return Participant handle
    * 
    * @throws IOException If no participant can be made
    * 
    */
   default Participant createParticipant(ParticipantAttributes att) throws IOException
   {
      return createParticipant(att, null);
   }

   /**
    * Create a Publisher in a Participant.
    * 
    * This method may allocate memory and is thread-safe
    * 
    * @param participant where you want to create the publisher
    * @param publisherAttributes Implementation specific publisher attributes, see {@link #createPublisherAttributes() createPublisherAttributes()}
    * @param listener Listener for publisher status. Can be null
    * 
    * @return Publisher handle
    * 
    * @throws IOException If the publisher cannot be made
    * @throws IllegalArgumentException If the attributes are invalid for this publisher
    */
   public Publisher createPublisher(Participant participant, PublisherAttributes publisherAttributes, PublisherListener listener) throws IOException, IllegalArgumentException;

   /**
    * Create a Publisher in a Participant without a listener.
    * 
    * This method may allocate memory and is thread-safe
    * 
    * @param participant where you want to create the publisher
    * @param publisherAttributes Implementation specific publisher attributes, see {@link #createPublisherAttributes() createPublisherAttributes()}
    * 
    * @return Publisher handle
    * 
    * @throws IOException If the publisher cannot be made
    * @throws IllegalArgumentException If the attributes are invalid for this publisher
    */
   default Publisher createPublisher(Participant participant, PublisherAttributes publisherAttributes) throws IOException, IllegalArgumentException
   {
      return createPublisher(participant, publisherAttributes, null);
   }
   
   /**
    * Create a Subscriber in a Participant.
    * 
    * @param participant the participant where you want to create the Publisher.
    * @param subscriberAttributes Implementation specific subscriber attributes, see {@link #createSubscriberAttributes() createSubscriberAttributes()}
    * @param listener Listener for subscriber status and messages. Can be null
    * @return Subscriber handle
    * @throws IOException If the subscriber cannot be made
    * @throws IllegalArgumentException If the attributes are invalid for this subscriber
    */
   public Subscriber createSubscriber(Participant participant, SubscriberAttributes subscriberAttributes, SubscriberListener listener) throws IOException, IllegalArgumentException;
   
   /**
    * Create a Subscriber in a Participant without a listener.
    * 
    * @param participant the participant where you want to create the Publisher.
    * @param subscriberAttributes Implementation specific subscriber attributes, see {@link #createSubscriberAttributes() createSubscriberAttributes()}
    * 
    * @return Subscriber handle
    * @throws IOException If the subscriber cannot be made
    * @throws IllegalArgumentException If the attributes are invalid for this subscriber
    */
   default Subscriber createSubscriber(Participant participant, SubscriberAttributes subscriberAttributes) throws IOException, IllegalArgumentException
   {
      return createSubscriber(participant, subscriberAttributes, null);
   }

   /**
    * Remove a Participant and all associated publishers and subscribers.
    * 
    * This method may allocate memory and is thread-safe
    * 
    * @param participant to remove
    * 
    * @return true if participant is found and removed
    */
   public boolean removeParticipant(Participant participant);

   /**
    * Remove a Publisher.
    * 
    * This method may allocate memory and is thread-safe
    * 
    * @param publisher
    * @return true if publisher is found and removed
    */
   public boolean removePublisher(Publisher publisher);
   
   
   /**
    * Remove a Subscriber.
    * 
    * This method may allocate memory and is thread-safe
    * 
    * @param publisher
    * @return true if subscriber is found and removed
    */
   public boolean removeSubscriber(Subscriber subscriber);
   
   /**
    * Return a registered type.
    * 
    * This method does not allocate memory and is thread-safe
    * 
    * @param participant
    * @param typeName
    * 
    * @return Registered type or null if not found
    */
   public TopicDataType<?> getRegisteredType(Participant participant, String typeName);
   
   /**
    * Register a type in a participant.
    * 
    * This method may allocate memory and is thread-safe
    * 
    * @param participant
    * @param topicDataType
    * 
    * @throws IllegalArgumentException 
    */
   public void registerType(Participant participant, TopicDataType<?> topicDataType) throws IllegalArgumentException;
   
   /**
    * Unregister a type in a participant
    * 
    * This method may allocate memory and is thread-safe
    * 
    * @param participant
    * @param typeName
    * @throws IOException
    */
   public void unregisterType(Participant participant, String typeName) throws IOException;
   
   public void stopAll();
   
   /**
    * Generate an implementation specific version of SubscriberAttributes
    * 
    * This method allocates memory
    * 
    * @return Implementation specific version of SubscriberAttributes
    */
   public SubscriberAttributes createSubscriberAttributes();
   
   /**
    * Generate an implementation specific version of PublisherAttributes
    * 
    * This method allocates memory
    * 
    * @return Implementation specific version of PublisherAttributes
    */
   public PublisherAttributes createPublisherAttributes();
   
   
   /**
    * Generate an implementation specific version of ParticipantAttributes
    * 
    * To access implementation specific features, cast the ParticipantAttributes to their implementation specific version.
    * 
    * This method allocates memory
    * 
    * @return Implementation specific version of ParticipantAttributes
    */
   public ParticipantAttributes createParticipantAttributes();
   
   /**
    * Create an implementation specific version of ParticipantAttributes with the following options set
    * 
    * - DomainId: domainId
    * - LeaseDuration: Time.Infinite
    * - Name: name
    * 
    * To access implementation specific features, cast the ParticipantAttributes to their implementation specific version.
    * 
    * @param domainId desired domainId for these attributes
    * @param name desired name for these attributes
    * @return Implementation specific version of ParticipantAttributes with reasonable defaults
    */
   default ParticipantAttributes createParticipantAttributes(int domainId, String name)
   {
      ParticipantAttributes participantAttributes = createParticipantAttributes();
      participantAttributes.setDomainId(domainId);
      participantAttributes.setLeaseDuration(Time.Infinite);
      participantAttributes.setName(name);
      return participantAttributes;
   }
   
   /**
    * Create an implementation specific version of SubscriberAttributes with the following options set
    * 
    * Topic.TopicKind: WITH_KEY if topicDataType.isGetKeyDefined() is true, NO_KEY otherwise
    * Topic.TopicDataType: topicDataType.getName();
    * Topic.TopicName: topicName
    * Topic.QoS.ReliabilityKind: reliablityKind
    * Topic.QoS.partitions: partitions
    * 
    * Furthermore, if topicDataType has not been registered with the participant then it will be registered.
    * 
    * @param participant Participant to register the topicDataType with.
    * @param topicDataType Topic data type.
    * @param topicName Topic name.
    * @param ReliabilityKind the default for subscribers is BEST_EFFORT
    * @param partitions [Optional] partitions this topic subscribes on. If none are given, no partitions will be set.
    * 
    * @return Implementation specific version of SubscriberAttributes with reasonable defaults.
    */
   default SubscriberAttributes createSubscriberAttributes(Participant participant, TopicDataType<?> topicDataType, String topicName, ReliabilityKind reliabilityKind, String... partitions)
   {
      TopicDataType<?> registeredType = getRegisteredType(participant, topicDataType.getName());
      if(registeredType == null)
      {
         registerType(participant, topicDataType);        
      }
      
      SubscriberAttributes subscriberAttributes = createSubscriberAttributes();
      subscriberAttributes.getTopic().setTopicKind(topicDataType.isGetKeyDefined() ? TopicKind.WITH_KEY : TopicKind.NO_KEY);
      subscriberAttributes.getTopic().setTopicDataType(topicDataType.getName());
      subscriberAttributes.getTopic().setTopicName(topicName);
      subscriberAttributes.getQos().setReliabilityKind(reliabilityKind);
      if(partitions != null)
      {
         for(String partition : partitions)
         {
            subscriberAttributes.getQos().addPartition(partition);
            
         }
      }
      return subscriberAttributes;
   }
   
   /**
    * Create an implementation specific version of PublisherAttributes with the following options set
    * 
    * Topic.TopicKind: WITH_KEY if topicDataType.isGetKeyDefined() is true, NO_KEY otherwise
    * Topic.TopicDataType: topicDataType.getName();
    * Topic.TopicName: topicName
    * Topic.QoS.partitions: partitions
    * Topic.QoS.ReliabilityKind: reliablityKind
    * if topicDataType.getTypeSize() > 65kB QoS.publishMode will be set to ASYNCHRONOUS_PUBLISH_MODE
    * 
    * Furthermore, if topicDataType has not been registered with the participant then it will be registered.
    * 
    * @param participant Participant to register the topicDataType with.
    * @param topicDataType Topic data type.
    * @param topicName Topic name.
    * @param ReliabilityKind the default for publishers is RELIABLE
    * @param partitions [Optional] partitions this topic publishes on. If none are given, no partitions will be set.
    * 
    * @return Implementation specific version of PublisherAttributes with reasonable defaults.
    */
   default PublisherAttributes createPublisherAttributes(Participant participant, TopicDataType<?> topicDataType, String topicName, ReliabilityKind reliablity, String... partitions)
   {
      TopicDataType<?> registeredType = getRegisteredType(participant, topicDataType.getName());
      if(registeredType == null)
      {
         registerType(participant, topicDataType);        
      }
      
      PublisherAttributes publisherAttributes = createPublisherAttributes();
      publisherAttributes.getTopic().setTopicKind(topicDataType.isGetKeyDefined() ? TopicKind.WITH_KEY : TopicKind.NO_KEY);
      publisherAttributes.getTopic().setTopicDataType(topicDataType.getName());
      publisherAttributes.getTopic().setTopicName(topicName);
      publisherAttributes.getQos().setReliabilityKind(reliablity);
      if(partitions != null)
      {
         for(String partition : partitions)
         {
            publisherAttributes.getQos().addPartition(partition);
            
         }
      }
      
      if(topicDataType.getTypeSize() > 65000)
      {
         publisherAttributes.getQos().setPublishMode(PublishModeKind.ASYNCHRONOUS_PUBLISH_MODE);
      }
      
      return publisherAttributes;

   }
}

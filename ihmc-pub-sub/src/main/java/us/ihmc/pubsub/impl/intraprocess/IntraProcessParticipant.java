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
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.attributes.ParticipantAttributes;
import us.ihmc.pubsub.attributes.TopicAttributes.TopicKind;
import us.ihmc.pubsub.common.DiscoveryStatus;
import us.ihmc.pubsub.common.Guid;
import us.ihmc.pubsub.participant.Participant;
import us.ihmc.pubsub.participant.ParticipantDiscoveryInfo;
import us.ihmc.pubsub.participant.ParticipantListener;
import us.ihmc.pubsub.participant.PublisherEndpointDiscoveryListener;
import us.ihmc.pubsub.participant.SubscriberEndpointDiscoveryListener;
import us.ihmc.pubsub.publisher.PublisherListener;
import us.ihmc.pubsub.subscriber.SubscriberListener;

public class IntraProcessParticipant implements Participant
{

   private final IntraProcessParticipantAttributes attributes;
   private final Guid guid = new Guid();

   private boolean isAvailable = true;
   
   private int entityId = 0;

   private IntraProcessDomainImpl domain;
   private ParticipantListener participantListener;
   
   private PublisherEndpointDiscoveryListener publisherEndpointDiscoveryListener = null;
   private SubscriberEndpointDiscoveryListener subscriberEndpointDiscoveryListener = null;

   private final ArrayList<IntraProcessSubscriber> subscribers = new ArrayList<>();
   private final ArrayList<IntraProcessPublisher> publishers = new ArrayList<>();
   
   private final HashMap<String, TopicDataType<?>> registeredTopicDataTypes = new HashMap<>();

   IntraProcessParticipant(IntraProcessDomainImpl domain, IntraProcessParticipantAttributes att, ParticipantListener participantListener)
   {
      this.attributes = att;
      this.participantListener = participantListener;
      this.domain = domain;

      byte[] guidBytes = new byte[12];
      Random random = new Random();
      random.nextBytes(guidBytes);

      guid.getGuidPrefix().setValue(guidBytes);

   }

   IntraProcessDomainImpl getDomain()
   {
      return domain;
   }
   
   String getName()
   {
      return attributes.getName();
   }

   @Override
   public Guid getGuid()
   {
      return guid;
   }

   @Override
   public ParticipantAttributes getAttributes()
   {
      return attributes;
   }

   @Override
   public void registerEndpointDiscoveryListeners(PublisherEndpointDiscoveryListener publisherEndpointDiscoveryListener,
                                                  SubscriberEndpointDiscoveryListener subscriberEndpointDiscoveryListener)
         throws IOException
   {
      this.subscriberEndpointDiscoveryListener = subscriberEndpointDiscoveryListener;
      this.publisherEndpointDiscoveryListener = publisherEndpointDiscoveryListener;
   }

   @Override
   public int get_no_publisher(String target_topic)
   {
      int size = 0;
      for (IntraProcessPublisher publisher : publishers)
      {
         if (publisher.getAttributes().getTopic().getTopicName().equals(target_topic))
         {
            size++;
         }
      }
      return size;
   }

   @Override
   public int get_no_subscribers(String target_topic)
   {
      int size = 0;
      for (IntraProcessSubscriber subscriber : subscribers)
      {
         if (subscriber.getAttributes().getTopic().getTopicName().equals(target_topic))
         {
            size++;
         }
      }
      return size;
   }

   @Override
   public boolean isAvailable()
   {
      return isAvailable;
   }
   
   private Guid createNextGuid()
   {
      entityId++;
      
      Guid child = new Guid();
      child.getGuidPrefix().setValue(guid.getGuidPrefix().getValue());
      child.getEntity().setValue(ByteBuffer.allocate(4).putInt(entityId).array());
      return child;
      
   }
   
   IntraProcessPublisher createPublisher(IntraProcessDomainImpl domain, IntraProcessPublisherAttributes attr, PublisherListener listener) throws IOException
   {
      
      IntraProcessPublisher publisher = new IntraProcessPublisher(createNextGuid(), domain, this, attr, listener);
      publishers.add(publisher);
      return publisher;
   }
   
   IntraProcessSubscriber createSubscriber(IntraProcessDomainImpl domain, IntraProcessSubscriberAttributes attr, SubscriberListener listener) throws IOException
   {
      IntraProcessSubscriber subscriber = new IntraProcessSubscriber(createNextGuid(), domain, this, attr, listener);
      subscribers.add(subscriber);
      return subscriber;
   }

   void notifyParticipantListener(IntraProcessParticipant participant, DiscoveryStatus discoveryStatus)
   {
      if (participantListener != null)
      {
         ParticipantDiscoveryInfo info = new ParticipantDiscoveryInfo(participant.getName(), participant.getGuid(), discoveryStatus);
         participantListener.onParticipantDiscovery(participant, info);
      }
   }

   void notifySubscriberDiscoveryListener(IntraProcessSubscriber subscriber)
   {
      if (subscriberEndpointDiscoveryListener != null)
      {
         subscriberEndpointDiscoveryListener.subscriberTopicChange(true, subscriber.getGuid(), false, new ArrayList<>(), new ArrayList<>(),
                                                                   subscriber.getParticipant().getGuid(), subscriber.getAttributes().getTopic().getTopicName(),
                                                                   subscriber.getAttributes().getTopic().getTopicDataType(), -1, TopicKind.NO_KEY,
                                                                   new IntraProcessReaderQosHolder(subscriber.getAttributes().getQos()));
      }
   }

   void notifyPublisherDiscoveryListener(IntraProcessPublisher publisher)
   {
      if (publisherEndpointDiscoveryListener != null)
      {
         publisherEndpointDiscoveryListener.publisherTopicChange(true, publisher.getGuid(), new ArrayList<>(), new ArrayList<>(),
                                                                 publisher.getParticipant().getGuid(), publisher.getAttributes().getTopic().getTopicName(),
                                                                 publisher.getAttributes().getTopic().getTopicDataType(), -1,
                                                                 publisher.getTopicDataType().getTypeSize(), TopicKind.NO_KEY,
                                                                 new IntraProcessWriterQosHolder(publisher.getAttributes().getQos()));
      }
   }

   TopicDataType<?> getTopicDataType(String topicDataType)
   {
      return registeredTopicDataTypes.get(topicDataType);
   }
   
   void registerTopicDataType(TopicDataType<?> type)
   {
      registeredTopicDataTypes.put(type.getName(), type);
   }

   public void unRegisterTopicDataType(String typeName) throws IOException
   {
      if(registeredTopicDataTypes.remove(typeName) == null)
      {
         throw new IOException("Cannot remove " + typeName + " from participant " + getName() + ". Type not registered");
      }
   }

   List<IntraProcessSubscriber> getSubscribers()
   {
      return new ArrayList<>(subscribers);
   }

   List<IntraProcessPublisher> getPublishers()
   {
      return new ArrayList<>(publishers);
   }

   void unregister(IntraProcessSubscriber subscriber)
   {
      subscribers.remove(subscriber);
   }
   
   void unregister(IntraProcessPublisher publisher)
   {
      publishers.remove(publisher);
   }

   void destroy()
   {
      isAvailable = false;
      domain = null;
      participantListener = null;
      publisherEndpointDiscoveryListener = null;
      subscriberEndpointDiscoveryListener = null;
      registeredTopicDataTypes.clear();
   }
}

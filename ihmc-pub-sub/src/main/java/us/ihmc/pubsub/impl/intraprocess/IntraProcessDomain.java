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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import us.ihmc.pubsub.Domain;
import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.attributes.ParticipantAttributes;
import us.ihmc.pubsub.attributes.PublisherAttributes;
import us.ihmc.pubsub.attributes.SubscriberAttributes;
import us.ihmc.pubsub.common.LogLevel;
import us.ihmc.pubsub.participant.Participant;
import us.ihmc.pubsub.participant.ParticipantListener;
import us.ihmc.pubsub.publisher.Publisher;
import us.ihmc.pubsub.publisher.PublisherListener;
import us.ihmc.pubsub.subscriber.Subscriber;
import us.ihmc.pubsub.subscriber.SubscriberListener;

public class IntraProcessDomain implements Domain
{
   private LogLevel logLevel = LogLevel.WARNING;

   private static IntraProcessDomain instance = null;

   private final IntraProcessDomainImpl domains[] = new IntraProcessDomainImpl[233];

   private final HashMap<Participant, IntraProcessParticipant> participants = new HashMap<>();

   public static synchronized IntraProcessDomain getInstance()
   {
      if (instance == null)
      {
         instance = new IntraProcessDomain();
      }
      return instance;
   }

   private IntraProcessDomain()
   {

   }

   @Override
   public void setLogLevel(LogLevel level)
   {
      this.logLevel = level;
   }

   private synchronized IntraProcessDomainImpl getOrCreateDomain(int domainId) throws IOException
   {
      if (domainId < 0 || domainId > 232)
      {
         throw new IOException("Invalid domain id. Valid range for domain id is0 - 232");
      }

      if (domains[domainId] == null)
      {
         domains[domainId] = new IntraProcessDomainImpl(domainId, logLevel);
      }

      return domains[domainId];
   }

   @Override
   public synchronized Participant createParticipant(ParticipantAttributes att, ParticipantListener participantListener) throws IOException
   {
      if (att instanceof IntraProcessParticipantAttributes)
      {
         IntraProcessDomainImpl domain = getOrCreateDomain(((IntraProcessParticipantAttributes) att).getDomain());
         IntraProcessParticipant participant = domain.createParticipant((IntraProcessParticipantAttributes) att, participantListener);
         participants.put(participant, participant);
         return participant;

      }
      else
      {
         throw new IllegalArgumentException("Participant attributes have to be an instance of IntraProcessParticipantAttributes. Use domain.createParticipantAttributes()");
      }

   }

   @Override
   public synchronized Publisher createPublisher(Participant participant, PublisherAttributes publisherAttributes, PublisherListener listener)
         throws IOException, IllegalArgumentException
   {
      
      IntraProcessParticipant intraProcessParticipant = participants.get(participant);
      if(intraProcessParticipant == null)
      {
         throw new IllegalArgumentException("This participant is not registered with this domain.");
      }
      
      if(publisherAttributes instanceof IntraProcessPublisherAttributes)
      {
         return intraProcessParticipant.getDomain().createPublisher(intraProcessParticipant, (IntraProcessPublisherAttributes) publisherAttributes, listener);
      }
      else
      {
         throw new IllegalArgumentException("Publisher attributes have to be an instance of IntraProcessPublisherAttributes. Use domain.createPublisherAttributes()");
      }
   }

   @Override
   public synchronized Subscriber createSubscriber(Participant participant, SubscriberAttributes subscriberAttributes, SubscriberListener listener)
         throws IOException, IllegalArgumentException
   {
      IntraProcessParticipant intraProcessParticipant = participants.get(participant);
      if(intraProcessParticipant == null)
      {
         throw new IllegalArgumentException("This participant is not registered with this domain.");
      }
      
      if(subscriberAttributes instanceof IntraProcessSubscriberAttributes)
      {
         return intraProcessParticipant.getDomain().createSubscriber(intraProcessParticipant, (IntraProcessSubscriberAttributes) subscriberAttributes, listener);
      }
      else
      {
         throw new IllegalArgumentException("Publisher attributes have to be an instance of IntraProcessPublisherAttributes. Use domain.createPublisherAttributes()");
      }
   }

   @Override
   public synchronized boolean removeParticipant(Participant participant)
   {
      IntraProcessParticipant intraProcessParticipant = participants.get(participant);
      if(intraProcessParticipant == null)
      {
         throw new IllegalArgumentException("This participant is not registered with this domain.");
      }

      if(intraProcessParticipant.getDomain().removeParticipant(intraProcessParticipant))
      {
         participants.remove(participant);
         return true;
      }
      else
      {
         return false;
      }
   }

   @Override
   public synchronized boolean removePublisher(Publisher publisher)
   {
      if(publisher instanceof IntraProcessPublisher)
      {
         IntraProcessPublisher intraProcessPublisher = (IntraProcessPublisher) publisher;
         return intraProcessPublisher.getParticipant().getDomain().removePublisher(intraProcessPublisher);
      }
      else
      {
         throw new RuntimeException("Publisher is not of type IntraProcessPublisher");
      }
   }

   @Override
   public synchronized boolean removeSubscriber(Subscriber subscriber)
   {
      if(subscriber instanceof IntraProcessSubscriber)
      {
         IntraProcessSubscriber intraProcessSubscriber = (IntraProcessSubscriber) subscriber;
         return intraProcessSubscriber.getParticipant().getDomain().removeSubscriber(intraProcessSubscriber);
      }
      else
      {
         throw new RuntimeException("Subscriber is not of type IntraProcessSubscriber");
      }
   }

   @Override
   public TopicDataType<?> getRegisteredType(Participant participant, String typeName)
   {
      IntraProcessParticipant intraProcessParticipant = participants.get(participant);
      if(intraProcessParticipant == null)
      {
         throw new IllegalArgumentException("This participant is not registered with this domain.");
      }

      return intraProcessParticipant.getTopicDataType(typeName);
   }

   @Override
   public synchronized void registerType(Participant participant, TopicDataType<?> topicDataType) throws IllegalArgumentException
   {
      IntraProcessParticipant intraProcessParticipant = participants.get(participant);
      if(intraProcessParticipant == null)
      {
         throw new IllegalArgumentException("This participant is not registered with this domain.");
      }

      intraProcessParticipant.registerTopicDataType(topicDataType);
   }

   @Override
   public synchronized void unregisterType(Participant participant, String typeName) throws IOException
   {
      IntraProcessParticipant intraProcessParticipant = participants.get(participant);
      if(intraProcessParticipant == null)
      {
         throw new IllegalArgumentException("This participant is not registered with this domain.");
      }

      intraProcessParticipant.unRegisterTopicDataType(typeName);
   }

   @Override
   public synchronized void stopAll()
   {
      List<IntraProcessParticipant> participantsToRemove = new ArrayList<>(participants.values());
      for(IntraProcessParticipant participantToRemove : participantsToRemove)
      {
         removeParticipant(participantToRemove);
      }
   }

   @Override
   public SubscriberAttributes createSubscriberAttributes()
   {
      return new IntraProcessSubscriberAttributes();
   }

   @Override
   public PublisherAttributes createPublisherAttributes()
   {
      return new IntraProcessPublisherAttributes();
   }

   @Override
   public ParticipantAttributes createParticipantAttributes()
   {
      return new IntraProcessParticipantAttributes();
   }

}

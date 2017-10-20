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
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;

import us.ihmc.pubsub.common.DiscoveryStatus;
import us.ihmc.pubsub.common.LogLevel;
import us.ihmc.pubsub.common.MatchingInfo.MatchingStatus;
import us.ihmc.pubsub.participant.Participant;
import us.ihmc.pubsub.participant.ParticipantListener;
import us.ihmc.pubsub.subscriber.Subscriber;
import us.ihmc.pubsub.subscriber.SubscriberListener;

class IntraProcessDomainImpl
{

   private final Executor threadPool = Executors.newCachedThreadPool();

   private final ReentrantLock domainLock = new ReentrantLock();

   private final int domainID;

   private final List<IntraProcessParticipant> participants = new ArrayList<>();
   private final HashMap<String, List<IntraProcessSubscriber>> subscribers = new HashMap<>();
   private final HashMap<String, List<IntraProcessPublisher>> publishers = new HashMap<>();

   private LogLevel logLevel;

   public IntraProcessDomainImpl(int domainID, LogLevel logLevel)
   {
      this.domainID = domainID;
      this.logLevel = logLevel;
   }

   private void matchParticipants(Consumer<IntraProcessParticipant> exec)
   {
      for (IntraProcessParticipant participant : participants)
      {
         if (logLevel == LogLevel.INFO)
         {
            IntraProcessLog.info(this, "Notifying matched participant " + participant);
         }
         threadPool.execute(() -> exec.accept(participant));
      }
   }

   private void matchSubscribers(IntraProcessPublisherAttributes publisherToMatch, Consumer<IntraProcessSubscriber> exec)
   {
      List<IntraProcessSubscriber> topicSubscribers = subscribers.get(publisherToMatch.getTopic().getTopicName());
      for (IntraProcessSubscriber subscriber : topicSubscribers)
      {
         if (subscriber.getAttributes().publisherMatches(publisherToMatch))
         {
            if (logLevel == LogLevel.INFO)
            {
               IntraProcessLog.info(this, "Notifying matched subscriber " + subscriber);
            }
            threadPool.execute(() -> exec.accept(subscriber));
         }
      }
   }

   private void matchPublishers(IntraProcessSubscriberAttributes subscriberToMatch, Consumer<IntraProcessPublisher> exec)
   {
      List<IntraProcessPublisher> topicPublishers = publishers.get(subscriberToMatch.getTopic().getTopicName());
      for (IntraProcessPublisher publisher : topicPublishers)
      {
         if (subscriberToMatch.publisherMatches(publisher.getAttributes()))
         {
            if (logLevel == LogLevel.INFO)
            {
               IntraProcessLog.info(this, "Notifying matched publisher " + publisher);
            }
            threadPool.execute(() -> exec.accept(publisher));
         }
      }
   }

   Participant createParticipant(IntraProcessParticipantAttributes attributes, ParticipantListener listener)
   {
      domainLock.lock();
      IntraProcessParticipant participant = new IntraProcessParticipant(attributes, listener);

      if (logLevel == LogLevel.INFO)
      {
         IntraProcessLog.info(this, "Adding participant " + participant);
      }
      matchParticipants((participantToNotify) -> participantToNotify.notifyParticipantListener(participant, DiscoveryStatus.DISCOVERED_RTPSPARTICIPANT));
      participants.add(participant);

      domainLock.unlock();

      return participant;
   }

   void removeParticipant(IntraProcessParticipant participant) throws IOException
   {
      domainLock.lock();
      if (logLevel == LogLevel.INFO)
      {
         IntraProcessLog.info(this, "Removing participant " + participant);
      }
      if (participants.remove(participant))
      {
         matchParticipants((participantToNotify) -> participantToNotify.notifyParticipantListener(participant, DiscoveryStatus.REMOVED_RTPSPARTICIPANT));
      }
      else
      {
         throw new IOException("No participant matched in domain");
      }

      domainLock.unlock();
   }

   Subscriber addSubscriber(IntraProcessParticipant participant, IntraProcessSubscriberAttributes attr, SubscriberListener listener)
   {
      domainLock.lock();
      IntraProcessSubscriber subscriber = participant.createSubscriber(this, attr, listener);
      
      String topicName = subscriber.getAttributes().getTopic().getTopicName();
      List<IntraProcessSubscriber> topicSubscribers = subscribers.get(topicName);
      if (topicSubscribers == null)
      {
         if (logLevel == LogLevel.INFO)
         {
            IntraProcessLog.info(this, "Creating new subscriber list for topic " + topicName);
         }
         topicSubscribers = new ArrayList<>();
         subscribers.put(topicName, new ArrayList<>());
      }

      if (logLevel == LogLevel.INFO)
      {
         IntraProcessLog.info(this, "Adding subscriber" + subscriber);
      }
      topicSubscribers.add(subscriber);

      if (logLevel == LogLevel.INFO)
         IntraProcessLog.info(this, "Notifying subscribers discovery listeners");
      matchParticipants((participantToNotify) -> participantToNotify.notifySubscriberDiscoveryListener(subscriber));
      if (logLevel == LogLevel.INFO)
         IntraProcessLog.info(this, "Notifying publisher listeners");
      matchPublishers(subscriber.getAttributes(), (publisher) -> publisher.notifyPublisherListener(subscriber, MatchingStatus.MATCHED_MATCHING));

      domainLock.unlock();
      
      return subscriber;
   }

   void removeSubscriber(IntraProcessSubscriber subscriber) throws IOException
   {
      domainLock.lock();
      String topicName = subscriber.getAttributes().getTopic().getTopicName();
      List<IntraProcessSubscriber> topicSubscribers = subscribers.get(topicName);
      if (topicSubscribers == null)
      {
         throw new IOException("No subscriber matched in domain");
      }

      if (logLevel == LogLevel.INFO)
      {
         IntraProcessLog.info(this, "Removing subscriber" + subscriber);
      }
      if (topicSubscribers.remove(subscriber))

      {
         if (logLevel == LogLevel.INFO)
            IntraProcessLog.info(this, "Notifying publisher listeners");
         matchPublishers(subscriber.getAttributes(), (publisher) -> publisher.notifyPublisherListener(subscriber, MatchingStatus.REMOVED_MATCHING));
      }
      else
      {
         throw new IOException("No subscriber matched in domain");
      }

      domainLock.unlock();
   }

   void addPublisher(IntraProcessPublisher publisher)
   {
      domainLock.lock();
      String topicName = publisher.getAttributes().getTopic().getTopicName();
      List<IntraProcessPublisher> topicPublishers = publishers.get(topicName);
      if (topicPublishers == null)
      {
         if (logLevel == LogLevel.INFO)
         {
            IntraProcessLog.info(this, "Creating new publisher list for topic " + topicName);
         }
         topicPublishers = new ArrayList<>();
         publishers.put(topicName, new ArrayList<>());
      }

      if (logLevel == LogLevel.INFO)
      {
         IntraProcessLog.info(this, "Adding publisher" + publisher);
      }
      topicPublishers.add(publisher);

      if (logLevel == LogLevel.INFO)
         IntraProcessLog.info(this, "Notifying publisher discovery listeners");
      matchParticipants((participant) -> participant.notifyPublisherDiscoveryListener(publisher));
      if (logLevel == LogLevel.INFO)
         IntraProcessLog.info(this, "Notifying subscriber listeners");
      matchSubscribers(publisher.getAttributes(), (subscriber) -> subscriber.notifySubscriberListener(publisher, MatchingStatus.MATCHED_MATCHING));

      domainLock.unlock();
   }

   void removePublisher(IntraProcessPublisher publisher) throws IOException
   {
      domainLock.lock();
      String topicName = publisher.getAttributes().getTopic().getTopicName();
      List<IntraProcessPublisher> topicSubscribers = publishers.get(topicName);
      if (topicSubscribers == null)
      {
         throw new IOException("No publisher matched in domain");
      }

      if (logLevel == LogLevel.INFO)
      {
         IntraProcessLog.info(this, "Removing publisher" + topicName);
      }
      if (topicSubscribers.remove(publisher))
      {
         if (logLevel == LogLevel.INFO)
            IntraProcessLog.info(this, "Notifying subscriber listeners");
         matchSubscribers(publisher.getAttributes(), (subscriber) -> subscriber.notifySubscriberListener(publisher, MatchingStatus.REMOVED_MATCHING));
      }
      else
      {
         throw new IOException("No subscriber matched in domain");
      }

      domainLock.unlock();
   }

}

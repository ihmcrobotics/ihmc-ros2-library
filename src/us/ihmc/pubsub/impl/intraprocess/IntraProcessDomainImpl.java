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

class IntraProcessDomainImpl
{

   private final Executor threadPool = Executors.newCachedThreadPool();

   private final ReentrantLock domainLock = new ReentrantLock();

   private final int domainID;

   private final List<IntraProcessParticipant> participants = new ArrayList<>();
   private final HashMap<TopicSubscription, List<IntraProcessSubscriber>> subscribers = new HashMap<>();
   private final HashMap<TopicSubscription, List<IntraProcessPublisher>> publishers = new HashMap<>();

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

   private void matchSubscribers(TopicSubscription publisherToMatch, Consumer<IntraProcessSubscriber> exec)
   {
      List<IntraProcessSubscriber> topicSubscribers = subscribers.get(publisherToMatch);
      for (IntraProcessSubscriber subscriber : topicSubscribers)
      {
         if (subscriber.getSubscription().publisherMatches(publisherToMatch))
         {
            if (logLevel == LogLevel.INFO)
            {
               IntraProcessLog.info(this, "Notifying matched subscriber " + subscriber);
            }
            threadPool.execute(() -> exec.accept(subscriber));
         }
      }
   }

   private void matchPublishers(TopicSubscription subscriberToMatch, Consumer<IntraProcessPublisher> exec)
   {
      List<IntraProcessPublisher> topicPublishers = publishers.get(subscriberToMatch);
      for (IntraProcessPublisher publisher : topicPublishers)
      {
         if (subscriberToMatch.publisherMatches(publisher.getSubscription()))
         {
            if (logLevel == LogLevel.INFO)
            {
               IntraProcessLog.info(this, "Notifying matched publisher " + publisher);
            }
            threadPool.execute(() -> exec.accept(publisher));
         }
      }
   }

   public void addParticipant(IntraProcessParticipant participant)
   {
      domainLock.lock();

      if (logLevel == LogLevel.INFO)
      {
         IntraProcessLog.info(this, "Adding participant " + participant);
      }
      matchParticipants((participantToNotify) -> participantToNotify.notifyParticipantListener(participant, DiscoveryStatus.DISCOVERED_RTPSPARTICIPANT));
      participants.add(participant);

      domainLock.unlock();
   }

   public void removeParticipant(IntraProcessParticipant participant) throws IOException
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

   public void addSubscriber(IntraProcessSubscriber subscriber)
   {
      domainLock.lock();
      List<IntraProcessSubscriber> topicSubscribers = subscribers.get(subscriber.getSubscription());
      if (topicSubscribers == null)
      {
         if (logLevel == LogLevel.INFO)
         {
            IntraProcessLog.info(this, "Creating new subscriber list for topic " + subscriber.getSubscription());
         }
         topicSubscribers = new ArrayList<>();
         subscribers.put(subscriber.getSubscription(), new ArrayList<>());
      }

      if (logLevel == LogLevel.INFO)
      {
         IntraProcessLog.info(this, "Adding subscriber" + subscriber);
      }
      topicSubscribers.add(subscriber);

      if (logLevel == LogLevel.INFO)
         IntraProcessLog.info(this, "Notifying subscribers discovery listeners");
      matchParticipants((participant) -> participant.notifySubscriberDiscoveryListener(subscriber));
      if (logLevel == LogLevel.INFO)
         IntraProcessLog.info(this, "Notifying publisher listeners");
      matchPublishers(subscriber.getSubscription(), (publisher) -> publisher.notifyPublisherListener(subscriber, MatchingStatus.MATCHED_MATCHING));

      domainLock.unlock();
   }

   public void removeSubscriber(IntraProcessSubscriber subscriber) throws IOException
   {
      domainLock.lock();
      List<IntraProcessSubscriber> topicSubscribers = subscribers.get(subscriber.getSubscription());
      if (topicSubscribers == null)
      {
         throw new IOException("No subcriber matched in domain");
      }

      if (logLevel == LogLevel.INFO)
      {
         IntraProcessLog.info(this, "Removing subscriber" + subscriber);
      }
      if (topicSubscribers.remove(subscriber))

      {
         if (logLevel == LogLevel.INFO)
            IntraProcessLog.info(this, "Notifying publisher listeners");
         matchPublishers(subscriber.getSubscription(), (publisher) -> publisher.notifyPublisherListener(subscriber, MatchingStatus.REMOVED_MATCHING));
      }
      else
      {
         throw new IOException("No subscriber matched in domain");
      }

      domainLock.unlock();
   }

   public void addPublisher(IntraProcessPublisher publisher)
   {
      domainLock.lock();
      List<IntraProcessPublisher> topicPublishers = publishers.get(publisher.getSubscription());
      if (topicPublishers == null)
      {
         if (logLevel == LogLevel.INFO)
         {
            IntraProcessLog.info(this, "Creating new publisher list for topic " + publisher.getSubscription());
         }
         topicPublishers = new ArrayList<>();
         publishers.put(publisher.getSubscription(), new ArrayList<>());
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
      matchSubscribers(publisher.getSubscription(), (subscriber) -> subscriber.notifySubscriberListener(publisher, MatchingStatus.MATCHED_MATCHING));

      domainLock.unlock();
   }

}

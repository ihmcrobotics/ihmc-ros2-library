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
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;

import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.common.DiscoveryStatus;
import us.ihmc.pubsub.common.LogLevel;
import us.ihmc.pubsub.common.MatchingInfo.MatchingStatus;
import us.ihmc.pubsub.common.SampleInfo;
import us.ihmc.pubsub.participant.ParticipantListener;
import us.ihmc.pubsub.publisher.PublisherListener;
import us.ihmc.pubsub.subscriber.Subscriber;
import us.ihmc.pubsub.subscriber.SubscriberListener;

class IntraProcessDomainImpl
{

//   private final Executor threadPool = Executors.newCachedThreadPool(); // give threads a name
   private final Executor threadPool = Executors.newSingleThreadExecutor(new ThreadFactory()
   {
      private final AtomicInteger threadNumber = new AtomicInteger(1);

      @Override
      public Thread newThread(Runnable r)
      {
         Thread t = new Thread(r, "IntraProcessDomainImpl-thread-" + threadNumber.getAndIncrement());

         if (t.isDaemon())
            t.setDaemon(false);
         if (t.getPriority() != Thread.NORM_PRIORITY)
            t.setPriority(Thread.NORM_PRIORITY);

         return t;
      }
   });

   private final ReentrantLock domainLock = new ReentrantLock();

   private final List<IntraProcessParticipant> participants = new ArrayList<>();
   private final HashMap<String, List<IntraProcessSubscriber>> subscribers = new HashMap<>();
   private final HashMap<String, List<IntraProcessPublisher>> publishers = new HashMap<>();

   private LogLevel logLevel;
   
   public IntraProcessDomainImpl(int domainID, LogLevel logLevel)
   {
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
      if (topicSubscribers != null)
      {
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
   }

   private void matchPublishers(IntraProcessSubscriberAttributes subscriberToMatch, Consumer<IntraProcessPublisher> exec)
   {
      List<IntraProcessPublisher> topicPublishers = publishers.get(subscriberToMatch.getTopic().getTopicName());
      if (topicPublishers != null)
      {
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
   }

   IntraProcessParticipant createParticipant(IntraProcessParticipantAttributes attributes, ParticipantListener listener)
   {
      domainLock.lock();
      try
      {
         IntraProcessParticipant participant = new IntraProcessParticipant(this, attributes, listener);

         if (logLevel == LogLevel.INFO)
         {
            IntraProcessLog.info(this, "Adding participant " + participant);
         }
         matchParticipants((participantToNotify) -> participantToNotify.notifyParticipantListener(participant, DiscoveryStatus.DISCOVERED_RTPSPARTICIPANT));

         if (logLevel == LogLevel.INFO)
            IntraProcessLog.info(this, "Notifying self of existing participants");
         matchParticipants((participantOnline) -> participant.notifyParticipantListener(participantOnline, DiscoveryStatus.DISCOVERED_RTPSPARTICIPANT));

         participants.add(participant);
         return participant;
      } finally
      {
         domainLock.unlock();
      }
   }

   boolean removeParticipant(IntraProcessParticipant participant)
   {
      domainLock.lock();
      try
      {
         if (logLevel == LogLevel.INFO)
         {
            IntraProcessLog.info(this, "Removing participant " + participant);
         }
         if (participants.remove(participant))
         {
            for (IntraProcessSubscriber subscriber : participant.getSubscribers())
            {
               removeSubscriber(subscriber);
            }
            for (IntraProcessPublisher publisher : participant.getPublishers())
            {
               removePublisher(publisher);
            }
            participant.destroy();
            matchParticipants((participantToNotify) -> participantToNotify.notifyParticipantListener(participant, DiscoveryStatus.REMOVED_RTPSPARTICIPANT));
            return true;
         }
         else
         {
            return false;
         }
      } finally
      {
         domainLock.unlock();
      }

   }

   Subscriber createSubscriber(IntraProcessParticipant participant, IntraProcessSubscriberAttributes attr, SubscriberListener listener) throws IOException
   {
      domainLock.lock();
      try
      {
         IntraProcessSubscriber subscriber = participant.createSubscriber(this, attr, listener);

         String topicName = attr.getTopic().getTopicName();
         List<IntraProcessSubscriber> topicSubscribers = subscribers.get(topicName);
         if (topicSubscribers == null)
         {
            if (logLevel == LogLevel.INFO)
            {
               IntraProcessLog.info(this, "Creating new subscriber list for topic " + topicName);
            }
            topicSubscribers = new ArrayList<>();
            subscribers.put(topicName, topicSubscribers);
         }

         if (logLevel == LogLevel.INFO)
         {
            IntraProcessLog.info(this, "Adding subscriber " + subscriber);
         }
         topicSubscribers.add(subscriber);

         if (logLevel == LogLevel.INFO)
            IntraProcessLog.info(this, "Notifying subscribers discovery listeners");
         matchParticipants((participantToNotify) -> participantToNotify.notifySubscriberDiscoveryListener(subscriber));
         if (logLevel == LogLevel.INFO)
            IntraProcessLog.info(this, "Notifying publisher listeners");
         matchPublishers(subscriber.getAttributes(), (publisher) -> publisher.notifyPublisherListener(subscriber, MatchingStatus.MATCHED_MATCHING));

         if (logLevel == LogLevel.INFO)
            IntraProcessLog.info(this, "Notifying self listener of existing publishers");
         matchPublishers(subscriber.getAttributes(), (publisher) -> subscriber.notifySubscriberListener(publisher, MatchingStatus.MATCHED_MATCHING));

         return subscriber;
      } finally
      {
         domainLock.unlock();
      }

   }

   boolean removeSubscriber(IntraProcessSubscriber subscriber)
   {
      domainLock.lock();
      try
      {
         String topicName = subscriber.getAttributes().getTopic().getTopicName();
         List<IntraProcessSubscriber> topicSubscribers = subscribers.get(topicName);
         if (topicSubscribers == null)
         {
            if (logLevel == LogLevel.WARNING)
               IntraProcessLog.warn(this, "Subscriber is not part of this domain");

            return false;
         }

         if (logLevel == LogLevel.INFO)
         {
            IntraProcessLog.info(this, "Removing subscriber " + subscriber);
         }
         if (topicSubscribers.remove(subscriber))
         {
            subscriber.getParticipant().unregister(subscriber);
            if (logLevel == LogLevel.INFO)
               IntraProcessLog.info(this, "Notifying publisher listeners");
            matchPublishers(subscriber.getAttributes(), (publisher) -> publisher.notifyPublisherListener(subscriber, MatchingStatus.REMOVED_MATCHING));
            subscriber.destroy();
         }
         else
         {
            if (logLevel == LogLevel.WARNING)
               IntraProcessLog.warn(this, "No subscriber matched in this domain");
            return false;
         }
         return true;
      } finally
      {
         domainLock.unlock();

      }

   }

   IntraProcessPublisher createPublisher(IntraProcessParticipant participant, IntraProcessPublisherAttributes attr, PublisherListener listener)
         throws IOException
   {
      domainLock.lock();
      try
      {
         IntraProcessPublisher publisher = participant.createPublisher(this, attr, listener);
         String topicName = attr.getTopic().getTopicName();
         List<IntraProcessPublisher> topicPublishers = publishers.get(topicName);
         if (topicPublishers == null)
         {
            if (logLevel == LogLevel.INFO)
            {
               IntraProcessLog.info(this, "Creating new publisher list for topic " + topicName);
            }
            topicPublishers = new ArrayList<>();
            publishers.put(topicName, topicPublishers);
         }

         if (logLevel == LogLevel.INFO)
         {
            IntraProcessLog.info(this, "Adding publisher " + publisher);
         }
         topicPublishers.add(publisher);

         if (logLevel == LogLevel.INFO)
            IntraProcessLog.info(this, "Notifying publisher discovery listeners");
         matchParticipants((participantToNotify) -> participantToNotify.notifyPublisherDiscoveryListener(publisher));
         if (logLevel == LogLevel.INFO)
            IntraProcessLog.info(this, "Notifying subscriber listeners");
         matchSubscribers(publisher.getAttributes(), (subscriber) -> subscriber.notifySubscriberListener(publisher, MatchingStatus.MATCHED_MATCHING));

         if (logLevel == LogLevel.INFO)
            IntraProcessLog.info(this, "Notify self listener of existing subscribers");
         matchSubscribers(publisher.getAttributes(), (subscriber) -> publisher.notifyPublisherListener(subscriber, MatchingStatus.MATCHED_MATCHING));

         return publisher;
      } finally
      {
         domainLock.unlock();
      }

   }

   boolean removePublisher(IntraProcessPublisher publisher)
   {
      domainLock.lock();
      try
      {
         String topicName = publisher.getAttributes().getTopic().getTopicName();
         List<IntraProcessPublisher> topicSubscribers = publishers.get(topicName);
         if (topicSubscribers == null)
         {
            if (logLevel == LogLevel.WARNING)
               IntraProcessLog.warn(this, "No publisher matched in domain");
            return false;
         }

         if (logLevel == LogLevel.INFO)
         {
            IntraProcessLog.info(this, "Removing publisher " + topicName);
         }
         if (topicSubscribers.remove(publisher))
         {
            publisher.getParticipant().unregister(publisher);
            if (logLevel == LogLevel.INFO)
               IntraProcessLog.info(this, "Notifying subscriber listeners");
            matchSubscribers(publisher.getAttributes(), (subscriber) -> subscriber.notifySubscriberListener(publisher, MatchingStatus.REMOVED_MATCHING));
            publisher.destroy();
         }
         else
         {

            if (logLevel == LogLevel.WARNING)
               IntraProcessLog.warn(this, "No subscriber matched in domain");

            return false;
         }
         return true;
      } finally
      {
         domainLock.unlock();
      }
   }

   <T> void write(IntraProcessPublisherAttributes attr, TopicDataType<T> type, T data, SampleInfo info) throws IOException
   {
      domainLock.lock();
      
      try
      {
         List<IntraProcessSubscriber> topicSubscribers = subscribers.get(attr.getTopic().getTopicName());
         if (topicSubscribers != null)
         {
            for (IntraProcessSubscriber subscriber : topicSubscribers)
            {
               if (subscriber.getAttributes().publisherMatches(attr))
               {
                  if (logLevel == LogLevel.INFO)
                  {
//                     IntraProcessLog.info(this, "Publishing " + data + " to " + subscriber);
                  }

                  T newData = type.createData();
                  if (!newData.getClass().isAssignableFrom(data.getClass()))
                  {
                     throw new IOException("Expected message of type " + newData.getClass().getName() + "; got " + data.getClass().getName());
                  }

                  type.copy(data, newData);

                  SampleInfo newInfo = new SampleInfo();
                  newInfo.set(info);
                  threadPool.execute(() -> subscriber.putNextData(newData, newInfo));
               }
            }
         }
      } finally
      {
         domainLock.unlock();
      }
   }

}

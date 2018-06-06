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
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.common.Guid;
import us.ihmc.pubsub.common.MatchingInfo;
import us.ihmc.pubsub.common.MatchingInfo.MatchingStatus;
import us.ihmc.pubsub.common.SampleInfo;
import us.ihmc.pubsub.subscriber.Subscriber;
import us.ihmc.pubsub.subscriber.SubscriberListener;

class IntraProcessSubscriber<T> implements Subscriber<T>
{

   private class MessageHolder
   {
      @SuppressWarnings("unchecked")
      public MessageHolder(Object newData, SampleInfo newInfo)
      {
         this.message = (T) newData;
         this.info = newInfo;
      }

      T message;
      SampleInfo info;
   }

   private final ReentrantLock messageLock = new ReentrantLock();
   private final Condition messageCondition = messageLock.newCondition();
   
   private final TopicDataType<T> topicDataType;
   private final Guid guid;
   private final IntraProcessSubscriberAttributes attr;
   private IntraProcessParticipant participant;
   private SubscriberListener<T> listener;

   
   private final LinkedList<MessageHolder> messageQueue;

   private boolean available = true;

   IntraProcessSubscriber(Guid guid, IntraProcessDomainImpl domain, IntraProcessParticipant intraProcessParticipant, IntraProcessSubscriberAttributes attr,
                          SubscriberListener<T> listener)
         throws IOException
   {
      @SuppressWarnings("unchecked")
      TopicDataType<T> topicDataType = (TopicDataType<T>) intraProcessParticipant.getTopicDataType(attr.getTopic().getTopicDataType());
      if (topicDataType == null)
      {
         throw new IOException("Cannot registered publisher with topic " + attr.getTopic().getTopicDataType() + ". Topic data type is not registered.");
      }
      this.topicDataType = topicDataType.newInstance();
      this.guid = guid;
      this.participant = intraProcessParticipant;
      this.attr = attr;
      this.listener = listener;

      this.messageQueue = new LinkedList<>();
   }

   @Override
   public Guid getGuid()
   {
      return guid;
   }

   @Override
   public void waitForUnreadMessage(int timeoutInMilliseconds) throws InterruptedException
   {
      messageLock.lock();
      if(messageQueue.peek() == null)
      {
         if(timeoutInMilliseconds > 0)
         {
            messageCondition.await(timeoutInMilliseconds, TimeUnit.MILLISECONDS);
         }
         else
         {
            messageCondition.await();
         }
      }
      messageLock.unlock();
   }

   @Override
   public boolean readNextData(T data, SampleInfo info)
   {
      messageLock.lock();

      MessageHolder next = messageQueue.peek();
      if (next != null)
      {
         topicDataType.copy(next.message, (T) data);
         if (info != null)
         {
            info.set(next.info);
         }
         messageLock.unlock();
         return true;
      }
      else
      {
         messageLock.unlock();
         return false;
      }
   }

   @Override
   public T readNextData()
   {
      return readNextData(null);
   }

   @Override
   public T readNextData(SampleInfo info)
   {
      T nextData = topicDataType.createData();
      if (readNextData(nextData, info))
         return nextData;
      else
         return null;
   }

   @Override
   public boolean takeNextData(T data, SampleInfo info)
   {
      messageLock.lock();
      MessageHolder next = messageQueue.poll();
      if (next != null)
      {
         topicDataType.copy(next.message, data);
         if(info != null)
         {
            info.set(next.info);
         }
         messageLock.unlock();
         return true;
      }
      else
      {
         messageLock.unlock();
         return false;
      }
   }

   @Override
   public T takeNextData()
   {
      return takeNextData(null);
   }

   @Override
   public T takeNextData(SampleInfo info)
   {
      T nextData = topicDataType.createData();
      if (takeNextData(nextData, info))
         return nextData;
      else
         return null;
   }

   @Override
   public IntraProcessSubscriberAttributes getAttributes()
   {
      return attr;
   }

   @Override
   public boolean isInCleanState()
   {
      return true;
   }

   @Override
   public boolean isAvailable()
   {
      return available;
   }

   public void notifySubscriberListener(IntraProcessPublisher<T> publisher, MatchingStatus matchedMatching)
   {
      if (listener != null)
      {
         MatchingInfo info = new MatchingInfo();
         info.setStatus(matchedMatching);
         info.getGuid().set(publisher.getGuid());
         listener.onSubscriptionMatched(this, info);
      }
   }

   public IntraProcessParticipant getParticipant()
   {
      return participant;
   }

   void destroy()
   {
      available = false;
      participant = null;
      listener = null;
      messageQueue.clear();
   }

   void putNextData(Object newData, SampleInfo newInfo)
   {
      messageLock.lock();
      messageQueue.offer(new MessageHolder(newData, newInfo));
      messageCondition.signal();
      messageLock.unlock();
      if(listener != null)
      {
         listener.onNewDataMessage(this);
      }
   }

}

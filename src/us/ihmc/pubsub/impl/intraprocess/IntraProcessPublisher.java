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

import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.common.Guid;
import us.ihmc.pubsub.common.MatchingInfo;
import us.ihmc.pubsub.common.MatchingInfo.MatchingStatus;
import us.ihmc.pubsub.publisher.Publisher;
import us.ihmc.pubsub.publisher.PublisherListener;

class IntraProcessPublisher implements Publisher
{

   private boolean available = true;
   private final TopicDataType<?> topicDataType;
   private final Guid guid;
   private final IntraProcessPublisherAttributes attr;
   private IntraProcessDomainImpl domain;
   private IntraProcessParticipant participant;
   private PublisherListener listener;

   public IntraProcessPublisher(Guid guid, IntraProcessDomainImpl domainImpl, IntraProcessParticipant participant, IntraProcessPublisherAttributes attr,
                                PublisherListener listener)
         throws IOException
   {
      TopicDataType<?> topicDataType = participant.getTopicDataType(attr.getTopic().getTopicDataType());
      if (topicDataType == null)
      {
         throw new IOException("Cannot registered publisher with topic " + attr.getTopic().getTopicDataType() + ". Topic data type is not registered.");
      }
      this.topicDataType = topicDataType.newInstance();
      this.guid = guid;
      this.domain = domainImpl;
      this.participant = participant;
      this.attr = attr;
      this.listener = listener;

   }

   @Override
   public void write(Object data) throws IOException
   {
      // TODO Auto-generated method stub

   }

   @Override
   public void dispose(Object data) throws IOException
   {
      // TODO Auto-generated method stub

   }

   @Override
   public void unregister(Object data) throws IOException
   {
      // TODO Auto-generated method stub

   }

   @Override
   public void dispose_and_unregister(Object data) throws IOException
   {
      // TODO Auto-generated method stub

   }

   @Override
   public int removeAllChange() throws IOException
   {
      // TODO Auto-generated method stub
      return 0;
   }

   @Override
   public Guid getGuid()
   {
      return guid;
   }

   @Override
   public IntraProcessPublisherAttributes getAttributes()
   {
      return attr;
   }

   @Override
   public boolean isAvailable()
   {
      return available;
   }

   void notifyPublisherListener(IntraProcessSubscriber subscriber, MatchingStatus matchedMatching)
   {
      if (listener != null)
      {
         MatchingInfo info = new MatchingInfo();
         info.setStatus(matchedMatching);
         info.getGuid().set(subscriber.getGuid());
         listener.onPublicationMatched(this, info);
      }
   }

   public TopicDataType<?> getTopicDataType()
   {
      return topicDataType;
   }

   IntraProcessParticipant getParticipant()
   {
      return participant;
   }

   void destroy()
   {
      available = false;
      domain = null;
      participant = null;
      listener = null;
   }

}

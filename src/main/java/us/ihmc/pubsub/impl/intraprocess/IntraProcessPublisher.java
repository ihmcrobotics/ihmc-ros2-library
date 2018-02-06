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

import org.apache.commons.lang3.NotImplementedException;

import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.attributes.DurabilityKind;
import us.ihmc.pubsub.common.ChangeKind;
import us.ihmc.pubsub.common.Guid;
import us.ihmc.pubsub.common.MatchingInfo;
import us.ihmc.pubsub.common.SampleInfo;
import us.ihmc.pubsub.common.MatchingInfo.MatchingStatus;
import us.ihmc.pubsub.publisher.Publisher;
import us.ihmc.pubsub.publisher.PublisherListener;

class IntraProcessPublisher <T> implements Publisher
{

   private boolean available = true;
   private final TopicDataType<T> topicDataType;
   private final Guid guid;
   private final IntraProcessPublisherAttributes attr;
   private IntraProcessDomainImpl domain;
   private IntraProcessParticipant participant;
   private PublisherListener listener;

   
   private long sequence = 0;

   public IntraProcessPublisher(Guid guid, IntraProcessDomainImpl domainImpl, IntraProcessParticipant participant, IntraProcessPublisherAttributes attr,
                                PublisherListener listener)
         throws IOException
   {
      @SuppressWarnings("unchecked")
      TopicDataType<T> topicDataType = (TopicDataType<T>) participant.getTopicDataType(attr.getTopic().getTopicDataType());
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
      
      if(attr.getQos().getDurabilityKind() != DurabilityKind.VOLATILE_DURABILITY_QOS)
      {
         throw new RuntimeException("Only volatile durability is supported for intraprocess communication");
      }

   }

   @SuppressWarnings("unchecked")
   @Override
   public void write(Object data) throws IOException
   {
      
      SampleInfo newInfo = new SampleInfo();
      newInfo.setDataLength(topicDataType.getTypeSize());
      newInfo.setSampleKind(ChangeKind.ALIVE);
      newInfo.getSourceTimestamp().set(System.nanoTime());
      newInfo.getSampleIdentity().getGuid().set(guid);
      newInfo.getSampleIdentity().getSequenceNumber().set(sequence);

      domain.write(attr, topicDataType, (T) data, newInfo);
      
      sequence++;
   }

   @Override
   public void dispose(Object data) throws IOException
   {
      throw new NotImplementedException("Dispose not implemented for intraprocess communication");
   }

   @Override
   public void unregister(Object data) throws IOException
   {
      throw new NotImplementedException("Unregister not implemented for intraprocess communication");
   }

   @Override
   public void dispose_and_unregister(Object data) throws IOException
   {
      throw new NotImplementedException("Dispose and unregister not implemented for intraprocess communication");
   }

   @Override
   public int removeAllChange() throws IOException
   {
      throw new NotImplementedException("Remove all change not implemented for intraprocess communication");
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

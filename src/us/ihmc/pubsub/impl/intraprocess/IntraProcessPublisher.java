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
import us.ihmc.pubsub.common.MatchingInfo.MatchingStatus;
import us.ihmc.pubsub.publisher.Publisher;

class IntraProcessPublisher implements Publisher
{

   public IntraProcessPublisher(IntraProcessDomainImpl domainImpl, IntraProcessParticipant participant, IntraProcessPublisherAttributes attr)
   {
      
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
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public IntraProcessPublisherAttributes getAttributes()
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public boolean isAvailable()
   {
      // TODO Auto-generated method stub
      return false;
   }

   public void notifyPublisherListener(IntraProcessSubscriber subscriber, MatchingStatus matchedMatching)
   {
   }

   public TopicDataType<?> getTopicDataType()
   {
      // TODO Auto-generated method stub
      return null;
   }

   public IntraProcessParticipant getParticipant()
   {
      // TODO Auto-generated method stub
      return null;
   }

}

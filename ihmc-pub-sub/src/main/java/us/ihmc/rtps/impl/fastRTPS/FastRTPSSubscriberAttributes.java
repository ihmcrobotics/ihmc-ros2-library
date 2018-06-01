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
package us.ihmc.rtps.impl.fastRTPS;

import us.ihmc.pubsub.attributes.SubscriberAttributes;

public class FastRTPSSubscriberAttributes extends SubscriberAttributes
{
   private final FastRTPSReaderQosHolder qos = new FastRTPSReaderQosHolder();
   private final ReaderTimes times = new ReaderTimes();
   
   FastRTPSSubscriberAttributes()
   {
      super();
   }

   TopicAttributes createFastRTPSTopicAttributes()
   {
      return FastRTPSAttributes.createAttributes(topic);
   }

   public void delete()
   {
      ((FastRTPSReaderQosHolder)this.qos).delete();
      this.times.delete();
   }

   @Override
   public void finalize()
   {
      delete();
   }

   @Override
   public FastRTPSReaderQosHolder getQos()
   {
      return qos;
   }

   @SuppressWarnings("unchecked")
   @Override
   public ReaderTimes getTimes()
   {
      return times;
   }
}

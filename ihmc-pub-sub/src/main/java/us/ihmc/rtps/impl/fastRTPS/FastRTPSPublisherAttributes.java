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

import us.ihmc.pubsub.attributes.PublisherAttributes;

public class FastRTPSPublisherAttributes extends PublisherAttributes
{
   private final WriterTimes times = new WriterTimes();
   private final FastRTPSWriterQosHolder qos = new FastRTPSWriterQosHolder();


   FastRTPSPublisherAttributes()
   {
      super();
   }
   
   TopicAttributes createFastRTPSTopicAttributes()
   {
      return FastRTPSAttributes.createAttributes(topic);
   }
   
   ThroughputControllerDescriptor createTroughputControllerDescriptor()
   {
      return FastRTPSAttributes.createTroughputControllerDescriptor(throughputController);
   }
   
   public void delete()
   {
      ((FastRTPSWriterQosHolder)this.qos).delete();
      this.times.delete();
   }
   
   @Override
   public void finalize()
   {
      delete();
   }

   @Override
   public FastRTPSWriterQosHolder getQos()
   {
      return qos;
   }

   @SuppressWarnings("unchecked")
   @Override
   public WriterTimes getTimes()
   {
      return times;
   }
   
}

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


class FastRTPSAttributes
{
   static TopicAttributes createAttributes(us.ihmc.pubsub.attributes.TopicAttributes topic)
   {
      TopicAttributes attributes = new TopicAttributes(topic.getTopicName(), topic.getTopicDataType(),TopicKind_t.swigToEnum(topic.getTopicKind().ordinal()));
      
      HistoryQosPolicy historyQos = attributes.getHistoryQos();
      historyQos.setDepth(topic.getHistoryQos().getDepth());
      historyQos.setKind(HistoryQosPolicyKind.swigToEnum(topic.getHistoryQos().getKind().ordinal()));
      historyQos.setHasChanged(topic.getHistoryQos().isHasChanged());
      
      
      ResourceLimitsQosPolicy resourceLimitsQosPolicy = attributes.getResourceLimitsQos();
      resourceLimitsQosPolicy.setAllocated_samples(topic.getResourceLimitsQosPolicy().getAllocated_samples());
      resourceLimitsQosPolicy.setHasChanged(topic.getResourceLimitsQosPolicy().isHasChanged());
      resourceLimitsQosPolicy.setMax_instances(topic.getResourceLimitsQosPolicy().getMax_instances());
      resourceLimitsQosPolicy.setMax_samples(topic.getResourceLimitsQosPolicy().getMaxSamples());
      resourceLimitsQosPolicy.setMax_samples_per_instance(topic.getResourceLimitsQosPolicy().getMax_samples_per_instance());
      
      return attributes;
      
   }
   
   static ThroughputControllerDescriptor createTroughputControllerDescriptor(us.ihmc.pubsub.attributes.ThroughputControllerDescriptor throughputController)
   {
      ThroughputControllerDescriptor descriptor = new ThroughputControllerDescriptor(throughputController.getBytesPerPeriod(), throughputController.getPeriodMillisecs());
      return descriptor;
   }
}

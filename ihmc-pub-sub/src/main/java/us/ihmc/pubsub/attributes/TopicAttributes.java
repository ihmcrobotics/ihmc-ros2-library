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
package us.ihmc.pubsub.attributes;

/**
 * Class TopicAttributes, used by the user to define the attributes of the topic associated with a Publisher or Subscriber.
 */
public class TopicAttributes
{
   public enum TopicKind
   {
      NO_KEY, WITH_KEY
   }

   private TopicKind topicKind = TopicKind.NO_KEY;
   private String topicName = "UNDEF";
   private String topicDataType = "UNDEF";
   private final HistoryQosPolicy historyQos = new HistoryQosPolicy();
   private final ResourceLimitsQosPolicy resourceLimitsQosPolicy = new ResourceLimitsQosPolicy();

   public TopicKind getTopicKind()
   {
      return topicKind;
   }

   public void setTopicKind(TopicKind topicKind)
   {
      this.topicKind = topicKind;
   }

   public String getTopicName()
   {
      return topicName;
   }

   public void setTopicName(String topicName)
   {
      this.topicName = topicName;
   }

   public String getTopicDataType()
   {
      return topicDataType;
   }

   public void setTopicDataType(String topicDataType)
   {
      this.topicDataType = topicDataType;
   }

   public HistoryQosPolicy getHistoryQos()
   {
      return historyQos;
   }

   public ResourceLimitsQosPolicy getResourceLimitsQosPolicy()
   {
      return resourceLimitsQosPolicy;
   }

}

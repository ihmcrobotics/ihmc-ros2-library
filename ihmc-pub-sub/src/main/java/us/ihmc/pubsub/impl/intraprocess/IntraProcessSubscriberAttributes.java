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

import us.ihmc.pubsub.attributes.DurabilityKind;
import us.ihmc.pubsub.attributes.ReliabilityKind;
import us.ihmc.pubsub.attributes.SubscriberAttributes;

class IntraProcessSubscriberAttributes extends SubscriberAttributes
{

   private final IntraProcessReaderQosHolder qos = new IntraProcessReaderQosHolder();

   @Override
   public IntraProcessReaderQosHolder getQos()
   {
      return qos;
   }

   @Override
   public <T> T getTimes()
   {
      return null;
   }

   boolean publisherMatches(IntraProcessPublisherAttributes publisher)
   {
      if (!getTopic().getTopicName().equals(publisher.getTopic().getTopicName()))
         return false;

      if (!getTopic().getTopicDataType().equals(publisher.getTopic().getTopicDataType()))
         return false;

      if (getQos().getOwnershipPolicyKind() != publisher.getQos().getOwnershipPolicyKind())
         return false;

      if (publisher.getQos().getReliabilityKind() == ReliabilityKind.BEST_EFFORT && getQos().getReliabilityKind() == ReliabilityKind.RELIABLE)
         return false;

      if (publisher.getQos().getDurabilityKind() == DurabilityKind.TRANSIENT_LOCAL_DURABILITY_QOS
            && getQos().getDurabilityKind() == DurabilityKind.VOLATILE_DURABILITY_QOS)
         return false;

      if (this.getQos().getPartitions().isEmpty() && publisher.getQos().getPartitions().isEmpty())
      {
         return true;
      }
      else
      {
         for (String partition : getQos().getPartitions())
         {
            for (String subPartition : publisher.getQos().getPartitions())
            {
               if (partition.equals(subPartition))
               {
                  return true;
               }
            }
         }
      }

      return false;
   }

}

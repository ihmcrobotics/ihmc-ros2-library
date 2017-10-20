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

import java.util.ArrayList;
import java.util.List;

import us.ihmc.pubsub.attributes.DurabilityKind;
import us.ihmc.pubsub.attributes.OwnerShipPolicyKind;
import us.ihmc.pubsub.attributes.ReliabilityKind;

/**
 * Class to describe a topic subscription
 * 
 * Has an equals on name, topicdatatype and ownership to facilitate using a hashmap to quickly look up matching subscribers.
 * 
 * @author Jesper Smith
 *
 */
class TopicSubscription
{
   private final String name; // equals
   private final String topicDataType; // equals
   private final OwnerShipPolicyKind ownership; // equals

   private final ReliabilityKind reliability; // If subscriber is RELIABLE then publisher is RELIABLE
   private final DurabilityKind durability; // If subscriber is TRANSIENT_LOCAL then publisher cannot be VOLATILE

   private final List<String> partitions; // At least one partition should match

   public TopicSubscription(String name, String topicDataType, OwnerShipPolicyKind ownership, ReliabilityKind reliability, DurabilityKind durability,
                            List<String> partitions)
   {
      this.name = name;
      this.topicDataType = topicDataType;
      this.ownership = ownership;
      this.reliability = reliability;
      this.durability = durability;
      this.partitions = new ArrayList<>();
      if(partitions != null)
      {
         this.partitions.addAll(partitions);
      }
   }

   boolean publisherMatches(TopicSubscription subscriber)
   {
      if(!name.equals(subscriber.name))
         return false;
      
      if(!topicDataType.equals(subscriber.topicDataType))
         return false;
      
      if(ownership != subscriber.ownership)
         return false;
      
      if(subscriber.reliability == ReliabilityKind.RELIABLE && reliability == ReliabilityKind.BEST_EFFORT)
         return false;
      
      if(subscriber.durability == DurabilityKind.TRANSIENT_LOCAL_DURABILITY_QOS && durability == DurabilityKind.VOLATILE_DURABILITY_QOS)
         return false;
      
      
      
      
      if(this.partitions.isEmpty() && subscriber.partitions.isEmpty())
      {
         return true;
      }
      else
      {
         for(String partition : partitions)
         {
            for(String subPartition : subscriber.partitions)
            {
               if(partition.equals(subPartition))
               {
                  return true;
               }
            }
         }
      }
      
      return false;
   }

   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((name == null) ? 0 : name.hashCode());
      result = prime * result + ((ownership == null) ? 0 : ownership.hashCode());
      result = prime * result + ((topicDataType == null) ? 0 : topicDataType.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj)
   {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      TopicSubscription other = (TopicSubscription) obj;
      if (name == null)
      {
         if (other.name != null)
            return false;
      }
      else if (!name.equals(other.name))
         return false;
      if (ownership != other.ownership)
         return false;
      if (topicDataType == null)
      {
         if (other.topicDataType != null)
            return false;
      }
      else if (!topicDataType.equals(other.topicDataType))
         return false;
      return true;
   }
   
   

}

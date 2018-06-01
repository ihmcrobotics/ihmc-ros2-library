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

import java.util.List;

public interface QosInterface
{

   /**
    * Sets the reliability kind of the Qos Parameters 
    * 
    * @param reliabilityKind
    */
   void setReliabilityKind(ReliabilityKind reliabilityKind);

   /**
    * 
    * @return the reliability setting for Qos
    */
   ReliabilityKind getReliabilityKind();
   
   
   /**
    * 
    * @return the durability settings of the Qos parameters
    */
   DurabilityKind getDurabilityKind();
   
   /**
    * 
    * @param durabilityKind the desired durability kind
    */
   void setDurabilityKind(DurabilityKind durabilityKind);
   
   
   /**
    * 
    * @return ownership policy of the QoS parameters
    */
   OwnerShipPolicyKind getOwnershipPolicyKind();
   
   /**
    * 
    * @param ownerShipPolicyKind the desired ownership policy
    */
   void setOwnershipPolicyKind(OwnerShipPolicyKind ownerShipPolicyKind);
   
   
   /**
    * Add partition to the list of partitions this endpoint is connected to
    * @param name
    */
   public abstract void addPartition(String name);
   
   /**
    * 
    * @return list of partitions this endpoint is connected to
    */
   public abstract List<String> getPartitions();
   
   /**
    * 
    * @return true if the endpoint is a writer (publisher), false otherwise 
    */
   boolean isWriter();

}
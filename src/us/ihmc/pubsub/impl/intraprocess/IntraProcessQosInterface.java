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
import us.ihmc.pubsub.attributes.QosInterface;
import us.ihmc.pubsub.attributes.ReliabilityKind;

/**
 * Class to describe a topic subscription
 * 
 * Has an equals on name, topicdatatype and ownership to facilitate using a hashmap to quickly look up matching subscribers.
 * 
 * @author Jesper Smith
 *
 */
abstract class IntraProcessQosInterface implements QosInterface
{
   private OwnerShipPolicyKind ownership; // equals

   private ReliabilityKind reliability; // If subscriber is RELIABLE then publisher is RELIABLE
   private DurabilityKind durability; // If subscriber is TRANSIENT_LOCAL then publisher cannot be VOLATILE

   private final List<String> partitions = new ArrayList<>(); // At least one partition should match

   IntraProcessQosInterface()
   {
      this.ownership = OwnerShipPolicyKind.SHARED_OWNERSHIP_QOS;
      this.reliability = ReliabilityKind.RELIABLE;
      this.durability = DurabilityKind.VOLATILE_DURABILITY_QOS;
   }

   IntraProcessQosInterface(IntraProcessQosInterface orig)
   {
      this.ownership = orig.ownership;
      this.reliability = orig.reliability;
      this.durability = orig.durability;
      this.partitions.addAll(orig.partitions);

   }

   @Override
   public void setReliabilityKind(ReliabilityKind reliabilityKind)
   {
      this.reliability = reliabilityKind;
   }

   @Override
   public ReliabilityKind getReliabilityKind()
   {
      return reliability;
   }

   @Override
   public DurabilityKind getDurabilityKind()
   {
      return durability;
   }

   @Override
   public void setDurabilityKind(DurabilityKind durabilityKind)
   {
      this.durability = durabilityKind;
   }

   @Override
   public OwnerShipPolicyKind getOwnershipPolicyKind()
   {
      return ownership;
   }

   @Override
   public void setOwnershipPolicyKind(OwnerShipPolicyKind ownerShipPolicyKind)
   {
      this.ownership = ownerShipPolicyKind;
   }

   @Override
   public void addPartition(String name)
   {
      this.partitions.add(name);
   }

   @Override
   public List<String> getPartitions()
   {
      return partitions;
   }

}

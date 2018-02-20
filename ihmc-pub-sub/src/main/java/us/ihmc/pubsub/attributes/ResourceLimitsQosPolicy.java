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
 * Class ResourceLimitsQosPolicy, defines the ResourceLimits for the Writer or the Reader.
 * max_samples: Default value 5000.
 * max_instances: Default value 10.
 * max_samples_per_instance: Default value 400.
 * allocated_samples: Default value 100.
 */
public class ResourceLimitsQosPolicy extends QosPolicy
{

   private int maxSamples = 5000;
   private int max_instances = 10;
   private int max_samples_per_instance = 400;
   private int allocated_samples = 100;
   
   public ResourceLimitsQosPolicy()
   {
      super(false);
   }

   public int getMaxSamples()
   {
      return maxSamples;
   }

   public void setMaxSamples(int maxSamples)
   {
      this.maxSamples = maxSamples;
   }

   public int getMax_instances()
   {
      return max_instances;
   }

   public void setMax_instances(int max_instances)
   {
      this.max_instances = max_instances;
   }

   public int getMax_samples_per_instance()
   {
      return max_samples_per_instance;
   }

   public void setMax_samples_per_instance(int max_samples_per_instance)
   {
      this.max_samples_per_instance = max_samples_per_instance;
   }

   public int getAllocated_samples()
   {
      return allocated_samples;
   }

   public void setAllocated_samples(int allocated_samples)
   {
      this.allocated_samples = allocated_samples;
   }
   
   

}

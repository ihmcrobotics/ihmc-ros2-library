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
 * Descriptor for a Throughput Controller, containing all constructor information
 * for it. 
 */
public class ThroughputControllerDescriptor
{
   /**
    * Packet size in bytes that this controller will allow in a given period.
    * 
    * Default: Unsigned 32 bit integer max
    */
   private long bytesPerPeriod = 4294967295l;

   /**
    *  Window of time in which no more than 'bytesPerPeriod' bytes are allowed.
    */
   private long periodMillisecs = 0;

   public long getBytesPerPeriod()
   {
      return bytesPerPeriod;
   }

   public void setBytesPerPeriod(long bytesPerPeriod)
   {
      this.bytesPerPeriod = bytesPerPeriod;
   }

   public long getPeriodMillisecs()
   {
      return periodMillisecs;
   }

   public void setPeriodMillisecs(long periodMillisecs)
   {
      this.periodMillisecs = periodMillisecs;
   }

}

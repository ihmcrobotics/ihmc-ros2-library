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
package us.ihmc.pubsub.common;

/**
 * Class SampleInfo with information that is provided along a sample when reading data from a Subscriber. 
 * 
 * @author Jesper Smith
 *
 */
public class SampleInfo
{
   private int dataLength;
   private ChangeKind sampleKind;
   private int ownershipStrength;
   private final Time sourceTimestamp = new Time();
   private final InstanceHandle instanceHandle = new InstanceHandle();
   private final SampleIdentity sampleIdentity = new SampleIdentity();
   private final SampleIdentity relatedSampleIdentity = new SampleIdentity();

   public ChangeKind getSampleKind()
   {
      return sampleKind;
   }

   public void setSampleKind(ChangeKind sampleKind)
   {
      this.sampleKind = sampleKind;
   }

   /**
    * 
    * @return Ownership Strength of the writer of the sample (0 if the ownership kind is set to SHARED_OWNERSHIP_QOS)
    */
   public int getOwnershipStrength()
   {
      return ownershipStrength;
   }

   public void setOwnershipStrength(int ownershipStrength)
   {
      this.ownershipStrength = ownershipStrength;
   }

   /**
    * 
    * @return Source timestamp of the sample
    */
   public Time getSourceTimestamp()
   {
      return sourceTimestamp;
   }

   public InstanceHandle getInstanceHandle()
   {
      return instanceHandle;
   }

   public SampleIdentity getSampleIdentity()
   {
      return sampleIdentity;
   }

   public SampleIdentity getRelatedSampleIdentity()
   {
      return relatedSampleIdentity;
   }

   /**
    * @return the size of this sample in bytes
    */
   public int getDataLength()
   {
      return dataLength;
   }

   /**
    * Set the size of this sample in bytes
    * @param dataLength
    */
   public void setDataLength(int dataLength)
   {
      this.dataLength = dataLength;
   }

   
   public void set(SampleInfo other)
   {
      this.dataLength = other.dataLength;
      this.sampleKind = other.sampleKind;
      this.ownershipStrength = other.ownershipStrength;
      this.sourceTimestamp.set(other.sourceTimestamp);
      this.instanceHandle.setValue(other.instanceHandle.getValue());
      this.sampleIdentity.set(other.sampleIdentity);
      this.relatedSampleIdentity.set(other.relatedSampleIdentity);
   }
}

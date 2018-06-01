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
 * Holder for the QoS Parameters. 
 *  
 * @author Jesper Smith
 *
 * @param <T>
 */
public interface WriterQosHolder extends QosInterface
{
   
   
   /**
    * Get implementation specific version of the WriterQos parameters
    * 
    * Implementations:
    *    FastRTPS: us.ihmc.rtps.impl.fastRTPS.WriterQos
    * 
    * @return implementation specific writerQos
    */
   public <T> T getWriterQos();
   
   @Override
   default boolean isWriter()
   {
      return true;
   }
   
   /**
    * Set the publish mode QoS policy
    * 
    * Set to to ASYNCHRONOUS_PUBLISH_MODE if the data is expected to be over 65kB
    * 
    * @param publishMode
    */
   public void setPublishMode(PublishModeKind publishMode);
   
   /**
    * Get the publish mode QoS policy
    * @return
    */
   public PublishModeKind getPublishMode();
}

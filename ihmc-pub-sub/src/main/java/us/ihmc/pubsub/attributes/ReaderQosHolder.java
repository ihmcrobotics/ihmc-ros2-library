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
public interface ReaderQosHolder extends QosInterface
{

   /**
    * Function to get an implementation specific version of the reader QoS parameters.
    * 
    * Versions:
    *    FastRTPS: us.ihmc.rtps.impl.fastRTPS.ReaderQos
    * 
    * @return Reader QoS parameters
    */
   public <T> T getReaderQos();
   
   @Override
   default boolean isWriter()
   {
      return false;
   }
}

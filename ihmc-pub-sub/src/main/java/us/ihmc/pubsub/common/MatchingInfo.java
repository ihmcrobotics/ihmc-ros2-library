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
 * Class MatchingInfo contains information about the matching between two endpoints
 * 
 * @author Jesper Smith
 *
 */
public class MatchingInfo
{
   /**
    * Indicates whether the matched publication/subscription method of the PublisherListener or SubscriberListener has been called for a matching or a removal of a remote endpoint
    *
    */
   public enum MatchingStatus
   {
      /**
       * MATCHED_MATCHING, new publisher/subscriber found.
       */
      MATCHED_MATCHING,
      /**
       * REMOVED_MATCHING, publisher/subscriber removed.
       */
      REMOVED_MATCHING;
      
      public static final MatchingStatus[] values = values();
   }
   
   private MatchingStatus status;
   private final Guid guid = new Guid();
   
   
   /**
    * 
    * This method does not allocate memory
    *  
    * @return status
    */
   public MatchingStatus getStatus()
   {
      return status;
   }
   public void setStatus(MatchingStatus status)
   {
      this.status = status;
   }
   
   /**
    * 
    * This method does not allocate memory
    * 
    * @return Remote endpoint GUID
    */
   public Guid getGuid()
   {
      return guid;
   }
   
   
}

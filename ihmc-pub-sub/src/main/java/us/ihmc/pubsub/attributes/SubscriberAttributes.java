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

import java.util.ArrayList;
import java.util.List;

/**
 * Class SubscriberAttributes, used by the user to define the attributes of a Subscriber.
 * 
 * @author Jesper Smith
 *
 * @param <ReaderQos_t>
 * @param <ReaderTimes_t>
 * @param <LocatorList_t>
 */
public abstract class SubscriberAttributes
{
   protected final TopicAttributes topic = new TopicAttributes();
   protected final ArrayList<Locator> unicastLocatorList = new ArrayList<>();
   protected final ArrayList<Locator> multicastLocatorList = new ArrayList<>();
   protected final ArrayList<Locator> outLocatorList = new ArrayList<>();

   private int userDefinedID = -1;
   private int entityID = -1;
   private boolean expectsInlineQos;
   private MemoryManagementPolicy historyMemoryPolicy = MemoryManagementPolicy.PREALLOCATED_MEMORY_MODE;

   public SubscriberAttributes()
   {
   }

   public int getUserDefinedID()
   {
      return userDefinedID;
   }

   public void setUserDefinedID(int userDefinedID)
   {
      this.userDefinedID = userDefinedID;
   }

   public int getEntityID()
   {
      return entityID;
   }

   public void setEntityID(int entityID)
   {
      this.entityID = entityID;
   }

   public boolean isExpectsInlineQos()
   {
      return expectsInlineQos;
   }

   public void setExpectsInlineQos(boolean expectsInlineQos)
   {
      this.expectsInlineQos = expectsInlineQos;
   }

   public MemoryManagementPolicy getHistoryMemoryPolicy()
   {
      return historyMemoryPolicy;
   }

   public void setHistoryMemoryPolicy(MemoryManagementPolicy historyMemoryPolicy)
   {
      this.historyMemoryPolicy = historyMemoryPolicy;
   }

   public TopicAttributes getTopic()
   {
      return topic;
   }

   /** 
    * @return holder for Qos settings
    */
   public abstract ReaderQosHolder getQos();

   /** 
    * Get implementation specific version of reader times.
    * 
    * Implementations: 
    *    FastRTPS: us.ihmc.rtps.impl.fastRTPS.ReaderTimes
    * 
    * @return implementation specific version of reader times.
    */
   public abstract <T> T getTimes();

   public List<Locator> getUnicastLocatorList()
   {
      return unicastLocatorList;
   }

   public List<Locator> getMulticastLocatorList()
   {
      return multicastLocatorList;
   }

   public List<Locator> getOutLocatorList()
   {
      return outLocatorList;
   }

}

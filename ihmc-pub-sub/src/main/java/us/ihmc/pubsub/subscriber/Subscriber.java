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
package us.ihmc.pubsub.subscriber;

import us.ihmc.pubsub.attributes.SubscriberAttributes;
import us.ihmc.pubsub.common.Guid;
import us.ihmc.pubsub.common.SampleInfo;

public interface Subscriber<T>
{
   /**
    * Get the associated GUID.
    * 
    * This method does not allocate memory.
    * 
    * @return the associated GUID
    */
   public Guid getGuid();

   /**
    * Method to block the current thread until an unread message is available.
    * 
    * Note: if a listener is registered this function will return on a new message, even if the listener reads it.
    * 
    * This method does not allocate memory
    * 
    * @throws InterruptedException
    */
   default void waitForUnreadMessage() throws InterruptedException
   {
      waitForUnreadMessage(0);
   }

   /**
    * Method to block the current thread until an unread message is available.
    * 
    * Note: if a listener is registered this function will return on a new message, even if the listener reads it. 
    * 
    * This method does not allocate memory
    * 
    * @param timeoutInMilliseconds Timeout in milli seconds. Will wait forever if set to 0
    * @throws InterruptedException
    */
   public void waitForUnreadMessage(int timeoutInMilliseconds) throws InterruptedException;

   /**
    * Read next unread Data from the Subscriber.
    * 
    * This method does not allocate memory.
    * 
    * @param data the object where you want the data stored.
    * @param info a SampleInfo structure that informs you about your sample.
    * 
    * @return True if a sample was read.
    */
   public boolean readNextData(T data, SampleInfo info);

   /**
    * Take next Data from the Subscriber.
    * 
    * The data is removed from the subscriber.
    * 
    * This method does not allocate memory.
    * 
    * @param data the object where you want the data stored.
    * @param info a SampleInfo_t structure that informs you about your sample.
    * 
    * @return True if a sample was taken.
    */
   public boolean takeNextData(T data, SampleInfo info);

   /**
    * Read next unread Data from the Subscriber.
    * 
    * <b>This method allocates memory.</b>
    * 
    * @return the next Data from the Subscriber, or {@code null} if no sample could be read.
    */
   public T readNextData();

   /**
    * Read next unread Data from the Subscriber.
    * 
    * <b>This method allocates memory.</b>
    * 
    * @param info a SampleInfo structure that informs you about your sample.
    * 
    * @return the next Data from the Subscriber, or {@code null} if no sample could be read.
    */
   public T readNextData(SampleInfo info);

   /**
    * Take next Data from the Subscriber.
    * 
    * The data is removed from the subscriber.
    * 
    * <b>This method allocates memory.</b>
    * 
    * @return the next Data from the Subscriber, or {@code null} if no sample could be read.
    */
   public T takeNextData();

   /**
    * Take next Data from the Subscriber.
    * 
    * The data is removed from the subscriber.
    * 
    * <b>This method allocates memory.</b>
    * 
    * @param info a SampleInfo structure that informs you about your sample.
    * 
    * @return the next Data from the Subscriber, or {@code null} if no sample could be read.
    */
   public T takeNextData(SampleInfo info);

   /**
    * Get the Attributes of the Subscriber.
    * 
    * This method does not allocate memory
    * 
    * @return Attributes of the subscriber
    */
   public SubscriberAttributes getAttributes();

   /**
    * Returns there is a clean state with all Publishers. It occurs when the Subscriber received all samples sent by Publishers. In other words, its WriterProxies are up to date.
    * 
    * This method does not allocate memory
    * 
    * @return There is a clean state with all Publishers.
    */
   public boolean isInCleanState();

   /**
    * Checks if this publisher is available to read data from the domain 
    * 
    * This method does not allocate memory
    * 
    * @return true if this subscriber is available
    */
   public boolean isAvailable();
}

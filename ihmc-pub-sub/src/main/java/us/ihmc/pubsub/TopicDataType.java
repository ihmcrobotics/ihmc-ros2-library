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
package us.ihmc.pubsub;

import java.io.IOException;
import java.nio.ByteBuffer;

import us.ihmc.idl.CDR;
import us.ihmc.idl.InterchangeSerializer;
import us.ihmc.pubsub.common.SerializedPayload;

/**
 * Class TopicDataType used to provide the Participant with the methods to serialize, deserialize and get the key of a specific data type
 * 
 * @author Jesper Smith
 *
 * @param <T>
 */
public interface TopicDataType<T>
{
   /**
    * Serialize method, it should be implemented by the user.
    *
    * 
    * @param data
    * @param serializedPayload
    * 
    */
   public void serialize(T data, SerializedPayload serializedPayload) throws IOException;

   /**
    * Deserialize method, it should be implemented by the user
    * 
    * @param serializedPayload
    * @param data
    * 
    */
   public void deserialize(SerializedPayload serializedPayload, T data) throws IOException;

   
   /**
    * Interchange Serialize method, it should be implemented by the user.
    *
    * 
    * @param data
    * @param serializedPayload
    * 
    */
   public void serialize(T data, InterchangeSerializer serializer);
   
   /**
    * Interchange deserialize method, it should be implemented by the user
    * 
    * @param serializedPayload
    * @param data
    * 
    */
   public void deserialize(InterchangeSerializer serializer, T data);
   
   
   /**
    * Nested element serialize method, it should be implemented by the user
    * 
    * @param data
    * @param cdr
    * 
    */
   public void serialize(T data, CDR cdr);

   /**
    * Nested element deserialize method, it should be implemented by the user
    * 
    * @param data
    * @param cdr
    * 
    */
   public void deserialize(T data, CDR cdr);

   /**
    * Set dest to the contents in src
    * 
    * This function is considered thread safe, no side effects are allowed in the implementation of this method.
    * 
    * @param src
    * @param dest
    */
   public void copy(T src, T dest);
   
   /**
    * Maximum serialized size of the type in bytes. 
    * 
    * If the type has unbounded fields, and therefore cannot have a maximum size, use 0.
    * 
    * This size includes the header bytes for the encapsulation format.
    * 
    * This function is considered thread safe, no side effects are allowed in the implementation of this method.
    *
    * @return maximum size in bytes
    */
   public int getTypeSize();

   /**
    * Return the topic data type name
    * 
    * This function is considered thread safe, no side effects are allowed in the implementation of this method.
    * 
    * @return Topic data type name
    */
   public String getName();
   
   /**
    * Return a new instance of the underlying data type.
    * 
    * This function is considered thread safe, no side effects are allowed in the implementation of this method.
    * 
    * @return an instance of the data type
    */
   public T createData();
   
   /**
    * Create a new instance of this class.
    * 
    * This is used to avoid threading issues when re-using pub-sub types when constructing topics
    * 
    * This function is considered thread safe, no side effects are allowed in the implementation of this method.
    * 
    * @return a copy of this pub sub type. 
    */
   public TopicDataType<T> newInstance();

   /**
    * Get the key associated with the data. 
    */
   default void getKey(T data, ByteBuffer target)
   {
   }

   /**
    * Indicates whether the method to obtain the key has been implemented
    * @return true when implemented
    */
   default boolean isGetKeyDefined()
   {
      return false;
   }
}

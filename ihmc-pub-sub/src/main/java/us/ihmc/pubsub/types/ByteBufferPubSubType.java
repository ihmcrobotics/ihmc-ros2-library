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
package us.ihmc.pubsub.types;

import java.io.IOException;
import java.nio.ByteBuffer;

import org.apache.commons.lang3.NotImplementedException;

import us.ihmc.idl.CDR;
import us.ihmc.idl.InterchangeSerializer;
import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.common.SerializedPayload;

/**
 * A generic data type to send over raw byte buffers.
 * 
 * As the IHMC pub sub library assumes a predefined maximum data size, the max size has to be specified and will be allocated as buffer. 
 * Buffers will be pre-allocated and incur a double copy (native layer -> internal library layer -> user buffer). 
 * 
 * The topic name will include the maximum topic size in the following format:
 *    [name]::[maxSize]
 *    
 * On serialization, the data will be read from the source ByteBuffer from its current position to the limit.
 * On deserialization, the data will be put in the target ByteBuffer at its current position. Make sure there is enough space remaining for the incoming message.
 *    
 * @author Jesper Smith
 *
 */
public class ByteBufferPubSubType implements TopicDataType<ByteBuffer>
{
   private final String name;
   
   private final int maxSize;

   private final String userName;
   private final int userMaxSize;
   
   private static int align(int size)
   {
      int adv = (size % 4);

      if (adv != 0)
      {
         size += (4 - adv);
      }

      return size;
   }

   /**
    * Constructor for the ByteBuffer pub/sub type.
    * 
    * @param name desired topic name
    * @param maxSize maximum size of the buffer
    */
   public ByteBufferPubSubType(String name, int maxSize)
   {
      this.userName = name;
      this.userMaxSize = maxSize;
      this.maxSize = CDR.getTypeSize(align(maxSize)) + 4; // add integer with actual data size to the data 
      this.name = name + "::" + this.maxSize;
   }

   @Override
   public void serialize(ByteBuffer data, SerializedPayload serializedPayload) throws IOException
   {
      if (CDR.getTypeSize(data.remaining() + 4) > maxSize)
      {
         throw new IOException("Data size is larger than the maximum size");
      }
      CDR.writeEncapsulation(serializedPayload);

      ByteBuffer target = serializedPayload.getData();
      target.putInt(data.remaining());
      target.put(data);
      serializedPayload.setLength(align(target.position()));
   }

   @Override
   public void deserialize(SerializedPayload serializedPayload, ByteBuffer data) throws IOException
   {
      CDR.readEncapsulation(serializedPayload);
      
      ByteBuffer src = serializedPayload.getData();

      int length = src.getInt();
      if (length > data.remaining())
      {
         throw new IOException("ByteBuffer data does not have enough space remaining to accept the incoming message.");
      }
      for (int i = 0; i < length; i++)
      {
         data.put(src.get());
      }
   }

   @Override
   public int getTypeSize()
   {
      return maxSize;
   }

   @Override
   public String getName()
   {
      return name;
   }

   @Override
   public ByteBuffer createData()
   {
      return ByteBuffer.allocateDirect(maxSize);
   }

   @Override
   public TopicDataType<ByteBuffer> newInstance()
   {
      return new ByteBufferPubSubType(userName, userMaxSize);
   }

   @Override
   public void serialize(ByteBuffer data, CDR cdr)
   {
      throw new NotImplementedException("Nested serializer is not implemented for bytebuffer pub/sub type");
   }

   @Override
   public void deserialize(ByteBuffer data, CDR cdr)
   {
      throw new NotImplementedException("Nested serializer is not implemented for bytebuffer pub/sub type");
   }

   @Override
   public void copy(ByteBuffer src, ByteBuffer dest)
   {
      throw new NotImplementedException("Copy is not implemented for bytebuffer pub/sub type");
   }

   @Override
   public void serialize(ByteBuffer data, InterchangeSerializer serializer)
   {
      throw new NotImplementedException("Interchange serializer is not implemented for bytebuffer pub/sub type");
   }

   @Override
   public void deserialize(InterchangeSerializer serializer, ByteBuffer data)
   {
      throw new NotImplementedException("Interchange serializer is not implemented for bytebuffer pub/sub type");
      
   }

}

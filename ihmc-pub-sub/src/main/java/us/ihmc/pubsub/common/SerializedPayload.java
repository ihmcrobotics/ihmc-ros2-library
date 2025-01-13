/**
 * Copyright 2024 Florida Institute for Human and Machine Cognition (IHMC)
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

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Structure to hold serialized data
 * 
 * @author Jesper Smith
 *
 */
public class SerializedPayload
{
   public static final short CDR_BE = 0x0000;
   public static final short CDR_LE = 0x0001;
   public static final short PL_CDR_BE = 0x0002;
   public static final short PL_CDR_LE = 0x0003;

   private short encapsulation;
   private final boolean unbounded;
   private ByteBuffer data;
   private int pos;

   /**
    * Constructor 
    * 
    * @param typeSize bounded size or 0 for unbounded types
    */
   public SerializedPayload(int typeSize)
   {
      unbounded = typeSize == 0;

      if (unbounded)
         data = ByteBuffer.allocate(8);
      else
         data = ByteBuffer.allocate(typeSize);

      setEncapsulation(CDR_LE);
   }

   /**
    * 
    * @return Encapsulation of the data as suggested in the RTPS 2.1 specification chapter 10.
    */
   public short getEncapsulation()
   {
      return encapsulation;
   }

   /**
    * Set encapsulation of the data as suggested in the RTPS 2.1 specification chapter 10. The byte order of the underlying buffer is adjusted accordingly.
    * @param encapsulation
    */
   public void setEncapsulation(short encapsulation)
   {
      this.encapsulation = encapsulation;
      if(encapsulation == CDR_BE || encapsulation == PL_CDR_BE)
      {
         data.order(ByteOrder.BIG_ENDIAN);
      }
      else
      {
         data.order(ByteOrder.LITTLE_ENDIAN);
      }
   }

   /**
    * 
    * @return Actual length of the data.
    */
   public int getLength()
   {
      return data.limit();
   }

   /**
    * 
    * @return Position when reading.
    */
   public int getPos()
   {
      return pos;
   }

   public void setPos(int pos)
   {
      this.pos = pos;
   }

   public void ensureCapacity(int size)
   {
      if (unbounded)
      {
         if (data.capacity() < size)
         {
            data = ByteBuffer.allocate(data.capacity() * 2);
         }
      }
   }

   public ByteBuffer getData()
   {
      return data;
   }
}

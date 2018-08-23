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
package us.ihmc.idl;

import java.nio.ByteBuffer;

import org.apache.commons.lang3.NotImplementedException;

import us.ihmc.pubsub.common.SerializedPayload;

/**
 * Helper class to serialize and deserialize IDL messages.
 * 
 * It should not be necessary to use this class directly. Use the IDLGenerator to create the neccessary java files to serialize and deserialize messages
 * 
 * @author Jesper Smith
 *
 */
public class CDR
{
   private static final int encapsulation_size = 4;
   
   private SerializedPayload payload;
   private ByteBuffer buf;
   private static short options = 0x0;

   public static int alignment(int current_alignment, int dataSize)
   {
      return (dataSize - (current_alignment % dataSize)) & (dataSize - 1);
   }

   public void serialize(SerializedPayload payload)
   {
      writeEncapsulation(payload);

      buf = payload.getData();
      this.payload = payload;

   }

   public static void writeEncapsulation(SerializedPayload payload)
   {
      ByteBuffer buf = payload.getData();
      //Write encapsulation
      buf.put((byte) 0x0);
      buf.put((byte) payload.getEncapsulation());
      buf.putShort(options);
   }

   public void deserialize(SerializedPayload payload)
   {
      readEncapsulation(payload);
      buf = payload.getData();
      this.payload = payload;
   }
   
   public static void readEncapsulation(SerializedPayload payload)
   {
      ByteBuffer buf = payload.getData();
      /* int dummy = */ buf.get();
      short encapsulation = buf.get();
      payload.setEncapsulation(encapsulation);
      /* this.options = */ buf.getShort();
   }

   public void finishSerialize()
   {
      buf.flip();
      payload.setLength(buf.limit());
   }

   public void finishDeserialize()
   {
   }
   
   public static int getTypeSize(int elementTypeSize)
   {
      return elementTypeSize + encapsulation_size;
   }

   /**
    * Signed short
    */
   public short read_type_1()
   {
      align(2);
      return buf.getShort();
   }

   public void write_type_1(short val)
   {
      align(2);
      buf.putShort(val);
   }

   /**
    * Signed int
    */
   public int read_type_2()
   {
      align(4);
      return buf.getInt();
   }

   public void write_type_2(int val)
   {
      align(4);
      buf.putInt(val);
   }

   /**
    * Unsigned short
    */
   public int read_type_3()
   {
      return Short.toUnsignedInt(read_type_1());
   }

   public void write_type_3(int val)
   {
      write_type_1((short) val);
   }

   /**
    * Unsigned int
    */
   public long read_type_4()
   {
      return Integer.toUnsignedLong(read_type_2());
   }

   public void write_type_4(long val)
   {
      write_type_2((int) val);
   }

   /**
    * Float
    */
   public float read_type_5()
   {
      align(4);
      return buf.getFloat();
   }

   public void write_type_5(float val)
   {
      align(4);
      buf.putFloat(val);
   }

   /**
    * Double
    */
   public double read_type_6()
   {
      align(8);
      return buf.getDouble();
   }

   public void write_type_6(double val)
   {
      align(8);
      buf.putDouble(val);
   }

   /**
    * Boolean
    */
   public boolean read_type_7()
   {
      int val = read_type_9();
      return val != (byte) 0;
   }

   public void write_type_7(boolean val)
   {
      write_type_9(val ? (byte) 1 : (byte) 0);
   }

   /**
    * Char
    */
   public char read_type_8()
   {
      return (char) (buf.get() & 0xFF);
   }

   public void write_type_8(char val)
   {
      buf.put((byte) val);
   }

   /**
    * Octet
    */
   public byte read_type_9()
   {
      return buf.get();
   }

   public void write_type_9(byte val)
   {
      buf.put(val);
   }

   /**
    * Union
    */
   public Object read_type_b()
   {
      throw new NotImplementedException("Union types are not implemented yet");
   }

   public void write_type_b(Object object)
   {
      throw new NotImplementedException("Union types are not implemented yet");
   }

   /**
    * Enum
    */

   public int read_type_c()
   {
      return read_type_2();
   }

   public void write_type_c(int val)
   {
      write_type_2(val);
   }

   /**
    * String
    */
   public void read_type_d(StringBuilder res)
   {
      int length = read_type_2() - 1;
      res.setLength(length);
      for (int i = 0; i < length; i++)
      {
         res.setCharAt(i, (char) buf.get());
      }
      buf.get();
   }

   public void write_type_d(StringBuilder str)
   {
      write_type_2(str.length() + 1);
      for (int i = 0; i < str.length(); i++)
      {
         buf.put((byte) str.charAt(i));
      }
      buf.put((byte) 0);
   }

   /**
    * Sequence
    */
   public void read_type_e(IDLSequence seq)
   {
      int length = read_type_2();
      seq.resetQuick();
      for (int i = 0; i < length; i++)
      {
         seq.readElement(i, this);
      }
   }

   public void write_type_e(IDLSequence seq)
   {
      int length = seq.size();
      write_type_2(length);
      for (int i = 0; i < length; i++)
      {
         seq.writeElement(i, this);
      }
   }

   /** 
    * Array
    */
   public void read_type_f()
   {

   }

   /**
    * Signed long, 64 bit
    */
   public long read_type_11()
   {
      align(8);
      return buf.getLong();
   }

   public void write_type_11(long val)
   {
      align(8);
      buf.putLong(val);
   }

   /**
    * Unsigned long, 64bit
    */
   public long read_type_12()
   {
      return read_type_11();
   }

   public void write_type_12(long val)
   {
      write_type_11(val);
   }

   /**
    * Long doubles (16 bytes, unsupported)
    */
   public double read_type_13()
   {
      throw new NotImplementedException("Java does not support 16 byte Double values");
   }

   public void write_type_13(double val)
   {
      throw new NotImplementedException("Java does not support 16 byte Double values");
   }

   /**
    * Wide char (32 bits)
    */
   public char read_type_14()
   {
      return (char) read_type_2();
   }

   public void write_type_14(char val)
   {
      write_type_2((int) val);
   }

   /**
    * Wide string
    */
   public void read_type_15(StringBuilder res)
   {
      int length = read_type_2();
      res.setLength(length);
      for (int i = 0; i < length; i++)
      {
         res.setCharAt(i, buf.getChar());
      }
   }

   public void write_type_15(StringBuilder str)
   {
      write_type_2(str.length());
      for (int i = 0; i < str.length(); i++)
      {
         buf.putChar(str.charAt(i));
      }
   }

   public int align(int byteBoundary)
   {
      int position = buf.position() - encapsulation_size;
      int adv = (position % byteBoundary);

      if (adv != 0)
      {
         buf.position(position + encapsulation_size + (byteBoundary - adv));
      }

      return adv;
   }

}

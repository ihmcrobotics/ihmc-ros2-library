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

import org.apache.commons.lang3.NotImplementedException;

import us.ihmc.pubsub.TopicDataType;

public interface InterchangeSerializer
{
   /**
    * Signed short
    */
   public short read_type_1(String name);
   
   public void write_type_1(String name, short val);
   
   /**
    * Signed int
    */
   public int read_type_2(String name);
   
   public void write_type_2(String name, int val);
   
   /**
    * Unsigned short
    */
   default int read_type_3(String name)
   {
      return read_type_1(name) & 0xFFFF;
   }
   
   default void write_type_3(String name, int val)
   {
      write_type_1(name, (short) val);
   }
   
   /**
    * Unsigned int
    */
   default long read_type_4(String name)
   {
      return read_type_2(name) & 0xFFFFFFFF;
   }
   
   default void write_type_4(String name, long val)
   {
      write_type_2(name, (int) val);
   }
   
   /**
    * Float
    */
   public float read_type_5(String name);
   
   public void write_type_5(String name, float val);
   
   /**
    * Double
    */
   public double read_type_6(String name);
   
   public void write_type_6(String name, double val);
   
   /**
    * Boolean
    */
   public boolean read_type_7(String name);
   
   public void write_type_7(String name, boolean val);
   
   /**
    * Char
    */
   public char read_type_8(String name);
   
   public void write_type_8(String name, char val);
   
   /**
    * Octet
    */
   public byte read_type_9(String name);
   
   public void write_type_9(String name, byte val);
   
   /**
    * Struct
    */
   public <T> void read_type_a(String name, TopicDataType<T> type, T data);
   
   public <T> void write_type_a(String name, TopicDataType<T> type, T data);
   
   /**
    * Union
    */
   default Object read_type_b(String name)
   {
      throw new NotImplementedException("Union types are not implemented yet");
   }
   
   default void write_type_b(String name, Object object)
   {
      throw new NotImplementedException("Union types are not implemented yet");     
   }
   
   /**
    * Enum
    */
   
   public Enum<?> read_type_c(String name, Class<? extends Enum<?>> enumType);
   
   public void write_type_c(String name, Enum<?> val);
   
   /**
    * String
    */
   public void read_type_d(String name, StringBuilder res);
   
   public void write_type_d(String name, StringBuilder str);
   
   /**
    * Sequence
    */
   public void read_type_e(String name, IDLSequence seq);
   
   public void write_type_e(String name, IDLSequence seq);
   
   /** 
    * Array
    */
   public <T> void read_type_f(String name, TopicDataType<T> dataType, Object[] arr);
   public <T> void write_type_f(String name, TopicDataType<T> dataType, Object[] arr);
   public <T> void read_type_f(String name, T[] arr);
   public <T> void write_type_f(String name, T[] arr);
   public void read_type_f(String name, boolean[] arr);
   public void write_type_f(String name, boolean[] arr);
   public void read_type_f(String name, byte[] arr);
   public void write_type_f(String name, byte[] arr);
   public void read_type_f(String name, char[] arr);
   public void write_type_f(String name, char[] arr);
   public void read_type_f(String name, short[] arr);
   public void write_type_f(String name, short[] arr);
   public void read_type_f(String name, int[] arr);
   public void write_type_f(String name, int[] arr);
   public void read_type_f(String name, long[] arr);
   public void write_type_f(String name, long[] arr);
   public void read_type_f(String name, float[] arr);
   public void write_type_f(String name, float[] arr);
   public void read_type_f(String name, double[] arr);
   public void write_type_f(String name, double[] arr);
   
   
   /**
    * Signed long, 64 bit
    */
   public long read_type_11(String name);
   
   public void write_type_11(String name, long val);
   
   /**
    * Unsigned long, 64bit
    */
   default long read_type_12(String name)
   {
      return read_type_11(name);
   }
   
   default void write_type_12(String name, long val)
   {
      write_type_11(name, val);
   }
   
   /**
    * Long doubles (16 bytes, unsupported)
    */
   default double read_type_13(String name)
   {
      throw new NotImplementedException("Java does not support 16 byte Double values");
   }
   
   default void write_type_13(String name, double val)
   {
      throw new NotImplementedException("Java does not support 16 byte Double values");
   }
   
   /**
    * Wide char (32 bits)
    */
   public char read_type_14(String name);
   
   public void write_type_14(String name, char val);

   /**
    * Wide string
    */
   public void read_type_15(String name, StringBuilder res);
   
   public void write_type_15(String name, StringBuilder str);   

   
}

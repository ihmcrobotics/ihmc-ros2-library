/**
 * Copyright 2018 Florida Institute for Human and Machine Cognition (IHMC)
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
package us.ihmc.idl.serializers.extra;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.lang3.NotImplementedException;
import us.ihmc.idl.IDLSequence;
import us.ihmc.idl.InterchangeSerializer;
import us.ihmc.pubsub.TopicDataType;

/**
 * Internal class to serialize IDL data to representations supported by Jackson
 * 
 * @author Jesper Smith
 *
 */
class JacksonInterchangeSerializer implements InterchangeSerializer
{
   private final boolean supportsArrays;
   private final ObjectNode node;

   JacksonInterchangeSerializer(ObjectNode node, boolean supportsArrays)
   {
      this.node = node;
      this.supportsArrays = supportsArrays;
   }

   /**
    * Signed short
    */
   public short read_type_1(String name)
   {
      return (short) node.path(name).asInt();
   }

   public void write_type_1(String name, short val)
   {
      node.put(name, val);
   }

   /**
    * Signed int
    */
   public int read_type_2(String name)
   {
      return node.path(name).asInt();
   }

   public void write_type_2(String name, int val)
   {
      node.put(name, val);
   }

   /**
    * Float
    */
   public float read_type_5(String name)
   {
      return (float) node.path(name).asDouble();
   }

   public void write_type_5(String name, float val)
   {
      node.put(name, val);
   }

   /**
    * Double
    */
   public double read_type_6(String name)
   {
      return node.path(name).asDouble();
   }

   public void write_type_6(String name, double val)
   {
      node.put(name, val);
   }

   /**
    * Boolean
    */
   public boolean read_type_7(String name)
   {
      return node.path(name).asBoolean();
   }

   public void write_type_7(String name, boolean val)
   {
      node.put(name, val);
   }

   /**
    * Char
    */
   public char read_type_8(String name)
   {
      String text = node.path(name).asText();
      return str2char(text);
   }

   private final char str2char(String text)
   {
      if (text != null && text.length() > 0)
      {
         return text.charAt(0);
      }
      else
      {
         return '\0';
      }
   }

   public void write_type_8(String name, char val)
   {
      node.put(name, String.valueOf(val));
   }

   /**
    * Octet
    */
   public byte read_type_9(String name)
   {
      return (byte) node.path(name).asInt();
   }

   public void write_type_9(String name, byte val)
   {
      node.put(name, (int) val);
   }

   /**
    * Struct
    */
   public <T> void read_type_a(String name, TopicDataType<T> type, T data)
   {
      type.deserialize(new JacksonInterchangeSerializer(node.with(name), supportsArrays), data);
   }

   public <T> void write_type_a(String name, TopicDataType<T> type, T data)
   {
      type.serialize(data, new JacksonInterchangeSerializer(node.putObject(name), supportsArrays));
   }

   /**
    * Enum
    */
   public Enum<?> read_type_c(String name, Class<? extends Enum<?>> enumType)
   {
      String val = node.path(name).asText();
      return str2enum(enumType.getEnumConstants(), val);
   }

   private static Enum<?> str2enum(Enum<?>[] enumConstants, String val)
   {
      for (Enum<?> enumVal : enumConstants)
      {
         if (enumVal.name().equals(val))
         {
            return enumVal;
         }
      }
      return null;
   }

   public void write_type_c(String name, Enum<?> val)
   {
      if (val == null)
      {
         node.putNull(name);
      }
      else
      {
         node.put(name, val.name());
      }
   }

   /**
    * String
    */
   public void read_type_d(String name, StringBuilder res)
   {
      res.setLength(0);
      res.append(node.path(name).asText());
   }

   public void write_type_d(String name, StringBuilder str)
   {
      node.put(name, str.toString());
   }
   
   private void checkArraySupport()
   {
      if(!supportsArrays)
      {
         throw new UnsupportedFeatureException("This serializer does not support arrays and sequences");
      }
   }

   /**
    * Sequence
    */
   @SuppressWarnings({"rawtypes", "unchecked"})
   public void read_type_e(String name, IDLSequence seq)
   {
      checkArraySupport();
      seq.resetQuick();
      JsonNode child = node.path(name);
      if (child.isArray())
      {
         for (JsonNode val : child)
         {
            if (seq instanceof IDLSequence.Boolean)
            {
               ((IDLSequence.Boolean) seq).add(val.asBoolean());
            }
            else if (seq instanceof IDLSequence.Byte)
            {
               ((IDLSequence.Byte) seq).add((byte) val.asInt());
            }
            else if (seq instanceof IDLSequence.Char)
            {
               ((IDLSequence.Char) seq).add(str2char(val.asText()));
            }
            else if (seq instanceof IDLSequence.Short)
            {
               ((IDLSequence.Short) seq).add((short) val.asInt());
            }
            else if (seq instanceof IDLSequence.Integer)
            {
               ((IDLSequence.Integer) seq).add(val.asInt());
            }
            else if (seq instanceof IDLSequence.Long)
            {
               ((IDLSequence.Long) seq).add(val.asLong());
            }
            else if (seq instanceof IDLSequence.Float)
            {
               ((IDLSequence.Float) seq).add((float)val.asDouble());
            }
            else if (seq instanceof IDLSequence.Double)
            {
               ((IDLSequence.Double) seq).add(val.asDouble());
            }
            else if (seq instanceof IDLSequence.StringBuilderHolder)
            {
               ((IDLSequence.StringBuilderHolder) seq).add(val.asText());
            }
            else if (seq instanceof IDLSequence.Enum)
            {
               ((IDLSequence.Enum) seq).add(str2enum(((IDLSequence.Enum) seq).getEnumConstants(), val.asText()));
            }
            else if (seq instanceof IDLSequence.Object)
            {
               TopicDataType<Object> type = ((IDLSequence.Object) seq).getTopicDataType();
               Object childStruct = ((IDLSequence.Object) seq).add();
               if(val.isObject())
               {
                  type.deserialize(new JacksonInterchangeSerializer((ObjectNode) val, supportsArrays), childStruct);
               }
            }
            else
            {
               throw new RuntimeException("Unknown sequence object");
            }
         }
      }
      else
      {
         return;
      }
   }

   @SuppressWarnings("rawtypes")
   public void write_type_e(String name, IDLSequence seq)
   {
      checkArraySupport();
      ArrayNode child = node.putArray(name);
      for (int i = 0; i < seq.size(); i++)
      {
         if (seq instanceof IDLSequence.Boolean)
         {
            child.add(((IDLSequence.Boolean) seq).getBoolean(i));
         }
         else if (seq instanceof IDLSequence.Byte)
         {
            child.add(((IDLSequence.Byte) seq).get(i));
         }
         else if (seq instanceof IDLSequence.Char)
         {
            child.add(String.valueOf(((IDLSequence.Char) seq).get(i)));
         }
         else if (seq instanceof IDLSequence.Short)
         {
            child.add(((IDLSequence.Short) seq).get(i));
         }
         else if (seq instanceof IDLSequence.Integer)
         {
            child.add(((IDLSequence.Integer) seq).get(i));
         }
         else if (seq instanceof IDLSequence.Long)
         {
            child.add(((IDLSequence.Long) seq).get(i));
         }
         else if (seq instanceof IDLSequence.Float)
         {
            child.add(((IDLSequence.Float) seq).get(i));
         }
         else if (seq instanceof IDLSequence.Double)
         {
            child.add(((IDLSequence.Double) seq).get(i));
         }
         else if (seq instanceof IDLSequence.StringBuilderHolder)
         {
            child.add(((IDLSequence.StringBuilderHolder) seq).get(i).toString());
         }
         else if (seq instanceof IDLSequence.Enum)
         {
            child.add(((Enum<?>) ((IDLSequence.Enum) seq).get(i)).name());
         }
         else if (seq instanceof IDLSequence.Object)
         {
            @SuppressWarnings("unchecked") TopicDataType<Object> type = ((IDLSequence.Object) seq).getTopicDataType();
            Object childStruct = ((IDLSequence.Object) seq).get(i);
            type.serialize(childStruct, new JacksonInterchangeSerializer(child.addObject(), supportsArrays));
         }
         else
         {
            throw new RuntimeException("Unknown sequence object");
         }
      }
   }

   /** 
    * Array
    */

   public void read_type_f(String name, boolean[] arr)
   {
      checkArraySupport();
      JsonNode child = node.path(name);
      read_array(arr, child);
   }

   private void read_array(boolean[] arr, JsonNode child)
   {
      for (int i = 0; i < arr.length; i++)
      {
         JsonNode element = child.get(i);
         if (element != null)
         {
            arr[i] = element.asBoolean();
         }
         else
         {
            arr[i] = false;
         }
      }
   }

   public void read_type_f(String name, byte[] arr)
   {
      checkArraySupport();
      JsonNode child = node.path(name);
      read_array(arr, child);
   }
   
   private void read_array(byte[] arr, JsonNode child)
   {
      for (int i = 0; i < arr.length; i++)
      {
         JsonNode element = child.get(i);
         if (element != null)
         {
            arr[i] = (byte) element.asInt();
         }
         else
         {
            arr[i] = '\0';
         }
      }
   }
   public void read_type_f(String name, char[] arr)
   {
      checkArraySupport();
      JsonNode child = node.path(name);
      read_array(arr, child);
   }

   private void read_array(char[] arr, JsonNode child)
   {
      for (int i = 0; i < arr.length; i++)
      {
         JsonNode element = child.get(i);
         if (element != null)
         {
            arr[i] = str2char(element.asText());
         }
         else
         {
            arr[i] = '\0';
         }
      }
   }

   public void read_type_f(String name, short[] arr)
   {
      checkArraySupport();
      JsonNode child = node.path(name);
      read_array(arr, child);
   }

   private void read_array(short[] arr, JsonNode child)
   {
      for (int i = 0; i < arr.length; i++)
      {
         JsonNode element = child.get(i);
         if (element != null)
         {
            arr[i] = (short) element.asInt();
         }
         else
         {
            arr[i] = (short) 0;
         }
      }
   }

   public void read_type_f(String name, int[] arr)
   {
      checkArraySupport();
      JsonNode child = node.path(name);
      read_array(arr, child);
   }

   private void read_array(int[] arr, JsonNode child)
   {
      for (int i = 0; i < arr.length; i++)
      {
         JsonNode element = child.get(i);
         if (element != null)
         {
            arr[i] = element.asInt();
         }
         else
         {
            arr[i] = 0;
         }
      }
   }

   public void read_type_f(String name, long[] arr)
   {
      checkArraySupport();
      JsonNode child = node.path(name);
      read_array(arr, child);
   }

   private void read_array(long[] arr, JsonNode child)
   {
      for (int i = 0; i < arr.length; i++)
      {
         JsonNode element = child.get(i);
         if (element != null)
         {
            arr[i] = element.asLong();
         }
         else
         {
            arr[i] = 0L;
         }
      }
   }

   public void read_type_f(String name, float[] arr)
   {
      checkArraySupport();
      JsonNode child = node.path(name);
      read_array(arr, child);
   }

   private void read_array(float[] arr, JsonNode child)
   {
      for (int i = 0; i < arr.length; i++)
      {
         JsonNode element = child.get(i);
         if (element != null)
         {
            arr[i] = (float) element.asDouble();
         }
         else
         {
            arr[i] = 0.0f;
         }
      }
   }

   public void read_type_f(String name, double[] arr)
   {
      checkArraySupport();
      JsonNode child = node.path(name);
      read_array(arr, child);
   }

   private void read_array(double[] arr, JsonNode child)
   {
      for (int i = 0; i < arr.length; i++)
      {
         JsonNode element = child.get(i);
         if (element != null)
         {
            arr[i] = element.asDouble();
         }
         else
         {
            arr[i] = 0.0;
         }
      }
   }

   public <T> void read_type_f(String name, T[] arr)
   {
      checkArraySupport();
      JsonNode child = node.path(name);
      read_array(arr, child, null);
      
   }

   public <T> void read_type_f(String name, TopicDataType<T> dataType, Object[] arr)
   {
      checkArraySupport();
      JsonNode child = node.path(name);
      read_array(arr, child, dataType);
      
   }

   @SuppressWarnings("unchecked")
   private <T> void read_array(T[] arr, JsonNode child, @SuppressWarnings("rawtypes") TopicDataType dataType)
   {
      if(child == null)
      {
         return;
      }
      
      Class<?> arrayType = arr.getClass().getComponentType();
      if(arrayType.isArray())
      {
         for (int i = 0; i < arr.length; i++)
         {
            JsonNode element = child.get(i);
            if(arr[i] instanceof boolean[])
               read_array((boolean[])arr[i], element);
            else if(arr[i] instanceof byte[])
               read_array((byte[])arr[i], element);
            else if(arr[i] instanceof char[])
               read_array((char[])arr[i], element);
            else if(arr[i] instanceof short[])
               read_array((short[])arr[i], element);
            else if(arr[i] instanceof int[])
               read_array((int[])arr[i], element);
            else if(arr[i] instanceof long[])
               read_array((long[])arr[i], element);
            else if(arr[i] instanceof float[])
               read_array((float[])arr[i], element);
            else if(arr[i] instanceof double[])
               read_array((double[])arr[i], element);
            else
               read_array((Object[])arr[i], element, dataType);
         }
      }
      else if (arrayType.isEnum())
      {
         Enum<?>[] enumConstants = (Enum[]) arr.getClass().getComponentType().getEnumConstants();
         for (int i = 0; i < arr.length; i++)
         {
            JsonNode element = child.get(i);
            if (element != null)
            {
               arr[i] = (T) str2enum(enumConstants, element.asText());
            }
            else
            {
               arr[i] = null;
            }
         }

      }
      else if(StringBuilder.class.isAssignableFrom(arrayType))
      {
         for (int i = 0; i < arr.length; i++)
         {
            JsonNode element = child.get(i);
            if(element != null)
            {
               ((StringBuilder) arr[i]).setLength(0);
               ((StringBuilder) arr[i]).append(element.asText());
            }
         }
      }
      else if (dataType != null)
      {
         for (int i = 0; i < arr.length; i++)
         {
            JsonNode element = child.get(i);
            if (element != null && element.isObject())
            {
               dataType.deserialize(new JacksonInterchangeSerializer((ObjectNode) element, supportsArrays), arr[i]);
            }
         }
      }
      else
      {
         throw new NotImplementedException("Unexpected array type " + arrayType + ". Aborting.");
      }
   }

   public void write_type_f(String name, boolean[] arr)
   {
      checkArraySupport();
      ArrayNode child = node.putArray(name);
      write_array(arr, child);

   }

   private void write_array(boolean[] arr, ArrayNode child)
   {
      for (int i = 0; i < arr.length; i++)
      {
         child.add(arr[i]);
      }
   }
   public void write_type_f(String name, byte[] arr)
   {
      checkArraySupport();
      ArrayNode child = node.putArray(name);
      write_array(arr, child);
      
   }
   
   private void write_array(byte[] arr, ArrayNode child)
   {
      for (int i = 0; i < arr.length; i++)
      {
         child.add(arr[i]);
      }
   }

   public void write_type_f(String name, char[] arr)
   {
      checkArraySupport();
      ArrayNode child = node.putArray(name);
      write_array(arr, child);

   }

   private void write_array(char[] arr, ArrayNode child)
   {
      for (int i = 0; i < arr.length; i++)
      {
         child.add(String.valueOf(arr[i]));
      }
   }

   public void write_type_f(String name, short[] arr)
   {
      checkArraySupport();
      ArrayNode child = node.putArray(name);
      write_array(arr, child);

   }

   private void write_array(short[] arr, ArrayNode child)
   {
      for (int i = 0; i < arr.length; i++)
      {
         child.add(arr[i]);
      }
   }

   public void write_type_f(String name, int[] arr)
   {
      checkArraySupport();
      ArrayNode child = node.putArray(name);
      write_array(arr, child);

   }

   private void write_array(int[] arr, ArrayNode child)
   {
      for (int i = 0; i < arr.length; i++)
      {
         child.add(arr[i]);
      }
   }

   public void write_type_f(String name, long[] arr)
   {
      checkArraySupport();
      ArrayNode child = node.putArray(name);
      write_array(arr, child);

   }

   private void write_array(long[] arr, ArrayNode child)
   {
      for (int i = 0; i < arr.length; i++)
      {
         child.add(arr[i]);
      }
   }

   public void write_type_f(String name, float[] arr)
   {
      checkArraySupport();
      ArrayNode child = node.putArray(name);
      write_array(arr, child);

   }

   private void write_array(float[] arr, ArrayNode child)
   {
      for (int i = 0; i < arr.length; i++)
      {
         child.add(arr[i]);
      }
   }

   public void write_type_f(String name, double[] arr)
   {
      checkArraySupport();
      ArrayNode child = node.putArray(name);
      write_array(arr, child);

   }

   private void write_array(double[] arr, ArrayNode child)
   {
      for (int i = 0; i < arr.length; i++)
      {
         child.add(arr[i]);
      }
   }
   
   @SuppressWarnings("unchecked")
   private <T> void write_array(ArrayNode child, T[] arr, @SuppressWarnings("rawtypes") TopicDataType dataType)
   {
      Class<?> arrayType = arr.getClass().getComponentType();
      if(arrayType.isArray())
      {
         for (int i = 0; i < arr.length; i++)
         {
            ArrayNode element = child.addArray();
            if(arr[i] instanceof boolean[])
               write_array((boolean[])arr[i], element);
            else if(arr[i] instanceof byte[])
               write_array((byte[])arr[i], element);
            else if(arr[i] instanceof char[])
               write_array((char[])arr[i], element);
            else if(arr[i] instanceof short[])
               write_array((short[])arr[i], element);
            else if(arr[i] instanceof int[])
               write_array((int[])arr[i], element);
            else if(arr[i] instanceof long[])
               write_array((long[])arr[i], element);
            else if(arr[i] instanceof float[])
               write_array((float[])arr[i], element);
            else if(arr[i] instanceof double[])
               write_array((double[])arr[i], element);
            else
               write_array(element, (Object[])arr[i], dataType);
         }
      }
      else if (arrayType.isEnum())
      {
         for (int i = 0; i < arr.length; i++)
         {
            if (arr[i] == null)
            {
               child.add("null");
            }
            else
            {
               child.add(((Enum<?>) arr[i]).name());
            }
         }
      }
      else if(StringBuilder.class.isAssignableFrom(arrayType))
      {
         for (int i = 0; i < arr.length; i++)
         {
            child.add(((StringBuilder) arr[i]).toString());
         }
      }
      else if (dataType != null)
      {
         for (int i = 0; i < arr.length; i++)
         {
            ObjectNode element = child.addObject();
            dataType.serialize(arr[i], new JacksonInterchangeSerializer(element, supportsArrays));
         }
      }
      else
      {
         throw new NotImplementedException("Unexpected array type " + arrayType + ". Aborting.");
      }
   }

   public <T> void write_type_f(String name, T[] arr)
   {
      checkArraySupport();
      ArrayNode child = node.putArray(name);
      write_array(child, arr, null);
      

   }

   public <T> void write_type_f(String name, TopicDataType<T> dataType, Object[] arr)
   {
      checkArraySupport();
      ArrayNode child = node.putArray(name);
      write_array(child, arr, dataType);
   }

   /**
    * Signed long, 64 bit
    */
   public long read_type_11(String name)
   {
      return node.path(name).asLong();
   }

   public void write_type_11(String name, long val)
   {
      node.put(name, val);
   }

   /**
    * Wide char (32 bits)
    */
   public char read_type_14(String name)
   {
      return read_type_8(name);
   }
   
   public void write_type_14(String name, char val)
   {
      write_type_8(name, val);
   }
   
   /**
    * Wide string
    */
   public void read_type_15(String name, StringBuilder res)
   {
      read_type_d(name, res);
   }

   public void write_type_15(String name, StringBuilder str)
   {
      write_type_d(name, str);
   }

}

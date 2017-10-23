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

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/**
 * Structure GUID_t, entity identifier, unique in DDS-RTPS Domain.
 * 
 * @author Jesper Smith
 *
 */
public class Guid
{
   public class GuidPrefix
   {
      public static final int size = 12;

      private byte[] value = new byte[size];

      public byte[] getValue()
      {
         return value;
      }

      public void setValue(byte[] value)
      {
         this.value = value;
      }

      private GuidPrefix()
      {
      }

      @Override
      public String toString()
      {
         StringBuilder sb = new StringBuilder(size * 2);
         for (byte b : value)
            sb.append(String.format("%02x", b));
         return sb.toString();
      }

      @Override
      public int hashCode()
      {
         return Arrays.hashCode(value);
      }

      @Override
      public boolean equals(Object obj)
      {
         if (this == obj)
            return true;
         if (obj == null)
            return false;
         if (getClass() != obj.getClass())
            return false;
         GuidPrefix other = (GuidPrefix) obj;
         if (!Arrays.equals(value, other.value))
            return false;
         return true;
      }

   }

   public class Entity
   {
      public static final int size = 4;

      private byte[] value = new byte[size];

      public byte[] getValue()
      {
         return value;
      }

      public void setValue(byte[] value)
      {
         this.value = value;
      }

      private Entity()
      {
      };

      @Override
      public String toString()
      {
         StringBuilder sb = new StringBuilder(size * 2);
         for (byte b : value)
            sb.append(String.format("%02x", b));
         return sb.toString();
      }

      @Override
      public int hashCode()
      {
         return Arrays.hashCode(value);
      }

      @Override
      public boolean equals(Object obj)
      {
         if (this == obj)
            return true;
         if (obj == null)
            return false;
         if (getClass() != obj.getClass())
            return false;
         Entity other = (Entity) obj;
         if (!Arrays.equals(value, other.value))
            return false;
         return true;
      }
   }

   private final GuidPrefix guidPrefix = new GuidPrefix();
   private final Entity entity = new Entity();

   private final ByteBuffer conversionBuffer = ByteBuffer.allocate(16);

   public Guid()
   {
      conversionBuffer.order(ByteOrder.nativeOrder());
   }

   public GuidPrefix getGuidPrefix()
   {
      return guidPrefix;
   }

   public Entity getEntity()
   {
      return entity;
   }

   public void fromPrimitives(long high, long low)
   {
      conversionBuffer.clear();
      conversionBuffer.putLong(high);
      conversionBuffer.putLong(low);
      conversionBuffer.flip();
      conversionBuffer.get(guidPrefix.value, 0, Guid.GuidPrefix.size);
      conversionBuffer.get(entity.value, 0, Guid.Entity.size);
   }

   @Override
   public String toString()
   {
      StringBuilder sb = new StringBuilder();
      sb.append("GUID Prefix: ");
      sb.append(guidPrefix.toString());
      sb.append(" Entity ID: ");
      sb.append(entity.toString());
      return sb.toString();
   }

   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + entity.hashCode();
      result = prime * result + guidPrefix.hashCode();
      return result;
   }

   @Override
   public boolean equals(Object obj)
   {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      Guid other = (Guid) obj;
      if (!entity.equals(other.entity))
         return false;
      if (!guidPrefix.equals(other.guidPrefix))
         return false;
      return true;
   }

   public void set(Guid guid)
   {
      System.arraycopy(guid.guidPrefix.value, 0, guidPrefix.value, 0, guidPrefix.value.length);
      System.arraycopy(guid.entity.value, 0, entity.value, 0, entity.value.length);
   }

}

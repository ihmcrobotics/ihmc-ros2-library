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

/**
 * Class Locator, uniquely identifies a communication channel for a particular transport.
 * 
 * @author Jesper Smith
 *
 */
public class Locator
{
   /**
    * Specifies the locator type
    */
   public enum Kind
   {
      LOCATOR_KIND_RESERVED, LOCATOR_KIND_UDPv4, LOCATOR_KIND_UDPv6
   }

   private final byte address[] = new byte[16];
   private Kind kind;
   private int port;

   /**
    * Default constructor
    */
   public Locator()
   {
      this.kind = Kind.LOCATOR_KIND_UDPv4;
      this.port = 0;
   }

   /**
    * Set IPv4 address as 4 octets.
    * 
    * @param o1
    * @param o2
    * @param o3
    * @param o4
    * 
    * @throws RuntimeException if locator kind is not LOCATOR_KIND_UDPv4
    */
   public void setIPv4Adress(byte o1, byte o2, byte o3, byte o4)
   {
      if (this.kind != Kind.LOCATOR_KIND_UDPv4)
      {
         throw new RuntimeException("Trying to set IPv4 address on locator that is not of kind LOCATOR_KIND_UDPv4");
      }
      address[12] = o1;
      address[13] = o2;
      address[14] = o3;
      address[15] = o4;
   }

   /**
    * Set IPv6 address as 8 groups
    * 
    * @param group0
    * @param group1
    * @param group2
    * @param group3
    * @param group4
    * @param group5
    * @param group6
    * @param group7
    * 
    * @throws RuntimeException if locator kind is not LOCATOR_KIND_UDPv6
    */
   public void setIPv6Address(int group0, int group1, int group2, int group3, int group4, int group5, int group6, int group7)
   {
      if (this.kind != Kind.LOCATOR_KIND_UDPv6)
      {
         throw new RuntimeException("Trying to set IPv4 address on locator that is not of kind LOCATOR_KIND_UDPv6");
      }
      address[0] = (byte) (group0 >> 8);
      address[1] = (byte) group0;
      address[2] = (byte) (group1 >> 8);
      address[3] = (byte) group1;
      address[4] = (byte) (group2 >> 8);
      address[5] = (byte) group2;
      address[6] = (byte) (group3 >> 8);
      address[7] = (byte) group3;
      address[8] = (byte) (group4 >> 8);
      address[9] = (byte) group4;
      address[10] = (byte) (group5 >> 8);
      address[11] = (byte) group5;
      address[12] = (byte) (group6 >> 8);
      address[13] = (byte) group6;
      address[14] = (byte) (group7 >> 8);
      address[15] = (byte) group7;
   }

   /**
    * Get a single octet of the address
    * 
    * @param octet octet number, 12-15 for IPv4, 0-15 for IPv6
    * @return
    */
   public byte getOctet(int octet)
   {
      return address[octet];
   }

   /**
    * 
    * @return Locator Kind
    */
   public Kind getKind()
   {
      return kind;
   }

   /**
    * 
    * @return Locator port
    */
   public int getPort()
   {
      return port;
   }

   /**
    * 
    * @param kind new Kind for this locator
    */
   public void setKind(Kind kind)
   {
      this.kind = kind;
   }

   /**
    * 
    * @param port new port for this locator
    */
   public void setPort(int port)
   {
      this.port = port;
   }

   public void setOctet(int i, byte locatorOctet)
   {
      address[i] = locatorOctet;
   }

   public String toString()
   {
      switch (kind)
      {
      case LOCATOR_KIND_UDPv4:
      {
         StringBuilder builder = new StringBuilder();
         builder.append(Kind.LOCATOR_KIND_UDPv4.toString());
         builder.append(" ");
         for (int i = 12; i < 16; i++)
         {
            builder.append((int) address[i] & 0xFF);
            if (i < 15)
            {
               builder.append(".");
            }
         }
         builder.append(":");
         builder.append(port);
         return builder.toString();
      }
      case LOCATOR_KIND_UDPv6:
      {
         StringBuilder builder = new StringBuilder();
         builder.append(Kind.LOCATOR_KIND_UDPv6.toString());
         builder.append(" ");
         for (int i = 0; i < 16; i += 2)
         {
            int group = (address[i] & 0xFF) << 8;
            group += (address[i+1] & 0xFF);
            
            builder.append(group);
            if (i < 15)
            {
               builder.append("::");
            }
         }
         builder.append(":");
         builder.append(port);
         return builder.toString();
      }
      case LOCATOR_KIND_RESERVED:
      default:
         return Kind.LOCATOR_KIND_RESERVED.toString();
      }
   }
}

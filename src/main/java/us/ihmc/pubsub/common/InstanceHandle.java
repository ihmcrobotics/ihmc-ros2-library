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

/**
 * Struct InstanceHandle_t, used to contain the key for WITH_KEY topics. 
 * 
 * @author Jesper Smith
 *
 */
public class InstanceHandle
{
   private byte value[] = new byte[16];

   public boolean isDefined()
   {
      for(int i = 0; i < 16; i++)
      {
            if(value[i] != 0)
            {
               return true;
            }
      }
      return false;
   }

 
   public byte[] getValue()
   {
      return value;
   }

   public void setValue(byte[] value)
   {
      this.value = value;
   }

}

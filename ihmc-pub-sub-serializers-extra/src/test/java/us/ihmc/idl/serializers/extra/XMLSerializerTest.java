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

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import us.ihmc.idl.generated.chat.ChatMessage;
import us.ihmc.idl.generated.chat.ChatMessagePubSubType;
import us.ihmc.idl.generated.test.IDLElementTest;
import us.ihmc.idl.generated.test.IDLElementTestPubSubType;

public class XMLSerializerTest
{
   @Test(expected=IOException.class)
   public void testException() throws IOException
   {
      IDLElementTestPubSubType dataType = new IDLElementTestPubSubType();
      XMLSerializer<IDLElementTest> serializer = new XMLSerializer<>(dataType);
      
      IDLElementTest testElement = JSONSerializerTest.createPopulatedIDLElementTest();
      
      serializer.serializeToString(testElement);
      
      
   }
   @Test(timeout = 30000)
   public void test() throws IOException
   {
      ChatMessagePubSubType dataType = new ChatMessagePubSubType();
      XMLSerializer<ChatMessage> serializer = new XMLSerializer<>(dataType);
      

      ChatMessage msg = new ChatMessage();
      msg.getSender().append("Java");
      msg.getMsg().append("Hello World");
      
      String xml = serializer.serializeToString(msg);
      
      ChatMessage res = serializer.deserialize(xml);
      
      assertEquals(msg, res);
      
   }

}

package us.ihmc.pubsub.test;

import org.junit.jupiter.api.Test;
import us.ihmc.idl.generated.chat.ChatMessage;
import us.ihmc.idl.generated.chat.ChatMessagePubSubType;
import us.ihmc.pubsub.common.SerializedPayload;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

public class ChatMessageTest
{
   @Test// timeout = 30000
   public void testHelloWorld() throws IOException
   {
      byte[] javaHelloWorld = { // just copy and paste terminal output for regression test
      0x00,
      0x01,
      0x00,
      0x00,
      0x00,
      0x00,
      0x00,
      0x00,
      0x05,
      0x00,
      0x00,
      0x00,
      0x4A,
      0x61,
      0x76,
      0x61,
      0x00,
      0x00,
      0x00,
      0x00,
      0x0C,
      0x00,
      0x00,
      0x00,
      0x48,
      0x65,
      0x6C,
      0x6C,
      0x6F,
      0x20,
      0x57,
      0x6F,
      0x72,
      0x6C,
      0x64,
      0x00};
      String senderIn = "Java";
      String msgIn = "Hello World";

      ChatMessage msg = new ChatMessage();
      msg.getSender().append(senderIn);
      msg.getMsg().append(msgIn);

      ChatMessagePubSubType type = new ChatMessagePubSubType();
      SerializedPayload payload = new SerializedPayload(type.getTypeSize());

      type.serialize(msg, payload);

      byte[] data = new byte[payload.getData().limit()];
      payload.getData().get(data);

      for (int i =0; i < data.length; i++)
      {
         System.out.printf("0x%02X\n", data[i]);
      }

      assertArrayEquals(javaHelloWorld, data);

      ChatMessage invertedMsg = new ChatMessage();
      SerializedPayload invertedPayload = new SerializedPayload(type.getTypeSize());
      invertedPayload.getData().put(javaHelloWorld);
      invertedPayload.getData().flip();
      type.deserialize(invertedPayload, invertedMsg);

      assertEquals(invertedMsg.getSender().toString(), senderIn);
      assertEquals(invertedMsg.getMsg().toString(), msgIn);
   }
}

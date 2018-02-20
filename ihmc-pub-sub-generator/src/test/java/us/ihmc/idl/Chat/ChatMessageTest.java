package us.ihmc.idl.Chat;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import us.ihmc.idl.generated.Chat.ChatMessage;
import us.ihmc.idl.generated.Chat.ChatMessagePubSubType;
import us.ihmc.pubsub.common.SerializedPayload;

public class ChatMessageTest
{
   @Test(timeout = 30000)
   public void testHelloWorld() throws IOException
   {
      byte[] javaHelloWorld = {(byte) 0x00, (byte) 0x01, (byte) 0x00, (byte) 0x00, 0x05, 0x00, 0x00, 0x00, 0x4a, 0x61, 0x76, 0x61, 0x00, 0x00, 0x00, 0x00, 0x0c, 0x00, 0x00, 0x00, 0x48, 0x65, 0x6c, 0x6c, 0x6f,
            0x20, 0x57, 0x6f, 0x72, 0x6c, 0x64, 0x00};
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

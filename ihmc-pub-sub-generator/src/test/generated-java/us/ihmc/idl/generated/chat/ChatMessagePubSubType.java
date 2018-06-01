package us.ihmc.idl.generated.chat;

/**
* 
* Topic data type of the struct "ChatMessage" defined in "ChatMessage.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from ChatMessage.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit ChatMessage.idl instead.
*
*/
public class ChatMessagePubSubType implements us.ihmc.pubsub.TopicDataType<us.ihmc.idl.generated.chat.ChatMessage>
{
   public static final java.lang.String name = "chat::ChatMessage";

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(us.ihmc.idl.generated.chat.ChatMessage data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, us.ihmc.idl.generated.chat.ChatMessage data) throws java.io.IOException
   {
      deserializeCDR.deserialize(serializedPayload);
      read(data, deserializeCDR);
      deserializeCDR.finishDeserialize();
   }

   public static int getMaxCdrSerializedSize()
   {
      return getMaxCdrSerializedSize(0);
   }

   public static int getMaxCdrSerializedSize(int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(us.ihmc.idl.generated.chat.ChatMessage data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(us.ihmc.idl.generated.chat.ChatMessage data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getSender().length() + 1;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getMsg().length() + 1;


      return current_alignment - initial_alignment;
   }

   public static void write(us.ihmc.idl.generated.chat.ChatMessage data, us.ihmc.idl.CDR cdr)
   {
      cdr.write_type_2(data.getKey());

      if(data.getSender().length() <= 255)
      cdr.write_type_d(data.getSender());else
          throw new RuntimeException("sender field exceeds the maximum length");

      if(data.getMsg().length() <= 255)
      cdr.write_type_d(data.getMsg());else
          throw new RuntimeException("msg field exceeds the maximum length");

   }

   public static void read(us.ihmc.idl.generated.chat.ChatMessage data, us.ihmc.idl.CDR cdr)
   {
      data.setKey(cdr.read_type_2());
      	
      cdr.read_type_d(data.getSender());	
      cdr.read_type_d(data.getMsg());	

   }

   @Override
   public final void serialize(us.ihmc.idl.generated.chat.ChatMessage data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_2("key", data.getKey());
      ser.write_type_d("sender", data.getSender());
      ser.write_type_d("msg", data.getMsg());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, us.ihmc.idl.generated.chat.ChatMessage data)
   {
      data.setKey(ser.read_type_2("key"));
      ser.read_type_d("sender", data.getSender());
      ser.read_type_d("msg", data.getMsg());
   }

   public static void staticCopy(us.ihmc.idl.generated.chat.ChatMessage src, us.ihmc.idl.generated.chat.ChatMessage dest)
   {
      dest.set(src);
   }

   @Override
   public us.ihmc.idl.generated.chat.ChatMessage createData()
   {
      return new us.ihmc.idl.generated.chat.ChatMessage();
   }
   @Override
   public int getTypeSize()
   {
      return us.ihmc.idl.CDR.getTypeSize(getMaxCdrSerializedSize());
   }

   @Override
   public java.lang.String getName()
   {
      return name;
   }
   
   public void serialize(us.ihmc.idl.generated.chat.ChatMessage data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(us.ihmc.idl.generated.chat.ChatMessage data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(us.ihmc.idl.generated.chat.ChatMessage src, us.ihmc.idl.generated.chat.ChatMessage dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public ChatMessagePubSubType newInstance()
   {
      return new ChatMessagePubSubType();
   }
}

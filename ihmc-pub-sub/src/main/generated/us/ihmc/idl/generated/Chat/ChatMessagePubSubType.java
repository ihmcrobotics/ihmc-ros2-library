package us.ihmc.idl.generated.Chat;

import java.io.IOException;

import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.common.SerializedPayload;
import us.ihmc.idl.InterchangeSerializer;
import us.ihmc.idl.CDR;
import us.ihmc.idl.IDLSequence;

/**
* 
* Topic data type of the struct "ChatMessage" defined in "ChatMessage.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from ChatMessage.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit ChatMessage.idl instead.
*
*/
public class ChatMessagePubSubType implements TopicDataType<us.ihmc.idl.generated.Chat.ChatMessage>
{
	public static final String name = "Chat::ChatMessage";
	
	
	
    public ChatMessagePubSubType()
    {
        
    }

	private final CDR serializeCDR = new CDR();
	private final CDR deserializeCDR = new CDR();

    
    @Override
   public void serialize(us.ihmc.idl.generated.Chat.ChatMessage data, SerializedPayload serializedPayload) throws IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }
   @Override
   public void deserialize(SerializedPayload serializedPayload, us.ihmc.idl.generated.Chat.ChatMessage data) throws IOException
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
	            
	    current_alignment += 4 + CDR.alignment(current_alignment, 4) + 255 + 1;

	    current_alignment += 4 + CDR.alignment(current_alignment, 4) + 255 + 1;

	
	    return current_alignment - initial_alignment;
	}


	public final static int getCdrSerializedSize(us.ihmc.idl.generated.Chat.ChatMessage data)
	{
		return getCdrSerializedSize(data, 0);
	}

	public final static int getCdrSerializedSize(us.ihmc.idl.generated.Chat.ChatMessage data, int current_alignment)
	{
	    int initial_alignment = current_alignment;
	            
	    current_alignment += 4 + CDR.alignment(current_alignment, 4) + data.getSender().length() + 1;

	    current_alignment += 4 + CDR.alignment(current_alignment, 4) + data.getMsg().length() + 1;

	
	    return current_alignment - initial_alignment;
	}
	
   public static void write(us.ihmc.idl.generated.Chat.ChatMessage data, CDR cdr)
   {

	    if(data.getSender().length() <= 255)
	    cdr.write_type_d(data.getSender());else
	        throw new RuntimeException("sender field exceeds the maximum length");

	    if(data.getMsg().length() <= 255)
	    cdr.write_type_d(data.getMsg());else
	        throw new RuntimeException("msg field exceeds the maximum length");
   }

   public static void read(us.ihmc.idl.generated.Chat.ChatMessage data, CDR cdr)
   {

	    	cdr.read_type_d(data.getSender());	

	    	cdr.read_type_d(data.getMsg());	
   }
   
	@Override
	public final void serialize(us.ihmc.idl.generated.Chat.ChatMessage data, InterchangeSerializer ser)
	{
			    ser.write_type_d("sender", data.getSender());
			    
			    ser.write_type_d("msg", data.getMsg());
			    
	}
	
	@Override
	public final void deserialize(InterchangeSerializer ser, us.ihmc.idl.generated.Chat.ChatMessage data)
	{
	    			ser.read_type_d("sender", data.getSender());	
	    	    
	    			ser.read_type_d("msg", data.getMsg());	
	    	    
	}

   public static void staticCopy(us.ihmc.idl.generated.Chat.ChatMessage src, us.ihmc.idl.generated.Chat.ChatMessage dest)
   {
      dest.set(src);
   }
   
   
   @Override
   public us.ihmc.idl.generated.Chat.ChatMessage createData()
   {
      return new us.ihmc.idl.generated.Chat.ChatMessage();
   }
      

   @Override
   public int getTypeSize()
   {
      return CDR.getTypeSize(getMaxCdrSerializedSize());
   }

   @Override
   public String getName()
   {
      return name;
   }
   
   public void serialize(us.ihmc.idl.generated.Chat.ChatMessage data, CDR cdr)
	{
		write(data, cdr);
	}

   public void deserialize(us.ihmc.idl.generated.Chat.ChatMessage data, CDR cdr)
   {
        read(data, cdr);
   }
   
   public void copy(us.ihmc.idl.generated.Chat.ChatMessage src, us.ihmc.idl.generated.Chat.ChatMessage dest)
   {
      staticCopy(src, dest);
   }	

   
   @Override
   public ChatMessagePubSubType newInstance()
   {
   	  return new ChatMessagePubSubType();
   }
}
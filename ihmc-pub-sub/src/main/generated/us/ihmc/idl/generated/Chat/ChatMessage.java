package us.ihmc.idl.generated.Chat;
import us.ihmc.idl.IDLSequence;
import java.util.Arrays;

/**
* 
* Definition of the class "ChatMessage" defined in ChatMessage.idl. 
*
* This file was automatically generated from ChatMessage.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit ChatMessage.idl instead.
*
*/
public class ChatMessage
{
    public ChatMessage()
    {
        	sender_ = new StringBuilder(255); 
        	msg_ = new StringBuilder(255); 
        
        
    }

    public void set(ChatMessage other)
    {
        	sender_.setLength(0);
        	sender_.append(other.sender_);
        	msg_.setLength(0);
        	msg_.append(other.msg_);
    }

        public void setSender(String sender)
        {
        	sender_.setLength(0);
        	sender_.append(sender);
        }
        
        public String getSenderAsString()
        {
        	return getSender().toString();
        }

    public StringBuilder getSender()
    {
        return sender_;
    }

        
        public void setMsg(String msg)
        {
        	msg_.setLength(0);
        	msg_.append(msg);
        }
        
        public String getMsgAsString()
        {
        	return getMsg().toString();
        }

    public StringBuilder getMsg()
    {
        return msg_;
    }

        




    @Override
    public boolean equals(Object other)
    {
        if(other == null) return false;
        if(other == this) return true;
        if(!(other instanceof ChatMessage)) return false;
        ChatMessage otherMyClass = (ChatMessage)other;
        boolean returnedValue = true;

        returnedValue &= us.ihmc.idl.IDLTools.equals(this.sender_, otherMyClass.sender_);
                
        returnedValue &= us.ihmc.idl.IDLTools.equals(this.msg_, otherMyClass.msg_);
                

        return returnedValue;
    }
    
     @Override
    public String toString()
    {
		StringBuilder builder = new StringBuilder();
		
      	builder.append("ChatMessage {");
        builder.append("sender=");
        builder.append(this.sender_);

                builder.append(", ");
        builder.append("msg=");
        builder.append(this.msg_);

                
        builder.append("}");
		return builder.toString();
    }

    private StringBuilder sender_; 
    private StringBuilder msg_; 

}
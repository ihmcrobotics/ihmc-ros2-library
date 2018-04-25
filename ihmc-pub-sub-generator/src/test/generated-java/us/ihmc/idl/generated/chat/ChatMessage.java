package us.ihmc.idl.generated.chat;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

// Define a ChatMessage
public class ChatMessage extends Packet<ChatMessage> implements Settable<ChatMessage>, EpsilonComparable<ChatMessage>
{
   public int key_;
   /*
           * This is the sender
           */
   public java.lang.StringBuilder sender_;
   // This is the message
   public java.lang.StringBuilder msg_;

   public ChatMessage()
   {
      sender_ = new java.lang.StringBuilder(255);
      msg_ = new java.lang.StringBuilder(255);
   }

   public ChatMessage(ChatMessage other)
   {
      this();
      set(other);
   }

   public void set(ChatMessage other)
   {
      key_ = other.key_;

      sender_.setLength(0);
      sender_.append(other.sender_);

      msg_.setLength(0);
      msg_.append(other.msg_);

   }

   public void setKey(int key)
   {
      key_ = key;
   }
   public int getKey()
   {
      return key_;
   }

   /*
           * This is the sender
           */
   public void setSender(java.lang.String sender)
   {
      sender_.setLength(0);
      sender_.append(sender);
   }

   /*
           * This is the sender
           */
   public java.lang.String getSenderAsString()
   {
      return getSender().toString();
   }
   /*
           * This is the sender
           */
   public java.lang.StringBuilder getSender()
   {
      return sender_;
   }

   // This is the message
   public void setMsg(java.lang.String msg)
   {
      msg_.setLength(0);
      msg_.append(msg);
   }

   // This is the message
   public java.lang.String getMsgAsString()
   {
      return getMsg().toString();
   }
   // This is the message
   public java.lang.StringBuilder getMsg()
   {
      return msg_;
   }


   public static Supplier<ChatMessagePubSubType> getPubSubType()
   {
      return ChatMessagePubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return ChatMessagePubSubType::new;
   }

   @Override
   public boolean epsilonEquals(ChatMessage other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.key_, other.key_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.sender_, other.sender_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.msg_, other.msg_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof ChatMessage)) return false;

      ChatMessage otherMyClass = (ChatMessage) other;

      if(this.key_ != otherMyClass.key_) return false;

      if (!us.ihmc.idl.IDLTools.equals(this.sender_, otherMyClass.sender_)) return false;

      if (!us.ihmc.idl.IDLTools.equals(this.msg_, otherMyClass.msg_)) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("ChatMessage {");
      builder.append("key=");
      builder.append(this.key_);      builder.append(", ");
      builder.append("sender=");
      builder.append(this.sender_);      builder.append(", ");
      builder.append("msg=");
      builder.append(this.msg_);
      builder.append("}");
      return builder.toString();
   }
}

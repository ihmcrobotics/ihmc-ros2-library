package us.ihmc.idl.generated.test;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

public class BigMessage extends Packet<BigMessage> implements Settable<BigMessage>, EpsilonComparable<BigMessage>
{
   public int id_;
   public us.ihmc.idl.IDLSequence.Object<us.ihmc.idl.generated.test.IDLSubmessage>  largeSequence_;

   public BigMessage()
   {
      largeSequence_ = new us.ihmc.idl.IDLSequence.Object<us.ihmc.idl.generated.test.IDLSubmessage> (100000, new us.ihmc.idl.generated.test.IDLSubmessagePubSubType());

   }

   public BigMessage(BigMessage other)
   {
      this();
      set(other);
   }

   public void set(BigMessage other)
   {
      id_ = other.id_;

      largeSequence_.set(other.largeSequence_);
   }

   public void setId(int id)
   {
      id_ = id;
   }
   public int getId()
   {
      return id_;
   }


   public us.ihmc.idl.IDLSequence.Object<us.ihmc.idl.generated.test.IDLSubmessage>  getLargeSequence()
   {
      return largeSequence_;
   }


   public static Supplier<BigMessagePubSubType> getPubSubType()
   {
      return BigMessagePubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return BigMessagePubSubType::new;
   }

   @Override
   public boolean epsilonEquals(BigMessage other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.id_, other.id_, epsilon)) return false;

      if (this.largeSequence_.size() != other.largeSequence_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.largeSequence_.size(); i++)
         {  if (!this.largeSequence_.get(i).epsilonEquals(other.largeSequence_.get(i), epsilon)) return false; }
      }


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof BigMessage)) return false;

      BigMessage otherMyClass = (BigMessage) other;

      if(this.id_ != otherMyClass.id_) return false;

      if (!this.largeSequence_.equals(otherMyClass.largeSequence_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("BigMessage {");
      builder.append("id=");
      builder.append(this.id_);      builder.append(", ");
      builder.append("largeSequence=");
      builder.append(this.largeSequence_);
      builder.append("}");
      return builder.toString();
   }
}

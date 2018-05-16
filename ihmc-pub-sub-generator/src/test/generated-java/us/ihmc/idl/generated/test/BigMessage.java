package us.ihmc.idl.generated.test;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

public class BigMessage extends Packet<BigMessage> implements Settable<BigMessage>, EpsilonComparable<BigMessage>
{
   public us.ihmc.idl.IDLSequence.Double  largeSequence_;

   public BigMessage()
   {
      largeSequence_ = new us.ihmc.idl.IDLSequence.Double (100000, "type_6");

   }

   public BigMessage(BigMessage other)
   {
      this();
      set(other);
   }

   public void set(BigMessage other)
   {
      largeSequence_.set(other.largeSequence_);
   }


   public us.ihmc.idl.IDLSequence.Double  getLargeSequence()
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

      if (!us.ihmc.idl.IDLTools.epsilonEqualsDoubleSequence(this.largeSequence_, other.largeSequence_, epsilon)) return false;

      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof BigMessage)) return false;

      BigMessage otherMyClass = (BigMessage) other;

      if (!this.largeSequence_.equals(otherMyClass.largeSequence_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("BigMessage {");
      builder.append("largeSequence=");
      builder.append(this.largeSequence_);
      builder.append("}");
      return builder.toString();
   }
}

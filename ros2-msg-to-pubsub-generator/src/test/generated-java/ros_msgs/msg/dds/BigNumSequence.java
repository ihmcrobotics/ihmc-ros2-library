package ros_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

public class BigNumSequence extends Packet<BigNumSequence> implements Settable<BigNumSequence>, EpsilonComparable<BigNumSequence>
{
   public us.ihmc.idl.IDLSequence.Object<ros_msgs.msg.dds.Num>  large_sequence_;

   public BigNumSequence()
   {
      large_sequence_ = new us.ihmc.idl.IDLSequence.Object<ros_msgs.msg.dds.Num> (10000, new ros_msgs.msg.dds.NumPubSubType());

   }

   public BigNumSequence(BigNumSequence other)
   {
      this();
      set(other);
   }

   public void set(BigNumSequence other)
   {
      large_sequence_.set(other.large_sequence_);
   }


   public us.ihmc.idl.IDLSequence.Object<ros_msgs.msg.dds.Num>  getLargeSequence()
   {
      return large_sequence_;
   }


   public static Supplier<BigNumSequencePubSubType> getPubSubType()
   {
      return BigNumSequencePubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return BigNumSequencePubSubType::new;
   }

   @Override
   public boolean epsilonEquals(BigNumSequence other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (this.large_sequence_.size() != other.large_sequence_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.large_sequence_.size(); i++)
         {  if (!this.large_sequence_.get(i).epsilonEquals(other.large_sequence_.get(i), epsilon)) return false; }
      }

      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof BigNumSequence)) return false;

      BigNumSequence otherMyClass = (BigNumSequence) other;

      if (!this.large_sequence_.equals(otherMyClass.large_sequence_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("BigNumSequence {");
      builder.append("large_sequence=");
      builder.append(this.large_sequence_);
      builder.append("}");
      return builder.toString();
   }
}

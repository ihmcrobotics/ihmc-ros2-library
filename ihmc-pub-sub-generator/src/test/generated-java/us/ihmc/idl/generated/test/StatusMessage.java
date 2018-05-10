package us.ihmc.idl.generated.test;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
 * This message is to test sending uint32_t.
 */
public class StatusMessage extends Packet<StatusMessage> implements Settable<StatusMessage>, EpsilonComparable<StatusMessage>
{
   public long sequence_id_;
   public boolean pause_;

   public StatusMessage()
   {
   }

   public StatusMessage(StatusMessage other)
   {
      this();
      set(other);
   }

   public void set(StatusMessage other)
   {
      sequence_id_ = other.sequence_id_;

      pause_ = other.pause_;

   }

   public void setSequenceId(long sequence_id)
   {
      sequence_id_ = sequence_id;
   }
   public long getSequenceId()
   {
      return sequence_id_;
   }

   public void setPause(boolean pause)
   {
      pause_ = pause;
   }
   public boolean getPause()
   {
      return pause_;
   }


   public static Supplier<StatusMessagePubSubType> getPubSubType()
   {
      return StatusMessagePubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return StatusMessagePubSubType::new;
   }

   @Override
   public boolean epsilonEquals(StatusMessage other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.sequence_id_, other.sequence_id_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.pause_, other.pause_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof StatusMessage)) return false;

      StatusMessage otherMyClass = (StatusMessage) other;

      if(this.sequence_id_ != otherMyClass.sequence_id_) return false;

      if(this.pause_ != otherMyClass.pause_) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("StatusMessage {");
      builder.append("sequence_id=");
      builder.append(this.sequence_id_);      builder.append(", ");
      builder.append("pause=");
      builder.append(this.pause_);
      builder.append("}");
      return builder.toString();
   }
}

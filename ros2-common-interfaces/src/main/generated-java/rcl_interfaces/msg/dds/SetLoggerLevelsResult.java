package rcl_interfaces.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

public class SetLoggerLevelsResult extends Packet<SetLoggerLevelsResult> implements Settable<SetLoggerLevelsResult>, EpsilonComparable<SetLoggerLevelsResult>
{
   /**
            * True when succeed, false when failed.
            */
   public boolean successful_;
   /**
            * Reason why the setting was either successful or a failure.
            */
   public java.lang.StringBuilder reason_;

   public SetLoggerLevelsResult()
   {
      reason_ = new java.lang.StringBuilder(255);
   }

   public SetLoggerLevelsResult(SetLoggerLevelsResult other)
   {
      this();
      set(other);
   }

   public void set(SetLoggerLevelsResult other)
   {
      successful_ = other.successful_;

      reason_.setLength(0);
      reason_.append(other.reason_);

   }

   /**
            * True when succeed, false when failed.
            */
   public void setSuccessful(boolean successful)
   {
      successful_ = successful;
   }
   /**
            * True when succeed, false when failed.
            */
   public boolean getSuccessful()
   {
      return successful_;
   }

   /**
            * Reason why the setting was either successful or a failure.
            */
   public void setReason(java.lang.String reason)
   {
      reason_.setLength(0);
      reason_.append(reason);
   }

   /**
            * Reason why the setting was either successful or a failure.
            */
   public java.lang.String getReasonAsString()
   {
      return getReason().toString();
   }
   /**
            * Reason why the setting was either successful or a failure.
            */
   public java.lang.StringBuilder getReason()
   {
      return reason_;
   }


   public static Supplier<SetLoggerLevelsResultPubSubType> getPubSubType()
   {
      return SetLoggerLevelsResultPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return SetLoggerLevelsResultPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(SetLoggerLevelsResult other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.successful_, other.successful_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.reason_, other.reason_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof SetLoggerLevelsResult)) return false;

      SetLoggerLevelsResult otherMyClass = (SetLoggerLevelsResult) other;

      if(this.successful_ != otherMyClass.successful_) return false;

      if (!us.ihmc.idl.IDLTools.equals(this.reason_, otherMyClass.reason_)) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("SetLoggerLevelsResult {");
      builder.append("successful=");
      builder.append(this.successful_);      builder.append(", ");
      builder.append("reason=");
      builder.append(this.reason_);
      builder.append("}");
      return builder.toString();
   }
}

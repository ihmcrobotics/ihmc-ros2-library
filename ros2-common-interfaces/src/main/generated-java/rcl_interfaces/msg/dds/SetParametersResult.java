package rcl_interfaces.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

public class SetParametersResult extends Packet<SetParametersResult> implements Settable<SetParametersResult>, EpsilonComparable<SetParametersResult>
{
   /**
            * A true value of the same index indicates that the parameter was set
            * successfully. A false value indicates the change was rejected.
            */
   public boolean successful_;
   /**
            * Reason why the setting was either successful or a failure. This should only be
            * used for logging and user interfaces.
            */
   public java.lang.StringBuilder reason_;

   public SetParametersResult()
   {
      reason_ = new java.lang.StringBuilder(255);
   }

   public SetParametersResult(SetParametersResult other)
   {
      this();
      set(other);
   }

   public void set(SetParametersResult other)
   {
      successful_ = other.successful_;

      reason_.setLength(0);
      reason_.append(other.reason_);

   }

   /**
            * A true value of the same index indicates that the parameter was set
            * successfully. A false value indicates the change was rejected.
            */
   public void setSuccessful(boolean successful)
   {
      successful_ = successful;
   }
   /**
            * A true value of the same index indicates that the parameter was set
            * successfully. A false value indicates the change was rejected.
            */
   public boolean getSuccessful()
   {
      return successful_;
   }

   /**
            * Reason why the setting was either successful or a failure. This should only be
            * used for logging and user interfaces.
            */
   public void setReason(java.lang.String reason)
   {
      reason_.setLength(0);
      reason_.append(reason);
   }

   /**
            * Reason why the setting was either successful or a failure. This should only be
            * used for logging and user interfaces.
            */
   public java.lang.String getReasonAsString()
   {
      return getReason().toString();
   }
   /**
            * Reason why the setting was either successful or a failure. This should only be
            * used for logging and user interfaces.
            */
   public java.lang.StringBuilder getReason()
   {
      return reason_;
   }


   public static Supplier<SetParametersResultPubSubType> getPubSubType()
   {
      return SetParametersResultPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return SetParametersResultPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(SetParametersResult other, double epsilon)
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
      if(!(other instanceof SetParametersResult)) return false;

      SetParametersResult otherMyClass = (SetParametersResult) other;

      if(this.successful_ != otherMyClass.successful_) return false;

      if (!us.ihmc.idl.IDLTools.equals(this.reason_, otherMyClass.reason_)) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("SetParametersResult {");
      builder.append("successful=");
      builder.append(this.successful_);      builder.append(", ");
      builder.append("reason=");
      builder.append(this.reason_);
      builder.append("}");
      return builder.toString();
   }
}

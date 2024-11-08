package rcl_interfaces.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * These types correspond to the value that is set in the ParameterValue message.
       */
public class ParameterType extends Packet<ParameterType> implements Settable<ParameterType>, EpsilonComparable<ParameterType>
{
   /**
          * Default value, which implies this is not a valid parameter.
          */
   public static final byte PARAMETER_NOT_SET = (byte) 0;
   public static final byte PARAMETER_BOOL = (byte) 1;
   public static final byte PARAMETER_INTEGER = (byte) 2;
   public static final byte PARAMETER_DOUBLE = (byte) 3;
   public static final byte PARAMETER_STRING = (byte) 4;
   public static final byte PARAMETER_BYTE_ARRAY = (byte) 5;
   public static final byte PARAMETER_BOOL_ARRAY = (byte) 6;
   public static final byte PARAMETER_INTEGER_ARRAY = (byte) 7;
   public static final byte PARAMETER_DOUBLE_ARRAY = (byte) 8;
   public static final byte PARAMETER_STRING_ARRAY = (byte) 9;
   public boolean unused_placeholder_field_;

   public ParameterType()
   {
   }

   public ParameterType(ParameterType other)
   {
      this();
      set(other);
   }

   public void set(ParameterType other)
   {
      unused_placeholder_field_ = other.unused_placeholder_field_;

   }

   public void setUnusedPlaceholderField(boolean unused_placeholder_field)
   {
      unused_placeholder_field_ = unused_placeholder_field;
   }
   public boolean getUnusedPlaceholderField()
   {
      return unused_placeholder_field_;
   }


   public static Supplier<ParameterTypePubSubType> getPubSubType()
   {
      return ParameterTypePubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return ParameterTypePubSubType::new;
   }

   @Override
   public boolean epsilonEquals(ParameterType other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.unused_placeholder_field_, other.unused_placeholder_field_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof ParameterType)) return false;

      ParameterType otherMyClass = (ParameterType) other;

      if(this.unused_placeholder_field_ != otherMyClass.unused_placeholder_field_) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("ParameterType {");
      builder.append("unused_placeholder_field=");
      builder.append(this.unused_placeholder_field_);
      builder.append("}");
      return builder.toString();
   }
}

package rcl_interfaces.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * Used to determine which of the next *_value fields are set.
       * ParameterType.PARAMETER_NOT_SET indicates that the parameter was not set
       * (if gotten) or is uninitialized.
       * Values are enumerated in `ParameterType.msg`.
       * "Variant" style storage of the parameter value. Only the value corresponding
       * the type field will have valid information.
       */
public class ParameterValue extends Packet<ParameterValue> implements Settable<ParameterValue>, EpsilonComparable<ParameterValue>
{
   /**
            * The type of this parameter, which corresponds to the appropriate field below.
            */
   public byte type_;
   /**
            * Boolean value, can be either true or false.
            */
   public boolean bool_value_;
   /**
            * Integer value ranging from -9,223,372,036,854,775,808 to
            * 9,223,372,036,854,775,807.
            */
   public long integer_value_;
   /**
            * A double precision floating point value following IEEE 754.
            */
   public double double_value_;
   /**
            * A textual value with no practical length limit.
            */
   public java.lang.StringBuilder string_value_;
   /**
            * An array of bytes, used for non-textual information.
            */
   public us.ihmc.idl.IDLSequence.Byte  byte_array_value_;
   /**
            * An array of boolean values.
            */
   public us.ihmc.idl.IDLSequence.Boolean  bool_array_value_;
   /**
            * An array of 64-bit integer values.
            */
   public us.ihmc.idl.IDLSequence.Long  integer_array_value_;
   /**
            * An array of 64-bit floating point values.
            */
   public us.ihmc.idl.IDLSequence.Double  double_array_value_;
   /**
            * An array of string values.
            */
   public us.ihmc.idl.IDLSequence.StringBuilderHolder  string_array_value_;

   public ParameterValue()
   {
      string_value_ = new java.lang.StringBuilder(255);
      byte_array_value_ = new us.ihmc.idl.IDLSequence.Byte (100, "type_9");

      bool_array_value_ = new us.ihmc.idl.IDLSequence.Boolean (100, "type_7");

      integer_array_value_ = new us.ihmc.idl.IDLSequence.Long (100, "type_11");

      double_array_value_ = new us.ihmc.idl.IDLSequence.Double (100, "type_6");

      string_array_value_ = new us.ihmc.idl.IDLSequence.StringBuilderHolder (100, "type_d");
   }

   public ParameterValue(ParameterValue other)
   {
      this();
      set(other);
   }

   public void set(ParameterValue other)
   {
      type_ = other.type_;

      bool_value_ = other.bool_value_;

      integer_value_ = other.integer_value_;

      double_value_ = other.double_value_;

      string_value_.setLength(0);
      string_value_.append(other.string_value_);

      byte_array_value_.set(other.byte_array_value_);
      bool_array_value_.set(other.bool_array_value_);
      integer_array_value_.set(other.integer_array_value_);
      double_array_value_.set(other.double_array_value_);
      string_array_value_.set(other.string_array_value_);
   }

   /**
            * The type of this parameter, which corresponds to the appropriate field below.
            */
   public void setType(byte type)
   {
      type_ = type;
   }
   /**
            * The type of this parameter, which corresponds to the appropriate field below.
            */
   public byte getType()
   {
      return type_;
   }

   /**
            * Boolean value, can be either true or false.
            */
   public void setBoolValue(boolean bool_value)
   {
      bool_value_ = bool_value;
   }
   /**
            * Boolean value, can be either true or false.
            */
   public boolean getBoolValue()
   {
      return bool_value_;
   }

   /**
            * Integer value ranging from -9,223,372,036,854,775,808 to
            * 9,223,372,036,854,775,807.
            */
   public void setIntegerValue(long integer_value)
   {
      integer_value_ = integer_value;
   }
   /**
            * Integer value ranging from -9,223,372,036,854,775,808 to
            * 9,223,372,036,854,775,807.
            */
   public long getIntegerValue()
   {
      return integer_value_;
   }

   /**
            * A double precision floating point value following IEEE 754.
            */
   public void setDoubleValue(double double_value)
   {
      double_value_ = double_value;
   }
   /**
            * A double precision floating point value following IEEE 754.
            */
   public double getDoubleValue()
   {
      return double_value_;
   }

   /**
            * A textual value with no practical length limit.
            */
   public void setStringValue(java.lang.String string_value)
   {
      string_value_.setLength(0);
      string_value_.append(string_value);
   }

   /**
            * A textual value with no practical length limit.
            */
   public java.lang.String getStringValueAsString()
   {
      return getStringValue().toString();
   }
   /**
            * A textual value with no practical length limit.
            */
   public java.lang.StringBuilder getStringValue()
   {
      return string_value_;
   }


   /**
            * An array of bytes, used for non-textual information.
            */
   public us.ihmc.idl.IDLSequence.Byte  getByteArrayValue()
   {
      return byte_array_value_;
   }


   /**
            * An array of boolean values.
            */
   public us.ihmc.idl.IDLSequence.Boolean  getBoolArrayValue()
   {
      return bool_array_value_;
   }


   /**
            * An array of 64-bit integer values.
            */
   public us.ihmc.idl.IDLSequence.Long  getIntegerArrayValue()
   {
      return integer_array_value_;
   }


   /**
            * An array of 64-bit floating point values.
            */
   public us.ihmc.idl.IDLSequence.Double  getDoubleArrayValue()
   {
      return double_array_value_;
   }


   /**
            * An array of string values.
            */
   public us.ihmc.idl.IDLSequence.StringBuilderHolder  getStringArrayValue()
   {
      return string_array_value_;
   }


   public static Supplier<ParameterValuePubSubType> getPubSubType()
   {
      return ParameterValuePubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return ParameterValuePubSubType::new;
   }

   @Override
   public boolean epsilonEquals(ParameterValue other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.type_, other.type_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.bool_value_, other.bool_value_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.integer_value_, other.integer_value_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.double_value_, other.double_value_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.string_value_, other.string_value_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsByteSequence(this.byte_array_value_, other.byte_array_value_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBooleanSequence(this.bool_array_value_, other.bool_array_value_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsLongSequence(this.integer_array_value_, other.integer_array_value_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsDoubleSequence(this.double_array_value_, other.double_array_value_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilderSequence(this.string_array_value_, other.string_array_value_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof ParameterValue)) return false;

      ParameterValue otherMyClass = (ParameterValue) other;

      if(this.type_ != otherMyClass.type_) return false;

      if(this.bool_value_ != otherMyClass.bool_value_) return false;

      if(this.integer_value_ != otherMyClass.integer_value_) return false;

      if(this.double_value_ != otherMyClass.double_value_) return false;

      if (!us.ihmc.idl.IDLTools.equals(this.string_value_, otherMyClass.string_value_)) return false;

      if (!this.byte_array_value_.equals(otherMyClass.byte_array_value_)) return false;
      if (!this.bool_array_value_.equals(otherMyClass.bool_array_value_)) return false;
      if (!this.integer_array_value_.equals(otherMyClass.integer_array_value_)) return false;
      if (!this.double_array_value_.equals(otherMyClass.double_array_value_)) return false;
      if (!this.string_array_value_.equals(otherMyClass.string_array_value_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("ParameterValue {");
      builder.append("type=");
      builder.append(this.type_);      builder.append(", ");
      builder.append("bool_value=");
      builder.append(this.bool_value_);      builder.append(", ");
      builder.append("integer_value=");
      builder.append(this.integer_value_);      builder.append(", ");
      builder.append("double_value=");
      builder.append(this.double_value_);      builder.append(", ");
      builder.append("string_value=");
      builder.append(this.string_value_);      builder.append(", ");
      builder.append("byte_array_value=");
      builder.append(this.byte_array_value_);      builder.append(", ");
      builder.append("bool_array_value=");
      builder.append(this.bool_array_value_);      builder.append(", ");
      builder.append("integer_array_value=");
      builder.append(this.integer_array_value_);      builder.append(", ");
      builder.append("double_array_value=");
      builder.append(this.double_array_value_);      builder.append(", ");
      builder.append("string_array_value=");
      builder.append(this.string_array_value_);
      builder.append("}");
      return builder.toString();
   }
}

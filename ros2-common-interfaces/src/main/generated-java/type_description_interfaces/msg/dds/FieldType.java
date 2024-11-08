package type_description_interfaces.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * Represents the type of a field and related meta-data.
       * A constant for each type supported according to:
       * http://design.ros2.org/articles/legacy_interface_definition.html
       * and:
       * http://design.ros2.org/articles/idl_interface_definition.html
       * Order is loosely coupled to the order of appearance in the IDL 4.2 spec:
       * https://www.omg.org/spec/IDL/4.2
       * Layout of constants across the 0-255 decimal values in the uint8:
       * 
       * - 000    : Reserved for "not set"
       * - 001-048: Primitive types, strings, and reserved space for future primitive types
       * - 049-096: Fixed sized array of primitive and string types
       * - 097-144: Bounded Sequences of primitive and string types
       * - 145-192: Unbounded Sequences of primitive and string types
       * - 193-255: Reserved space for future array/sequence-like types
       */
public class FieldType extends Packet<FieldType> implements Settable<FieldType>, EpsilonComparable<FieldType>
{
   public static final byte FIELD_TYPE_NOT_SET = (byte) 0;
   /**
          * Nested type defined in other .msg/.idl files.
          */
   public static final byte FIELD_TYPE_NESTED_TYPE = (byte) 1;
   /**
          * Integer Types
          */
   public static final byte FIELD_TYPE_INT8 = (byte) 2;
   public static final byte FIELD_TYPE_UINT8 = (byte) 3;
   public static final byte FIELD_TYPE_INT16 = (byte) 4;
   public static final byte FIELD_TYPE_UINT16 = (byte) 5;
   public static final byte FIELD_TYPE_INT32 = (byte) 6;
   public static final byte FIELD_TYPE_UINT32 = (byte) 7;
   public static final byte FIELD_TYPE_INT64 = (byte) 8;
   public static final byte FIELD_TYPE_UINT64 = (byte) 9;
   /**
          * Floating-Point Types
          */
   public static final byte FIELD_TYPE_FLOAT = (byte) 10;
   public static final byte FIELD_TYPE_DOUBLE = (byte) 11;
   public static final byte FIELD_TYPE_LONG_DOUBLE = (byte) 12;
   /**
          * Char and WChar Types
          */
   public static final byte FIELD_TYPE_CHAR = (byte) 13;
   public static final byte FIELD_TYPE_WCHAR = (byte) 14;
   /**
          * Boolean Type
          */
   public static final byte FIELD_TYPE_BOOLEAN = (byte) 15;
   /**
          * Byte/Octet Type
          */
   public static final byte FIELD_TYPE_BYTE = (byte) 16;
   /**
          * String Types
          */
   public static final byte FIELD_TYPE_STRING = (byte) 17;
   public static final byte FIELD_TYPE_WSTRING = (byte) 18;
   /**
          * Fixed String Types
          */
   public static final byte FIELD_TYPE_FIXED_STRING = (byte) 19;
   public static final byte FIELD_TYPE_FIXED_WSTRING = (byte) 20;
   /**
          * Bounded String Types
          */
   public static final byte FIELD_TYPE_BOUNDED_STRING = (byte) 21;
   public static final byte FIELD_TYPE_BOUNDED_WSTRING = (byte) 22;
   /**
          * Fixed Sized Array Types
          */
   public static final byte FIELD_TYPE_NESTED_TYPE_ARRAY = (byte) 49;
   public static final byte FIELD_TYPE_INT8_ARRAY = (byte) 50;
   public static final byte FIELD_TYPE_UINT8_ARRAY = (byte) 51;
   public static final byte FIELD_TYPE_INT16_ARRAY = (byte) 52;
   public static final byte FIELD_TYPE_UINT16_ARRAY = (byte) 53;
   public static final byte FIELD_TYPE_INT32_ARRAY = (byte) 54;
   public static final byte FIELD_TYPE_UINT32_ARRAY = (byte) 55;
   public static final byte FIELD_TYPE_INT64_ARRAY = (byte) 56;
   public static final byte FIELD_TYPE_UINT64_ARRAY = (byte) 57;
   public static final byte FIELD_TYPE_FLOAT_ARRAY = (byte) 58;
   public static final byte FIELD_TYPE_DOUBLE_ARRAY = (byte) 59;
   public static final byte FIELD_TYPE_LONG_DOUBLE_ARRAY = (byte) 60;
   public static final byte FIELD_TYPE_CHAR_ARRAY = (byte) 61;
   public static final byte FIELD_TYPE_WCHAR_ARRAY = (byte) 62;
   public static final byte FIELD_TYPE_BOOLEAN_ARRAY = (byte) 63;
   public static final byte FIELD_TYPE_BYTE_ARRAY = (byte) 64;
   public static final byte FIELD_TYPE_STRING_ARRAY = (byte) 65;
   public static final byte FIELD_TYPE_WSTRING_ARRAY = (byte) 66;
   public static final byte FIELD_TYPE_FIXED_STRING_ARRAY = (byte) 67;
   public static final byte FIELD_TYPE_FIXED_WSTRING_ARRAY = (byte) 68;
   public static final byte FIELD_TYPE_BOUNDED_STRING_ARRAY = (byte) 69;
   public static final byte FIELD_TYPE_BOUNDED_WSTRING_ARRAY = (byte) 70;
   /**
          * Bounded Sequence Types
          */
   public static final byte FIELD_TYPE_NESTED_TYPE_BOUNDED_SEQUENCE = (byte) 97;
   public static final byte FIELD_TYPE_INT8_BOUNDED_SEQUENCE = (byte) 98;
   public static final byte FIELD_TYPE_UINT8_BOUNDED_SEQUENCE = (byte) 99;
   public static final byte FIELD_TYPE_INT16_BOUNDED_SEQUENCE = (byte) 100;
   public static final byte FIELD_TYPE_UINT16_BOUNDED_SEQUENCE = (byte) 101;
   public static final byte FIELD_TYPE_INT32_BOUNDED_SEQUENCE = (byte) 102;
   public static final byte FIELD_TYPE_UINT32_BOUNDED_SEQUENCE = (byte) 103;
   public static final byte FIELD_TYPE_INT64_BOUNDED_SEQUENCE = (byte) 104;
   public static final byte FIELD_TYPE_UINT64_BOUNDED_SEQUENCE = (byte) 105;
   public static final byte FIELD_TYPE_FLOAT_BOUNDED_SEQUENCE = (byte) 106;
   public static final byte FIELD_TYPE_DOUBLE_BOUNDED_SEQUENCE = (byte) 107;
   public static final byte FIELD_TYPE_LONG_DOUBLE_BOUNDED_SEQUENCE = (byte) 108;
   public static final byte FIELD_TYPE_CHAR_BOUNDED_SEQUENCE = (byte) 109;
   public static final byte FIELD_TYPE_WCHAR_BOUNDED_SEQUENCE = (byte) 110;
   public static final byte FIELD_TYPE_BOOLEAN_BOUNDED_SEQUENCE = (byte) 111;
   public static final byte FIELD_TYPE_BYTE_BOUNDED_SEQUENCE = (byte) 112;
   public static final byte FIELD_TYPE_STRING_BOUNDED_SEQUENCE = (byte) 113;
   public static final byte FIELD_TYPE_WSTRING_BOUNDED_SEQUENCE = (byte) 114;
   public static final byte FIELD_TYPE_FIXED_STRING_BOUNDED_SEQUENCE = (byte) 115;
   public static final byte FIELD_TYPE_FIXED_WSTRING_BOUNDED_SEQUENCE = (byte) 116;
   public static final byte FIELD_TYPE_BOUNDED_STRING_BOUNDED_SEQUENCE = (byte) 117;
   public static final byte FIELD_TYPE_BOUNDED_WSTRING_BOUNDED_SEQUENCE = (byte) 118;
   /**
          * Unbounded Sequence Types
          */
   public static final byte FIELD_TYPE_NESTED_TYPE_UNBOUNDED_SEQUENCE = (byte) 145;
   public static final byte FIELD_TYPE_INT8_UNBOUNDED_SEQUENCE = (byte) 146;
   public static final byte FIELD_TYPE_UINT8_UNBOUNDED_SEQUENCE = (byte) 147;
   public static final byte FIELD_TYPE_INT16_UNBOUNDED_SEQUENCE = (byte) 148;
   public static final byte FIELD_TYPE_UINT16_UNBOUNDED_SEQUENCE = (byte) 149;
   public static final byte FIELD_TYPE_INT32_UNBOUNDED_SEQUENCE = (byte) 150;
   public static final byte FIELD_TYPE_UINT32_UNBOUNDED_SEQUENCE = (byte) 151;
   public static final byte FIELD_TYPE_INT64_UNBOUNDED_SEQUENCE = (byte) 152;
   public static final byte FIELD_TYPE_UINT64_UNBOUNDED_SEQUENCE = (byte) 153;
   public static final byte FIELD_TYPE_FLOAT_UNBOUNDED_SEQUENCE = (byte) 154;
   public static final byte FIELD_TYPE_DOUBLE_UNBOUNDED_SEQUENCE = (byte) 155;
   public static final byte FIELD_TYPE_LONG_DOUBLE_UNBOUNDED_SEQUENCE = (byte) 156;
   public static final byte FIELD_TYPE_CHAR_UNBOUNDED_SEQUENCE = (byte) 157;
   public static final byte FIELD_TYPE_WCHAR_UNBOUNDED_SEQUENCE = (byte) 158;
   public static final byte FIELD_TYPE_BOOLEAN_UNBOUNDED_SEQUENCE = (byte) 159;
   public static final byte FIELD_TYPE_BYTE_UNBOUNDED_SEQUENCE = (byte) 160;
   public static final byte FIELD_TYPE_STRING_UNBOUNDED_SEQUENCE = (byte) 161;
   public static final byte FIELD_TYPE_WSTRING_UNBOUNDED_SEQUENCE = (byte) 162;
   public static final byte FIELD_TYPE_FIXED_STRING_UNBOUNDED_SEQUENCE = (byte) 163;
   public static final byte FIELD_TYPE_FIXED_WSTRING_UNBOUNDED_SEQUENCE = (byte) 164;
   public static final byte FIELD_TYPE_BOUNDED_STRING_UNBOUNDED_SEQUENCE = (byte) 165;
   public static final byte FIELD_TYPE_BOUNDED_WSTRING_UNBOUNDED_SEQUENCE = (byte) 166;
   /**
            * Identifying number for the type of the field, using one of the above constants.
            */
   public byte type_id_;
   /**
            * Only used when the type is an array or a bounded sequence.
            * In the case of an array, this is the fixed capacity of the array.
            * In the case of a bounded sequence, this is the maximum capacity of the sequence.
            * In all other cases this field is unused.
            */
   public long capacity_;
   /**
            * Only used when the type is a fixed or bounded string/wstring, or a array/sequence of those.
            * In the case of a fixed string/wstring, it is the fixed length of the string.
            * In the case of a bounded string/wstring, it is the maximum capacity of the string.
            * In the case of an array/sequence of fixed string/wstring, it is the fixed length of the strings.
            * In the case of an array/sequence of bounded string/wstring, it is the maximum capacity of the strings.
            * It is not currently possible to have different string capacities per element in the array/sequence.
            */
   public long string_capacity_;
   /**
            * Only used when the type is a nested type or array/sequence of nested types.
            * This is limited to 255 characters.
            * TODO(wjwwood): this 255 character limit was chosen due to this being the limit
            * for DDSI-RTPS based middlewares, which is the most commonly used right now.
            * We lack a ROS 2 specific limit in our design documents, but we should update
            * this and/or link to the design doc when that is available.
            */
   public java.lang.StringBuilder nested_type_name_;

   public FieldType()
   {
      nested_type_name_ = new java.lang.StringBuilder(255);
   }

   public FieldType(FieldType other)
   {
      this();
      set(other);
   }

   public void set(FieldType other)
   {
      type_id_ = other.type_id_;

      capacity_ = other.capacity_;

      string_capacity_ = other.string_capacity_;

      nested_type_name_.setLength(0);
      nested_type_name_.append(other.nested_type_name_);

   }

   /**
            * Identifying number for the type of the field, using one of the above constants.
            */
   public void setTypeId(byte type_id)
   {
      type_id_ = type_id;
   }
   /**
            * Identifying number for the type of the field, using one of the above constants.
            */
   public byte getTypeId()
   {
      return type_id_;
   }

   /**
            * Only used when the type is an array or a bounded sequence.
            * In the case of an array, this is the fixed capacity of the array.
            * In the case of a bounded sequence, this is the maximum capacity of the sequence.
            * In all other cases this field is unused.
            */
   public void setCapacity(long capacity)
   {
      capacity_ = capacity;
   }
   /**
            * Only used when the type is an array or a bounded sequence.
            * In the case of an array, this is the fixed capacity of the array.
            * In the case of a bounded sequence, this is the maximum capacity of the sequence.
            * In all other cases this field is unused.
            */
   public long getCapacity()
   {
      return capacity_;
   }

   /**
            * Only used when the type is a fixed or bounded string/wstring, or a array/sequence of those.
            * In the case of a fixed string/wstring, it is the fixed length of the string.
            * In the case of a bounded string/wstring, it is the maximum capacity of the string.
            * In the case of an array/sequence of fixed string/wstring, it is the fixed length of the strings.
            * In the case of an array/sequence of bounded string/wstring, it is the maximum capacity of the strings.
            * It is not currently possible to have different string capacities per element in the array/sequence.
            */
   public void setStringCapacity(long string_capacity)
   {
      string_capacity_ = string_capacity;
   }
   /**
            * Only used when the type is a fixed or bounded string/wstring, or a array/sequence of those.
            * In the case of a fixed string/wstring, it is the fixed length of the string.
            * In the case of a bounded string/wstring, it is the maximum capacity of the string.
            * In the case of an array/sequence of fixed string/wstring, it is the fixed length of the strings.
            * In the case of an array/sequence of bounded string/wstring, it is the maximum capacity of the strings.
            * It is not currently possible to have different string capacities per element in the array/sequence.
            */
   public long getStringCapacity()
   {
      return string_capacity_;
   }

   /**
            * Only used when the type is a nested type or array/sequence of nested types.
            * This is limited to 255 characters.
            * TODO(wjwwood): this 255 character limit was chosen due to this being the limit
            * for DDSI-RTPS based middlewares, which is the most commonly used right now.
            * We lack a ROS 2 specific limit in our design documents, but we should update
            * this and/or link to the design doc when that is available.
            */
   public void setNestedTypeName(java.lang.String nested_type_name)
   {
      nested_type_name_.setLength(0);
      nested_type_name_.append(nested_type_name);
   }

   /**
            * Only used when the type is a nested type or array/sequence of nested types.
            * This is limited to 255 characters.
            * TODO(wjwwood): this 255 character limit was chosen due to this being the limit
            * for DDSI-RTPS based middlewares, which is the most commonly used right now.
            * We lack a ROS 2 specific limit in our design documents, but we should update
            * this and/or link to the design doc when that is available.
            */
   public java.lang.String getNestedTypeNameAsString()
   {
      return getNestedTypeName().toString();
   }
   /**
            * Only used when the type is a nested type or array/sequence of nested types.
            * This is limited to 255 characters.
            * TODO(wjwwood): this 255 character limit was chosen due to this being the limit
            * for DDSI-RTPS based middlewares, which is the most commonly used right now.
            * We lack a ROS 2 specific limit in our design documents, but we should update
            * this and/or link to the design doc when that is available.
            */
   public java.lang.StringBuilder getNestedTypeName()
   {
      return nested_type_name_;
   }


   public static Supplier<FieldTypePubSubType> getPubSubType()
   {
      return FieldTypePubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return FieldTypePubSubType::new;
   }

   @Override
   public boolean epsilonEquals(FieldType other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.type_id_, other.type_id_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.capacity_, other.capacity_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.string_capacity_, other.string_capacity_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.nested_type_name_, other.nested_type_name_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof FieldType)) return false;

      FieldType otherMyClass = (FieldType) other;

      if(this.type_id_ != otherMyClass.type_id_) return false;

      if(this.capacity_ != otherMyClass.capacity_) return false;

      if(this.string_capacity_ != otherMyClass.string_capacity_) return false;

      if (!us.ihmc.idl.IDLTools.equals(this.nested_type_name_, otherMyClass.nested_type_name_)) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("FieldType {");
      builder.append("type_id=");
      builder.append(this.type_id_);      builder.append(", ");
      builder.append("capacity=");
      builder.append(this.capacity_);      builder.append(", ");
      builder.append("string_capacity=");
      builder.append(this.string_capacity_);      builder.append(", ");
      builder.append("nested_type_name=");
      builder.append(this.nested_type_name_);
      builder.append("}");
      return builder.toString();
   }
}

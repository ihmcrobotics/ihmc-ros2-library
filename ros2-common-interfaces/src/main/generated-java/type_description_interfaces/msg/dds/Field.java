package type_description_interfaces.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * Represents a single field in a type.
       */
public class Field extends Packet<Field> implements Settable<Field>, EpsilonComparable<Field>
{
   /**
            * Name of the field.
            */
   public java.lang.StringBuilder name_;
   /**
            * Type of the field, including details about the type like length, nested name, etc.
            */
   public type_description_interfaces.msg.dds.FieldType type_;
   /**
            * Literal default value of the field as a string, as it appeared in the original
            * message description file, whether that be .msg/.srv/.action or .idl.
            */
   public java.lang.StringBuilder default_value_;

   public Field()
   {
      name_ = new java.lang.StringBuilder(255);
      type_ = new type_description_interfaces.msg.dds.FieldType();
      default_value_ = new java.lang.StringBuilder(255);
   }

   public Field(Field other)
   {
      this();
      set(other);
   }

   public void set(Field other)
   {
      name_.setLength(0);
      name_.append(other.name_);

      type_description_interfaces.msg.dds.FieldTypePubSubType.staticCopy(other.type_, type_);
      default_value_.setLength(0);
      default_value_.append(other.default_value_);

   }

   /**
            * Name of the field.
            */
   public void setName(java.lang.String name)
   {
      name_.setLength(0);
      name_.append(name);
   }

   /**
            * Name of the field.
            */
   public java.lang.String getNameAsString()
   {
      return getName().toString();
   }
   /**
            * Name of the field.
            */
   public java.lang.StringBuilder getName()
   {
      return name_;
   }


   /**
            * Type of the field, including details about the type like length, nested name, etc.
            */
   public type_description_interfaces.msg.dds.FieldType getType()
   {
      return type_;
   }

   /**
            * Literal default value of the field as a string, as it appeared in the original
            * message description file, whether that be .msg/.srv/.action or .idl.
            */
   public void setDefaultValue(java.lang.String default_value)
   {
      default_value_.setLength(0);
      default_value_.append(default_value);
   }

   /**
            * Literal default value of the field as a string, as it appeared in the original
            * message description file, whether that be .msg/.srv/.action or .idl.
            */
   public java.lang.String getDefaultValueAsString()
   {
      return getDefaultValue().toString();
   }
   /**
            * Literal default value of the field as a string, as it appeared in the original
            * message description file, whether that be .msg/.srv/.action or .idl.
            */
   public java.lang.StringBuilder getDefaultValue()
   {
      return default_value_;
   }


   public static Supplier<FieldPubSubType> getPubSubType()
   {
      return FieldPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return FieldPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(Field other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.name_, other.name_, epsilon)) return false;

      if (!this.type_.epsilonEquals(other.type_, epsilon)) return false;
      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.default_value_, other.default_value_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof Field)) return false;

      Field otherMyClass = (Field) other;

      if (!us.ihmc.idl.IDLTools.equals(this.name_, otherMyClass.name_)) return false;

      if (!this.type_.equals(otherMyClass.type_)) return false;
      if (!us.ihmc.idl.IDLTools.equals(this.default_value_, otherMyClass.default_value_)) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("Field {");
      builder.append("name=");
      builder.append(this.name_);      builder.append(", ");
      builder.append("type=");
      builder.append(this.type_);      builder.append(", ");
      builder.append("default_value=");
      builder.append(this.default_value_);
      builder.append("}");
      return builder.toString();
   }
}

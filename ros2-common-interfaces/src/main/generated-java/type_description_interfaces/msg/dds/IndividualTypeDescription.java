package type_description_interfaces.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * Represents a single type, without the types it references, if any.
       */
public class IndividualTypeDescription extends Packet<IndividualTypeDescription> implements Settable<IndividualTypeDescription>, EpsilonComparable<IndividualTypeDescription>
{
   /**
            * Name of the type.
            * This is limited to 255 characters.
            * TODO(wjwwood): this 255 character limit was chosen due to this being the limit
            * for DDSI-RTPS based middlewares, which is the most commonly used right now.
            * We lack a ROS 2 specific limit in our design documents, but we should update
            * this and/or link to the design doc when that is available.
            */
   public java.lang.StringBuilder type_name_;
   /**
            * Fields of the type.
            */
   public us.ihmc.idl.IDLSequence.Object<type_description_interfaces.msg.dds.Field>  fields_;

   public IndividualTypeDescription()
   {
      type_name_ = new java.lang.StringBuilder(255);
      fields_ = new us.ihmc.idl.IDLSequence.Object<type_description_interfaces.msg.dds.Field> (100, new type_description_interfaces.msg.dds.FieldPubSubType());

   }

   public IndividualTypeDescription(IndividualTypeDescription other)
   {
      this();
      set(other);
   }

   public void set(IndividualTypeDescription other)
   {
      type_name_.setLength(0);
      type_name_.append(other.type_name_);

      fields_.set(other.fields_);
   }

   /**
            * Name of the type.
            * This is limited to 255 characters.
            * TODO(wjwwood): this 255 character limit was chosen due to this being the limit
            * for DDSI-RTPS based middlewares, which is the most commonly used right now.
            * We lack a ROS 2 specific limit in our design documents, but we should update
            * this and/or link to the design doc when that is available.
            */
   public void setTypeName(java.lang.String type_name)
   {
      type_name_.setLength(0);
      type_name_.append(type_name);
   }

   /**
            * Name of the type.
            * This is limited to 255 characters.
            * TODO(wjwwood): this 255 character limit was chosen due to this being the limit
            * for DDSI-RTPS based middlewares, which is the most commonly used right now.
            * We lack a ROS 2 specific limit in our design documents, but we should update
            * this and/or link to the design doc when that is available.
            */
   public java.lang.String getTypeNameAsString()
   {
      return getTypeName().toString();
   }
   /**
            * Name of the type.
            * This is limited to 255 characters.
            * TODO(wjwwood): this 255 character limit was chosen due to this being the limit
            * for DDSI-RTPS based middlewares, which is the most commonly used right now.
            * We lack a ROS 2 specific limit in our design documents, but we should update
            * this and/or link to the design doc when that is available.
            */
   public java.lang.StringBuilder getTypeName()
   {
      return type_name_;
   }


   /**
            * Fields of the type.
            */
   public us.ihmc.idl.IDLSequence.Object<type_description_interfaces.msg.dds.Field>  getFields()
   {
      return fields_;
   }


   public static Supplier<IndividualTypeDescriptionPubSubType> getPubSubType()
   {
      return IndividualTypeDescriptionPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return IndividualTypeDescriptionPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(IndividualTypeDescription other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.type_name_, other.type_name_, epsilon)) return false;

      if (this.fields_.size() != other.fields_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.fields_.size(); i++)
         {  if (!this.fields_.get(i).epsilonEquals(other.fields_.get(i), epsilon)) return false; }
      }


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof IndividualTypeDescription)) return false;

      IndividualTypeDescription otherMyClass = (IndividualTypeDescription) other;

      if (!us.ihmc.idl.IDLTools.equals(this.type_name_, otherMyClass.type_name_)) return false;

      if (!this.fields_.equals(otherMyClass.fields_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("IndividualTypeDescription {");
      builder.append("type_name=");
      builder.append(this.type_name_);      builder.append(", ");
      builder.append("fields=");
      builder.append(this.fields_);
      builder.append("}");
      return builder.toString();
   }
}

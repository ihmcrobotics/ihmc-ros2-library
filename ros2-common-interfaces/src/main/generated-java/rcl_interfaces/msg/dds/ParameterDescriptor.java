package rcl_interfaces.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * This is the message to communicate a parameter's descriptor.
       * Parameter constraints
       * If any of the following sequences are not empty, then the constraint inside of
       * them apply to this parameter.
       * 
       * FloatingPointRange and IntegerRange are mutually exclusive.
       */
public class ParameterDescriptor extends Packet<ParameterDescriptor> implements Settable<ParameterDescriptor>, EpsilonComparable<ParameterDescriptor>
{
   /**
            * The name of the parameter.
            */
   public java.lang.StringBuilder name_;
   /**
            * Enum values are defined in the `ParameterType.msg` message.
            */
   public byte type_;
   /**
            * Description of the parameter, visible from introspection tools.
            */
   public java.lang.StringBuilder description_;
   /**
            * Plain English description of additional constraints which cannot be expressed
            * with the available constraints, e.g. "only prime numbers".
            * 
            * By convention, this should only be used to clarify constraints which cannot
            * be completely expressed with the parameter constraints below.
            */
   public java.lang.StringBuilder additional_constraints_;
   /**
            * If 'true' then the value cannot change after it has been initialized.
            */
   public boolean read_only_;
   /**
            * If true, the parameter is allowed to change type.
            */
   public boolean dynamic_typing_;
   /**
            * FloatingPointRange consists of a from_value, a to_value, and a step.
            */
   public us.ihmc.idl.IDLSequence.Object<rcl_interfaces.msg.dds.FloatingPointRange>  floating_point_range_;
   /**
            * IntegerRange consists of a from_value, a to_value, and a step.
            */
   public us.ihmc.idl.IDLSequence.Object<rcl_interfaces.msg.dds.IntegerRange>  integer_range_;

   public ParameterDescriptor()
   {
      name_ = new java.lang.StringBuilder(255);
      description_ = new java.lang.StringBuilder(255);
      additional_constraints_ = new java.lang.StringBuilder(255);
      floating_point_range_ = new us.ihmc.idl.IDLSequence.Object<rcl_interfaces.msg.dds.FloatingPointRange> (1, new rcl_interfaces.msg.dds.FloatingPointRangePubSubType());
      integer_range_ = new us.ihmc.idl.IDLSequence.Object<rcl_interfaces.msg.dds.IntegerRange> (1, new rcl_interfaces.msg.dds.IntegerRangePubSubType());

   }

   public ParameterDescriptor(ParameterDescriptor other)
   {
      this();
      set(other);
   }

   public void set(ParameterDescriptor other)
   {
      name_.setLength(0);
      name_.append(other.name_);

      type_ = other.type_;

      description_.setLength(0);
      description_.append(other.description_);

      additional_constraints_.setLength(0);
      additional_constraints_.append(other.additional_constraints_);

      read_only_ = other.read_only_;

      dynamic_typing_ = other.dynamic_typing_;

      floating_point_range_.set(other.floating_point_range_);
      integer_range_.set(other.integer_range_);
   }

   /**
            * The name of the parameter.
            */
   public void setName(java.lang.String name)
   {
      name_.setLength(0);
      name_.append(name);
   }

   /**
            * The name of the parameter.
            */
   public java.lang.String getNameAsString()
   {
      return getName().toString();
   }
   /**
            * The name of the parameter.
            */
   public java.lang.StringBuilder getName()
   {
      return name_;
   }

   /**
            * Enum values are defined in the `ParameterType.msg` message.
            */
   public void setType(byte type)
   {
      type_ = type;
   }
   /**
            * Enum values are defined in the `ParameterType.msg` message.
            */
   public byte getType()
   {
      return type_;
   }

   /**
            * Description of the parameter, visible from introspection tools.
            */
   public void setDescription(java.lang.String description)
   {
      description_.setLength(0);
      description_.append(description);
   }

   /**
            * Description of the parameter, visible from introspection tools.
            */
   public java.lang.String getDescriptionAsString()
   {
      return getDescription().toString();
   }
   /**
            * Description of the parameter, visible from introspection tools.
            */
   public java.lang.StringBuilder getDescription()
   {
      return description_;
   }

   /**
            * Plain English description of additional constraints which cannot be expressed
            * with the available constraints, e.g. "only prime numbers".
            * 
            * By convention, this should only be used to clarify constraints which cannot
            * be completely expressed with the parameter constraints below.
            */
   public void setAdditionalConstraints(java.lang.String additional_constraints)
   {
      additional_constraints_.setLength(0);
      additional_constraints_.append(additional_constraints);
   }

   /**
            * Plain English description of additional constraints which cannot be expressed
            * with the available constraints, e.g. "only prime numbers".
            * 
            * By convention, this should only be used to clarify constraints which cannot
            * be completely expressed with the parameter constraints below.
            */
   public java.lang.String getAdditionalConstraintsAsString()
   {
      return getAdditionalConstraints().toString();
   }
   /**
            * Plain English description of additional constraints which cannot be expressed
            * with the available constraints, e.g. "only prime numbers".
            * 
            * By convention, this should only be used to clarify constraints which cannot
            * be completely expressed with the parameter constraints below.
            */
   public java.lang.StringBuilder getAdditionalConstraints()
   {
      return additional_constraints_;
   }

   /**
            * If 'true' then the value cannot change after it has been initialized.
            */
   public void setReadOnly(boolean read_only)
   {
      read_only_ = read_only;
   }
   /**
            * If 'true' then the value cannot change after it has been initialized.
            */
   public boolean getReadOnly()
   {
      return read_only_;
   }

   /**
            * If true, the parameter is allowed to change type.
            */
   public void setDynamicTyping(boolean dynamic_typing)
   {
      dynamic_typing_ = dynamic_typing;
   }
   /**
            * If true, the parameter is allowed to change type.
            */
   public boolean getDynamicTyping()
   {
      return dynamic_typing_;
   }


   /**
            * FloatingPointRange consists of a from_value, a to_value, and a step.
            */
   public us.ihmc.idl.IDLSequence.Object<rcl_interfaces.msg.dds.FloatingPointRange>  getFloatingPointRange()
   {
      return floating_point_range_;
   }


   /**
            * IntegerRange consists of a from_value, a to_value, and a step.
            */
   public us.ihmc.idl.IDLSequence.Object<rcl_interfaces.msg.dds.IntegerRange>  getIntegerRange()
   {
      return integer_range_;
   }


   public static Supplier<ParameterDescriptorPubSubType> getPubSubType()
   {
      return ParameterDescriptorPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return ParameterDescriptorPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(ParameterDescriptor other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.name_, other.name_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.type_, other.type_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.description_, other.description_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.additional_constraints_, other.additional_constraints_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.read_only_, other.read_only_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.dynamic_typing_, other.dynamic_typing_, epsilon)) return false;

      if (this.floating_point_range_.size() != other.floating_point_range_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.floating_point_range_.size(); i++)
         {  if (!this.floating_point_range_.get(i).epsilonEquals(other.floating_point_range_.get(i), epsilon)) return false; }
      }

      if (this.integer_range_.size() != other.integer_range_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.integer_range_.size(); i++)
         {  if (!this.integer_range_.get(i).epsilonEquals(other.integer_range_.get(i), epsilon)) return false; }
      }


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof ParameterDescriptor)) return false;

      ParameterDescriptor otherMyClass = (ParameterDescriptor) other;

      if (!us.ihmc.idl.IDLTools.equals(this.name_, otherMyClass.name_)) return false;

      if(this.type_ != otherMyClass.type_) return false;

      if (!us.ihmc.idl.IDLTools.equals(this.description_, otherMyClass.description_)) return false;

      if (!us.ihmc.idl.IDLTools.equals(this.additional_constraints_, otherMyClass.additional_constraints_)) return false;

      if(this.read_only_ != otherMyClass.read_only_) return false;

      if(this.dynamic_typing_ != otherMyClass.dynamic_typing_) return false;

      if (!this.floating_point_range_.equals(otherMyClass.floating_point_range_)) return false;
      if (!this.integer_range_.equals(otherMyClass.integer_range_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("ParameterDescriptor {");
      builder.append("name=");
      builder.append(this.name_);      builder.append(", ");
      builder.append("type=");
      builder.append(this.type_);      builder.append(", ");
      builder.append("description=");
      builder.append(this.description_);      builder.append(", ");
      builder.append("additional_constraints=");
      builder.append(this.additional_constraints_);      builder.append(", ");
      builder.append("read_only=");
      builder.append(this.read_only_);      builder.append(", ");
      builder.append("dynamic_typing=");
      builder.append(this.dynamic_typing_);      builder.append(", ");
      builder.append("floating_point_range=");
      builder.append(this.floating_point_range_);      builder.append(", ");
      builder.append("integer_range=");
      builder.append(this.integer_range_);
      builder.append("}");
      return builder.toString();
   }
}

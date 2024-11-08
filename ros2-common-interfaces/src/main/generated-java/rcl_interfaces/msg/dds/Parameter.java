package rcl_interfaces.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * This is the message to communicate a parameter. It is an open struct with an enum in
       * the descriptor to select which value is active.
       */
public class Parameter extends Packet<Parameter> implements Settable<Parameter>, EpsilonComparable<Parameter>
{
   /**
            * The full name of the parameter.
            */
   public java.lang.StringBuilder name_;
   /**
            * The parameter's value which can be one of several types, see
            * `ParameterValue.msg` and `ParameterType.msg`.
            */
   public rcl_interfaces.msg.dds.ParameterValue value_;

   public Parameter()
   {
      name_ = new java.lang.StringBuilder(255);
      value_ = new rcl_interfaces.msg.dds.ParameterValue();
   }

   public Parameter(Parameter other)
   {
      this();
      set(other);
   }

   public void set(Parameter other)
   {
      name_.setLength(0);
      name_.append(other.name_);

      rcl_interfaces.msg.dds.ParameterValuePubSubType.staticCopy(other.value_, value_);
   }

   /**
            * The full name of the parameter.
            */
   public void setName(java.lang.String name)
   {
      name_.setLength(0);
      name_.append(name);
   }

   /**
            * The full name of the parameter.
            */
   public java.lang.String getNameAsString()
   {
      return getName().toString();
   }
   /**
            * The full name of the parameter.
            */
   public java.lang.StringBuilder getName()
   {
      return name_;
   }


   /**
            * The parameter's value which can be one of several types, see
            * `ParameterValue.msg` and `ParameterType.msg`.
            */
   public rcl_interfaces.msg.dds.ParameterValue getValue()
   {
      return value_;
   }


   public static Supplier<ParameterPubSubType> getPubSubType()
   {
      return ParameterPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return ParameterPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(Parameter other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.name_, other.name_, epsilon)) return false;

      if (!this.value_.epsilonEquals(other.value_, epsilon)) return false;

      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof Parameter)) return false;

      Parameter otherMyClass = (Parameter) other;

      if (!us.ihmc.idl.IDLTools.equals(this.name_, otherMyClass.name_)) return false;

      if (!this.value_.equals(otherMyClass.value_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("Parameter {");
      builder.append("name=");
      builder.append(this.name_);      builder.append(", ");
      builder.append("value=");
      builder.append(this.value_);
      builder.append("}");
      return builder.toString();
   }
}

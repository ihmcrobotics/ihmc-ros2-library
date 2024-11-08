package rcl_interfaces.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * Represents bounds and a step value for an integer typed parameter.
       */
public class IntegerRange extends Packet<IntegerRange> implements Settable<IntegerRange>, EpsilonComparable<IntegerRange>
{
   /**
            * Start value for valid values, inclusive.
            */
   public long from_value_;
   /**
            * End value for valid values, inclusive.
            */
   public long to_value_;
   /**
            * Size of valid steps between the from and to bound.
            * 
            * A step value of zero implies a continuous range of values. Ideally, the step
            * would be less than or equal to the distance between the bounds, as well as an
            * even multiple of the distance between the bounds, but neither are required.
            * 
            * If the absolute value of the step is larger than or equal to the distance
            * between the two bounds, then the bounds will be the only valid values. e.g. if
            * the range is defined as {from_value: 1, to_value: 2, step: 5} then the valid
            * values will be 1 and 2.
            * 
            * If the step is less than the distance between the bounds, but the distance is
            * not a multiple of the step, then the "to" bound will always be a valid value,
            * e.g. if the range is defined as {from_value: 2, to_value: 5, step: 2} then
            * the valid values will be 2, 4, and 5.
            */
   public long step_;

   public IntegerRange()
   {
   }

   public IntegerRange(IntegerRange other)
   {
      this();
      set(other);
   }

   public void set(IntegerRange other)
   {
      from_value_ = other.from_value_;

      to_value_ = other.to_value_;

      step_ = other.step_;

   }

   /**
            * Start value for valid values, inclusive.
            */
   public void setFromValue(long from_value)
   {
      from_value_ = from_value;
   }
   /**
            * Start value for valid values, inclusive.
            */
   public long getFromValue()
   {
      return from_value_;
   }

   /**
            * End value for valid values, inclusive.
            */
   public void setToValue(long to_value)
   {
      to_value_ = to_value;
   }
   /**
            * End value for valid values, inclusive.
            */
   public long getToValue()
   {
      return to_value_;
   }

   /**
            * Size of valid steps between the from and to bound.
            * 
            * A step value of zero implies a continuous range of values. Ideally, the step
            * would be less than or equal to the distance between the bounds, as well as an
            * even multiple of the distance between the bounds, but neither are required.
            * 
            * If the absolute value of the step is larger than or equal to the distance
            * between the two bounds, then the bounds will be the only valid values. e.g. if
            * the range is defined as {from_value: 1, to_value: 2, step: 5} then the valid
            * values will be 1 and 2.
            * 
            * If the step is less than the distance between the bounds, but the distance is
            * not a multiple of the step, then the "to" bound will always be a valid value,
            * e.g. if the range is defined as {from_value: 2, to_value: 5, step: 2} then
            * the valid values will be 2, 4, and 5.
            */
   public void setStep(long step)
   {
      step_ = step;
   }
   /**
            * Size of valid steps between the from and to bound.
            * 
            * A step value of zero implies a continuous range of values. Ideally, the step
            * would be less than or equal to the distance between the bounds, as well as an
            * even multiple of the distance between the bounds, but neither are required.
            * 
            * If the absolute value of the step is larger than or equal to the distance
            * between the two bounds, then the bounds will be the only valid values. e.g. if
            * the range is defined as {from_value: 1, to_value: 2, step: 5} then the valid
            * values will be 1 and 2.
            * 
            * If the step is less than the distance between the bounds, but the distance is
            * not a multiple of the step, then the "to" bound will always be a valid value,
            * e.g. if the range is defined as {from_value: 2, to_value: 5, step: 2} then
            * the valid values will be 2, 4, and 5.
            */
   public long getStep()
   {
      return step_;
   }


   public static Supplier<IntegerRangePubSubType> getPubSubType()
   {
      return IntegerRangePubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return IntegerRangePubSubType::new;
   }

   @Override
   public boolean epsilonEquals(IntegerRange other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.from_value_, other.from_value_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.to_value_, other.to_value_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.step_, other.step_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof IntegerRange)) return false;

      IntegerRange otherMyClass = (IntegerRange) other;

      if(this.from_value_ != otherMyClass.from_value_) return false;

      if(this.to_value_ != otherMyClass.to_value_) return false;

      if(this.step_ != otherMyClass.step_) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("IntegerRange {");
      builder.append("from_value=");
      builder.append(this.from_value_);      builder.append(", ");
      builder.append("to_value=");
      builder.append(this.to_value_);      builder.append(", ");
      builder.append("step=");
      builder.append(this.step_);
      builder.append("}");
      return builder.toString();
   }
}

package std_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Definition of the class "Float64" defined in Float64_.idl.
 *
 * This file was automatically generated from Float64_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit Float64_.idl instead.
 */
public class Float64 implements Settable<Float64>, EpsilonComparable<Float64>
{
   private double data_;

   public Float64()
   {
   }

   public Float64(Float64 other)
   {
      set(other);
   }

   public void set(Float64 other)
   {
      data_ = other.data_;
   }

   public double getData()
   {
      return data_;
   }

   public void setData(double data)
   {
      data_ = data;
   }

   @Override
   public boolean epsilonEquals(Float64 other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.data_, other.data_, epsilon))
         return false;

      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;
      if (!(other instanceof Float64))
         return false;

      Float64 otherMyClass = (Float64) other;

      if (this.data_ != otherMyClass.data_)
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("Float64 {");
      builder.append("data=");
      builder.append(this.data_);

      builder.append("}");
      return builder.toString();
   }
}
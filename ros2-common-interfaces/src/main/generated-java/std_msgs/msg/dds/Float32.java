package std_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

public class Float32 extends Packet<Float32> implements Settable<Float32>, EpsilonComparable<Float32>
{
   public float data_;

   public Float32()
   {
   }

   public Float32(Float32 other)
   {
      set(other);
   }

   public void set(Float32 other)
   {
      data_ = other.data_;
   }

   public float getData()
   {
      return data_;
   }

   public void setData(float data)
   {
      data_ = data;
   }

   @Override
   public boolean epsilonEquals(Float32 other, double epsilon)
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
      if (!(other instanceof Float32))
         return false;

      Float32 otherMyClass = (Float32) other;

      if (this.data_ != otherMyClass.data_)
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("Float32 {");
      builder.append("data=");
      builder.append(this.data_);

      builder.append("}");
      return builder.toString();
   }
}

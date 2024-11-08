package std_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * This was originally provided as an example message.
       * It is deprecated as of Foxy
       * It is recommended to create your own semantically meaningful message.
       * However if you would like to continue using this please use the equivalent in example_msgs.
       */
public class Float64 extends Packet<Float64> implements Settable<Float64>, EpsilonComparable<Float64>
{
   public double data_;

   public Float64()
   {
   }

   public Float64(Float64 other)
   {
      this();
      set(other);
   }

   public void set(Float64 other)
   {
      data_ = other.data_;

   }

   public void setData(double data)
   {
      data_ = data;
   }
   public double getData()
   {
      return data_;
   }


   public static Supplier<Float64PubSubType> getPubSubType()
   {
      return Float64PubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return Float64PubSubType::new;
   }

   @Override
   public boolean epsilonEquals(Float64 other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.data_, other.data_, epsilon)) return false;

      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof Float64)) return false;

      Float64 otherMyClass = (Float64) other;

      if(this.data_ != otherMyClass.data_) return false;


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

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
public class Int64 extends Packet<Int64> implements Settable<Int64>, EpsilonComparable<Int64>
{
   public long data_;

   public Int64()
   {
   }

   public Int64(Int64 other)
   {
      this();
      set(other);
   }

   public void set(Int64 other)
   {
      data_ = other.data_;

   }

   public void setData(long data)
   {
      data_ = data;
   }
   public long getData()
   {
      return data_;
   }


   public static Supplier<Int64PubSubType> getPubSubType()
   {
      return Int64PubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return Int64PubSubType::new;
   }

   @Override
   public boolean epsilonEquals(Int64 other, double epsilon)
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
      if(!(other instanceof Int64)) return false;

      Int64 otherMyClass = (Int64) other;

      if(this.data_ != otherMyClass.data_) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("Int64 {");
      builder.append("data=");
      builder.append(this.data_);
      builder.append("}");
      return builder.toString();
   }
}

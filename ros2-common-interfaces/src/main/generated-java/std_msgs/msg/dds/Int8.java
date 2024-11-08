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
public class Int8 extends Packet<Int8> implements Settable<Int8>, EpsilonComparable<Int8>
{
   public byte data_;

   public Int8()
   {
   }

   public Int8(Int8 other)
   {
      this();
      set(other);
   }

   public void set(Int8 other)
   {
      data_ = other.data_;

   }

   public void setData(byte data)
   {
      data_ = data;
   }
   public byte getData()
   {
      return data_;
   }


   public static Supplier<Int8PubSubType> getPubSubType()
   {
      return Int8PubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return Int8PubSubType::new;
   }

   @Override
   public boolean epsilonEquals(Int8 other, double epsilon)
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
      if(!(other instanceof Int8)) return false;

      Int8 otherMyClass = (Int8) other;

      if(this.data_ != otherMyClass.data_) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("Int8 {");
      builder.append("data=");
      builder.append(this.data_);
      builder.append("}");
      return builder.toString();
   }
}

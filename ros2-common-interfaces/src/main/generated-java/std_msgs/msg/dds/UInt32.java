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
public class UInt32 extends Packet<UInt32> implements Settable<UInt32>, EpsilonComparable<UInt32>
{
   public long data_;

   public UInt32()
   {
   }

   public UInt32(UInt32 other)
   {
      this();
      set(other);
   }

   public void set(UInt32 other)
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


   public static Supplier<UInt32PubSubType> getPubSubType()
   {
      return UInt32PubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return UInt32PubSubType::new;
   }

   @Override
   public boolean epsilonEquals(UInt32 other, double epsilon)
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
      if(!(other instanceof UInt32)) return false;

      UInt32 otherMyClass = (UInt32) other;

      if(this.data_ != otherMyClass.data_) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("UInt32 {");
      builder.append("data=");
      builder.append(this.data_);
      builder.append("}");
      return builder.toString();
   }
}

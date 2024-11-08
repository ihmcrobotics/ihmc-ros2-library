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
       * Please look at the MultiArrayLayout message definition for
       * documentation on all multiarrays.
       */
public class ByteMultiArray extends Packet<ByteMultiArray> implements Settable<ByteMultiArray>, EpsilonComparable<ByteMultiArray>
{
   /**
            * specification of data layout
            */
   public std_msgs.msg.dds.MultiArrayLayout layout_;
   /**
            * array of data
            */
   public us.ihmc.idl.IDLSequence.Byte  data_;

   public ByteMultiArray()
   {
      layout_ = new std_msgs.msg.dds.MultiArrayLayout();
      data_ = new us.ihmc.idl.IDLSequence.Byte (100, "type_9");

   }

   public ByteMultiArray(ByteMultiArray other)
   {
      this();
      set(other);
   }

   public void set(ByteMultiArray other)
   {
      std_msgs.msg.dds.MultiArrayLayoutPubSubType.staticCopy(other.layout_, layout_);
      data_.set(other.data_);
   }


   /**
            * specification of data layout
            */
   public std_msgs.msg.dds.MultiArrayLayout getLayout()
   {
      return layout_;
   }


   /**
            * array of data
            */
   public us.ihmc.idl.IDLSequence.Byte  getData()
   {
      return data_;
   }


   public static Supplier<ByteMultiArrayPubSubType> getPubSubType()
   {
      return ByteMultiArrayPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return ByteMultiArrayPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(ByteMultiArray other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!this.layout_.epsilonEquals(other.layout_, epsilon)) return false;
      if (!us.ihmc.idl.IDLTools.epsilonEqualsByteSequence(this.data_, other.data_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof ByteMultiArray)) return false;

      ByteMultiArray otherMyClass = (ByteMultiArray) other;

      if (!this.layout_.equals(otherMyClass.layout_)) return false;
      if (!this.data_.equals(otherMyClass.data_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("ByteMultiArray {");
      builder.append("layout=");
      builder.append(this.layout_);      builder.append(", ");
      builder.append("data=");
      builder.append(this.data_);
      builder.append("}");
      return builder.toString();
   }
}

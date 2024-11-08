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
public class UInt8MultiArray extends Packet<UInt8MultiArray> implements Settable<UInt8MultiArray>, EpsilonComparable<UInt8MultiArray>
{
   /**
            * specification of data layout
            */
   public std_msgs.msg.dds.MultiArrayLayout layout_;
   /**
            * array of data
            */
   public us.ihmc.idl.IDLSequence.Byte  data_;

   public UInt8MultiArray()
   {
      layout_ = new std_msgs.msg.dds.MultiArrayLayout();
      data_ = new us.ihmc.idl.IDLSequence.Byte (100, "type_9");

   }

   public UInt8MultiArray(UInt8MultiArray other)
   {
      this();
      set(other);
   }

   public void set(UInt8MultiArray other)
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


   public static Supplier<UInt8MultiArrayPubSubType> getPubSubType()
   {
      return UInt8MultiArrayPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return UInt8MultiArrayPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(UInt8MultiArray other, double epsilon)
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
      if(!(other instanceof UInt8MultiArray)) return false;

      UInt8MultiArray otherMyClass = (UInt8MultiArray) other;

      if (!this.layout_.equals(otherMyClass.layout_)) return false;
      if (!this.data_.equals(otherMyClass.data_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("UInt8MultiArray {");
      builder.append("layout=");
      builder.append(this.layout_);      builder.append(", ");
      builder.append("data=");
      builder.append(this.data_);
      builder.append("}");
      return builder.toString();
   }
}

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
public class UInt32MultiArray extends Packet<UInt32MultiArray> implements Settable<UInt32MultiArray>, EpsilonComparable<UInt32MultiArray>
{
   /**
            * specification of data layout
            */
   public std_msgs.msg.dds.MultiArrayLayout layout_;
   /**
            * array of data
            */
   public us.ihmc.idl.IDLSequence.Long  data_;

   public UInt32MultiArray()
   {
      layout_ = new std_msgs.msg.dds.MultiArrayLayout();
      data_ = new us.ihmc.idl.IDLSequence.Long (100, "type_4");

   }

   public UInt32MultiArray(UInt32MultiArray other)
   {
      this();
      set(other);
   }

   public void set(UInt32MultiArray other)
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
   public us.ihmc.idl.IDLSequence.Long  getData()
   {
      return data_;
   }


   public static Supplier<UInt32MultiArrayPubSubType> getPubSubType()
   {
      return UInt32MultiArrayPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return UInt32MultiArrayPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(UInt32MultiArray other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!this.layout_.epsilonEquals(other.layout_, epsilon)) return false;
      if (!us.ihmc.idl.IDLTools.epsilonEqualsLongSequence(this.data_, other.data_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof UInt32MultiArray)) return false;

      UInt32MultiArray otherMyClass = (UInt32MultiArray) other;

      if (!this.layout_.equals(otherMyClass.layout_)) return false;
      if (!this.data_.equals(otherMyClass.data_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("UInt32MultiArray {");
      builder.append("layout=");
      builder.append(this.layout_);      builder.append(", ");
      builder.append("data=");
      builder.append(this.data_);
      builder.append("}");
      return builder.toString();
   }
}

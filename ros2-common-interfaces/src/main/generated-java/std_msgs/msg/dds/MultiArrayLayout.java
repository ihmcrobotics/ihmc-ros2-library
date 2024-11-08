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
       * The multiarray declares a generic multi-dimensional array of a
       * particular data type.  Dimensions are ordered from outer most
       * to inner most.
       * 
       * Accessors should ALWAYS be written in terms of dimension stride
       * and specified outer-most dimension first.
       * 
       * multiarray(i,j,k) = data[data_offset + dim_stride[1]*i + dim_stride[2]*j + k]
       * 
       * A standard, 3-channel 640x480 image with interleaved color channels
       * would be specified as:
       * 
       * dim[0].label  = "height"
       * dim[0].size   = 480
       * dim[0].stride = 3*640*480 = 921600  (note dim[0] stride is just size of image)
       * dim[1].label  = "width"
       * dim[1].size   = 640
       * dim[1].stride = 3*640 = 1920
       * dim[2].label  = "channel"
       * dim[2].size   = 3
       * dim[2].stride = 3
       * 
       * multiarray(i,j,k) refers to the ith row, jth column, and kth channel.
       */
public class MultiArrayLayout extends Packet<MultiArrayLayout> implements Settable<MultiArrayLayout>, EpsilonComparable<MultiArrayLayout>
{
   /**
            * Array of dimension properties
            */
   public us.ihmc.idl.IDLSequence.Object<std_msgs.msg.dds.MultiArrayDimension>  dim_;
   /**
            * padding bytes at front of data
            */
   public long data_offset_;

   public MultiArrayLayout()
   {
      dim_ = new us.ihmc.idl.IDLSequence.Object<std_msgs.msg.dds.MultiArrayDimension> (100, new std_msgs.msg.dds.MultiArrayDimensionPubSubType());

   }

   public MultiArrayLayout(MultiArrayLayout other)
   {
      this();
      set(other);
   }

   public void set(MultiArrayLayout other)
   {
      dim_.set(other.dim_);
      data_offset_ = other.data_offset_;

   }


   /**
            * Array of dimension properties
            */
   public us.ihmc.idl.IDLSequence.Object<std_msgs.msg.dds.MultiArrayDimension>  getDim()
   {
      return dim_;
   }

   /**
            * padding bytes at front of data
            */
   public void setDataOffset(long data_offset)
   {
      data_offset_ = data_offset;
   }
   /**
            * padding bytes at front of data
            */
   public long getDataOffset()
   {
      return data_offset_;
   }


   public static Supplier<MultiArrayLayoutPubSubType> getPubSubType()
   {
      return MultiArrayLayoutPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return MultiArrayLayoutPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(MultiArrayLayout other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (this.dim_.size() != other.dim_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.dim_.size(); i++)
         {  if (!this.dim_.get(i).epsilonEquals(other.dim_.get(i), epsilon)) return false; }
      }

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.data_offset_, other.data_offset_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof MultiArrayLayout)) return false;

      MultiArrayLayout otherMyClass = (MultiArrayLayout) other;

      if (!this.dim_.equals(otherMyClass.dim_)) return false;
      if(this.data_offset_ != otherMyClass.data_offset_) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("MultiArrayLayout {");
      builder.append("dim=");
      builder.append(this.dim_);      builder.append(", ");
      builder.append("data_offset=");
      builder.append(this.data_offset_);
      builder.append("}");
      return builder.toString();
   }
}

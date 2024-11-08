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
public class MultiArrayDimension extends Packet<MultiArrayDimension> implements Settable<MultiArrayDimension>, EpsilonComparable<MultiArrayDimension>
{
   /**
            * label of given dimension
            */
   public java.lang.StringBuilder label_;
   /**
            * size of given dimension (in type units)
            */
   public long size_;
   /**
            * stride of given dimension
            */
   public long stride_;

   public MultiArrayDimension()
   {
      label_ = new java.lang.StringBuilder(255);
   }

   public MultiArrayDimension(MultiArrayDimension other)
   {
      this();
      set(other);
   }

   public void set(MultiArrayDimension other)
   {
      label_.setLength(0);
      label_.append(other.label_);

      size_ = other.size_;

      stride_ = other.stride_;

   }

   /**
            * label of given dimension
            */
   public void setLabel(java.lang.String label)
   {
      label_.setLength(0);
      label_.append(label);
   }

   /**
            * label of given dimension
            */
   public java.lang.String getLabelAsString()
   {
      return getLabel().toString();
   }
   /**
            * label of given dimension
            */
   public java.lang.StringBuilder getLabel()
   {
      return label_;
   }

   /**
            * size of given dimension (in type units)
            */
   public void setSize(long size)
   {
      size_ = size;
   }
   /**
            * size of given dimension (in type units)
            */
   public long getSize()
   {
      return size_;
   }

   /**
            * stride of given dimension
            */
   public void setStride(long stride)
   {
      stride_ = stride;
   }
   /**
            * stride of given dimension
            */
   public long getStride()
   {
      return stride_;
   }


   public static Supplier<MultiArrayDimensionPubSubType> getPubSubType()
   {
      return MultiArrayDimensionPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return MultiArrayDimensionPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(MultiArrayDimension other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.label_, other.label_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.size_, other.size_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.stride_, other.stride_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof MultiArrayDimension)) return false;

      MultiArrayDimension otherMyClass = (MultiArrayDimension) other;

      if (!us.ihmc.idl.IDLTools.equals(this.label_, otherMyClass.label_)) return false;

      if(this.size_ != otherMyClass.size_) return false;

      if(this.stride_ != otherMyClass.stride_) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("MultiArrayDimension {");
      builder.append("label=");
      builder.append(this.label_);      builder.append(", ");
      builder.append("size=");
      builder.append(this.size_);      builder.append(", ");
      builder.append("stride=");
      builder.append(this.stride_);
      builder.append("}");
      return builder.toString();
   }
}

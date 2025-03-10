package sensor_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * This message contains a compressed image.
       * Header frame_id should be optical frame of camera
       * origin of frame should be optical center of cameara
       * +x should point to the right in the image
       * +y should point down in the image
       * +z should point into to plane of the image
       * Acceptable values:
       * jpeg, png, tiff
       */
public class CompressedImage extends Packet<CompressedImage> implements Settable<CompressedImage>, EpsilonComparable<CompressedImage>
{
   /**
            * Header timestamp should be acquisition time of image
            */
   public std_msgs.msg.dds.Header header_;
   /**
            * Specifies the format of the data
            */
   public java.lang.StringBuilder format_;
   /**
            * Compressed image buffer
            */
   public us.ihmc.idl.IDLSequence.Byte  data_;

   public CompressedImage()
   {
      header_ = new std_msgs.msg.dds.Header();
      format_ = new java.lang.StringBuilder(255);
      data_ = new us.ihmc.idl.IDLSequence.Byte (3000000, "type_9");

   }

   public CompressedImage(CompressedImage other)
   {
      this();
      set(other);
   }

   public void set(CompressedImage other)
   {
      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
      format_.setLength(0);
      format_.append(other.format_);

      data_.set(other.data_);
   }


   /**
            * Header timestamp should be acquisition time of image
            */
   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }

   /**
            * Specifies the format of the data
            */
   public void setFormat(java.lang.String format)
   {
      format_.setLength(0);
      format_.append(format);
   }

   /**
            * Specifies the format of the data
            */
   public java.lang.String getFormatAsString()
   {
      return getFormat().toString();
   }
   /**
            * Specifies the format of the data
            */
   public java.lang.StringBuilder getFormat()
   {
      return format_;
   }


   /**
            * Compressed image buffer
            */
   public us.ihmc.idl.IDLSequence.Byte  getData()
   {
      return data_;
   }


   public static Supplier<CompressedImagePubSubType> getPubSubType()
   {
      return CompressedImagePubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return CompressedImagePubSubType::new;
   }

   @Override
   public boolean epsilonEquals(CompressedImage other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!this.header_.epsilonEquals(other.header_, epsilon)) return false;
      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.format_, other.format_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsByteSequence(this.data_, other.data_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof CompressedImage)) return false;

      CompressedImage otherMyClass = (CompressedImage) other;

      if (!this.header_.equals(otherMyClass.header_)) return false;
      if (!us.ihmc.idl.IDLTools.equals(this.format_, otherMyClass.format_)) return false;

      if (!this.data_.equals(otherMyClass.data_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("CompressedImage {");
      builder.append("header=");
      builder.append(this.header_);      builder.append(", ");
      builder.append("format=");
      builder.append(this.format_);      builder.append(", ");
      builder.append("data=");
      builder.append(this.data_);
      builder.append("}");
      return builder.toString();
   }
}

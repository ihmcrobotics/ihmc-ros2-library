package sensor_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

public class PointField extends Packet<PointField> implements Settable<PointField>, EpsilonComparable<PointField>
{
   /**
          * This message holds the description of one point entry in the
          * PointCloud2 message format.
          */
   public static final byte INT8 = (byte) 1;
   public static final byte UINT8 = (byte) 2;
   public static final byte INT16 = (byte) 3;
   public static final byte UINT16 = (byte) 4;
   public static final byte INT32 = (byte) 5;
   public static final byte UINT32 = (byte) 6;
   public static final byte FLOAT32 = (byte) 7;
   public static final byte FLOAT64 = (byte) 8;
   /**
            * Common PointField names are x, y, z, intensity, rgb, rgba
            * Name of field
            */
   public java.lang.StringBuilder name_;
   /**
            * Offset from start of point struct
            */
   public long offset_;
   /**
            * Datatype enumeration, see above
            */
   public byte datatype_;
   /**
            * How many elements in the field
            */
   public long count_;

   public PointField()
   {
      name_ = new java.lang.StringBuilder(255);
   }

   public PointField(PointField other)
   {
      this();
      set(other);
   }

   public void set(PointField other)
   {
      name_.setLength(0);
      name_.append(other.name_);

      offset_ = other.offset_;

      datatype_ = other.datatype_;

      count_ = other.count_;

   }

   /**
            * Common PointField names are x, y, z, intensity, rgb, rgba
            * Name of field
            */
   public void setName(java.lang.String name)
   {
      name_.setLength(0);
      name_.append(name);
   }

   /**
            * Common PointField names are x, y, z, intensity, rgb, rgba
            * Name of field
            */
   public java.lang.String getNameAsString()
   {
      return getName().toString();
   }
   /**
            * Common PointField names are x, y, z, intensity, rgb, rgba
            * Name of field
            */
   public java.lang.StringBuilder getName()
   {
      return name_;
   }

   /**
            * Offset from start of point struct
            */
   public void setOffset(long offset)
   {
      offset_ = offset;
   }
   /**
            * Offset from start of point struct
            */
   public long getOffset()
   {
      return offset_;
   }

   /**
            * Datatype enumeration, see above
            */
   public void setDatatype(byte datatype)
   {
      datatype_ = datatype;
   }
   /**
            * Datatype enumeration, see above
            */
   public byte getDatatype()
   {
      return datatype_;
   }

   /**
            * How many elements in the field
            */
   public void setCount(long count)
   {
      count_ = count;
   }
   /**
            * How many elements in the field
            */
   public long getCount()
   {
      return count_;
   }


   public static Supplier<PointFieldPubSubType> getPubSubType()
   {
      return PointFieldPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return PointFieldPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(PointField other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.name_, other.name_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.offset_, other.offset_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.datatype_, other.datatype_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.count_, other.count_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof PointField)) return false;

      PointField otherMyClass = (PointField) other;

      if (!us.ihmc.idl.IDLTools.equals(this.name_, otherMyClass.name_)) return false;

      if(this.offset_ != otherMyClass.offset_) return false;

      if(this.datatype_ != otherMyClass.datatype_) return false;

      if(this.count_ != otherMyClass.count_) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("PointField {");
      builder.append("name=");
      builder.append(this.name_);      builder.append(", ");
      builder.append("offset=");
      builder.append(this.offset_);      builder.append(", ");
      builder.append("datatype=");
      builder.append(this.datatype_);      builder.append(", ");
      builder.append("count=");
      builder.append(this.count_);
      builder.append("}");
      return builder.toString();
   }
}

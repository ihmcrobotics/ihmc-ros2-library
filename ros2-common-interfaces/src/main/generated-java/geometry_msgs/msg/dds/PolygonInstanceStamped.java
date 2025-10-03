package geometry_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * This represents a Polygon with reference coordinate frame and timestamp
       * It includes a unique identification field for disambiguating multiple instances
       */
public class PolygonInstanceStamped extends Packet<PolygonInstanceStamped> implements Settable<PolygonInstanceStamped>, EpsilonComparable<PolygonInstanceStamped>
{
   public std_msgs.msg.dds.Header header_;
   public geometry_msgs.msg.dds.PolygonInstance polygon_;

   public PolygonInstanceStamped()
   {
      header_ = new std_msgs.msg.dds.Header();
      polygon_ = new geometry_msgs.msg.dds.PolygonInstance();
   }

   public PolygonInstanceStamped(PolygonInstanceStamped other)
   {
      this();
      set(other);
   }

   public void set(PolygonInstanceStamped other)
   {
      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
      geometry_msgs.msg.dds.PolygonInstancePubSubType.staticCopy(other.polygon_, polygon_);
   }


   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }


   public geometry_msgs.msg.dds.PolygonInstance getPolygon()
   {
      return polygon_;
   }


   public static Supplier<PolygonInstanceStampedPubSubType> getPubSubType()
   {
      return PolygonInstanceStampedPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return PolygonInstanceStampedPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(PolygonInstanceStamped other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!this.header_.epsilonEquals(other.header_, epsilon)) return false;
      if (!this.polygon_.epsilonEquals(other.polygon_, epsilon)) return false;

      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof PolygonInstanceStamped)) return false;

      PolygonInstanceStamped otherMyClass = (PolygonInstanceStamped) other;

      if (!this.header_.equals(otherMyClass.header_)) return false;
      if (!this.polygon_.equals(otherMyClass.polygon_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("PolygonInstanceStamped {");
      builder.append("header=");
      builder.append(this.header_);      builder.append(", ");
      builder.append("polygon=");
      builder.append(this.polygon_);
      builder.append("}");
      return builder.toString();
   }
}

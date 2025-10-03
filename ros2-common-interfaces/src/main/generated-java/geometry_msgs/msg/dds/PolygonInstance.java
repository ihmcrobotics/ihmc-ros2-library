package geometry_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * A specification of a polygon where the first and last points are assumed to be connected
       * It includes a unique identification field for disambiguating multiple instances
       */
public class PolygonInstance extends Packet<PolygonInstance> implements Settable<PolygonInstance>, EpsilonComparable<PolygonInstance>
{
   public geometry_msgs.msg.dds.Polygon polygon_;
   public long id_;

   public PolygonInstance()
   {
      polygon_ = new geometry_msgs.msg.dds.Polygon();
   }

   public PolygonInstance(PolygonInstance other)
   {
      this();
      set(other);
   }

   public void set(PolygonInstance other)
   {
      geometry_msgs.msg.dds.PolygonPubSubType.staticCopy(other.polygon_, polygon_);
      id_ = other.id_;

   }


   public geometry_msgs.msg.dds.Polygon getPolygon()
   {
      return polygon_;
   }

   public void setId(long id)
   {
      id_ = id;
   }
   public long getId()
   {
      return id_;
   }


   public static Supplier<PolygonInstancePubSubType> getPubSubType()
   {
      return PolygonInstancePubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return PolygonInstancePubSubType::new;
   }

   @Override
   public boolean epsilonEquals(PolygonInstance other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!this.polygon_.epsilonEquals(other.polygon_, epsilon)) return false;
      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.id_, other.id_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof PolygonInstance)) return false;

      PolygonInstance otherMyClass = (PolygonInstance) other;

      if (!this.polygon_.equals(otherMyClass.polygon_)) return false;
      if(this.id_ != otherMyClass.id_) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("PolygonInstance {");
      builder.append("polygon=");
      builder.append(this.polygon_);      builder.append(", ");
      builder.append("id=");
      builder.append(this.id_);
      builder.append("}");
      return builder.toString();
   }
}

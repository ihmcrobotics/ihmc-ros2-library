package nav_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * This hold basic information about the characteristics of the OccupancyGrid
       */
public class MapMetaData extends Packet<MapMetaData> implements Settable<MapMetaData>, EpsilonComparable<MapMetaData>
{
   /**
            * The time at which the map was loaded
            */
   public builtin_interfaces.msg.dds.Time map_load_time_;
   /**
            * The map resolution [m/cell]
            */
   public float resolution_;
   /**
            * Map width [cells]
            */
   public long width_;
   /**
            * Map height [cells]
            */
   public long height_;
   /**
            * The origin of the map [m, m, rad].  This is the real-world pose of the
            * bottom left corner of cell (0,0) in the map.
            */
   public us.ihmc.euclid.geometry.Pose3D origin_;

   public MapMetaData()
   {
      map_load_time_ = new builtin_interfaces.msg.dds.Time();
      origin_ = new us.ihmc.euclid.geometry.Pose3D();
   }

   public MapMetaData(MapMetaData other)
   {
      this();
      set(other);
   }

   public void set(MapMetaData other)
   {
      builtin_interfaces.msg.dds.TimePubSubType.staticCopy(other.map_load_time_, map_load_time_);
      resolution_ = other.resolution_;

      width_ = other.width_;

      height_ = other.height_;

      geometry_msgs.msg.dds.PosePubSubType.staticCopy(other.origin_, origin_);
   }


   /**
            * The time at which the map was loaded
            */
   public builtin_interfaces.msg.dds.Time getMapLoadTime()
   {
      return map_load_time_;
   }

   /**
            * The map resolution [m/cell]
            */
   public void setResolution(float resolution)
   {
      resolution_ = resolution;
   }
   /**
            * The map resolution [m/cell]
            */
   public float getResolution()
   {
      return resolution_;
   }

   /**
            * Map width [cells]
            */
   public void setWidth(long width)
   {
      width_ = width;
   }
   /**
            * Map width [cells]
            */
   public long getWidth()
   {
      return width_;
   }

   /**
            * Map height [cells]
            */
   public void setHeight(long height)
   {
      height_ = height;
   }
   /**
            * Map height [cells]
            */
   public long getHeight()
   {
      return height_;
   }


   /**
            * The origin of the map [m, m, rad].  This is the real-world pose of the
            * bottom left corner of cell (0,0) in the map.
            */
   public us.ihmc.euclid.geometry.Pose3D getOrigin()
   {
      return origin_;
   }


   public static Supplier<MapMetaDataPubSubType> getPubSubType()
   {
      return MapMetaDataPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return MapMetaDataPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(MapMetaData other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!this.map_load_time_.epsilonEquals(other.map_load_time_, epsilon)) return false;
      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.resolution_, other.resolution_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.width_, other.width_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.height_, other.height_, epsilon)) return false;

      if (!this.origin_.epsilonEquals(other.origin_, epsilon)) return false;

      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof MapMetaData)) return false;

      MapMetaData otherMyClass = (MapMetaData) other;

      if (!this.map_load_time_.equals(otherMyClass.map_load_time_)) return false;
      if(this.resolution_ != otherMyClass.resolution_) return false;

      if(this.width_ != otherMyClass.width_) return false;

      if(this.height_ != otherMyClass.height_) return false;

      if (!this.origin_.equals(otherMyClass.origin_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("MapMetaData {");
      builder.append("map_load_time=");
      builder.append(this.map_load_time_);      builder.append(", ");
      builder.append("resolution=");
      builder.append(this.resolution_);      builder.append(", ");
      builder.append("width=");
      builder.append(this.width_);      builder.append(", ");
      builder.append("height=");
      builder.append(this.height_);      builder.append(", ");
      builder.append("origin=");
      builder.append(this.origin_);
      builder.append("}");
      return builder.toString();
   }
}

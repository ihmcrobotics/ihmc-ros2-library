package visualization_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

public class ImageMarker extends Packet<ImageMarker> implements Settable<ImageMarker>, EpsilonComparable<ImageMarker>
{
   public static final int CIRCLE = 0;
   public static final int LINE_STRIP = 1;
   public static final int LINE_LIST = 2;
   public static final int POLYGON = 3;
   public static final int POINTS = 4;
   public static final int ADD = 0;
   public static final int REMOVE = 1;
   public std_msgs.msg.dds.Header header_;
   /**
            * Namespace which is used with the id to form a unique id.
            */
   public java.lang.StringBuilder ns_;
   /**
            * Unique id within the namespace.
            */
   public int id_;
   /**
            * One of the above types, e.g. CIRCLE, LINE_STRIP, etc.
            */
   public int type_;
   /**
            * Either ADD or REMOVE.
            */
   public int action_;
   /**
            * Two-dimensional coordinate position, in pixel-coordinates.
            */
   public us.ihmc.euclid.tuple3D.Point3D position_;
   /**
            * The scale of the object, e.g. the diameter for a CIRCLE.
            */
   public float scale_;
   /**
            * The outline color of the marker.
            */
   public std_msgs.msg.dds.ColorRGBA outline_color_;
   /**
            * Whether or not to fill in the shape with color.
            */
   public byte filled_;
   /**
            * Fill color; in the range: [0.0-1.0]
            */
   public std_msgs.msg.dds.ColorRGBA fill_color_;
   /**
            * How long the object should last before being automatically deleted.
            * 0 indicates forever.
            */
   public builtin_interfaces.msg.dds.Duration lifetime_;
   /**
            * Coordinates in 2D in pixel coords. Used for LINE_STRIP, LINE_LIST, POINTS, etc.
            */
   public us.ihmc.idl.IDLSequence.Object<us.ihmc.euclid.tuple3D.Point3D>  points_;
   /**
            * The color for each line, point, etc. in the points field.
            */
   public us.ihmc.idl.IDLSequence.Object<std_msgs.msg.dds.ColorRGBA>  outline_colors_;

   public ImageMarker()
   {
      header_ = new std_msgs.msg.dds.Header();
      ns_ = new java.lang.StringBuilder(255);
      position_ = new us.ihmc.euclid.tuple3D.Point3D();
      outline_color_ = new std_msgs.msg.dds.ColorRGBA();
      fill_color_ = new std_msgs.msg.dds.ColorRGBA();
      lifetime_ = new builtin_interfaces.msg.dds.Duration();
      points_ = new us.ihmc.idl.IDLSequence.Object<us.ihmc.euclid.tuple3D.Point3D> (100, new geometry_msgs.msg.dds.PointPubSubType());
      outline_colors_ = new us.ihmc.idl.IDLSequence.Object<std_msgs.msg.dds.ColorRGBA> (100, new std_msgs.msg.dds.ColorRGBAPubSubType());

   }

   public ImageMarker(ImageMarker other)
   {
      this();
      set(other);
   }

   public void set(ImageMarker other)
   {
      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
      ns_.setLength(0);
      ns_.append(other.ns_);

      id_ = other.id_;

      type_ = other.type_;

      action_ = other.action_;

      geometry_msgs.msg.dds.PointPubSubType.staticCopy(other.position_, position_);
      scale_ = other.scale_;

      std_msgs.msg.dds.ColorRGBAPubSubType.staticCopy(other.outline_color_, outline_color_);
      filled_ = other.filled_;

      std_msgs.msg.dds.ColorRGBAPubSubType.staticCopy(other.fill_color_, fill_color_);
      builtin_interfaces.msg.dds.DurationPubSubType.staticCopy(other.lifetime_, lifetime_);
      points_.set(other.points_);
      outline_colors_.set(other.outline_colors_);
   }


   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }

   /**
            * Namespace which is used with the id to form a unique id.
            */
   public void setNs(java.lang.String ns)
   {
      ns_.setLength(0);
      ns_.append(ns);
   }

   /**
            * Namespace which is used with the id to form a unique id.
            */
   public java.lang.String getNsAsString()
   {
      return getNs().toString();
   }
   /**
            * Namespace which is used with the id to form a unique id.
            */
   public java.lang.StringBuilder getNs()
   {
      return ns_;
   }

   /**
            * Unique id within the namespace.
            */
   public void setId(int id)
   {
      id_ = id;
   }
   /**
            * Unique id within the namespace.
            */
   public int getId()
   {
      return id_;
   }

   /**
            * One of the above types, e.g. CIRCLE, LINE_STRIP, etc.
            */
   public void setType(int type)
   {
      type_ = type;
   }
   /**
            * One of the above types, e.g. CIRCLE, LINE_STRIP, etc.
            */
   public int getType()
   {
      return type_;
   }

   /**
            * Either ADD or REMOVE.
            */
   public void setAction(int action)
   {
      action_ = action;
   }
   /**
            * Either ADD or REMOVE.
            */
   public int getAction()
   {
      return action_;
   }


   /**
            * Two-dimensional coordinate position, in pixel-coordinates.
            */
   public us.ihmc.euclid.tuple3D.Point3D getPosition()
   {
      return position_;
   }

   /**
            * The scale of the object, e.g. the diameter for a CIRCLE.
            */
   public void setScale(float scale)
   {
      scale_ = scale;
   }
   /**
            * The scale of the object, e.g. the diameter for a CIRCLE.
            */
   public float getScale()
   {
      return scale_;
   }


   /**
            * The outline color of the marker.
            */
   public std_msgs.msg.dds.ColorRGBA getOutlineColor()
   {
      return outline_color_;
   }

   /**
            * Whether or not to fill in the shape with color.
            */
   public void setFilled(byte filled)
   {
      filled_ = filled;
   }
   /**
            * Whether or not to fill in the shape with color.
            */
   public byte getFilled()
   {
      return filled_;
   }


   /**
            * Fill color; in the range: [0.0-1.0]
            */
   public std_msgs.msg.dds.ColorRGBA getFillColor()
   {
      return fill_color_;
   }


   /**
            * How long the object should last before being automatically deleted.
            * 0 indicates forever.
            */
   public builtin_interfaces.msg.dds.Duration getLifetime()
   {
      return lifetime_;
   }


   /**
            * Coordinates in 2D in pixel coords. Used for LINE_STRIP, LINE_LIST, POINTS, etc.
            */
   public us.ihmc.idl.IDLSequence.Object<us.ihmc.euclid.tuple3D.Point3D>  getPoints()
   {
      return points_;
   }


   /**
            * The color for each line, point, etc. in the points field.
            */
   public us.ihmc.idl.IDLSequence.Object<std_msgs.msg.dds.ColorRGBA>  getOutlineColors()
   {
      return outline_colors_;
   }


   public static Supplier<ImageMarkerPubSubType> getPubSubType()
   {
      return ImageMarkerPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return ImageMarkerPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(ImageMarker other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!this.header_.epsilonEquals(other.header_, epsilon)) return false;
      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.ns_, other.ns_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.id_, other.id_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.type_, other.type_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.action_, other.action_, epsilon)) return false;

      if (!this.position_.epsilonEquals(other.position_, epsilon)) return false;
      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.scale_, other.scale_, epsilon)) return false;

      if (!this.outline_color_.epsilonEquals(other.outline_color_, epsilon)) return false;
      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.filled_, other.filled_, epsilon)) return false;

      if (!this.fill_color_.epsilonEquals(other.fill_color_, epsilon)) return false;
      if (!this.lifetime_.epsilonEquals(other.lifetime_, epsilon)) return false;
      if (this.points_.size() != other.points_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.points_.size(); i++)
         {  if (!this.points_.get(i).epsilonEquals(other.points_.get(i), epsilon)) return false; }
      }

      if (this.outline_colors_.size() != other.outline_colors_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.outline_colors_.size(); i++)
         {  if (!this.outline_colors_.get(i).epsilonEquals(other.outline_colors_.get(i), epsilon)) return false; }
      }


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof ImageMarker)) return false;

      ImageMarker otherMyClass = (ImageMarker) other;

      if (!this.header_.equals(otherMyClass.header_)) return false;
      if (!us.ihmc.idl.IDLTools.equals(this.ns_, otherMyClass.ns_)) return false;

      if(this.id_ != otherMyClass.id_) return false;

      if(this.type_ != otherMyClass.type_) return false;

      if(this.action_ != otherMyClass.action_) return false;

      if (!this.position_.equals(otherMyClass.position_)) return false;
      if(this.scale_ != otherMyClass.scale_) return false;

      if (!this.outline_color_.equals(otherMyClass.outline_color_)) return false;
      if(this.filled_ != otherMyClass.filled_) return false;

      if (!this.fill_color_.equals(otherMyClass.fill_color_)) return false;
      if (!this.lifetime_.equals(otherMyClass.lifetime_)) return false;
      if (!this.points_.equals(otherMyClass.points_)) return false;
      if (!this.outline_colors_.equals(otherMyClass.outline_colors_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("ImageMarker {");
      builder.append("header=");
      builder.append(this.header_);      builder.append(", ");
      builder.append("ns=");
      builder.append(this.ns_);      builder.append(", ");
      builder.append("id=");
      builder.append(this.id_);      builder.append(", ");
      builder.append("type=");
      builder.append(this.type_);      builder.append(", ");
      builder.append("action=");
      builder.append(this.action_);      builder.append(", ");
      builder.append("position=");
      builder.append(this.position_);      builder.append(", ");
      builder.append("scale=");
      builder.append(this.scale_);      builder.append(", ");
      builder.append("outline_color=");
      builder.append(this.outline_color_);      builder.append(", ");
      builder.append("filled=");
      builder.append(this.filled_);      builder.append(", ");
      builder.append("fill_color=");
      builder.append(this.fill_color_);      builder.append(", ");
      builder.append("lifetime=");
      builder.append(this.lifetime_);      builder.append(", ");
      builder.append("points=");
      builder.append(this.points_);      builder.append(", ");
      builder.append("outline_colors=");
      builder.append(this.outline_colors_);
      builder.append("}");
      return builder.toString();
   }
}

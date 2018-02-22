package visualization_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Definition of the class "ImageMarker" defined in ImageMarker_.idl.
 *
 * This file was automatically generated from ImageMarker_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit ImageMarker_.idl instead.
 */
public class ImageMarker implements Settable<ImageMarker>, EpsilonComparable<ImageMarker>
{
   private std_msgs.msg.dds.Header header_;
   private java.lang.StringBuilder ns_;
   private int id_;
   private int type_;
   private int action_;
   private us.ihmc.euclid.tuple3D.Point3D position_;
   private float scale_;
   private std_msgs.msg.dds.ColorRGBA outline_color_;
   private byte filled_;
   private std_msgs.msg.dds.ColorRGBA fill_color_;
   private builtin_interfaces.msg.dds.Duration lifetime_;
   private us.ihmc.idl.IDLSequence.Object<us.ihmc.euclid.tuple3D.Point3D> points_;
   private us.ihmc.idl.IDLSequence.Object<std_msgs.msg.dds.ColorRGBA> outline_colors_;

   public ImageMarker()
   {
      header_ = new std_msgs.msg.dds.Header();
      ns_ = new java.lang.StringBuilder(255);

      position_ = new us.ihmc.euclid.tuple3D.Point3D();

      outline_color_ = new std_msgs.msg.dds.ColorRGBA();

      fill_color_ = new std_msgs.msg.dds.ColorRGBA();
      lifetime_ = new builtin_interfaces.msg.dds.Duration();
      points_ = new us.ihmc.idl.IDLSequence.Object<us.ihmc.euclid.tuple3D.Point3D>(100, us.ihmc.euclid.tuple3D.Point3D.class,
                                                                                   new geometry_msgs.msg.dds.PointPubSubType());

      outline_colors_ = new us.ihmc.idl.IDLSequence.Object<std_msgs.msg.dds.ColorRGBA>(100, std_msgs.msg.dds.ColorRGBA.class,
                                                                                       new std_msgs.msg.dds.ColorRGBAPubSubType());
   }

   public ImageMarker(ImageMarker other)
   {
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

   public java.lang.String getNsAsString()
   {
      return getNs().toString();
   }

   public java.lang.StringBuilder getNs()
   {
      return ns_;
   }

   public void setNs(String ns)
   {
      ns_.setLength(0);
      ns_.append(ns);
   }

   public int getId()
   {
      return id_;
   }

   public void setId(int id)
   {
      id_ = id;
   }

   public int getType()
   {
      return type_;
   }

   public void setType(int type)
   {
      type_ = type;
   }

   public int getAction()
   {
      return action_;
   }

   public void setAction(int action)
   {
      action_ = action;
   }

   public us.ihmc.euclid.tuple3D.Point3D getPosition()
   {
      return position_;
   }

   public float getScale()
   {
      return scale_;
   }

   public void setScale(float scale)
   {
      scale_ = scale;
   }

   public std_msgs.msg.dds.ColorRGBA getOutlineColor()
   {
      return outline_color_;
   }

   public byte getFilled()
   {
      return filled_;
   }

   public void setFilled(byte filled)
   {
      filled_ = filled;
   }

   public std_msgs.msg.dds.ColorRGBA getFillColor()
   {
      return fill_color_;
   }

   public builtin_interfaces.msg.dds.Duration getLifetime()
   {
      return lifetime_;
   }

   public us.ihmc.idl.IDLSequence.Object<us.ihmc.euclid.tuple3D.Point3D> getPoints()
   {
      return points_;
   }

   public us.ihmc.idl.IDLSequence.Object<std_msgs.msg.dds.ColorRGBA> getOutlineColors()
   {
      return outline_colors_;
   }

   @Override
   public boolean epsilonEquals(ImageMarker other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!this.header_.epsilonEquals(other.header_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.ns_, other.ns_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.id_, other.id_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.type_, other.type_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.action_, other.action_, epsilon))
         return false;

      if (!this.position_.epsilonEquals(other.position_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.scale_, other.scale_, epsilon))
         return false;

      if (!this.outline_color_.epsilonEquals(other.outline_color_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.filled_, other.filled_, epsilon))
         return false;

      if (!this.fill_color_.epsilonEquals(other.fill_color_, epsilon))
         return false;

      if (!this.lifetime_.epsilonEquals(other.lifetime_, epsilon))
         return false;

      if (this.points_.isEnum())
      {
         if (!this.points_.equals(other.points_))
            return false;
      }
      else if (this.points_.size() == other.points_.size())
      {
         return false;
      }
      else
      {
         for (int i = 0; i < this.points_.size(); i++)
         {
            if (!this.points_.get(i).epsilonEquals(other.points_.get(i), epsilon))
               return false;
         }
      }

      if (this.outline_colors_.isEnum())
      {
         if (!this.outline_colors_.equals(other.outline_colors_))
            return false;
      }
      else if (this.outline_colors_.size() == other.outline_colors_.size())
      {
         return false;
      }
      else
      {
         for (int i = 0; i < this.outline_colors_.size(); i++)
         {
            if (!this.outline_colors_.get(i).epsilonEquals(other.outline_colors_.get(i), epsilon))
               return false;
         }
      }

      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;
      if (!(other instanceof ImageMarker))
         return false;

      ImageMarker otherMyClass = (ImageMarker) other;

      if (!this.header_.equals(otherMyClass.header_))
         return false;

      if (!us.ihmc.idl.IDLTools.equals(this.ns_, otherMyClass.ns_))
         return false;

      if (this.id_ != otherMyClass.id_)
         return false;

      if (this.type_ != otherMyClass.type_)
         return false;

      if (this.action_ != otherMyClass.action_)
         return false;

      if (!this.position_.equals(otherMyClass.position_))
         return false;

      if (this.scale_ != otherMyClass.scale_)
         return false;

      if (!this.outline_color_.equals(otherMyClass.outline_color_))
         return false;

      if (this.filled_ != otherMyClass.filled_)
         return false;

      if (!this.fill_color_.equals(otherMyClass.fill_color_))
         return false;

      if (!this.lifetime_.equals(otherMyClass.lifetime_))
         return false;

      if (!this.points_.equals(otherMyClass.points_))
         return false;

      if (!this.outline_colors_.equals(otherMyClass.outline_colors_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("ImageMarker {");
      builder.append("header=");
      builder.append(this.header_);

      builder.append(", ");
      builder.append("ns=");
      builder.append(this.ns_);

      builder.append(", ");
      builder.append("id=");
      builder.append(this.id_);

      builder.append(", ");
      builder.append("type=");
      builder.append(this.type_);

      builder.append(", ");
      builder.append("action=");
      builder.append(this.action_);

      builder.append(", ");
      builder.append("position=");
      builder.append(this.position_);

      builder.append(", ");
      builder.append("scale=");
      builder.append(this.scale_);

      builder.append(", ");
      builder.append("outline_color=");
      builder.append(this.outline_color_);

      builder.append(", ");
      builder.append("filled=");
      builder.append(this.filled_);

      builder.append(", ");
      builder.append("fill_color=");
      builder.append(this.fill_color_);

      builder.append(", ");
      builder.append("lifetime=");
      builder.append(this.lifetime_);

      builder.append(", ");
      builder.append("points=");
      builder.append(this.points_);

      builder.append(", ");
      builder.append("outline_colors=");
      builder.append(this.outline_colors_);

      builder.append("}");
      return builder.toString();
   }
}
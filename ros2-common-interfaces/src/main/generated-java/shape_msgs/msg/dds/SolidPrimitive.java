package shape_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * Defines box, sphere, cylinder, cone and prism.
       * All shapes are defined to have their bounding boxes centered around 0,0,0.
       * The meaning of the shape dimensions: each constant defines the index in the 'dimensions' array.
       * For the CYLINDER and CONE types, the center line is oriented along the Z axis.
       * Therefore the CYLINDER_HEIGHT (CONE_HEIGHT) component of dimensions gives the
       * height of the cylinder (cone).
       * The CYLINDER_RADIUS (CONE_RADIUS) component of dimensions gives the radius of
       * the base of the cylinder (cone).
       * Cone and cylinder primitives are defined to be circular. The tip of the cone
       * is pointing up, along +Z axis.
       * For the type PRISM, the center line is oriented along Z axis.
       * The PRISM_HEIGHT component of dimensions gives the
       * height of the prism.
       * The polygon defines the Z axis centered base of the prism.
       * The prism is constructed by extruding the base in +Z and -Z
       * directions by half of the PRISM_HEIGHT
       * Only x and y fields of the points are used in the polygon.
       * Points of the polygon are ordered counter-clockwise.
       */
public class SolidPrimitive extends Packet<SolidPrimitive> implements Settable<SolidPrimitive>, EpsilonComparable<SolidPrimitive>
{
   public static final byte BOX = (byte) 1;
   public static final byte SPHERE = (byte) 2;
   public static final byte CYLINDER = (byte) 3;
   public static final byte CONE = (byte) 4;
   public static final byte PRISM = (byte) 5;
   /**
          * For type BOX, the X, Y, and Z dimensions are the length of the corresponding sides of the box.
          */
   public static final byte BOX_X = (byte) 0;
   public static final byte BOX_Y = (byte) 1;
   public static final byte BOX_Z = (byte) 2;
   /**
          * For the SPHERE type, only one component is used, and it gives the radius of the sphere.
          */
   public static final byte SPHERE_RADIUS = (byte) 0;
   public static final byte CYLINDER_HEIGHT = (byte) 0;
   public static final byte CYLINDER_RADIUS = (byte) 1;
   public static final byte CONE_HEIGHT = (byte) 0;
   public static final byte CONE_RADIUS = (byte) 1;
   public static final byte PRISM_HEIGHT = (byte) 0;
   /**
            * The type of the shape
            */
   public byte type_;
   /**
            * The dimensions of the shape
            * At no point will dimensions have a length > 3.
            */
   public us.ihmc.idl.IDLSequence.Double  dimensions_;
   public geometry_msgs.msg.dds.Polygon polygon_;

   public SolidPrimitive()
   {
      dimensions_ = new us.ihmc.idl.IDLSequence.Double (3, "type_6");

      polygon_ = new geometry_msgs.msg.dds.Polygon();
   }

   public SolidPrimitive(SolidPrimitive other)
   {
      this();
      set(other);
   }

   public void set(SolidPrimitive other)
   {
      type_ = other.type_;

      dimensions_.set(other.dimensions_);
      geometry_msgs.msg.dds.PolygonPubSubType.staticCopy(other.polygon_, polygon_);
   }

   /**
            * The type of the shape
            */
   public void setType(byte type)
   {
      type_ = type;
   }
   /**
            * The type of the shape
            */
   public byte getType()
   {
      return type_;
   }


   /**
            * The dimensions of the shape
            * At no point will dimensions have a length > 3.
            */
   public us.ihmc.idl.IDLSequence.Double  getDimensions()
   {
      return dimensions_;
   }


   public geometry_msgs.msg.dds.Polygon getPolygon()
   {
      return polygon_;
   }


   public static Supplier<SolidPrimitivePubSubType> getPubSubType()
   {
      return SolidPrimitivePubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return SolidPrimitivePubSubType::new;
   }

   @Override
   public boolean epsilonEquals(SolidPrimitive other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.type_, other.type_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsDoubleSequence(this.dimensions_, other.dimensions_, epsilon)) return false;

      if (!this.polygon_.epsilonEquals(other.polygon_, epsilon)) return false;

      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof SolidPrimitive)) return false;

      SolidPrimitive otherMyClass = (SolidPrimitive) other;

      if(this.type_ != otherMyClass.type_) return false;

      if (!this.dimensions_.equals(otherMyClass.dimensions_)) return false;
      if (!this.polygon_.equals(otherMyClass.polygon_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("SolidPrimitive {");
      builder.append("type=");
      builder.append(this.type_);      builder.append(", ");
      builder.append("dimensions=");
      builder.append(this.dimensions_);      builder.append(", ");
      builder.append("polygon=");
      builder.append(this.polygon_);
      builder.append("}");
      return builder.toString();
   }
}

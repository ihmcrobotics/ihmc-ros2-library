package us.ihmc.idl.generated.geometry;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

//@Abstract(type="java.lang.Object", impl="null")
public class Vector extends Packet<Vector> implements Settable<Vector>, EpsilonComparable<Vector>
{
   public java.lang.StringBuilder frame_;
   public double x_;
   public double y_;
   public double z_;
   public us.ihmc.idl.IDLSequence.Double  bla_;
   public double[] waa_;

   public Vector()
   {
      frame_ = new java.lang.StringBuilder(128);
      bla_ = new us.ihmc.idl.IDLSequence.Double (100, "type_6");

      waa_ = new double[3];

   }

   public Vector(Vector other)
   {
      this();
      set(other);
   }

   public void set(Vector other)
   {
      frame_.setLength(0);
      frame_.append(other.frame_);

      x_ = other.x_;

      y_ = other.y_;

      z_ = other.z_;

      bla_.set(other.bla_);
      for(int i1 = 0; i1 < waa_.length; ++i1)
      {
            waa_[i1] = other.waa_[i1];

      }

   }

   public void setFrame(java.lang.String frame)
   {
      frame_.setLength(0);
      frame_.append(frame);
   }

   public java.lang.String getFrameAsString()
   {
      return getFrame().toString();
   }
   public java.lang.StringBuilder getFrame()
   {
      return frame_;
   }

   public void setX(double x)
   {
      x_ = x;
   }
   public double getX()
   {
      return x_;
   }

   public void setY(double y)
   {
      y_ = y;
   }
   public double getY()
   {
      return y_;
   }

   public void setZ(double z)
   {
      z_ = z;
   }
   public double getZ()
   {
      return z_;
   }


   public us.ihmc.idl.IDLSequence.Double  getBla()
   {
      return bla_;
   }


   public double[] getWaa()
   {
      return waa_;
   }


   public static Supplier<VectorPubSubType> getPubSubType()
   {
      return VectorPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return VectorPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(Vector other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.frame_, other.frame_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.x_, other.x_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.y_, other.y_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.z_, other.z_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsDoubleSequence(this.bla_, other.bla_, epsilon)) return false;

      for(int i3 = 0; i3 < waa_.length; ++i3)
      {
                if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.waa_[i3], other.waa_[i3], epsilon)) return false;
      }


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof Vector)) return false;

      Vector otherMyClass = (Vector) other;

      if (!us.ihmc.idl.IDLTools.equals(this.frame_, otherMyClass.frame_)) return false;

      if(this.x_ != otherMyClass.x_) return false;

      if(this.y_ != otherMyClass.y_) return false;

      if(this.z_ != otherMyClass.z_) return false;

      if (!this.bla_.equals(otherMyClass.bla_)) return false;
      for(int i5 = 0; i5 < waa_.length; ++i5)
      {
                if(this.waa_[i5] != otherMyClass.waa_[i5]) return false;

      }

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("Vector {");
      builder.append("frame=");
      builder.append(this.frame_);      builder.append(", ");
      builder.append("x=");
      builder.append(this.x_);      builder.append(", ");
      builder.append("y=");
      builder.append(this.y_);      builder.append(", ");
      builder.append("z=");
      builder.append(this.z_);      builder.append(", ");
      builder.append("bla=");
      builder.append(this.bla_);      builder.append(", ");
      builder.append("waa=");
      builder.append(java.util.Arrays.toString(this.waa_));
      builder.append("}");
      return builder.toString();
   }
}

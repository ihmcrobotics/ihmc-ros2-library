package us.ihmc.idl.generated.geometry;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

public class Box extends Packet<Box> implements Settable<Box>, EpsilonComparable<Box>
{
   public us.ihmc.idl.generated.geometry.Vector center_;
   public double w_;
   public double l_;
   public double h_;

   public Box()
   {
      center_ = new us.ihmc.idl.generated.geometry.Vector();
   }

   public Box(Box other)
   {
      this();
      set(other);
   }

   public void set(Box other)
   {
      us.ihmc.idl.generated.geometry.VectorPubSubType.staticCopy(other.center_, center_);
      w_ = other.w_;

      l_ = other.l_;

      h_ = other.h_;

   }


   public us.ihmc.idl.generated.geometry.Vector getCenter()
   {
      return center_;
   }

   public void setW(double w)
   {
      w_ = w;
   }
   public double getW()
   {
      return w_;
   }

   public void setL(double l)
   {
      l_ = l;
   }
   public double getL()
   {
      return l_;
   }

   public void setH(double h)
   {
      h_ = h;
   }
   public double getH()
   {
      return h_;
   }


   public static Supplier<BoxPubSubType> getPubSubType()
   {
      return BoxPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return BoxPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(Box other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!this.center_.epsilonEquals(other.center_, epsilon)) return false;
      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.w_, other.w_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.l_, other.l_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.h_, other.h_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof Box)) return false;

      Box otherMyClass = (Box) other;

      if (!this.center_.equals(otherMyClass.center_)) return false;
      if(this.w_ != otherMyClass.w_) return false;

      if(this.l_ != otherMyClass.l_) return false;

      if(this.h_ != otherMyClass.h_) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("Box {");
      builder.append("center=");
      builder.append(this.center_);      builder.append(", ");
      builder.append("w=");
      builder.append(this.w_);      builder.append(", ");
      builder.append("l=");
      builder.append(this.l_);      builder.append(", ");
      builder.append("h=");
      builder.append(this.h_);
      builder.append("}");
      return builder.toString();
   }
}

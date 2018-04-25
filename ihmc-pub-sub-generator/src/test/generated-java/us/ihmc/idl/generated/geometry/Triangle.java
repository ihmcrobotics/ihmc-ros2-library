package us.ihmc.idl.generated.geometry;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

public class Triangle extends Packet<Triangle> implements Settable<Triangle>, EpsilonComparable<Triangle>
{
   public us.ihmc.idl.generated.geometry.Vector[] points_;

   public Triangle()
   {
      points_ = new us.ihmc.idl.generated.geometry.Vector[3];

      for(int i7 = 0; i7 < points_.length; ++i7)
      {
          points_[i7] = new us.ihmc.idl.generated.geometry.Vector();
      }
   }

   public Triangle(Triangle other)
   {
      this();
      set(other);
   }

   public void set(Triangle other)
   {
      for(int i9 = 0; i9 < points_.length; ++i9)
      {
            us.ihmc.idl.generated.geometry.VectorPubSubType.staticCopy(other.points_[i9], points_[i9]);}
   }


   public us.ihmc.idl.generated.geometry.Vector[] getPoints()
   {
      return points_;
   }


   public static Supplier<TrianglePubSubType> getPubSubType()
   {
      return TrianglePubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return TrianglePubSubType::new;
   }

   @Override
   public boolean epsilonEquals(Triangle other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      for(int i11 = 0; i11 < points_.length; ++i11)
      {
              if (!this.points_[i11].epsilonEquals(other.points_[i11], epsilon)) return false;
      }

      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof Triangle)) return false;

      Triangle otherMyClass = (Triangle) other;

      for(int i13 = 0; i13 < points_.length; ++i13)
      {
                if (!this.points_[i13].equals(otherMyClass.points_[i13])) return false;
      }
      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("Triangle {");
      builder.append("points=");
      builder.append(java.util.Arrays.toString(this.points_));
      builder.append("}");
      return builder.toString();
   }
}

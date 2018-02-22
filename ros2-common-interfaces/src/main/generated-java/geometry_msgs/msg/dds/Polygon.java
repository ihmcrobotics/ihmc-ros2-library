package geometry_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Definition of the class "Polygon" defined in Polygon_.idl.
 *
 * This file was automatically generated from Polygon_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit Polygon_.idl instead.
 */
public class Polygon implements Settable<Polygon>, EpsilonComparable<Polygon>
{
   private us.ihmc.idl.IDLSequence.Object<us.ihmc.euclid.tuple3D.Point3D32> points_;

   public Polygon()
   {
      points_ = new us.ihmc.idl.IDLSequence.Object<us.ihmc.euclid.tuple3D.Point3D32>(100, us.ihmc.euclid.tuple3D.Point3D32.class,
                                                                                     new geometry_msgs.msg.dds.Point32PubSubType());
   }

   public Polygon(Polygon other)
   {
      set(other);
   }

   public void set(Polygon other)
   {
      points_.set(other.points_);
   }

   public us.ihmc.idl.IDLSequence.Object<us.ihmc.euclid.tuple3D.Point3D32> getPoints()
   {
      return points_;
   }

   @Override
   public boolean epsilonEquals(Polygon other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

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

      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;
      if (!(other instanceof Polygon))
         return false;

      Polygon otherMyClass = (Polygon) other;

      if (!this.points_.equals(otherMyClass.points_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("Polygon {");
      builder.append("points=");
      builder.append(this.points_);

      builder.append("}");
      return builder.toString();
   }
}
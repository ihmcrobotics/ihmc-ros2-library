package geometry_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

public class Inertia extends Packet<Inertia> implements Settable<Inertia>, EpsilonComparable<Inertia>
{
   /**
            * Mass [kg]
            */
   public double m_;
   /**
            * Center of mass [m]
            */
   public us.ihmc.euclid.tuple3D.Vector3D com_;
   /**
            * Inertia Tensor [kg-m^2] about the center of mass
            * | ixx ixy ixz |
            * I = | ixy iyy iyz |
            * | ixz iyz izz |
            */
   public double ixx_;
   public double ixy_;
   public double ixz_;
   public double iyy_;
   public double iyz_;
   public double izz_;

   public Inertia()
   {
      com_ = new us.ihmc.euclid.tuple3D.Vector3D();
   }

   public Inertia(Inertia other)
   {
      this();
      set(other);
   }

   public void set(Inertia other)
   {
      m_ = other.m_;

      geometry_msgs.msg.dds.Vector3PubSubType.staticCopy(other.com_, com_);
      ixx_ = other.ixx_;

      ixy_ = other.ixy_;

      ixz_ = other.ixz_;

      iyy_ = other.iyy_;

      iyz_ = other.iyz_;

      izz_ = other.izz_;

   }

   /**
            * Mass [kg]
            */
   public void setM(double m)
   {
      m_ = m;
   }
   /**
            * Mass [kg]
            */
   public double getM()
   {
      return m_;
   }


   /**
            * Center of mass [m]
            */
   public us.ihmc.euclid.tuple3D.Vector3D getCom()
   {
      return com_;
   }

   /**
            * Inertia Tensor [kg-m^2] about the center of mass
            * | ixx ixy ixz |
            * I = | ixy iyy iyz |
            * | ixz iyz izz |
            */
   public void setIxx(double ixx)
   {
      ixx_ = ixx;
   }
   /**
            * Inertia Tensor [kg-m^2] about the center of mass
            * | ixx ixy ixz |
            * I = | ixy iyy iyz |
            * | ixz iyz izz |
            */
   public double getIxx()
   {
      return ixx_;
   }

   public void setIxy(double ixy)
   {
      ixy_ = ixy;
   }
   public double getIxy()
   {
      return ixy_;
   }

   public void setIxz(double ixz)
   {
      ixz_ = ixz;
   }
   public double getIxz()
   {
      return ixz_;
   }

   public void setIyy(double iyy)
   {
      iyy_ = iyy;
   }
   public double getIyy()
   {
      return iyy_;
   }

   public void setIyz(double iyz)
   {
      iyz_ = iyz;
   }
   public double getIyz()
   {
      return iyz_;
   }

   public void setIzz(double izz)
   {
      izz_ = izz;
   }
   public double getIzz()
   {
      return izz_;
   }


   public static Supplier<InertiaPubSubType> getPubSubType()
   {
      return InertiaPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return InertiaPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(Inertia other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.m_, other.m_, epsilon)) return false;

      if (!this.com_.epsilonEquals(other.com_, epsilon)) return false;
      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.ixx_, other.ixx_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.ixy_, other.ixy_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.ixz_, other.ixz_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.iyy_, other.iyy_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.iyz_, other.iyz_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.izz_, other.izz_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof Inertia)) return false;

      Inertia otherMyClass = (Inertia) other;

      if(this.m_ != otherMyClass.m_) return false;

      if (!this.com_.equals(otherMyClass.com_)) return false;
      if(this.ixx_ != otherMyClass.ixx_) return false;

      if(this.ixy_ != otherMyClass.ixy_) return false;

      if(this.ixz_ != otherMyClass.ixz_) return false;

      if(this.iyy_ != otherMyClass.iyy_) return false;

      if(this.iyz_ != otherMyClass.iyz_) return false;

      if(this.izz_ != otherMyClass.izz_) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("Inertia {");
      builder.append("m=");
      builder.append(this.m_);      builder.append(", ");
      builder.append("com=");
      builder.append(this.com_);      builder.append(", ");
      builder.append("ixx=");
      builder.append(this.ixx_);      builder.append(", ");
      builder.append("ixy=");
      builder.append(this.ixy_);      builder.append(", ");
      builder.append("ixz=");
      builder.append(this.ixz_);      builder.append(", ");
      builder.append("iyy=");
      builder.append(this.iyy_);      builder.append(", ");
      builder.append("iyz=");
      builder.append(this.iyz_);      builder.append(", ");
      builder.append("izz=");
      builder.append(this.izz_);
      builder.append("}");
      return builder.toString();
   }
}

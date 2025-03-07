package visualization_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

public class UVCoordinate extends Packet<UVCoordinate> implements Settable<UVCoordinate>, EpsilonComparable<UVCoordinate>
{
   /**
            * Location of the pixel as a ratio of the width of a 2D texture.
            * Values should be in range: [0.0-1.0].
            */
   public float u_;
   public float v_;

   public UVCoordinate()
   {
   }

   public UVCoordinate(UVCoordinate other)
   {
      this();
      set(other);
   }

   public void set(UVCoordinate other)
   {
      u_ = other.u_;

      v_ = other.v_;

   }

   /**
            * Location of the pixel as a ratio of the width of a 2D texture.
            * Values should be in range: [0.0-1.0].
            */
   public void setU(float u)
   {
      u_ = u;
   }
   /**
            * Location of the pixel as a ratio of the width of a 2D texture.
            * Values should be in range: [0.0-1.0].
            */
   public float getU()
   {
      return u_;
   }

   public void setV(float v)
   {
      v_ = v;
   }
   public float getV()
   {
      return v_;
   }


   public static Supplier<UVCoordinatePubSubType> getPubSubType()
   {
      return UVCoordinatePubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return UVCoordinatePubSubType::new;
   }

   @Override
   public boolean epsilonEquals(UVCoordinate other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.u_, other.u_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.v_, other.v_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof UVCoordinate)) return false;

      UVCoordinate otherMyClass = (UVCoordinate) other;

      if(this.u_ != otherMyClass.u_) return false;

      if(this.v_ != otherMyClass.v_) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("UVCoordinate {");
      builder.append("u=");
      builder.append(this.u_);      builder.append(", ");
      builder.append("v=");
      builder.append(this.v_);
      builder.append("}");
      return builder.toString();
   }
}

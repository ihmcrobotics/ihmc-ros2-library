package geometry_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * This represents force in free space, separated into its linear and angular parts.
       */
public class Wrench extends Packet<Wrench> implements Settable<Wrench>, EpsilonComparable<Wrench>
{
   public us.ihmc.euclid.tuple3D.Vector3D force_;
   public us.ihmc.euclid.tuple3D.Vector3D torque_;

   public Wrench()
   {
      force_ = new us.ihmc.euclid.tuple3D.Vector3D();
      torque_ = new us.ihmc.euclid.tuple3D.Vector3D();
   }

   public Wrench(Wrench other)
   {
      this();
      set(other);
   }

   public void set(Wrench other)
   {
      geometry_msgs.msg.dds.Vector3PubSubType.staticCopy(other.force_, force_);
      geometry_msgs.msg.dds.Vector3PubSubType.staticCopy(other.torque_, torque_);
   }


   public us.ihmc.euclid.tuple3D.Vector3D getForce()
   {
      return force_;
   }


   public us.ihmc.euclid.tuple3D.Vector3D getTorque()
   {
      return torque_;
   }


   public static Supplier<WrenchPubSubType> getPubSubType()
   {
      return WrenchPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return WrenchPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(Wrench other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!this.force_.epsilonEquals(other.force_, epsilon)) return false;
      if (!this.torque_.epsilonEquals(other.torque_, epsilon)) return false;

      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof Wrench)) return false;

      Wrench otherMyClass = (Wrench) other;

      if (!this.force_.equals(otherMyClass.force_)) return false;
      if (!this.torque_.equals(otherMyClass.torque_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("Wrench {");
      builder.append("force=");
      builder.append(this.force_);      builder.append(", ");
      builder.append("torque=");
      builder.append(this.torque_);
      builder.append("}");
      return builder.toString();
   }
}

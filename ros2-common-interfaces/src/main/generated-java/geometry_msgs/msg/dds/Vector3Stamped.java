package geometry_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * This represents a Vector3 with reference coordinate frame and timestamp
       * Note that this follows vector semantics with it always anchored at the origin,
       * so the rotational elements of a transform are the only parts applied when transforming.
       */
public class Vector3Stamped extends Packet<Vector3Stamped> implements Settable<Vector3Stamped>, EpsilonComparable<Vector3Stamped>
{
   public std_msgs.msg.dds.Header header_;
   public us.ihmc.euclid.tuple3D.Vector3D vector_;

   public Vector3Stamped()
   {
      header_ = new std_msgs.msg.dds.Header();
      vector_ = new us.ihmc.euclid.tuple3D.Vector3D();
   }

   public Vector3Stamped(Vector3Stamped other)
   {
      this();
      set(other);
   }

   public void set(Vector3Stamped other)
   {
      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
      geometry_msgs.msg.dds.Vector3PubSubType.staticCopy(other.vector_, vector_);
   }


   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }


   public us.ihmc.euclid.tuple3D.Vector3D getVector()
   {
      return vector_;
   }


   public static Supplier<Vector3StampedPubSubType> getPubSubType()
   {
      return Vector3StampedPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return Vector3StampedPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(Vector3Stamped other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!this.header_.epsilonEquals(other.header_, epsilon)) return false;
      if (!this.vector_.epsilonEquals(other.vector_, epsilon)) return false;

      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof Vector3Stamped)) return false;

      Vector3Stamped otherMyClass = (Vector3Stamped) other;

      if (!this.header_.equals(otherMyClass.header_)) return false;
      if (!this.vector_.equals(otherMyClass.vector_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("Vector3Stamped {");
      builder.append("header=");
      builder.append(this.header_);      builder.append(", ");
      builder.append("vector=");
      builder.append(this.vector_);
      builder.append("}");
      return builder.toString();
   }
}

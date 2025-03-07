package geometry_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * This expresses the timestamped velocity vector of a frame 'body_frame_id' in the reference frame 'reference_frame_id' expressed from arbitrary observation frame 'header.frame_id'.
       * - If the 'body_frame_id' and 'header.frame_id' are identical, the velocity is observed and defined in the local coordinates system of the body
       * which is the usual use-case in mobile robotics and is also known as a body twist.
       */
public class VelocityStamped extends Packet<VelocityStamped> implements Settable<VelocityStamped>, EpsilonComparable<VelocityStamped>
{
   public std_msgs.msg.dds.Header header_;
   public java.lang.StringBuilder body_frame_id_;
   public java.lang.StringBuilder reference_frame_id_;
   public geometry_msgs.msg.dds.Twist velocity_;

   public VelocityStamped()
   {
      header_ = new std_msgs.msg.dds.Header();
      body_frame_id_ = new java.lang.StringBuilder(255);
      reference_frame_id_ = new java.lang.StringBuilder(255);
      velocity_ = new geometry_msgs.msg.dds.Twist();
   }

   public VelocityStamped(VelocityStamped other)
   {
      this();
      set(other);
   }

   public void set(VelocityStamped other)
   {
      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
      body_frame_id_.setLength(0);
      body_frame_id_.append(other.body_frame_id_);

      reference_frame_id_.setLength(0);
      reference_frame_id_.append(other.reference_frame_id_);

      geometry_msgs.msg.dds.TwistPubSubType.staticCopy(other.velocity_, velocity_);
   }


   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }

   public void setBodyFrameId(java.lang.String body_frame_id)
   {
      body_frame_id_.setLength(0);
      body_frame_id_.append(body_frame_id);
   }

   public java.lang.String getBodyFrameIdAsString()
   {
      return getBodyFrameId().toString();
   }
   public java.lang.StringBuilder getBodyFrameId()
   {
      return body_frame_id_;
   }

   public void setReferenceFrameId(java.lang.String reference_frame_id)
   {
      reference_frame_id_.setLength(0);
      reference_frame_id_.append(reference_frame_id);
   }

   public java.lang.String getReferenceFrameIdAsString()
   {
      return getReferenceFrameId().toString();
   }
   public java.lang.StringBuilder getReferenceFrameId()
   {
      return reference_frame_id_;
   }


   public geometry_msgs.msg.dds.Twist getVelocity()
   {
      return velocity_;
   }


   public static Supplier<VelocityStampedPubSubType> getPubSubType()
   {
      return VelocityStampedPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return VelocityStampedPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(VelocityStamped other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!this.header_.epsilonEquals(other.header_, epsilon)) return false;
      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.body_frame_id_, other.body_frame_id_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.reference_frame_id_, other.reference_frame_id_, epsilon)) return false;

      if (!this.velocity_.epsilonEquals(other.velocity_, epsilon)) return false;

      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof VelocityStamped)) return false;

      VelocityStamped otherMyClass = (VelocityStamped) other;

      if (!this.header_.equals(otherMyClass.header_)) return false;
      if (!us.ihmc.idl.IDLTools.equals(this.body_frame_id_, otherMyClass.body_frame_id_)) return false;

      if (!us.ihmc.idl.IDLTools.equals(this.reference_frame_id_, otherMyClass.reference_frame_id_)) return false;

      if (!this.velocity_.equals(otherMyClass.velocity_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("VelocityStamped {");
      builder.append("header=");
      builder.append(this.header_);      builder.append(", ");
      builder.append("body_frame_id=");
      builder.append(this.body_frame_id_);      builder.append(", ");
      builder.append("reference_frame_id=");
      builder.append(this.reference_frame_id_);      builder.append(", ");
      builder.append("velocity=");
      builder.append(this.velocity_);
      builder.append("}");
      return builder.toString();
   }
}

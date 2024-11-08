package geometry_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * This expresses a transform from coordinate frame header.frame_id
       * to the coordinate frame child_frame_id at the time of header.stamp
       * 
       * This message is mostly used by the
       * <a href="https://index.ros.org/p/tf2/">tf2</a> package.
       * See its documentation for more information.
       * 
       * The child_frame_id is necessary in addition to the frame_id
       * in the Header to communicate the full reference for the transform
       * in a self contained message.
       */
public class TransformStamped extends Packet<TransformStamped> implements Settable<TransformStamped>, EpsilonComparable<TransformStamped>
{
   /**
            * The frame id in the header is used as the reference frame of this transform.
            */
   public std_msgs.msg.dds.Header header_;
   /**
            * The frame id of the child frame to which this transform points.
            */
   public java.lang.StringBuilder child_frame_id_;
   /**
            * Translation and rotation in 3-dimensions of child_frame_id from header.frame_id.
            */
   public us.ihmc.euclid.transform.QuaternionBasedTransform transform_;

   public TransformStamped()
   {
      header_ = new std_msgs.msg.dds.Header();
      child_frame_id_ = new java.lang.StringBuilder(255);
      transform_ = new us.ihmc.euclid.transform.QuaternionBasedTransform();
   }

   public TransformStamped(TransformStamped other)
   {
      this();
      set(other);
   }

   public void set(TransformStamped other)
   {
      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
      child_frame_id_.setLength(0);
      child_frame_id_.append(other.child_frame_id_);

      geometry_msgs.msg.dds.TransformPubSubType.staticCopy(other.transform_, transform_);
   }


   /**
            * The frame id in the header is used as the reference frame of this transform.
            */
   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }

   /**
            * The frame id of the child frame to which this transform points.
            */
   public void setChildFrameId(java.lang.String child_frame_id)
   {
      child_frame_id_.setLength(0);
      child_frame_id_.append(child_frame_id);
   }

   /**
            * The frame id of the child frame to which this transform points.
            */
   public java.lang.String getChildFrameIdAsString()
   {
      return getChildFrameId().toString();
   }
   /**
            * The frame id of the child frame to which this transform points.
            */
   public java.lang.StringBuilder getChildFrameId()
   {
      return child_frame_id_;
   }


   /**
            * Translation and rotation in 3-dimensions of child_frame_id from header.frame_id.
            */
   public us.ihmc.euclid.transform.QuaternionBasedTransform getTransform()
   {
      return transform_;
   }


   public static Supplier<TransformStampedPubSubType> getPubSubType()
   {
      return TransformStampedPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return TransformStampedPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(TransformStamped other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!this.header_.epsilonEquals(other.header_, epsilon)) return false;
      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.child_frame_id_, other.child_frame_id_, epsilon)) return false;

      if (!this.transform_.epsilonEquals(other.transform_, epsilon)) return false;

      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof TransformStamped)) return false;

      TransformStamped otherMyClass = (TransformStamped) other;

      if (!this.header_.equals(otherMyClass.header_)) return false;
      if (!us.ihmc.idl.IDLTools.equals(this.child_frame_id_, otherMyClass.child_frame_id_)) return false;

      if (!this.transform_.equals(otherMyClass.transform_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("TransformStamped {");
      builder.append("header=");
      builder.append(this.header_);      builder.append(", ");
      builder.append("child_frame_id=");
      builder.append(this.child_frame_id_);      builder.append(", ");
      builder.append("transform=");
      builder.append(this.transform_);
      builder.append("}");
      return builder.toString();
   }
}

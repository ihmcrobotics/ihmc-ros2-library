package trajectory_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * A representation of a multi-dof joint trajectory (each point is a transformation)
       * Each point along the trajectory will include an array of positions/velocities/accelerations
       * that has the same length as the array of joint names, and has the same order of joints as
       * the joint names array.
       */
public class MultiDOFJointTrajectory extends Packet<MultiDOFJointTrajectory> implements Settable<MultiDOFJointTrajectory>, EpsilonComparable<MultiDOFJointTrajectory>
{
   /**
            * The header is used to specify the coordinate frame and the reference time for the trajectory durations
            */
   public std_msgs.msg.dds.Header header_;
   public us.ihmc.idl.IDLSequence.StringBuilderHolder  joint_names_;
   public us.ihmc.idl.IDLSequence.Object<trajectory_msgs.msg.dds.MultiDOFJointTrajectoryPoint>  points_;

   public MultiDOFJointTrajectory()
   {
      header_ = new std_msgs.msg.dds.Header();
      joint_names_ = new us.ihmc.idl.IDLSequence.StringBuilderHolder (100, "type_d");
      points_ = new us.ihmc.idl.IDLSequence.Object<trajectory_msgs.msg.dds.MultiDOFJointTrajectoryPoint> (100, new trajectory_msgs.msg.dds.MultiDOFJointTrajectoryPointPubSubType());

   }

   public MultiDOFJointTrajectory(MultiDOFJointTrajectory other)
   {
      this();
      set(other);
   }

   public void set(MultiDOFJointTrajectory other)
   {
      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
      joint_names_.set(other.joint_names_);
      points_.set(other.points_);
   }


   /**
            * The header is used to specify the coordinate frame and the reference time for the trajectory durations
            */
   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }


   public us.ihmc.idl.IDLSequence.StringBuilderHolder  getJointNames()
   {
      return joint_names_;
   }


   public us.ihmc.idl.IDLSequence.Object<trajectory_msgs.msg.dds.MultiDOFJointTrajectoryPoint>  getPoints()
   {
      return points_;
   }


   public static Supplier<MultiDOFJointTrajectoryPubSubType> getPubSubType()
   {
      return MultiDOFJointTrajectoryPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return MultiDOFJointTrajectoryPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(MultiDOFJointTrajectory other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!this.header_.epsilonEquals(other.header_, epsilon)) return false;
      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilderSequence(this.joint_names_, other.joint_names_, epsilon)) return false;

      if (this.points_.size() != other.points_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.points_.size(); i++)
         {  if (!this.points_.get(i).epsilonEquals(other.points_.get(i), epsilon)) return false; }
      }


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof MultiDOFJointTrajectory)) return false;

      MultiDOFJointTrajectory otherMyClass = (MultiDOFJointTrajectory) other;

      if (!this.header_.equals(otherMyClass.header_)) return false;
      if (!this.joint_names_.equals(otherMyClass.joint_names_)) return false;
      if (!this.points_.equals(otherMyClass.points_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("MultiDOFJointTrajectory {");
      builder.append("header=");
      builder.append(this.header_);      builder.append(", ");
      builder.append("joint_names=");
      builder.append(this.joint_names_);      builder.append(", ");
      builder.append("points=");
      builder.append(this.points_);
      builder.append("}");
      return builder.toString();
   }
}

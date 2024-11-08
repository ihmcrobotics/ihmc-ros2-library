package trajectory_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

public class MultiDOFJointTrajectoryPoint extends Packet<MultiDOFJointTrajectoryPoint> implements Settable<MultiDOFJointTrajectoryPoint>, EpsilonComparable<MultiDOFJointTrajectoryPoint>
{
   /**
            * Each multi-dof joint can specify a transform (up to 6 DOF).
            */
   public us.ihmc.idl.IDLSequence.Object<us.ihmc.euclid.transform.QuaternionBasedTransform>  transforms_;
   /**
            * There can be a velocity specified for the origin of the joint.
            */
   public us.ihmc.idl.IDLSequence.Object<geometry_msgs.msg.dds.Twist>  velocities_;
   /**
            * There can be an acceleration specified for the origin of the joint.
            */
   public us.ihmc.idl.IDLSequence.Object<geometry_msgs.msg.dds.Twist>  accelerations_;
   /**
            * Desired time from the trajectory start to arrive at this trajectory point.
            */
   public builtin_interfaces.msg.dds.Duration time_from_start_;

   public MultiDOFJointTrajectoryPoint()
   {
      transforms_ = new us.ihmc.idl.IDLSequence.Object<us.ihmc.euclid.transform.QuaternionBasedTransform> (100, new geometry_msgs.msg.dds.TransformPubSubType());
      velocities_ = new us.ihmc.idl.IDLSequence.Object<geometry_msgs.msg.dds.Twist> (100, new geometry_msgs.msg.dds.TwistPubSubType());
      accelerations_ = new us.ihmc.idl.IDLSequence.Object<geometry_msgs.msg.dds.Twist> (100, new geometry_msgs.msg.dds.TwistPubSubType());
      time_from_start_ = new builtin_interfaces.msg.dds.Duration();

   }

   public MultiDOFJointTrajectoryPoint(MultiDOFJointTrajectoryPoint other)
   {
      this();
      set(other);
   }

   public void set(MultiDOFJointTrajectoryPoint other)
   {
      transforms_.set(other.transforms_);
      velocities_.set(other.velocities_);
      accelerations_.set(other.accelerations_);
      builtin_interfaces.msg.dds.DurationPubSubType.staticCopy(other.time_from_start_, time_from_start_);
   }


   /**
            * Each multi-dof joint can specify a transform (up to 6 DOF).
            */
   public us.ihmc.idl.IDLSequence.Object<us.ihmc.euclid.transform.QuaternionBasedTransform>  getTransforms()
   {
      return transforms_;
   }


   /**
            * There can be a velocity specified for the origin of the joint.
            */
   public us.ihmc.idl.IDLSequence.Object<geometry_msgs.msg.dds.Twist>  getVelocities()
   {
      return velocities_;
   }


   /**
            * There can be an acceleration specified for the origin of the joint.
            */
   public us.ihmc.idl.IDLSequence.Object<geometry_msgs.msg.dds.Twist>  getAccelerations()
   {
      return accelerations_;
   }


   /**
            * Desired time from the trajectory start to arrive at this trajectory point.
            */
   public builtin_interfaces.msg.dds.Duration getTimeFromStart()
   {
      return time_from_start_;
   }


   public static Supplier<MultiDOFJointTrajectoryPointPubSubType> getPubSubType()
   {
      return MultiDOFJointTrajectoryPointPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return MultiDOFJointTrajectoryPointPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(MultiDOFJointTrajectoryPoint other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (this.transforms_.size() != other.transforms_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.transforms_.size(); i++)
         {  if (!this.transforms_.get(i).epsilonEquals(other.transforms_.get(i), epsilon)) return false; }
      }

      if (this.velocities_.size() != other.velocities_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.velocities_.size(); i++)
         {  if (!this.velocities_.get(i).epsilonEquals(other.velocities_.get(i), epsilon)) return false; }
      }

      if (this.accelerations_.size() != other.accelerations_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.accelerations_.size(); i++)
         {  if (!this.accelerations_.get(i).epsilonEquals(other.accelerations_.get(i), epsilon)) return false; }
      }

      if (!this.time_from_start_.epsilonEquals(other.time_from_start_, epsilon)) return false;

      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof MultiDOFJointTrajectoryPoint)) return false;

      MultiDOFJointTrajectoryPoint otherMyClass = (MultiDOFJointTrajectoryPoint) other;

      if (!this.transforms_.equals(otherMyClass.transforms_)) return false;
      if (!this.velocities_.equals(otherMyClass.velocities_)) return false;
      if (!this.accelerations_.equals(otherMyClass.accelerations_)) return false;
      if (!this.time_from_start_.equals(otherMyClass.time_from_start_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("MultiDOFJointTrajectoryPoint {");
      builder.append("transforms=");
      builder.append(this.transforms_);      builder.append(", ");
      builder.append("velocities=");
      builder.append(this.velocities_);      builder.append(", ");
      builder.append("accelerations=");
      builder.append(this.accelerations_);      builder.append(", ");
      builder.append("time_from_start=");
      builder.append(this.time_from_start_);
      builder.append("}");
      return builder.toString();
   }
}

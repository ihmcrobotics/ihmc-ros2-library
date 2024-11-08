package trajectory_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * Each trajectory point specifies either positions[, velocities[, accelerations]]
       * or positions[, effort] for the trajectory to be executed.
       * All specified values are in the same order as the joint names in JointTrajectory.msg.
       */
public class JointTrajectoryPoint extends Packet<JointTrajectoryPoint> implements Settable<JointTrajectoryPoint>, EpsilonComparable<JointTrajectoryPoint>
{
   /**
            * Single DOF joint positions for each joint relative to their "0" position.
            * The units depend on the specific joint type: radians for revolute or
            * continuous joints, and meters for prismatic joints.
            */
   public us.ihmc.idl.IDLSequence.Double  positions_;
   /**
            * The rate of change in position of each joint. Units are joint type dependent.
            * Radians/second for revolute or continuous joints, and meters/second for
            * prismatic joints.
            */
   public us.ihmc.idl.IDLSequence.Double  velocities_;
   /**
            * Rate of change in velocity of each joint. Units are joint type dependent.
            * Radians/second^2 for revolute or continuous joints, and meters/second^2 for
            * prismatic joints.
            */
   public us.ihmc.idl.IDLSequence.Double  accelerations_;
   /**
            * The torque or the force to be applied at each joint. For revolute/continuous
            * joints effort denotes a torque in newton-meters. For prismatic joints, effort
            * denotes a force in newtons.
            */
   public us.ihmc.idl.IDLSequence.Double  effort_;
   /**
            * Desired time from the trajectory start to arrive at this trajectory point.
            */
   public builtin_interfaces.msg.dds.Duration time_from_start_;

   public JointTrajectoryPoint()
   {
      positions_ = new us.ihmc.idl.IDLSequence.Double (100, "type_6");

      velocities_ = new us.ihmc.idl.IDLSequence.Double (100, "type_6");

      accelerations_ = new us.ihmc.idl.IDLSequence.Double (100, "type_6");

      effort_ = new us.ihmc.idl.IDLSequence.Double (100, "type_6");

      time_from_start_ = new builtin_interfaces.msg.dds.Duration();
   }

   public JointTrajectoryPoint(JointTrajectoryPoint other)
   {
      this();
      set(other);
   }

   public void set(JointTrajectoryPoint other)
   {
      positions_.set(other.positions_);
      velocities_.set(other.velocities_);
      accelerations_.set(other.accelerations_);
      effort_.set(other.effort_);
      builtin_interfaces.msg.dds.DurationPubSubType.staticCopy(other.time_from_start_, time_from_start_);
   }


   /**
            * Single DOF joint positions for each joint relative to their "0" position.
            * The units depend on the specific joint type: radians for revolute or
            * continuous joints, and meters for prismatic joints.
            */
   public us.ihmc.idl.IDLSequence.Double  getPositions()
   {
      return positions_;
   }


   /**
            * The rate of change in position of each joint. Units are joint type dependent.
            * Radians/second for revolute or continuous joints, and meters/second for
            * prismatic joints.
            */
   public us.ihmc.idl.IDLSequence.Double  getVelocities()
   {
      return velocities_;
   }


   /**
            * Rate of change in velocity of each joint. Units are joint type dependent.
            * Radians/second^2 for revolute or continuous joints, and meters/second^2 for
            * prismatic joints.
            */
   public us.ihmc.idl.IDLSequence.Double  getAccelerations()
   {
      return accelerations_;
   }


   /**
            * The torque or the force to be applied at each joint. For revolute/continuous
            * joints effort denotes a torque in newton-meters. For prismatic joints, effort
            * denotes a force in newtons.
            */
   public us.ihmc.idl.IDLSequence.Double  getEffort()
   {
      return effort_;
   }


   /**
            * Desired time from the trajectory start to arrive at this trajectory point.
            */
   public builtin_interfaces.msg.dds.Duration getTimeFromStart()
   {
      return time_from_start_;
   }


   public static Supplier<JointTrajectoryPointPubSubType> getPubSubType()
   {
      return JointTrajectoryPointPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return JointTrajectoryPointPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(JointTrajectoryPoint other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsDoubleSequence(this.positions_, other.positions_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsDoubleSequence(this.velocities_, other.velocities_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsDoubleSequence(this.accelerations_, other.accelerations_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsDoubleSequence(this.effort_, other.effort_, epsilon)) return false;

      if (!this.time_from_start_.epsilonEquals(other.time_from_start_, epsilon)) return false;

      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof JointTrajectoryPoint)) return false;

      JointTrajectoryPoint otherMyClass = (JointTrajectoryPoint) other;

      if (!this.positions_.equals(otherMyClass.positions_)) return false;
      if (!this.velocities_.equals(otherMyClass.velocities_)) return false;
      if (!this.accelerations_.equals(otherMyClass.accelerations_)) return false;
      if (!this.effort_.equals(otherMyClass.effort_)) return false;
      if (!this.time_from_start_.equals(otherMyClass.time_from_start_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("JointTrajectoryPoint {");
      builder.append("positions=");
      builder.append(this.positions_);      builder.append(", ");
      builder.append("velocities=");
      builder.append(this.velocities_);      builder.append(", ");
      builder.append("accelerations=");
      builder.append(this.accelerations_);      builder.append(", ");
      builder.append("effort=");
      builder.append(this.effort_);      builder.append(", ");
      builder.append("time_from_start=");
      builder.append(this.time_from_start_);
      builder.append("}");
      return builder.toString();
   }
}

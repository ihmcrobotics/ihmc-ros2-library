package sensor_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * Representation of state for joints with multiple degrees of freedom,
       * following the structure of JointState which can only represent a single degree of freedom.
       * 
       * It is assumed that a joint in a system corresponds to a transform that gets applied
       * along the kinematic chain. For example, a planar joint (as in URDF) is 3DOF (x, y, yaw)
       * and those 3DOF can be expressed as a transformation matrix, and that transformation
       * matrix can be converted back to (x, y, yaw)
       * 
       * Each joint is uniquely identified by its name
       * The header specifies the time at which the joint states were recorded. All the joint states
       * in one message have to be recorded at the same time.
       * 
       * This message consists of a multiple arrays, one for each part of the joint state.
       * The goal is to make each of the fields optional. When e.g. your joints have no
       * wrench associated with them, you can leave the wrench array empty.
       * 
       * All arrays in this message should have the same size, or be empty.
       * This is the only way to uniquely associate the joint name with the correct
       * states.
       */
public class MultiDOFJointState extends Packet<MultiDOFJointState> implements Settable<MultiDOFJointState>, EpsilonComparable<MultiDOFJointState>
{
   public std_msgs.msg.dds.Header header_;
   public us.ihmc.idl.IDLSequence.StringBuilderHolder  joint_names_;
   public us.ihmc.idl.IDLSequence.Object<us.ihmc.euclid.transform.QuaternionBasedTransform>  transforms_;
   public us.ihmc.idl.IDLSequence.Object<geometry_msgs.msg.dds.Twist>  twist_;
   public us.ihmc.idl.IDLSequence.Object<geometry_msgs.msg.dds.Wrench>  wrench_;

   public MultiDOFJointState()
   {
      header_ = new std_msgs.msg.dds.Header();
      joint_names_ = new us.ihmc.idl.IDLSequence.StringBuilderHolder (100, "type_d");
      transforms_ = new us.ihmc.idl.IDLSequence.Object<us.ihmc.euclid.transform.QuaternionBasedTransform> (100, new geometry_msgs.msg.dds.TransformPubSubType());
      twist_ = new us.ihmc.idl.IDLSequence.Object<geometry_msgs.msg.dds.Twist> (100, new geometry_msgs.msg.dds.TwistPubSubType());
      wrench_ = new us.ihmc.idl.IDLSequence.Object<geometry_msgs.msg.dds.Wrench> (100, new geometry_msgs.msg.dds.WrenchPubSubType());

   }

   public MultiDOFJointState(MultiDOFJointState other)
   {
      this();
      set(other);
   }

   public void set(MultiDOFJointState other)
   {
      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
      joint_names_.set(other.joint_names_);
      transforms_.set(other.transforms_);
      twist_.set(other.twist_);
      wrench_.set(other.wrench_);
   }


   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }


   public us.ihmc.idl.IDLSequence.StringBuilderHolder  getJointNames()
   {
      return joint_names_;
   }


   public us.ihmc.idl.IDLSequence.Object<us.ihmc.euclid.transform.QuaternionBasedTransform>  getTransforms()
   {
      return transforms_;
   }


   public us.ihmc.idl.IDLSequence.Object<geometry_msgs.msg.dds.Twist>  getTwist()
   {
      return twist_;
   }


   public us.ihmc.idl.IDLSequence.Object<geometry_msgs.msg.dds.Wrench>  getWrench()
   {
      return wrench_;
   }


   public static Supplier<MultiDOFJointStatePubSubType> getPubSubType()
   {
      return MultiDOFJointStatePubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return MultiDOFJointStatePubSubType::new;
   }

   @Override
   public boolean epsilonEquals(MultiDOFJointState other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!this.header_.epsilonEquals(other.header_, epsilon)) return false;
      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilderSequence(this.joint_names_, other.joint_names_, epsilon)) return false;

      if (this.transforms_.size() != other.transforms_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.transforms_.size(); i++)
         {  if (!this.transforms_.get(i).epsilonEquals(other.transforms_.get(i), epsilon)) return false; }
      }

      if (this.twist_.size() != other.twist_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.twist_.size(); i++)
         {  if (!this.twist_.get(i).epsilonEquals(other.twist_.get(i), epsilon)) return false; }
      }

      if (this.wrench_.size() != other.wrench_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.wrench_.size(); i++)
         {  if (!this.wrench_.get(i).epsilonEquals(other.wrench_.get(i), epsilon)) return false; }
      }


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof MultiDOFJointState)) return false;

      MultiDOFJointState otherMyClass = (MultiDOFJointState) other;

      if (!this.header_.equals(otherMyClass.header_)) return false;
      if (!this.joint_names_.equals(otherMyClass.joint_names_)) return false;
      if (!this.transforms_.equals(otherMyClass.transforms_)) return false;
      if (!this.twist_.equals(otherMyClass.twist_)) return false;
      if (!this.wrench_.equals(otherMyClass.wrench_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("MultiDOFJointState {");
      builder.append("header=");
      builder.append(this.header_);      builder.append(", ");
      builder.append("joint_names=");
      builder.append(this.joint_names_);      builder.append(", ");
      builder.append("transforms=");
      builder.append(this.transforms_);      builder.append(", ");
      builder.append("twist=");
      builder.append(this.twist_);      builder.append(", ");
      builder.append("wrench=");
      builder.append(this.wrench_);
      builder.append("}");
      return builder.toString();
   }
}

package nav_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * An array of navigation goals
       */
public class Goals extends Packet<Goals> implements Settable<Goals>, EpsilonComparable<Goals>
{
   /**
            * This header will store the time at which the poses were computed (not to be confused with the stamps of the poses themselves)
            * In the case that individual poses do not have their frame_id set or their timetamp set they will use the default value here.
            */
   public std_msgs.msg.dds.Header header_;
   /**
            * An array of goals to for navigation to achieve.
            * The goals should be executed in the order of the array.
            * The header and stamp are intended to be used for computing the position of the goals.
            * They may vary to support cases of goals that are moving with respect to the robot.
            */
   public us.ihmc.idl.IDLSequence.Object<geometry_msgs.msg.dds.PoseStamped>  goals_;

   public Goals()
   {
      header_ = new std_msgs.msg.dds.Header();
      goals_ = new us.ihmc.idl.IDLSequence.Object<geometry_msgs.msg.dds.PoseStamped> (100, new geometry_msgs.msg.dds.PoseStampedPubSubType());

   }

   public Goals(Goals other)
   {
      this();
      set(other);
   }

   public void set(Goals other)
   {
      std_msgs.msg.dds.HeaderPubSubType.staticCopy(other.header_, header_);
      goals_.set(other.goals_);
   }


   /**
            * This header will store the time at which the poses were computed (not to be confused with the stamps of the poses themselves)
            * In the case that individual poses do not have their frame_id set or their timetamp set they will use the default value here.
            */
   public std_msgs.msg.dds.Header getHeader()
   {
      return header_;
   }


   /**
            * An array of goals to for navigation to achieve.
            * The goals should be executed in the order of the array.
            * The header and stamp are intended to be used for computing the position of the goals.
            * They may vary to support cases of goals that are moving with respect to the robot.
            */
   public us.ihmc.idl.IDLSequence.Object<geometry_msgs.msg.dds.PoseStamped>  getGoals()
   {
      return goals_;
   }


   public static Supplier<GoalsPubSubType> getPubSubType()
   {
      return GoalsPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return GoalsPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(Goals other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!this.header_.epsilonEquals(other.header_, epsilon)) return false;
      if (this.goals_.size() != other.goals_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.goals_.size(); i++)
         {  if (!this.goals_.get(i).epsilonEquals(other.goals_.get(i), epsilon)) return false; }
      }


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof Goals)) return false;

      Goals otherMyClass = (Goals) other;

      if (!this.header_.equals(otherMyClass.header_)) return false;
      if (!this.goals_.equals(otherMyClass.goals_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("Goals {");
      builder.append("header=");
      builder.append(this.header_);      builder.append(", ");
      builder.append("goals=");
      builder.append(this.goals_);
      builder.append("}");
      return builder.toString();
   }
}

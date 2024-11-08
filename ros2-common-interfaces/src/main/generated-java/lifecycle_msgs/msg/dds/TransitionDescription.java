package lifecycle_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

public class TransitionDescription extends Packet<TransitionDescription> implements Settable<TransitionDescription>, EpsilonComparable<TransitionDescription>
{
   /**
            * The transition id and label of this description.
            */
   public lifecycle_msgs.msg.dds.Transition transition_;
   /**
            * The current state from which this transition transitions.
            */
   public lifecycle_msgs.msg.dds.State start_state_;
   /**
            * The desired target state of this transition.
            */
   public lifecycle_msgs.msg.dds.State goal_state_;

   public TransitionDescription()
   {
      transition_ = new lifecycle_msgs.msg.dds.Transition();
      start_state_ = new lifecycle_msgs.msg.dds.State();
      goal_state_ = new lifecycle_msgs.msg.dds.State();
   }

   public TransitionDescription(TransitionDescription other)
   {
      this();
      set(other);
   }

   public void set(TransitionDescription other)
   {
      lifecycle_msgs.msg.dds.TransitionPubSubType.staticCopy(other.transition_, transition_);
      lifecycle_msgs.msg.dds.StatePubSubType.staticCopy(other.start_state_, start_state_);
      lifecycle_msgs.msg.dds.StatePubSubType.staticCopy(other.goal_state_, goal_state_);
   }


   /**
            * The transition id and label of this description.
            */
   public lifecycle_msgs.msg.dds.Transition getTransition()
   {
      return transition_;
   }


   /**
            * The current state from which this transition transitions.
            */
   public lifecycle_msgs.msg.dds.State getStartState()
   {
      return start_state_;
   }


   /**
            * The desired target state of this transition.
            */
   public lifecycle_msgs.msg.dds.State getGoalState()
   {
      return goal_state_;
   }


   public static Supplier<TransitionDescriptionPubSubType> getPubSubType()
   {
      return TransitionDescriptionPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return TransitionDescriptionPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(TransitionDescription other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!this.transition_.epsilonEquals(other.transition_, epsilon)) return false;
      if (!this.start_state_.epsilonEquals(other.start_state_, epsilon)) return false;
      if (!this.goal_state_.epsilonEquals(other.goal_state_, epsilon)) return false;

      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof TransitionDescription)) return false;

      TransitionDescription otherMyClass = (TransitionDescription) other;

      if (!this.transition_.equals(otherMyClass.transition_)) return false;
      if (!this.start_state_.equals(otherMyClass.start_state_)) return false;
      if (!this.goal_state_.equals(otherMyClass.goal_state_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("TransitionDescription {");
      builder.append("transition=");
      builder.append(this.transition_);      builder.append(", ");
      builder.append("start_state=");
      builder.append(this.start_state_);      builder.append(", ");
      builder.append("goal_state=");
      builder.append(this.goal_state_);
      builder.append("}");
      return builder.toString();
   }
}

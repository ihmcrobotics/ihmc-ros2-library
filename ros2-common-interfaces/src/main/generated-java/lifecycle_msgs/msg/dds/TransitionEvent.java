package lifecycle_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

public class TransitionEvent extends Packet<TransitionEvent> implements Settable<TransitionEvent>, EpsilonComparable<TransitionEvent>
{
   /**
            * The time point at which this event occurred.
            */
   public long timestamp_;
   /**
            * The id and label of this transition event.
            */
   public lifecycle_msgs.msg.dds.Transition transition_;
   /**
            * The starting state from which this event transitioned.
            */
   public lifecycle_msgs.msg.dds.State start_state_;
   /**
            * The end state of this transition event.
            */
   public lifecycle_msgs.msg.dds.State goal_state_;

   public TransitionEvent()
   {
      transition_ = new lifecycle_msgs.msg.dds.Transition();
      start_state_ = new lifecycle_msgs.msg.dds.State();
      goal_state_ = new lifecycle_msgs.msg.dds.State();
   }

   public TransitionEvent(TransitionEvent other)
   {
      this();
      set(other);
   }

   public void set(TransitionEvent other)
   {
      timestamp_ = other.timestamp_;

      lifecycle_msgs.msg.dds.TransitionPubSubType.staticCopy(other.transition_, transition_);
      lifecycle_msgs.msg.dds.StatePubSubType.staticCopy(other.start_state_, start_state_);
      lifecycle_msgs.msg.dds.StatePubSubType.staticCopy(other.goal_state_, goal_state_);
   }

   /**
            * The time point at which this event occurred.
            */
   public void setTimestamp(long timestamp)
   {
      timestamp_ = timestamp;
   }
   /**
            * The time point at which this event occurred.
            */
   public long getTimestamp()
   {
      return timestamp_;
   }


   /**
            * The id and label of this transition event.
            */
   public lifecycle_msgs.msg.dds.Transition getTransition()
   {
      return transition_;
   }


   /**
            * The starting state from which this event transitioned.
            */
   public lifecycle_msgs.msg.dds.State getStartState()
   {
      return start_state_;
   }


   /**
            * The end state of this transition event.
            */
   public lifecycle_msgs.msg.dds.State getGoalState()
   {
      return goal_state_;
   }


   public static Supplier<TransitionEventPubSubType> getPubSubType()
   {
      return TransitionEventPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return TransitionEventPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(TransitionEvent other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.timestamp_, other.timestamp_, epsilon)) return false;

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
      if(!(other instanceof TransitionEvent)) return false;

      TransitionEvent otherMyClass = (TransitionEvent) other;

      if(this.timestamp_ != otherMyClass.timestamp_) return false;

      if (!this.transition_.equals(otherMyClass.transition_)) return false;
      if (!this.start_state_.equals(otherMyClass.start_state_)) return false;
      if (!this.goal_state_.equals(otherMyClass.goal_state_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("TransitionEvent {");
      builder.append("timestamp=");
      builder.append(this.timestamp_);      builder.append(", ");
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

package lifecycle_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * Primary state definitions as depicted in:
       * http://design.ros2.org/articles/node_lifecycle.html
       * These are the primary states. State changes can only be requested when the
       * node is in one of these states.
       * Temporary intermediate states. When a transition is requested, the node
       * changes its state into one of these states.
       */
public class State extends Packet<State> implements Settable<State>, EpsilonComparable<State>
{
   /**
          * Indicates state has not yet been set.
          */
   public static final byte PRIMARY_STATE_UNKNOWN = (byte) 0;
   /**
          * This is the life cycle state the node is in immediately after being
          * instantiated.
          */
   public static final byte PRIMARY_STATE_UNCONFIGURED = (byte) 1;
   /**
          * This state represents a node that is not currently performing any processing.
          */
   public static final byte PRIMARY_STATE_INACTIVE = (byte) 2;
   /**
          * This is the main state of the node's life cycle. While in this state, the node
          * performs any processing, responds to service requests, reads and processes
          * data, produces output, etc.
          */
   public static final byte PRIMARY_STATE_ACTIVE = (byte) 3;
   /**
          * The finalized state is the state in which the node ends immediately before
          * being destroyed.
          */
   public static final byte PRIMARY_STATE_FINALIZED = (byte) 4;
   /**
          * In this transition state the node's onConfigure callback will be called to
          * allow the node to load its configuration and conduct any required setup.
          */
   public static final byte TRANSITION_STATE_CONFIGURING = (byte) 10;
   /**
          * In this transition state the node's callback onCleanup will be called to clear
          * all state and return the node to a functionally equivalent state as when
          * first created.
          */
   public static final byte TRANSITION_STATE_CLEANINGUP = (byte) 11;
   /**
          * In this transition state the callback onShutdown will be executed to do any
          * cleanup necessary before destruction.
          */
   public static final byte TRANSITION_STATE_SHUTTINGDOWN = (byte) 12;
   /**
          * In this transition state the callback onActivate will be executed to do any
          * final preparations to start executing.
          */
   public static final byte TRANSITION_STATE_ACTIVATING = (byte) 13;
   /**
          * In this transition state the callback onDeactivate will be executed to do any
          * cleanup to start executing, and reverse the onActivate changes.
          */
   public static final byte TRANSITION_STATE_DEACTIVATING = (byte) 14;
   /**
          * This transition state is where any error may be cleaned up.
          */
   public static final byte TRANSITION_STATE_ERRORPROCESSING = (byte) 15;
   /**
            * The state id value from the above definitions.
            */
   public byte id_;
   /**
            * A text label of the state.
            */
   public java.lang.StringBuilder label_;

   public State()
   {
      label_ = new java.lang.StringBuilder(255);
   }

   public State(State other)
   {
      this();
      set(other);
   }

   public void set(State other)
   {
      id_ = other.id_;

      label_.setLength(0);
      label_.append(other.label_);

   }

   /**
            * The state id value from the above definitions.
            */
   public void setId(byte id)
   {
      id_ = id;
   }
   /**
            * The state id value from the above definitions.
            */
   public byte getId()
   {
      return id_;
   }

   /**
            * A text label of the state.
            */
   public void setLabel(java.lang.String label)
   {
      label_.setLength(0);
      label_.append(label);
   }

   /**
            * A text label of the state.
            */
   public java.lang.String getLabelAsString()
   {
      return getLabel().toString();
   }
   /**
            * A text label of the state.
            */
   public java.lang.StringBuilder getLabel()
   {
      return label_;
   }


   public static Supplier<StatePubSubType> getPubSubType()
   {
      return StatePubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return StatePubSubType::new;
   }

   @Override
   public boolean epsilonEquals(State other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.id_, other.id_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.label_, other.label_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof State)) return false;

      State otherMyClass = (State) other;

      if(this.id_ != otherMyClass.id_) return false;

      if (!us.ihmc.idl.IDLTools.equals(this.label_, otherMyClass.label_)) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("State {");
      builder.append("id=");
      builder.append(this.id_);      builder.append(", ");
      builder.append("label=");
      builder.append(this.label_);
      builder.append("}");
      return builder.toString();
   }
}

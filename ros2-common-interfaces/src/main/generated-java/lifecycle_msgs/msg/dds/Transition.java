package lifecycle_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * Default values for transitions as described in:
       * http://design.ros2.org/articles/node_lifecycle.html
       * Reserved [0-9], publicly available transitions.
       * When a node is in one of these primary states, these transitions can be
       * invoked.
       * Reserved [90-99]. Transition callback success values.
       * These return values ought to be set as a return value for each callback.
       * Depending on which return value, the transition will be executed correctly or
       * fallback/error callbacks will be triggered.
       * #
       * # Fields
       * #
       */
public class Transition extends Packet<Transition> implements Settable<Transition>, EpsilonComparable<Transition>
{
   /**
          * This transition will instantiate the node, but will not run any code beyond
          * the constructor.
          */
   public static final byte TRANSITION_CREATE = (byte) 0;
   /**
          * The node's onConfigure callback will be called to allow the node to load its
          * configuration and conduct any required setup.
          */
   public static final byte TRANSITION_CONFIGURE = (byte) 1;
   /**
          * The node's callback onCleanup will be called in this transition to allow the
          * node to load its configuration and conduct any required setup.
          */
   public static final byte TRANSITION_CLEANUP = (byte) 2;
   /**
          * The node's callback onActivate will be executed to do any final preparations
          * to start executing.
          */
   public static final byte TRANSITION_ACTIVATE = (byte) 3;
   /**
          * The node's callback onDeactivate will be executed to do any cleanup to start
          * executing, and reverse the onActivate changes.
          */
   public static final byte TRANSITION_DEACTIVATE = (byte) 4;
   /**
          * This signals shutdown during an unconfigured state, the node's callback
          * onShutdown will be executed to do any cleanup necessary before destruction.
          */
   public static final byte TRANSITION_UNCONFIGURED_SHUTDOWN = (byte) 5;
   /**
          * This signals shutdown during an inactive state, the node's callback onShutdown
          * will be executed to do any cleanup necessary before destruction.
          */
   public static final byte TRANSITION_INACTIVE_SHUTDOWN = (byte) 6;
   /**
          * This signals shutdown during an active state, the node's callback onShutdown
          * will be executed to do any cleanup necessary before destruction.
          */
   public static final byte TRANSITION_ACTIVE_SHUTDOWN = (byte) 7;
   /**
          * This transition will simply cause the deallocation of the node.
          */
   public static final byte TRANSITION_DESTROY = (byte) 8;
   /**
          * Reserved [10-69], private transitions
          * These transitions are not publicly available and cannot be invoked by a user.
          * The following transitions are implicitly invoked based on the callback
          * feedback of the intermediate transition states.
          */
   public static final byte TRANSITION_ON_CONFIGURE_SUCCESS = (byte) 10;
   public static final byte TRANSITION_ON_CONFIGURE_FAILURE = (byte) 11;
   public static final byte TRANSITION_ON_CONFIGURE_ERROR = (byte) 12;
   public static final byte TRANSITION_ON_CLEANUP_SUCCESS = (byte) 20;
   public static final byte TRANSITION_ON_CLEANUP_FAILURE = (byte) 21;
   public static final byte TRANSITION_ON_CLEANUP_ERROR = (byte) 22;
   public static final byte TRANSITION_ON_ACTIVATE_SUCCESS = (byte) 30;
   public static final byte TRANSITION_ON_ACTIVATE_FAILURE = (byte) 31;
   public static final byte TRANSITION_ON_ACTIVATE_ERROR = (byte) 32;
   public static final byte TRANSITION_ON_DEACTIVATE_SUCCESS = (byte) 40;
   public static final byte TRANSITION_ON_DEACTIVATE_FAILURE = (byte) 41;
   public static final byte TRANSITION_ON_DEACTIVATE_ERROR = (byte) 42;
   public static final byte TRANSITION_ON_SHUTDOWN_SUCCESS = (byte) 50;
   public static final byte TRANSITION_ON_SHUTDOWN_FAILURE = (byte) 51;
   public static final byte TRANSITION_ON_SHUTDOWN_ERROR = (byte) 52;
   public static final byte TRANSITION_ON_ERROR_SUCCESS = (byte) 60;
   public static final byte TRANSITION_ON_ERROR_FAILURE = (byte) 61;
   public static final byte TRANSITION_ON_ERROR_ERROR = (byte) 62;
   /**
          * The transition callback successfully performed its required functionality.
          */
   public static final byte TRANSITION_CALLBACK_SUCCESS = (byte) 97;
   /**
          * The transition callback failed to perform its required functionality.
          */
   public static final byte TRANSITION_CALLBACK_FAILURE = (byte) 98;
   /**
          * The transition callback encountered an error that requires special cleanup, if
          * possible.
          */
   public static final byte TRANSITION_CALLBACK_ERROR = (byte) 99;
   /**
            * The transition id from above definitions.
            */
   public byte id_;
   /**
            * A text label of the transition.
            */
   public java.lang.StringBuilder label_;

   public Transition()
   {
      label_ = new java.lang.StringBuilder(255);
   }

   public Transition(Transition other)
   {
      this();
      set(other);
   }

   public void set(Transition other)
   {
      id_ = other.id_;

      label_.setLength(0);
      label_.append(other.label_);

   }

   /**
            * The transition id from above definitions.
            */
   public void setId(byte id)
   {
      id_ = id;
   }
   /**
            * The transition id from above definitions.
            */
   public byte getId()
   {
      return id_;
   }

   /**
            * A text label of the transition.
            */
   public void setLabel(java.lang.String label)
   {
      label_.setLength(0);
      label_.append(label);
   }

   /**
            * A text label of the transition.
            */
   public java.lang.String getLabelAsString()
   {
      return getLabel().toString();
   }
   /**
            * A text label of the transition.
            */
   public java.lang.StringBuilder getLabel()
   {
      return label_;
   }


   public static Supplier<TransitionPubSubType> getPubSubType()
   {
      return TransitionPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return TransitionPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(Transition other, double epsilon)
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
      if(!(other instanceof Transition)) return false;

      Transition otherMyClass = (Transition) other;

      if(this.id_ != otherMyClass.id_) return false;

      if (!us.ihmc.idl.IDLTools.equals(this.label_, otherMyClass.label_)) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("Transition {");
      builder.append("id=");
      builder.append(this.id_);      builder.append(", ");
      builder.append("label=");
      builder.append(this.label_);
      builder.append("}");
      return builder.toString();
   }
}

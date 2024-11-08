package rcl_interfaces.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * This message contains a parameter event.
       * Because the parameter event was an atomic update, a specific parameter name
       * can only be in one of the three sets.
       */
public class ParameterEvent extends Packet<ParameterEvent> implements Settable<ParameterEvent>, EpsilonComparable<ParameterEvent>
{
   /**
            * The time stamp when this parameter event occurred.
            */
   public builtin_interfaces.msg.dds.Time stamp_;
   /**
            * Fully qualified ROS path to node.
            */
   public java.lang.StringBuilder node_;
   /**
            * New parameters that have been set for this node.
            */
   public us.ihmc.idl.IDLSequence.Object<rcl_interfaces.msg.dds.Parameter>  new_parameters_;
   /**
            * Parameters that have been changed during this event.
            */
   public us.ihmc.idl.IDLSequence.Object<rcl_interfaces.msg.dds.Parameter>  changed_parameters_;
   /**
            * Parameters that have been deleted during this event.
            */
   public us.ihmc.idl.IDLSequence.Object<rcl_interfaces.msg.dds.Parameter>  deleted_parameters_;

   public ParameterEvent()
   {
      stamp_ = new builtin_interfaces.msg.dds.Time();
      node_ = new java.lang.StringBuilder(255);
      new_parameters_ = new us.ihmc.idl.IDLSequence.Object<rcl_interfaces.msg.dds.Parameter> (100, new rcl_interfaces.msg.dds.ParameterPubSubType());
      changed_parameters_ = new us.ihmc.idl.IDLSequence.Object<rcl_interfaces.msg.dds.Parameter> (100, new rcl_interfaces.msg.dds.ParameterPubSubType());
      deleted_parameters_ = new us.ihmc.idl.IDLSequence.Object<rcl_interfaces.msg.dds.Parameter> (100, new rcl_interfaces.msg.dds.ParameterPubSubType());

   }

   public ParameterEvent(ParameterEvent other)
   {
      this();
      set(other);
   }

   public void set(ParameterEvent other)
   {
      builtin_interfaces.msg.dds.TimePubSubType.staticCopy(other.stamp_, stamp_);
      node_.setLength(0);
      node_.append(other.node_);

      new_parameters_.set(other.new_parameters_);
      changed_parameters_.set(other.changed_parameters_);
      deleted_parameters_.set(other.deleted_parameters_);
   }


   /**
            * The time stamp when this parameter event occurred.
            */
   public builtin_interfaces.msg.dds.Time getStamp()
   {
      return stamp_;
   }

   /**
            * Fully qualified ROS path to node.
            */
   public void setNode(java.lang.String node)
   {
      node_.setLength(0);
      node_.append(node);
   }

   /**
            * Fully qualified ROS path to node.
            */
   public java.lang.String getNodeAsString()
   {
      return getNode().toString();
   }
   /**
            * Fully qualified ROS path to node.
            */
   public java.lang.StringBuilder getNode()
   {
      return node_;
   }


   /**
            * New parameters that have been set for this node.
            */
   public us.ihmc.idl.IDLSequence.Object<rcl_interfaces.msg.dds.Parameter>  getNewParameters()
   {
      return new_parameters_;
   }


   /**
            * Parameters that have been changed during this event.
            */
   public us.ihmc.idl.IDLSequence.Object<rcl_interfaces.msg.dds.Parameter>  getChangedParameters()
   {
      return changed_parameters_;
   }


   /**
            * Parameters that have been deleted during this event.
            */
   public us.ihmc.idl.IDLSequence.Object<rcl_interfaces.msg.dds.Parameter>  getDeletedParameters()
   {
      return deleted_parameters_;
   }


   public static Supplier<ParameterEventPubSubType> getPubSubType()
   {
      return ParameterEventPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return ParameterEventPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(ParameterEvent other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!this.stamp_.epsilonEquals(other.stamp_, epsilon)) return false;
      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.node_, other.node_, epsilon)) return false;

      if (this.new_parameters_.size() != other.new_parameters_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.new_parameters_.size(); i++)
         {  if (!this.new_parameters_.get(i).epsilonEquals(other.new_parameters_.get(i), epsilon)) return false; }
      }

      if (this.changed_parameters_.size() != other.changed_parameters_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.changed_parameters_.size(); i++)
         {  if (!this.changed_parameters_.get(i).epsilonEquals(other.changed_parameters_.get(i), epsilon)) return false; }
      }

      if (this.deleted_parameters_.size() != other.deleted_parameters_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.deleted_parameters_.size(); i++)
         {  if (!this.deleted_parameters_.get(i).epsilonEquals(other.deleted_parameters_.get(i), epsilon)) return false; }
      }


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof ParameterEvent)) return false;

      ParameterEvent otherMyClass = (ParameterEvent) other;

      if (!this.stamp_.equals(otherMyClass.stamp_)) return false;
      if (!us.ihmc.idl.IDLTools.equals(this.node_, otherMyClass.node_)) return false;

      if (!this.new_parameters_.equals(otherMyClass.new_parameters_)) return false;
      if (!this.changed_parameters_.equals(otherMyClass.changed_parameters_)) return false;
      if (!this.deleted_parameters_.equals(otherMyClass.deleted_parameters_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("ParameterEvent {");
      builder.append("stamp=");
      builder.append(this.stamp_);      builder.append(", ");
      builder.append("node=");
      builder.append(this.node_);      builder.append(", ");
      builder.append("new_parameters=");
      builder.append(this.new_parameters_);      builder.append(", ");
      builder.append("changed_parameters=");
      builder.append(this.changed_parameters_);      builder.append(", ");
      builder.append("deleted_parameters=");
      builder.append(this.deleted_parameters_);
      builder.append("}");
      return builder.toString();
   }
}

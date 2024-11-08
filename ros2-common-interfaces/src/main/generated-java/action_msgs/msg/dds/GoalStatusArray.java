package action_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

public class GoalStatusArray extends Packet<GoalStatusArray> implements Settable<GoalStatusArray>, EpsilonComparable<GoalStatusArray>
{
   /**
            * An array of goal statuses.
            */
   public us.ihmc.idl.IDLSequence.Object<action_msgs.msg.dds.GoalStatus>  status_list_;

   public GoalStatusArray()
   {
      status_list_ = new us.ihmc.idl.IDLSequence.Object<action_msgs.msg.dds.GoalStatus> (100, new action_msgs.msg.dds.GoalStatusPubSubType());

   }

   public GoalStatusArray(GoalStatusArray other)
   {
      this();
      set(other);
   }

   public void set(GoalStatusArray other)
   {
      status_list_.set(other.status_list_);
   }


   /**
            * An array of goal statuses.
            */
   public us.ihmc.idl.IDLSequence.Object<action_msgs.msg.dds.GoalStatus>  getStatusList()
   {
      return status_list_;
   }


   public static Supplier<GoalStatusArrayPubSubType> getPubSubType()
   {
      return GoalStatusArrayPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return GoalStatusArrayPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(GoalStatusArray other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (this.status_list_.size() != other.status_list_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.status_list_.size(); i++)
         {  if (!this.status_list_.get(i).epsilonEquals(other.status_list_.get(i), epsilon)) return false; }
      }

      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof GoalStatusArray)) return false;

      GoalStatusArray otherMyClass = (GoalStatusArray) other;

      if (!this.status_list_.equals(otherMyClass.status_list_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("GoalStatusArray {");
      builder.append("status_list=");
      builder.append(this.status_list_);
      builder.append("}");
      return builder.toString();
   }
}

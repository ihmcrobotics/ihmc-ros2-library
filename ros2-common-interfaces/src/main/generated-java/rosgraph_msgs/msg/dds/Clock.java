package rosgraph_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

public class Clock extends Packet<Clock> implements Settable<Clock>, EpsilonComparable<Clock>
{
   /**
            * This message communicates the current time.
            * 
            * For more information, see https://design.ros2.org/articles/clock_and_time.html.
            */
   public builtin_interfaces.msg.dds.Time clock_;

   public Clock()
   {
      clock_ = new builtin_interfaces.msg.dds.Time();
   }

   public Clock(Clock other)
   {
      this();
      set(other);
   }

   public void set(Clock other)
   {
      builtin_interfaces.msg.dds.TimePubSubType.staticCopy(other.clock_, clock_);   }


   /**
            * This message communicates the current time.
            * 
            * For more information, see https://design.ros2.org/articles/clock_and_time.html.
            */
   public builtin_interfaces.msg.dds.Time getClock()
   {
      return clock_;
   }


   public static Supplier<ClockPubSubType> getPubSubType()
   {
      return ClockPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return ClockPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(Clock other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!this.clock_.epsilonEquals(other.clock_, epsilon)) return false;

      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof Clock)) return false;

      Clock otherMyClass = (Clock) other;

      if (!this.clock_.equals(otherMyClass.clock_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("Clock {");
      builder.append("clock=");
      builder.append(this.clock_);
      builder.append("}");
      return builder.toString();
   }
}

package builtin_interfaces.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * Duration defines a period between two time points.
       * Messages of this datatype are of ROS Time following this design:
       * https://design.ros2.org/articles/clock_and_time.html
       */
public class Duration extends Packet<Duration> implements Settable<Duration>, EpsilonComparable<Duration>
{
   /**
            * Seconds component, range is valid over any possible int32 value.
            */
   public int sec_;
   /**
            * Nanoseconds component in the range of [0, 1e9).
            */
   public long nanosec_;

   public Duration()
   {
   }

   public Duration(Duration other)
   {
      this();
      set(other);
   }

   public void set(Duration other)
   {
      sec_ = other.sec_;

      nanosec_ = other.nanosec_;

   }

   /**
            * Seconds component, range is valid over any possible int32 value.
            */
   public void setSec(int sec)
   {
      sec_ = sec;
   }
   /**
            * Seconds component, range is valid over any possible int32 value.
            */
   public int getSec()
   {
      return sec_;
   }

   /**
            * Nanoseconds component in the range of [0, 1e9).
            */
   public void setNanosec(long nanosec)
   {
      nanosec_ = nanosec;
   }
   /**
            * Nanoseconds component in the range of [0, 1e9).
            */
   public long getNanosec()
   {
      return nanosec_;
   }


   public static Supplier<DurationPubSubType> getPubSubType()
   {
      return DurationPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return DurationPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(Duration other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.sec_, other.sec_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.nanosec_, other.nanosec_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof Duration)) return false;

      Duration otherMyClass = (Duration) other;

      if(this.sec_ != otherMyClass.sec_) return false;

      if(this.nanosec_ != otherMyClass.nanosec_) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("Duration {");
      builder.append("sec=");
      builder.append(this.sec_);      builder.append(", ");
      builder.append("nanosec=");
      builder.append(this.nanosec_);
      builder.append("}");
      return builder.toString();
   }
}

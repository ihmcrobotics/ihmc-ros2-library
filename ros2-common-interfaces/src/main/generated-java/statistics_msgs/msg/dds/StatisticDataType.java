package statistics_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * ############################################
       * This file contains the commonly used constants for the statistics data type.
       * 
       * The value 0 is reserved for unitialized statistic message data type.
       * Range of values: [0, 255].
       * Unallowed values: any value that is not specified in this file.
       * 
       * ############################################
       */
public class StatisticDataType extends Packet<StatisticDataType> implements Settable<StatisticDataType>, EpsilonComparable<StatisticDataType>
{
   /**
          * Constant for uninitialized
          */
   public static final byte STATISTICS_DATA_TYPE_UNINITIALIZED = (byte) 0;
   /**
          * Allowed values
          */
   public static final byte STATISTICS_DATA_TYPE_AVERAGE = (byte) 1;
   public static final byte STATISTICS_DATA_TYPE_MINIMUM = (byte) 2;
   public static final byte STATISTICS_DATA_TYPE_MAXIMUM = (byte) 3;
   public static final byte STATISTICS_DATA_TYPE_STDDEV = (byte) 4;
   public static final byte STATISTICS_DATA_TYPE_SAMPLE_COUNT = (byte) 5;
   public boolean unused_placeholder_field_;

   public StatisticDataType()
   {
   }

   public StatisticDataType(StatisticDataType other)
   {
      this();
      set(other);
   }

   public void set(StatisticDataType other)
   {
      unused_placeholder_field_ = other.unused_placeholder_field_;

   }

   public void setUnusedPlaceholderField(boolean unused_placeholder_field)
   {
      unused_placeholder_field_ = unused_placeholder_field;
   }
   public boolean getUnusedPlaceholderField()
   {
      return unused_placeholder_field_;
   }


   public static Supplier<StatisticDataTypePubSubType> getPubSubType()
   {
      return StatisticDataTypePubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return StatisticDataTypePubSubType::new;
   }

   @Override
   public boolean epsilonEquals(StatisticDataType other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.unused_placeholder_field_, other.unused_placeholder_field_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof StatisticDataType)) return false;

      StatisticDataType otherMyClass = (StatisticDataType) other;

      if(this.unused_placeholder_field_ != otherMyClass.unused_placeholder_field_) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("StatisticDataType {");
      builder.append("unused_placeholder_field=");
      builder.append(this.unused_placeholder_field_);
      builder.append("}");
      return builder.toString();
   }
}

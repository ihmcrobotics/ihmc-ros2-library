package statistics_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * ############################################
       * This holds the structure of a single data point of a StatisticDataType.
       * 
       * This message is used in MetricsStatisticsMessage, defined in MetricsStatisticsMessage.msg.
       * 
       * Examples of the value of data point are
       * - average size of messages received
       * - standard deviation of the period of messages published
       * - maximum age of messages published
       * 
       * A value of nan represents no data is available.
       * One example is that standard deviation is only available when there are two or more data points but there is only one,
       * and in this case the value would be nan.
       * +inf and -inf are not allowed.
       * 
       * ############################################
       */
public class StatisticDataPoint extends Packet<StatisticDataPoint> implements Settable<StatisticDataPoint>, EpsilonComparable<StatisticDataPoint>
{
   /**
            * The statistic type of this data point, defined in StatisticDataType.msg
            * Default value should be StatisticDataType.STATISTICS_DATA_TYPE_UNINITIALIZED (0).
            */
   public byte data_type_;
   /**
            * The value of the data point
            */
   public double data_;

   public StatisticDataPoint()
   {
   }

   public StatisticDataPoint(StatisticDataPoint other)
   {
      this();
      set(other);
   }

   public void set(StatisticDataPoint other)
   {
      data_type_ = other.data_type_;

      data_ = other.data_;

   }

   /**
            * The statistic type of this data point, defined in StatisticDataType.msg
            * Default value should be StatisticDataType.STATISTICS_DATA_TYPE_UNINITIALIZED (0).
            */
   public void setDataType(byte data_type)
   {
      data_type_ = data_type;
   }
   /**
            * The statistic type of this data point, defined in StatisticDataType.msg
            * Default value should be StatisticDataType.STATISTICS_DATA_TYPE_UNINITIALIZED (0).
            */
   public byte getDataType()
   {
      return data_type_;
   }

   /**
            * The value of the data point
            */
   public void setData(double data)
   {
      data_ = data;
   }
   /**
            * The value of the data point
            */
   public double getData()
   {
      return data_;
   }


   public static Supplier<StatisticDataPointPubSubType> getPubSubType()
   {
      return StatisticDataPointPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return StatisticDataPointPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(StatisticDataPoint other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.data_type_, other.data_type_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.data_, other.data_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof StatisticDataPoint)) return false;

      StatisticDataPoint otherMyClass = (StatisticDataPoint) other;

      if(this.data_type_ != otherMyClass.data_type_) return false;

      if(this.data_ != otherMyClass.data_) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("StatisticDataPoint {");
      builder.append("data_type=");
      builder.append(this.data_type_);      builder.append(", ");
      builder.append("data=");
      builder.append(this.data_);
      builder.append("}");
      return builder.toString();
   }
}

package statistics_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * ############################################
       * A generic metrics message providing statistics for measurements from different sources. For example,
       * measure a system's CPU % for a given window yields the following data points over a window of time:
       * 
       * - average cpu %
       * - std deviation
       * - min
       * - max
       * - sample count
       * 
       * These are all represented as different 'StatisticDataPoint's.
       * ############################################
       */
public class MetricsMessage extends Packet<MetricsMessage> implements Settable<MetricsMessage>, EpsilonComparable<MetricsMessage>
{
   /**
            * Name metric measurement source, e.g., node, topic, or process name
            */
   public java.lang.StringBuilder measurement_source_name_;
   /**
            * Name of the metric being measured, e.g. cpu_percentage, free_memory_mb, message_age, etc.
            */
   public java.lang.StringBuilder metrics_source_;
   /**
            * Unit of measure of the metric, e.g. percent, mb, seconds, etc.
            */
   public java.lang.StringBuilder unit_;
   /**
            * Measurement window start time
            */
   public builtin_interfaces.msg.dds.Time window_start_;
   /**
            * Measurement window end time
            */
   public builtin_interfaces.msg.dds.Time window_stop_;
   /**
            * A list of statistics data point, defined in StatisticDataPoint.msg
            */
   public us.ihmc.idl.IDLSequence.Object<statistics_msgs.msg.dds.StatisticDataPoint>  statistics_;

   public MetricsMessage()
   {
      measurement_source_name_ = new java.lang.StringBuilder(255);
      metrics_source_ = new java.lang.StringBuilder(255);
      unit_ = new java.lang.StringBuilder(255);
      window_start_ = new builtin_interfaces.msg.dds.Time();
      window_stop_ = new builtin_interfaces.msg.dds.Time();
      statistics_ = new us.ihmc.idl.IDLSequence.Object<statistics_msgs.msg.dds.StatisticDataPoint> (100, new statistics_msgs.msg.dds.StatisticDataPointPubSubType());

   }

   public MetricsMessage(MetricsMessage other)
   {
      this();
      set(other);
   }

   public void set(MetricsMessage other)
   {
      measurement_source_name_.setLength(0);
      measurement_source_name_.append(other.measurement_source_name_);

      metrics_source_.setLength(0);
      metrics_source_.append(other.metrics_source_);

      unit_.setLength(0);
      unit_.append(other.unit_);

      builtin_interfaces.msg.dds.TimePubSubType.staticCopy(other.window_start_, window_start_);
      builtin_interfaces.msg.dds.TimePubSubType.staticCopy(other.window_stop_, window_stop_);
      statistics_.set(other.statistics_);
   }

   /**
            * Name metric measurement source, e.g., node, topic, or process name
            */
   public void setMeasurementSourceName(java.lang.String measurement_source_name)
   {
      measurement_source_name_.setLength(0);
      measurement_source_name_.append(measurement_source_name);
   }

   /**
            * Name metric measurement source, e.g., node, topic, or process name
            */
   public java.lang.String getMeasurementSourceNameAsString()
   {
      return getMeasurementSourceName().toString();
   }
   /**
            * Name metric measurement source, e.g., node, topic, or process name
            */
   public java.lang.StringBuilder getMeasurementSourceName()
   {
      return measurement_source_name_;
   }

   /**
            * Name of the metric being measured, e.g. cpu_percentage, free_memory_mb, message_age, etc.
            */
   public void setMetricsSource(java.lang.String metrics_source)
   {
      metrics_source_.setLength(0);
      metrics_source_.append(metrics_source);
   }

   /**
            * Name of the metric being measured, e.g. cpu_percentage, free_memory_mb, message_age, etc.
            */
   public java.lang.String getMetricsSourceAsString()
   {
      return getMetricsSource().toString();
   }
   /**
            * Name of the metric being measured, e.g. cpu_percentage, free_memory_mb, message_age, etc.
            */
   public java.lang.StringBuilder getMetricsSource()
   {
      return metrics_source_;
   }

   /**
            * Unit of measure of the metric, e.g. percent, mb, seconds, etc.
            */
   public void setUnit(java.lang.String unit)
   {
      unit_.setLength(0);
      unit_.append(unit);
   }

   /**
            * Unit of measure of the metric, e.g. percent, mb, seconds, etc.
            */
   public java.lang.String getUnitAsString()
   {
      return getUnit().toString();
   }
   /**
            * Unit of measure of the metric, e.g. percent, mb, seconds, etc.
            */
   public java.lang.StringBuilder getUnit()
   {
      return unit_;
   }


   /**
            * Measurement window start time
            */
   public builtin_interfaces.msg.dds.Time getWindowStart()
   {
      return window_start_;
   }


   /**
            * Measurement window end time
            */
   public builtin_interfaces.msg.dds.Time getWindowStop()
   {
      return window_stop_;
   }


   /**
            * A list of statistics data point, defined in StatisticDataPoint.msg
            */
   public us.ihmc.idl.IDLSequence.Object<statistics_msgs.msg.dds.StatisticDataPoint>  getStatistics()
   {
      return statistics_;
   }


   public static Supplier<MetricsMessagePubSubType> getPubSubType()
   {
      return MetricsMessagePubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return MetricsMessagePubSubType::new;
   }

   @Override
   public boolean epsilonEquals(MetricsMessage other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.measurement_source_name_, other.measurement_source_name_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.metrics_source_, other.metrics_source_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.unit_, other.unit_, epsilon)) return false;

      if (!this.window_start_.epsilonEquals(other.window_start_, epsilon)) return false;
      if (!this.window_stop_.epsilonEquals(other.window_stop_, epsilon)) return false;
      if (this.statistics_.size() != other.statistics_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.statistics_.size(); i++)
         {  if (!this.statistics_.get(i).epsilonEquals(other.statistics_.get(i), epsilon)) return false; }
      }


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof MetricsMessage)) return false;

      MetricsMessage otherMyClass = (MetricsMessage) other;

      if (!us.ihmc.idl.IDLTools.equals(this.measurement_source_name_, otherMyClass.measurement_source_name_)) return false;

      if (!us.ihmc.idl.IDLTools.equals(this.metrics_source_, otherMyClass.metrics_source_)) return false;

      if (!us.ihmc.idl.IDLTools.equals(this.unit_, otherMyClass.unit_)) return false;

      if (!this.window_start_.equals(otherMyClass.window_start_)) return false;
      if (!this.window_stop_.equals(otherMyClass.window_stop_)) return false;
      if (!this.statistics_.equals(otherMyClass.statistics_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("MetricsMessage {");
      builder.append("measurement_source_name=");
      builder.append(this.measurement_source_name_);      builder.append(", ");
      builder.append("metrics_source=");
      builder.append(this.metrics_source_);      builder.append(", ");
      builder.append("unit=");
      builder.append(this.unit_);      builder.append(", ");
      builder.append("window_start=");
      builder.append(this.window_start_);      builder.append(", ");
      builder.append("window_stop=");
      builder.append(this.window_stop_);      builder.append(", ");
      builder.append("statistics=");
      builder.append(this.statistics_);
      builder.append("}");
      return builder.toString();
   }
}

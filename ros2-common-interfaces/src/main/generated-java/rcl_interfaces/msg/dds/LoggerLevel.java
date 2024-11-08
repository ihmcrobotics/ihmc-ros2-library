package rcl_interfaces.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * All available logger levels; these correspond to the enum in rcutils/logger.h
       */
public class LoggerLevel extends Packet<LoggerLevel> implements Settable<LoggerLevel>, EpsilonComparable<LoggerLevel>
{
   public static final byte LOG_LEVEL_UNKNOWN = (byte) 0;
   public static final byte LOG_LEVEL_DEBUG = (byte) 10;
   public static final byte LOG_LEVEL_INFO = (byte) 20;
   public static final byte LOG_LEVEL_WARN = (byte) 30;
   public static final byte LOG_LEVEL_ERROR = (byte) 40;
   public static final byte LOG_LEVEL_FATAL = (byte) 50;
   /**
            * The logger name.
            */
   public java.lang.StringBuilder name_;
   /**
            * The logger level
            */
   public long level_;

   public LoggerLevel()
   {
      name_ = new java.lang.StringBuilder(255);
   }

   public LoggerLevel(LoggerLevel other)
   {
      this();
      set(other);
   }

   public void set(LoggerLevel other)
   {
      name_.setLength(0);
      name_.append(other.name_);

      level_ = other.level_;

   }

   /**
            * The logger name.
            */
   public void setName(java.lang.String name)
   {
      name_.setLength(0);
      name_.append(name);
   }

   /**
            * The logger name.
            */
   public java.lang.String getNameAsString()
   {
      return getName().toString();
   }
   /**
            * The logger name.
            */
   public java.lang.StringBuilder getName()
   {
      return name_;
   }

   /**
            * The logger level
            */
   public void setLevel(long level)
   {
      level_ = level;
   }
   /**
            * The logger level
            */
   public long getLevel()
   {
      return level_;
   }


   public static Supplier<LoggerLevelPubSubType> getPubSubType()
   {
      return LoggerLevelPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return LoggerLevelPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(LoggerLevel other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.name_, other.name_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.level_, other.level_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof LoggerLevel)) return false;

      LoggerLevel otherMyClass = (LoggerLevel) other;

      if (!us.ihmc.idl.IDLTools.equals(this.name_, otherMyClass.name_)) return false;

      if(this.level_ != otherMyClass.level_) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("LoggerLevel {");
      builder.append("name=");
      builder.append(this.name_);      builder.append(", ");
      builder.append("level=");
      builder.append(this.level_);
      builder.append("}");
      return builder.toString();
   }
}

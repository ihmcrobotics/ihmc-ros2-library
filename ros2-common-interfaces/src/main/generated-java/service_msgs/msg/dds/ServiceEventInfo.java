package service_msgs.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

public class ServiceEventInfo extends Packet<ServiceEventInfo> implements Settable<ServiceEventInfo>, EpsilonComparable<ServiceEventInfo>
{
   public static final byte REQUEST_SENT = (byte) 0;
   public static final byte REQUEST_RECEIVED = (byte) 1;
   public static final byte RESPONSE_SENT = (byte) 2;
   public static final byte RESPONSE_RECEIVED = (byte) 3;
   /**
            * The type of event this message represents
            */
   public byte event_type_;
   /**
            * Timestamp for when the event occurred (sent or received time)
            */
   public builtin_interfaces.msg.dds.Time stamp_;
   /**
            * Unique identifier for the client that sent the service request
            * Note, this is only unique for the current session.
            * The size here has to match the size of rmw_dds_common/msg/Gid,
            * but unfortunately we cannot use that message directly due to a
            * circular dependency.
            */
   public char[] client_gid_;
   /**
            * Sequence number for the request
            * Combined with the client ID, this creates a unique ID for the service transaction
            */
   public long sequence_number_;

   public ServiceEventInfo()
   {
      stamp_ = new builtin_interfaces.msg.dds.Time();
      client_gid_ = new char[16];

   }

   public ServiceEventInfo(ServiceEventInfo other)
   {
      this();
      set(other);
   }

   public void set(ServiceEventInfo other)
   {
      event_type_ = other.event_type_;

      builtin_interfaces.msg.dds.TimePubSubType.staticCopy(other.stamp_, stamp_);
      for(int i1 = 0; i1 < client_gid_.length; ++i1)
      {
            client_gid_[i1] = other.client_gid_[i1];

      }

      sequence_number_ = other.sequence_number_;

   }

   /**
            * The type of event this message represents
            */
   public void setEventType(byte event_type)
   {
      event_type_ = event_type;
   }
   /**
            * The type of event this message represents
            */
   public byte getEventType()
   {
      return event_type_;
   }


   /**
            * Timestamp for when the event occurred (sent or received time)
            */
   public builtin_interfaces.msg.dds.Time getStamp()
   {
      return stamp_;
   }


   /**
            * Unique identifier for the client that sent the service request
            * Note, this is only unique for the current session.
            * The size here has to match the size of rmw_dds_common/msg/Gid,
            * but unfortunately we cannot use that message directly due to a
            * circular dependency.
            */
   public char[] getClientGid()
   {
      return client_gid_;
   }

   /**
            * Sequence number for the request
            * Combined with the client ID, this creates a unique ID for the service transaction
            */
   public void setSequenceNumber(long sequence_number)
   {
      sequence_number_ = sequence_number;
   }
   /**
            * Sequence number for the request
            * Combined with the client ID, this creates a unique ID for the service transaction
            */
   public long getSequenceNumber()
   {
      return sequence_number_;
   }


   public static Supplier<ServiceEventInfoPubSubType> getPubSubType()
   {
      return ServiceEventInfoPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return ServiceEventInfoPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(ServiceEventInfo other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.event_type_, other.event_type_, epsilon)) return false;

      if (!this.stamp_.epsilonEquals(other.stamp_, epsilon)) return false;
      for(int i3 = 0; i3 < client_gid_.length; ++i3)
      {
                if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.client_gid_[i3], other.client_gid_[i3], epsilon)) return false;
      }

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.sequence_number_, other.sequence_number_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof ServiceEventInfo)) return false;

      ServiceEventInfo otherMyClass = (ServiceEventInfo) other;

      if(this.event_type_ != otherMyClass.event_type_) return false;

      if (!this.stamp_.equals(otherMyClass.stamp_)) return false;
      for(int i5 = 0; i5 < client_gid_.length; ++i5)
      {
                if(this.client_gid_[i5] != otherMyClass.client_gid_[i5]) return false;

      }
      if(this.sequence_number_ != otherMyClass.sequence_number_) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("ServiceEventInfo {");
      builder.append("event_type=");
      builder.append(this.event_type_);      builder.append(", ");
      builder.append("stamp=");
      builder.append(this.stamp_);      builder.append(", ");
      builder.append("client_gid=");
      builder.append(java.util.Arrays.toString(this.client_gid_));      builder.append(", ");
      builder.append("sequence_number=");
      builder.append(this.sequence_number_);
      builder.append("}");
      return builder.toString();
   }
}

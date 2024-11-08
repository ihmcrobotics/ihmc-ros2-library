package type_description_interfaces.msg.dds;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
       * Represents an arbitrary key-value pair for application-specific information.
       */
public class KeyValue extends Packet<KeyValue> implements Settable<KeyValue>, EpsilonComparable<KeyValue>
{
   public java.lang.StringBuilder key_;
   public java.lang.StringBuilder value_;

   public KeyValue()
   {
      key_ = new java.lang.StringBuilder(255);
      value_ = new java.lang.StringBuilder(255);
   }

   public KeyValue(KeyValue other)
   {
      this();
      set(other);
   }

   public void set(KeyValue other)
   {
      key_.setLength(0);
      key_.append(other.key_);

      value_.setLength(0);
      value_.append(other.value_);

   }

   public void setKey(java.lang.String key)
   {
      key_.setLength(0);
      key_.append(key);
   }

   public java.lang.String getKeyAsString()
   {
      return getKey().toString();
   }
   public java.lang.StringBuilder getKey()
   {
      return key_;
   }

   public void setValue(java.lang.String value)
   {
      value_.setLength(0);
      value_.append(value);
   }

   public java.lang.String getValueAsString()
   {
      return getValue().toString();
   }
   public java.lang.StringBuilder getValue()
   {
      return value_;
   }


   public static Supplier<KeyValuePubSubType> getPubSubType()
   {
      return KeyValuePubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return KeyValuePubSubType::new;
   }

   @Override
   public boolean epsilonEquals(KeyValue other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.key_, other.key_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.value_, other.value_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof KeyValue)) return false;

      KeyValue otherMyClass = (KeyValue) other;

      if (!us.ihmc.idl.IDLTools.equals(this.key_, otherMyClass.key_)) return false;

      if (!us.ihmc.idl.IDLTools.equals(this.value_, otherMyClass.value_)) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("KeyValue {");
      builder.append("key=");
      builder.append(this.key_);      builder.append(", ");
      builder.append("value=");
      builder.append(this.value_);
      builder.append("}");
      return builder.toString();
   }
}

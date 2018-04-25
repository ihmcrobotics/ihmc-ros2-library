package us.ihmc.idl.generated.nested;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

public class NestedElement extends Packet<NestedElement> implements Settable<NestedElement>, EpsilonComparable<NestedElement>
{
   public java.lang.StringBuilder stringTest_;
   public int longTest_;

   public NestedElement()
   {
      stringTest_ = new java.lang.StringBuilder(255);
   }

   public NestedElement(NestedElement other)
   {
      this();
      set(other);
   }

   public void set(NestedElement other)
   {
      stringTest_.setLength(0);
      stringTest_.append(other.stringTest_);

      longTest_ = other.longTest_;

   }

   public void setStringTest(java.lang.String stringTest)
   {
      stringTest_.setLength(0);
      stringTest_.append(stringTest);
   }

   public java.lang.String getStringTestAsString()
   {
      return getStringTest().toString();
   }
   public java.lang.StringBuilder getStringTest()
   {
      return stringTest_;
   }

   public void setLongTest(int longTest)
   {
      longTest_ = longTest;
   }
   public int getLongTest()
   {
      return longTest_;
   }


   public static Supplier<NestedElementPubSubType> getPubSubType()
   {
      return NestedElementPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return NestedElementPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(NestedElement other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.stringTest_, other.stringTest_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.longTest_, other.longTest_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof NestedElement)) return false;

      NestedElement otherMyClass = (NestedElement) other;

      if (!us.ihmc.idl.IDLTools.equals(this.stringTest_, otherMyClass.stringTest_)) return false;

      if(this.longTest_ != otherMyClass.longTest_) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("NestedElement {");
      builder.append("stringTest=");
      builder.append(this.stringTest_);      builder.append(", ");
      builder.append("longTest=");
      builder.append(this.longTest_);
      builder.append("}");
      return builder.toString();
   }
}

package us.ihmc.idl.generated.test;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

/**
 * This is the header
 * Header line 2
 * This is some dangling comment that will be included in header
 */
public class IDLSubmessage extends Packet<IDLSubmessage> implements Settable<IDLSubmessage>, EpsilonComparable<IDLSubmessage>
{
   /**
    * a, b, c
    * 1, 2, 3
    * baby
    * sneaky boi
    */
   public static final int Y = 123;
   public static final String CATCH_23 = "No doc, watch out!";

   /**
    * this num should have default value 5
    */
   public long num_ = 5;
   /**
    * I have some doc not relevant to the next
    */
   public long no_default_with_doc_;
   public long no_doc_num_;
   /**
    * @javadoc I guess javadoc will work okay.
    * hello
    */
   public int hello_;

   public IDLSubmessage()
   {
   }

   public IDLSubmessage(IDLSubmessage other)
   {
      this();
      set(other);
   }

   public void set(IDLSubmessage other)
   {
      num_ = other.num_;

      no_default_with_doc_ = other.no_default_with_doc_;

      no_doc_num_ = other.no_doc_num_;

      hello_ = other.hello_;

   }

   /**
    * this num should have default value 5
    */
   public void setNum(long num)
   {
      num_ = num;
   }
   /**
    * this num should have default value 5
    */
   public long getNum()
   {
      return num_;
   }

   /**
    * I have some doc not relevant to the next
    */
   public void setNoDefaultWithDoc(long no_default_with_doc)
   {
      no_default_with_doc_ = no_default_with_doc;
   }
   /**
    * I have some doc not relevant to the next
    */
   public long getNoDefaultWithDoc()
   {
      return no_default_with_doc_;
   }

   public void setNoDocNum(long no_doc_num)
   {
      no_doc_num_ = no_doc_num;
   }
   public long getNoDocNum()
   {
      return no_doc_num_;
   }

   /**
    * @javadoc I guess javadoc will work okay.
    * hello
    */
   public void setHello(int hello)
   {
      hello_ = hello;
   }
   /**
    * @javadoc I guess javadoc will work okay.
    * hello
    */
   public int getHello()
   {
      return hello_;
   }


   public static Supplier<IDLSubmessagePubSubType> getPubSubType()
   {
      return IDLSubmessagePubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return IDLSubmessagePubSubType::new;
   }

   @Override
   public boolean epsilonEquals(IDLSubmessage other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.num_, other.num_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.no_default_with_doc_, other.no_default_with_doc_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.no_doc_num_, other.no_doc_num_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.hello_, other.hello_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof IDLSubmessage)) return false;

      IDLSubmessage otherMyClass = (IDLSubmessage) other;

      if(this.num_ != otherMyClass.num_) return false;

      if(this.no_default_with_doc_ != otherMyClass.no_default_with_doc_) return false;

      if(this.no_doc_num_ != otherMyClass.no_doc_num_) return false;

      if(this.hello_ != otherMyClass.hello_) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("IDLSubmessage {");
      builder.append("num=");
      builder.append(this.num_);      builder.append(", ");
      builder.append("no_default_with_doc=");
      builder.append(this.no_default_with_doc_);      builder.append(", ");
      builder.append("no_doc_num=");
      builder.append(this.no_doc_num_);      builder.append(", ");
      builder.append("hello=");
      builder.append(this.hello_);
      builder.append("}");
      return builder.toString();
   }
}

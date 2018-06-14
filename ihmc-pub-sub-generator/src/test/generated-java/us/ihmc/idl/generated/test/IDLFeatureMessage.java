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
public class IDLFeatureMessage extends Packet<IDLFeatureMessage> implements Settable<IDLFeatureMessage>, EpsilonComparable<IDLFeatureMessage>
{
   /**
    * a, b, c
    * 1, 2, 3
    * baby
    * sneaky boi
    */
   public static final int X = 123;
   public static final byte BYTE_ME = (byte) 255;
   public static final String CATCH_22 = "No doc, watch out!";

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
   public us.ihmc.idl.generated.test.IDLSubmessage num1_;
   public us.ihmc.idl.IDLSequence.Object<us.ihmc.idl.generated.test.IDLSubmessage>  num2_;
   /**
    * Should be ros_msgs::msg::dds::Num num3[3];
    */
   public us.ihmc.idl.generated.test.IDLSubmessage[] num3_;
   public us.ihmc.idl.IDLSequence.Object<us.ihmc.idl.generated.test.IDLSubmessage>  num4_;
   public java.lang.StringBuilder str1_;
   public java.lang.StringBuilder str2_;
   public us.ihmc.idl.IDLSequence.StringBuilderHolder  str3_;
   public us.ihmc.idl.IDLSequence.StringBuilderHolder  str4_;
   public us.ihmc.idl.IDLSequence.StringBuilderHolder  str5_;

   public IDLFeatureMessage()
   {
      num1_ = new us.ihmc.idl.generated.test.IDLSubmessage();
      num2_ = new us.ihmc.idl.IDLSequence.Object<us.ihmc.idl.generated.test.IDLSubmessage> (100, new us.ihmc.idl.generated.test.IDLSubmessagePubSubType());
      num3_ = new us.ihmc.idl.generated.test.IDLSubmessage[3];

      for(int i1 = 0; i1 < num3_.length; ++i1)
      {
          num3_[i1] = new us.ihmc.idl.generated.test.IDLSubmessage();
      }
      num4_ = new us.ihmc.idl.IDLSequence.Object<us.ihmc.idl.generated.test.IDLSubmessage> (3, new us.ihmc.idl.generated.test.IDLSubmessagePubSubType());
      str1_ = new java.lang.StringBuilder(255);
      str2_ = new java.lang.StringBuilder(10);
      str3_ = new us.ihmc.idl.IDLSequence.StringBuilderHolder (5, "type_d");
      str4_ = new us.ihmc.idl.IDLSequence.StringBuilderHolder (100, "type_d");
      str5_ = new us.ihmc.idl.IDLSequence.StringBuilderHolder (5, "type_d");

   }

   public IDLFeatureMessage(IDLFeatureMessage other)
   {
      this();
      set(other);
   }

   public void set(IDLFeatureMessage other)
   {
      num_ = other.num_;

      no_default_with_doc_ = other.no_default_with_doc_;

      no_doc_num_ = other.no_doc_num_;

      hello_ = other.hello_;

      us.ihmc.idl.generated.test.IDLSubmessagePubSubType.staticCopy(other.num1_, num1_);
      num2_.set(other.num2_);
      for(int i3 = 0; i3 < num3_.length; ++i3)
      {
            us.ihmc.idl.generated.test.IDLSubmessagePubSubType.staticCopy(other.num3_[i3], num3_[i3]);}

      num4_.set(other.num4_);
      str1_.setLength(0);
      str1_.append(other.str1_);

      str2_.setLength(0);
      str2_.append(other.str2_);

      str3_.set(other.str3_);
      str4_.set(other.str4_);
      str5_.set(other.str5_);
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


   public us.ihmc.idl.generated.test.IDLSubmessage getNum1()
   {
      return num1_;
   }


   public us.ihmc.idl.IDLSequence.Object<us.ihmc.idl.generated.test.IDLSubmessage>  getNum2()
   {
      return num2_;
   }


   /**
    * Should be ros_msgs::msg::dds::Num num3[3];
    */
   public us.ihmc.idl.generated.test.IDLSubmessage[] getNum3()
   {
      return num3_;
   }


   public us.ihmc.idl.IDLSequence.Object<us.ihmc.idl.generated.test.IDLSubmessage>  getNum4()
   {
      return num4_;
   }

   public void setStr1(java.lang.String str1)
   {
      str1_.setLength(0);
      str1_.append(str1);
   }

   public java.lang.String getStr1AsString()
   {
      return getStr1().toString();
   }
   public java.lang.StringBuilder getStr1()
   {
      return str1_;
   }

   public void setStr2(java.lang.String str2)
   {
      str2_.setLength(0);
      str2_.append(str2);
   }

   public java.lang.String getStr2AsString()
   {
      return getStr2().toString();
   }
   public java.lang.StringBuilder getStr2()
   {
      return str2_;
   }


   public us.ihmc.idl.IDLSequence.StringBuilderHolder  getStr3()
   {
      return str3_;
   }


   public us.ihmc.idl.IDLSequence.StringBuilderHolder  getStr4()
   {
      return str4_;
   }


   public us.ihmc.idl.IDLSequence.StringBuilderHolder  getStr5()
   {
      return str5_;
   }


   public static Supplier<IDLFeatureMessagePubSubType> getPubSubType()
   {
      return IDLFeatureMessagePubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return IDLFeatureMessagePubSubType::new;
   }

   @Override
   public boolean epsilonEquals(IDLFeatureMessage other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.num_, other.num_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.no_default_with_doc_, other.no_default_with_doc_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.no_doc_num_, other.no_doc_num_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.hello_, other.hello_, epsilon)) return false;

      if (!this.num1_.epsilonEquals(other.num1_, epsilon)) return false;
      if (this.num2_.size() != other.num2_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.num2_.size(); i++)
         {  if (!this.num2_.get(i).epsilonEquals(other.num2_.get(i), epsilon)) return false; }
      }

      for(int i5 = 0; i5 < num3_.length; ++i5)
      {
              if (!this.num3_[i5].epsilonEquals(other.num3_[i5], epsilon)) return false;
      }

      if (this.num4_.size() != other.num4_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.num4_.size(); i++)
         {  if (!this.num4_.get(i).epsilonEquals(other.num4_.get(i), epsilon)) return false; }
      }

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.str1_, other.str1_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.str2_, other.str2_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilderSequence(this.str3_, other.str3_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilderSequence(this.str4_, other.str4_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilderSequence(this.str5_, other.str5_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof IDLFeatureMessage)) return false;

      IDLFeatureMessage otherMyClass = (IDLFeatureMessage) other;

      if(this.num_ != otherMyClass.num_) return false;

      if(this.no_default_with_doc_ != otherMyClass.no_default_with_doc_) return false;

      if(this.no_doc_num_ != otherMyClass.no_doc_num_) return false;

      if(this.hello_ != otherMyClass.hello_) return false;

      if (!this.num1_.equals(otherMyClass.num1_)) return false;
      if (!this.num2_.equals(otherMyClass.num2_)) return false;
      for(int i7 = 0; i7 < num3_.length; ++i7)
      {
                if (!this.num3_[i7].equals(otherMyClass.num3_[i7])) return false;
      }
      if (!this.num4_.equals(otherMyClass.num4_)) return false;
      if (!us.ihmc.idl.IDLTools.equals(this.str1_, otherMyClass.str1_)) return false;

      if (!us.ihmc.idl.IDLTools.equals(this.str2_, otherMyClass.str2_)) return false;

      if (!this.str3_.equals(otherMyClass.str3_)) return false;
      if (!this.str4_.equals(otherMyClass.str4_)) return false;
      if (!this.str5_.equals(otherMyClass.str5_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("IDLFeatureMessage {");
      builder.append("num=");
      builder.append(this.num_);      builder.append(", ");
      builder.append("no_default_with_doc=");
      builder.append(this.no_default_with_doc_);      builder.append(", ");
      builder.append("no_doc_num=");
      builder.append(this.no_doc_num_);      builder.append(", ");
      builder.append("hello=");
      builder.append(this.hello_);      builder.append(", ");
      builder.append("num1=");
      builder.append(this.num1_);      builder.append(", ");
      builder.append("num2=");
      builder.append(this.num2_);      builder.append(", ");
      builder.append("num3=");
      builder.append(java.util.Arrays.toString(this.num3_));      builder.append(", ");
      builder.append("num4=");
      builder.append(this.num4_);      builder.append(", ");
      builder.append("str1=");
      builder.append(this.str1_);      builder.append(", ");
      builder.append("str2=");
      builder.append(this.str2_);      builder.append(", ");
      builder.append("str3=");
      builder.append(this.str3_);      builder.append(", ");
      builder.append("str4=");
      builder.append(this.str4_);      builder.append(", ");
      builder.append("str5=");
      builder.append(this.str5_);
      builder.append("}");
      return builder.toString();
   }
}

package ros_msgs.msg.dds;

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
public class Num extends Packet<Num> implements Settable<Num>, EpsilonComparable<Num>
{
   /**
          * a, b, c
          * 1, 2, 3
          * baby
          * sneaky boi
          */
   public static final int X = 123;
   public static final String CATCH_22 = "No doc, watch out!";

   /**
            * this num should have default value 5
            */
   public long num_ = 5;
   public double double_test_;
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

   public Num()
   {
   }

   public Num(Num other)
   {
      this();
      set(other);
   }

   public void set(Num other)
   {
      num_ = other.num_;

      double_test_ = other.double_test_;

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

   public void setDoubleTest(double double_test)
   {
      double_test_ = double_test;
   }
   public double getDoubleTest()
   {
      return double_test_;
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


   public static Supplier<NumPubSubType> getPubSubType()
   {
      return NumPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return NumPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(Num other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.num_, other.num_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.double_test_, other.double_test_, epsilon)) return false;

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
      if(!(other instanceof Num)) return false;

      Num otherMyClass = (Num) other;

      if(this.num_ != otherMyClass.num_) return false;

      if(this.double_test_ != otherMyClass.double_test_) return false;

      if(this.no_default_with_doc_ != otherMyClass.no_default_with_doc_) return false;

      if(this.no_doc_num_ != otherMyClass.no_doc_num_) return false;

      if(this.hello_ != otherMyClass.hello_) return false;


      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("Num {");
      builder.append("num=");
      builder.append(this.num_);      builder.append(", ");
      builder.append("double_test=");
      builder.append(this.double_test_);      builder.append(", ");
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

package us.ihmc.idl.generated.test;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.interfaces.Settable;
import us.ihmc.euclid.interfaces.EpsilonComparable;
import java.util.function.Supplier;
import us.ihmc.pubsub.TopicDataType;

public class IDLElementTest extends Packet<IDLElementTest> implements Settable<IDLElementTest>, EpsilonComparable<IDLElementTest>
{
   public char charTest_;
   public char wcharTest_;
   public byte octetTest_;
   public short shortTest_;
   public int ushortTest_;
   public int longTest_;
   public long ulongTest_;
   public long longlongTest_;
   public long ulonglongTest_;
   public float floatTest_;
   public double doubleTest_;
   public boolean booleanTest_;
   public us.ihmc.idl.generated.test.Color colorTest_;
   public us.ihmc.idl.generated.nested.NestedElement nestedElementTest_;
   public java.lang.StringBuilder stringTest_;
   public int[] longArray_;
   public us.ihmc.idl.generated.nested.NestedElement[][] nestedArray_;
   public java.lang.StringBuilder[] stringArray_;
   public us.ihmc.idl.generated.test.Color[] enumArray_;
   public us.ihmc.idl.IDLSequence.Char  charSeqTest_;
   public us.ihmc.idl.IDLSequence.Char  wcharSeqTest_;
   public us.ihmc.idl.IDLSequence.Byte  octetSeqTest_;
   public us.ihmc.idl.IDLSequence.Short  shortSeqTest_;
   public us.ihmc.idl.IDLSequence.Integer  ushortSeqTest_;
   public us.ihmc.idl.IDLSequence.Integer  longSeqTest_;
   public us.ihmc.idl.IDLSequence.Long  ulongSeqTest_;
   public us.ihmc.idl.IDLSequence.Long  longlongSeqtest_;
   public us.ihmc.idl.IDLSequence.Long  ulonglongSeqTest_;
   public us.ihmc.idl.IDLSequence.Float  floatSeqTest_;
   public us.ihmc.idl.IDLSequence.Double  doubleSeqTest_;
   public us.ihmc.idl.IDLSequence.Boolean  booleanSeqTest_;
   public us.ihmc.idl.IDLSequence.Object<us.ihmc.idl.generated.nested.NestedElement>  nestedSeqTest_;
   public us.ihmc.idl.IDLSequence.Enum<us.ihmc.idl.generated.test.Color> enumSeqTest_;
   public us.ihmc.idl.IDLSequence.StringBuilderHolder  stringSeqTest_;

   public IDLElementTest()
   {
      nestedElementTest_ = new us.ihmc.idl.generated.nested.NestedElement();
      stringTest_ = new java.lang.StringBuilder(255);
      longArray_ = new int[10];

      nestedArray_ = new us.ihmc.idl.generated.nested.NestedElement[5][3];

      for(int i1 = 0; i1 < nestedArray_.length; ++i1)
      {
        for(int i2 = 0; i2 < nestedArray_[i1].length; ++i2)
        {
            nestedArray_[i1][i2] = new us.ihmc.idl.generated.nested.NestedElement();
        }
      }
      stringArray_ = new java.lang.StringBuilder[4];

      for(int i4 = 0; i4 < stringArray_.length; ++i4)
      {
          stringArray_[i4] = new java.lang.StringBuilder();
      }
      enumArray_ = new us.ihmc.idl.generated.test.Color[6];

      charSeqTest_ = new us.ihmc.idl.IDLSequence.Char (25, "type_8");

      wcharSeqTest_ = new us.ihmc.idl.IDLSequence.Char (25, "type_14");

      octetSeqTest_ = new us.ihmc.idl.IDLSequence.Byte (25, "type_9");

      shortSeqTest_ = new us.ihmc.idl.IDLSequence.Short (25, "type_1");

      ushortSeqTest_ = new us.ihmc.idl.IDLSequence.Integer (25, "type_3");

      longSeqTest_ = new us.ihmc.idl.IDLSequence.Integer (25, "type_2");

      ulongSeqTest_ = new us.ihmc.idl.IDLSequence.Long (25, "type_4");

      longlongSeqtest_ = new us.ihmc.idl.IDLSequence.Long (25, "type_11");

      ulonglongSeqTest_ = new us.ihmc.idl.IDLSequence.Long (25, "type_12");

      floatSeqTest_ = new us.ihmc.idl.IDLSequence.Float (25, "type_5");

      doubleSeqTest_ = new us.ihmc.idl.IDLSequence.Double (25, "type_6");

      booleanSeqTest_ = new us.ihmc.idl.IDLSequence.Boolean (25, "type_7");

      nestedSeqTest_ = new us.ihmc.idl.IDLSequence.Object<us.ihmc.idl.generated.nested.NestedElement> (25, new us.ihmc.idl.generated.nested.NestedElementPubSubType());
      enumSeqTest_ = new us.ihmc.idl.IDLSequence.Enum<us.ihmc.idl.generated.test.Color>(25, us.ihmc.idl.generated.test.Color.class, us.ihmc.idl.generated.test.Color.values);

      stringSeqTest_ = new us.ihmc.idl.IDLSequence.StringBuilderHolder (25, "type_d");

   }

   public IDLElementTest(IDLElementTest other)
   {
      this();
      set(other);
   }

   public void set(IDLElementTest other)
   {
      charTest_ = other.charTest_;

      wcharTest_ = other.wcharTest_;

      octetTest_ = other.octetTest_;

      shortTest_ = other.shortTest_;

      ushortTest_ = other.ushortTest_;

      longTest_ = other.longTest_;

      ulongTest_ = other.ulongTest_;

      longlongTest_ = other.longlongTest_;

      ulonglongTest_ = other.ulonglongTest_;

      floatTest_ = other.floatTest_;

      doubleTest_ = other.doubleTest_;

      booleanTest_ = other.booleanTest_;

      colorTest_ = other.colorTest_;

      us.ihmc.idl.generated.nested.NestedElementPubSubType.staticCopy(other.nestedElementTest_, nestedElementTest_);
      stringTest_.setLength(0);
      stringTest_.append(other.stringTest_);

      for(int i6 = 0; i6 < longArray_.length; ++i6)
      {
            longArray_[i6] = other.longArray_[i6];

      }

      for(int i8 = 0; i8 < nestedArray_.length; ++i8)
      {
         for(int i9 = 0; i9 < nestedArray_[i8].length; ++i9)
         {
               us.ihmc.idl.generated.nested.NestedElementPubSubType.staticCopy(other.nestedArray_[i8][i9], nestedArray_[i8][i9]);}
      }

      for(int i11 = 0; i11 < stringArray_.length; ++i11)
      {
            stringArray_[i11].setLength(0);
            stringArray_[i11].append(other.stringArray_[i11]);
      }

      for(int i13 = 0; i13 < enumArray_.length; ++i13)
      {
            enumArray_[i13] = other.enumArray_[i13];

      }

      charSeqTest_.set(other.charSeqTest_);
      wcharSeqTest_.set(other.wcharSeqTest_);
      octetSeqTest_.set(other.octetSeqTest_);
      shortSeqTest_.set(other.shortSeqTest_);
      ushortSeqTest_.set(other.ushortSeqTest_);
      longSeqTest_.set(other.longSeqTest_);
      ulongSeqTest_.set(other.ulongSeqTest_);
      longlongSeqtest_.set(other.longlongSeqtest_);
      ulonglongSeqTest_.set(other.ulonglongSeqTest_);
      floatSeqTest_.set(other.floatSeqTest_);
      doubleSeqTest_.set(other.doubleSeqTest_);
      booleanSeqTest_.set(other.booleanSeqTest_);
      nestedSeqTest_.set(other.nestedSeqTest_);
      enumSeqTest_.set(other.enumSeqTest_);
      stringSeqTest_.set(other.stringSeqTest_);
   }

   public void setCharTest(char charTest)
   {
      charTest_ = charTest;
   }
   public char getCharTest()
   {
      return charTest_;
   }

   public void setWcharTest(char wcharTest)
   {
      wcharTest_ = wcharTest;
   }
   public char getWcharTest()
   {
      return wcharTest_;
   }

   public void setOctetTest(byte octetTest)
   {
      octetTest_ = octetTest;
   }
   public byte getOctetTest()
   {
      return octetTest_;
   }

   public void setShortTest(short shortTest)
   {
      shortTest_ = shortTest;
   }
   public short getShortTest()
   {
      return shortTest_;
   }

   public void setUshortTest(int ushortTest)
   {
      ushortTest_ = ushortTest;
   }
   public int getUshortTest()
   {
      return ushortTest_;
   }

   public void setLongTest(int longTest)
   {
      longTest_ = longTest;
   }
   public int getLongTest()
   {
      return longTest_;
   }

   public void setUlongTest(long ulongTest)
   {
      ulongTest_ = ulongTest;
   }
   public long getUlongTest()
   {
      return ulongTest_;
   }

   public void setLonglongTest(long longlongTest)
   {
      longlongTest_ = longlongTest;
   }
   public long getLonglongTest()
   {
      return longlongTest_;
   }

   public void setUlonglongTest(long ulonglongTest)
   {
      ulonglongTest_ = ulonglongTest;
   }
   public long getUlonglongTest()
   {
      return ulonglongTest_;
   }

   public void setFloatTest(float floatTest)
   {
      floatTest_ = floatTest;
   }
   public float getFloatTest()
   {
      return floatTest_;
   }

   public void setDoubleTest(double doubleTest)
   {
      doubleTest_ = doubleTest;
   }
   public double getDoubleTest()
   {
      return doubleTest_;
   }

   public void setBooleanTest(boolean booleanTest)
   {
      booleanTest_ = booleanTest;
   }
   public boolean getBooleanTest()
   {
      return booleanTest_;
   }

   public void setColorTest(us.ihmc.idl.generated.test.Color colorTest)
   {
      colorTest_ = colorTest;
   }
   public us.ihmc.idl.generated.test.Color getColorTest()
   {
      return colorTest_;
   }


   public us.ihmc.idl.generated.nested.NestedElement getNestedElementTest()
   {
      return nestedElementTest_;
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


   public int[] getLongArray()
   {
      return longArray_;
   }


   public us.ihmc.idl.generated.nested.NestedElement[][] getNestedArray()
   {
      return nestedArray_;
   }


   public java.lang.StringBuilder[] getStringArray()
   {
      return stringArray_;
   }


   public us.ihmc.idl.generated.test.Color[] getEnumArray()
   {
      return enumArray_;
   }


   public us.ihmc.idl.IDLSequence.Char  getCharSeqTest()
   {
      return charSeqTest_;
   }


   public us.ihmc.idl.IDLSequence.Char  getWcharSeqTest()
   {
      return wcharSeqTest_;
   }


   public us.ihmc.idl.IDLSequence.Byte  getOctetSeqTest()
   {
      return octetSeqTest_;
   }


   public us.ihmc.idl.IDLSequence.Short  getShortSeqTest()
   {
      return shortSeqTest_;
   }


   public us.ihmc.idl.IDLSequence.Integer  getUshortSeqTest()
   {
      return ushortSeqTest_;
   }


   public us.ihmc.idl.IDLSequence.Integer  getLongSeqTest()
   {
      return longSeqTest_;
   }


   public us.ihmc.idl.IDLSequence.Long  getUlongSeqTest()
   {
      return ulongSeqTest_;
   }


   public us.ihmc.idl.IDLSequence.Long  getLonglongSeqtest()
   {
      return longlongSeqtest_;
   }


   public us.ihmc.idl.IDLSequence.Long  getUlonglongSeqTest()
   {
      return ulonglongSeqTest_;
   }


   public us.ihmc.idl.IDLSequence.Float  getFloatSeqTest()
   {
      return floatSeqTest_;
   }


   public us.ihmc.idl.IDLSequence.Double  getDoubleSeqTest()
   {
      return doubleSeqTest_;
   }


   public us.ihmc.idl.IDLSequence.Boolean  getBooleanSeqTest()
   {
      return booleanSeqTest_;
   }


   public us.ihmc.idl.IDLSequence.Object<us.ihmc.idl.generated.nested.NestedElement>  getNestedSeqTest()
   {
      return nestedSeqTest_;
   }


   public us.ihmc.idl.IDLSequence.Enum<us.ihmc.idl.generated.test.Color> getEnumSeqTest()
   {
      return enumSeqTest_;
   }


   public us.ihmc.idl.IDLSequence.StringBuilderHolder  getStringSeqTest()
   {
      return stringSeqTest_;
   }


   public static Supplier<IDLElementTestPubSubType> getPubSubType()
   {
      return IDLElementTestPubSubType::new;
   }

   @Override
   public Supplier<TopicDataType> getPubSubTypePacket()
   {
      return IDLElementTestPubSubType::new;
   }

   @Override
   public boolean epsilonEquals(IDLElementTest other, double epsilon)
   {
      if(other == null) return false;
      if(other == this) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.charTest_, other.charTest_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.wcharTest_, other.wcharTest_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.octetTest_, other.octetTest_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.shortTest_, other.shortTest_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.ushortTest_, other.ushortTest_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.longTest_, other.longTest_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.ulongTest_, other.ulongTest_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.longlongTest_, other.longlongTest_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.ulonglongTest_, other.ulonglongTest_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.floatTest_, other.floatTest_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.doubleTest_, other.doubleTest_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.booleanTest_, other.booleanTest_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsEnum(this.colorTest_, other.colorTest_, epsilon)) return false;

      if (!this.nestedElementTest_.epsilonEquals(other.nestedElementTest_, epsilon)) return false;
      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.stringTest_, other.stringTest_, epsilon)) return false;

      for(int i15 = 0; i15 < longArray_.length; ++i15)
      {
                if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.longArray_[i15], other.longArray_[i15], epsilon)) return false;
      }

      for(int i17 = 0; i17 < nestedArray_.length; ++i17)
      {
        for(int i18 = 0; i18 < nestedArray_[i17].length; ++i18)
        {
                if (!this.nestedArray_[i17][i18].epsilonEquals(other.nestedArray_[i17][i18], epsilon)) return false;
        }
      }

      for(int i20 = 0; i20 < stringArray_.length; ++i20)
      {
                if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.stringArray_[i20], other.stringArray_[i20], epsilon)) return false;}

      for(int i22 = 0; i22 < enumArray_.length; ++i22)
      {
                if (!us.ihmc.idl.IDLTools.epsilonEqualsEnum(this.enumArray_[i22], other.enumArray_[i22], epsilon)) return false;
      }

      if (!us.ihmc.idl.IDLTools.epsilonEqualsCharSequence(this.charSeqTest_, other.charSeqTest_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsCharSequence(this.wcharSeqTest_, other.wcharSeqTest_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsByteSequence(this.octetSeqTest_, other.octetSeqTest_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsShortSequence(this.shortSeqTest_, other.shortSeqTest_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsIntegerSequence(this.ushortSeqTest_, other.ushortSeqTest_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsIntegerSequence(this.longSeqTest_, other.longSeqTest_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsLongSequence(this.ulongSeqTest_, other.ulongSeqTest_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsLongSequence(this.longlongSeqtest_, other.longlongSeqtest_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsLongSequence(this.ulonglongSeqTest_, other.ulonglongSeqTest_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsFloatSequence(this.floatSeqTest_, other.floatSeqTest_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsDoubleSequence(this.doubleSeqTest_, other.doubleSeqTest_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBooleanSequence(this.booleanSeqTest_, other.booleanSeqTest_, epsilon)) return false;

      if (this.nestedSeqTest_.size() != other.nestedSeqTest_.size()) { return false; }
      else
      {
         for (int i = 0; i < this.nestedSeqTest_.size(); i++)
         {  if (!this.nestedSeqTest_.get(i).epsilonEquals(other.nestedSeqTest_.get(i), epsilon)) return false; }
      }

      if (!us.ihmc.idl.IDLTools.epsilonEqualsEnumSequence(this.enumSeqTest_, other.enumSeqTest_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilderSequence(this.stringSeqTest_, other.stringSeqTest_, epsilon)) return false;


      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if(other == null) return false;
      if(other == this) return true;
      if(!(other instanceof IDLElementTest)) return false;

      IDLElementTest otherMyClass = (IDLElementTest) other;

      if(this.charTest_ != otherMyClass.charTest_) return false;

      if(this.wcharTest_ != otherMyClass.wcharTest_) return false;

      if(this.octetTest_ != otherMyClass.octetTest_) return false;

      if(this.shortTest_ != otherMyClass.shortTest_) return false;

      if(this.ushortTest_ != otherMyClass.ushortTest_) return false;

      if(this.longTest_ != otherMyClass.longTest_) return false;

      if(this.ulongTest_ != otherMyClass.ulongTest_) return false;

      if(this.longlongTest_ != otherMyClass.longlongTest_) return false;

      if(this.ulonglongTest_ != otherMyClass.ulonglongTest_) return false;

      if(this.floatTest_ != otherMyClass.floatTest_) return false;

      if(this.doubleTest_ != otherMyClass.doubleTest_) return false;

      if(this.booleanTest_ != otherMyClass.booleanTest_) return false;

      if(this.colorTest_ != otherMyClass.colorTest_) return false;

      if (!this.nestedElementTest_.equals(otherMyClass.nestedElementTest_)) return false;
      if (!us.ihmc.idl.IDLTools.equals(this.stringTest_, otherMyClass.stringTest_)) return false;

      for(int i24 = 0; i24 < longArray_.length; ++i24)
      {
                if(this.longArray_[i24] != otherMyClass.longArray_[i24]) return false;

      }
      for(int i26 = 0; i26 < nestedArray_.length; ++i26)
      {
        for(int i27 = 0; i27 < nestedArray_[i26].length; ++i27)
        {
                  if (!this.nestedArray_[i26][i27].equals(otherMyClass.nestedArray_[i26][i27])) return false;
        }
      }
      for(int i29 = 0; i29 < stringArray_.length; ++i29)
      {
                if (!us.ihmc.idl.IDLTools.equals(this.stringArray_[i29], otherMyClass.stringArray_[i29])) return false;}
      for(int i31 = 0; i31 < enumArray_.length; ++i31)
      {
                if(this.enumArray_[i31] != otherMyClass.enumArray_[i31]) return false;

      }
      if (!this.charSeqTest_.equals(otherMyClass.charSeqTest_)) return false;
      if (!this.wcharSeqTest_.equals(otherMyClass.wcharSeqTest_)) return false;
      if (!this.octetSeqTest_.equals(otherMyClass.octetSeqTest_)) return false;
      if (!this.shortSeqTest_.equals(otherMyClass.shortSeqTest_)) return false;
      if (!this.ushortSeqTest_.equals(otherMyClass.ushortSeqTest_)) return false;
      if (!this.longSeqTest_.equals(otherMyClass.longSeqTest_)) return false;
      if (!this.ulongSeqTest_.equals(otherMyClass.ulongSeqTest_)) return false;
      if (!this.longlongSeqtest_.equals(otherMyClass.longlongSeqtest_)) return false;
      if (!this.ulonglongSeqTest_.equals(otherMyClass.ulonglongSeqTest_)) return false;
      if (!this.floatSeqTest_.equals(otherMyClass.floatSeqTest_)) return false;
      if (!this.doubleSeqTest_.equals(otherMyClass.doubleSeqTest_)) return false;
      if (!this.booleanSeqTest_.equals(otherMyClass.booleanSeqTest_)) return false;
      if (!this.nestedSeqTest_.equals(otherMyClass.nestedSeqTest_)) return false;
      if (!this.enumSeqTest_.equals(otherMyClass.enumSeqTest_)) return false;
      if (!this.stringSeqTest_.equals(otherMyClass.stringSeqTest_)) return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("IDLElementTest {");
      builder.append("charTest=");
      builder.append(this.charTest_);      builder.append(", ");
      builder.append("wcharTest=");
      builder.append(this.wcharTest_);      builder.append(", ");
      builder.append("octetTest=");
      builder.append(this.octetTest_);      builder.append(", ");
      builder.append("shortTest=");
      builder.append(this.shortTest_);      builder.append(", ");
      builder.append("ushortTest=");
      builder.append(this.ushortTest_);      builder.append(", ");
      builder.append("longTest=");
      builder.append(this.longTest_);      builder.append(", ");
      builder.append("ulongTest=");
      builder.append(this.ulongTest_);      builder.append(", ");
      builder.append("longlongTest=");
      builder.append(this.longlongTest_);      builder.append(", ");
      builder.append("ulonglongTest=");
      builder.append(this.ulonglongTest_);      builder.append(", ");
      builder.append("floatTest=");
      builder.append(this.floatTest_);      builder.append(", ");
      builder.append("doubleTest=");
      builder.append(this.doubleTest_);      builder.append(", ");
      builder.append("booleanTest=");
      builder.append(this.booleanTest_);      builder.append(", ");
      builder.append("colorTest=");
      builder.append(this.colorTest_);      builder.append(", ");
      builder.append("nestedElementTest=");
      builder.append(this.nestedElementTest_);      builder.append(", ");
      builder.append("stringTest=");
      builder.append(this.stringTest_);      builder.append(", ");
      builder.append("longArray=");
      builder.append(java.util.Arrays.toString(this.longArray_));      builder.append(", ");
      builder.append("nestedArray=");
      builder.append(java.util.Arrays.deepToString(this.nestedArray_));      builder.append(", ");
      builder.append("stringArray=");
      builder.append(java.util.Arrays.toString(this.stringArray_));      builder.append(", ");
      builder.append("enumArray=");
      builder.append(java.util.Arrays.toString(this.enumArray_));      builder.append(", ");
      builder.append("charSeqTest=");
      builder.append(this.charSeqTest_);      builder.append(", ");
      builder.append("wcharSeqTest=");
      builder.append(this.wcharSeqTest_);      builder.append(", ");
      builder.append("octetSeqTest=");
      builder.append(this.octetSeqTest_);      builder.append(", ");
      builder.append("shortSeqTest=");
      builder.append(this.shortSeqTest_);      builder.append(", ");
      builder.append("ushortSeqTest=");
      builder.append(this.ushortSeqTest_);      builder.append(", ");
      builder.append("longSeqTest=");
      builder.append(this.longSeqTest_);      builder.append(", ");
      builder.append("ulongSeqTest=");
      builder.append(this.ulongSeqTest_);      builder.append(", ");
      builder.append("longlongSeqtest=");
      builder.append(this.longlongSeqtest_);      builder.append(", ");
      builder.append("ulonglongSeqTest=");
      builder.append(this.ulonglongSeqTest_);      builder.append(", ");
      builder.append("floatSeqTest=");
      builder.append(this.floatSeqTest_);      builder.append(", ");
      builder.append("doubleSeqTest=");
      builder.append(this.doubleSeqTest_);      builder.append(", ");
      builder.append("booleanSeqTest=");
      builder.append(this.booleanSeqTest_);      builder.append(", ");
      builder.append("nestedSeqTest=");
      builder.append(this.nestedSeqTest_);      builder.append(", ");
      builder.append("enumSeqTest=");
      builder.append(this.enumSeqTest_);      builder.append(", ");
      builder.append("stringSeqTest=");
      builder.append(this.stringSeqTest_);
      builder.append("}");
      return builder.toString();
   }
}

package us.ihmc.idl.generated.test;

/**
* 
* Topic data type of the struct "IDLElementTest" defined in "IDLElementTest.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from IDLElementTest.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit IDLElementTest.idl instead.
*
*/
public class IDLElementTestPubSubType implements us.ihmc.pubsub.TopicDataType<us.ihmc.idl.generated.test.IDLElementTest>
{
   public static final java.lang.String name = "test::IDLElementTest";

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(us.ihmc.idl.generated.test.IDLElementTest data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, us.ihmc.idl.generated.test.IDLElementTest data) throws java.io.IOException
   {
      deserializeCDR.deserialize(serializedPayload);
      read(data, deserializeCDR);
      deserializeCDR.finishDeserialize();
   }

   public static int getMaxCdrSerializedSize()
   {
      return getMaxCdrSerializedSize(0);
   }

   public static int getMaxCdrSerializedSize(int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 2 + us.ihmc.idl.CDR.alignment(current_alignment, 2);

      current_alignment += 2 + us.ihmc.idl.CDR.alignment(current_alignment, 2);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += us.ihmc.idl.generated.nested.NestedElementPubSubType.getMaxCdrSerializedSize(current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;
      current_alignment += ((10) * 4) + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      for(int i0 = 0; i0 < (5 * 3); ++i0)
      {
          current_alignment += us.ihmc.idl.generated.nested.NestedElementPubSubType.getMaxCdrSerializedSize(current_alignment);}
      for(int i0 = 0; i0 < (4); ++i0)
      {
          current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;
      }
      current_alignment += ((6) * 4) + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);current_alignment += (25 * 1) + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);current_alignment += (25 * 4) + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);current_alignment += (25 * 1) + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);current_alignment += (25 * 2) + us.ihmc.idl.CDR.alignment(current_alignment, 2);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);current_alignment += (25 * 2) + us.ihmc.idl.CDR.alignment(current_alignment, 2);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);current_alignment += (25 * 4) + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);current_alignment += (25 * 4) + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);current_alignment += (25 * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);current_alignment += (25 * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);current_alignment += (25 * 4) + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);current_alignment += (25 * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);current_alignment += (25 * 1) + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 25; ++i0)
      {
          current_alignment += us.ihmc.idl.generated.nested.NestedElementPubSubType.getMaxCdrSerializedSize(current_alignment);}
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);current_alignment += (25 * 4) + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 25; ++i0)
      {
        current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;
      }

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(us.ihmc.idl.generated.test.IDLElementTest data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(us.ihmc.idl.generated.test.IDLElementTest data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 2 + us.ihmc.idl.CDR.alignment(current_alignment, 2);


      current_alignment += 2 + us.ihmc.idl.CDR.alignment(current_alignment, 2);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += us.ihmc.idl.generated.nested.NestedElementPubSubType.getCdrSerializedSize(data.getNestedElementTest(), current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getStringTest().length() + 1;

      current_alignment += ((10) * 4) + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getNestedArray().length; ++i0)
      {
          for(int i1 = 0; i1 < data.getNestedArray()[i0].length; ++i1)
          {
                  current_alignment += us.ihmc.idl.generated.nested.NestedElementPubSubType.getCdrSerializedSize(data.getNestedArray()[i0][i1], current_alignment);
          }
      }
      for(int i0 = 0; i0 < data.getStringArray().length; ++i0)
      {
              current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getStringArray()[i0].length() + 1;

      }
      current_alignment += ((6) * 4) + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (data.getCharSeqTest().size() * 1) + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (data.getWcharSeqTest().size() * 4) + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (data.getOctetSeqTest().size() * 1) + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (data.getShortSeqTest().size() * 2) + us.ihmc.idl.CDR.alignment(current_alignment, 2);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (data.getUshortSeqTest().size() * 2) + us.ihmc.idl.CDR.alignment(current_alignment, 2);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (data.getLongSeqTest().size() * 4) + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (data.getUlongSeqTest().size() * 4) + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (data.getLonglongSeqtest().size() * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (data.getUlonglongSeqTest().size() * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (data.getFloatSeqTest().size() * 4) + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (data.getDoubleSeqTest().size() * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (data.getBooleanSeqTest().size() * 1) + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getNestedSeqTest().size(); ++i0)
      {
          current_alignment += us.ihmc.idl.generated.nested.NestedElementPubSubType.getCdrSerializedSize(data.getNestedSeqTest().get(i0), current_alignment);}

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (data.getEnumSeqTest().size() * 4) + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getStringSeqTest().size(); ++i0)
      {
          current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getStringSeqTest().get(i0).length() + 1;
      }

      return current_alignment - initial_alignment;
   }

   public static void write(us.ihmc.idl.generated.test.IDLElementTest data, us.ihmc.idl.CDR cdr)
   {
      cdr.write_type_8(data.getCharTest());

      cdr.write_type_14(data.getWcharTest());

      cdr.write_type_9(data.getOctetTest());

      cdr.write_type_1(data.getShortTest());

      cdr.write_type_3(data.getUshortTest());

      cdr.write_type_2(data.getLongTest());

      cdr.write_type_4(data.getUlongTest());

      cdr.write_type_11(data.getLonglongTest());

      cdr.write_type_12(data.getUlonglongTest());

      cdr.write_type_5(data.getFloatTest());

      cdr.write_type_6(data.getDoubleTest());

      cdr.write_type_7(data.getBooleanTest());

      cdr.write_type_c(data.getColorTest().ordinal());


      us.ihmc.idl.generated.nested.NestedElementPubSubType.write(data.getNestedElementTest(), cdr);
      if(data.getStringTest().length() <= 255)
      cdr.write_type_d(data.getStringTest());else
          throw new RuntimeException("stringTest field exceeds the maximum length");

      for(int i0 = 0; i0 < data.getLongArray().length; ++i0)
      {
        	cdr.write_type_2(data.getLongArray()[i0]);	
      }

      for(int i0 = 0; i0 < data.getNestedArray().length; ++i0)
      {
        for(int i1 = 0; i1 < data.getNestedArray()[i0].length; ++i1)
        {
          	us.ihmc.idl.generated.nested.NestedElementPubSubType.write(data.getNestedArray()[i0][i1], cdr);		
        }
      }

      for(int i0 = 0; i0 < data.getStringArray().length; ++i0)
      {
        	cdr.write_type_d(data.getStringArray()[i0]);	
      }

      for(int i0 = 0; i0 < data.getEnumArray().length; ++i0)
      {
            if (data.getEnumArray()[i0] == null)
        	   cdr.write_type_c(-1);
            else
        	   cdr.write_type_c(data.getEnumArray()[i0].ordinal());
        	
      }

      if(data.getCharSeqTest().size() <= 25)
      cdr.write_type_e(data.getCharSeqTest());else
          throw new RuntimeException("charSeqTest field exceeds the maximum length");

      if(data.getWcharSeqTest().size() <= 25)
      cdr.write_type_e(data.getWcharSeqTest());else
          throw new RuntimeException("wcharSeqTest field exceeds the maximum length");

      if(data.getOctetSeqTest().size() <= 25)
      cdr.write_type_e(data.getOctetSeqTest());else
          throw new RuntimeException("octetSeqTest field exceeds the maximum length");

      if(data.getShortSeqTest().size() <= 25)
      cdr.write_type_e(data.getShortSeqTest());else
          throw new RuntimeException("shortSeqTest field exceeds the maximum length");

      if(data.getUshortSeqTest().size() <= 25)
      cdr.write_type_e(data.getUshortSeqTest());else
          throw new RuntimeException("ushortSeqTest field exceeds the maximum length");

      if(data.getLongSeqTest().size() <= 25)
      cdr.write_type_e(data.getLongSeqTest());else
          throw new RuntimeException("longSeqTest field exceeds the maximum length");

      if(data.getUlongSeqTest().size() <= 25)
      cdr.write_type_e(data.getUlongSeqTest());else
          throw new RuntimeException("ulongSeqTest field exceeds the maximum length");

      if(data.getLonglongSeqtest().size() <= 25)
      cdr.write_type_e(data.getLonglongSeqtest());else
          throw new RuntimeException("longlongSeqtest field exceeds the maximum length");

      if(data.getUlonglongSeqTest().size() <= 25)
      cdr.write_type_e(data.getUlonglongSeqTest());else
          throw new RuntimeException("ulonglongSeqTest field exceeds the maximum length");

      if(data.getFloatSeqTest().size() <= 25)
      cdr.write_type_e(data.getFloatSeqTest());else
          throw new RuntimeException("floatSeqTest field exceeds the maximum length");

      if(data.getDoubleSeqTest().size() <= 25)
      cdr.write_type_e(data.getDoubleSeqTest());else
          throw new RuntimeException("doubleSeqTest field exceeds the maximum length");

      if(data.getBooleanSeqTest().size() <= 25)
      cdr.write_type_e(data.getBooleanSeqTest());else
          throw new RuntimeException("booleanSeqTest field exceeds the maximum length");

      if(data.getNestedSeqTest().size() <= 25)
      cdr.write_type_e(data.getNestedSeqTest());else
          throw new RuntimeException("nestedSeqTest field exceeds the maximum length");

      if(data.getEnumSeqTest().size() <= 25)
      cdr.write_type_e(data.getEnumSeqTest());else
          throw new RuntimeException("enumSeqTest field exceeds the maximum length");

      if(data.getStringSeqTest().size() <= 25)
      cdr.write_type_e(data.getStringSeqTest());else
          throw new RuntimeException("stringSeqTest field exceeds the maximum length");

   }

   public static void read(us.ihmc.idl.generated.test.IDLElementTest data, us.ihmc.idl.CDR cdr)
   {
      data.setCharTest(cdr.read_type_8());
      	
      data.setWcharTest(cdr.read_type_14());
      	
      data.setOctetTest(cdr.read_type_9());
      	
      data.setShortTest(cdr.read_type_1());
      	
      data.setUshortTest(cdr.read_type_3());
      	
      data.setLongTest(cdr.read_type_2());
      	
      data.setUlongTest(cdr.read_type_4());
      	
      data.setLonglongTest(cdr.read_type_11());
      	
      data.setUlonglongTest(cdr.read_type_12());
      	
      data.setFloatTest(cdr.read_type_5());
      	
      data.setDoubleTest(cdr.read_type_6());
      	
      data.setBooleanTest(cdr.read_type_7());
      	
      data.setColorTest(us.ihmc.idl.generated.test.Color.values[cdr.read_type_c()]);
      	
      us.ihmc.idl.generated.nested.NestedElementPubSubType.read(data.getNestedElementTest(), cdr);	
      cdr.read_type_d(data.getStringTest());	
      for(int i0 = 0; i0 < data.getLongArray().length; ++i0)
      {
        	data.getLongArray()[i0] = cdr.read_type_2();
        	
      }
      	
      for(int i0 = 0; i0 < data.getNestedArray().length; ++i0)
      {
        for(int i1 = 0; i1 < data.getNestedArray()[i0].length; ++i1)
        {
          	us.ihmc.idl.generated.nested.NestedElementPubSubType.read(data.getNestedArray()[i0][i1], cdr);	
        }
      }
      	
      for(int i0 = 0; i0 < data.getStringArray().length; ++i0)
      {
        	cdr.read_type_d(data.getStringArray()[i0]);	
      }
      	
      for(int i0 = 0; i0 < data.getEnumArray().length; ++i0)
      {
           int ordinal = cdr.read_type_c();
           if (ordinal < 0)
        	  data.getEnumArray()[i0] = null;
           else
              data.getEnumArray()[i0] = us.ihmc.idl.generated.test.Color.values[ordinal];
        	
      }
      	
      cdr.read_type_e(data.getCharSeqTest());	
      cdr.read_type_e(data.getWcharSeqTest());	
      cdr.read_type_e(data.getOctetSeqTest());	
      cdr.read_type_e(data.getShortSeqTest());	
      cdr.read_type_e(data.getUshortSeqTest());	
      cdr.read_type_e(data.getLongSeqTest());	
      cdr.read_type_e(data.getUlongSeqTest());	
      cdr.read_type_e(data.getLonglongSeqtest());	
      cdr.read_type_e(data.getUlonglongSeqTest());	
      cdr.read_type_e(data.getFloatSeqTest());	
      cdr.read_type_e(data.getDoubleSeqTest());	
      cdr.read_type_e(data.getBooleanSeqTest());	
      cdr.read_type_e(data.getNestedSeqTest());	
      cdr.read_type_e(data.getEnumSeqTest());	
      cdr.read_type_e(data.getStringSeqTest());	

   }

   @Override
   public final void serialize(us.ihmc.idl.generated.test.IDLElementTest data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_8("charTest", data.getCharTest());
      ser.write_type_14("wcharTest", data.getWcharTest());
      ser.write_type_9("octetTest", data.getOctetTest());
      ser.write_type_1("shortTest", data.getShortTest());
      ser.write_type_3("ushortTest", data.getUshortTest());
      ser.write_type_2("longTest", data.getLongTest());
      ser.write_type_4("ulongTest", data.getUlongTest());
      ser.write_type_11("longlongTest", data.getLonglongTest());
      ser.write_type_12("ulonglongTest", data.getUlonglongTest());
      ser.write_type_5("floatTest", data.getFloatTest());
      ser.write_type_6("doubleTest", data.getDoubleTest());
      ser.write_type_7("booleanTest", data.getBooleanTest());
      ser.write_type_c("colorTest", data.getColorTest());
      ser.write_type_a("nestedElementTest", new us.ihmc.idl.generated.nested.NestedElementPubSubType(), data.getNestedElementTest());

      ser.write_type_d("stringTest", data.getStringTest());
      ser.write_type_f("longArray", data.getLongArray());
      ser.write_type_f("nestedArray", new us.ihmc.idl.generated.nested.NestedElementPubSubType(), data.getNestedArray());
      ser.write_type_f("stringArray", data.getStringArray());
      ser.write_type_f("enumArray", data.getEnumArray());
      ser.write_type_e("charSeqTest", data.getCharSeqTest());
      ser.write_type_e("wcharSeqTest", data.getWcharSeqTest());
      ser.write_type_e("octetSeqTest", data.getOctetSeqTest());
      ser.write_type_e("shortSeqTest", data.getShortSeqTest());
      ser.write_type_e("ushortSeqTest", data.getUshortSeqTest());
      ser.write_type_e("longSeqTest", data.getLongSeqTest());
      ser.write_type_e("ulongSeqTest", data.getUlongSeqTest());
      ser.write_type_e("longlongSeqtest", data.getLonglongSeqtest());
      ser.write_type_e("ulonglongSeqTest", data.getUlonglongSeqTest());
      ser.write_type_e("floatSeqTest", data.getFloatSeqTest());
      ser.write_type_e("doubleSeqTest", data.getDoubleSeqTest());
      ser.write_type_e("booleanSeqTest", data.getBooleanSeqTest());
      ser.write_type_e("nestedSeqTest", data.getNestedSeqTest());
      ser.write_type_e("enumSeqTest", data.getEnumSeqTest());
      ser.write_type_e("stringSeqTest", data.getStringSeqTest());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, us.ihmc.idl.generated.test.IDLElementTest data)
   {
      data.setCharTest(ser.read_type_8("charTest"));
      data.setWcharTest(ser.read_type_14("wcharTest"));
      data.setOctetTest(ser.read_type_9("octetTest"));
      data.setShortTest(ser.read_type_1("shortTest"));
      data.setUshortTest(ser.read_type_3("ushortTest"));
      data.setLongTest(ser.read_type_2("longTest"));
      data.setUlongTest(ser.read_type_4("ulongTest"));
      data.setLonglongTest(ser.read_type_11("longlongTest"));
      data.setUlonglongTest(ser.read_type_12("ulonglongTest"));
      data.setFloatTest(ser.read_type_5("floatTest"));
      data.setDoubleTest(ser.read_type_6("doubleTest"));
      data.setBooleanTest(ser.read_type_7("booleanTest"));
      data.setColorTest((us.ihmc.idl.generated.test.Color)ser.read_type_c("colorTest", us.ihmc.idl.generated.test.Color.class));

      ser.read_type_a("nestedElementTest", new us.ihmc.idl.generated.nested.NestedElementPubSubType(), data.getNestedElementTest());

      ser.read_type_d("stringTest", data.getStringTest());
      ser.read_type_f("longArray", data.getLongArray());
      ser.read_type_f("nestedArray", new us.ihmc.idl.generated.nested.NestedElementPubSubType(), data.getNestedArray());
      ser.read_type_f("stringArray", data.getStringArray());
      ser.read_type_f("enumArray", data.getEnumArray());
      ser.read_type_e("charSeqTest", data.getCharSeqTest());
      ser.read_type_e("wcharSeqTest", data.getWcharSeqTest());
      ser.read_type_e("octetSeqTest", data.getOctetSeqTest());
      ser.read_type_e("shortSeqTest", data.getShortSeqTest());
      ser.read_type_e("ushortSeqTest", data.getUshortSeqTest());
      ser.read_type_e("longSeqTest", data.getLongSeqTest());
      ser.read_type_e("ulongSeqTest", data.getUlongSeqTest());
      ser.read_type_e("longlongSeqtest", data.getLonglongSeqtest());
      ser.read_type_e("ulonglongSeqTest", data.getUlonglongSeqTest());
      ser.read_type_e("floatSeqTest", data.getFloatSeqTest());
      ser.read_type_e("doubleSeqTest", data.getDoubleSeqTest());
      ser.read_type_e("booleanSeqTest", data.getBooleanSeqTest());
      ser.read_type_e("nestedSeqTest", data.getNestedSeqTest());
      ser.read_type_e("enumSeqTest", data.getEnumSeqTest());
      ser.read_type_e("stringSeqTest", data.getStringSeqTest());
   }

   public static void staticCopy(us.ihmc.idl.generated.test.IDLElementTest src, us.ihmc.idl.generated.test.IDLElementTest dest)
   {
      dest.set(src);
   }

   @Override
   public us.ihmc.idl.generated.test.IDLElementTest createData()
   {
      return new us.ihmc.idl.generated.test.IDLElementTest();
   }
   @Override
   public int getTypeSize()
   {
      return us.ihmc.idl.CDR.getTypeSize(getMaxCdrSerializedSize());
   }

   @Override
   public java.lang.String getName()
   {
      return name;
   }
   
   public void serialize(us.ihmc.idl.generated.test.IDLElementTest data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(us.ihmc.idl.generated.test.IDLElementTest data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(us.ihmc.idl.generated.test.IDLElementTest src, us.ihmc.idl.generated.test.IDLElementTest dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public IDLElementTestPubSubType newInstance()
   {
      return new IDLElementTestPubSubType();
   }
}

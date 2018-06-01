package us.ihmc.idl.generated.test;

/**
* 
* Topic data type of the struct "IDLFeatureMessage" defined in "IDLFeatureMessage.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from IDLFeatureMessage.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit IDLFeatureMessage.idl instead.
*
*/
public class IDLFeatureMessagePubSubType implements us.ihmc.pubsub.TopicDataType<us.ihmc.idl.generated.test.IDLFeatureMessage>
{
   public static final java.lang.String name = "test::IDLFeatureMessage";

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(us.ihmc.idl.generated.test.IDLFeatureMessage data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, us.ihmc.idl.generated.test.IDLFeatureMessage data) throws java.io.IOException
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

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += us.ihmc.idl.generated.test.IDLSubmessagePubSubType.getMaxCdrSerializedSize(current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 100; ++i0)
      {
          current_alignment += us.ihmc.idl.generated.test.IDLSubmessagePubSubType.getMaxCdrSerializedSize(current_alignment);}
      for(int i0 = 0; i0 < (3); ++i0)
      {
          current_alignment += us.ihmc.idl.generated.test.IDLSubmessagePubSubType.getMaxCdrSerializedSize(current_alignment);}
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 3; ++i0)
      {
          current_alignment += us.ihmc.idl.generated.test.IDLSubmessagePubSubType.getMaxCdrSerializedSize(current_alignment);}
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 10 + 1;
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 5; ++i0)
      {
        current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;
      }
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 100; ++i0)
      {
        current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 10 + 1;
      }
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 5; ++i0)
      {
        current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 10 + 1;
      }

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(us.ihmc.idl.generated.test.IDLFeatureMessage data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(us.ihmc.idl.generated.test.IDLFeatureMessage data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += us.ihmc.idl.generated.test.IDLSubmessagePubSubType.getCdrSerializedSize(data.getNum1(), current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getNum2().size(); ++i0)
      {
          current_alignment += us.ihmc.idl.generated.test.IDLSubmessagePubSubType.getCdrSerializedSize(data.getNum2().get(i0), current_alignment);}

      for(int i0 = 0; i0 < data.getNum3().length; ++i0)
      {
              current_alignment += us.ihmc.idl.generated.test.IDLSubmessagePubSubType.getCdrSerializedSize(data.getNum3()[i0], current_alignment);
      }
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getNum4().size(); ++i0)
      {
          current_alignment += us.ihmc.idl.generated.test.IDLSubmessagePubSubType.getCdrSerializedSize(data.getNum4().get(i0), current_alignment);}

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getStr1().length() + 1;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getStr2().length() + 1;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getStr3().size(); ++i0)
      {
          current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getStr3().get(i0).length() + 1;
      }
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getStr4().size(); ++i0)
      {
          current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getStr4().get(i0).length() + 1;
      }
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getStr5().size(); ++i0)
      {
          current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getStr5().get(i0).length() + 1;
      }

      return current_alignment - initial_alignment;
   }

   public static void write(us.ihmc.idl.generated.test.IDLFeatureMessage data, us.ihmc.idl.CDR cdr)
   {
      cdr.write_type_11(data.getNum());

      cdr.write_type_11(data.getNoDefaultWithDoc());

      cdr.write_type_11(data.getNoDocNum());

      cdr.write_type_2(data.getHello());

      us.ihmc.idl.generated.test.IDLSubmessagePubSubType.write(data.getNum1(), cdr);
      if(data.getNum2().size() <= 100)
      cdr.write_type_e(data.getNum2());else
          throw new RuntimeException("num2 field exceeds the maximum length");

      for(int i0 = 0; i0 < data.getNum3().length; ++i0)
      {
        	us.ihmc.idl.generated.test.IDLSubmessagePubSubType.write(data.getNum3()[i0], cdr);		
      }

      if(data.getNum4().size() <= 3)
      cdr.write_type_e(data.getNum4());else
          throw new RuntimeException("num4 field exceeds the maximum length");

      if(data.getStr1().length() <= 255)
      cdr.write_type_d(data.getStr1());else
          throw new RuntimeException("str1 field exceeds the maximum length");

      if(data.getStr2().length() <= 10)
      cdr.write_type_d(data.getStr2());else
          throw new RuntimeException("str2 field exceeds the maximum length");

      if(data.getStr3().size() <= 5)
      cdr.write_type_e(data.getStr3());else
          throw new RuntimeException("str3 field exceeds the maximum length");

      if(data.getStr4().size() <= 100)
      cdr.write_type_e(data.getStr4());else
          throw new RuntimeException("str4 field exceeds the maximum length");

      if(data.getStr5().size() <= 5)
      cdr.write_type_e(data.getStr5());else
          throw new RuntimeException("str5 field exceeds the maximum length");

   }

   public static void read(us.ihmc.idl.generated.test.IDLFeatureMessage data, us.ihmc.idl.CDR cdr)
   {
      data.setNum(cdr.read_type_11());
      	
      data.setNoDefaultWithDoc(cdr.read_type_11());
      	
      data.setNoDocNum(cdr.read_type_11());
      	
      data.setHello(cdr.read_type_2());
      	
      us.ihmc.idl.generated.test.IDLSubmessagePubSubType.read(data.getNum1(), cdr);	
      cdr.read_type_e(data.getNum2());	
      for(int i0 = 0; i0 < data.getNum3().length; ++i0)
      {
        	us.ihmc.idl.generated.test.IDLSubmessagePubSubType.read(data.getNum3()[i0], cdr);	
      }
      	
      cdr.read_type_e(data.getNum4());	
      cdr.read_type_d(data.getStr1());	
      cdr.read_type_d(data.getStr2());	
      cdr.read_type_e(data.getStr3());	
      cdr.read_type_e(data.getStr4());	
      cdr.read_type_e(data.getStr5());	

   }

   @Override
   public final void serialize(us.ihmc.idl.generated.test.IDLFeatureMessage data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_11("num", data.getNum());
      ser.write_type_11("no_default_with_doc", data.getNoDefaultWithDoc());
      ser.write_type_11("no_doc_num", data.getNoDocNum());
      ser.write_type_2("hello", data.getHello());
      ser.write_type_a("num1", new us.ihmc.idl.generated.test.IDLSubmessagePubSubType(), data.getNum1());

      ser.write_type_e("num2", data.getNum2());
      ser.write_type_f("num3", new us.ihmc.idl.generated.test.IDLSubmessagePubSubType(), data.getNum3());
      ser.write_type_e("num4", data.getNum4());
      ser.write_type_d("str1", data.getStr1());
      ser.write_type_d("str2", data.getStr2());
      ser.write_type_e("str3", data.getStr3());
      ser.write_type_e("str4", data.getStr4());
      ser.write_type_e("str5", data.getStr5());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, us.ihmc.idl.generated.test.IDLFeatureMessage data)
   {
      data.setNum(ser.read_type_11("num"));
      data.setNoDefaultWithDoc(ser.read_type_11("no_default_with_doc"));
      data.setNoDocNum(ser.read_type_11("no_doc_num"));
      data.setHello(ser.read_type_2("hello"));
      ser.read_type_a("num1", new us.ihmc.idl.generated.test.IDLSubmessagePubSubType(), data.getNum1());

      ser.read_type_e("num2", data.getNum2());
      ser.read_type_f("num3", new us.ihmc.idl.generated.test.IDLSubmessagePubSubType(), data.getNum3());
      ser.read_type_e("num4", data.getNum4());
      ser.read_type_d("str1", data.getStr1());
      ser.read_type_d("str2", data.getStr2());
      ser.read_type_e("str3", data.getStr3());
      ser.read_type_e("str4", data.getStr4());
      ser.read_type_e("str5", data.getStr5());
   }

   public static void staticCopy(us.ihmc.idl.generated.test.IDLFeatureMessage src, us.ihmc.idl.generated.test.IDLFeatureMessage dest)
   {
      dest.set(src);
   }

   @Override
   public us.ihmc.idl.generated.test.IDLFeatureMessage createData()
   {
      return new us.ihmc.idl.generated.test.IDLFeatureMessage();
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
   
   public void serialize(us.ihmc.idl.generated.test.IDLFeatureMessage data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(us.ihmc.idl.generated.test.IDLFeatureMessage data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(us.ihmc.idl.generated.test.IDLFeatureMessage src, us.ihmc.idl.generated.test.IDLFeatureMessage dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public IDLFeatureMessagePubSubType newInstance()
   {
      return new IDLFeatureMessagePubSubType();
   }
}

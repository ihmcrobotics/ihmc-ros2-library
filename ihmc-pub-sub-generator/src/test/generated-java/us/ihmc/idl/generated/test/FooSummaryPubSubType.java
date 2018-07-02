package us.ihmc.idl.generated.test;

/**
* 
* Topic data type of the struct "FooSummary" defined in "FooHandshake.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from FooHandshake.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit FooHandshake.idl instead.
*
*/
public class FooSummaryPubSubType implements us.ihmc.pubsub.TopicDataType<us.ihmc.idl.generated.test.FooSummary>
{
   public static final java.lang.String name = "test::FooSummary";

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(us.ihmc.idl.generated.test.FooSummary data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, us.ihmc.idl.generated.test.FooSummary data) throws java.io.IOException
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

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 1024 + 1;
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 128; ++i0)
      {
        current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 1024 + 1;
      }

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(us.ihmc.idl.generated.test.FooSummary data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(us.ihmc.idl.generated.test.FooSummary data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getSummaryTriggerVariable().length() + 1;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getSummarizedVariables().size(); ++i0)
      {
          current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getSummarizedVariables().get(i0).length() + 1;
      }

      return current_alignment - initial_alignment;
   }

   public static void write(us.ihmc.idl.generated.test.FooSummary data, us.ihmc.idl.CDR cdr)
   {
      cdr.write_type_7(data.getCreateSummary());

      if(data.getSummaryTriggerVariable().length() <= 1024)
      cdr.write_type_d(data.getSummaryTriggerVariable());else
          throw new RuntimeException("summaryTriggerVariable field exceeds the maximum length");

      if(data.getSummarizedVariables().size() <= 128)
      cdr.write_type_e(data.getSummarizedVariables());else
          throw new RuntimeException("summarizedVariables field exceeds the maximum length");

   }

   public static void read(us.ihmc.idl.generated.test.FooSummary data, us.ihmc.idl.CDR cdr)
   {
      data.setCreateSummary(cdr.read_type_7());
      	
      cdr.read_type_d(data.getSummaryTriggerVariable());	
      cdr.read_type_e(data.getSummarizedVariables());	

   }

   @Override
   public final void serialize(us.ihmc.idl.generated.test.FooSummary data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_7("createSummary", data.getCreateSummary());
      ser.write_type_d("summaryTriggerVariable", data.getSummaryTriggerVariable());
      ser.write_type_e("summarizedVariables", data.getSummarizedVariables());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, us.ihmc.idl.generated.test.FooSummary data)
   {
      data.setCreateSummary(ser.read_type_7("createSummary"));
      ser.read_type_d("summaryTriggerVariable", data.getSummaryTriggerVariable());
      ser.read_type_e("summarizedVariables", data.getSummarizedVariables());
   }

   public static void staticCopy(us.ihmc.idl.generated.test.FooSummary src, us.ihmc.idl.generated.test.FooSummary dest)
   {
      dest.set(src);
   }

   @Override
   public us.ihmc.idl.generated.test.FooSummary createData()
   {
      return new us.ihmc.idl.generated.test.FooSummary();
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
   
   public void serialize(us.ihmc.idl.generated.test.FooSummary data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(us.ihmc.idl.generated.test.FooSummary data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(us.ihmc.idl.generated.test.FooSummary src, us.ihmc.idl.generated.test.FooSummary dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public FooSummaryPubSubType newInstance()
   {
      return new FooSummaryPubSubType();
   }
}

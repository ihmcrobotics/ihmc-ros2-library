package us.ihmc.idl.generated.test;

/**
* 
* Topic data type of the struct "FooHandshake" defined in "FooHandshake.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from FooHandshake.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit FooHandshake.idl instead.
*
*/
public class FooHandshakePubSubType implements us.ihmc.pubsub.TopicDataType<us.ihmc.idl.generated.test.FooHandshake>
{
   public static final java.lang.String name = "test::FooHandshake";

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(us.ihmc.idl.generated.test.FooHandshake data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, us.ihmc.idl.generated.test.FooHandshake data) throws java.io.IOException
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

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 1024; ++i0)
      {
          current_alignment += us.ihmc.idl.generated.test.FooYoRegistryDefinitionPubSubType.getMaxCdrSerializedSize(current_alignment);}
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 32767; ++i0)
      {
          current_alignment += us.ihmc.idl.generated.test.FooYoVariableDefinitionPubSubType.getMaxCdrSerializedSize(current_alignment);}
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 128; ++i0)
      {
          current_alignment += us.ihmc.idl.generated.test.FooJointDefinitionPubSubType.getMaxCdrSerializedSize(current_alignment);}
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 2048; ++i0)
      {
          current_alignment += us.ihmc.idl.generated.test.FooGraphicObjectMessagePubSubType.getMaxCdrSerializedSize(current_alignment);}
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 2048; ++i0)
      {
          current_alignment += us.ihmc.idl.generated.test.FooGraphicObjectMessagePubSubType.getMaxCdrSerializedSize(current_alignment);}
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 1024; ++i0)
      {
          current_alignment += us.ihmc.idl.generated.test.FooEnumTypePubSubType.getMaxCdrSerializedSize(current_alignment);}
      current_alignment += us.ihmc.idl.generated.test.FooSummaryPubSubType.getMaxCdrSerializedSize(current_alignment);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(us.ihmc.idl.generated.test.FooHandshake data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(us.ihmc.idl.generated.test.FooHandshake data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getRegistries().size(); ++i0)
      {
          current_alignment += us.ihmc.idl.generated.test.FooYoRegistryDefinitionPubSubType.getCdrSerializedSize(data.getRegistries().get(i0), current_alignment);}

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getVariables().size(); ++i0)
      {
          current_alignment += us.ihmc.idl.generated.test.FooYoVariableDefinitionPubSubType.getCdrSerializedSize(data.getVariables().get(i0), current_alignment);}

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getJoints().size(); ++i0)
      {
          current_alignment += us.ihmc.idl.generated.test.FooJointDefinitionPubSubType.getCdrSerializedSize(data.getJoints().get(i0), current_alignment);}

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getGraphicObjects().size(); ++i0)
      {
          current_alignment += us.ihmc.idl.generated.test.FooGraphicObjectMessagePubSubType.getCdrSerializedSize(data.getGraphicObjects().get(i0), current_alignment);}

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getArtifacts().size(); ++i0)
      {
          current_alignment += us.ihmc.idl.generated.test.FooGraphicObjectMessagePubSubType.getCdrSerializedSize(data.getArtifacts().get(i0), current_alignment);}

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getEnumTypes().size(); ++i0)
      {
          current_alignment += us.ihmc.idl.generated.test.FooEnumTypePubSubType.getCdrSerializedSize(data.getEnumTypes().get(i0), current_alignment);}

      current_alignment += us.ihmc.idl.generated.test.FooSummaryPubSubType.getCdrSerializedSize(data.getSummary(), current_alignment);


      return current_alignment - initial_alignment;
   }

   public static void write(us.ihmc.idl.generated.test.FooHandshake data, us.ihmc.idl.CDR cdr)
   {
      cdr.write_type_6(data.getDt());

      if(data.getRegistries().size() <= 1024)
      cdr.write_type_e(data.getRegistries());else
          throw new RuntimeException("registries field exceeds the maximum length");

      if(data.getVariables().size() <= 32767)
      cdr.write_type_e(data.getVariables());else
          throw new RuntimeException("variables field exceeds the maximum length");

      if(data.getJoints().size() <= 128)
      cdr.write_type_e(data.getJoints());else
          throw new RuntimeException("joints field exceeds the maximum length");

      if(data.getGraphicObjects().size() <= 2048)
      cdr.write_type_e(data.getGraphicObjects());else
          throw new RuntimeException("graphicObjects field exceeds the maximum length");

      if(data.getArtifacts().size() <= 2048)
      cdr.write_type_e(data.getArtifacts());else
          throw new RuntimeException("artifacts field exceeds the maximum length");

      if(data.getEnumTypes().size() <= 1024)
      cdr.write_type_e(data.getEnumTypes());else
          throw new RuntimeException("enumTypes field exceeds the maximum length");

      us.ihmc.idl.generated.test.FooSummaryPubSubType.write(data.getSummary(), cdr);
   }

   public static void read(us.ihmc.idl.generated.test.FooHandshake data, us.ihmc.idl.CDR cdr)
   {
      data.setDt(cdr.read_type_6());
      	
      cdr.read_type_e(data.getRegistries());	
      cdr.read_type_e(data.getVariables());	
      cdr.read_type_e(data.getJoints());	
      cdr.read_type_e(data.getGraphicObjects());	
      cdr.read_type_e(data.getArtifacts());	
      cdr.read_type_e(data.getEnumTypes());	
      us.ihmc.idl.generated.test.FooSummaryPubSubType.read(data.getSummary(), cdr);	

   }

   @Override
   public final void serialize(us.ihmc.idl.generated.test.FooHandshake data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_6("dt", data.getDt());
      ser.write_type_e("registries", data.getRegistries());
      ser.write_type_e("variables", data.getVariables());
      ser.write_type_e("joints", data.getJoints());
      ser.write_type_e("graphicObjects", data.getGraphicObjects());
      ser.write_type_e("artifacts", data.getArtifacts());
      ser.write_type_e("enumTypes", data.getEnumTypes());
      ser.write_type_a("summary", new us.ihmc.idl.generated.test.FooSummaryPubSubType(), data.getSummary());

   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, us.ihmc.idl.generated.test.FooHandshake data)
   {
      data.setDt(ser.read_type_6("dt"));
      ser.read_type_e("registries", data.getRegistries());
      ser.read_type_e("variables", data.getVariables());
      ser.read_type_e("joints", data.getJoints());
      ser.read_type_e("graphicObjects", data.getGraphicObjects());
      ser.read_type_e("artifacts", data.getArtifacts());
      ser.read_type_e("enumTypes", data.getEnumTypes());
      ser.read_type_a("summary", new us.ihmc.idl.generated.test.FooSummaryPubSubType(), data.getSummary());

   }

   public static void staticCopy(us.ihmc.idl.generated.test.FooHandshake src, us.ihmc.idl.generated.test.FooHandshake dest)
   {
      dest.set(src);
   }

   @Override
   public us.ihmc.idl.generated.test.FooHandshake createData()
   {
      return new us.ihmc.idl.generated.test.FooHandshake();
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
   
   public void serialize(us.ihmc.idl.generated.test.FooHandshake data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(us.ihmc.idl.generated.test.FooHandshake data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(us.ihmc.idl.generated.test.FooHandshake src, us.ihmc.idl.generated.test.FooHandshake dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public FooHandshakePubSubType newInstance()
   {
      return new FooHandshakePubSubType();
   }
}

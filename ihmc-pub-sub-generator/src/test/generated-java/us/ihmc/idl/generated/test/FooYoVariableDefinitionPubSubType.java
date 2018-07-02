package us.ihmc.idl.generated.test;

/**
* 
* Topic data type of the struct "FooYoVariableDefinition" defined in "FooHandshake.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from FooHandshake.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit FooHandshake.idl instead.
*
*/
public class FooYoVariableDefinitionPubSubType implements us.ihmc.pubsub.TopicDataType<us.ihmc.idl.generated.test.FooYoVariableDefinition>
{
   public static final java.lang.String name = "test::FooYoVariableDefinition";

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(us.ihmc.idl.generated.test.FooYoVariableDefinition data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, us.ihmc.idl.generated.test.FooYoVariableDefinition data) throws java.io.IOException
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

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 2 + us.ihmc.idl.CDR.alignment(current_alignment, 2);

      current_alignment += 2 + us.ihmc.idl.CDR.alignment(current_alignment, 2);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(us.ihmc.idl.generated.test.FooYoVariableDefinition data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(us.ihmc.idl.generated.test.FooYoVariableDefinition data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getName().length() + 1;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getDescription().length() + 1;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 2 + us.ihmc.idl.CDR.alignment(current_alignment, 2);


      current_alignment += 2 + us.ihmc.idl.CDR.alignment(current_alignment, 2);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);



      return current_alignment - initial_alignment;
   }

   public static void write(us.ihmc.idl.generated.test.FooYoVariableDefinition data, us.ihmc.idl.CDR cdr)
   {
      if(data.getName().length() <= 255)
      cdr.write_type_d(data.getName());else
          throw new RuntimeException("name field exceeds the maximum length");

      if(data.getDescription().length() <= 255)
      cdr.write_type_d(data.getDescription());else
          throw new RuntimeException("description field exceeds the maximum length");

      cdr.write_type_c(data.getType().ordinal());


      cdr.write_type_3(data.getRegistry());

      cdr.write_type_3(data.getEnumType());

      cdr.write_type_7(data.getAllowNullValues());

      cdr.write_type_7(data.getIsParameter());

      cdr.write_type_6(data.getMin());

      cdr.write_type_6(data.getMax());

      cdr.write_type_c(data.getLoadStatus().ordinal());


   }

   public static void read(us.ihmc.idl.generated.test.FooYoVariableDefinition data, us.ihmc.idl.CDR cdr)
   {
      cdr.read_type_d(data.getName());	
      cdr.read_type_d(data.getDescription());	
      data.setType(us.ihmc.idl.generated.test.FooYoType.values[cdr.read_type_c()]);
      	
      data.setRegistry(cdr.read_type_3());
      	
      data.setEnumType(cdr.read_type_3());
      	
      data.setAllowNullValues(cdr.read_type_7());
      	
      data.setIsParameter(cdr.read_type_7());
      	
      data.setMin(cdr.read_type_6());
      	
      data.setMax(cdr.read_type_6());
      	
      data.setLoadStatus(us.ihmc.idl.generated.test.FooLoadStatus.values[cdr.read_type_c()]);
      	

   }

   @Override
   public final void serialize(us.ihmc.idl.generated.test.FooYoVariableDefinition data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_d("name", data.getName());
      ser.write_type_d("description", data.getDescription());
      ser.write_type_c("type", data.getType());
      ser.write_type_3("registry", data.getRegistry());
      ser.write_type_3("enumType", data.getEnumType());
      ser.write_type_7("allowNullValues", data.getAllowNullValues());
      ser.write_type_7("isParameter", data.getIsParameter());
      ser.write_type_6("min", data.getMin());
      ser.write_type_6("max", data.getMax());
      ser.write_type_c("loadStatus", data.getLoadStatus());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, us.ihmc.idl.generated.test.FooYoVariableDefinition data)
   {
      ser.read_type_d("name", data.getName());
      ser.read_type_d("description", data.getDescription());
      data.setType((us.ihmc.idl.generated.test.FooYoType)ser.read_type_c("type", us.ihmc.idl.generated.test.FooYoType.class));

      data.setRegistry(ser.read_type_3("registry"));
      data.setEnumType(ser.read_type_3("enumType"));
      data.setAllowNullValues(ser.read_type_7("allowNullValues"));
      data.setIsParameter(ser.read_type_7("isParameter"));
      data.setMin(ser.read_type_6("min"));
      data.setMax(ser.read_type_6("max"));
      data.setLoadStatus((us.ihmc.idl.generated.test.FooLoadStatus)ser.read_type_c("loadStatus", us.ihmc.idl.generated.test.FooLoadStatus.class));

   }

   public static void staticCopy(us.ihmc.idl.generated.test.FooYoVariableDefinition src, us.ihmc.idl.generated.test.FooYoVariableDefinition dest)
   {
      dest.set(src);
   }

   @Override
   public us.ihmc.idl.generated.test.FooYoVariableDefinition createData()
   {
      return new us.ihmc.idl.generated.test.FooYoVariableDefinition();
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
   
   public void serialize(us.ihmc.idl.generated.test.FooYoVariableDefinition data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(us.ihmc.idl.generated.test.FooYoVariableDefinition data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(us.ihmc.idl.generated.test.FooYoVariableDefinition src, us.ihmc.idl.generated.test.FooYoVariableDefinition dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public FooYoVariableDefinitionPubSubType newInstance()
   {
      return new FooYoVariableDefinitionPubSubType();
   }
}

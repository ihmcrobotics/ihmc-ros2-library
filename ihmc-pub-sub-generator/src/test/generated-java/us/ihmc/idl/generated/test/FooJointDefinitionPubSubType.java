package us.ihmc.idl.generated.test;

/**
* 
* Topic data type of the struct "FooJointDefinition" defined in "FooHandshake.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from FooHandshake.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit FooHandshake.idl instead.
*
*/
public class FooJointDefinitionPubSubType implements us.ihmc.pubsub.TopicDataType<us.ihmc.idl.generated.test.FooJointDefinition>
{
   public static final java.lang.String name = "test::FooJointDefinition";

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(us.ihmc.idl.generated.test.FooJointDefinition data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, us.ihmc.idl.generated.test.FooJointDefinition data) throws java.io.IOException
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
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(us.ihmc.idl.generated.test.FooJointDefinition data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(us.ihmc.idl.generated.test.FooJointDefinition data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getName().length() + 1;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);



      return current_alignment - initial_alignment;
   }

   public static void write(us.ihmc.idl.generated.test.FooJointDefinition data, us.ihmc.idl.CDR cdr)
   {
      if(data.getName().length() <= 255)
      cdr.write_type_d(data.getName());else
          throw new RuntimeException("name field exceeds the maximum length");

      cdr.write_type_c(data.getType().ordinal());


   }

   public static void read(us.ihmc.idl.generated.test.FooJointDefinition data, us.ihmc.idl.CDR cdr)
   {
      cdr.read_type_d(data.getName());	
      data.setType(us.ihmc.idl.generated.test.FooJointType.values[cdr.read_type_c()]);
      	

   }

   @Override
   public final void serialize(us.ihmc.idl.generated.test.FooJointDefinition data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_d("name", data.getName());
      ser.write_type_c("type", data.getType());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, us.ihmc.idl.generated.test.FooJointDefinition data)
   {
      ser.read_type_d("name", data.getName());
      data.setType((us.ihmc.idl.generated.test.FooJointType)ser.read_type_c("type", us.ihmc.idl.generated.test.FooJointType.class));

   }

   public static void staticCopy(us.ihmc.idl.generated.test.FooJointDefinition src, us.ihmc.idl.generated.test.FooJointDefinition dest)
   {
      dest.set(src);
   }

   @Override
   public us.ihmc.idl.generated.test.FooJointDefinition createData()
   {
      return new us.ihmc.idl.generated.test.FooJointDefinition();
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
   
   public void serialize(us.ihmc.idl.generated.test.FooJointDefinition data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(us.ihmc.idl.generated.test.FooJointDefinition data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(us.ihmc.idl.generated.test.FooJointDefinition src, us.ihmc.idl.generated.test.FooJointDefinition dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public FooJointDefinitionPubSubType newInstance()
   {
      return new FooJointDefinitionPubSubType();
   }
}

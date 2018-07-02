package us.ihmc.idl.generated.test;

/**
* 
* Topic data type of the struct "FooEnumType" defined in "FooHandshake.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from FooHandshake.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit FooHandshake.idl instead.
*
*/
public class FooEnumTypePubSubType implements us.ihmc.pubsub.TopicDataType<us.ihmc.idl.generated.test.FooEnumType>
{
   public static final java.lang.String name = "test::FooEnumType";

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(us.ihmc.idl.generated.test.FooEnumType data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, us.ihmc.idl.generated.test.FooEnumType data) throws java.io.IOException
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
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 255; ++i0)
      {
        current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;
      }

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(us.ihmc.idl.generated.test.FooEnumType data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(us.ihmc.idl.generated.test.FooEnumType data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getName().length() + 1;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getEnumValues().size(); ++i0)
      {
          current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getEnumValues().get(i0).length() + 1;
      }

      return current_alignment - initial_alignment;
   }

   public static void write(us.ihmc.idl.generated.test.FooEnumType data, us.ihmc.idl.CDR cdr)
   {
      if(data.getName().length() <= 255)
      cdr.write_type_d(data.getName());else
          throw new RuntimeException("name field exceeds the maximum length");

      if(data.getEnumValues().size() <= 255)
      cdr.write_type_e(data.getEnumValues());else
          throw new RuntimeException("enumValues field exceeds the maximum length");

   }

   public static void read(us.ihmc.idl.generated.test.FooEnumType data, us.ihmc.idl.CDR cdr)
   {
      cdr.read_type_d(data.getName());	
      cdr.read_type_e(data.getEnumValues());	

   }

   @Override
   public final void serialize(us.ihmc.idl.generated.test.FooEnumType data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_d("name", data.getName());
      ser.write_type_e("enumValues", data.getEnumValues());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, us.ihmc.idl.generated.test.FooEnumType data)
   {
      ser.read_type_d("name", data.getName());
      ser.read_type_e("enumValues", data.getEnumValues());
   }

   public static void staticCopy(us.ihmc.idl.generated.test.FooEnumType src, us.ihmc.idl.generated.test.FooEnumType dest)
   {
      dest.set(src);
   }

   @Override
   public us.ihmc.idl.generated.test.FooEnumType createData()
   {
      return new us.ihmc.idl.generated.test.FooEnumType();
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
   
   public void serialize(us.ihmc.idl.generated.test.FooEnumType data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(us.ihmc.idl.generated.test.FooEnumType data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(us.ihmc.idl.generated.test.FooEnumType src, us.ihmc.idl.generated.test.FooEnumType dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public FooEnumTypePubSubType newInstance()
   {
      return new FooEnumTypePubSubType();
   }
}

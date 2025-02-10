package type_description_interfaces.msg.dds;

/**
* 
* Topic data type of the struct "IndividualTypeDescription" defined in "IndividualTypeDescription_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from IndividualTypeDescription_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit IndividualTypeDescription_.idl instead.
*
*/
public class IndividualTypeDescriptionPubSubType implements us.ihmc.pubsub.TopicDataType<type_description_interfaces.msg.dds.IndividualTypeDescription>
{
   public static final java.lang.String name = "type_description_interfaces::msg::dds_::IndividualTypeDescription_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "3b184c5feb7f358190c6a45a4b27a64d7fb6df474834d08716c09d76bae5fd68";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(type_description_interfaces.msg.dds.IndividualTypeDescription data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, type_description_interfaces.msg.dds.IndividualTypeDescription data) throws java.io.IOException
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
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 100; ++i0)
      {
          current_alignment += type_description_interfaces.msg.dds.FieldPubSubType.getMaxCdrSerializedSize(current_alignment);}

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(type_description_interfaces.msg.dds.IndividualTypeDescription data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(type_description_interfaces.msg.dds.IndividualTypeDescription data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getTypeName().length() + 1;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getFields().size(); ++i0)
      {
          current_alignment += type_description_interfaces.msg.dds.FieldPubSubType.getCdrSerializedSize(data.getFields().get(i0), current_alignment);}


      return current_alignment - initial_alignment;
   }

   public static void write(type_description_interfaces.msg.dds.IndividualTypeDescription data, us.ihmc.idl.CDR cdr)
   {
      if(data.getTypeName().length() <= 255)
      cdr.write_type_d(data.getTypeName());else
          throw new RuntimeException("type_name field exceeds the maximum length: %d > %d".formatted(data.getTypeName().length(), 255));

      if(data.getFields().size() <= 100)
      cdr.write_type_e(data.getFields());else
          throw new RuntimeException("fields field exceeds the maximum length: %d > %d".formatted(data.getFields().size(), 100));

   }

   public static void read(type_description_interfaces.msg.dds.IndividualTypeDescription data, us.ihmc.idl.CDR cdr)
   {
      cdr.read_type_d(data.getTypeName());	
      cdr.read_type_e(data.getFields());	

   }

   @Override
   public final void serialize(type_description_interfaces.msg.dds.IndividualTypeDescription data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_d("type_name", data.getTypeName());
      ser.write_type_e("fields", data.getFields());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, type_description_interfaces.msg.dds.IndividualTypeDescription data)
   {
      ser.read_type_d("type_name", data.getTypeName());
      ser.read_type_e("fields", data.getFields());
   }

   public static void staticCopy(type_description_interfaces.msg.dds.IndividualTypeDescription src, type_description_interfaces.msg.dds.IndividualTypeDescription dest)
   {
      dest.set(src);
   }

   @Override
   public type_description_interfaces.msg.dds.IndividualTypeDescription createData()
   {
      return new type_description_interfaces.msg.dds.IndividualTypeDescription();
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
   
   public void serialize(type_description_interfaces.msg.dds.IndividualTypeDescription data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(type_description_interfaces.msg.dds.IndividualTypeDescription data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(type_description_interfaces.msg.dds.IndividualTypeDescription src, type_description_interfaces.msg.dds.IndividualTypeDescription dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public IndividualTypeDescriptionPubSubType newInstance()
   {
      return new IndividualTypeDescriptionPubSubType();
   }
}

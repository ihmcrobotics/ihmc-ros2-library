package type_description_interfaces.msg.dds;

/**
* 
* Topic data type of the struct "TypeDescription" defined in "TypeDescription_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from TypeDescription_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit TypeDescription_.idl instead.
*
*/
public class TypeDescriptionPubSubType implements us.ihmc.pubsub.TopicDataType<type_description_interfaces.msg.dds.TypeDescription>
{
   public static final java.lang.String name = "type_description_interfaces::msg::dds_::TypeDescription_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "caaf9f80918a41c8f83c554a872d24881296c2cbbd9eaa0e1434178b6ab657dd";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(type_description_interfaces.msg.dds.TypeDescription data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, type_description_interfaces.msg.dds.TypeDescription data) throws java.io.IOException
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

      current_alignment += type_description_interfaces.msg.dds.IndividualTypeDescriptionPubSubType.getMaxCdrSerializedSize(current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 100; ++i0)
      {
          current_alignment += type_description_interfaces.msg.dds.IndividualTypeDescriptionPubSubType.getMaxCdrSerializedSize(current_alignment);}

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(type_description_interfaces.msg.dds.TypeDescription data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(type_description_interfaces.msg.dds.TypeDescription data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += type_description_interfaces.msg.dds.IndividualTypeDescriptionPubSubType.getCdrSerializedSize(data.getTypeDescription(), current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getReferencedTypeDescriptions().size(); ++i0)
      {
          current_alignment += type_description_interfaces.msg.dds.IndividualTypeDescriptionPubSubType.getCdrSerializedSize(data.getReferencedTypeDescriptions().get(i0), current_alignment);}


      return current_alignment - initial_alignment;
   }

   public static void write(type_description_interfaces.msg.dds.TypeDescription data, us.ihmc.idl.CDR cdr)
   {
      type_description_interfaces.msg.dds.IndividualTypeDescriptionPubSubType.write(data.getTypeDescription(), cdr);
      if(data.getReferencedTypeDescriptions().size() <= 100)
      cdr.write_type_e(data.getReferencedTypeDescriptions());else
          throw new RuntimeException("referenced_type_descriptions field exceeds the maximum length");

   }

   public static void read(type_description_interfaces.msg.dds.TypeDescription data, us.ihmc.idl.CDR cdr)
   {
      type_description_interfaces.msg.dds.IndividualTypeDescriptionPubSubType.read(data.getTypeDescription(), cdr);	
      cdr.read_type_e(data.getReferencedTypeDescriptions());	

   }

   @Override
   public final void serialize(type_description_interfaces.msg.dds.TypeDescription data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("type_description", new type_description_interfaces.msg.dds.IndividualTypeDescriptionPubSubType(), data.getTypeDescription());

      ser.write_type_e("referenced_type_descriptions", data.getReferencedTypeDescriptions());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, type_description_interfaces.msg.dds.TypeDescription data)
   {
      ser.read_type_a("type_description", new type_description_interfaces.msg.dds.IndividualTypeDescriptionPubSubType(), data.getTypeDescription());

      ser.read_type_e("referenced_type_descriptions", data.getReferencedTypeDescriptions());
   }

   public static void staticCopy(type_description_interfaces.msg.dds.TypeDescription src, type_description_interfaces.msg.dds.TypeDescription dest)
   {
      dest.set(src);
   }

   @Override
   public type_description_interfaces.msg.dds.TypeDescription createData()
   {
      return new type_description_interfaces.msg.dds.TypeDescription();
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
   
   public void serialize(type_description_interfaces.msg.dds.TypeDescription data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(type_description_interfaces.msg.dds.TypeDescription data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(type_description_interfaces.msg.dds.TypeDescription src, type_description_interfaces.msg.dds.TypeDescription dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public TypeDescriptionPubSubType newInstance()
   {
      return new TypeDescriptionPubSubType();
   }
}

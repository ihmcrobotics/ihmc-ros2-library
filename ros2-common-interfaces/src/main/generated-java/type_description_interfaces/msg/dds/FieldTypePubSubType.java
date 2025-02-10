package type_description_interfaces.msg.dds;

/**
* 
* Topic data type of the struct "FieldType" defined in "FieldType_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from FieldType_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit FieldType_.idl instead.
*
*/
public class FieldTypePubSubType implements us.ihmc.pubsub.TopicDataType<type_description_interfaces.msg.dds.FieldType>
{
   public static final java.lang.String name = "type_description_interfaces::msg::dds_::FieldType_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "92d331ba99ca0ff645a43f6ba66fc534aec121528ff3f732fba8f38aabea0363";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(type_description_interfaces.msg.dds.FieldType data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, type_description_interfaces.msg.dds.FieldType data) throws java.io.IOException
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

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(type_description_interfaces.msg.dds.FieldType data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(type_description_interfaces.msg.dds.FieldType data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getNestedTypeName().length() + 1;


      return current_alignment - initial_alignment;
   }

   public static void write(type_description_interfaces.msg.dds.FieldType data, us.ihmc.idl.CDR cdr)
   {
      cdr.write_type_9(data.getTypeId());

      cdr.write_type_12(data.getCapacity());

      cdr.write_type_12(data.getStringCapacity());

      if(data.getNestedTypeName().length() <= 255)
      cdr.write_type_d(data.getNestedTypeName());else
          throw new RuntimeException("nested_type_name field exceeds the maximum length: %d > %d".formatted(data.getNestedTypeName().length(), 255));

   }

   public static void read(type_description_interfaces.msg.dds.FieldType data, us.ihmc.idl.CDR cdr)
   {
      data.setTypeId(cdr.read_type_9());
      	
      data.setCapacity(cdr.read_type_12());
      	
      data.setStringCapacity(cdr.read_type_12());
      	
      cdr.read_type_d(data.getNestedTypeName());	

   }

   @Override
   public final void serialize(type_description_interfaces.msg.dds.FieldType data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_9("type_id", data.getTypeId());
      ser.write_type_12("capacity", data.getCapacity());
      ser.write_type_12("string_capacity", data.getStringCapacity());
      ser.write_type_d("nested_type_name", data.getNestedTypeName());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, type_description_interfaces.msg.dds.FieldType data)
   {
      data.setTypeId(ser.read_type_9("type_id"));
      data.setCapacity(ser.read_type_12("capacity"));
      data.setStringCapacity(ser.read_type_12("string_capacity"));
      ser.read_type_d("nested_type_name", data.getNestedTypeName());
   }

   public static void staticCopy(type_description_interfaces.msg.dds.FieldType src, type_description_interfaces.msg.dds.FieldType dest)
   {
      dest.set(src);
   }

   @Override
   public type_description_interfaces.msg.dds.FieldType createData()
   {
      return new type_description_interfaces.msg.dds.FieldType();
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
   
   public void serialize(type_description_interfaces.msg.dds.FieldType data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(type_description_interfaces.msg.dds.FieldType data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(type_description_interfaces.msg.dds.FieldType src, type_description_interfaces.msg.dds.FieldType dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public FieldTypePubSubType newInstance()
   {
      return new FieldTypePubSubType();
   }
}

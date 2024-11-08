package type_description_interfaces.msg.dds;

/**
* 
* Topic data type of the struct "Field" defined in "Field_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from Field_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit Field_.idl instead.
*
*/
public class FieldPubSubType implements us.ihmc.pubsub.TopicDataType<type_description_interfaces.msg.dds.Field>
{
   public static final java.lang.String name = "type_description_interfaces::msg::dds_::Field_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "d684451031f679ae2afe1a94ce37697d79a982cebbe14c26b404459472deb37b";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(type_description_interfaces.msg.dds.Field data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, type_description_interfaces.msg.dds.Field data) throws java.io.IOException
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
      current_alignment += type_description_interfaces.msg.dds.FieldTypePubSubType.getMaxCdrSerializedSize(current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(type_description_interfaces.msg.dds.Field data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(type_description_interfaces.msg.dds.Field data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getName().length() + 1;

      current_alignment += type_description_interfaces.msg.dds.FieldTypePubSubType.getCdrSerializedSize(data.getType(), current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getDefaultValue().length() + 1;


      return current_alignment - initial_alignment;
   }

   public static void write(type_description_interfaces.msg.dds.Field data, us.ihmc.idl.CDR cdr)
   {
      if(data.getName().length() <= 255)
      cdr.write_type_d(data.getName());else
          throw new RuntimeException("name field exceeds the maximum length");

      type_description_interfaces.msg.dds.FieldTypePubSubType.write(data.getType(), cdr);
      if(data.getDefaultValue().length() <= 255)
      cdr.write_type_d(data.getDefaultValue());else
          throw new RuntimeException("default_value field exceeds the maximum length");

   }

   public static void read(type_description_interfaces.msg.dds.Field data, us.ihmc.idl.CDR cdr)
   {
      cdr.read_type_d(data.getName());	
      type_description_interfaces.msg.dds.FieldTypePubSubType.read(data.getType(), cdr);	
      cdr.read_type_d(data.getDefaultValue());	

   }

   @Override
   public final void serialize(type_description_interfaces.msg.dds.Field data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_d("name", data.getName());
      ser.write_type_a("type", new type_description_interfaces.msg.dds.FieldTypePubSubType(), data.getType());

      ser.write_type_d("default_value", data.getDefaultValue());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, type_description_interfaces.msg.dds.Field data)
   {
      ser.read_type_d("name", data.getName());
      ser.read_type_a("type", new type_description_interfaces.msg.dds.FieldTypePubSubType(), data.getType());

      ser.read_type_d("default_value", data.getDefaultValue());
   }

   public static void staticCopy(type_description_interfaces.msg.dds.Field src, type_description_interfaces.msg.dds.Field dest)
   {
      dest.set(src);
   }

   @Override
   public type_description_interfaces.msg.dds.Field createData()
   {
      return new type_description_interfaces.msg.dds.Field();
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
   
   public void serialize(type_description_interfaces.msg.dds.Field data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(type_description_interfaces.msg.dds.Field data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(type_description_interfaces.msg.dds.Field src, type_description_interfaces.msg.dds.Field dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public FieldPubSubType newInstance()
   {
      return new FieldPubSubType();
   }
}

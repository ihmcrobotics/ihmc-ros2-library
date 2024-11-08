package type_description_interfaces.msg.dds;

/**
* 
* Topic data type of the struct "TypeSource" defined in "TypeSource_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from TypeSource_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit TypeSource_.idl instead.
*
*/
public class TypeSourcePubSubType implements us.ihmc.pubsub.TopicDataType<type_description_interfaces.msg.dds.TypeSource>
{
   public static final java.lang.String name = "type_description_interfaces::msg::dds_::TypeSource_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "3a8fe81fe0f2fb519c7180fb8b1b43d7ba7d007304e826fef76561c91a955dcf";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(type_description_interfaces.msg.dds.TypeSource data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, type_description_interfaces.msg.dds.TypeSource data) throws java.io.IOException
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
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(type_description_interfaces.msg.dds.TypeSource data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(type_description_interfaces.msg.dds.TypeSource data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getTypeName().length() + 1;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getEncoding().length() + 1;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getRawFileContents().length() + 1;


      return current_alignment - initial_alignment;
   }

   public static void write(type_description_interfaces.msg.dds.TypeSource data, us.ihmc.idl.CDR cdr)
   {
      if(data.getTypeName().length() <= 255)
      cdr.write_type_d(data.getTypeName());else
          throw new RuntimeException("type_name field exceeds the maximum length");

      if(data.getEncoding().length() <= 255)
      cdr.write_type_d(data.getEncoding());else
          throw new RuntimeException("encoding field exceeds the maximum length");

      if(data.getRawFileContents().length() <= 255)
      cdr.write_type_d(data.getRawFileContents());else
          throw new RuntimeException("raw_file_contents field exceeds the maximum length");

   }

   public static void read(type_description_interfaces.msg.dds.TypeSource data, us.ihmc.idl.CDR cdr)
   {
      cdr.read_type_d(data.getTypeName());	
      cdr.read_type_d(data.getEncoding());	
      cdr.read_type_d(data.getRawFileContents());	

   }

   @Override
   public final void serialize(type_description_interfaces.msg.dds.TypeSource data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_d("type_name", data.getTypeName());
      ser.write_type_d("encoding", data.getEncoding());
      ser.write_type_d("raw_file_contents", data.getRawFileContents());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, type_description_interfaces.msg.dds.TypeSource data)
   {
      ser.read_type_d("type_name", data.getTypeName());
      ser.read_type_d("encoding", data.getEncoding());
      ser.read_type_d("raw_file_contents", data.getRawFileContents());
   }

   public static void staticCopy(type_description_interfaces.msg.dds.TypeSource src, type_description_interfaces.msg.dds.TypeSource dest)
   {
      dest.set(src);
   }

   @Override
   public type_description_interfaces.msg.dds.TypeSource createData()
   {
      return new type_description_interfaces.msg.dds.TypeSource();
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
   
   public void serialize(type_description_interfaces.msg.dds.TypeSource data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(type_description_interfaces.msg.dds.TypeSource data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(type_description_interfaces.msg.dds.TypeSource src, type_description_interfaces.msg.dds.TypeSource dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public TypeSourcePubSubType newInstance()
   {
      return new TypeSourcePubSubType();
   }
}

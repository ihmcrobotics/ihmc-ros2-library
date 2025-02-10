package diagnostic_msgs.msg.dds;

/**
* 
* Topic data type of the struct "DiagnosticStatus" defined in "DiagnosticStatus_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from DiagnosticStatus_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit DiagnosticStatus_.idl instead.
*
*/
public class DiagnosticStatusPubSubType implements us.ihmc.pubsub.TopicDataType<diagnostic_msgs.msg.dds.DiagnosticStatus>
{
   public static final java.lang.String name = "diagnostic_msgs::msg::dds_::DiagnosticStatus_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "ed65de97090d007f46a49babdad1e1e40ff141aee2e8b6b973d683265f29ef7f";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(diagnostic_msgs.msg.dds.DiagnosticStatus data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, diagnostic_msgs.msg.dds.DiagnosticStatus data) throws java.io.IOException
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

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 100; ++i0)
      {
          current_alignment += diagnostic_msgs.msg.dds.KeyValuePubSubType.getMaxCdrSerializedSize(current_alignment);}

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(diagnostic_msgs.msg.dds.DiagnosticStatus data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(diagnostic_msgs.msg.dds.DiagnosticStatus data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getName().length() + 1;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getMessage().length() + 1;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getHardwareId().length() + 1;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getValues().size(); ++i0)
      {
          current_alignment += diagnostic_msgs.msg.dds.KeyValuePubSubType.getCdrSerializedSize(data.getValues().get(i0), current_alignment);}


      return current_alignment - initial_alignment;
   }

   public static void write(diagnostic_msgs.msg.dds.DiagnosticStatus data, us.ihmc.idl.CDR cdr)
   {
      cdr.write_type_9(data.getLevel());

      if(data.getName().length() <= 255)
      cdr.write_type_d(data.getName());else
          throw new RuntimeException("name field exceeds the maximum length: %d > %d".formatted(data.getName().length(), 255));

      if(data.getMessage().length() <= 255)
      cdr.write_type_d(data.getMessage());else
          throw new RuntimeException("message field exceeds the maximum length: %d > %d".formatted(data.getMessage().length(), 255));

      if(data.getHardwareId().length() <= 255)
      cdr.write_type_d(data.getHardwareId());else
          throw new RuntimeException("hardware_id field exceeds the maximum length: %d > %d".formatted(data.getHardwareId().length(), 255));

      if(data.getValues().size() <= 100)
      cdr.write_type_e(data.getValues());else
          throw new RuntimeException("values field exceeds the maximum length: %d > %d".formatted(data.getValues().size(), 100));

   }

   public static void read(diagnostic_msgs.msg.dds.DiagnosticStatus data, us.ihmc.idl.CDR cdr)
   {
      data.setLevel(cdr.read_type_9());
      	
      cdr.read_type_d(data.getName());	
      cdr.read_type_d(data.getMessage());	
      cdr.read_type_d(data.getHardwareId());	
      cdr.read_type_e(data.getValues());	

   }

   @Override
   public final void serialize(diagnostic_msgs.msg.dds.DiagnosticStatus data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_9("level", data.getLevel());
      ser.write_type_d("name", data.getName());
      ser.write_type_d("message", data.getMessage());
      ser.write_type_d("hardware_id", data.getHardwareId());
      ser.write_type_e("values", data.getValues());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, diagnostic_msgs.msg.dds.DiagnosticStatus data)
   {
      data.setLevel(ser.read_type_9("level"));
      ser.read_type_d("name", data.getName());
      ser.read_type_d("message", data.getMessage());
      ser.read_type_d("hardware_id", data.getHardwareId());
      ser.read_type_e("values", data.getValues());
   }

   public static void staticCopy(diagnostic_msgs.msg.dds.DiagnosticStatus src, diagnostic_msgs.msg.dds.DiagnosticStatus dest)
   {
      dest.set(src);
   }

   @Override
   public diagnostic_msgs.msg.dds.DiagnosticStatus createData()
   {
      return new diagnostic_msgs.msg.dds.DiagnosticStatus();
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
   
   public void serialize(diagnostic_msgs.msg.dds.DiagnosticStatus data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(diagnostic_msgs.msg.dds.DiagnosticStatus data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(diagnostic_msgs.msg.dds.DiagnosticStatus src, diagnostic_msgs.msg.dds.DiagnosticStatus dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public DiagnosticStatusPubSubType newInstance()
   {
      return new DiagnosticStatusPubSubType();
   }
}

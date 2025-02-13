package rcl_interfaces.msg.dds;

/**
* 
* Topic data type of the struct "SetLoggerLevelsResult" defined in "SetLoggerLevelsResult_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from SetLoggerLevelsResult_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit SetLoggerLevelsResult_.idl instead.
*
*/
public class SetLoggerLevelsResultPubSubType implements us.ihmc.pubsub.TopicDataType<rcl_interfaces.msg.dds.SetLoggerLevelsResult>
{
   public static final java.lang.String name = "rcl_interfaces::msg::dds_::SetLoggerLevelsResult_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "aa336767610cd49e2d87f86b3d2d82364a6dfbe55a377bceb1bc61f5b0012b9c";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(rcl_interfaces.msg.dds.SetLoggerLevelsResult data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, rcl_interfaces.msg.dds.SetLoggerLevelsResult data) throws java.io.IOException
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

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(rcl_interfaces.msg.dds.SetLoggerLevelsResult data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(rcl_interfaces.msg.dds.SetLoggerLevelsResult data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getReason().length() + 1;


      return current_alignment - initial_alignment;
   }

   public static void write(rcl_interfaces.msg.dds.SetLoggerLevelsResult data, us.ihmc.idl.CDR cdr)
   {
      cdr.write_type_7(data.getSuccessful());

      if(data.getReason().length() <= 255)
      cdr.write_type_d(data.getReason());else
          throw new RuntimeException("reason field exceeds the maximum length: %d > %d".formatted(data.getReason().length(), 255));

   }

   public static void read(rcl_interfaces.msg.dds.SetLoggerLevelsResult data, us.ihmc.idl.CDR cdr)
   {
      data.setSuccessful(cdr.read_type_7());
      	
      cdr.read_type_d(data.getReason());	

   }

   @Override
   public final void serialize(rcl_interfaces.msg.dds.SetLoggerLevelsResult data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_7("successful", data.getSuccessful());
      ser.write_type_d("reason", data.getReason());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, rcl_interfaces.msg.dds.SetLoggerLevelsResult data)
   {
      data.setSuccessful(ser.read_type_7("successful"));
      ser.read_type_d("reason", data.getReason());
   }

   public static void staticCopy(rcl_interfaces.msg.dds.SetLoggerLevelsResult src, rcl_interfaces.msg.dds.SetLoggerLevelsResult dest)
   {
      dest.set(src);
   }

   @Override
   public rcl_interfaces.msg.dds.SetLoggerLevelsResult createData()
   {
      return new rcl_interfaces.msg.dds.SetLoggerLevelsResult();
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
   
   public void serialize(rcl_interfaces.msg.dds.SetLoggerLevelsResult data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(rcl_interfaces.msg.dds.SetLoggerLevelsResult data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(rcl_interfaces.msg.dds.SetLoggerLevelsResult src, rcl_interfaces.msg.dds.SetLoggerLevelsResult dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public SetLoggerLevelsResultPubSubType newInstance()
   {
      return new SetLoggerLevelsResultPubSubType();
   }
}

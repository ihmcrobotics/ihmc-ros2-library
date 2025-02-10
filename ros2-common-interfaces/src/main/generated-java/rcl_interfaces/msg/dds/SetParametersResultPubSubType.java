package rcl_interfaces.msg.dds;

/**
* 
* Topic data type of the struct "SetParametersResult" defined in "SetParametersResult_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from SetParametersResult_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit SetParametersResult_.idl instead.
*
*/
public class SetParametersResultPubSubType implements us.ihmc.pubsub.TopicDataType<rcl_interfaces.msg.dds.SetParametersResult>
{
   public static final java.lang.String name = "rcl_interfaces::msg::dds_::SetParametersResult_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "affbbc10c295dc1bf3a68894d8805bd00a289045903fba7eceb4c842d9b577ec";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(rcl_interfaces.msg.dds.SetParametersResult data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, rcl_interfaces.msg.dds.SetParametersResult data) throws java.io.IOException
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

   public final static int getCdrSerializedSize(rcl_interfaces.msg.dds.SetParametersResult data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(rcl_interfaces.msg.dds.SetParametersResult data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getReason().length() + 1;


      return current_alignment - initial_alignment;
   }

   public static void write(rcl_interfaces.msg.dds.SetParametersResult data, us.ihmc.idl.CDR cdr)
   {
      cdr.write_type_7(data.getSuccessful());

      if(data.getReason().length() <= 255)
      cdr.write_type_d(data.getReason());else
          throw new RuntimeException("reason field exceeds the maximum length: %d > %d".formatted(data.getReason().length(), 255));

   }

   public static void read(rcl_interfaces.msg.dds.SetParametersResult data, us.ihmc.idl.CDR cdr)
   {
      data.setSuccessful(cdr.read_type_7());
      	
      cdr.read_type_d(data.getReason());	

   }

   @Override
   public final void serialize(rcl_interfaces.msg.dds.SetParametersResult data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_7("successful", data.getSuccessful());
      ser.write_type_d("reason", data.getReason());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, rcl_interfaces.msg.dds.SetParametersResult data)
   {
      data.setSuccessful(ser.read_type_7("successful"));
      ser.read_type_d("reason", data.getReason());
   }

   public static void staticCopy(rcl_interfaces.msg.dds.SetParametersResult src, rcl_interfaces.msg.dds.SetParametersResult dest)
   {
      dest.set(src);
   }

   @Override
   public rcl_interfaces.msg.dds.SetParametersResult createData()
   {
      return new rcl_interfaces.msg.dds.SetParametersResult();
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
   
   public void serialize(rcl_interfaces.msg.dds.SetParametersResult data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(rcl_interfaces.msg.dds.SetParametersResult data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(rcl_interfaces.msg.dds.SetParametersResult src, rcl_interfaces.msg.dds.SetParametersResult dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public SetParametersResultPubSubType newInstance()
   {
      return new SetParametersResultPubSubType();
   }
}

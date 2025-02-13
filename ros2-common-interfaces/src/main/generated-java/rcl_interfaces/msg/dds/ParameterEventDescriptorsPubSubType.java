package rcl_interfaces.msg.dds;

/**
* 
* Topic data type of the struct "ParameterEventDescriptors" defined in "ParameterEventDescriptors_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from ParameterEventDescriptors_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit ParameterEventDescriptors_.idl instead.
*
*/
public class ParameterEventDescriptorsPubSubType implements us.ihmc.pubsub.TopicDataType<rcl_interfaces.msg.dds.ParameterEventDescriptors>
{
   public static final java.lang.String name = "rcl_interfaces::msg::dds_::ParameterEventDescriptors_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "6c53ff69ceacd3ff4f8818096131573c4cc4c184ace66f4e412bdd350827952b";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(rcl_interfaces.msg.dds.ParameterEventDescriptors data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, rcl_interfaces.msg.dds.ParameterEventDescriptors data) throws java.io.IOException
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

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 100; ++i0)
      {
          current_alignment += rcl_interfaces.msg.dds.ParameterDescriptorPubSubType.getMaxCdrSerializedSize(current_alignment);}
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 100; ++i0)
      {
          current_alignment += rcl_interfaces.msg.dds.ParameterDescriptorPubSubType.getMaxCdrSerializedSize(current_alignment);}
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 100; ++i0)
      {
          current_alignment += rcl_interfaces.msg.dds.ParameterDescriptorPubSubType.getMaxCdrSerializedSize(current_alignment);}

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(rcl_interfaces.msg.dds.ParameterEventDescriptors data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(rcl_interfaces.msg.dds.ParameterEventDescriptors data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getNewParameters().size(); ++i0)
      {
          current_alignment += rcl_interfaces.msg.dds.ParameterDescriptorPubSubType.getCdrSerializedSize(data.getNewParameters().get(i0), current_alignment);}

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getChangedParameters().size(); ++i0)
      {
          current_alignment += rcl_interfaces.msg.dds.ParameterDescriptorPubSubType.getCdrSerializedSize(data.getChangedParameters().get(i0), current_alignment);}

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getDeletedParameters().size(); ++i0)
      {
          current_alignment += rcl_interfaces.msg.dds.ParameterDescriptorPubSubType.getCdrSerializedSize(data.getDeletedParameters().get(i0), current_alignment);}


      return current_alignment - initial_alignment;
   }

   public static void write(rcl_interfaces.msg.dds.ParameterEventDescriptors data, us.ihmc.idl.CDR cdr)
   {
      if(data.getNewParameters().size() <= 100)
      cdr.write_type_e(data.getNewParameters());else
          throw new RuntimeException("new_parameters field exceeds the maximum length: %d > %d".formatted(data.getNewParameters().size(), 100));

      if(data.getChangedParameters().size() <= 100)
      cdr.write_type_e(data.getChangedParameters());else
          throw new RuntimeException("changed_parameters field exceeds the maximum length: %d > %d".formatted(data.getChangedParameters().size(), 100));

      if(data.getDeletedParameters().size() <= 100)
      cdr.write_type_e(data.getDeletedParameters());else
          throw new RuntimeException("deleted_parameters field exceeds the maximum length: %d > %d".formatted(data.getDeletedParameters().size(), 100));

   }

   public static void read(rcl_interfaces.msg.dds.ParameterEventDescriptors data, us.ihmc.idl.CDR cdr)
   {
      cdr.read_type_e(data.getNewParameters());	
      cdr.read_type_e(data.getChangedParameters());	
      cdr.read_type_e(data.getDeletedParameters());	

   }

   @Override
   public final void serialize(rcl_interfaces.msg.dds.ParameterEventDescriptors data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_e("new_parameters", data.getNewParameters());
      ser.write_type_e("changed_parameters", data.getChangedParameters());
      ser.write_type_e("deleted_parameters", data.getDeletedParameters());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, rcl_interfaces.msg.dds.ParameterEventDescriptors data)
   {
      ser.read_type_e("new_parameters", data.getNewParameters());
      ser.read_type_e("changed_parameters", data.getChangedParameters());
      ser.read_type_e("deleted_parameters", data.getDeletedParameters());
   }

   public static void staticCopy(rcl_interfaces.msg.dds.ParameterEventDescriptors src, rcl_interfaces.msg.dds.ParameterEventDescriptors dest)
   {
      dest.set(src);
   }

   @Override
   public rcl_interfaces.msg.dds.ParameterEventDescriptors createData()
   {
      return new rcl_interfaces.msg.dds.ParameterEventDescriptors();
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
   
   public void serialize(rcl_interfaces.msg.dds.ParameterEventDescriptors data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(rcl_interfaces.msg.dds.ParameterEventDescriptors data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(rcl_interfaces.msg.dds.ParameterEventDescriptors src, rcl_interfaces.msg.dds.ParameterEventDescriptors dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public ParameterEventDescriptorsPubSubType newInstance()
   {
      return new ParameterEventDescriptorsPubSubType();
   }
}

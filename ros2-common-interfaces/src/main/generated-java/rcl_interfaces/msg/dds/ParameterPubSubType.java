package rcl_interfaces.msg.dds;

/**
* 
* Topic data type of the struct "Parameter" defined in "Parameter_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from Parameter_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit Parameter_.idl instead.
*
*/
public class ParameterPubSubType implements us.ihmc.pubsub.TopicDataType<rcl_interfaces.msg.dds.Parameter>
{
   public static final java.lang.String name = "rcl_interfaces::msg::dds_::Parameter_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "41c4b5fb8187db8bed1575ad8f5c693bd25eb3d94a79bf76b64368dec58fcbea";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(rcl_interfaces.msg.dds.Parameter data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, rcl_interfaces.msg.dds.Parameter data) throws java.io.IOException
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
      current_alignment += rcl_interfaces.msg.dds.ParameterValuePubSubType.getMaxCdrSerializedSize(current_alignment);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(rcl_interfaces.msg.dds.Parameter data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(rcl_interfaces.msg.dds.Parameter data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getName().length() + 1;

      current_alignment += rcl_interfaces.msg.dds.ParameterValuePubSubType.getCdrSerializedSize(data.getValue(), current_alignment);


      return current_alignment - initial_alignment;
   }

   public static void write(rcl_interfaces.msg.dds.Parameter data, us.ihmc.idl.CDR cdr)
   {
      if(data.getName().length() <= 255)
      cdr.write_type_d(data.getName());else
          throw new RuntimeException("name field exceeds the maximum length: %d > %d".formatted(data.getName().length(), 255));

      rcl_interfaces.msg.dds.ParameterValuePubSubType.write(data.getValue(), cdr);
   }

   public static void read(rcl_interfaces.msg.dds.Parameter data, us.ihmc.idl.CDR cdr)
   {
      cdr.read_type_d(data.getName());	
      rcl_interfaces.msg.dds.ParameterValuePubSubType.read(data.getValue(), cdr);	

   }

   @Override
   public final void serialize(rcl_interfaces.msg.dds.Parameter data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_d("name", data.getName());
      ser.write_type_a("value", new rcl_interfaces.msg.dds.ParameterValuePubSubType(), data.getValue());

   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, rcl_interfaces.msg.dds.Parameter data)
   {
      ser.read_type_d("name", data.getName());
      ser.read_type_a("value", new rcl_interfaces.msg.dds.ParameterValuePubSubType(), data.getValue());

   }

   public static void staticCopy(rcl_interfaces.msg.dds.Parameter src, rcl_interfaces.msg.dds.Parameter dest)
   {
      dest.set(src);
   }

   @Override
   public rcl_interfaces.msg.dds.Parameter createData()
   {
      return new rcl_interfaces.msg.dds.Parameter();
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
   
   public void serialize(rcl_interfaces.msg.dds.Parameter data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(rcl_interfaces.msg.dds.Parameter data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(rcl_interfaces.msg.dds.Parameter src, rcl_interfaces.msg.dds.Parameter dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public ParameterPubSubType newInstance()
   {
      return new ParameterPubSubType();
   }
}

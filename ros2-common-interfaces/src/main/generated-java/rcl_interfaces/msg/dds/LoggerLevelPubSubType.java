package rcl_interfaces.msg.dds;

/**
* 
* Topic data type of the struct "LoggerLevel" defined in "LoggerLevel_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from LoggerLevel_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit LoggerLevel_.idl instead.
*
*/
public class LoggerLevelPubSubType implements us.ihmc.pubsub.TopicDataType<rcl_interfaces.msg.dds.LoggerLevel>
{
   public static final java.lang.String name = "rcl_interfaces::msg::dds_::LoggerLevel_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "e4042a96cdc3ce71f6363da8a12fa99de8cf0a6e91d086cb70f53bb0c22a2ccc";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(rcl_interfaces.msg.dds.LoggerLevel data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, rcl_interfaces.msg.dds.LoggerLevel data) throws java.io.IOException
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
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(rcl_interfaces.msg.dds.LoggerLevel data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(rcl_interfaces.msg.dds.LoggerLevel data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getName().length() + 1;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);



      return current_alignment - initial_alignment;
   }

   public static void write(rcl_interfaces.msg.dds.LoggerLevel data, us.ihmc.idl.CDR cdr)
   {
      if(data.getName().length() <= 255)
      cdr.write_type_d(data.getName());else
          throw new RuntimeException("name field exceeds the maximum length");

      cdr.write_type_4(data.getLevel());

   }

   public static void read(rcl_interfaces.msg.dds.LoggerLevel data, us.ihmc.idl.CDR cdr)
   {
      cdr.read_type_d(data.getName());	
      data.setLevel(cdr.read_type_4());
      	

   }

   @Override
   public final void serialize(rcl_interfaces.msg.dds.LoggerLevel data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_d("name", data.getName());
      ser.write_type_4("level", data.getLevel());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, rcl_interfaces.msg.dds.LoggerLevel data)
   {
      ser.read_type_d("name", data.getName());
      data.setLevel(ser.read_type_4("level"));
   }

   public static void staticCopy(rcl_interfaces.msg.dds.LoggerLevel src, rcl_interfaces.msg.dds.LoggerLevel dest)
   {
      dest.set(src);
   }

   @Override
   public rcl_interfaces.msg.dds.LoggerLevel createData()
   {
      return new rcl_interfaces.msg.dds.LoggerLevel();
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
   
   public void serialize(rcl_interfaces.msg.dds.LoggerLevel data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(rcl_interfaces.msg.dds.LoggerLevel data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(rcl_interfaces.msg.dds.LoggerLevel src, rcl_interfaces.msg.dds.LoggerLevel dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public LoggerLevelPubSubType newInstance()
   {
      return new LoggerLevelPubSubType();
   }
}

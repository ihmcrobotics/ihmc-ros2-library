package rcl_interfaces.msg.dds;

/**
* 
* Topic data type of the struct "Log" defined in "Log_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from Log_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit Log_.idl instead.
*
*/
public class LogPubSubType implements us.ihmc.pubsub.TopicDataType<rcl_interfaces.msg.dds.Log>
{
   public static final java.lang.String name = "rcl_interfaces::msg::dds_::Log_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "622c54d5fc055721c91be8ef628e2f8ea000c5f33ad543d64ea8267a08149f8f";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(rcl_interfaces.msg.dds.Log data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, rcl_interfaces.msg.dds.Log data) throws java.io.IOException
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

      current_alignment += builtin_interfaces.msg.dds.TimePubSubType.getMaxCdrSerializedSize(current_alignment);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(rcl_interfaces.msg.dds.Log data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(rcl_interfaces.msg.dds.Log data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += builtin_interfaces.msg.dds.TimePubSubType.getCdrSerializedSize(data.getStamp(), current_alignment);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getName().length() + 1;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getMsg().length() + 1;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getFile().length() + 1;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getFunction().length() + 1;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);



      return current_alignment - initial_alignment;
   }

   public static void write(rcl_interfaces.msg.dds.Log data, us.ihmc.idl.CDR cdr)
   {
      builtin_interfaces.msg.dds.TimePubSubType.write(data.getStamp(), cdr);
      cdr.write_type_9(data.getLevel());

      if(data.getName().length() <= 255)
      cdr.write_type_d(data.getName());else
          throw new RuntimeException("name field exceeds the maximum length: %d > %d".formatted(data.getName().length(), 255));

      if(data.getMsg().length() <= 255)
      cdr.write_type_d(data.getMsg());else
          throw new RuntimeException("msg field exceeds the maximum length: %d > %d".formatted(data.getMsg().length(), 255));

      if(data.getFile().length() <= 255)
      cdr.write_type_d(data.getFile());else
          throw new RuntimeException("file field exceeds the maximum length: %d > %d".formatted(data.getFile().length(), 255));

      if(data.getFunction().length() <= 255)
      cdr.write_type_d(data.getFunction());else
          throw new RuntimeException("function field exceeds the maximum length: %d > %d".formatted(data.getFunction().length(), 255));

      cdr.write_type_4(data.getLine());

   }

   public static void read(rcl_interfaces.msg.dds.Log data, us.ihmc.idl.CDR cdr)
   {
      builtin_interfaces.msg.dds.TimePubSubType.read(data.getStamp(), cdr);	
      data.setLevel(cdr.read_type_9());
      	
      cdr.read_type_d(data.getName());	
      cdr.read_type_d(data.getMsg());	
      cdr.read_type_d(data.getFile());	
      cdr.read_type_d(data.getFunction());	
      data.setLine(cdr.read_type_4());
      	

   }

   @Override
   public final void serialize(rcl_interfaces.msg.dds.Log data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("stamp", new builtin_interfaces.msg.dds.TimePubSubType(), data.getStamp());

      ser.write_type_9("level", data.getLevel());
      ser.write_type_d("name", data.getName());
      ser.write_type_d("msg", data.getMsg());
      ser.write_type_d("file", data.getFile());
      ser.write_type_d("function", data.getFunction());
      ser.write_type_4("line", data.getLine());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, rcl_interfaces.msg.dds.Log data)
   {
      ser.read_type_a("stamp", new builtin_interfaces.msg.dds.TimePubSubType(), data.getStamp());

      data.setLevel(ser.read_type_9("level"));
      ser.read_type_d("name", data.getName());
      ser.read_type_d("msg", data.getMsg());
      ser.read_type_d("file", data.getFile());
      ser.read_type_d("function", data.getFunction());
      data.setLine(ser.read_type_4("line"));
   }

   public static void staticCopy(rcl_interfaces.msg.dds.Log src, rcl_interfaces.msg.dds.Log dest)
   {
      dest.set(src);
   }

   @Override
   public rcl_interfaces.msg.dds.Log createData()
   {
      return new rcl_interfaces.msg.dds.Log();
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
   
   public void serialize(rcl_interfaces.msg.dds.Log data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(rcl_interfaces.msg.dds.Log data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(rcl_interfaces.msg.dds.Log src, rcl_interfaces.msg.dds.Log dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public LogPubSubType newInstance()
   {
      return new LogPubSubType();
   }
}

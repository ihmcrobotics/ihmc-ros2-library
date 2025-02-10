package sensor_msgs.msg.dds;

/**
* 
* Topic data type of the struct "TimeReference" defined in "TimeReference_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from TimeReference_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit TimeReference_.idl instead.
*
*/
public class TimeReferencePubSubType implements us.ihmc.pubsub.TopicDataType<sensor_msgs.msg.dds.TimeReference>
{
   public static final java.lang.String name = "sensor_msgs::msg::dds_::TimeReference_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "85fd3a8e2171ad3873e842825bce084599e00198222dfcf78f5987800b8221b2";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(sensor_msgs.msg.dds.TimeReference data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, sensor_msgs.msg.dds.TimeReference data) throws java.io.IOException
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

      current_alignment += std_msgs.msg.dds.HeaderPubSubType.getMaxCdrSerializedSize(current_alignment);

      current_alignment += builtin_interfaces.msg.dds.TimePubSubType.getMaxCdrSerializedSize(current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(sensor_msgs.msg.dds.TimeReference data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(sensor_msgs.msg.dds.TimeReference data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += std_msgs.msg.dds.HeaderPubSubType.getCdrSerializedSize(data.getHeader(), current_alignment);

      current_alignment += builtin_interfaces.msg.dds.TimePubSubType.getCdrSerializedSize(data.getTimeRef(), current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getTimeSource().length() + 1;


      return current_alignment - initial_alignment;
   }

   public static void write(sensor_msgs.msg.dds.TimeReference data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.write(data.getHeader(), cdr);
      builtin_interfaces.msg.dds.TimePubSubType.write(data.getTimeRef(), cdr);
      if(data.getTimeSource().length() <= 255)
      cdr.write_type_d(data.getTimeSource());else
          throw new RuntimeException("timeSource field exceeds the maximum length: %d > %d".formatted(data.getTimeSource().length(), 255));

   }

   public static void read(sensor_msgs.msg.dds.TimeReference data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.read(data.getHeader(), cdr);	
      builtin_interfaces.msg.dds.TimePubSubType.read(data.getTimeRef(), cdr);	
      cdr.read_type_d(data.getTimeSource());	

   }

   @Override
   public final void serialize(sensor_msgs.msg.dds.TimeReference data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.write_type_a("time_ref", new builtin_interfaces.msg.dds.TimePubSubType(), data.getTimeRef());

      ser.write_type_d("timeSource", data.getTimeSource());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, sensor_msgs.msg.dds.TimeReference data)
   {
      ser.read_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.read_type_a("time_ref", new builtin_interfaces.msg.dds.TimePubSubType(), data.getTimeRef());

      ser.read_type_d("timeSource", data.getTimeSource());
   }

   public static void staticCopy(sensor_msgs.msg.dds.TimeReference src, sensor_msgs.msg.dds.TimeReference dest)
   {
      dest.set(src);
   }

   @Override
   public sensor_msgs.msg.dds.TimeReference createData()
   {
      return new sensor_msgs.msg.dds.TimeReference();
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
   
   public void serialize(sensor_msgs.msg.dds.TimeReference data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(sensor_msgs.msg.dds.TimeReference data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(sensor_msgs.msg.dds.TimeReference src, sensor_msgs.msg.dds.TimeReference dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public TimeReferencePubSubType newInstance()
   {
      return new TimeReferencePubSubType();
   }
}

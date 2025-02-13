package sensor_msgs.msg.dds;

/**
* 
* Topic data type of the struct "LaserEcho" defined in "LaserEcho_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from LaserEcho_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit LaserEcho_.idl instead.
*
*/
public class LaserEchoPubSubType implements us.ihmc.pubsub.TopicDataType<sensor_msgs.msg.dds.LaserEcho>
{
   public static final java.lang.String name = "sensor_msgs::msg::dds_::LaserEcho_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "b60ab320cee2e9c80242b806673aa85ec79316476b4d49db9e0f6ac66aa11402";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(sensor_msgs.msg.dds.LaserEcho data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, sensor_msgs.msg.dds.LaserEcho data) throws java.io.IOException
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

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);current_alignment += (100 * 4) + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(sensor_msgs.msg.dds.LaserEcho data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(sensor_msgs.msg.dds.LaserEcho data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (data.getEchoes().size() * 4) + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      return current_alignment - initial_alignment;
   }

   public static void write(sensor_msgs.msg.dds.LaserEcho data, us.ihmc.idl.CDR cdr)
   {
      if(data.getEchoes().size() <= 100)
      cdr.write_type_e(data.getEchoes());else
          throw new RuntimeException("echoes field exceeds the maximum length: %d > %d".formatted(data.getEchoes().size(), 100));

   }

   public static void read(sensor_msgs.msg.dds.LaserEcho data, us.ihmc.idl.CDR cdr)
   {
      cdr.read_type_e(data.getEchoes());	

   }

   @Override
   public final void serialize(sensor_msgs.msg.dds.LaserEcho data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_e("echoes", data.getEchoes());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, sensor_msgs.msg.dds.LaserEcho data)
   {
      ser.read_type_e("echoes", data.getEchoes());
   }

   public static void staticCopy(sensor_msgs.msg.dds.LaserEcho src, sensor_msgs.msg.dds.LaserEcho dest)
   {
      dest.set(src);
   }

   @Override
   public sensor_msgs.msg.dds.LaserEcho createData()
   {
      return new sensor_msgs.msg.dds.LaserEcho();
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
   
   public void serialize(sensor_msgs.msg.dds.LaserEcho data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(sensor_msgs.msg.dds.LaserEcho data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(sensor_msgs.msg.dds.LaserEcho src, sensor_msgs.msg.dds.LaserEcho dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public LaserEchoPubSubType newInstance()
   {
      return new LaserEchoPubSubType();
   }
}

package sensor_msgs.msg.dds;

/**
* 
* Topic data type of the struct "ChannelFloat32" defined in "ChannelFloat32_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from ChannelFloat32_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit ChannelFloat32_.idl instead.
*
*/
public class ChannelFloat32PubSubType implements us.ihmc.pubsub.TopicDataType<sensor_msgs.msg.dds.ChannelFloat32>
{
   public static final java.lang.String name = "sensor_msgs::msg::dds_::ChannelFloat32_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "976f822bff3e35b6664d34fdc94dcf04aa2d798d9a13ad7adfa4347b93dc4ccc";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(sensor_msgs.msg.dds.ChannelFloat32 data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, sensor_msgs.msg.dds.ChannelFloat32 data) throws java.io.IOException
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
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);current_alignment += (100 * 4) + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(sensor_msgs.msg.dds.ChannelFloat32 data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(sensor_msgs.msg.dds.ChannelFloat32 data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getName().length() + 1;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (data.getValues().size() * 4) + us.ihmc.idl.CDR.alignment(current_alignment, 4);



      return current_alignment - initial_alignment;
   }

   public static void write(sensor_msgs.msg.dds.ChannelFloat32 data, us.ihmc.idl.CDR cdr)
   {
      if(data.getName().length() <= 255)
      cdr.write_type_d(data.getName());else
          throw new RuntimeException("name field exceeds the maximum length: %d > %d".formatted(data.getName().length(), 255));

      if(data.getValues().size() <= 100)
      cdr.write_type_e(data.getValues());else
          throw new RuntimeException("values field exceeds the maximum length: %d > %d".formatted(data.getValues().size(), 100));

   }

   public static void read(sensor_msgs.msg.dds.ChannelFloat32 data, us.ihmc.idl.CDR cdr)
   {
      cdr.read_type_d(data.getName());	
      cdr.read_type_e(data.getValues());	

   }

   @Override
   public final void serialize(sensor_msgs.msg.dds.ChannelFloat32 data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_d("name", data.getName());
      ser.write_type_e("values", data.getValues());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, sensor_msgs.msg.dds.ChannelFloat32 data)
   {
      ser.read_type_d("name", data.getName());
      ser.read_type_e("values", data.getValues());
   }

   public static void staticCopy(sensor_msgs.msg.dds.ChannelFloat32 src, sensor_msgs.msg.dds.ChannelFloat32 dest)
   {
      dest.set(src);
   }

   @Override
   public sensor_msgs.msg.dds.ChannelFloat32 createData()
   {
      return new sensor_msgs.msg.dds.ChannelFloat32();
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
   
   public void serialize(sensor_msgs.msg.dds.ChannelFloat32 data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(sensor_msgs.msg.dds.ChannelFloat32 data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(sensor_msgs.msg.dds.ChannelFloat32 src, sensor_msgs.msg.dds.ChannelFloat32 dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public ChannelFloat32PubSubType newInstance()
   {
      return new ChannelFloat32PubSubType();
   }
}

package sensor_msgs.msg.dds;

/**
* 
* Topic data type of the struct "PointCloud" defined in "PointCloud_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from PointCloud_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit PointCloud_.idl instead.
*
*/
public class PointCloudPubSubType implements us.ihmc.pubsub.TopicDataType<sensor_msgs.msg.dds.PointCloud>
{
   public static final java.lang.String name = "sensor_msgs::msg::dds_::PointCloud_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "69cdba19a70d87cda842eb0ba2d46d9a8cc0bff9fbcb839c553c25375d5447c6";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(sensor_msgs.msg.dds.PointCloud data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, sensor_msgs.msg.dds.PointCloud data) throws java.io.IOException
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

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 100; ++i0)
      {
          current_alignment += geometry_msgs.msg.dds.Point32PubSubType.getMaxCdrSerializedSize(current_alignment);}
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 100; ++i0)
      {
          current_alignment += sensor_msgs.msg.dds.ChannelFloat32PubSubType.getMaxCdrSerializedSize(current_alignment);}

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(sensor_msgs.msg.dds.PointCloud data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(sensor_msgs.msg.dds.PointCloud data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += std_msgs.msg.dds.HeaderPubSubType.getCdrSerializedSize(data.getHeader(), current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getPoints().size(); ++i0)
      {
          current_alignment += geometry_msgs.msg.dds.Point32PubSubType.getCdrSerializedSize(data.getPoints().get(i0), current_alignment);}

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getChannels().size(); ++i0)
      {
          current_alignment += sensor_msgs.msg.dds.ChannelFloat32PubSubType.getCdrSerializedSize(data.getChannels().get(i0), current_alignment);}


      return current_alignment - initial_alignment;
   }

   public static void write(sensor_msgs.msg.dds.PointCloud data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.write(data.getHeader(), cdr);
      if(data.getPoints().size() <= 100)
      cdr.write_type_e(data.getPoints());else
          throw new RuntimeException("points field exceeds the maximum length: %d > %d".formatted(data.getPoints().size(), 100));

      if(data.getChannels().size() <= 100)
      cdr.write_type_e(data.getChannels());else
          throw new RuntimeException("channels field exceeds the maximum length: %d > %d".formatted(data.getChannels().size(), 100));

   }

   public static void read(sensor_msgs.msg.dds.PointCloud data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.read(data.getHeader(), cdr);	
      cdr.read_type_e(data.getPoints());	
      cdr.read_type_e(data.getChannels());	

   }

   @Override
   public final void serialize(sensor_msgs.msg.dds.PointCloud data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.write_type_e("points", data.getPoints());
      ser.write_type_e("channels", data.getChannels());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, sensor_msgs.msg.dds.PointCloud data)
   {
      ser.read_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.read_type_e("points", data.getPoints());
      ser.read_type_e("channels", data.getChannels());
   }

   public static void staticCopy(sensor_msgs.msg.dds.PointCloud src, sensor_msgs.msg.dds.PointCloud dest)
   {
      dest.set(src);
   }

   @Override
   public sensor_msgs.msg.dds.PointCloud createData()
   {
      return new sensor_msgs.msg.dds.PointCloud();
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
   
   public void serialize(sensor_msgs.msg.dds.PointCloud data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(sensor_msgs.msg.dds.PointCloud data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(sensor_msgs.msg.dds.PointCloud src, sensor_msgs.msg.dds.PointCloud dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public PointCloudPubSubType newInstance()
   {
      return new PointCloudPubSubType();
   }
}

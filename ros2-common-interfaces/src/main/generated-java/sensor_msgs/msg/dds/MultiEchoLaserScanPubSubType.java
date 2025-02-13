package sensor_msgs.msg.dds;

/**
* 
* Topic data type of the struct "MultiEchoLaserScan" defined in "MultiEchoLaserScan_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from MultiEchoLaserScan_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit MultiEchoLaserScan_.idl instead.
*
*/
public class MultiEchoLaserScanPubSubType implements us.ihmc.pubsub.TopicDataType<sensor_msgs.msg.dds.MultiEchoLaserScan>
{
   public static final java.lang.String name = "sensor_msgs::msg::dds_::MultiEchoLaserScan_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "836c789ac097a941bc80fd47da4441880adb187cb5d151588dfbf99c5c759a31";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(sensor_msgs.msg.dds.MultiEchoLaserScan data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, sensor_msgs.msg.dds.MultiEchoLaserScan data) throws java.io.IOException
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

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 100; ++i0)
      {
          current_alignment += sensor_msgs.msg.dds.LaserEchoPubSubType.getMaxCdrSerializedSize(current_alignment);}
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 100; ++i0)
      {
          current_alignment += sensor_msgs.msg.dds.LaserEchoPubSubType.getMaxCdrSerializedSize(current_alignment);}

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(sensor_msgs.msg.dds.MultiEchoLaserScan data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(sensor_msgs.msg.dds.MultiEchoLaserScan data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += std_msgs.msg.dds.HeaderPubSubType.getCdrSerializedSize(data.getHeader(), current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getRanges().size(); ++i0)
      {
          current_alignment += sensor_msgs.msg.dds.LaserEchoPubSubType.getCdrSerializedSize(data.getRanges().get(i0), current_alignment);}

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getIntensities().size(); ++i0)
      {
          current_alignment += sensor_msgs.msg.dds.LaserEchoPubSubType.getCdrSerializedSize(data.getIntensities().get(i0), current_alignment);}


      return current_alignment - initial_alignment;
   }

   public static void write(sensor_msgs.msg.dds.MultiEchoLaserScan data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.write(data.getHeader(), cdr);
      cdr.write_type_5(data.getAngleMin());

      cdr.write_type_5(data.getAngleMax());

      cdr.write_type_5(data.getAngleIncrement());

      cdr.write_type_5(data.getTimeIncrement());

      cdr.write_type_5(data.getScanTime());

      cdr.write_type_5(data.getRangeMin());

      cdr.write_type_5(data.getRangeMax());

      if(data.getRanges().size() <= 100)
      cdr.write_type_e(data.getRanges());else
          throw new RuntimeException("ranges field exceeds the maximum length: %d > %d".formatted(data.getRanges().size(), 100));

      if(data.getIntensities().size() <= 100)
      cdr.write_type_e(data.getIntensities());else
          throw new RuntimeException("intensities field exceeds the maximum length: %d > %d".formatted(data.getIntensities().size(), 100));

   }

   public static void read(sensor_msgs.msg.dds.MultiEchoLaserScan data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.read(data.getHeader(), cdr);	
      data.setAngleMin(cdr.read_type_5());
      	
      data.setAngleMax(cdr.read_type_5());
      	
      data.setAngleIncrement(cdr.read_type_5());
      	
      data.setTimeIncrement(cdr.read_type_5());
      	
      data.setScanTime(cdr.read_type_5());
      	
      data.setRangeMin(cdr.read_type_5());
      	
      data.setRangeMax(cdr.read_type_5());
      	
      cdr.read_type_e(data.getRanges());	
      cdr.read_type_e(data.getIntensities());	

   }

   @Override
   public final void serialize(sensor_msgs.msg.dds.MultiEchoLaserScan data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.write_type_5("angle_min", data.getAngleMin());
      ser.write_type_5("angle_max", data.getAngleMax());
      ser.write_type_5("angle_increment", data.getAngleIncrement());
      ser.write_type_5("time_increment", data.getTimeIncrement());
      ser.write_type_5("scan_time", data.getScanTime());
      ser.write_type_5("range_min", data.getRangeMin());
      ser.write_type_5("range_max", data.getRangeMax());
      ser.write_type_e("ranges", data.getRanges());
      ser.write_type_e("intensities", data.getIntensities());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, sensor_msgs.msg.dds.MultiEchoLaserScan data)
   {
      ser.read_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      data.setAngleMin(ser.read_type_5("angle_min"));
      data.setAngleMax(ser.read_type_5("angle_max"));
      data.setAngleIncrement(ser.read_type_5("angle_increment"));
      data.setTimeIncrement(ser.read_type_5("time_increment"));
      data.setScanTime(ser.read_type_5("scan_time"));
      data.setRangeMin(ser.read_type_5("range_min"));
      data.setRangeMax(ser.read_type_5("range_max"));
      ser.read_type_e("ranges", data.getRanges());
      ser.read_type_e("intensities", data.getIntensities());
   }

   public static void staticCopy(sensor_msgs.msg.dds.MultiEchoLaserScan src, sensor_msgs.msg.dds.MultiEchoLaserScan dest)
   {
      dest.set(src);
   }

   @Override
   public sensor_msgs.msg.dds.MultiEchoLaserScan createData()
   {
      return new sensor_msgs.msg.dds.MultiEchoLaserScan();
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
   
   public void serialize(sensor_msgs.msg.dds.MultiEchoLaserScan data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(sensor_msgs.msg.dds.MultiEchoLaserScan data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(sensor_msgs.msg.dds.MultiEchoLaserScan src, sensor_msgs.msg.dds.MultiEchoLaserScan dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public MultiEchoLaserScanPubSubType newInstance()
   {
      return new MultiEchoLaserScanPubSubType();
   }
}

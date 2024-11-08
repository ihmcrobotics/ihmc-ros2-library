package statistics_msgs.msg.dds;

/**
* 
* Topic data type of the struct "MetricsMessage" defined in "MetricsMessage_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from MetricsMessage_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit MetricsMessage_.idl instead.
*
*/
public class MetricsMessagePubSubType implements us.ihmc.pubsub.TopicDataType<statistics_msgs.msg.dds.MetricsMessage>
{
   public static final java.lang.String name = "statistics_msgs::msg::dds_::MetricsMessage_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "c6f9a2ed0211b1bbd9f72101e6e8823a00ee74cebcb759c9f9104e3fc0a82e7a";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(statistics_msgs.msg.dds.MetricsMessage data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, statistics_msgs.msg.dds.MetricsMessage data) throws java.io.IOException
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
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;
      current_alignment += builtin_interfaces.msg.dds.TimePubSubType.getMaxCdrSerializedSize(current_alignment);

      current_alignment += builtin_interfaces.msg.dds.TimePubSubType.getMaxCdrSerializedSize(current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 100; ++i0)
      {
          current_alignment += statistics_msgs.msg.dds.StatisticDataPointPubSubType.getMaxCdrSerializedSize(current_alignment);}

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(statistics_msgs.msg.dds.MetricsMessage data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(statistics_msgs.msg.dds.MetricsMessage data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getMeasurementSourceName().length() + 1;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getMetricsSource().length() + 1;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getUnit().length() + 1;

      current_alignment += builtin_interfaces.msg.dds.TimePubSubType.getCdrSerializedSize(data.getWindowStart(), current_alignment);

      current_alignment += builtin_interfaces.msg.dds.TimePubSubType.getCdrSerializedSize(data.getWindowStop(), current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getStatistics().size(); ++i0)
      {
          current_alignment += statistics_msgs.msg.dds.StatisticDataPointPubSubType.getCdrSerializedSize(data.getStatistics().get(i0), current_alignment);}


      return current_alignment - initial_alignment;
   }

   public static void write(statistics_msgs.msg.dds.MetricsMessage data, us.ihmc.idl.CDR cdr)
   {
      if(data.getMeasurementSourceName().length() <= 255)
      cdr.write_type_d(data.getMeasurementSourceName());else
          throw new RuntimeException("measurement_source_name field exceeds the maximum length");

      if(data.getMetricsSource().length() <= 255)
      cdr.write_type_d(data.getMetricsSource());else
          throw new RuntimeException("metrics_source field exceeds the maximum length");

      if(data.getUnit().length() <= 255)
      cdr.write_type_d(data.getUnit());else
          throw new RuntimeException("unit field exceeds the maximum length");

      builtin_interfaces.msg.dds.TimePubSubType.write(data.getWindowStart(), cdr);
      builtin_interfaces.msg.dds.TimePubSubType.write(data.getWindowStop(), cdr);
      if(data.getStatistics().size() <= 100)
      cdr.write_type_e(data.getStatistics());else
          throw new RuntimeException("statistics field exceeds the maximum length");

   }

   public static void read(statistics_msgs.msg.dds.MetricsMessage data, us.ihmc.idl.CDR cdr)
   {
      cdr.read_type_d(data.getMeasurementSourceName());	
      cdr.read_type_d(data.getMetricsSource());	
      cdr.read_type_d(data.getUnit());	
      builtin_interfaces.msg.dds.TimePubSubType.read(data.getWindowStart(), cdr);	
      builtin_interfaces.msg.dds.TimePubSubType.read(data.getWindowStop(), cdr);	
      cdr.read_type_e(data.getStatistics());	

   }

   @Override
   public final void serialize(statistics_msgs.msg.dds.MetricsMessage data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_d("measurement_source_name", data.getMeasurementSourceName());
      ser.write_type_d("metrics_source", data.getMetricsSource());
      ser.write_type_d("unit", data.getUnit());
      ser.write_type_a("window_start", new builtin_interfaces.msg.dds.TimePubSubType(), data.getWindowStart());

      ser.write_type_a("window_stop", new builtin_interfaces.msg.dds.TimePubSubType(), data.getWindowStop());

      ser.write_type_e("statistics", data.getStatistics());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, statistics_msgs.msg.dds.MetricsMessage data)
   {
      ser.read_type_d("measurement_source_name", data.getMeasurementSourceName());
      ser.read_type_d("metrics_source", data.getMetricsSource());
      ser.read_type_d("unit", data.getUnit());
      ser.read_type_a("window_start", new builtin_interfaces.msg.dds.TimePubSubType(), data.getWindowStart());

      ser.read_type_a("window_stop", new builtin_interfaces.msg.dds.TimePubSubType(), data.getWindowStop());

      ser.read_type_e("statistics", data.getStatistics());
   }

   public static void staticCopy(statistics_msgs.msg.dds.MetricsMessage src, statistics_msgs.msg.dds.MetricsMessage dest)
   {
      dest.set(src);
   }

   @Override
   public statistics_msgs.msg.dds.MetricsMessage createData()
   {
      return new statistics_msgs.msg.dds.MetricsMessage();
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
   
   public void serialize(statistics_msgs.msg.dds.MetricsMessage data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(statistics_msgs.msg.dds.MetricsMessage data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(statistics_msgs.msg.dds.MetricsMessage src, statistics_msgs.msg.dds.MetricsMessage dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public MetricsMessagePubSubType newInstance()
   {
      return new MetricsMessagePubSubType();
   }
}

package statistics_msgs.msg.dds;

/**
* 
* Topic data type of the struct "StatisticDataPoint" defined in "StatisticDataPoint_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from StatisticDataPoint_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit StatisticDataPoint_.idl instead.
*
*/
public class StatisticDataPointPubSubType implements us.ihmc.pubsub.TopicDataType<statistics_msgs.msg.dds.StatisticDataPoint>
{
   public static final java.lang.String name = "statistics_msgs::msg::dds_::StatisticDataPoint_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "f3375827966bd72145fde6ffab85a8b70da638fd68066a3d1578d135c1133545";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(statistics_msgs.msg.dds.StatisticDataPoint data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, statistics_msgs.msg.dds.StatisticDataPoint data) throws java.io.IOException
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

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(statistics_msgs.msg.dds.StatisticDataPoint data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(statistics_msgs.msg.dds.StatisticDataPoint data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);



      return current_alignment - initial_alignment;
   }

   public static void write(statistics_msgs.msg.dds.StatisticDataPoint data, us.ihmc.idl.CDR cdr)
   {
      cdr.write_type_9(data.getDataType());

      cdr.write_type_6(data.getData());

   }

   public static void read(statistics_msgs.msg.dds.StatisticDataPoint data, us.ihmc.idl.CDR cdr)
   {
      data.setDataType(cdr.read_type_9());
      	
      data.setData(cdr.read_type_6());
      	

   }

   @Override
   public final void serialize(statistics_msgs.msg.dds.StatisticDataPoint data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_9("data_type", data.getDataType());
      ser.write_type_6("data", data.getData());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, statistics_msgs.msg.dds.StatisticDataPoint data)
   {
      data.setDataType(ser.read_type_9("data_type"));
      data.setData(ser.read_type_6("data"));
   }

   public static void staticCopy(statistics_msgs.msg.dds.StatisticDataPoint src, statistics_msgs.msg.dds.StatisticDataPoint dest)
   {
      dest.set(src);
   }

   @Override
   public statistics_msgs.msg.dds.StatisticDataPoint createData()
   {
      return new statistics_msgs.msg.dds.StatisticDataPoint();
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
   
   public void serialize(statistics_msgs.msg.dds.StatisticDataPoint data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(statistics_msgs.msg.dds.StatisticDataPoint data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(statistics_msgs.msg.dds.StatisticDataPoint src, statistics_msgs.msg.dds.StatisticDataPoint dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public StatisticDataPointPubSubType newInstance()
   {
      return new StatisticDataPointPubSubType();
   }
}

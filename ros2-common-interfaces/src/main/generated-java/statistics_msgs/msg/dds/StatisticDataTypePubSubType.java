package statistics_msgs.msg.dds;

/**
* 
* Topic data type of the struct "StatisticDataType" defined in "StatisticDataType_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from StatisticDataType_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit StatisticDataType_.idl instead.
*
*/
public class StatisticDataTypePubSubType implements us.ihmc.pubsub.TopicDataType<statistics_msgs.msg.dds.StatisticDataType>
{
   public static final java.lang.String name = "statistics_msgs::msg::dds_::StatisticDataType_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "5ec83fc55a6d99a66ede1d9b28f572cd31329a4dd1d4268e4b53e08fbc39b9f5";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(statistics_msgs.msg.dds.StatisticDataType data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, statistics_msgs.msg.dds.StatisticDataType data) throws java.io.IOException
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


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(statistics_msgs.msg.dds.StatisticDataType data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(statistics_msgs.msg.dds.StatisticDataType data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);



      return current_alignment - initial_alignment;
   }

   public static void write(statistics_msgs.msg.dds.StatisticDataType data, us.ihmc.idl.CDR cdr)
   {
      cdr.write_type_7(data.getUnusedPlaceholderField());

   }

   public static void read(statistics_msgs.msg.dds.StatisticDataType data, us.ihmc.idl.CDR cdr)
   {
      data.setUnusedPlaceholderField(cdr.read_type_7());
      	

   }

   @Override
   public final void serialize(statistics_msgs.msg.dds.StatisticDataType data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_7("unused_placeholder_field", data.getUnusedPlaceholderField());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, statistics_msgs.msg.dds.StatisticDataType data)
   {
      data.setUnusedPlaceholderField(ser.read_type_7("unused_placeholder_field"));   }

   public static void staticCopy(statistics_msgs.msg.dds.StatisticDataType src, statistics_msgs.msg.dds.StatisticDataType dest)
   {
      dest.set(src);
   }

   @Override
   public statistics_msgs.msg.dds.StatisticDataType createData()
   {
      return new statistics_msgs.msg.dds.StatisticDataType();
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
   
   public void serialize(statistics_msgs.msg.dds.StatisticDataType data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(statistics_msgs.msg.dds.StatisticDataType data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(statistics_msgs.msg.dds.StatisticDataType src, statistics_msgs.msg.dds.StatisticDataType dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public StatisticDataTypePubSubType newInstance()
   {
      return new StatisticDataTypePubSubType();
   }
}

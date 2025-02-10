package nav_msgs.msg.dds;

/**
* 
* Topic data type of the struct "OccupancyGrid" defined in "OccupancyGrid_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from OccupancyGrid_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit OccupancyGrid_.idl instead.
*
*/
public class OccupancyGridPubSubType implements us.ihmc.pubsub.TopicDataType<nav_msgs.msg.dds.OccupancyGrid>
{
   public static final java.lang.String name = "nav_msgs::msg::dds_::OccupancyGrid_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "3491cd941c89106597a3eb6a19d4b15aab1f13e1007c5410917a9bc7c4d7661c";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(nav_msgs.msg.dds.OccupancyGrid data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, nav_msgs.msg.dds.OccupancyGrid data) throws java.io.IOException
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

      current_alignment += nav_msgs.msg.dds.MapMetaDataPubSubType.getMaxCdrSerializedSize(current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);current_alignment += (100 * 1) + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(nav_msgs.msg.dds.OccupancyGrid data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(nav_msgs.msg.dds.OccupancyGrid data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += std_msgs.msg.dds.HeaderPubSubType.getCdrSerializedSize(data.getHeader(), current_alignment);

      current_alignment += nav_msgs.msg.dds.MapMetaDataPubSubType.getCdrSerializedSize(data.getInfo(), current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (data.getData().size() * 1) + us.ihmc.idl.CDR.alignment(current_alignment, 1);



      return current_alignment - initial_alignment;
   }

   public static void write(nav_msgs.msg.dds.OccupancyGrid data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.write(data.getHeader(), cdr);
      nav_msgs.msg.dds.MapMetaDataPubSubType.write(data.getInfo(), cdr);
      if(data.getData().size() <= 100)
      cdr.write_type_e(data.getData());else
          throw new RuntimeException("data field exceeds the maximum length: %d > %d".formatted(data.getData().size(), 100));

   }

   public static void read(nav_msgs.msg.dds.OccupancyGrid data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.read(data.getHeader(), cdr);	
      nav_msgs.msg.dds.MapMetaDataPubSubType.read(data.getInfo(), cdr);	
      cdr.read_type_e(data.getData());	

   }

   @Override
   public final void serialize(nav_msgs.msg.dds.OccupancyGrid data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.write_type_a("info", new nav_msgs.msg.dds.MapMetaDataPubSubType(), data.getInfo());

      ser.write_type_e("data", data.getData());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, nav_msgs.msg.dds.OccupancyGrid data)
   {
      ser.read_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.read_type_a("info", new nav_msgs.msg.dds.MapMetaDataPubSubType(), data.getInfo());

      ser.read_type_e("data", data.getData());
   }

   public static void staticCopy(nav_msgs.msg.dds.OccupancyGrid src, nav_msgs.msg.dds.OccupancyGrid dest)
   {
      dest.set(src);
   }

   @Override
   public nav_msgs.msg.dds.OccupancyGrid createData()
   {
      return new nav_msgs.msg.dds.OccupancyGrid();
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
   
   public void serialize(nav_msgs.msg.dds.OccupancyGrid data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(nav_msgs.msg.dds.OccupancyGrid data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(nav_msgs.msg.dds.OccupancyGrid src, nav_msgs.msg.dds.OccupancyGrid dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public OccupancyGridPubSubType newInstance()
   {
      return new OccupancyGridPubSubType();
   }
}

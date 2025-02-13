package nav_msgs.msg.dds;

/**
* 
* Topic data type of the struct "GridCells" defined in "GridCells_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from GridCells_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit GridCells_.idl instead.
*
*/
public class GridCellsPubSubType implements us.ihmc.pubsub.TopicDataType<nav_msgs.msg.dds.GridCells>
{
   public static final java.lang.String name = "nav_msgs::msg::dds_::GridCells_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "25da9fb0f1b14f317b4c8f0d178db20114b4b6d0a86174f5b424d420f37ece78";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(nav_msgs.msg.dds.GridCells data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, nav_msgs.msg.dds.GridCells data) throws java.io.IOException
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

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 100; ++i0)
      {
          current_alignment += geometry_msgs.msg.dds.PointPubSubType.getMaxCdrSerializedSize(current_alignment);}

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(nav_msgs.msg.dds.GridCells data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(nav_msgs.msg.dds.GridCells data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += std_msgs.msg.dds.HeaderPubSubType.getCdrSerializedSize(data.getHeader(), current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getCells().size(); ++i0)
      {
          current_alignment += geometry_msgs.msg.dds.PointPubSubType.getCdrSerializedSize(data.getCells().get(i0), current_alignment);}


      return current_alignment - initial_alignment;
   }

   public static void write(nav_msgs.msg.dds.GridCells data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.write(data.getHeader(), cdr);
      cdr.write_type_5(data.getCellWidth());

      cdr.write_type_5(data.getCellHeight());

      if(data.getCells().size() <= 100)
      cdr.write_type_e(data.getCells());else
          throw new RuntimeException("cells field exceeds the maximum length: %d > %d".formatted(data.getCells().size(), 100));

   }

   public static void read(nav_msgs.msg.dds.GridCells data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.read(data.getHeader(), cdr);	
      data.setCellWidth(cdr.read_type_5());
      	
      data.setCellHeight(cdr.read_type_5());
      	
      cdr.read_type_e(data.getCells());	

   }

   @Override
   public final void serialize(nav_msgs.msg.dds.GridCells data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.write_type_5("cell_width", data.getCellWidth());
      ser.write_type_5("cell_height", data.getCellHeight());
      ser.write_type_e("cells", data.getCells());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, nav_msgs.msg.dds.GridCells data)
   {
      ser.read_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      data.setCellWidth(ser.read_type_5("cell_width"));
      data.setCellHeight(ser.read_type_5("cell_height"));
      ser.read_type_e("cells", data.getCells());
   }

   public static void staticCopy(nav_msgs.msg.dds.GridCells src, nav_msgs.msg.dds.GridCells dest)
   {
      dest.set(src);
   }

   @Override
   public nav_msgs.msg.dds.GridCells createData()
   {
      return new nav_msgs.msg.dds.GridCells();
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
   
   public void serialize(nav_msgs.msg.dds.GridCells data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(nav_msgs.msg.dds.GridCells data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(nav_msgs.msg.dds.GridCells src, nav_msgs.msg.dds.GridCells dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public GridCellsPubSubType newInstance()
   {
      return new GridCellsPubSubType();
   }
}

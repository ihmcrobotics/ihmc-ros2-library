package sensor_msgs.msg.dds;

/**
* 
* Topic data type of the struct "PointCloud2" defined in "PointCloud2_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from PointCloud2_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit PointCloud2_.idl instead.
*
*/
public class PointCloud2PubSubType implements us.ihmc.pubsub.TopicDataType<sensor_msgs.msg.dds.PointCloud2>
{
   public static final java.lang.String name = "sensor_msgs::msg::dds_::PointCloud2_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "be3a876aa4717e7738568e9d10542dceccdf593f18fd61b7a90359c0ca8d8f81";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(sensor_msgs.msg.dds.PointCloud2 data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, sensor_msgs.msg.dds.PointCloud2 data) throws java.io.IOException
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

      for(int i0 = 0; i0 < (16); ++i0)
      {
          current_alignment += sensor_msgs.msg.dds.PointFieldPubSubType.getMaxCdrSerializedSize(current_alignment);}
      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += ((25000000) * 1) + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(sensor_msgs.msg.dds.PointCloud2 data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(sensor_msgs.msg.dds.PointCloud2 data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += std_msgs.msg.dds.HeaderPubSubType.getCdrSerializedSize(data.getHeader(), current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      for(int i0 = 0; i0 < data.getFields().length; ++i0)
      {
              current_alignment += sensor_msgs.msg.dds.PointFieldPubSubType.getCdrSerializedSize(data.getFields()[i0], current_alignment);
      }
      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += ((25000000) * 1) + us.ihmc.idl.CDR.alignment(current_alignment, 1);
      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);



      return current_alignment - initial_alignment;
   }

   public static void write(sensor_msgs.msg.dds.PointCloud2 data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.write(data.getHeader(), cdr);
      cdr.write_type_4(data.getHeight());

      cdr.write_type_4(data.getWidth());

      for(int i0 = 0; i0 < data.getFields().length; ++i0)
      {
        	sensor_msgs.msg.dds.PointFieldPubSubType.write(data.getFields()[i0], cdr);		
      }

      cdr.write_type_7(data.getIsBigendian());

      cdr.write_type_4(data.getPointStep());

      cdr.write_type_4(data.getRowStep());

      for(int i0 = 0; i0 < data.getData().length; ++i0)
      {
        	cdr.write_type_9(data.getData()[i0]);	
      }

      cdr.write_type_7(data.getIsDense());

   }

   public static void read(sensor_msgs.msg.dds.PointCloud2 data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.read(data.getHeader(), cdr);	
      data.setHeight(cdr.read_type_4());
      	
      data.setWidth(cdr.read_type_4());
      	
      for(int i0 = 0; i0 < data.getFields().length; ++i0)
      {
        	sensor_msgs.msg.dds.PointFieldPubSubType.read(data.getFields()[i0], cdr);	
      }
      	
      data.setIsBigendian(cdr.read_type_7());
      	
      data.setPointStep(cdr.read_type_4());
      	
      data.setRowStep(cdr.read_type_4());
      	
      for(int i0 = 0; i0 < data.getData().length; ++i0)
      {
        	data.getData()[i0] = cdr.read_type_9();
        	
      }
      	
      data.setIsDense(cdr.read_type_7());
      	

   }

   @Override
   public final void serialize(sensor_msgs.msg.dds.PointCloud2 data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.write_type_4("height", data.getHeight());
      ser.write_type_4("width", data.getWidth());
      ser.write_type_f("fields", new sensor_msgs.msg.dds.PointFieldPubSubType(), data.getFields());
      ser.write_type_7("is_bigendian", data.getIsBigendian());
      ser.write_type_4("point_step", data.getPointStep());
      ser.write_type_4("row_step", data.getRowStep());
      ser.write_type_f("data", data.getData());
      ser.write_type_7("is_dense", data.getIsDense());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, sensor_msgs.msg.dds.PointCloud2 data)
   {
      ser.read_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      data.setHeight(ser.read_type_4("height"));
      data.setWidth(ser.read_type_4("width"));
      ser.read_type_f("fields", new sensor_msgs.msg.dds.PointFieldPubSubType(), data.getFields());
      data.setIsBigendian(ser.read_type_7("is_bigendian"));
      data.setPointStep(ser.read_type_4("point_step"));
      data.setRowStep(ser.read_type_4("row_step"));
      ser.read_type_f("data", data.getData());
      data.setIsDense(ser.read_type_7("is_dense"));
   }

   public static void staticCopy(sensor_msgs.msg.dds.PointCloud2 src, sensor_msgs.msg.dds.PointCloud2 dest)
   {
      dest.set(src);
   }

   @Override
   public sensor_msgs.msg.dds.PointCloud2 createData()
   {
      return new sensor_msgs.msg.dds.PointCloud2();
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
   
   public void serialize(sensor_msgs.msg.dds.PointCloud2 data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(sensor_msgs.msg.dds.PointCloud2 data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(sensor_msgs.msg.dds.PointCloud2 src, sensor_msgs.msg.dds.PointCloud2 dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public PointCloud2PubSubType newInstance()
   {
      return new PointCloud2PubSubType();
   }
}

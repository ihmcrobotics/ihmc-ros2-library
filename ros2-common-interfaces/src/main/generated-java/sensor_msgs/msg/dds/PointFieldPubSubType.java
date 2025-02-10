package sensor_msgs.msg.dds;

/**
* 
* Topic data type of the struct "PointField" defined in "PointField_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from PointField_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit PointField_.idl instead.
*
*/
public class PointFieldPubSubType implements us.ihmc.pubsub.TopicDataType<sensor_msgs.msg.dds.PointField>
{
   public static final java.lang.String name = "sensor_msgs::msg::dds_::PointField_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "b1e8f26da12f5feee902afdd9758c69d1b9c4f789af3ffbcea7f331b5ff0b780";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(sensor_msgs.msg.dds.PointField data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, sensor_msgs.msg.dds.PointField data) throws java.io.IOException
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
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(sensor_msgs.msg.dds.PointField data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(sensor_msgs.msg.dds.PointField data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getName().length() + 1;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);



      return current_alignment - initial_alignment;
   }

   public static void write(sensor_msgs.msg.dds.PointField data, us.ihmc.idl.CDR cdr)
   {
      if(data.getName().length() <= 255)
      cdr.write_type_d(data.getName());else
          throw new RuntimeException("name field exceeds the maximum length: %d > %d".formatted(data.getName().length(), 255));

      cdr.write_type_4(data.getOffset());

      cdr.write_type_9(data.getDatatype());

      cdr.write_type_4(data.getCount());

   }

   public static void read(sensor_msgs.msg.dds.PointField data, us.ihmc.idl.CDR cdr)
   {
      cdr.read_type_d(data.getName());	
      data.setOffset(cdr.read_type_4());
      	
      data.setDatatype(cdr.read_type_9());
      	
      data.setCount(cdr.read_type_4());
      	

   }

   @Override
   public final void serialize(sensor_msgs.msg.dds.PointField data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_d("name", data.getName());
      ser.write_type_4("offset", data.getOffset());
      ser.write_type_9("datatype", data.getDatatype());
      ser.write_type_4("count", data.getCount());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, sensor_msgs.msg.dds.PointField data)
   {
      ser.read_type_d("name", data.getName());
      data.setOffset(ser.read_type_4("offset"));
      data.setDatatype(ser.read_type_9("datatype"));
      data.setCount(ser.read_type_4("count"));
   }

   public static void staticCopy(sensor_msgs.msg.dds.PointField src, sensor_msgs.msg.dds.PointField dest)
   {
      dest.set(src);
   }

   @Override
   public sensor_msgs.msg.dds.PointField createData()
   {
      return new sensor_msgs.msg.dds.PointField();
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
   
   public void serialize(sensor_msgs.msg.dds.PointField data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(sensor_msgs.msg.dds.PointField data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(sensor_msgs.msg.dds.PointField src, sensor_msgs.msg.dds.PointField dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public PointFieldPubSubType newInstance()
   {
      return new PointFieldPubSubType();
   }
}

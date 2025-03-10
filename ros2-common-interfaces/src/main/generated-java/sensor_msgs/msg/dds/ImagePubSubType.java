package sensor_msgs.msg.dds;

/**
* 
* Topic data type of the struct "Image" defined in "Image_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from Image_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit Image_.idl instead.
*
*/
public class ImagePubSubType implements us.ihmc.pubsub.TopicDataType<sensor_msgs.msg.dds.Image>
{
   public static final java.lang.String name = "sensor_msgs::msg::dds_::Image_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "ec242a5da5da6c2a7ccf69ee9ca046a8ec5f6c9c24acb92ca7c55a5bc92aa539";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(sensor_msgs.msg.dds.Image data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, sensor_msgs.msg.dds.Image data) throws java.io.IOException
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

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;
      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);current_alignment += (10000000 * 1) + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(sensor_msgs.msg.dds.Image data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(sensor_msgs.msg.dds.Image data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += std_msgs.msg.dds.HeaderPubSubType.getCdrSerializedSize(data.getHeader(), current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getEncoding().length() + 1;

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (data.getData().size() * 1) + us.ihmc.idl.CDR.alignment(current_alignment, 1);



      return current_alignment - initial_alignment;
   }

   public static void write(sensor_msgs.msg.dds.Image data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.write(data.getHeader(), cdr);
      cdr.write_type_4(data.getHeight());

      cdr.write_type_4(data.getWidth());

      if(data.getEncoding().length() <= 255)
      cdr.write_type_d(data.getEncoding());else
          throw new RuntimeException("encoding field exceeds the maximum length: %d > %d".formatted(data.getEncoding().length(), 255));

      cdr.write_type_9(data.getIsBigendian());

      cdr.write_type_4(data.getStep());

      if(data.getData().size() <= 10000000)
      cdr.write_type_e(data.getData());else
          throw new RuntimeException("data field exceeds the maximum length: %d > %d".formatted(data.getData().size(), 10000000));

   }

   public static void read(sensor_msgs.msg.dds.Image data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.read(data.getHeader(), cdr);	
      data.setHeight(cdr.read_type_4());
      	
      data.setWidth(cdr.read_type_4());
      	
      cdr.read_type_d(data.getEncoding());	
      data.setIsBigendian(cdr.read_type_9());
      	
      data.setStep(cdr.read_type_4());
      	
      cdr.read_type_e(data.getData());	

   }

   @Override
   public final void serialize(sensor_msgs.msg.dds.Image data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.write_type_4("height", data.getHeight());
      ser.write_type_4("width", data.getWidth());
      ser.write_type_d("encoding", data.getEncoding());
      ser.write_type_9("is_bigendian", data.getIsBigendian());
      ser.write_type_4("step", data.getStep());
      ser.write_type_e("data", data.getData());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, sensor_msgs.msg.dds.Image data)
   {
      ser.read_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      data.setHeight(ser.read_type_4("height"));
      data.setWidth(ser.read_type_4("width"));
      ser.read_type_d("encoding", data.getEncoding());
      data.setIsBigendian(ser.read_type_9("is_bigendian"));
      data.setStep(ser.read_type_4("step"));
      ser.read_type_e("data", data.getData());
   }

   public static void staticCopy(sensor_msgs.msg.dds.Image src, sensor_msgs.msg.dds.Image dest)
   {
      dest.set(src);
   }

   @Override
   public sensor_msgs.msg.dds.Image createData()
   {
      return new sensor_msgs.msg.dds.Image();
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
   
   public void serialize(sensor_msgs.msg.dds.Image data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(sensor_msgs.msg.dds.Image data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(sensor_msgs.msg.dds.Image src, sensor_msgs.msg.dds.Image dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public ImagePubSubType newInstance()
   {
      return new ImagePubSubType();
   }
}

package sensor_msgs.msg.dds;

/**
* 
* Topic data type of the struct "CompressedImage" defined in "CompressedImage_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from CompressedImage_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit CompressedImage_.idl instead.
*
*/
public class CompressedImagePubSubType implements us.ihmc.pubsub.TopicDataType<sensor_msgs.msg.dds.CompressedImage>
{
   public static final java.lang.String name = "sensor_msgs::msg::dds_::CompressedImage_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "5b55ffba1f3d4724c5c8f1a611ae4bc8427984fda06f428982c4810ac5c3249e";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(sensor_msgs.msg.dds.CompressedImage data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, sensor_msgs.msg.dds.CompressedImage data) throws java.io.IOException
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

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);current_alignment += (3000000 * 1) + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(sensor_msgs.msg.dds.CompressedImage data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(sensor_msgs.msg.dds.CompressedImage data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += std_msgs.msg.dds.HeaderPubSubType.getCdrSerializedSize(data.getHeader(), current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getFormat().length() + 1;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (data.getData().size() * 1) + us.ihmc.idl.CDR.alignment(current_alignment, 1);



      return current_alignment - initial_alignment;
   }

   public static void write(sensor_msgs.msg.dds.CompressedImage data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.write(data.getHeader(), cdr);
      if(data.getFormat().length() <= 255)
      cdr.write_type_d(data.getFormat());else
          throw new RuntimeException("format field exceeds the maximum length: %d > %d".formatted(data.getFormat().length(), 255));

      if(data.getData().size() <= 3000000)
      cdr.write_type_e(data.getData());else
          throw new RuntimeException("data field exceeds the maximum length: %d > %d".formatted(data.getData().size(), 3000000));

   }

   public static void read(sensor_msgs.msg.dds.CompressedImage data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.read(data.getHeader(), cdr);	
      cdr.read_type_d(data.getFormat());	
      cdr.read_type_e(data.getData());	

   }

   @Override
   public final void serialize(sensor_msgs.msg.dds.CompressedImage data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.write_type_d("format", data.getFormat());
      ser.write_type_e("data", data.getData());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, sensor_msgs.msg.dds.CompressedImage data)
   {
      ser.read_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.read_type_d("format", data.getFormat());
      ser.read_type_e("data", data.getData());
   }

   public static void staticCopy(sensor_msgs.msg.dds.CompressedImage src, sensor_msgs.msg.dds.CompressedImage dest)
   {
      dest.set(src);
   }

   @Override
   public sensor_msgs.msg.dds.CompressedImage createData()
   {
      return new sensor_msgs.msg.dds.CompressedImage();
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
   
   public void serialize(sensor_msgs.msg.dds.CompressedImage data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(sensor_msgs.msg.dds.CompressedImage data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(sensor_msgs.msg.dds.CompressedImage src, sensor_msgs.msg.dds.CompressedImage dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public CompressedImagePubSubType newInstance()
   {
      return new CompressedImagePubSubType();
   }
}

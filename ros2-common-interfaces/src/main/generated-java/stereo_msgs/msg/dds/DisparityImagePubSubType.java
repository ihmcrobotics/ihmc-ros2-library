package stereo_msgs.msg.dds;

/**
* 
* Topic data type of the struct "DisparityImage" defined in "DisparityImage_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from DisparityImage_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit DisparityImage_.idl instead.
*
*/
public class DisparityImagePubSubType implements us.ihmc.pubsub.TopicDataType<stereo_msgs.msg.dds.DisparityImage>
{
   public static final java.lang.String name = "stereo_msgs::msg::dds_::DisparityImage_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "8d72fb03446501c7f345cf0a0c1af8ffa1c603661b308e294a47370f7f96133a";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(stereo_msgs.msg.dds.DisparityImage data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, stereo_msgs.msg.dds.DisparityImage data) throws java.io.IOException
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

      current_alignment += sensor_msgs.msg.dds.ImagePubSubType.getMaxCdrSerializedSize(current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += sensor_msgs.msg.dds.RegionOfInterestPubSubType.getMaxCdrSerializedSize(current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(stereo_msgs.msg.dds.DisparityImage data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(stereo_msgs.msg.dds.DisparityImage data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += std_msgs.msg.dds.HeaderPubSubType.getCdrSerializedSize(data.getHeader(), current_alignment);

      current_alignment += sensor_msgs.msg.dds.ImagePubSubType.getCdrSerializedSize(data.getImage(), current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += sensor_msgs.msg.dds.RegionOfInterestPubSubType.getCdrSerializedSize(data.getValidWindow(), current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);



      return current_alignment - initial_alignment;
   }

   public static void write(stereo_msgs.msg.dds.DisparityImage data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.write(data.getHeader(), cdr);
      sensor_msgs.msg.dds.ImagePubSubType.write(data.getImage(), cdr);
      cdr.write_type_5(data.getF());

      cdr.write_type_5(data.getT());

      sensor_msgs.msg.dds.RegionOfInterestPubSubType.write(data.getValidWindow(), cdr);
      cdr.write_type_5(data.getMinDisparity());

      cdr.write_type_5(data.getMaxDisparity());

      cdr.write_type_5(data.getDeltaD());

   }

   public static void read(stereo_msgs.msg.dds.DisparityImage data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.read(data.getHeader(), cdr);	
      sensor_msgs.msg.dds.ImagePubSubType.read(data.getImage(), cdr);	
      data.setF(cdr.read_type_5());
      	
      data.setT(cdr.read_type_5());
      	
      sensor_msgs.msg.dds.RegionOfInterestPubSubType.read(data.getValidWindow(), cdr);	
      data.setMinDisparity(cdr.read_type_5());
      	
      data.setMaxDisparity(cdr.read_type_5());
      	
      data.setDeltaD(cdr.read_type_5());
      	

   }

   @Override
   public final void serialize(stereo_msgs.msg.dds.DisparityImage data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.write_type_a("image", new sensor_msgs.msg.dds.ImagePubSubType(), data.getImage());

      ser.write_type_5("f", data.getF());
      ser.write_type_5("t", data.getT());
      ser.write_type_a("valid_window", new sensor_msgs.msg.dds.RegionOfInterestPubSubType(), data.getValidWindow());

      ser.write_type_5("min_disparity", data.getMinDisparity());
      ser.write_type_5("max_disparity", data.getMaxDisparity());
      ser.write_type_5("delta_d", data.getDeltaD());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, stereo_msgs.msg.dds.DisparityImage data)
   {
      ser.read_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.read_type_a("image", new sensor_msgs.msg.dds.ImagePubSubType(), data.getImage());

      data.setF(ser.read_type_5("f"));
      data.setT(ser.read_type_5("t"));
      ser.read_type_a("valid_window", new sensor_msgs.msg.dds.RegionOfInterestPubSubType(), data.getValidWindow());

      data.setMinDisparity(ser.read_type_5("min_disparity"));
      data.setMaxDisparity(ser.read_type_5("max_disparity"));
      data.setDeltaD(ser.read_type_5("delta_d"));
   }

   public static void staticCopy(stereo_msgs.msg.dds.DisparityImage src, stereo_msgs.msg.dds.DisparityImage dest)
   {
      dest.set(src);
   }

   @Override
   public stereo_msgs.msg.dds.DisparityImage createData()
   {
      return new stereo_msgs.msg.dds.DisparityImage();
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
   
   public void serialize(stereo_msgs.msg.dds.DisparityImage data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(stereo_msgs.msg.dds.DisparityImage data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(stereo_msgs.msg.dds.DisparityImage src, stereo_msgs.msg.dds.DisparityImage dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public DisparityImagePubSubType newInstance()
   {
      return new DisparityImagePubSubType();
   }
}

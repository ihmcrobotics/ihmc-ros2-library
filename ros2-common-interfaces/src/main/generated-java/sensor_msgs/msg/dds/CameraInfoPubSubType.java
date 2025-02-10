package sensor_msgs.msg.dds;

/**
* 
* Topic data type of the struct "CameraInfo" defined in "CameraInfo_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from CameraInfo_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit CameraInfo_.idl instead.
*
*/
public class CameraInfoPubSubType implements us.ihmc.pubsub.TopicDataType<sensor_msgs.msg.dds.CameraInfo>
{
   public static final java.lang.String name = "sensor_msgs::msg::dds_::CameraInfo_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "5dfbf4cbb6dcab34f05ef8c8b08aff9b776de6ed52493ede25882f438392e138";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(sensor_msgs.msg.dds.CameraInfo data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, sensor_msgs.msg.dds.CameraInfo data) throws java.io.IOException
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
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);current_alignment += (100 * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += ((9) * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += ((9) * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += ((12) * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += sensor_msgs.msg.dds.RegionOfInterestPubSubType.getMaxCdrSerializedSize(current_alignment);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(sensor_msgs.msg.dds.CameraInfo data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(sensor_msgs.msg.dds.CameraInfo data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += std_msgs.msg.dds.HeaderPubSubType.getCdrSerializedSize(data.getHeader(), current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getDistortionModel().length() + 1;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (data.getD().size() * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += ((9) * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);
      current_alignment += ((9) * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);
      current_alignment += ((12) * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += sensor_msgs.msg.dds.RegionOfInterestPubSubType.getCdrSerializedSize(data.getRoi(), current_alignment);


      return current_alignment - initial_alignment;
   }

   public static void write(sensor_msgs.msg.dds.CameraInfo data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.write(data.getHeader(), cdr);
      cdr.write_type_4(data.getHeight());

      cdr.write_type_4(data.getWidth());

      if(data.getDistortionModel().length() <= 255)
      cdr.write_type_d(data.getDistortionModel());else
          throw new RuntimeException("distortion_model field exceeds the maximum length: %d > %d".formatted(data.getDistortionModel().length(), 255));

      if(data.getD().size() <= 100)
      cdr.write_type_e(data.getD());else
          throw new RuntimeException("d field exceeds the maximum length: %d > %d".formatted(data.getD().size(), 100));

      for(int i0 = 0; i0 < data.getK().length; ++i0)
      {
        	cdr.write_type_6(data.getK()[i0]);	
      }

      for(int i0 = 0; i0 < data.getR().length; ++i0)
      {
        	cdr.write_type_6(data.getR()[i0]);	
      }

      for(int i0 = 0; i0 < data.getP().length; ++i0)
      {
        	cdr.write_type_6(data.getP()[i0]);	
      }

      cdr.write_type_4(data.getBinningX());

      cdr.write_type_4(data.getBinningY());

      sensor_msgs.msg.dds.RegionOfInterestPubSubType.write(data.getRoi(), cdr);
   }

   public static void read(sensor_msgs.msg.dds.CameraInfo data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.read(data.getHeader(), cdr);	
      data.setHeight(cdr.read_type_4());
      	
      data.setWidth(cdr.read_type_4());
      	
      cdr.read_type_d(data.getDistortionModel());	
      cdr.read_type_e(data.getD());	
      for(int i0 = 0; i0 < data.getK().length; ++i0)
      {
        	data.getK()[i0] = cdr.read_type_6();
        	
      }
      	
      for(int i0 = 0; i0 < data.getR().length; ++i0)
      {
        	data.getR()[i0] = cdr.read_type_6();
        	
      }
      	
      for(int i0 = 0; i0 < data.getP().length; ++i0)
      {
        	data.getP()[i0] = cdr.read_type_6();
        	
      }
      	
      data.setBinningX(cdr.read_type_4());
      	
      data.setBinningY(cdr.read_type_4());
      	
      sensor_msgs.msg.dds.RegionOfInterestPubSubType.read(data.getRoi(), cdr);	

   }

   @Override
   public final void serialize(sensor_msgs.msg.dds.CameraInfo data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.write_type_4("height", data.getHeight());
      ser.write_type_4("width", data.getWidth());
      ser.write_type_d("distortion_model", data.getDistortionModel());
      ser.write_type_e("d", data.getD());
      ser.write_type_f("k", data.getK());
      ser.write_type_f("r", data.getR());
      ser.write_type_f("p", data.getP());
      ser.write_type_4("binning_x", data.getBinningX());
      ser.write_type_4("binning_y", data.getBinningY());
      ser.write_type_a("roi", new sensor_msgs.msg.dds.RegionOfInterestPubSubType(), data.getRoi());

   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, sensor_msgs.msg.dds.CameraInfo data)
   {
      ser.read_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      data.setHeight(ser.read_type_4("height"));
      data.setWidth(ser.read_type_4("width"));
      ser.read_type_d("distortion_model", data.getDistortionModel());
      ser.read_type_e("d", data.getD());
      ser.read_type_f("k", data.getK());
      ser.read_type_f("r", data.getR());
      ser.read_type_f("p", data.getP());
      data.setBinningX(ser.read_type_4("binning_x"));
      data.setBinningY(ser.read_type_4("binning_y"));
      ser.read_type_a("roi", new sensor_msgs.msg.dds.RegionOfInterestPubSubType(), data.getRoi());

   }

   public static void staticCopy(sensor_msgs.msg.dds.CameraInfo src, sensor_msgs.msg.dds.CameraInfo dest)
   {
      dest.set(src);
   }

   @Override
   public sensor_msgs.msg.dds.CameraInfo createData()
   {
      return new sensor_msgs.msg.dds.CameraInfo();
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
   
   public void serialize(sensor_msgs.msg.dds.CameraInfo data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(sensor_msgs.msg.dds.CameraInfo data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(sensor_msgs.msg.dds.CameraInfo src, sensor_msgs.msg.dds.CameraInfo dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public CameraInfoPubSubType newInstance()
   {
      return new CameraInfoPubSubType();
   }
}

package visualization_msgs.msg.dds;

/**
* 
* Topic data type of the struct "ImageMarker" defined in "ImageMarker_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from ImageMarker_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit ImageMarker_.idl instead.
*
*/
public class ImageMarkerPubSubType implements us.ihmc.pubsub.TopicDataType<visualization_msgs.msg.dds.ImageMarker>
{
   public static final java.lang.String name = "visualization_msgs::msg::dds_::ImageMarker_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "d7a1a99ce4ea377b232370be7e682bd9493bd319feab6601251b69bfc5b1a9ff";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(visualization_msgs.msg.dds.ImageMarker data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, visualization_msgs.msg.dds.ImageMarker data) throws java.io.IOException
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
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += geometry_msgs.msg.dds.PointPubSubType.getMaxCdrSerializedSize(current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += std_msgs.msg.dds.ColorRGBAPubSubType.getMaxCdrSerializedSize(current_alignment);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += std_msgs.msg.dds.ColorRGBAPubSubType.getMaxCdrSerializedSize(current_alignment);

      current_alignment += builtin_interfaces.msg.dds.DurationPubSubType.getMaxCdrSerializedSize(current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 100; ++i0)
      {
          current_alignment += geometry_msgs.msg.dds.PointPubSubType.getMaxCdrSerializedSize(current_alignment);}
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 100; ++i0)
      {
          current_alignment += std_msgs.msg.dds.ColorRGBAPubSubType.getMaxCdrSerializedSize(current_alignment);}

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(visualization_msgs.msg.dds.ImageMarker data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(visualization_msgs.msg.dds.ImageMarker data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += std_msgs.msg.dds.HeaderPubSubType.getCdrSerializedSize(data.getHeader(), current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getNs().length() + 1;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += geometry_msgs.msg.dds.PointPubSubType.getCdrSerializedSize(data.getPosition(), current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += std_msgs.msg.dds.ColorRGBAPubSubType.getCdrSerializedSize(data.getOutlineColor(), current_alignment);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += std_msgs.msg.dds.ColorRGBAPubSubType.getCdrSerializedSize(data.getFillColor(), current_alignment);

      current_alignment += builtin_interfaces.msg.dds.DurationPubSubType.getCdrSerializedSize(data.getLifetime(), current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getPoints().size(); ++i0)
      {
          current_alignment += geometry_msgs.msg.dds.PointPubSubType.getCdrSerializedSize(data.getPoints().get(i0), current_alignment);}

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getOutlineColors().size(); ++i0)
      {
          current_alignment += std_msgs.msg.dds.ColorRGBAPubSubType.getCdrSerializedSize(data.getOutlineColors().get(i0), current_alignment);}


      return current_alignment - initial_alignment;
   }

   public static void write(visualization_msgs.msg.dds.ImageMarker data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.write(data.getHeader(), cdr);
      if(data.getNs().length() <= 255)
      cdr.write_type_d(data.getNs());else
          throw new RuntimeException("ns field exceeds the maximum length: %d > %d".formatted(data.getNs().length(), 255));

      cdr.write_type_2(data.getId());

      cdr.write_type_2(data.getType());

      cdr.write_type_2(data.getAction());

      geometry_msgs.msg.dds.PointPubSubType.write(data.getPosition(), cdr);
      cdr.write_type_5(data.getScale());

      std_msgs.msg.dds.ColorRGBAPubSubType.write(data.getOutlineColor(), cdr);
      cdr.write_type_9(data.getFilled());

      std_msgs.msg.dds.ColorRGBAPubSubType.write(data.getFillColor(), cdr);
      builtin_interfaces.msg.dds.DurationPubSubType.write(data.getLifetime(), cdr);
      if(data.getPoints().size() <= 100)
      cdr.write_type_e(data.getPoints());else
          throw new RuntimeException("points field exceeds the maximum length: %d > %d".formatted(data.getPoints().size(), 100));

      if(data.getOutlineColors().size() <= 100)
      cdr.write_type_e(data.getOutlineColors());else
          throw new RuntimeException("outline_colors field exceeds the maximum length: %d > %d".formatted(data.getOutlineColors().size(), 100));

   }

   public static void read(visualization_msgs.msg.dds.ImageMarker data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.read(data.getHeader(), cdr);	
      cdr.read_type_d(data.getNs());	
      data.setId(cdr.read_type_2());
      	
      data.setType(cdr.read_type_2());
      	
      data.setAction(cdr.read_type_2());
      	
      geometry_msgs.msg.dds.PointPubSubType.read(data.getPosition(), cdr);	
      data.setScale(cdr.read_type_5());
      	
      std_msgs.msg.dds.ColorRGBAPubSubType.read(data.getOutlineColor(), cdr);	
      data.setFilled(cdr.read_type_9());
      	
      std_msgs.msg.dds.ColorRGBAPubSubType.read(data.getFillColor(), cdr);	
      builtin_interfaces.msg.dds.DurationPubSubType.read(data.getLifetime(), cdr);	
      cdr.read_type_e(data.getPoints());	
      cdr.read_type_e(data.getOutlineColors());	

   }

   @Override
   public final void serialize(visualization_msgs.msg.dds.ImageMarker data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.write_type_d("ns", data.getNs());
      ser.write_type_2("id", data.getId());
      ser.write_type_2("type", data.getType());
      ser.write_type_2("action", data.getAction());
      ser.write_type_a("position", new geometry_msgs.msg.dds.PointPubSubType(), data.getPosition());

      ser.write_type_5("scale", data.getScale());
      ser.write_type_a("outline_color", new std_msgs.msg.dds.ColorRGBAPubSubType(), data.getOutlineColor());

      ser.write_type_9("filled", data.getFilled());
      ser.write_type_a("fill_color", new std_msgs.msg.dds.ColorRGBAPubSubType(), data.getFillColor());

      ser.write_type_a("lifetime", new builtin_interfaces.msg.dds.DurationPubSubType(), data.getLifetime());

      ser.write_type_e("points", data.getPoints());
      ser.write_type_e("outline_colors", data.getOutlineColors());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, visualization_msgs.msg.dds.ImageMarker data)
   {
      ser.read_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.read_type_d("ns", data.getNs());
      data.setId(ser.read_type_2("id"));
      data.setType(ser.read_type_2("type"));
      data.setAction(ser.read_type_2("action"));
      ser.read_type_a("position", new geometry_msgs.msg.dds.PointPubSubType(), data.getPosition());

      data.setScale(ser.read_type_5("scale"));
      ser.read_type_a("outline_color", new std_msgs.msg.dds.ColorRGBAPubSubType(), data.getOutlineColor());

      data.setFilled(ser.read_type_9("filled"));
      ser.read_type_a("fill_color", new std_msgs.msg.dds.ColorRGBAPubSubType(), data.getFillColor());

      ser.read_type_a("lifetime", new builtin_interfaces.msg.dds.DurationPubSubType(), data.getLifetime());

      ser.read_type_e("points", data.getPoints());
      ser.read_type_e("outline_colors", data.getOutlineColors());
   }

   public static void staticCopy(visualization_msgs.msg.dds.ImageMarker src, visualization_msgs.msg.dds.ImageMarker dest)
   {
      dest.set(src);
   }

   @Override
   public visualization_msgs.msg.dds.ImageMarker createData()
   {
      return new visualization_msgs.msg.dds.ImageMarker();
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
   
   public void serialize(visualization_msgs.msg.dds.ImageMarker data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(visualization_msgs.msg.dds.ImageMarker data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(visualization_msgs.msg.dds.ImageMarker src, visualization_msgs.msg.dds.ImageMarker dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public ImageMarkerPubSubType newInstance()
   {
      return new ImageMarkerPubSubType();
   }
}

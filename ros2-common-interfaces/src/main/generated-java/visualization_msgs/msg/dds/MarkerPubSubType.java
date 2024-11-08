package visualization_msgs.msg.dds;

/**
* 
* Topic data type of the struct "Marker" defined in "Marker_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from Marker_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit Marker_.idl instead.
*
*/
public class MarkerPubSubType implements us.ihmc.pubsub.TopicDataType<visualization_msgs.msg.dds.Marker>
{
   public static final java.lang.String name = "visualization_msgs::msg::dds_::Marker_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "376a27a22789587188d03dc275c6964eac008f399bdc7dd3e70a8820ee849b23";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(visualization_msgs.msg.dds.Marker data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, visualization_msgs.msg.dds.Marker data) throws java.io.IOException
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

      current_alignment += geometry_msgs.msg.dds.PosePubSubType.getMaxCdrSerializedSize(current_alignment);

      current_alignment += geometry_msgs.msg.dds.Vector3PubSubType.getMaxCdrSerializedSize(current_alignment);

      current_alignment += std_msgs.msg.dds.ColorRGBAPubSubType.getMaxCdrSerializedSize(current_alignment);

      current_alignment += builtin_interfaces.msg.dds.DurationPubSubType.getMaxCdrSerializedSize(current_alignment);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 100; ++i0)
      {
          current_alignment += geometry_msgs.msg.dds.PointPubSubType.getMaxCdrSerializedSize(current_alignment);}
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 100; ++i0)
      {
          current_alignment += std_msgs.msg.dds.ColorRGBAPubSubType.getMaxCdrSerializedSize(current_alignment);}
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;
      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(visualization_msgs.msg.dds.Marker data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(visualization_msgs.msg.dds.Marker data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += std_msgs.msg.dds.HeaderPubSubType.getCdrSerializedSize(data.getHeader(), current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getNs().length() + 1;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += geometry_msgs.msg.dds.PosePubSubType.getCdrSerializedSize(data.getPose(), current_alignment);

      current_alignment += geometry_msgs.msg.dds.Vector3PubSubType.getCdrSerializedSize(data.getScale(), current_alignment);

      current_alignment += std_msgs.msg.dds.ColorRGBAPubSubType.getCdrSerializedSize(data.getColor(), current_alignment);

      current_alignment += builtin_interfaces.msg.dds.DurationPubSubType.getCdrSerializedSize(data.getLifetime(), current_alignment);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getPoints().size(); ++i0)
      {
          current_alignment += geometry_msgs.msg.dds.PointPubSubType.getCdrSerializedSize(data.getPoints().get(i0), current_alignment);}

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getColors().size(); ++i0)
      {
          current_alignment += std_msgs.msg.dds.ColorRGBAPubSubType.getCdrSerializedSize(data.getColors().get(i0), current_alignment);}

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getText().length() + 1;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getMeshResource().length() + 1;

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);



      return current_alignment - initial_alignment;
   }

   public static void write(visualization_msgs.msg.dds.Marker data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.write(data.getHeader(), cdr);
      if(data.getNs().length() <= 255)
      cdr.write_type_d(data.getNs());else
          throw new RuntimeException("ns field exceeds the maximum length");

      cdr.write_type_2(data.getId());

      cdr.write_type_2(data.getType());

      cdr.write_type_2(data.getAction());

      geometry_msgs.msg.dds.PosePubSubType.write(data.getPose(), cdr);
      geometry_msgs.msg.dds.Vector3PubSubType.write(data.getScale(), cdr);
      std_msgs.msg.dds.ColorRGBAPubSubType.write(data.getColor(), cdr);
      builtin_interfaces.msg.dds.DurationPubSubType.write(data.getLifetime(), cdr);
      cdr.write_type_7(data.getFrameLocked());

      if(data.getPoints().size() <= 100)
      cdr.write_type_e(data.getPoints());else
          throw new RuntimeException("points field exceeds the maximum length");

      if(data.getColors().size() <= 100)
      cdr.write_type_e(data.getColors());else
          throw new RuntimeException("colors field exceeds the maximum length");

      if(data.getText().length() <= 255)
      cdr.write_type_d(data.getText());else
          throw new RuntimeException("text field exceeds the maximum length");

      if(data.getMeshResource().length() <= 255)
      cdr.write_type_d(data.getMeshResource());else
          throw new RuntimeException("mesh_resource field exceeds the maximum length");

      cdr.write_type_7(data.getMeshUseEmbeddedMaterials());

   }

   public static void read(visualization_msgs.msg.dds.Marker data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.read(data.getHeader(), cdr);	
      cdr.read_type_d(data.getNs());	
      data.setId(cdr.read_type_2());
      	
      data.setType(cdr.read_type_2());
      	
      data.setAction(cdr.read_type_2());
      	
      geometry_msgs.msg.dds.PosePubSubType.read(data.getPose(), cdr);	
      geometry_msgs.msg.dds.Vector3PubSubType.read(data.getScale(), cdr);	
      std_msgs.msg.dds.ColorRGBAPubSubType.read(data.getColor(), cdr);	
      builtin_interfaces.msg.dds.DurationPubSubType.read(data.getLifetime(), cdr);	
      data.setFrameLocked(cdr.read_type_7());
      	
      cdr.read_type_e(data.getPoints());	
      cdr.read_type_e(data.getColors());	
      cdr.read_type_d(data.getText());	
      cdr.read_type_d(data.getMeshResource());	
      data.setMeshUseEmbeddedMaterials(cdr.read_type_7());
      	

   }

   @Override
   public final void serialize(visualization_msgs.msg.dds.Marker data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.write_type_d("ns", data.getNs());
      ser.write_type_2("id", data.getId());
      ser.write_type_2("type", data.getType());
      ser.write_type_2("action", data.getAction());
      ser.write_type_a("pose", new geometry_msgs.msg.dds.PosePubSubType(), data.getPose());

      ser.write_type_a("scale", new geometry_msgs.msg.dds.Vector3PubSubType(), data.getScale());

      ser.write_type_a("color", new std_msgs.msg.dds.ColorRGBAPubSubType(), data.getColor());

      ser.write_type_a("lifetime", new builtin_interfaces.msg.dds.DurationPubSubType(), data.getLifetime());

      ser.write_type_7("frame_locked", data.getFrameLocked());
      ser.write_type_e("points", data.getPoints());
      ser.write_type_e("colors", data.getColors());
      ser.write_type_d("text", data.getText());
      ser.write_type_d("mesh_resource", data.getMeshResource());
      ser.write_type_7("mesh_use_embedded_materials", data.getMeshUseEmbeddedMaterials());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, visualization_msgs.msg.dds.Marker data)
   {
      ser.read_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.read_type_d("ns", data.getNs());
      data.setId(ser.read_type_2("id"));
      data.setType(ser.read_type_2("type"));
      data.setAction(ser.read_type_2("action"));
      ser.read_type_a("pose", new geometry_msgs.msg.dds.PosePubSubType(), data.getPose());

      ser.read_type_a("scale", new geometry_msgs.msg.dds.Vector3PubSubType(), data.getScale());

      ser.read_type_a("color", new std_msgs.msg.dds.ColorRGBAPubSubType(), data.getColor());

      ser.read_type_a("lifetime", new builtin_interfaces.msg.dds.DurationPubSubType(), data.getLifetime());

      data.setFrameLocked(ser.read_type_7("frame_locked"));
      ser.read_type_e("points", data.getPoints());
      ser.read_type_e("colors", data.getColors());
      ser.read_type_d("text", data.getText());
      ser.read_type_d("mesh_resource", data.getMeshResource());
      data.setMeshUseEmbeddedMaterials(ser.read_type_7("mesh_use_embedded_materials"));
   }

   public static void staticCopy(visualization_msgs.msg.dds.Marker src, visualization_msgs.msg.dds.Marker dest)
   {
      dest.set(src);
   }

   @Override
   public visualization_msgs.msg.dds.Marker createData()
   {
      return new visualization_msgs.msg.dds.Marker();
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
   
   public void serialize(visualization_msgs.msg.dds.Marker data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(visualization_msgs.msg.dds.Marker data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(visualization_msgs.msg.dds.Marker src, visualization_msgs.msg.dds.Marker dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public MarkerPubSubType newInstance()
   {
      return new MarkerPubSubType();
   }
}

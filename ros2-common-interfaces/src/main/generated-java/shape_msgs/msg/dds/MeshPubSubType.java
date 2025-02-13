package shape_msgs.msg.dds;

/**
* 
* Topic data type of the struct "Mesh" defined in "Mesh_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from Mesh_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit Mesh_.idl instead.
*
*/
public class MeshPubSubType implements us.ihmc.pubsub.TopicDataType<shape_msgs.msg.dds.Mesh>
{
   public static final java.lang.String name = "shape_msgs::msg::dds_::Mesh_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "cda279a1ee1661dd96edd33f81804fd42c711df374a92b37332eb1fbf44f24b9";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(shape_msgs.msg.dds.Mesh data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, shape_msgs.msg.dds.Mesh data) throws java.io.IOException
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

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 100; ++i0)
      {
          current_alignment += shape_msgs.msg.dds.MeshTrianglePubSubType.getMaxCdrSerializedSize(current_alignment);}
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 100; ++i0)
      {
          current_alignment += geometry_msgs.msg.dds.PointPubSubType.getMaxCdrSerializedSize(current_alignment);}

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(shape_msgs.msg.dds.Mesh data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(shape_msgs.msg.dds.Mesh data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getTriangles().size(); ++i0)
      {
          current_alignment += shape_msgs.msg.dds.MeshTrianglePubSubType.getCdrSerializedSize(data.getTriangles().get(i0), current_alignment);}

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getVertices().size(); ++i0)
      {
          current_alignment += geometry_msgs.msg.dds.PointPubSubType.getCdrSerializedSize(data.getVertices().get(i0), current_alignment);}


      return current_alignment - initial_alignment;
   }

   public static void write(shape_msgs.msg.dds.Mesh data, us.ihmc.idl.CDR cdr)
   {
      if(data.getTriangles().size() <= 100)
      cdr.write_type_e(data.getTriangles());else
          throw new RuntimeException("triangles field exceeds the maximum length: %d > %d".formatted(data.getTriangles().size(), 100));

      if(data.getVertices().size() <= 100)
      cdr.write_type_e(data.getVertices());else
          throw new RuntimeException("vertices field exceeds the maximum length: %d > %d".formatted(data.getVertices().size(), 100));

   }

   public static void read(shape_msgs.msg.dds.Mesh data, us.ihmc.idl.CDR cdr)
   {
      cdr.read_type_e(data.getTriangles());	
      cdr.read_type_e(data.getVertices());	

   }

   @Override
   public final void serialize(shape_msgs.msg.dds.Mesh data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_e("triangles", data.getTriangles());
      ser.write_type_e("vertices", data.getVertices());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, shape_msgs.msg.dds.Mesh data)
   {
      ser.read_type_e("triangles", data.getTriangles());
      ser.read_type_e("vertices", data.getVertices());
   }

   public static void staticCopy(shape_msgs.msg.dds.Mesh src, shape_msgs.msg.dds.Mesh dest)
   {
      dest.set(src);
   }

   @Override
   public shape_msgs.msg.dds.Mesh createData()
   {
      return new shape_msgs.msg.dds.Mesh();
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
   
   public void serialize(shape_msgs.msg.dds.Mesh data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(shape_msgs.msg.dds.Mesh data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(shape_msgs.msg.dds.Mesh src, shape_msgs.msg.dds.Mesh dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public MeshPubSubType newInstance()
   {
      return new MeshPubSubType();
   }
}

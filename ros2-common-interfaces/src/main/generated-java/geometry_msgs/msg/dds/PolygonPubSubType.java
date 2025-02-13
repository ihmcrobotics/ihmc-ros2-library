package geometry_msgs.msg.dds;

/**
* 
* Topic data type of the struct "Polygon" defined in "Polygon_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from Polygon_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit Polygon_.idl instead.
*
*/
public class PolygonPubSubType implements us.ihmc.pubsub.TopicDataType<geometry_msgs.msg.dds.Polygon>
{
   public static final java.lang.String name = "geometry_msgs::msg::dds_::Polygon_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "88819cd2a43691dde36cd44789fc62db983db1ff19287ceebd87f540ea19de8d";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(geometry_msgs.msg.dds.Polygon data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, geometry_msgs.msg.dds.Polygon data) throws java.io.IOException
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
          current_alignment += geometry_msgs.msg.dds.Point32PubSubType.getMaxCdrSerializedSize(current_alignment);}
      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(geometry_msgs.msg.dds.Polygon data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(geometry_msgs.msg.dds.Polygon data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getPoints().size(); ++i0)
      {
          current_alignment += geometry_msgs.msg.dds.Point32PubSubType.getCdrSerializedSize(data.getPoints().get(i0), current_alignment);}

      return current_alignment - initial_alignment;
   }

   public static void write(geometry_msgs.msg.dds.Polygon data, us.ihmc.idl.CDR cdr)
   {
      if(data.getPoints().size() <= 100)
      cdr.write_type_e(data.getPoints());else
          throw new RuntimeException("points field exceeds the maximum length: %d > %d".formatted(data.getPoints().size(), 100));

   }

   public static void read(geometry_msgs.msg.dds.Polygon data, us.ihmc.idl.CDR cdr)
   {
      cdr.read_type_e(data.getPoints());	

   }

   @Override
   public final void serialize(geometry_msgs.msg.dds.Polygon data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_e("points", data.getPoints());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, geometry_msgs.msg.dds.Polygon data)
   {
      ser.read_type_e("points", data.getPoints());
   }

   public static void staticCopy(geometry_msgs.msg.dds.Polygon src, geometry_msgs.msg.dds.Polygon dest)
   {
      dest.set(src);
   }

   @Override
   public geometry_msgs.msg.dds.Polygon createData()
   {
      return new geometry_msgs.msg.dds.Polygon();
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
   
   public void serialize(geometry_msgs.msg.dds.Polygon data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(geometry_msgs.msg.dds.Polygon data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(geometry_msgs.msg.dds.Polygon src, geometry_msgs.msg.dds.Polygon dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public PolygonPubSubType newInstance()
   {
      return new PolygonPubSubType();
   }
}

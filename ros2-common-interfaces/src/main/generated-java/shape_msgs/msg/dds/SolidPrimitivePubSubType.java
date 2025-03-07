package shape_msgs.msg.dds;

/**
* 
* Topic data type of the struct "SolidPrimitive" defined in "SolidPrimitive_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from SolidPrimitive_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit SolidPrimitive_.idl instead.
*
*/
public class SolidPrimitivePubSubType implements us.ihmc.pubsub.TopicDataType<shape_msgs.msg.dds.SolidPrimitive>
{
   public static final java.lang.String name = "shape_msgs::msg::dds_::SolidPrimitive_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "ab6bee1b39609974b4e11c93ef8f6f0607cea4b5ef09f05abd826308400752aa";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(shape_msgs.msg.dds.SolidPrimitive data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, shape_msgs.msg.dds.SolidPrimitive data) throws java.io.IOException
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

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);current_alignment += (3 * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += geometry_msgs.msg.dds.PolygonPubSubType.getMaxCdrSerializedSize(current_alignment);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(shape_msgs.msg.dds.SolidPrimitive data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(shape_msgs.msg.dds.SolidPrimitive data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (data.getDimensions().size() * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += geometry_msgs.msg.dds.PolygonPubSubType.getCdrSerializedSize(data.getPolygon(), current_alignment);


      return current_alignment - initial_alignment;
   }

   public static void write(shape_msgs.msg.dds.SolidPrimitive data, us.ihmc.idl.CDR cdr)
   {
      cdr.write_type_9(data.getType());

      if(data.getDimensions().size() <= 3)
      cdr.write_type_e(data.getDimensions());else
          throw new RuntimeException("dimensions field exceeds the maximum length: %d > %d".formatted(data.getDimensions().size(), 3));

      geometry_msgs.msg.dds.PolygonPubSubType.write(data.getPolygon(), cdr);
   }

   public static void read(shape_msgs.msg.dds.SolidPrimitive data, us.ihmc.idl.CDR cdr)
   {
      data.setType(cdr.read_type_9());
      	
      cdr.read_type_e(data.getDimensions());	
      geometry_msgs.msg.dds.PolygonPubSubType.read(data.getPolygon(), cdr);	

   }

   @Override
   public final void serialize(shape_msgs.msg.dds.SolidPrimitive data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_9("type", data.getType());
      ser.write_type_e("dimensions", data.getDimensions());
      ser.write_type_a("polygon", new geometry_msgs.msg.dds.PolygonPubSubType(), data.getPolygon());

   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, shape_msgs.msg.dds.SolidPrimitive data)
   {
      data.setType(ser.read_type_9("type"));
      ser.read_type_e("dimensions", data.getDimensions());
      ser.read_type_a("polygon", new geometry_msgs.msg.dds.PolygonPubSubType(), data.getPolygon());

   }

   public static void staticCopy(shape_msgs.msg.dds.SolidPrimitive src, shape_msgs.msg.dds.SolidPrimitive dest)
   {
      dest.set(src);
   }

   @Override
   public shape_msgs.msg.dds.SolidPrimitive createData()
   {
      return new shape_msgs.msg.dds.SolidPrimitive();
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
   
   public void serialize(shape_msgs.msg.dds.SolidPrimitive data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(shape_msgs.msg.dds.SolidPrimitive data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(shape_msgs.msg.dds.SolidPrimitive src, shape_msgs.msg.dds.SolidPrimitive dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public SolidPrimitivePubSubType newInstance()
   {
      return new SolidPrimitivePubSubType();
   }
}

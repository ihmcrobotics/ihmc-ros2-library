package geometry_msgs.msg.dds;

/**
* 
* Topic data type of the struct "PolygonInstance" defined in "PolygonInstance_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from PolygonInstance_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit PolygonInstance_.idl instead.
*
*/
public class PolygonInstancePubSubType implements us.ihmc.pubsub.TopicDataType<geometry_msgs.msg.dds.PolygonInstance>
{
   public static final java.lang.String name = "geometry_msgs::msg::dds_::PolygonInstance_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "2901c0a4574d08b92cd701a9617b2178d8010c1b0556e83129ead1995ba5bb39";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(geometry_msgs.msg.dds.PolygonInstance data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, geometry_msgs.msg.dds.PolygonInstance data) throws java.io.IOException
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

      current_alignment += geometry_msgs.msg.dds.PolygonPubSubType.getMaxCdrSerializedSize(current_alignment);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(geometry_msgs.msg.dds.PolygonInstance data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(geometry_msgs.msg.dds.PolygonInstance data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += geometry_msgs.msg.dds.PolygonPubSubType.getCdrSerializedSize(data.getPolygon(), current_alignment);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);



      return current_alignment - initial_alignment;
   }

   public static void write(geometry_msgs.msg.dds.PolygonInstance data, us.ihmc.idl.CDR cdr)
   {
      geometry_msgs.msg.dds.PolygonPubSubType.write(data.getPolygon(), cdr);
      cdr.write_type_11(data.getId());

   }

   public static void read(geometry_msgs.msg.dds.PolygonInstance data, us.ihmc.idl.CDR cdr)
   {
      geometry_msgs.msg.dds.PolygonPubSubType.read(data.getPolygon(), cdr);	
      data.setId(cdr.read_type_11());
      	

   }

   @Override
   public final void serialize(geometry_msgs.msg.dds.PolygonInstance data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("polygon", new geometry_msgs.msg.dds.PolygonPubSubType(), data.getPolygon());

      ser.write_type_11("id", data.getId());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, geometry_msgs.msg.dds.PolygonInstance data)
   {
      ser.read_type_a("polygon", new geometry_msgs.msg.dds.PolygonPubSubType(), data.getPolygon());

      data.setId(ser.read_type_11("id"));
   }

   public static void staticCopy(geometry_msgs.msg.dds.PolygonInstance src, geometry_msgs.msg.dds.PolygonInstance dest)
   {
      dest.set(src);
   }

   @Override
   public geometry_msgs.msg.dds.PolygonInstance createData()
   {
      return new geometry_msgs.msg.dds.PolygonInstance();
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
   
   public void serialize(geometry_msgs.msg.dds.PolygonInstance data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(geometry_msgs.msg.dds.PolygonInstance data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(geometry_msgs.msg.dds.PolygonInstance src, geometry_msgs.msg.dds.PolygonInstance dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public PolygonInstancePubSubType newInstance()
   {
      return new PolygonInstancePubSubType();
   }
}

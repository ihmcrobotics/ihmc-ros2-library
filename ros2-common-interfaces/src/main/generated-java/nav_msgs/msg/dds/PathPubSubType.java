package nav_msgs.msg.dds;

/**
* 
* Topic data type of the struct "Path" defined in "Path_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from Path_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit Path_.idl instead.
*
*/
public class PathPubSubType implements us.ihmc.pubsub.TopicDataType<nav_msgs.msg.dds.Path>
{
   public static final java.lang.String name = "nav_msgs::msg::dds_::Path_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "cd5c002ba5bee40787a2cd17d3288c1e34189d13b1284307d8936410f7c4034e";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(nav_msgs.msg.dds.Path data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, nav_msgs.msg.dds.Path data) throws java.io.IOException
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

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 100; ++i0)
      {
          current_alignment += geometry_msgs.msg.dds.PoseStampedPubSubType.getMaxCdrSerializedSize(current_alignment);}

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(nav_msgs.msg.dds.Path data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(nav_msgs.msg.dds.Path data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += std_msgs.msg.dds.HeaderPubSubType.getCdrSerializedSize(data.getHeader(), current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getPoses().size(); ++i0)
      {
          current_alignment += geometry_msgs.msg.dds.PoseStampedPubSubType.getCdrSerializedSize(data.getPoses().get(i0), current_alignment);}


      return current_alignment - initial_alignment;
   }

   public static void write(nav_msgs.msg.dds.Path data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.write(data.getHeader(), cdr);
      if(data.getPoses().size() <= 100)
      cdr.write_type_e(data.getPoses());else
          throw new RuntimeException("poses field exceeds the maximum length: %d > %d".formatted(data.getPoses().size(), 100));

   }

   public static void read(nav_msgs.msg.dds.Path data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.read(data.getHeader(), cdr);	
      cdr.read_type_e(data.getPoses());	

   }

   @Override
   public final void serialize(nav_msgs.msg.dds.Path data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.write_type_e("poses", data.getPoses());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, nav_msgs.msg.dds.Path data)
   {
      ser.read_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.read_type_e("poses", data.getPoses());
   }

   public static void staticCopy(nav_msgs.msg.dds.Path src, nav_msgs.msg.dds.Path dest)
   {
      dest.set(src);
   }

   @Override
   public nav_msgs.msg.dds.Path createData()
   {
      return new nav_msgs.msg.dds.Path();
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
   
   public void serialize(nav_msgs.msg.dds.Path data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(nav_msgs.msg.dds.Path data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(nav_msgs.msg.dds.Path src, nav_msgs.msg.dds.Path dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public PathPubSubType newInstance()
   {
      return new PathPubSubType();
   }
}

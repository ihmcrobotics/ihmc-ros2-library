package geometry_msgs.msg.dds;

/**
* 
* Topic data type of the struct "PoseArray" defined in "PoseArray_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from PoseArray_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit PoseArray_.idl instead.
*
*/
public class PoseArrayPubSubType implements us.ihmc.pubsub.TopicDataType<geometry_msgs.msg.dds.PoseArray>
{
   public static final java.lang.String name = "geometry_msgs::msg::dds_::PoseArray_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "c259f047fa88cac5f18b65e953b531574c5d2ec23a4d51818575809fe0101662";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(geometry_msgs.msg.dds.PoseArray data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, geometry_msgs.msg.dds.PoseArray data) throws java.io.IOException
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
          current_alignment += geometry_msgs.msg.dds.PosePubSubType.getMaxCdrSerializedSize(current_alignment);}

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(geometry_msgs.msg.dds.PoseArray data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(geometry_msgs.msg.dds.PoseArray data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += std_msgs.msg.dds.HeaderPubSubType.getCdrSerializedSize(data.getHeader(), current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getPoses().size(); ++i0)
      {
          current_alignment += geometry_msgs.msg.dds.PosePubSubType.getCdrSerializedSize(data.getPoses().get(i0), current_alignment);}


      return current_alignment - initial_alignment;
   }

   public static void write(geometry_msgs.msg.dds.PoseArray data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.write(data.getHeader(), cdr);
      if(data.getPoses().size() <= 100)
      cdr.write_type_e(data.getPoses());else
          throw new RuntimeException("poses field exceeds the maximum length: %d > %d".formatted(data.getPoses().size(), 100));

   }

   public static void read(geometry_msgs.msg.dds.PoseArray data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.read(data.getHeader(), cdr);	
      cdr.read_type_e(data.getPoses());	

   }

   @Override
   public final void serialize(geometry_msgs.msg.dds.PoseArray data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.write_type_e("poses", data.getPoses());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, geometry_msgs.msg.dds.PoseArray data)
   {
      ser.read_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.read_type_e("poses", data.getPoses());
   }

   public static void staticCopy(geometry_msgs.msg.dds.PoseArray src, geometry_msgs.msg.dds.PoseArray dest)
   {
      dest.set(src);
   }

   @Override
   public geometry_msgs.msg.dds.PoseArray createData()
   {
      return new geometry_msgs.msg.dds.PoseArray();
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
   
   public void serialize(geometry_msgs.msg.dds.PoseArray data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(geometry_msgs.msg.dds.PoseArray data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(geometry_msgs.msg.dds.PoseArray src, geometry_msgs.msg.dds.PoseArray dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public PoseArrayPubSubType newInstance()
   {
      return new PoseArrayPubSubType();
   }
}

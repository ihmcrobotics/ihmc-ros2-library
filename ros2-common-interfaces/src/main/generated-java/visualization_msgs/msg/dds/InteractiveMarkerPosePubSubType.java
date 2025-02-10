package visualization_msgs.msg.dds;

/**
* 
* Topic data type of the struct "InteractiveMarkerPose" defined in "InteractiveMarkerPose_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from InteractiveMarkerPose_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit InteractiveMarkerPose_.idl instead.
*
*/
public class InteractiveMarkerPosePubSubType implements us.ihmc.pubsub.TopicDataType<visualization_msgs.msg.dds.InteractiveMarkerPose>
{
   public static final java.lang.String name = "visualization_msgs::msg::dds_::InteractiveMarkerPose_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "17143d47372933f6e08d71826c518911263b120ca8ca33175257aa07f4d3a37f";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(visualization_msgs.msg.dds.InteractiveMarkerPose data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, visualization_msgs.msg.dds.InteractiveMarkerPose data) throws java.io.IOException
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

      current_alignment += geometry_msgs.msg.dds.PosePubSubType.getMaxCdrSerializedSize(current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(visualization_msgs.msg.dds.InteractiveMarkerPose data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(visualization_msgs.msg.dds.InteractiveMarkerPose data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += std_msgs.msg.dds.HeaderPubSubType.getCdrSerializedSize(data.getHeader(), current_alignment);

      current_alignment += geometry_msgs.msg.dds.PosePubSubType.getCdrSerializedSize(data.getPose(), current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getName().length() + 1;


      return current_alignment - initial_alignment;
   }

   public static void write(visualization_msgs.msg.dds.InteractiveMarkerPose data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.write(data.getHeader(), cdr);
      geometry_msgs.msg.dds.PosePubSubType.write(data.getPose(), cdr);
      if(data.getName().length() <= 255)
      cdr.write_type_d(data.getName());else
          throw new RuntimeException("name field exceeds the maximum length: %d > %d".formatted(data.getName().length(), 255));

   }

   public static void read(visualization_msgs.msg.dds.InteractiveMarkerPose data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.read(data.getHeader(), cdr);	
      geometry_msgs.msg.dds.PosePubSubType.read(data.getPose(), cdr);	
      cdr.read_type_d(data.getName());	

   }

   @Override
   public final void serialize(visualization_msgs.msg.dds.InteractiveMarkerPose data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.write_type_a("pose", new geometry_msgs.msg.dds.PosePubSubType(), data.getPose());

      ser.write_type_d("name", data.getName());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, visualization_msgs.msg.dds.InteractiveMarkerPose data)
   {
      ser.read_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.read_type_a("pose", new geometry_msgs.msg.dds.PosePubSubType(), data.getPose());

      ser.read_type_d("name", data.getName());
   }

   public static void staticCopy(visualization_msgs.msg.dds.InteractiveMarkerPose src, visualization_msgs.msg.dds.InteractiveMarkerPose dest)
   {
      dest.set(src);
   }

   @Override
   public visualization_msgs.msg.dds.InteractiveMarkerPose createData()
   {
      return new visualization_msgs.msg.dds.InteractiveMarkerPose();
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
   
   public void serialize(visualization_msgs.msg.dds.InteractiveMarkerPose data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(visualization_msgs.msg.dds.InteractiveMarkerPose data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(visualization_msgs.msg.dds.InteractiveMarkerPose src, visualization_msgs.msg.dds.InteractiveMarkerPose dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public InteractiveMarkerPosePubSubType newInstance()
   {
      return new InteractiveMarkerPosePubSubType();
   }
}

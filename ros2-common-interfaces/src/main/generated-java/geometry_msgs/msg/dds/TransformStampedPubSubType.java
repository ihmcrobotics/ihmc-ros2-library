package geometry_msgs.msg.dds;

/**
* 
* Topic data type of the struct "TransformStamped" defined in "TransformStamped_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from TransformStamped_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit TransformStamped_.idl instead.
*
*/
public class TransformStampedPubSubType implements us.ihmc.pubsub.TopicDataType<geometry_msgs.msg.dds.TransformStamped>
{
   public static final java.lang.String name = "geometry_msgs::msg::dds_::TransformStamped_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "163ddc457f73149699ea2561bd1e220a0914568b09e28b55e34fb413df40ec3e";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(geometry_msgs.msg.dds.TransformStamped data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, geometry_msgs.msg.dds.TransformStamped data) throws java.io.IOException
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
      current_alignment += geometry_msgs.msg.dds.TransformPubSubType.getMaxCdrSerializedSize(current_alignment);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(geometry_msgs.msg.dds.TransformStamped data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(geometry_msgs.msg.dds.TransformStamped data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += std_msgs.msg.dds.HeaderPubSubType.getCdrSerializedSize(data.getHeader(), current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getChildFrameId().length() + 1;

      current_alignment += geometry_msgs.msg.dds.TransformPubSubType.getCdrSerializedSize(data.getTransform(), current_alignment);


      return current_alignment - initial_alignment;
   }

   public static void write(geometry_msgs.msg.dds.TransformStamped data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.write(data.getHeader(), cdr);
      if(data.getChildFrameId().length() <= 255)
      cdr.write_type_d(data.getChildFrameId());else
          throw new RuntimeException("child_frame_id field exceeds the maximum length: %d > %d".formatted(data.getChildFrameId().length(), 255));

      geometry_msgs.msg.dds.TransformPubSubType.write(data.getTransform(), cdr);
   }

   public static void read(geometry_msgs.msg.dds.TransformStamped data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.read(data.getHeader(), cdr);	
      cdr.read_type_d(data.getChildFrameId());	
      geometry_msgs.msg.dds.TransformPubSubType.read(data.getTransform(), cdr);	

   }

   @Override
   public final void serialize(geometry_msgs.msg.dds.TransformStamped data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.write_type_d("child_frame_id", data.getChildFrameId());
      ser.write_type_a("transform", new geometry_msgs.msg.dds.TransformPubSubType(), data.getTransform());

   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, geometry_msgs.msg.dds.TransformStamped data)
   {
      ser.read_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.read_type_d("child_frame_id", data.getChildFrameId());
      ser.read_type_a("transform", new geometry_msgs.msg.dds.TransformPubSubType(), data.getTransform());

   }

   public static void staticCopy(geometry_msgs.msg.dds.TransformStamped src, geometry_msgs.msg.dds.TransformStamped dest)
   {
      dest.set(src);
   }

   @Override
   public geometry_msgs.msg.dds.TransformStamped createData()
   {
      return new geometry_msgs.msg.dds.TransformStamped();
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
   
   public void serialize(geometry_msgs.msg.dds.TransformStamped data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(geometry_msgs.msg.dds.TransformStamped data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(geometry_msgs.msg.dds.TransformStamped src, geometry_msgs.msg.dds.TransformStamped dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public TransformStampedPubSubType newInstance()
   {
      return new TransformStampedPubSubType();
   }
}

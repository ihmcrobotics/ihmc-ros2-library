package geometry_msgs.msg.dds;

/**
* 
* Topic data type of the struct "VelocityStamped" defined in "VelocityStamped_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from VelocityStamped_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit VelocityStamped_.idl instead.
*
*/
public class VelocityStampedPubSubType implements us.ihmc.pubsub.TopicDataType<geometry_msgs.msg.dds.VelocityStamped>
{
   public static final java.lang.String name = "geometry_msgs::msg::dds_::VelocityStamped_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "e99c80b7ed24d06ef8797a892dcaca9a1426f3b9c82fb96066f3f3088161df10";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(geometry_msgs.msg.dds.VelocityStamped data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, geometry_msgs.msg.dds.VelocityStamped data) throws java.io.IOException
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
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;
      current_alignment += geometry_msgs.msg.dds.TwistPubSubType.getMaxCdrSerializedSize(current_alignment);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(geometry_msgs.msg.dds.VelocityStamped data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(geometry_msgs.msg.dds.VelocityStamped data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += std_msgs.msg.dds.HeaderPubSubType.getCdrSerializedSize(data.getHeader(), current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getBodyFrameId().length() + 1;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getReferenceFrameId().length() + 1;

      current_alignment += geometry_msgs.msg.dds.TwistPubSubType.getCdrSerializedSize(data.getVelocity(), current_alignment);


      return current_alignment - initial_alignment;
   }

   public static void write(geometry_msgs.msg.dds.VelocityStamped data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.write(data.getHeader(), cdr);
      if(data.getBodyFrameId().length() <= 255)
      cdr.write_type_d(data.getBodyFrameId());else
          throw new RuntimeException("body_frame_id field exceeds the maximum length: %d > %d".formatted(data.getBodyFrameId().length(), 255));

      if(data.getReferenceFrameId().length() <= 255)
      cdr.write_type_d(data.getReferenceFrameId());else
          throw new RuntimeException("reference_frame_id field exceeds the maximum length: %d > %d".formatted(data.getReferenceFrameId().length(), 255));

      geometry_msgs.msg.dds.TwistPubSubType.write(data.getVelocity(), cdr);
   }

   public static void read(geometry_msgs.msg.dds.VelocityStamped data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.read(data.getHeader(), cdr);	
      cdr.read_type_d(data.getBodyFrameId());	
      cdr.read_type_d(data.getReferenceFrameId());	
      geometry_msgs.msg.dds.TwistPubSubType.read(data.getVelocity(), cdr);	

   }

   @Override
   public final void serialize(geometry_msgs.msg.dds.VelocityStamped data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.write_type_d("body_frame_id", data.getBodyFrameId());
      ser.write_type_d("reference_frame_id", data.getReferenceFrameId());
      ser.write_type_a("velocity", new geometry_msgs.msg.dds.TwistPubSubType(), data.getVelocity());

   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, geometry_msgs.msg.dds.VelocityStamped data)
   {
      ser.read_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.read_type_d("body_frame_id", data.getBodyFrameId());
      ser.read_type_d("reference_frame_id", data.getReferenceFrameId());
      ser.read_type_a("velocity", new geometry_msgs.msg.dds.TwistPubSubType(), data.getVelocity());

   }

   public static void staticCopy(geometry_msgs.msg.dds.VelocityStamped src, geometry_msgs.msg.dds.VelocityStamped dest)
   {
      dest.set(src);
   }

   @Override
   public geometry_msgs.msg.dds.VelocityStamped createData()
   {
      return new geometry_msgs.msg.dds.VelocityStamped();
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
   
   public void serialize(geometry_msgs.msg.dds.VelocityStamped data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(geometry_msgs.msg.dds.VelocityStamped data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(geometry_msgs.msg.dds.VelocityStamped src, geometry_msgs.msg.dds.VelocityStamped dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public VelocityStampedPubSubType newInstance()
   {
      return new VelocityStampedPubSubType();
   }
}

package trajectory_msgs.msg.dds;

/**
* 
* Topic data type of the struct "MultiDOFJointTrajectoryPoint" defined in "MultiDOFJointTrajectoryPoint_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from MultiDOFJointTrajectoryPoint_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit MultiDOFJointTrajectoryPoint_.idl instead.
*
*/
public class MultiDOFJointTrajectoryPointPubSubType implements us.ihmc.pubsub.TopicDataType<trajectory_msgs.msg.dds.MultiDOFJointTrajectoryPoint>
{
   public static final java.lang.String name = "trajectory_msgs::msg::dds_::MultiDOFJointTrajectoryPoint_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "d05ada4b76f86c2939a22dcb7918cd949975c52cfdf5dc7931d4cc989c70dd65";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(trajectory_msgs.msg.dds.MultiDOFJointTrajectoryPoint data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, trajectory_msgs.msg.dds.MultiDOFJointTrajectoryPoint data) throws java.io.IOException
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
          current_alignment += geometry_msgs.msg.dds.TransformPubSubType.getMaxCdrSerializedSize(current_alignment);}
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 100; ++i0)
      {
          current_alignment += geometry_msgs.msg.dds.TwistPubSubType.getMaxCdrSerializedSize(current_alignment);}
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 100; ++i0)
      {
          current_alignment += geometry_msgs.msg.dds.TwistPubSubType.getMaxCdrSerializedSize(current_alignment);}
      current_alignment += builtin_interfaces.msg.dds.DurationPubSubType.getMaxCdrSerializedSize(current_alignment);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(trajectory_msgs.msg.dds.MultiDOFJointTrajectoryPoint data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(trajectory_msgs.msg.dds.MultiDOFJointTrajectoryPoint data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getTransforms().size(); ++i0)
      {
          current_alignment += geometry_msgs.msg.dds.TransformPubSubType.getCdrSerializedSize(data.getTransforms().get(i0), current_alignment);}

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getVelocities().size(); ++i0)
      {
          current_alignment += geometry_msgs.msg.dds.TwistPubSubType.getCdrSerializedSize(data.getVelocities().get(i0), current_alignment);}

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getAccelerations().size(); ++i0)
      {
          current_alignment += geometry_msgs.msg.dds.TwistPubSubType.getCdrSerializedSize(data.getAccelerations().get(i0), current_alignment);}

      current_alignment += builtin_interfaces.msg.dds.DurationPubSubType.getCdrSerializedSize(data.getTimeFromStart(), current_alignment);


      return current_alignment - initial_alignment;
   }

   public static void write(trajectory_msgs.msg.dds.MultiDOFJointTrajectoryPoint data, us.ihmc.idl.CDR cdr)
   {
      if(data.getTransforms().size() <= 100)
      cdr.write_type_e(data.getTransforms());else
          throw new RuntimeException("transforms field exceeds the maximum length: %d > %d".formatted(data.getTransforms().size(), 100));

      if(data.getVelocities().size() <= 100)
      cdr.write_type_e(data.getVelocities());else
          throw new RuntimeException("velocities field exceeds the maximum length: %d > %d".formatted(data.getVelocities().size(), 100));

      if(data.getAccelerations().size() <= 100)
      cdr.write_type_e(data.getAccelerations());else
          throw new RuntimeException("accelerations field exceeds the maximum length: %d > %d".formatted(data.getAccelerations().size(), 100));

      builtin_interfaces.msg.dds.DurationPubSubType.write(data.getTimeFromStart(), cdr);
   }

   public static void read(trajectory_msgs.msg.dds.MultiDOFJointTrajectoryPoint data, us.ihmc.idl.CDR cdr)
   {
      cdr.read_type_e(data.getTransforms());	
      cdr.read_type_e(data.getVelocities());	
      cdr.read_type_e(data.getAccelerations());	
      builtin_interfaces.msg.dds.DurationPubSubType.read(data.getTimeFromStart(), cdr);	

   }

   @Override
   public final void serialize(trajectory_msgs.msg.dds.MultiDOFJointTrajectoryPoint data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_e("transforms", data.getTransforms());
      ser.write_type_e("velocities", data.getVelocities());
      ser.write_type_e("accelerations", data.getAccelerations());
      ser.write_type_a("time_from_start", new builtin_interfaces.msg.dds.DurationPubSubType(), data.getTimeFromStart());

   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, trajectory_msgs.msg.dds.MultiDOFJointTrajectoryPoint data)
   {
      ser.read_type_e("transforms", data.getTransforms());
      ser.read_type_e("velocities", data.getVelocities());
      ser.read_type_e("accelerations", data.getAccelerations());
      ser.read_type_a("time_from_start", new builtin_interfaces.msg.dds.DurationPubSubType(), data.getTimeFromStart());

   }

   public static void staticCopy(trajectory_msgs.msg.dds.MultiDOFJointTrajectoryPoint src, trajectory_msgs.msg.dds.MultiDOFJointTrajectoryPoint dest)
   {
      dest.set(src);
   }

   @Override
   public trajectory_msgs.msg.dds.MultiDOFJointTrajectoryPoint createData()
   {
      return new trajectory_msgs.msg.dds.MultiDOFJointTrajectoryPoint();
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
   
   public void serialize(trajectory_msgs.msg.dds.MultiDOFJointTrajectoryPoint data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(trajectory_msgs.msg.dds.MultiDOFJointTrajectoryPoint data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(trajectory_msgs.msg.dds.MultiDOFJointTrajectoryPoint src, trajectory_msgs.msg.dds.MultiDOFJointTrajectoryPoint dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public MultiDOFJointTrajectoryPointPubSubType newInstance()
   {
      return new MultiDOFJointTrajectoryPointPubSubType();
   }
}

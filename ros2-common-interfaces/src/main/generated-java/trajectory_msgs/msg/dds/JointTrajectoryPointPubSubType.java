package trajectory_msgs.msg.dds;

/**
* 
* Topic data type of the struct "JointTrajectoryPoint" defined in "JointTrajectoryPoint_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from JointTrajectoryPoint_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit JointTrajectoryPoint_.idl instead.
*
*/
public class JointTrajectoryPointPubSubType implements us.ihmc.pubsub.TopicDataType<trajectory_msgs.msg.dds.JointTrajectoryPoint>
{
   public static final java.lang.String name = "trajectory_msgs::msg::dds_::JointTrajectoryPoint_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "36591927d6c9c6a4649b653a9a674d95e609bf75e32fbed272d56ad859a0270a";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(trajectory_msgs.msg.dds.JointTrajectoryPoint data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, trajectory_msgs.msg.dds.JointTrajectoryPoint data) throws java.io.IOException
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

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);current_alignment += (100 * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);current_alignment += (100 * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);current_alignment += (100 * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);current_alignment += (100 * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += builtin_interfaces.msg.dds.DurationPubSubType.getMaxCdrSerializedSize(current_alignment);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(trajectory_msgs.msg.dds.JointTrajectoryPoint data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(trajectory_msgs.msg.dds.JointTrajectoryPoint data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (data.getPositions().size() * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (data.getVelocities().size() * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (data.getAccelerations().size() * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (data.getEffort().size() * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += builtin_interfaces.msg.dds.DurationPubSubType.getCdrSerializedSize(data.getTimeFromStart(), current_alignment);


      return current_alignment - initial_alignment;
   }

   public static void write(trajectory_msgs.msg.dds.JointTrajectoryPoint data, us.ihmc.idl.CDR cdr)
   {
      if(data.getPositions().size() <= 100)
      cdr.write_type_e(data.getPositions());else
          throw new RuntimeException("positions field exceeds the maximum length: %d > %d".formatted(data.getPositions().size(), 100));

      if(data.getVelocities().size() <= 100)
      cdr.write_type_e(data.getVelocities());else
          throw new RuntimeException("velocities field exceeds the maximum length: %d > %d".formatted(data.getVelocities().size(), 100));

      if(data.getAccelerations().size() <= 100)
      cdr.write_type_e(data.getAccelerations());else
          throw new RuntimeException("accelerations field exceeds the maximum length: %d > %d".formatted(data.getAccelerations().size(), 100));

      if(data.getEffort().size() <= 100)
      cdr.write_type_e(data.getEffort());else
          throw new RuntimeException("effort field exceeds the maximum length: %d > %d".formatted(data.getEffort().size(), 100));

      builtin_interfaces.msg.dds.DurationPubSubType.write(data.getTimeFromStart(), cdr);
   }

   public static void read(trajectory_msgs.msg.dds.JointTrajectoryPoint data, us.ihmc.idl.CDR cdr)
   {
      cdr.read_type_e(data.getPositions());	
      cdr.read_type_e(data.getVelocities());	
      cdr.read_type_e(data.getAccelerations());	
      cdr.read_type_e(data.getEffort());	
      builtin_interfaces.msg.dds.DurationPubSubType.read(data.getTimeFromStart(), cdr);	

   }

   @Override
   public final void serialize(trajectory_msgs.msg.dds.JointTrajectoryPoint data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_e("positions", data.getPositions());
      ser.write_type_e("velocities", data.getVelocities());
      ser.write_type_e("accelerations", data.getAccelerations());
      ser.write_type_e("effort", data.getEffort());
      ser.write_type_a("time_from_start", new builtin_interfaces.msg.dds.DurationPubSubType(), data.getTimeFromStart());

   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, trajectory_msgs.msg.dds.JointTrajectoryPoint data)
   {
      ser.read_type_e("positions", data.getPositions());
      ser.read_type_e("velocities", data.getVelocities());
      ser.read_type_e("accelerations", data.getAccelerations());
      ser.read_type_e("effort", data.getEffort());
      ser.read_type_a("time_from_start", new builtin_interfaces.msg.dds.DurationPubSubType(), data.getTimeFromStart());

   }

   public static void staticCopy(trajectory_msgs.msg.dds.JointTrajectoryPoint src, trajectory_msgs.msg.dds.JointTrajectoryPoint dest)
   {
      dest.set(src);
   }

   @Override
   public trajectory_msgs.msg.dds.JointTrajectoryPoint createData()
   {
      return new trajectory_msgs.msg.dds.JointTrajectoryPoint();
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
   
   public void serialize(trajectory_msgs.msg.dds.JointTrajectoryPoint data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(trajectory_msgs.msg.dds.JointTrajectoryPoint data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(trajectory_msgs.msg.dds.JointTrajectoryPoint src, trajectory_msgs.msg.dds.JointTrajectoryPoint dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public JointTrajectoryPointPubSubType newInstance()
   {
      return new JointTrajectoryPointPubSubType();
   }
}

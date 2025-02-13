package actionlib_msgs.msg.dds;

/**
* 
* Topic data type of the struct "GoalStatus" defined in "GoalStatus_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from GoalStatus_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit GoalStatus_.idl instead.
*
*/
public class GoalStatusPubSubType implements us.ihmc.pubsub.TopicDataType<actionlib_msgs.msg.dds.GoalStatus>
{
   public static final java.lang.String name = "actionlib_msgs::msg::dds_::GoalStatus_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "164fdc878f46714a774cec38502e9df5129ff4c034ba1be1012f31095d05159e";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(actionlib_msgs.msg.dds.GoalStatus data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, actionlib_msgs.msg.dds.GoalStatus data) throws java.io.IOException
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

      current_alignment += actionlib_msgs.msg.dds.GoalIDPubSubType.getMaxCdrSerializedSize(current_alignment);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(actionlib_msgs.msg.dds.GoalStatus data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(actionlib_msgs.msg.dds.GoalStatus data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += actionlib_msgs.msg.dds.GoalIDPubSubType.getCdrSerializedSize(data.getGoalId(), current_alignment);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getText().length() + 1;


      return current_alignment - initial_alignment;
   }

   public static void write(actionlib_msgs.msg.dds.GoalStatus data, us.ihmc.idl.CDR cdr)
   {
      actionlib_msgs.msg.dds.GoalIDPubSubType.write(data.getGoalId(), cdr);
      cdr.write_type_9(data.getStatus());

      if(data.getText().length() <= 255)
      cdr.write_type_d(data.getText());else
          throw new RuntimeException("text field exceeds the maximum length: %d > %d".formatted(data.getText().length(), 255));

   }

   public static void read(actionlib_msgs.msg.dds.GoalStatus data, us.ihmc.idl.CDR cdr)
   {
      actionlib_msgs.msg.dds.GoalIDPubSubType.read(data.getGoalId(), cdr);	
      data.setStatus(cdr.read_type_9());
      	
      cdr.read_type_d(data.getText());	

   }

   @Override
   public final void serialize(actionlib_msgs.msg.dds.GoalStatus data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("goal_id", new actionlib_msgs.msg.dds.GoalIDPubSubType(), data.getGoalId());

      ser.write_type_9("status", data.getStatus());
      ser.write_type_d("text", data.getText());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, actionlib_msgs.msg.dds.GoalStatus data)
   {
      ser.read_type_a("goal_id", new actionlib_msgs.msg.dds.GoalIDPubSubType(), data.getGoalId());

      data.setStatus(ser.read_type_9("status"));
      ser.read_type_d("text", data.getText());
   }

   public static void staticCopy(actionlib_msgs.msg.dds.GoalStatus src, actionlib_msgs.msg.dds.GoalStatus dest)
   {
      dest.set(src);
   }

   @Override
   public actionlib_msgs.msg.dds.GoalStatus createData()
   {
      return new actionlib_msgs.msg.dds.GoalStatus();
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
   
   public void serialize(actionlib_msgs.msg.dds.GoalStatus data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(actionlib_msgs.msg.dds.GoalStatus data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(actionlib_msgs.msg.dds.GoalStatus src, actionlib_msgs.msg.dds.GoalStatus dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public GoalStatusPubSubType newInstance()
   {
      return new GoalStatusPubSubType();
   }
}

package nav_msgs.msg.dds;

/**
* 
* Topic data type of the struct "Goals" defined in "Goals_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from Goals_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit Goals_.idl instead.
*
*/
public class GoalsPubSubType implements us.ihmc.pubsub.TopicDataType<nav_msgs.msg.dds.Goals>
{
   public static final java.lang.String name = "nav_msgs::msg::dds_::Goals_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "6f12eafe96b8046c8f530ab66915f6a05364018ce1e1d3b0de62afe4f51f76c4";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(nav_msgs.msg.dds.Goals data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, nav_msgs.msg.dds.Goals data) throws java.io.IOException
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

   public final static int getCdrSerializedSize(nav_msgs.msg.dds.Goals data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(nav_msgs.msg.dds.Goals data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += std_msgs.msg.dds.HeaderPubSubType.getCdrSerializedSize(data.getHeader(), current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getGoals().size(); ++i0)
      {
          current_alignment += geometry_msgs.msg.dds.PoseStampedPubSubType.getCdrSerializedSize(data.getGoals().get(i0), current_alignment);}


      return current_alignment - initial_alignment;
   }

   public static void write(nav_msgs.msg.dds.Goals data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.write(data.getHeader(), cdr);
      if(data.getGoals().size() <= 100)
      cdr.write_type_e(data.getGoals());else
          throw new RuntimeException("goals field exceeds the maximum length: %d > %d".formatted(data.getGoals().size(), 100));

   }

   public static void read(nav_msgs.msg.dds.Goals data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.read(data.getHeader(), cdr);	
      cdr.read_type_e(data.getGoals());	

   }

   @Override
   public final void serialize(nav_msgs.msg.dds.Goals data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.write_type_e("goals", data.getGoals());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, nav_msgs.msg.dds.Goals data)
   {
      ser.read_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.read_type_e("goals", data.getGoals());
   }

   public static void staticCopy(nav_msgs.msg.dds.Goals src, nav_msgs.msg.dds.Goals dest)
   {
      dest.set(src);
   }

   @Override
   public nav_msgs.msg.dds.Goals createData()
   {
      return new nav_msgs.msg.dds.Goals();
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
   
   public void serialize(nav_msgs.msg.dds.Goals data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(nav_msgs.msg.dds.Goals data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(nav_msgs.msg.dds.Goals src, nav_msgs.msg.dds.Goals dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public GoalsPubSubType newInstance()
   {
      return new GoalsPubSubType();
   }
}

package ros_msgs.msg.dds;

/**
* 
* Topic data type of the struct "BigNumSequence" defined in "BigNumSequence_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from BigNumSequence_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit BigNumSequence_.idl instead.
*
*/
public class BigNumSequencePubSubType implements us.ihmc.pubsub.TopicDataType<ros_msgs.msg.dds.BigNumSequence>
{
   public static final java.lang.String name = "ros_msgs::msg::dds_::BigNumSequence_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "e096d173daf0b557338ea3ffacfe07d80c33f4e9283d32707915d29c688172a6";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(ros_msgs.msg.dds.BigNumSequence data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, ros_msgs.msg.dds.BigNumSequence data) throws java.io.IOException
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

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 10000; ++i0)
      {
          current_alignment += ros_msgs.msg.dds.NumPubSubType.getMaxCdrSerializedSize(current_alignment);}
      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(ros_msgs.msg.dds.BigNumSequence data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(ros_msgs.msg.dds.BigNumSequence data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getLargeSequence().size(); ++i0)
      {
          current_alignment += ros_msgs.msg.dds.NumPubSubType.getCdrSerializedSize(data.getLargeSequence().get(i0), current_alignment);}

      return current_alignment - initial_alignment;
   }

   public static void write(ros_msgs.msg.dds.BigNumSequence data, us.ihmc.idl.CDR cdr)
   {
      if(data.getLargeSequence().size() <= 10000)
      cdr.write_type_e(data.getLargeSequence());else
          throw new RuntimeException("large_sequence field exceeds the maximum length");

   }

   public static void read(ros_msgs.msg.dds.BigNumSequence data, us.ihmc.idl.CDR cdr)
   {
      cdr.read_type_e(data.getLargeSequence());	

   }

   @Override
   public final void serialize(ros_msgs.msg.dds.BigNumSequence data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_e("large_sequence", data.getLargeSequence());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, ros_msgs.msg.dds.BigNumSequence data)
   {
      ser.read_type_e("large_sequence", data.getLargeSequence());
   }

   public static void staticCopy(ros_msgs.msg.dds.BigNumSequence src, ros_msgs.msg.dds.BigNumSequence dest)
   {
      dest.set(src);
   }

   @Override
   public ros_msgs.msg.dds.BigNumSequence createData()
   {
      return new ros_msgs.msg.dds.BigNumSequence();
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
   
   public void serialize(ros_msgs.msg.dds.BigNumSequence data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(ros_msgs.msg.dds.BigNumSequence data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(ros_msgs.msg.dds.BigNumSequence src, ros_msgs.msg.dds.BigNumSequence dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public BigNumSequencePubSubType newInstance()
   {
      return new BigNumSequencePubSubType();
   }
}

package lifecycle_msgs.msg.dds;

/**
* 
* Topic data type of the struct "Transition" defined in "Transition_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from Transition_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit Transition_.idl instead.
*
*/
public class TransitionPubSubType implements us.ihmc.pubsub.TopicDataType<lifecycle_msgs.msg.dds.Transition>
{
   public static final java.lang.String name = "lifecycle_msgs::msg::dds_::Transition_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "48a1705d314d4753a96b0e98d36c308249fd0c5d7a6940c897d991882138e4f7";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(lifecycle_msgs.msg.dds.Transition data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, lifecycle_msgs.msg.dds.Transition data) throws java.io.IOException
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

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(lifecycle_msgs.msg.dds.Transition data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(lifecycle_msgs.msg.dds.Transition data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getLabel().length() + 1;


      return current_alignment - initial_alignment;
   }

   public static void write(lifecycle_msgs.msg.dds.Transition data, us.ihmc.idl.CDR cdr)
   {
      cdr.write_type_9(data.getId());

      if(data.getLabel().length() <= 255)
      cdr.write_type_d(data.getLabel());else
          throw new RuntimeException("label field exceeds the maximum length: %d > %d".formatted(data.getLabel().length(), 255));

   }

   public static void read(lifecycle_msgs.msg.dds.Transition data, us.ihmc.idl.CDR cdr)
   {
      data.setId(cdr.read_type_9());
      	
      cdr.read_type_d(data.getLabel());	

   }

   @Override
   public final void serialize(lifecycle_msgs.msg.dds.Transition data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_9("id", data.getId());
      ser.write_type_d("label", data.getLabel());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, lifecycle_msgs.msg.dds.Transition data)
   {
      data.setId(ser.read_type_9("id"));
      ser.read_type_d("label", data.getLabel());
   }

   public static void staticCopy(lifecycle_msgs.msg.dds.Transition src, lifecycle_msgs.msg.dds.Transition dest)
   {
      dest.set(src);
   }

   @Override
   public lifecycle_msgs.msg.dds.Transition createData()
   {
      return new lifecycle_msgs.msg.dds.Transition();
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
   
   public void serialize(lifecycle_msgs.msg.dds.Transition data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(lifecycle_msgs.msg.dds.Transition data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(lifecycle_msgs.msg.dds.Transition src, lifecycle_msgs.msg.dds.Transition dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public TransitionPubSubType newInstance()
   {
      return new TransitionPubSubType();
   }
}

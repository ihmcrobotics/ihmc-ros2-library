package ros_msgs.msg.dds;

/**
* 
* Topic data type of the struct "EmptyOne" defined in "EmptyOne_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from EmptyOne_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit EmptyOne_.idl instead.
*
*/
public class EmptyOnePubSubType implements us.ihmc.pubsub.TopicDataType<ros_msgs.msg.dds.EmptyOne>
{
   public static final java.lang.String name = "ros_msgs::msg::dds_::EmptyOne_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "e84161c0605080c021906af007b5c881c0fbc275ea30f169f67347df78c826a1";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(ros_msgs.msg.dds.EmptyOne data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, ros_msgs.msg.dds.EmptyOne data) throws java.io.IOException
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
      // UnusedPlaceholderField (unbounded)
      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      return current_alignment - initial_alignment;   }

   public final static int getCdrSerializedSize(ros_msgs.msg.dds.EmptyOne data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(ros_msgs.msg.dds.EmptyOne data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      // UnusedPlaceholderField (unbounded)
      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);



      return current_alignment - initial_alignment;
   }

   public static void write(ros_msgs.msg.dds.EmptyOne data, us.ihmc.idl.CDR cdr)
   {
      // UnusedPlaceholderField (unbounded)
      cdr.write_type_7(data.getUnusedPlaceholderField());

   }

   public static void read(ros_msgs.msg.dds.EmptyOne data, us.ihmc.idl.CDR cdr)
   {
      // UnusedPlaceholderField (unbounded)
      data.setUnusedPlaceholderField(cdr.read_type_7());
      	

   }

   @Override
   public final void serialize(ros_msgs.msg.dds.EmptyOne data, us.ihmc.idl.InterchangeSerializer ser)
   {
      // UnusedPlaceholderField (unbounded)
      ser.write_type_7("unused_placeholder_field", data.getUnusedPlaceholderField());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, ros_msgs.msg.dds.EmptyOne data)
   {
      // UnusedPlaceholderField (unbounded)
      data.setUnusedPlaceholderField(ser.read_type_7("unused_placeholder_field"));
   }

   public static void staticCopy(ros_msgs.msg.dds.EmptyOne src, ros_msgs.msg.dds.EmptyOne dest)
   {
      dest.set(src);
   }

   @Override
   public ros_msgs.msg.dds.EmptyOne createData()
   {
      return new ros_msgs.msg.dds.EmptyOne();
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
   
   public void serialize(ros_msgs.msg.dds.EmptyOne data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(ros_msgs.msg.dds.EmptyOne data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(ros_msgs.msg.dds.EmptyOne src, ros_msgs.msg.dds.EmptyOne dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public EmptyOnePubSubType newInstance()
   {
      return new EmptyOnePubSubType();
   }
}

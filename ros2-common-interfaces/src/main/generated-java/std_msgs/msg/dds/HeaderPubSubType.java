package std_msgs.msg.dds;

/**
* 
* Topic data type of the struct "Header" defined in "Header_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from Header_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit Header_.idl instead.
*
*/
public class HeaderPubSubType implements us.ihmc.pubsub.TopicDataType<std_msgs.msg.dds.Header>
{
   public static final java.lang.String name = "std_msgs::msg::dds_::Header_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "fa751b1f55bd91eee31335a4b21b4fe4144b2e349c25e1e24ac391d66831fe1a";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(std_msgs.msg.dds.Header data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, std_msgs.msg.dds.Header data) throws java.io.IOException
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

      current_alignment += builtin_interfaces.msg.dds.TimePubSubType.getMaxCdrSerializedSize(current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(std_msgs.msg.dds.Header data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(std_msgs.msg.dds.Header data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += builtin_interfaces.msg.dds.TimePubSubType.getCdrSerializedSize(data.getStamp(), current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getFrameId().length() + 1;


      return current_alignment - initial_alignment;
   }

   public static void write(std_msgs.msg.dds.Header data, us.ihmc.idl.CDR cdr)
   {
      builtin_interfaces.msg.dds.TimePubSubType.write(data.getStamp(), cdr);
      if(data.getFrameId().length() <= 255)
      cdr.write_type_d(data.getFrameId());else
          throw new RuntimeException("frame_id field exceeds the maximum length: %d > %d".formatted(data.getFrameId().length(), 255));

   }

   public static void read(std_msgs.msg.dds.Header data, us.ihmc.idl.CDR cdr)
   {
      builtin_interfaces.msg.dds.TimePubSubType.read(data.getStamp(), cdr);	
      cdr.read_type_d(data.getFrameId());	

   }

   @Override
   public final void serialize(std_msgs.msg.dds.Header data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("stamp", new builtin_interfaces.msg.dds.TimePubSubType(), data.getStamp());

      ser.write_type_d("frame_id", data.getFrameId());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, std_msgs.msg.dds.Header data)
   {
      ser.read_type_a("stamp", new builtin_interfaces.msg.dds.TimePubSubType(), data.getStamp());

      ser.read_type_d("frame_id", data.getFrameId());
   }

   public static void staticCopy(std_msgs.msg.dds.Header src, std_msgs.msg.dds.Header dest)
   {
      dest.set(src);
   }

   @Override
   public std_msgs.msg.dds.Header createData()
   {
      return new std_msgs.msg.dds.Header();
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
   
   public void serialize(std_msgs.msg.dds.Header data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(std_msgs.msg.dds.Header data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(std_msgs.msg.dds.Header src, std_msgs.msg.dds.Header dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public HeaderPubSubType newInstance()
   {
      return new HeaderPubSubType();
   }
}

package tf2_msgs.msg.dds;

/**
* 
* Topic data type of the struct "TFMessage" defined in "TFMessage_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from TFMessage_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit TFMessage_.idl instead.
*
*/
public class TFMessagePubSubType implements us.ihmc.pubsub.TopicDataType<tf2_msgs.msg.dds.TFMessage>
{
   public static final java.lang.String name = "tf2_msgs::msg::dds_::TFMessage_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "6feff138edee6fc3c16fdf9ab0b4c9e0b5ea7108ece559b00b28d4dad3fd09d6";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(tf2_msgs.msg.dds.TFMessage data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, tf2_msgs.msg.dds.TFMessage data) throws java.io.IOException
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
          current_alignment += geometry_msgs.msg.dds.TransformStampedPubSubType.getMaxCdrSerializedSize(current_alignment);}
      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(tf2_msgs.msg.dds.TFMessage data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(tf2_msgs.msg.dds.TFMessage data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getTransforms().size(); ++i0)
      {
          current_alignment += geometry_msgs.msg.dds.TransformStampedPubSubType.getCdrSerializedSize(data.getTransforms().get(i0), current_alignment);}

      return current_alignment - initial_alignment;
   }

   public static void write(tf2_msgs.msg.dds.TFMessage data, us.ihmc.idl.CDR cdr)
   {
      if(data.getTransforms().size() <= 100)
      cdr.write_type_e(data.getTransforms());else
          throw new RuntimeException("transforms field exceeds the maximum length: %d > %d".formatted(data.getTransforms().size(), 100));

   }

   public static void read(tf2_msgs.msg.dds.TFMessage data, us.ihmc.idl.CDR cdr)
   {
      cdr.read_type_e(data.getTransforms());	

   }

   @Override
   public final void serialize(tf2_msgs.msg.dds.TFMessage data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_e("transforms", data.getTransforms());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, tf2_msgs.msg.dds.TFMessage data)
   {
      ser.read_type_e("transforms", data.getTransforms());
   }

   public static void staticCopy(tf2_msgs.msg.dds.TFMessage src, tf2_msgs.msg.dds.TFMessage dest)
   {
      dest.set(src);
   }

   @Override
   public tf2_msgs.msg.dds.TFMessage createData()
   {
      return new tf2_msgs.msg.dds.TFMessage();
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
   
   public void serialize(tf2_msgs.msg.dds.TFMessage data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(tf2_msgs.msg.dds.TFMessage data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(tf2_msgs.msg.dds.TFMessage src, tf2_msgs.msg.dds.TFMessage dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public TFMessagePubSubType newInstance()
   {
      return new TFMessagePubSubType();
   }
}

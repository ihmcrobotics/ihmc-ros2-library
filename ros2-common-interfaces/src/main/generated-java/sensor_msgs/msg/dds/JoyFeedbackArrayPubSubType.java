package sensor_msgs.msg.dds;

/**
* 
* Topic data type of the struct "JoyFeedbackArray" defined in "JoyFeedbackArray_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from JoyFeedbackArray_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit JoyFeedbackArray_.idl instead.
*
*/
public class JoyFeedbackArrayPubSubType implements us.ihmc.pubsub.TopicDataType<sensor_msgs.msg.dds.JoyFeedbackArray>
{
   public static final java.lang.String name = "sensor_msgs::msg::dds_::JoyFeedbackArray_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "c73dad552ddd008e1f24513ec894b9b87a27a376d809ae37f92470b3b5c733c3";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(sensor_msgs.msg.dds.JoyFeedbackArray data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, sensor_msgs.msg.dds.JoyFeedbackArray data) throws java.io.IOException
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
          current_alignment += sensor_msgs.msg.dds.JoyFeedbackPubSubType.getMaxCdrSerializedSize(current_alignment);}
      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(sensor_msgs.msg.dds.JoyFeedbackArray data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(sensor_msgs.msg.dds.JoyFeedbackArray data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getArray().size(); ++i0)
      {
          current_alignment += sensor_msgs.msg.dds.JoyFeedbackPubSubType.getCdrSerializedSize(data.getArray().get(i0), current_alignment);}

      return current_alignment - initial_alignment;
   }

   public static void write(sensor_msgs.msg.dds.JoyFeedbackArray data, us.ihmc.idl.CDR cdr)
   {
      if(data.getArray().size() <= 100)
      cdr.write_type_e(data.getArray());else
          throw new RuntimeException("array field exceeds the maximum length: %d > %d".formatted(data.getArray().size(), 100));

   }

   public static void read(sensor_msgs.msg.dds.JoyFeedbackArray data, us.ihmc.idl.CDR cdr)
   {
      cdr.read_type_e(data.getArray());	

   }

   @Override
   public final void serialize(sensor_msgs.msg.dds.JoyFeedbackArray data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_e("array", data.getArray());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, sensor_msgs.msg.dds.JoyFeedbackArray data)
   {
      ser.read_type_e("array", data.getArray());
   }

   public static void staticCopy(sensor_msgs.msg.dds.JoyFeedbackArray src, sensor_msgs.msg.dds.JoyFeedbackArray dest)
   {
      dest.set(src);
   }

   @Override
   public sensor_msgs.msg.dds.JoyFeedbackArray createData()
   {
      return new sensor_msgs.msg.dds.JoyFeedbackArray();
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
   
   public void serialize(sensor_msgs.msg.dds.JoyFeedbackArray data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(sensor_msgs.msg.dds.JoyFeedbackArray data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(sensor_msgs.msg.dds.JoyFeedbackArray src, sensor_msgs.msg.dds.JoyFeedbackArray dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public JoyFeedbackArrayPubSubType newInstance()
   {
      return new JoyFeedbackArrayPubSubType();
   }
}

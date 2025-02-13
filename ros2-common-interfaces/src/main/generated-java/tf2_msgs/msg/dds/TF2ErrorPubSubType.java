package tf2_msgs.msg.dds;

/**
* 
* Topic data type of the struct "TF2Error" defined in "TF2Error_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from TF2Error_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit TF2Error_.idl instead.
*
*/
public class TF2ErrorPubSubType implements us.ihmc.pubsub.TopicDataType<tf2_msgs.msg.dds.TF2Error>
{
   public static final java.lang.String name = "tf2_msgs::msg::dds_::TF2Error_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "c3c8db7ee8ceaa4e43d863f4fe2bf3a2fe9382f94b0553e067e2eba50daf1595";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(tf2_msgs.msg.dds.TF2Error data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, tf2_msgs.msg.dds.TF2Error data) throws java.io.IOException
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

   public final static int getCdrSerializedSize(tf2_msgs.msg.dds.TF2Error data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(tf2_msgs.msg.dds.TF2Error data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getErrorString().length() + 1;


      return current_alignment - initial_alignment;
   }

   public static void write(tf2_msgs.msg.dds.TF2Error data, us.ihmc.idl.CDR cdr)
   {
      cdr.write_type_9(data.getError());

      if(data.getErrorString().length() <= 255)
      cdr.write_type_d(data.getErrorString());else
          throw new RuntimeException("error_string field exceeds the maximum length: %d > %d".formatted(data.getErrorString().length(), 255));

   }

   public static void read(tf2_msgs.msg.dds.TF2Error data, us.ihmc.idl.CDR cdr)
   {
      data.setError(cdr.read_type_9());
      	
      cdr.read_type_d(data.getErrorString());	

   }

   @Override
   public final void serialize(tf2_msgs.msg.dds.TF2Error data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_9("error", data.getError());
      ser.write_type_d("error_string", data.getErrorString());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, tf2_msgs.msg.dds.TF2Error data)
   {
      data.setError(ser.read_type_9("error"));
      ser.read_type_d("error_string", data.getErrorString());
   }

   public static void staticCopy(tf2_msgs.msg.dds.TF2Error src, tf2_msgs.msg.dds.TF2Error dest)
   {
      dest.set(src);
   }

   @Override
   public tf2_msgs.msg.dds.TF2Error createData()
   {
      return new tf2_msgs.msg.dds.TF2Error();
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
   
   public void serialize(tf2_msgs.msg.dds.TF2Error data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(tf2_msgs.msg.dds.TF2Error data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(tf2_msgs.msg.dds.TF2Error src, tf2_msgs.msg.dds.TF2Error dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public TF2ErrorPubSubType newInstance()
   {
      return new TF2ErrorPubSubType();
   }
}

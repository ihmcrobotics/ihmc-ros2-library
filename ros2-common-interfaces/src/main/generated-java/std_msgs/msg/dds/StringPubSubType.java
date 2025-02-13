package std_msgs.msg.dds;

/**
* 
* Topic data type of the struct "String" defined in "String_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from String_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit String_.idl instead.
*
*/
public class StringPubSubType implements us.ihmc.pubsub.TopicDataType<std_msgs.msg.dds.String>
{
   public static final java.lang.String name = "std_msgs::msg::dds_::String_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "4e293427c093da0329b82b5eed7a2a9f1c59bfa200e01ffd429483d76d160218";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(std_msgs.msg.dds.String data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, std_msgs.msg.dds.String data) throws java.io.IOException
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

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;
      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(std_msgs.msg.dds.String data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(std_msgs.msg.dds.String data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getData().length() + 1;

      return current_alignment - initial_alignment;
   }

   public static void write(std_msgs.msg.dds.String data, us.ihmc.idl.CDR cdr)
   {
      if(data.getData().length() <= 255)
      cdr.write_type_d(data.getData());else
          throw new RuntimeException("data field exceeds the maximum length: %d > %d".formatted(data.getData().length(), 255));

   }

   public static void read(std_msgs.msg.dds.String data, us.ihmc.idl.CDR cdr)
   {
      cdr.read_type_d(data.getData());	

   }

   @Override
   public final void serialize(std_msgs.msg.dds.String data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_d("data", data.getData());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, std_msgs.msg.dds.String data)
   {
      ser.read_type_d("data", data.getData());
   }

   public static void staticCopy(std_msgs.msg.dds.String src, std_msgs.msg.dds.String dest)
   {
      dest.set(src);
   }

   @Override
   public std_msgs.msg.dds.String createData()
   {
      return new std_msgs.msg.dds.String();
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
   
   public void serialize(std_msgs.msg.dds.String data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(std_msgs.msg.dds.String data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(std_msgs.msg.dds.String src, std_msgs.msg.dds.String dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public StringPubSubType newInstance()
   {
      return new StringPubSubType();
   }
}

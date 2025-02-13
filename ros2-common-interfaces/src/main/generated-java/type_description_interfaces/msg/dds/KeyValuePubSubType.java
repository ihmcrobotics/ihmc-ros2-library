package type_description_interfaces.msg.dds;

/**
* 
* Topic data type of the struct "KeyValue" defined in "KeyValue_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from KeyValue_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit KeyValue_.idl instead.
*
*/
public class KeyValuePubSubType implements us.ihmc.pubsub.TopicDataType<type_description_interfaces.msg.dds.KeyValue>
{
   public static final java.lang.String name = "type_description_interfaces::msg::dds_::KeyValue_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "319a6889f4c5db2a4b90d7af5c109164514391f08115cb6f5d532def033c55a3";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(type_description_interfaces.msg.dds.KeyValue data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, type_description_interfaces.msg.dds.KeyValue data) throws java.io.IOException
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
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(type_description_interfaces.msg.dds.KeyValue data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(type_description_interfaces.msg.dds.KeyValue data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getKey().length() + 1;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getValue().length() + 1;


      return current_alignment - initial_alignment;
   }

   public static void write(type_description_interfaces.msg.dds.KeyValue data, us.ihmc.idl.CDR cdr)
   {
      if(data.getKey().length() <= 255)
      cdr.write_type_d(data.getKey());else
          throw new RuntimeException("key field exceeds the maximum length: %d > %d".formatted(data.getKey().length(), 255));

      if(data.getValue().length() <= 255)
      cdr.write_type_d(data.getValue());else
          throw new RuntimeException("value field exceeds the maximum length: %d > %d".formatted(data.getValue().length(), 255));

   }

   public static void read(type_description_interfaces.msg.dds.KeyValue data, us.ihmc.idl.CDR cdr)
   {
      cdr.read_type_d(data.getKey());	
      cdr.read_type_d(data.getValue());	

   }

   @Override
   public final void serialize(type_description_interfaces.msg.dds.KeyValue data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_d("key", data.getKey());
      ser.write_type_d("value", data.getValue());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, type_description_interfaces.msg.dds.KeyValue data)
   {
      ser.read_type_d("key", data.getKey());
      ser.read_type_d("value", data.getValue());
   }

   public static void staticCopy(type_description_interfaces.msg.dds.KeyValue src, type_description_interfaces.msg.dds.KeyValue dest)
   {
      dest.set(src);
   }

   @Override
   public type_description_interfaces.msg.dds.KeyValue createData()
   {
      return new type_description_interfaces.msg.dds.KeyValue();
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
   
   public void serialize(type_description_interfaces.msg.dds.KeyValue data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(type_description_interfaces.msg.dds.KeyValue data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(type_description_interfaces.msg.dds.KeyValue src, type_description_interfaces.msg.dds.KeyValue dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public KeyValuePubSubType newInstance()
   {
      return new KeyValuePubSubType();
   }
}

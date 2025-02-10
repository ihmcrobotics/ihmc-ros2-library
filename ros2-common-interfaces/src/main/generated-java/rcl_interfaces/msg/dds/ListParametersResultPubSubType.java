package rcl_interfaces.msg.dds;

/**
* 
* Topic data type of the struct "ListParametersResult" defined in "ListParametersResult_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from ListParametersResult_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit ListParametersResult_.idl instead.
*
*/
public class ListParametersResultPubSubType implements us.ihmc.pubsub.TopicDataType<rcl_interfaces.msg.dds.ListParametersResult>
{
   public static final java.lang.String name = "rcl_interfaces::msg::dds_::ListParametersResult_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "c4a8e54f9922f7776c6ff22ab19af5c1e8ae139fc4e9eee4dc8ce5e9927c7e3a";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(rcl_interfaces.msg.dds.ListParametersResult data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, rcl_interfaces.msg.dds.ListParametersResult data) throws java.io.IOException
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
        current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;
      }
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 100; ++i0)
      {
        current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;
      }

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(rcl_interfaces.msg.dds.ListParametersResult data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(rcl_interfaces.msg.dds.ListParametersResult data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getNames().size(); ++i0)
      {
          current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getNames().get(i0).length() + 1;
      }
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getPrefixes().size(); ++i0)
      {
          current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getPrefixes().get(i0).length() + 1;
      }

      return current_alignment - initial_alignment;
   }

   public static void write(rcl_interfaces.msg.dds.ListParametersResult data, us.ihmc.idl.CDR cdr)
   {
      if(data.getNames().size() <= 100)
      cdr.write_type_e(data.getNames());else
          throw new RuntimeException("names field exceeds the maximum length: %d > %d".formatted(data.getNames().size(), 100));

      if(data.getPrefixes().size() <= 100)
      cdr.write_type_e(data.getPrefixes());else
          throw new RuntimeException("prefixes field exceeds the maximum length: %d > %d".formatted(data.getPrefixes().size(), 100));

   }

   public static void read(rcl_interfaces.msg.dds.ListParametersResult data, us.ihmc.idl.CDR cdr)
   {
      cdr.read_type_e(data.getNames());	
      cdr.read_type_e(data.getPrefixes());	

   }

   @Override
   public final void serialize(rcl_interfaces.msg.dds.ListParametersResult data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_e("names", data.getNames());
      ser.write_type_e("prefixes", data.getPrefixes());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, rcl_interfaces.msg.dds.ListParametersResult data)
   {
      ser.read_type_e("names", data.getNames());
      ser.read_type_e("prefixes", data.getPrefixes());
   }

   public static void staticCopy(rcl_interfaces.msg.dds.ListParametersResult src, rcl_interfaces.msg.dds.ListParametersResult dest)
   {
      dest.set(src);
   }

   @Override
   public rcl_interfaces.msg.dds.ListParametersResult createData()
   {
      return new rcl_interfaces.msg.dds.ListParametersResult();
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
   
   public void serialize(rcl_interfaces.msg.dds.ListParametersResult data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(rcl_interfaces.msg.dds.ListParametersResult data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(rcl_interfaces.msg.dds.ListParametersResult src, rcl_interfaces.msg.dds.ListParametersResult dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public ListParametersResultPubSubType newInstance()
   {
      return new ListParametersResultPubSubType();
   }
}

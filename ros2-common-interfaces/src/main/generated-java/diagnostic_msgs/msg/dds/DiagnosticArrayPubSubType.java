package diagnostic_msgs.msg.dds;

/**
* 
* Topic data type of the struct "DiagnosticArray" defined in "DiagnosticArray_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from DiagnosticArray_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit DiagnosticArray_.idl instead.
*
*/
public class DiagnosticArrayPubSubType implements us.ihmc.pubsub.TopicDataType<diagnostic_msgs.msg.dds.DiagnosticArray>
{
   public static final java.lang.String name = "diagnostic_msgs::msg::dds_::DiagnosticArray_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "93e9f01002c0da92d1249e8f0eaf555588b07696922a522531e5c575b4b4629d";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(diagnostic_msgs.msg.dds.DiagnosticArray data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, diagnostic_msgs.msg.dds.DiagnosticArray data) throws java.io.IOException
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

      current_alignment += std_msgs.msg.dds.HeaderPubSubType.getMaxCdrSerializedSize(current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 100; ++i0)
      {
          current_alignment += diagnostic_msgs.msg.dds.DiagnosticStatusPubSubType.getMaxCdrSerializedSize(current_alignment);}

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(diagnostic_msgs.msg.dds.DiagnosticArray data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(diagnostic_msgs.msg.dds.DiagnosticArray data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += std_msgs.msg.dds.HeaderPubSubType.getCdrSerializedSize(data.getHeader(), current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getStatus().size(); ++i0)
      {
          current_alignment += diagnostic_msgs.msg.dds.DiagnosticStatusPubSubType.getCdrSerializedSize(data.getStatus().get(i0), current_alignment);}


      return current_alignment - initial_alignment;
   }

   public static void write(diagnostic_msgs.msg.dds.DiagnosticArray data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.write(data.getHeader(), cdr);
      if(data.getStatus().size() <= 100)
      cdr.write_type_e(data.getStatus());else
          throw new RuntimeException("status field exceeds the maximum length: %d > %d".formatted(data.getStatus().size(), 100));

   }

   public static void read(diagnostic_msgs.msg.dds.DiagnosticArray data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.read(data.getHeader(), cdr);	
      cdr.read_type_e(data.getStatus());	

   }

   @Override
   public final void serialize(diagnostic_msgs.msg.dds.DiagnosticArray data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.write_type_e("status", data.getStatus());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, diagnostic_msgs.msg.dds.DiagnosticArray data)
   {
      ser.read_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.read_type_e("status", data.getStatus());
   }

   public static void staticCopy(diagnostic_msgs.msg.dds.DiagnosticArray src, diagnostic_msgs.msg.dds.DiagnosticArray dest)
   {
      dest.set(src);
   }

   @Override
   public diagnostic_msgs.msg.dds.DiagnosticArray createData()
   {
      return new diagnostic_msgs.msg.dds.DiagnosticArray();
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
   
   public void serialize(diagnostic_msgs.msg.dds.DiagnosticArray data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(diagnostic_msgs.msg.dds.DiagnosticArray data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(diagnostic_msgs.msg.dds.DiagnosticArray src, diagnostic_msgs.msg.dds.DiagnosticArray dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public DiagnosticArrayPubSubType newInstance()
   {
      return new DiagnosticArrayPubSubType();
   }
}

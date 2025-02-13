package visualization_msgs.msg.dds;

/**
* 
* Topic data type of the struct "InteractiveMarkerInit" defined in "InteractiveMarkerInit_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from InteractiveMarkerInit_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit InteractiveMarkerInit_.idl instead.
*
*/
public class InteractiveMarkerInitPubSubType implements us.ihmc.pubsub.TopicDataType<visualization_msgs.msg.dds.InteractiveMarkerInit>
{
   public static final java.lang.String name = "visualization_msgs::msg::dds_::InteractiveMarkerInit_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "0a93a184965d6aa56f1470715dd1a1a8ceec5e8a10ec0b1d3634062979e6b806";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(visualization_msgs.msg.dds.InteractiveMarkerInit data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, visualization_msgs.msg.dds.InteractiveMarkerInit data) throws java.io.IOException
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
      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 100; ++i0)
      {
          current_alignment += visualization_msgs.msg.dds.InteractiveMarkerPubSubType.getMaxCdrSerializedSize(current_alignment);}

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(visualization_msgs.msg.dds.InteractiveMarkerInit data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(visualization_msgs.msg.dds.InteractiveMarkerInit data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getServerId().length() + 1;

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getMarkers().size(); ++i0)
      {
          current_alignment += visualization_msgs.msg.dds.InteractiveMarkerPubSubType.getCdrSerializedSize(data.getMarkers().get(i0), current_alignment);}


      return current_alignment - initial_alignment;
   }

   public static void write(visualization_msgs.msg.dds.InteractiveMarkerInit data, us.ihmc.idl.CDR cdr)
   {
      if(data.getServerId().length() <= 255)
      cdr.write_type_d(data.getServerId());else
          throw new RuntimeException("server_id field exceeds the maximum length: %d > %d".formatted(data.getServerId().length(), 255));

      cdr.write_type_12(data.getSeqNum());

      if(data.getMarkers().size() <= 100)
      cdr.write_type_e(data.getMarkers());else
          throw new RuntimeException("markers field exceeds the maximum length: %d > %d".formatted(data.getMarkers().size(), 100));

   }

   public static void read(visualization_msgs.msg.dds.InteractiveMarkerInit data, us.ihmc.idl.CDR cdr)
   {
      cdr.read_type_d(data.getServerId());	
      data.setSeqNum(cdr.read_type_12());
      	
      cdr.read_type_e(data.getMarkers());	

   }

   @Override
   public final void serialize(visualization_msgs.msg.dds.InteractiveMarkerInit data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_d("server_id", data.getServerId());
      ser.write_type_12("seq_num", data.getSeqNum());
      ser.write_type_e("markers", data.getMarkers());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, visualization_msgs.msg.dds.InteractiveMarkerInit data)
   {
      ser.read_type_d("server_id", data.getServerId());
      data.setSeqNum(ser.read_type_12("seq_num"));
      ser.read_type_e("markers", data.getMarkers());
   }

   public static void staticCopy(visualization_msgs.msg.dds.InteractiveMarkerInit src, visualization_msgs.msg.dds.InteractiveMarkerInit dest)
   {
      dest.set(src);
   }

   @Override
   public visualization_msgs.msg.dds.InteractiveMarkerInit createData()
   {
      return new visualization_msgs.msg.dds.InteractiveMarkerInit();
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
   
   public void serialize(visualization_msgs.msg.dds.InteractiveMarkerInit data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(visualization_msgs.msg.dds.InteractiveMarkerInit data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(visualization_msgs.msg.dds.InteractiveMarkerInit src, visualization_msgs.msg.dds.InteractiveMarkerInit dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public InteractiveMarkerInitPubSubType newInstance()
   {
      return new InteractiveMarkerInitPubSubType();
   }
}

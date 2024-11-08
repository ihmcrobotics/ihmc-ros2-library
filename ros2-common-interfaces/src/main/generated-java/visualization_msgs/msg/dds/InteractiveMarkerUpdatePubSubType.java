package visualization_msgs.msg.dds;

/**
* 
* Topic data type of the struct "InteractiveMarkerUpdate" defined in "InteractiveMarkerUpdate_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from InteractiveMarkerUpdate_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit InteractiveMarkerUpdate_.idl instead.
*
*/
public class InteractiveMarkerUpdatePubSubType implements us.ihmc.pubsub.TopicDataType<visualization_msgs.msg.dds.InteractiveMarkerUpdate>
{
   public static final java.lang.String name = "visualization_msgs::msg::dds_::InteractiveMarkerUpdate_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "6a38d92e63b502c8dcbeec2686cb708ebb9a124c4d2a5797ddcc892275ca15e9";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(visualization_msgs.msg.dds.InteractiveMarkerUpdate data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, visualization_msgs.msg.dds.InteractiveMarkerUpdate data) throws java.io.IOException
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

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 100; ++i0)
      {
          current_alignment += visualization_msgs.msg.dds.InteractiveMarkerPubSubType.getMaxCdrSerializedSize(current_alignment);}
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 100; ++i0)
      {
          current_alignment += visualization_msgs.msg.dds.InteractiveMarkerPosePubSubType.getMaxCdrSerializedSize(current_alignment);}
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 100; ++i0)
      {
        current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;
      }

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(visualization_msgs.msg.dds.InteractiveMarkerUpdate data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(visualization_msgs.msg.dds.InteractiveMarkerUpdate data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getServerId().length() + 1;

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getMarkers().size(); ++i0)
      {
          current_alignment += visualization_msgs.msg.dds.InteractiveMarkerPubSubType.getCdrSerializedSize(data.getMarkers().get(i0), current_alignment);}

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getPoses().size(); ++i0)
      {
          current_alignment += visualization_msgs.msg.dds.InteractiveMarkerPosePubSubType.getCdrSerializedSize(data.getPoses().get(i0), current_alignment);}

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getErases().size(); ++i0)
      {
          current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getErases().get(i0).length() + 1;
      }

      return current_alignment - initial_alignment;
   }

   public static void write(visualization_msgs.msg.dds.InteractiveMarkerUpdate data, us.ihmc.idl.CDR cdr)
   {
      if(data.getServerId().length() <= 255)
      cdr.write_type_d(data.getServerId());else
          throw new RuntimeException("server_id field exceeds the maximum length");

      cdr.write_type_12(data.getSeqNum());

      cdr.write_type_9(data.getType());

      if(data.getMarkers().size() <= 100)
      cdr.write_type_e(data.getMarkers());else
          throw new RuntimeException("markers field exceeds the maximum length");

      if(data.getPoses().size() <= 100)
      cdr.write_type_e(data.getPoses());else
          throw new RuntimeException("poses field exceeds the maximum length");

      if(data.getErases().size() <= 100)
      cdr.write_type_e(data.getErases());else
          throw new RuntimeException("erases field exceeds the maximum length");

   }

   public static void read(visualization_msgs.msg.dds.InteractiveMarkerUpdate data, us.ihmc.idl.CDR cdr)
   {
      cdr.read_type_d(data.getServerId());	
      data.setSeqNum(cdr.read_type_12());
      	
      data.setType(cdr.read_type_9());
      	
      cdr.read_type_e(data.getMarkers());	
      cdr.read_type_e(data.getPoses());	
      cdr.read_type_e(data.getErases());	

   }

   @Override
   public final void serialize(visualization_msgs.msg.dds.InteractiveMarkerUpdate data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_d("server_id", data.getServerId());
      ser.write_type_12("seq_num", data.getSeqNum());
      ser.write_type_9("type", data.getType());
      ser.write_type_e("markers", data.getMarkers());
      ser.write_type_e("poses", data.getPoses());
      ser.write_type_e("erases", data.getErases());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, visualization_msgs.msg.dds.InteractiveMarkerUpdate data)
   {
      ser.read_type_d("server_id", data.getServerId());
      data.setSeqNum(ser.read_type_12("seq_num"));
      data.setType(ser.read_type_9("type"));
      ser.read_type_e("markers", data.getMarkers());
      ser.read_type_e("poses", data.getPoses());
      ser.read_type_e("erases", data.getErases());
   }

   public static void staticCopy(visualization_msgs.msg.dds.InteractiveMarkerUpdate src, visualization_msgs.msg.dds.InteractiveMarkerUpdate dest)
   {
      dest.set(src);
   }

   @Override
   public visualization_msgs.msg.dds.InteractiveMarkerUpdate createData()
   {
      return new visualization_msgs.msg.dds.InteractiveMarkerUpdate();
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
   
   public void serialize(visualization_msgs.msg.dds.InteractiveMarkerUpdate data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(visualization_msgs.msg.dds.InteractiveMarkerUpdate data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(visualization_msgs.msg.dds.InteractiveMarkerUpdate src, visualization_msgs.msg.dds.InteractiveMarkerUpdate dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public InteractiveMarkerUpdatePubSubType newInstance()
   {
      return new InteractiveMarkerUpdatePubSubType();
   }
}

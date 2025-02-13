package visualization_msgs.msg.dds;

/**
* 
* Topic data type of the struct "InteractiveMarkerFeedback" defined in "InteractiveMarkerFeedback_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from InteractiveMarkerFeedback_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit InteractiveMarkerFeedback_.idl instead.
*
*/
public class InteractiveMarkerFeedbackPubSubType implements us.ihmc.pubsub.TopicDataType<visualization_msgs.msg.dds.InteractiveMarkerFeedback>
{
   public static final java.lang.String name = "visualization_msgs::msg::dds_::InteractiveMarkerFeedback_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "5b828600580ce52a7fee51bb12ad4fba44321bae26432779f19d747b3f4a6ca9";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(visualization_msgs.msg.dds.InteractiveMarkerFeedback data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, visualization_msgs.msg.dds.InteractiveMarkerFeedback data) throws java.io.IOException
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

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;
      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += geometry_msgs.msg.dds.PosePubSubType.getMaxCdrSerializedSize(current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += geometry_msgs.msg.dds.PointPubSubType.getMaxCdrSerializedSize(current_alignment);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(visualization_msgs.msg.dds.InteractiveMarkerFeedback data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(visualization_msgs.msg.dds.InteractiveMarkerFeedback data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += std_msgs.msg.dds.HeaderPubSubType.getCdrSerializedSize(data.getHeader(), current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getClientId().length() + 1;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getMarkerName().length() + 1;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getControlName().length() + 1;

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += geometry_msgs.msg.dds.PosePubSubType.getCdrSerializedSize(data.getPose(), current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += geometry_msgs.msg.dds.PointPubSubType.getCdrSerializedSize(data.getMousePoint(), current_alignment);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);



      return current_alignment - initial_alignment;
   }

   public static void write(visualization_msgs.msg.dds.InteractiveMarkerFeedback data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.write(data.getHeader(), cdr);
      if(data.getClientId().length() <= 255)
      cdr.write_type_d(data.getClientId());else
          throw new RuntimeException("client_id field exceeds the maximum length: %d > %d".formatted(data.getClientId().length(), 255));

      if(data.getMarkerName().length() <= 255)
      cdr.write_type_d(data.getMarkerName());else
          throw new RuntimeException("marker_name field exceeds the maximum length: %d > %d".formatted(data.getMarkerName().length(), 255));

      if(data.getControlName().length() <= 255)
      cdr.write_type_d(data.getControlName());else
          throw new RuntimeException("control_name field exceeds the maximum length: %d > %d".formatted(data.getControlName().length(), 255));

      cdr.write_type_9(data.getEventType());

      geometry_msgs.msg.dds.PosePubSubType.write(data.getPose(), cdr);
      cdr.write_type_4(data.getMenuEntryId());

      geometry_msgs.msg.dds.PointPubSubType.write(data.getMousePoint(), cdr);
      cdr.write_type_7(data.getMousePointValid());

   }

   public static void read(visualization_msgs.msg.dds.InteractiveMarkerFeedback data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.read(data.getHeader(), cdr);	
      cdr.read_type_d(data.getClientId());	
      cdr.read_type_d(data.getMarkerName());	
      cdr.read_type_d(data.getControlName());	
      data.setEventType(cdr.read_type_9());
      	
      geometry_msgs.msg.dds.PosePubSubType.read(data.getPose(), cdr);	
      data.setMenuEntryId(cdr.read_type_4());
      	
      geometry_msgs.msg.dds.PointPubSubType.read(data.getMousePoint(), cdr);	
      data.setMousePointValid(cdr.read_type_7());
      	

   }

   @Override
   public final void serialize(visualization_msgs.msg.dds.InteractiveMarkerFeedback data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.write_type_d("client_id", data.getClientId());
      ser.write_type_d("marker_name", data.getMarkerName());
      ser.write_type_d("control_name", data.getControlName());
      ser.write_type_9("event_type", data.getEventType());
      ser.write_type_a("pose", new geometry_msgs.msg.dds.PosePubSubType(), data.getPose());

      ser.write_type_4("menu_entry_id", data.getMenuEntryId());
      ser.write_type_a("mouse_point", new geometry_msgs.msg.dds.PointPubSubType(), data.getMousePoint());

      ser.write_type_7("mouse_point_valid", data.getMousePointValid());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, visualization_msgs.msg.dds.InteractiveMarkerFeedback data)
   {
      ser.read_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.read_type_d("client_id", data.getClientId());
      ser.read_type_d("marker_name", data.getMarkerName());
      ser.read_type_d("control_name", data.getControlName());
      data.setEventType(ser.read_type_9("event_type"));
      ser.read_type_a("pose", new geometry_msgs.msg.dds.PosePubSubType(), data.getPose());

      data.setMenuEntryId(ser.read_type_4("menu_entry_id"));
      ser.read_type_a("mouse_point", new geometry_msgs.msg.dds.PointPubSubType(), data.getMousePoint());

      data.setMousePointValid(ser.read_type_7("mouse_point_valid"));
   }

   public static void staticCopy(visualization_msgs.msg.dds.InteractiveMarkerFeedback src, visualization_msgs.msg.dds.InteractiveMarkerFeedback dest)
   {
      dest.set(src);
   }

   @Override
   public visualization_msgs.msg.dds.InteractiveMarkerFeedback createData()
   {
      return new visualization_msgs.msg.dds.InteractiveMarkerFeedback();
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
   
   public void serialize(visualization_msgs.msg.dds.InteractiveMarkerFeedback data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(visualization_msgs.msg.dds.InteractiveMarkerFeedback data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(visualization_msgs.msg.dds.InteractiveMarkerFeedback src, visualization_msgs.msg.dds.InteractiveMarkerFeedback dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public InteractiveMarkerFeedbackPubSubType newInstance()
   {
      return new InteractiveMarkerFeedbackPubSubType();
   }
}

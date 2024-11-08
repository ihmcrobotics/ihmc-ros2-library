package visualization_msgs.msg.dds;

/**
* 
* Topic data type of the struct "InteractiveMarkerControl" defined in "InteractiveMarkerControl_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from InteractiveMarkerControl_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit InteractiveMarkerControl_.idl instead.
*
*/
public class InteractiveMarkerControlPubSubType implements us.ihmc.pubsub.TopicDataType<visualization_msgs.msg.dds.InteractiveMarkerControl>
{
   public static final java.lang.String name = "visualization_msgs::msg::dds_::InteractiveMarkerControl_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "021b6b1574d8f083fbec6fc01f909acc0610db60b4ce35a8e2de8e6d8b739020";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(visualization_msgs.msg.dds.InteractiveMarkerControl data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, visualization_msgs.msg.dds.InteractiveMarkerControl data) throws java.io.IOException
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
      current_alignment += geometry_msgs.msg.dds.QuaternionPubSubType.getMaxCdrSerializedSize(current_alignment);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 100; ++i0)
      {
          current_alignment += visualization_msgs.msg.dds.MarkerPubSubType.getMaxCdrSerializedSize(current_alignment);}
      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(visualization_msgs.msg.dds.InteractiveMarkerControl data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(visualization_msgs.msg.dds.InteractiveMarkerControl data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getName().length() + 1;

      current_alignment += geometry_msgs.msg.dds.QuaternionPubSubType.getCdrSerializedSize(data.getOrientation(), current_alignment);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getMarkers().size(); ++i0)
      {
          current_alignment += visualization_msgs.msg.dds.MarkerPubSubType.getCdrSerializedSize(data.getMarkers().get(i0), current_alignment);}

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getDescription().length() + 1;


      return current_alignment - initial_alignment;
   }

   public static void write(visualization_msgs.msg.dds.InteractiveMarkerControl data, us.ihmc.idl.CDR cdr)
   {
      if(data.getName().length() <= 255)
      cdr.write_type_d(data.getName());else
          throw new RuntimeException("name field exceeds the maximum length");

      geometry_msgs.msg.dds.QuaternionPubSubType.write(data.getOrientation(), cdr);
      cdr.write_type_9(data.getOrientationMode());

      cdr.write_type_9(data.getInteractionMode());

      cdr.write_type_7(data.getAlwaysVisible());

      if(data.getMarkers().size() <= 100)
      cdr.write_type_e(data.getMarkers());else
          throw new RuntimeException("markers field exceeds the maximum length");

      cdr.write_type_7(data.getIndependentMarkerOrientation());

      if(data.getDescription().length() <= 255)
      cdr.write_type_d(data.getDescription());else
          throw new RuntimeException("description field exceeds the maximum length");

   }

   public static void read(visualization_msgs.msg.dds.InteractiveMarkerControl data, us.ihmc.idl.CDR cdr)
   {
      cdr.read_type_d(data.getName());	
      geometry_msgs.msg.dds.QuaternionPubSubType.read(data.getOrientation(), cdr);	
      data.setOrientationMode(cdr.read_type_9());
      	
      data.setInteractionMode(cdr.read_type_9());
      	
      data.setAlwaysVisible(cdr.read_type_7());
      	
      cdr.read_type_e(data.getMarkers());	
      data.setIndependentMarkerOrientation(cdr.read_type_7());
      	
      cdr.read_type_d(data.getDescription());	

   }

   @Override
   public final void serialize(visualization_msgs.msg.dds.InteractiveMarkerControl data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_d("name", data.getName());
      ser.write_type_a("orientation", new geometry_msgs.msg.dds.QuaternionPubSubType(), data.getOrientation());

      ser.write_type_9("orientation_mode", data.getOrientationMode());
      ser.write_type_9("interaction_mode", data.getInteractionMode());
      ser.write_type_7("always_visible", data.getAlwaysVisible());
      ser.write_type_e("markers", data.getMarkers());
      ser.write_type_7("independent_marker_orientation", data.getIndependentMarkerOrientation());
      ser.write_type_d("description", data.getDescription());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, visualization_msgs.msg.dds.InteractiveMarkerControl data)
   {
      ser.read_type_d("name", data.getName());
      ser.read_type_a("orientation", new geometry_msgs.msg.dds.QuaternionPubSubType(), data.getOrientation());

      data.setOrientationMode(ser.read_type_9("orientation_mode"));
      data.setInteractionMode(ser.read_type_9("interaction_mode"));
      data.setAlwaysVisible(ser.read_type_7("always_visible"));
      ser.read_type_e("markers", data.getMarkers());
      data.setIndependentMarkerOrientation(ser.read_type_7("independent_marker_orientation"));
      ser.read_type_d("description", data.getDescription());
   }

   public static void staticCopy(visualization_msgs.msg.dds.InteractiveMarkerControl src, visualization_msgs.msg.dds.InteractiveMarkerControl dest)
   {
      dest.set(src);
   }

   @Override
   public visualization_msgs.msg.dds.InteractiveMarkerControl createData()
   {
      return new visualization_msgs.msg.dds.InteractiveMarkerControl();
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
   
   public void serialize(visualization_msgs.msg.dds.InteractiveMarkerControl data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(visualization_msgs.msg.dds.InteractiveMarkerControl data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(visualization_msgs.msg.dds.InteractiveMarkerControl src, visualization_msgs.msg.dds.InteractiveMarkerControl dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public InteractiveMarkerControlPubSubType newInstance()
   {
      return new InteractiveMarkerControlPubSubType();
   }
}

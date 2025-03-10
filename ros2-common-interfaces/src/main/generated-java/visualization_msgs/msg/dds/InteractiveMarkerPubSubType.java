package visualization_msgs.msg.dds;

/**
* 
* Topic data type of the struct "InteractiveMarker" defined in "InteractiveMarker_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from InteractiveMarker_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit InteractiveMarker_.idl instead.
*
*/
public class InteractiveMarkerPubSubType implements us.ihmc.pubsub.TopicDataType<visualization_msgs.msg.dds.InteractiveMarker>
{
   public static final java.lang.String name = "visualization_msgs::msg::dds_::InteractiveMarker_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "e6dae6521c0d09978fed4ab3b17714a5b118f6232a0319a47ce57ae78eaf7318";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(visualization_msgs.msg.dds.InteractiveMarker data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, visualization_msgs.msg.dds.InteractiveMarker data) throws java.io.IOException
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

      current_alignment += geometry_msgs.msg.dds.PosePubSubType.getMaxCdrSerializedSize(current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 100; ++i0)
      {
          current_alignment += visualization_msgs.msg.dds.MenuEntryPubSubType.getMaxCdrSerializedSize(current_alignment);}
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 100; ++i0)
      {
          current_alignment += visualization_msgs.msg.dds.InteractiveMarkerControlPubSubType.getMaxCdrSerializedSize(current_alignment);}

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(visualization_msgs.msg.dds.InteractiveMarker data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(visualization_msgs.msg.dds.InteractiveMarker data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += std_msgs.msg.dds.HeaderPubSubType.getCdrSerializedSize(data.getHeader(), current_alignment);

      current_alignment += geometry_msgs.msg.dds.PosePubSubType.getCdrSerializedSize(data.getPose(), current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getName().length() + 1;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getDescription().length() + 1;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getMenuEntries().size(); ++i0)
      {
          current_alignment += visualization_msgs.msg.dds.MenuEntryPubSubType.getCdrSerializedSize(data.getMenuEntries().get(i0), current_alignment);}

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getControls().size(); ++i0)
      {
          current_alignment += visualization_msgs.msg.dds.InteractiveMarkerControlPubSubType.getCdrSerializedSize(data.getControls().get(i0), current_alignment);}


      return current_alignment - initial_alignment;
   }

   public static void write(visualization_msgs.msg.dds.InteractiveMarker data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.write(data.getHeader(), cdr);
      geometry_msgs.msg.dds.PosePubSubType.write(data.getPose(), cdr);
      if(data.getName().length() <= 255)
      cdr.write_type_d(data.getName());else
          throw new RuntimeException("name field exceeds the maximum length: %d > %d".formatted(data.getName().length(), 255));

      if(data.getDescription().length() <= 255)
      cdr.write_type_d(data.getDescription());else
          throw new RuntimeException("description field exceeds the maximum length: %d > %d".formatted(data.getDescription().length(), 255));

      cdr.write_type_5(data.getScale());

      if(data.getMenuEntries().size() <= 100)
      cdr.write_type_e(data.getMenuEntries());else
          throw new RuntimeException("menu_entries field exceeds the maximum length: %d > %d".formatted(data.getMenuEntries().size(), 100));

      if(data.getControls().size() <= 100)
      cdr.write_type_e(data.getControls());else
          throw new RuntimeException("controls field exceeds the maximum length: %d > %d".formatted(data.getControls().size(), 100));

   }

   public static void read(visualization_msgs.msg.dds.InteractiveMarker data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.read(data.getHeader(), cdr);	
      geometry_msgs.msg.dds.PosePubSubType.read(data.getPose(), cdr);	
      cdr.read_type_d(data.getName());	
      cdr.read_type_d(data.getDescription());	
      data.setScale(cdr.read_type_5());
      	
      cdr.read_type_e(data.getMenuEntries());	
      cdr.read_type_e(data.getControls());	

   }

   @Override
   public final void serialize(visualization_msgs.msg.dds.InteractiveMarker data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.write_type_a("pose", new geometry_msgs.msg.dds.PosePubSubType(), data.getPose());

      ser.write_type_d("name", data.getName());
      ser.write_type_d("description", data.getDescription());
      ser.write_type_5("scale", data.getScale());
      ser.write_type_e("menu_entries", data.getMenuEntries());
      ser.write_type_e("controls", data.getControls());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, visualization_msgs.msg.dds.InteractiveMarker data)
   {
      ser.read_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.read_type_a("pose", new geometry_msgs.msg.dds.PosePubSubType(), data.getPose());

      ser.read_type_d("name", data.getName());
      ser.read_type_d("description", data.getDescription());
      data.setScale(ser.read_type_5("scale"));
      ser.read_type_e("menu_entries", data.getMenuEntries());
      ser.read_type_e("controls", data.getControls());
   }

   public static void staticCopy(visualization_msgs.msg.dds.InteractiveMarker src, visualization_msgs.msg.dds.InteractiveMarker dest)
   {
      dest.set(src);
   }

   @Override
   public visualization_msgs.msg.dds.InteractiveMarker createData()
   {
      return new visualization_msgs.msg.dds.InteractiveMarker();
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
   
   public void serialize(visualization_msgs.msg.dds.InteractiveMarker data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(visualization_msgs.msg.dds.InteractiveMarker data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(visualization_msgs.msg.dds.InteractiveMarker src, visualization_msgs.msg.dds.InteractiveMarker dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public InteractiveMarkerPubSubType newInstance()
   {
      return new InteractiveMarkerPubSubType();
   }
}

package visualization_msgs.msg.dds;

/**
* 
* Topic data type of the struct "MenuEntry" defined in "MenuEntry_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from MenuEntry_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit MenuEntry_.idl instead.
*
*/
public class MenuEntryPubSubType implements us.ihmc.pubsub.TopicDataType<visualization_msgs.msg.dds.MenuEntry>
{
   public static final java.lang.String name = "visualization_msgs::msg::dds_::MenuEntry_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "f229b3f1e7bd669e1d6017455255418690162cca9c46e6a078ba366ac4086e41";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(visualization_msgs.msg.dds.MenuEntry data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, visualization_msgs.msg.dds.MenuEntry data) throws java.io.IOException
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

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;
      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(visualization_msgs.msg.dds.MenuEntry data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(visualization_msgs.msg.dds.MenuEntry data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getTitle().length() + 1;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getCommand().length() + 1;

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);



      return current_alignment - initial_alignment;
   }

   public static void write(visualization_msgs.msg.dds.MenuEntry data, us.ihmc.idl.CDR cdr)
   {
      cdr.write_type_4(data.getId());

      cdr.write_type_4(data.getParentId());

      if(data.getTitle().length() <= 255)
      cdr.write_type_d(data.getTitle());else
          throw new RuntimeException("title field exceeds the maximum length: %d > %d".formatted(data.getTitle().length(), 255));

      if(data.getCommand().length() <= 255)
      cdr.write_type_d(data.getCommand());else
          throw new RuntimeException("command field exceeds the maximum length: %d > %d".formatted(data.getCommand().length(), 255));

      cdr.write_type_9(data.getCommandType());

   }

   public static void read(visualization_msgs.msg.dds.MenuEntry data, us.ihmc.idl.CDR cdr)
   {
      data.setId(cdr.read_type_4());
      	
      data.setParentId(cdr.read_type_4());
      	
      cdr.read_type_d(data.getTitle());	
      cdr.read_type_d(data.getCommand());	
      data.setCommandType(cdr.read_type_9());
      	

   }

   @Override
   public final void serialize(visualization_msgs.msg.dds.MenuEntry data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_4("id", data.getId());
      ser.write_type_4("parent_id", data.getParentId());
      ser.write_type_d("title", data.getTitle());
      ser.write_type_d("command", data.getCommand());
      ser.write_type_9("command_type", data.getCommandType());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, visualization_msgs.msg.dds.MenuEntry data)
   {
      data.setId(ser.read_type_4("id"));
      data.setParentId(ser.read_type_4("parent_id"));
      ser.read_type_d("title", data.getTitle());
      ser.read_type_d("command", data.getCommand());
      data.setCommandType(ser.read_type_9("command_type"));
   }

   public static void staticCopy(visualization_msgs.msg.dds.MenuEntry src, visualization_msgs.msg.dds.MenuEntry dest)
   {
      dest.set(src);
   }

   @Override
   public visualization_msgs.msg.dds.MenuEntry createData()
   {
      return new visualization_msgs.msg.dds.MenuEntry();
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
   
   public void serialize(visualization_msgs.msg.dds.MenuEntry data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(visualization_msgs.msg.dds.MenuEntry data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(visualization_msgs.msg.dds.MenuEntry src, visualization_msgs.msg.dds.MenuEntry dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public MenuEntryPubSubType newInstance()
   {
      return new MenuEntryPubSubType();
   }
}

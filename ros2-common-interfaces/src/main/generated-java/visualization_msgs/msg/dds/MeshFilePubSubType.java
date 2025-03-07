package visualization_msgs.msg.dds;

/**
* 
* Topic data type of the struct "MeshFile" defined in "MeshFile_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from MeshFile_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit MeshFile_.idl instead.
*
*/
public class MeshFilePubSubType implements us.ihmc.pubsub.TopicDataType<visualization_msgs.msg.dds.MeshFile>
{
   public static final java.lang.String name = "visualization_msgs::msg::dds_::MeshFile_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "c19edefe9add18099ae26999a09ff7aae73e22be4a29438a74864b166ade8459";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(visualization_msgs.msg.dds.MeshFile data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, visualization_msgs.msg.dds.MeshFile data) throws java.io.IOException
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
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);current_alignment += (100 * 1) + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(visualization_msgs.msg.dds.MeshFile data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(visualization_msgs.msg.dds.MeshFile data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getFilename().length() + 1;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (data.getData().size() * 1) + us.ihmc.idl.CDR.alignment(current_alignment, 1);



      return current_alignment - initial_alignment;
   }

   public static void write(visualization_msgs.msg.dds.MeshFile data, us.ihmc.idl.CDR cdr)
   {
      if(data.getFilename().length() <= 255)
      cdr.write_type_d(data.getFilename());else
          throw new RuntimeException("filename field exceeds the maximum length: %d > %d".formatted(data.getFilename().length(), 255));

      if(data.getData().size() <= 100)
      cdr.write_type_e(data.getData());else
          throw new RuntimeException("data field exceeds the maximum length: %d > %d".formatted(data.getData().size(), 100));

   }

   public static void read(visualization_msgs.msg.dds.MeshFile data, us.ihmc.idl.CDR cdr)
   {
      cdr.read_type_d(data.getFilename());	
      cdr.read_type_e(data.getData());	

   }

   @Override
   public final void serialize(visualization_msgs.msg.dds.MeshFile data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_d("filename", data.getFilename());
      ser.write_type_e("data", data.getData());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, visualization_msgs.msg.dds.MeshFile data)
   {
      ser.read_type_d("filename", data.getFilename());
      ser.read_type_e("data", data.getData());
   }

   public static void staticCopy(visualization_msgs.msg.dds.MeshFile src, visualization_msgs.msg.dds.MeshFile dest)
   {
      dest.set(src);
   }

   @Override
   public visualization_msgs.msg.dds.MeshFile createData()
   {
      return new visualization_msgs.msg.dds.MeshFile();
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
   
   public void serialize(visualization_msgs.msg.dds.MeshFile data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(visualization_msgs.msg.dds.MeshFile data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(visualization_msgs.msg.dds.MeshFile src, visualization_msgs.msg.dds.MeshFile dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public MeshFilePubSubType newInstance()
   {
      return new MeshFilePubSubType();
   }
}

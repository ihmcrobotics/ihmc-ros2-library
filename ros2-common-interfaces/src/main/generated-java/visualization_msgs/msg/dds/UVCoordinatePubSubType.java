package visualization_msgs.msg.dds;

/**
* 
* Topic data type of the struct "UVCoordinate" defined in "UVCoordinate_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from UVCoordinate_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit UVCoordinate_.idl instead.
*
*/
public class UVCoordinatePubSubType implements us.ihmc.pubsub.TopicDataType<visualization_msgs.msg.dds.UVCoordinate>
{
   public static final java.lang.String name = "visualization_msgs::msg::dds_::UVCoordinate_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "a4c97065a0e07b039ee957882d0d70f0b4dbc345a06c3cc220a6416d20a85d88";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(visualization_msgs.msg.dds.UVCoordinate data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, visualization_msgs.msg.dds.UVCoordinate data) throws java.io.IOException
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


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(visualization_msgs.msg.dds.UVCoordinate data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(visualization_msgs.msg.dds.UVCoordinate data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);



      return current_alignment - initial_alignment;
   }

   public static void write(visualization_msgs.msg.dds.UVCoordinate data, us.ihmc.idl.CDR cdr)
   {
      cdr.write_type_5(data.getU());

      cdr.write_type_5(data.getV());

   }

   public static void read(visualization_msgs.msg.dds.UVCoordinate data, us.ihmc.idl.CDR cdr)
   {
      data.setU(cdr.read_type_5());
      	
      data.setV(cdr.read_type_5());
      	

   }

   @Override
   public final void serialize(visualization_msgs.msg.dds.UVCoordinate data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_5("u", data.getU());
      ser.write_type_5("v", data.getV());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, visualization_msgs.msg.dds.UVCoordinate data)
   {
      data.setU(ser.read_type_5("u"));
      data.setV(ser.read_type_5("v"));
   }

   public static void staticCopy(visualization_msgs.msg.dds.UVCoordinate src, visualization_msgs.msg.dds.UVCoordinate dest)
   {
      dest.set(src);
   }

   @Override
   public visualization_msgs.msg.dds.UVCoordinate createData()
   {
      return new visualization_msgs.msg.dds.UVCoordinate();
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
   
   public void serialize(visualization_msgs.msg.dds.UVCoordinate data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(visualization_msgs.msg.dds.UVCoordinate data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(visualization_msgs.msg.dds.UVCoordinate src, visualization_msgs.msg.dds.UVCoordinate dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public UVCoordinatePubSubType newInstance()
   {
      return new UVCoordinatePubSubType();
   }
}

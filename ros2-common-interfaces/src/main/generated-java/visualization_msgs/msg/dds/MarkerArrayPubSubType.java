package visualization_msgs.msg.dds;

/**
* 
* Topic data type of the struct "MarkerArray" defined in "MarkerArray_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from MarkerArray_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit MarkerArray_.idl instead.
*
*/
public class MarkerArrayPubSubType implements us.ihmc.pubsub.TopicDataType<visualization_msgs.msg.dds.MarkerArray>
{
   public static final java.lang.String name = "visualization_msgs::msg::dds_::MarkerArray_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "ef63c65484e016876f310352f24abd117701415179cddcea2073a772c29be6f8";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(visualization_msgs.msg.dds.MarkerArray data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, visualization_msgs.msg.dds.MarkerArray data) throws java.io.IOException
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
          current_alignment += visualization_msgs.msg.dds.MarkerPubSubType.getMaxCdrSerializedSize(current_alignment);}
      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(visualization_msgs.msg.dds.MarkerArray data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(visualization_msgs.msg.dds.MarkerArray data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getMarkers().size(); ++i0)
      {
          current_alignment += visualization_msgs.msg.dds.MarkerPubSubType.getCdrSerializedSize(data.getMarkers().get(i0), current_alignment);}

      return current_alignment - initial_alignment;
   }

   public static void write(visualization_msgs.msg.dds.MarkerArray data, us.ihmc.idl.CDR cdr)
   {
      if(data.getMarkers().size() <= 100)
      cdr.write_type_e(data.getMarkers());else
          throw new RuntimeException("markers field exceeds the maximum length");

   }

   public static void read(visualization_msgs.msg.dds.MarkerArray data, us.ihmc.idl.CDR cdr)
   {
      cdr.read_type_e(data.getMarkers());	

   }

   @Override
   public final void serialize(visualization_msgs.msg.dds.MarkerArray data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_e("markers", data.getMarkers());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, visualization_msgs.msg.dds.MarkerArray data)
   {
      ser.read_type_e("markers", data.getMarkers());
   }

   public static void staticCopy(visualization_msgs.msg.dds.MarkerArray src, visualization_msgs.msg.dds.MarkerArray dest)
   {
      dest.set(src);
   }

   @Override
   public visualization_msgs.msg.dds.MarkerArray createData()
   {
      return new visualization_msgs.msg.dds.MarkerArray();
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
   
   public void serialize(visualization_msgs.msg.dds.MarkerArray data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(visualization_msgs.msg.dds.MarkerArray data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(visualization_msgs.msg.dds.MarkerArray src, visualization_msgs.msg.dds.MarkerArray dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public MarkerArrayPubSubType newInstance()
   {
      return new MarkerArrayPubSubType();
   }
}

package sensor_msgs.msg.dds;

/**
* 
* Topic data type of the struct "Joy" defined in "Joy_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from Joy_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit Joy_.idl instead.
*
*/
public class JoyPubSubType implements us.ihmc.pubsub.TopicDataType<sensor_msgs.msg.dds.Joy>
{
   public static final java.lang.String name = "sensor_msgs::msg::dds_::Joy_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "e0809bcc443158474accef9eb0fb3e49650b95119a2ebce69b779ae680892b2f";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(sensor_msgs.msg.dds.Joy data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, sensor_msgs.msg.dds.Joy data) throws java.io.IOException
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

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);current_alignment += (100 * 4) + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);current_alignment += (100 * 4) + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(sensor_msgs.msg.dds.Joy data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(sensor_msgs.msg.dds.Joy data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += std_msgs.msg.dds.HeaderPubSubType.getCdrSerializedSize(data.getHeader(), current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (data.getAxes().size() * 4) + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (data.getButtons().size() * 4) + us.ihmc.idl.CDR.alignment(current_alignment, 4);



      return current_alignment - initial_alignment;
   }

   public static void write(sensor_msgs.msg.dds.Joy data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.write(data.getHeader(), cdr);
      if(data.getAxes().size() <= 100)
      cdr.write_type_e(data.getAxes());else
          throw new RuntimeException("axes field exceeds the maximum length: %d > %d".formatted(data.getAxes().size(), 100));

      if(data.getButtons().size() <= 100)
      cdr.write_type_e(data.getButtons());else
          throw new RuntimeException("buttons field exceeds the maximum length: %d > %d".formatted(data.getButtons().size(), 100));

   }

   public static void read(sensor_msgs.msg.dds.Joy data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.read(data.getHeader(), cdr);	
      cdr.read_type_e(data.getAxes());	
      cdr.read_type_e(data.getButtons());	

   }

   @Override
   public final void serialize(sensor_msgs.msg.dds.Joy data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.write_type_e("axes", data.getAxes());
      ser.write_type_e("buttons", data.getButtons());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, sensor_msgs.msg.dds.Joy data)
   {
      ser.read_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.read_type_e("axes", data.getAxes());
      ser.read_type_e("buttons", data.getButtons());
   }

   public static void staticCopy(sensor_msgs.msg.dds.Joy src, sensor_msgs.msg.dds.Joy dest)
   {
      dest.set(src);
   }

   @Override
   public sensor_msgs.msg.dds.Joy createData()
   {
      return new sensor_msgs.msg.dds.Joy();
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
   
   public void serialize(sensor_msgs.msg.dds.Joy data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(sensor_msgs.msg.dds.Joy data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(sensor_msgs.msg.dds.Joy src, sensor_msgs.msg.dds.Joy dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public JoyPubSubType newInstance()
   {
      return new JoyPubSubType();
   }
}

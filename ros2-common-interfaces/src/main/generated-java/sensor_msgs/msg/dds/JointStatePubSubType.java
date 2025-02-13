package sensor_msgs.msg.dds;

/**
* 
* Topic data type of the struct "JointState" defined in "JointState_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from JointState_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit JointState_.idl instead.
*
*/
public class JointStatePubSubType implements us.ihmc.pubsub.TopicDataType<sensor_msgs.msg.dds.JointState>
{
   public static final java.lang.String name = "sensor_msgs::msg::dds_::JointState_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "1be855b075a6601472f9a7cece07534b179f10c38347afbb376f5920dca254f6";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(sensor_msgs.msg.dds.JointState data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, sensor_msgs.msg.dds.JointState data) throws java.io.IOException
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

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 100; ++i0)
      {
        current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;
      }
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);current_alignment += (100 * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);current_alignment += (100 * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);current_alignment += (100 * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(sensor_msgs.msg.dds.JointState data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(sensor_msgs.msg.dds.JointState data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += std_msgs.msg.dds.HeaderPubSubType.getCdrSerializedSize(data.getHeader(), current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getName().size(); ++i0)
      {
          current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getName().get(i0).length() + 1;
      }
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (data.getPosition().size() * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (data.getVelocity().size() * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (data.getEffort().size() * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);



      return current_alignment - initial_alignment;
   }

   public static void write(sensor_msgs.msg.dds.JointState data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.write(data.getHeader(), cdr);
      if(data.getName().size() <= 100)
      cdr.write_type_e(data.getName());else
          throw new RuntimeException("name field exceeds the maximum length: %d > %d".formatted(data.getName().size(), 100));

      if(data.getPosition().size() <= 100)
      cdr.write_type_e(data.getPosition());else
          throw new RuntimeException("position field exceeds the maximum length: %d > %d".formatted(data.getPosition().size(), 100));

      if(data.getVelocity().size() <= 100)
      cdr.write_type_e(data.getVelocity());else
          throw new RuntimeException("velocity field exceeds the maximum length: %d > %d".formatted(data.getVelocity().size(), 100));

      if(data.getEffort().size() <= 100)
      cdr.write_type_e(data.getEffort());else
          throw new RuntimeException("effort field exceeds the maximum length: %d > %d".formatted(data.getEffort().size(), 100));

   }

   public static void read(sensor_msgs.msg.dds.JointState data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.read(data.getHeader(), cdr);	
      cdr.read_type_e(data.getName());	
      cdr.read_type_e(data.getPosition());	
      cdr.read_type_e(data.getVelocity());	
      cdr.read_type_e(data.getEffort());	

   }

   @Override
   public final void serialize(sensor_msgs.msg.dds.JointState data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.write_type_e("name", data.getName());
      ser.write_type_e("position", data.getPosition());
      ser.write_type_e("velocity", data.getVelocity());
      ser.write_type_e("effort", data.getEffort());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, sensor_msgs.msg.dds.JointState data)
   {
      ser.read_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.read_type_e("name", data.getName());
      ser.read_type_e("position", data.getPosition());
      ser.read_type_e("velocity", data.getVelocity());
      ser.read_type_e("effort", data.getEffort());
   }

   public static void staticCopy(sensor_msgs.msg.dds.JointState src, sensor_msgs.msg.dds.JointState dest)
   {
      dest.set(src);
   }

   @Override
   public sensor_msgs.msg.dds.JointState createData()
   {
      return new sensor_msgs.msg.dds.JointState();
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
   
   public void serialize(sensor_msgs.msg.dds.JointState data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(sensor_msgs.msg.dds.JointState data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(sensor_msgs.msg.dds.JointState src, sensor_msgs.msg.dds.JointState dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public JointStatePubSubType newInstance()
   {
      return new JointStatePubSubType();
   }
}

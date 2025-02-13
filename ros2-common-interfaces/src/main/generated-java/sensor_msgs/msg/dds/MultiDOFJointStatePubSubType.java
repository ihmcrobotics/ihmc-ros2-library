package sensor_msgs.msg.dds;

/**
* 
* Topic data type of the struct "MultiDOFJointState" defined in "MultiDOFJointState_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from MultiDOFJointState_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit MultiDOFJointState_.idl instead.
*
*/
public class MultiDOFJointStatePubSubType implements us.ihmc.pubsub.TopicDataType<sensor_msgs.msg.dds.MultiDOFJointState>
{
   public static final java.lang.String name = "sensor_msgs::msg::dds_::MultiDOFJointState_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "6a977debf790321cef0c5196898a6a365f643d0982ed8139066ed1fa54590bd6";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(sensor_msgs.msg.dds.MultiDOFJointState data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, sensor_msgs.msg.dds.MultiDOFJointState data) throws java.io.IOException
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
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 100; ++i0)
      {
          current_alignment += geometry_msgs.msg.dds.TransformPubSubType.getMaxCdrSerializedSize(current_alignment);}
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 100; ++i0)
      {
          current_alignment += geometry_msgs.msg.dds.TwistPubSubType.getMaxCdrSerializedSize(current_alignment);}
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);for(int i0 = 0; i0 < 100; ++i0)
      {
          current_alignment += geometry_msgs.msg.dds.WrenchPubSubType.getMaxCdrSerializedSize(current_alignment);}

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(sensor_msgs.msg.dds.MultiDOFJointState data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(sensor_msgs.msg.dds.MultiDOFJointState data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += std_msgs.msg.dds.HeaderPubSubType.getCdrSerializedSize(data.getHeader(), current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getJointNames().size(); ++i0)
      {
          current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getJointNames().get(i0).length() + 1;
      }
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getTransforms().size(); ++i0)
      {
          current_alignment += geometry_msgs.msg.dds.TransformPubSubType.getCdrSerializedSize(data.getTransforms().get(i0), current_alignment);}

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getTwist().size(); ++i0)
      {
          current_alignment += geometry_msgs.msg.dds.TwistPubSubType.getCdrSerializedSize(data.getTwist().get(i0), current_alignment);}

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getWrench().size(); ++i0)
      {
          current_alignment += geometry_msgs.msg.dds.WrenchPubSubType.getCdrSerializedSize(data.getWrench().get(i0), current_alignment);}


      return current_alignment - initial_alignment;
   }

   public static void write(sensor_msgs.msg.dds.MultiDOFJointState data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.write(data.getHeader(), cdr);
      if(data.getJointNames().size() <= 100)
      cdr.write_type_e(data.getJointNames());else
          throw new RuntimeException("joint_names field exceeds the maximum length: %d > %d".formatted(data.getJointNames().size(), 100));

      if(data.getTransforms().size() <= 100)
      cdr.write_type_e(data.getTransforms());else
          throw new RuntimeException("transforms field exceeds the maximum length: %d > %d".formatted(data.getTransforms().size(), 100));

      if(data.getTwist().size() <= 100)
      cdr.write_type_e(data.getTwist());else
          throw new RuntimeException("twist field exceeds the maximum length: %d > %d".formatted(data.getTwist().size(), 100));

      if(data.getWrench().size() <= 100)
      cdr.write_type_e(data.getWrench());else
          throw new RuntimeException("wrench field exceeds the maximum length: %d > %d".formatted(data.getWrench().size(), 100));

   }

   public static void read(sensor_msgs.msg.dds.MultiDOFJointState data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.read(data.getHeader(), cdr);	
      cdr.read_type_e(data.getJointNames());	
      cdr.read_type_e(data.getTransforms());	
      cdr.read_type_e(data.getTwist());	
      cdr.read_type_e(data.getWrench());	

   }

   @Override
   public final void serialize(sensor_msgs.msg.dds.MultiDOFJointState data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.write_type_e("joint_names", data.getJointNames());
      ser.write_type_e("transforms", data.getTransforms());
      ser.write_type_e("twist", data.getTwist());
      ser.write_type_e("wrench", data.getWrench());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, sensor_msgs.msg.dds.MultiDOFJointState data)
   {
      ser.read_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.read_type_e("joint_names", data.getJointNames());
      ser.read_type_e("transforms", data.getTransforms());
      ser.read_type_e("twist", data.getTwist());
      ser.read_type_e("wrench", data.getWrench());
   }

   public static void staticCopy(sensor_msgs.msg.dds.MultiDOFJointState src, sensor_msgs.msg.dds.MultiDOFJointState dest)
   {
      dest.set(src);
   }

   @Override
   public sensor_msgs.msg.dds.MultiDOFJointState createData()
   {
      return new sensor_msgs.msg.dds.MultiDOFJointState();
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
   
   public void serialize(sensor_msgs.msg.dds.MultiDOFJointState data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(sensor_msgs.msg.dds.MultiDOFJointState data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(sensor_msgs.msg.dds.MultiDOFJointState src, sensor_msgs.msg.dds.MultiDOFJointState dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public MultiDOFJointStatePubSubType newInstance()
   {
      return new MultiDOFJointStatePubSubType();
   }
}

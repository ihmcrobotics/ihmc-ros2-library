package std_msgs.msg.dds;

/**
* 
* Topic data type of the struct "MultiArrayDimension" defined in "MultiArrayDimension_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from MultiArrayDimension_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit MultiArrayDimension_.idl instead.
*
*/
public class MultiArrayDimensionPubSubType implements us.ihmc.pubsub.TopicDataType<std_msgs.msg.dds.MultiArrayDimension>
{
   public static final java.lang.String name = "std_msgs::msg::dds_::MultiArrayDimension_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "09b5eb3642f1561e2013e0d820513d7d8ec420544378b1fe7a455a414d5d2a77";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(std_msgs.msg.dds.MultiArrayDimension data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, std_msgs.msg.dds.MultiArrayDimension data) throws java.io.IOException
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
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(std_msgs.msg.dds.MultiArrayDimension data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(std_msgs.msg.dds.MultiArrayDimension data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getLabel().length() + 1;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);



      return current_alignment - initial_alignment;
   }

   public static void write(std_msgs.msg.dds.MultiArrayDimension data, us.ihmc.idl.CDR cdr)
   {
      if(data.getLabel().length() <= 255)
      cdr.write_type_d(data.getLabel());else
          throw new RuntimeException("label field exceeds the maximum length: %d > %d".formatted(data.getLabel().length(), 255));

      cdr.write_type_4(data.getSize());

      cdr.write_type_4(data.getStride());

   }

   public static void read(std_msgs.msg.dds.MultiArrayDimension data, us.ihmc.idl.CDR cdr)
   {
      cdr.read_type_d(data.getLabel());	
      data.setSize(cdr.read_type_4());
      	
      data.setStride(cdr.read_type_4());
      	

   }

   @Override
   public final void serialize(std_msgs.msg.dds.MultiArrayDimension data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_d("label", data.getLabel());
      ser.write_type_4("size", data.getSize());
      ser.write_type_4("stride", data.getStride());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, std_msgs.msg.dds.MultiArrayDimension data)
   {
      ser.read_type_d("label", data.getLabel());
      data.setSize(ser.read_type_4("size"));
      data.setStride(ser.read_type_4("stride"));
   }

   public static void staticCopy(std_msgs.msg.dds.MultiArrayDimension src, std_msgs.msg.dds.MultiArrayDimension dest)
   {
      dest.set(src);
   }

   @Override
   public std_msgs.msg.dds.MultiArrayDimension createData()
   {
      return new std_msgs.msg.dds.MultiArrayDimension();
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
   
   public void serialize(std_msgs.msg.dds.MultiArrayDimension data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(std_msgs.msg.dds.MultiArrayDimension data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(std_msgs.msg.dds.MultiArrayDimension src, std_msgs.msg.dds.MultiArrayDimension dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public MultiArrayDimensionPubSubType newInstance()
   {
      return new MultiArrayDimensionPubSubType();
   }
}

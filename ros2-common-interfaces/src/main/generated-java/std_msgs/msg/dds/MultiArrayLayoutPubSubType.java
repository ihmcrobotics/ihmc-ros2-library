package std_msgs.msg.dds;

/**
* 
* Topic data type of the struct "MultiArrayLayout" defined in "MultiArrayLayout_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from MultiArrayLayout_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit MultiArrayLayout_.idl instead.
*
*/
public class MultiArrayLayoutPubSubType implements us.ihmc.pubsub.TopicDataType<std_msgs.msg.dds.MultiArrayLayout>
{
   public static final java.lang.String name = "std_msgs::msg::dds_::MultiArrayLayout_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "431004d782f6c42bf44132b9f595116177d47e669bdbeb03a7be15bdebde0ad7";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(std_msgs.msg.dds.MultiArrayLayout data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, std_msgs.msg.dds.MultiArrayLayout data) throws java.io.IOException
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
          current_alignment += std_msgs.msg.dds.MultiArrayDimensionPubSubType.getMaxCdrSerializedSize(current_alignment);}
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(std_msgs.msg.dds.MultiArrayLayout data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(std_msgs.msg.dds.MultiArrayLayout data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      for(int i0 = 0; i0 < data.getDim().size(); ++i0)
      {
          current_alignment += std_msgs.msg.dds.MultiArrayDimensionPubSubType.getCdrSerializedSize(data.getDim().get(i0), current_alignment);}

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);



      return current_alignment - initial_alignment;
   }

   public static void write(std_msgs.msg.dds.MultiArrayLayout data, us.ihmc.idl.CDR cdr)
   {
      if(data.getDim().size() <= 100)
      cdr.write_type_e(data.getDim());else
          throw new RuntimeException("dim field exceeds the maximum length: %d > %d".formatted(data.getDim().size(), 100));

      cdr.write_type_4(data.getDataOffset());

   }

   public static void read(std_msgs.msg.dds.MultiArrayLayout data, us.ihmc.idl.CDR cdr)
   {
      cdr.read_type_e(data.getDim());	
      data.setDataOffset(cdr.read_type_4());
      	

   }

   @Override
   public final void serialize(std_msgs.msg.dds.MultiArrayLayout data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_e("dim", data.getDim());
      ser.write_type_4("data_offset", data.getDataOffset());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, std_msgs.msg.dds.MultiArrayLayout data)
   {
      ser.read_type_e("dim", data.getDim());
      data.setDataOffset(ser.read_type_4("data_offset"));
   }

   public static void staticCopy(std_msgs.msg.dds.MultiArrayLayout src, std_msgs.msg.dds.MultiArrayLayout dest)
   {
      dest.set(src);
   }

   @Override
   public std_msgs.msg.dds.MultiArrayLayout createData()
   {
      return new std_msgs.msg.dds.MultiArrayLayout();
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
   
   public void serialize(std_msgs.msg.dds.MultiArrayLayout data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(std_msgs.msg.dds.MultiArrayLayout data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(std_msgs.msg.dds.MultiArrayLayout src, std_msgs.msg.dds.MultiArrayLayout dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public MultiArrayLayoutPubSubType newInstance()
   {
      return new MultiArrayLayoutPubSubType();
   }
}

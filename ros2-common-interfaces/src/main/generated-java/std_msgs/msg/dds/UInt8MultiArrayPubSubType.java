package std_msgs.msg.dds;

/**
* 
* Topic data type of the struct "UInt8MultiArray" defined in "UInt8MultiArray_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from UInt8MultiArray_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit UInt8MultiArray_.idl instead.
*
*/
public class UInt8MultiArrayPubSubType implements us.ihmc.pubsub.TopicDataType<std_msgs.msg.dds.UInt8MultiArray>
{
   public static final java.lang.String name = "std_msgs::msg::dds_::UInt8MultiArray_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "6e23a2d917ed5eed11414dc505f8510ef9eec6550d51921bf5b729fa70e263f7";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(std_msgs.msg.dds.UInt8MultiArray data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, std_msgs.msg.dds.UInt8MultiArray data) throws java.io.IOException
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

      current_alignment += std_msgs.msg.dds.MultiArrayLayoutPubSubType.getMaxCdrSerializedSize(current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);current_alignment += (100 * 1) + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(std_msgs.msg.dds.UInt8MultiArray data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(std_msgs.msg.dds.UInt8MultiArray data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += std_msgs.msg.dds.MultiArrayLayoutPubSubType.getCdrSerializedSize(data.getLayout(), current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (data.getData().size() * 1) + us.ihmc.idl.CDR.alignment(current_alignment, 1);



      return current_alignment - initial_alignment;
   }

   public static void write(std_msgs.msg.dds.UInt8MultiArray data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.MultiArrayLayoutPubSubType.write(data.getLayout(), cdr);
      if(data.getData().size() <= 100)
      cdr.write_type_e(data.getData());else
          throw new RuntimeException("data field exceeds the maximum length: %d > %d".formatted(data.getData().size(), 100));

   }

   public static void read(std_msgs.msg.dds.UInt8MultiArray data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.MultiArrayLayoutPubSubType.read(data.getLayout(), cdr);	
      cdr.read_type_e(data.getData());	

   }

   @Override
   public final void serialize(std_msgs.msg.dds.UInt8MultiArray data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("layout", new std_msgs.msg.dds.MultiArrayLayoutPubSubType(), data.getLayout());

      ser.write_type_e("data", data.getData());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, std_msgs.msg.dds.UInt8MultiArray data)
   {
      ser.read_type_a("layout", new std_msgs.msg.dds.MultiArrayLayoutPubSubType(), data.getLayout());

      ser.read_type_e("data", data.getData());
   }

   public static void staticCopy(std_msgs.msg.dds.UInt8MultiArray src, std_msgs.msg.dds.UInt8MultiArray dest)
   {
      dest.set(src);
   }

   @Override
   public std_msgs.msg.dds.UInt8MultiArray createData()
   {
      return new std_msgs.msg.dds.UInt8MultiArray();
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
   
   public void serialize(std_msgs.msg.dds.UInt8MultiArray data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(std_msgs.msg.dds.UInt8MultiArray data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(std_msgs.msg.dds.UInt8MultiArray src, std_msgs.msg.dds.UInt8MultiArray dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public UInt8MultiArrayPubSubType newInstance()
   {
      return new UInt8MultiArrayPubSubType();
   }
}

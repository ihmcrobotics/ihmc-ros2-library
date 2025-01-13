package ros_msgs.msg.dds;

/**
* 
* Topic data type of the struct "Num" defined in "Num_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from Num_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit Num_.idl instead.
*
*/
public class NumPubSubType implements us.ihmc.pubsub.TopicDataType<ros_msgs.msg.dds.Num>
{
   public static final java.lang.String name = "ros_msgs::msg::dds_::Num_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "0a8e645895177cdd4f899e1e12c54076fafe98ce5bfb4e5003d5a61b79a62ee0";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(ros_msgs.msg.dds.Num data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, ros_msgs.msg.dds.Num data) throws java.io.IOException
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
      // Num (unbounded)
      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      // DoubleTest (unbounded)
      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      // NoDefaultWithDoc (unbounded)
      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      // NoDocNum (unbounded)
      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      // Hello (unbounded)
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      return current_alignment - initial_alignment;   }

   public final static int getCdrSerializedSize(ros_msgs.msg.dds.Num data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(ros_msgs.msg.dds.Num data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      // Num (unbounded)
      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      // DoubleTest (unbounded)
      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      // NoDefaultWithDoc (unbounded)
      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      // NoDocNum (unbounded)
      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      // Hello (unbounded)
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);



      return current_alignment - initial_alignment;
   }

   public static void write(ros_msgs.msg.dds.Num data, us.ihmc.idl.CDR cdr)
   {
      // Num (unbounded)
      cdr.write_type_11(data.getNum());

      // DoubleTest (unbounded)
      cdr.write_type_6(data.getDoubleTest());

      // NoDefaultWithDoc (unbounded)
      cdr.write_type_11(data.getNoDefaultWithDoc());

      // NoDocNum (unbounded)
      cdr.write_type_11(data.getNoDocNum());

      // Hello (unbounded)
      cdr.write_type_2(data.getHello());

   }

   public static void read(ros_msgs.msg.dds.Num data, us.ihmc.idl.CDR cdr)
   {
      // Num (unbounded)
      data.setNum(cdr.read_type_11());
      	
      // DoubleTest (unbounded)
      data.setDoubleTest(cdr.read_type_6());
      	
      // NoDefaultWithDoc (unbounded)
      data.setNoDefaultWithDoc(cdr.read_type_11());
      	
      // NoDocNum (unbounded)
      data.setNoDocNum(cdr.read_type_11());
      	
      // Hello (unbounded)
      data.setHello(cdr.read_type_2());
      	

   }

   @Override
   public final void serialize(ros_msgs.msg.dds.Num data, us.ihmc.idl.InterchangeSerializer ser)
   {
      // Num (unbounded)
      ser.write_type_11("num", data.getNum());
      // DoubleTest (unbounded)
      ser.write_type_6("double_test", data.getDoubleTest());
      // NoDefaultWithDoc (unbounded)
      ser.write_type_11("no_default_with_doc", data.getNoDefaultWithDoc());
      // NoDocNum (unbounded)
      ser.write_type_11("no_doc_num", data.getNoDocNum());
      // Hello (unbounded)
      ser.write_type_2("hello", data.getHello());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, ros_msgs.msg.dds.Num data)
   {
      // Num (unbounded)
      data.setNum(ser.read_type_11("num"));
      // DoubleTest (unbounded)
      data.setDoubleTest(ser.read_type_6("double_test"));
      // NoDefaultWithDoc (unbounded)
      data.setNoDefaultWithDoc(ser.read_type_11("no_default_with_doc"));
      // NoDocNum (unbounded)
      data.setNoDocNum(ser.read_type_11("no_doc_num"));
      // Hello (unbounded)
      data.setHello(ser.read_type_2("hello"));
   }

   public static void staticCopy(ros_msgs.msg.dds.Num src, ros_msgs.msg.dds.Num dest)
   {
      dest.set(src);
   }

   @Override
   public ros_msgs.msg.dds.Num createData()
   {
      return new ros_msgs.msg.dds.Num();
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
   
   public void serialize(ros_msgs.msg.dds.Num data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(ros_msgs.msg.dds.Num data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(ros_msgs.msg.dds.Num src, ros_msgs.msg.dds.Num dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public NumPubSubType newInstance()
   {
      return new NumPubSubType();
   }
}

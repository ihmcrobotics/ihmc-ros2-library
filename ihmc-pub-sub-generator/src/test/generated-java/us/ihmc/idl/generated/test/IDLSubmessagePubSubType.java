package us.ihmc.idl.generated.test;

/**
* 
* Topic data type of the struct "IDLSubmessage" defined in "IDLSubmessage.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from IDLSubmessage.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit IDLSubmessage.idl instead.
*
*/
public class IDLSubmessagePubSubType implements us.ihmc.pubsub.TopicDataType<us.ihmc.idl.generated.test.IDLSubmessage>
{
   public static final java.lang.String name = "test::IDLSubmessage";

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(us.ihmc.idl.generated.test.IDLSubmessage data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, us.ihmc.idl.generated.test.IDLSubmessage data) throws java.io.IOException
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

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(us.ihmc.idl.generated.test.IDLSubmessage data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(us.ihmc.idl.generated.test.IDLSubmessage data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);



      return current_alignment - initial_alignment;
   }

   public static void write(us.ihmc.idl.generated.test.IDLSubmessage data, us.ihmc.idl.CDR cdr)
   {
      cdr.write_type_11(data.getNum());

      cdr.write_type_11(data.getNoDefaultWithDoc());

      cdr.write_type_11(data.getNoDocNum());

      cdr.write_type_2(data.getHello());

   }

   public static void read(us.ihmc.idl.generated.test.IDLSubmessage data, us.ihmc.idl.CDR cdr)
   {
      data.setNum(cdr.read_type_11());
      	
      data.setNoDefaultWithDoc(cdr.read_type_11());
      	
      data.setNoDocNum(cdr.read_type_11());
      	
      data.setHello(cdr.read_type_2());
      	

   }

   @Override
   public final void serialize(us.ihmc.idl.generated.test.IDLSubmessage data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_11("num", data.getNum());
      ser.write_type_11("no_default_with_doc", data.getNoDefaultWithDoc());
      ser.write_type_11("no_doc_num", data.getNoDocNum());
      ser.write_type_2("hello", data.getHello());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, us.ihmc.idl.generated.test.IDLSubmessage data)
   {
      data.setNum(ser.read_type_11("num"));
      data.setNoDefaultWithDoc(ser.read_type_11("no_default_with_doc"));
      data.setNoDocNum(ser.read_type_11("no_doc_num"));
      data.setHello(ser.read_type_2("hello"));
   }

   public static void staticCopy(us.ihmc.idl.generated.test.IDLSubmessage src, us.ihmc.idl.generated.test.IDLSubmessage dest)
   {
      dest.set(src);
   }

   @Override
   public us.ihmc.idl.generated.test.IDLSubmessage createData()
   {
      return new us.ihmc.idl.generated.test.IDLSubmessage();
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
   
   public void serialize(us.ihmc.idl.generated.test.IDLSubmessage data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(us.ihmc.idl.generated.test.IDLSubmessage data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(us.ihmc.idl.generated.test.IDLSubmessage src, us.ihmc.idl.generated.test.IDLSubmessage dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public IDLSubmessagePubSubType newInstance()
   {
      return new IDLSubmessagePubSubType();
   }
}

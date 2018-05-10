package us.ihmc.idl.generated.test;

/**
* 
* Topic data type of the struct "StatusMessage" defined in "StatusMessage.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from StatusMessage.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit StatusMessage.idl instead.
*
*/
public class StatusMessagePubSubType implements us.ihmc.pubsub.TopicDataType<us.ihmc.idl.generated.test.StatusMessage>
{
   public static final java.lang.String name = "test::StatusMessage";

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(us.ihmc.idl.generated.test.StatusMessage data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, us.ihmc.idl.generated.test.StatusMessage data) throws java.io.IOException
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

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(us.ihmc.idl.generated.test.StatusMessage data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(us.ihmc.idl.generated.test.StatusMessage data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);



      return current_alignment - initial_alignment;
   }

   public static void write(us.ihmc.idl.generated.test.StatusMessage data, us.ihmc.idl.CDR cdr)
   {
      cdr.write_type_12(data.getSequenceId());

      cdr.write_type_7(data.getPause());

   }

   public static void read(us.ihmc.idl.generated.test.StatusMessage data, us.ihmc.idl.CDR cdr)
   {
      data.setSequenceId(cdr.read_type_12());
      	
      data.setPause(cdr.read_type_7());
      	

   }

   @Override
   public final void serialize(us.ihmc.idl.generated.test.StatusMessage data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_12("sequence_id", data.getSequenceId());
      ser.write_type_7("pause", data.getPause());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, us.ihmc.idl.generated.test.StatusMessage data)
   {
      data.setSequenceId(ser.read_type_12("sequence_id"));
      data.setPause(ser.read_type_7("pause"));
   }

   public static void staticCopy(us.ihmc.idl.generated.test.StatusMessage src, us.ihmc.idl.generated.test.StatusMessage dest)
   {
      dest.set(src);
   }

   @Override
   public us.ihmc.idl.generated.test.StatusMessage createData()
   {
      return new us.ihmc.idl.generated.test.StatusMessage();
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
   
   public void serialize(us.ihmc.idl.generated.test.StatusMessage data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(us.ihmc.idl.generated.test.StatusMessage data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(us.ihmc.idl.generated.test.StatusMessage src, us.ihmc.idl.generated.test.StatusMessage dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public StatusMessagePubSubType newInstance()
   {
      return new StatusMessagePubSubType();
   }
}

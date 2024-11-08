package service_msgs.msg.dds;

/**
* 
* Topic data type of the struct "ServiceEventInfo" defined in "ServiceEventInfo_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from ServiceEventInfo_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit ServiceEventInfo_.idl instead.
*
*/
public class ServiceEventInfoPubSubType implements us.ihmc.pubsub.TopicDataType<service_msgs.msg.dds.ServiceEventInfo>
{
   public static final java.lang.String name = "service_msgs::msg::dds_::ServiceEventInfo_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "21d37586767853f0de2f43e9cc1105e95032b1b00f8ef03d4c8f529b754243d3";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(service_msgs.msg.dds.ServiceEventInfo data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, service_msgs.msg.dds.ServiceEventInfo data) throws java.io.IOException
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

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += builtin_interfaces.msg.dds.TimePubSubType.getMaxCdrSerializedSize(current_alignment);

      current_alignment += ((16) * 1) + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(service_msgs.msg.dds.ServiceEventInfo data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(service_msgs.msg.dds.ServiceEventInfo data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += builtin_interfaces.msg.dds.TimePubSubType.getCdrSerializedSize(data.getStamp(), current_alignment);

      current_alignment += ((16) * 1) + us.ihmc.idl.CDR.alignment(current_alignment, 1);
      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);



      return current_alignment - initial_alignment;
   }

   public static void write(service_msgs.msg.dds.ServiceEventInfo data, us.ihmc.idl.CDR cdr)
   {
      cdr.write_type_9(data.getEventType());

      builtin_interfaces.msg.dds.TimePubSubType.write(data.getStamp(), cdr);
      for(int i0 = 0; i0 < data.getClientGid().length; ++i0)
      {
        	cdr.write_type_8(data.getClientGid()[i0]);	
      }

      cdr.write_type_11(data.getSequenceNumber());

   }

   public static void read(service_msgs.msg.dds.ServiceEventInfo data, us.ihmc.idl.CDR cdr)
   {
      data.setEventType(cdr.read_type_9());
      	
      builtin_interfaces.msg.dds.TimePubSubType.read(data.getStamp(), cdr);	
      for(int i0 = 0; i0 < data.getClientGid().length; ++i0)
      {
        	data.getClientGid()[i0] = cdr.read_type_8();
        	
      }
      	
      data.setSequenceNumber(cdr.read_type_11());
      	

   }

   @Override
   public final void serialize(service_msgs.msg.dds.ServiceEventInfo data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_9("event_type", data.getEventType());
      ser.write_type_a("stamp", new builtin_interfaces.msg.dds.TimePubSubType(), data.getStamp());

      ser.write_type_f("client_gid", data.getClientGid());
      ser.write_type_11("sequence_number", data.getSequenceNumber());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, service_msgs.msg.dds.ServiceEventInfo data)
   {
      data.setEventType(ser.read_type_9("event_type"));
      ser.read_type_a("stamp", new builtin_interfaces.msg.dds.TimePubSubType(), data.getStamp());

      ser.read_type_f("client_gid", data.getClientGid());
      data.setSequenceNumber(ser.read_type_11("sequence_number"));
   }

   public static void staticCopy(service_msgs.msg.dds.ServiceEventInfo src, service_msgs.msg.dds.ServiceEventInfo dest)
   {
      dest.set(src);
   }

   @Override
   public service_msgs.msg.dds.ServiceEventInfo createData()
   {
      return new service_msgs.msg.dds.ServiceEventInfo();
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
   
   public void serialize(service_msgs.msg.dds.ServiceEventInfo data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(service_msgs.msg.dds.ServiceEventInfo data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(service_msgs.msg.dds.ServiceEventInfo src, service_msgs.msg.dds.ServiceEventInfo dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public ServiceEventInfoPubSubType newInstance()
   {
      return new ServiceEventInfoPubSubType();
   }
}

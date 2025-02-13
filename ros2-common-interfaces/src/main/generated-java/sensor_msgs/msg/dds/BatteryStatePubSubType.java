package sensor_msgs.msg.dds;

/**
* 
* Topic data type of the struct "BatteryState" defined in "BatteryState_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from BatteryState_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit BatteryState_.idl instead.
*
*/
public class BatteryStatePubSubType implements us.ihmc.pubsub.TopicDataType<sensor_msgs.msg.dds.BatteryState>
{
   public static final java.lang.String name = "sensor_msgs::msg::dds_::BatteryState_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "b35bdae7825475a7535250bc8375ef115f7db01ef9e6a77fcd7fb0c1c58eed12";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(sensor_msgs.msg.dds.BatteryState data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, sensor_msgs.msg.dds.BatteryState data) throws java.io.IOException
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

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);current_alignment += (100 * 4) + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);current_alignment += (100 * 4) + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;
      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 255 + 1;

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(sensor_msgs.msg.dds.BatteryState data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(sensor_msgs.msg.dds.BatteryState data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += std_msgs.msg.dds.HeaderPubSubType.getCdrSerializedSize(data.getHeader(), current_alignment);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (data.getCellVoltage().size() * 4) + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (data.getCellTemperature().size() * 4) + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getLocation().length() + 1;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getSerialNumber().length() + 1;


      return current_alignment - initial_alignment;
   }

   public static void write(sensor_msgs.msg.dds.BatteryState data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.write(data.getHeader(), cdr);
      cdr.write_type_5(data.getVoltage());

      cdr.write_type_5(data.getTemperature());

      cdr.write_type_5(data.getCurrent());

      cdr.write_type_5(data.getCharge());

      cdr.write_type_5(data.getCapacity());

      cdr.write_type_5(data.getDesignCapacity());

      cdr.write_type_5(data.getPercentage());

      cdr.write_type_9(data.getPowerSupplyStatus());

      cdr.write_type_9(data.getPowerSupplyHealth());

      cdr.write_type_9(data.getPowerSupplyTechnology());

      cdr.write_type_7(data.getPresent());

      if(data.getCellVoltage().size() <= 100)
      cdr.write_type_e(data.getCellVoltage());else
          throw new RuntimeException("cell_voltage field exceeds the maximum length: %d > %d".formatted(data.getCellVoltage().size(), 100));

      if(data.getCellTemperature().size() <= 100)
      cdr.write_type_e(data.getCellTemperature());else
          throw new RuntimeException("cell_temperature field exceeds the maximum length: %d > %d".formatted(data.getCellTemperature().size(), 100));

      if(data.getLocation().length() <= 255)
      cdr.write_type_d(data.getLocation());else
          throw new RuntimeException("location field exceeds the maximum length: %d > %d".formatted(data.getLocation().length(), 255));

      if(data.getSerialNumber().length() <= 255)
      cdr.write_type_d(data.getSerialNumber());else
          throw new RuntimeException("serial_number field exceeds the maximum length: %d > %d".formatted(data.getSerialNumber().length(), 255));

   }

   public static void read(sensor_msgs.msg.dds.BatteryState data, us.ihmc.idl.CDR cdr)
   {
      std_msgs.msg.dds.HeaderPubSubType.read(data.getHeader(), cdr);	
      data.setVoltage(cdr.read_type_5());
      	
      data.setTemperature(cdr.read_type_5());
      	
      data.setCurrent(cdr.read_type_5());
      	
      data.setCharge(cdr.read_type_5());
      	
      data.setCapacity(cdr.read_type_5());
      	
      data.setDesignCapacity(cdr.read_type_5());
      	
      data.setPercentage(cdr.read_type_5());
      	
      data.setPowerSupplyStatus(cdr.read_type_9());
      	
      data.setPowerSupplyHealth(cdr.read_type_9());
      	
      data.setPowerSupplyTechnology(cdr.read_type_9());
      	
      data.setPresent(cdr.read_type_7());
      	
      cdr.read_type_e(data.getCellVoltage());	
      cdr.read_type_e(data.getCellTemperature());	
      cdr.read_type_d(data.getLocation());	
      cdr.read_type_d(data.getSerialNumber());	

   }

   @Override
   public final void serialize(sensor_msgs.msg.dds.BatteryState data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      ser.write_type_5("voltage", data.getVoltage());
      ser.write_type_5("temperature", data.getTemperature());
      ser.write_type_5("current", data.getCurrent());
      ser.write_type_5("charge", data.getCharge());
      ser.write_type_5("capacity", data.getCapacity());
      ser.write_type_5("design_capacity", data.getDesignCapacity());
      ser.write_type_5("percentage", data.getPercentage());
      ser.write_type_9("power_supply_status", data.getPowerSupplyStatus());
      ser.write_type_9("power_supply_health", data.getPowerSupplyHealth());
      ser.write_type_9("power_supply_technology", data.getPowerSupplyTechnology());
      ser.write_type_7("present", data.getPresent());
      ser.write_type_e("cell_voltage", data.getCellVoltage());
      ser.write_type_e("cell_temperature", data.getCellTemperature());
      ser.write_type_d("location", data.getLocation());
      ser.write_type_d("serial_number", data.getSerialNumber());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, sensor_msgs.msg.dds.BatteryState data)
   {
      ser.read_type_a("header", new std_msgs.msg.dds.HeaderPubSubType(), data.getHeader());

      data.setVoltage(ser.read_type_5("voltage"));
      data.setTemperature(ser.read_type_5("temperature"));
      data.setCurrent(ser.read_type_5("current"));
      data.setCharge(ser.read_type_5("charge"));
      data.setCapacity(ser.read_type_5("capacity"));
      data.setDesignCapacity(ser.read_type_5("design_capacity"));
      data.setPercentage(ser.read_type_5("percentage"));
      data.setPowerSupplyStatus(ser.read_type_9("power_supply_status"));
      data.setPowerSupplyHealth(ser.read_type_9("power_supply_health"));
      data.setPowerSupplyTechnology(ser.read_type_9("power_supply_technology"));
      data.setPresent(ser.read_type_7("present"));
      ser.read_type_e("cell_voltage", data.getCellVoltage());
      ser.read_type_e("cell_temperature", data.getCellTemperature());
      ser.read_type_d("location", data.getLocation());
      ser.read_type_d("serial_number", data.getSerialNumber());
   }

   public static void staticCopy(sensor_msgs.msg.dds.BatteryState src, sensor_msgs.msg.dds.BatteryState dest)
   {
      dest.set(src);
   }

   @Override
   public sensor_msgs.msg.dds.BatteryState createData()
   {
      return new sensor_msgs.msg.dds.BatteryState();
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
   
   public void serialize(sensor_msgs.msg.dds.BatteryState data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(sensor_msgs.msg.dds.BatteryState data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(sensor_msgs.msg.dds.BatteryState src, sensor_msgs.msg.dds.BatteryState dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public BatteryStatePubSubType newInstance()
   {
      return new BatteryStatePubSubType();
   }
}

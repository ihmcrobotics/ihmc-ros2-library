package us.ihmc.idl.generated.geometry;

/**
* 
* Topic data type of the struct "Box" defined in "Vector.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from Vector.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit Vector.idl instead.
*
*/
public class BoxPubSubType implements us.ihmc.pubsub.TopicDataType<us.ihmc.idl.generated.geometry.Box>
{
   public static final java.lang.String name = "geometry::Box";

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(us.ihmc.idl.generated.geometry.Box data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, us.ihmc.idl.generated.geometry.Box data) throws java.io.IOException
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

      current_alignment += us.ihmc.idl.generated.geometry.VectorPubSubType.getMaxCdrSerializedSize(current_alignment);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(us.ihmc.idl.generated.geometry.Box data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(us.ihmc.idl.generated.geometry.Box data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += us.ihmc.idl.generated.geometry.VectorPubSubType.getCdrSerializedSize(data.getCenter(), current_alignment);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);



      return current_alignment - initial_alignment;
   }

   public static void write(us.ihmc.idl.generated.geometry.Box data, us.ihmc.idl.CDR cdr)
   {
      us.ihmc.idl.generated.geometry.VectorPubSubType.write(data.getCenter(), cdr);
      cdr.write_type_6(data.getW());

      cdr.write_type_6(data.getL());

      cdr.write_type_6(data.getH());

   }

   public static void read(us.ihmc.idl.generated.geometry.Box data, us.ihmc.idl.CDR cdr)
   {
      us.ihmc.idl.generated.geometry.VectorPubSubType.read(data.getCenter(), cdr);	
      data.setW(cdr.read_type_6());
      	
      data.setL(cdr.read_type_6());
      	
      data.setH(cdr.read_type_6());
      	

   }

   @Override
   public final void serialize(us.ihmc.idl.generated.geometry.Box data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_a("center", new us.ihmc.idl.generated.geometry.VectorPubSubType(), data.getCenter());

      ser.write_type_6("w", data.getW());
      ser.write_type_6("l", data.getL());
      ser.write_type_6("h", data.getH());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, us.ihmc.idl.generated.geometry.Box data)
   {
      ser.read_type_a("center", new us.ihmc.idl.generated.geometry.VectorPubSubType(), data.getCenter());

      data.setW(ser.read_type_6("w"));
      data.setL(ser.read_type_6("l"));
      data.setH(ser.read_type_6("h"));
   }

   public static void staticCopy(us.ihmc.idl.generated.geometry.Box src, us.ihmc.idl.generated.geometry.Box dest)
   {
      dest.set(src);
   }

   @Override
   public us.ihmc.idl.generated.geometry.Box createData()
   {
      return new us.ihmc.idl.generated.geometry.Box();
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
   
   public void serialize(us.ihmc.idl.generated.geometry.Box data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(us.ihmc.idl.generated.geometry.Box data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(us.ihmc.idl.generated.geometry.Box src, us.ihmc.idl.generated.geometry.Box dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public BoxPubSubType newInstance()
   {
      return new BoxPubSubType();
   }
}

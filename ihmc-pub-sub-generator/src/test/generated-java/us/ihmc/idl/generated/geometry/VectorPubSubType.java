package us.ihmc.idl.generated.geometry;

/**
* 
* Topic data type of the struct "Vector" defined in "Vector.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from Vector.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit Vector.idl instead.
*
*/
public class VectorPubSubType implements us.ihmc.pubsub.TopicDataType<us.ihmc.idl.generated.geometry.Vector>
{
   public static final java.lang.String name = "geometry::Vector";

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(us.ihmc.idl.generated.geometry.Vector data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, us.ihmc.idl.generated.geometry.Vector data) throws java.io.IOException
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

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + 128 + 1;
      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);current_alignment += (100 * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      current_alignment += ((3) * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(us.ihmc.idl.generated.geometry.Vector data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(us.ihmc.idl.generated.geometry.Vector data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + data.getFrame().length() + 1;

      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
      current_alignment += (data.getBla().size() * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);


      current_alignment += ((3) * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);

      return current_alignment - initial_alignment;
   }

   public static void write(us.ihmc.idl.generated.geometry.Vector data, us.ihmc.idl.CDR cdr)
   {
      if(data.getFrame().length() <= 128)
      cdr.write_type_d(data.getFrame());else
          throw new RuntimeException("frame field exceeds the maximum length");

      cdr.write_type_6(data.getX());

      cdr.write_type_6(data.getY());

      cdr.write_type_6(data.getZ());

      if(data.getBla().size() <= 100)
      cdr.write_type_e(data.getBla());else
          throw new RuntimeException("bla field exceeds the maximum length");

      for(int i0 = 0; i0 < data.getWaa().length; ++i0)
      {
        	cdr.write_type_6(data.getWaa()[i0]);	
      }

   }

   public static void read(us.ihmc.idl.generated.geometry.Vector data, us.ihmc.idl.CDR cdr)
   {
      cdr.read_type_d(data.getFrame());	
      data.setX(cdr.read_type_6());
      	
      data.setY(cdr.read_type_6());
      	
      data.setZ(cdr.read_type_6());
      	
      cdr.read_type_e(data.getBla());	
      for(int i0 = 0; i0 < data.getWaa().length; ++i0)
      {
        	data.getWaa()[i0] = cdr.read_type_6();
        	
      }
      	

   }

   @Override
   public final void serialize(us.ihmc.idl.generated.geometry.Vector data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_d("frame", data.getFrame());
      ser.write_type_6("x", data.getX());
      ser.write_type_6("y", data.getY());
      ser.write_type_6("z", data.getZ());
      ser.write_type_e("bla", data.getBla());
      ser.write_type_f("waa", data.getWaa());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, us.ihmc.idl.generated.geometry.Vector data)
   {
      ser.read_type_d("frame", data.getFrame());
      data.setX(ser.read_type_6("x"));
      data.setY(ser.read_type_6("y"));
      data.setZ(ser.read_type_6("z"));
      ser.read_type_e("bla", data.getBla());
      ser.read_type_f("waa", data.getWaa());
   }

   public static void staticCopy(us.ihmc.idl.generated.geometry.Vector src, us.ihmc.idl.generated.geometry.Vector dest)
   {
      dest.set(src);
   }

   @Override
   public us.ihmc.idl.generated.geometry.Vector createData()
   {
      return new us.ihmc.idl.generated.geometry.Vector();
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
   
   public void serialize(us.ihmc.idl.generated.geometry.Vector data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(us.ihmc.idl.generated.geometry.Vector data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(us.ihmc.idl.generated.geometry.Vector src, us.ihmc.idl.generated.geometry.Vector dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public VectorPubSubType newInstance()
   {
      return new VectorPubSubType();
   }
}

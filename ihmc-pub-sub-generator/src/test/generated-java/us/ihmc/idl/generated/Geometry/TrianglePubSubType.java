package us.ihmc.idl.generated.geometry;

/**
* 
* Topic data type of the struct "Triangle" defined in "Vector.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from Vector.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit Vector.idl instead.
*
*/
public class TrianglePubSubType implements us.ihmc.pubsub.TopicDataType<us.ihmc.idl.generated.geometry.Triangle>
{
   public static final java.lang.String name = "geometry::Triangle";

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   @Override
   public void serialize(us.ihmc.idl.generated.geometry.Triangle data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, us.ihmc.idl.generated.geometry.Triangle data) throws java.io.IOException
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

      for(int i0 = 0; i0 < (3); ++i0)
      {
          current_alignment += us.ihmc.idl.generated.geometry.VectorPubSubType.getMaxCdrSerializedSize(current_alignment);}
      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(us.ihmc.idl.generated.geometry.Triangle data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(us.ihmc.idl.generated.geometry.Triangle data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      for(int i0 = 0; i0 < data.getPoints().length; ++i0)
      {
              current_alignment += us.ihmc.idl.generated.geometry.VectorPubSubType.getCdrSerializedSize(data.getPoints()[i0], current_alignment);
      }
      return current_alignment - initial_alignment;
   }

   public static void write(us.ihmc.idl.generated.geometry.Triangle data, us.ihmc.idl.CDR cdr)
   {
      for(int i0 = 0; i0 < data.getPoints().length; ++i0)
      {
        	us.ihmc.idl.generated.geometry.VectorPubSubType.write(data.getPoints()[i0], cdr);		
      }
   }

   public static void read(us.ihmc.idl.generated.geometry.Triangle data, us.ihmc.idl.CDR cdr)
   {
      for(int i0 = 0; i0 < data.getPoints().length; ++i0)
      {
        	us.ihmc.idl.generated.geometry.VectorPubSubType.read(data.getPoints()[i0], cdr);	
      }
      	

   }

   @Override
   public final void serialize(us.ihmc.idl.generated.geometry.Triangle data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_f("points", new us.ihmc.idl.generated.geometry.VectorPubSubType(), data.getPoints());   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, us.ihmc.idl.generated.geometry.Triangle data)
   {
      ser.read_type_f("points", new us.ihmc.idl.generated.geometry.VectorPubSubType(), data.getPoints());   }

   public static void staticCopy(us.ihmc.idl.generated.geometry.Triangle src, us.ihmc.idl.generated.geometry.Triangle dest)
   {
      dest.set(src);
   }

   @Override
   public us.ihmc.idl.generated.geometry.Triangle createData()
   {
      return new us.ihmc.idl.generated.geometry.Triangle();
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
   
   public void serialize(us.ihmc.idl.generated.geometry.Triangle data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(us.ihmc.idl.generated.geometry.Triangle data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(us.ihmc.idl.generated.geometry.Triangle src, us.ihmc.idl.generated.geometry.Triangle dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public TrianglePubSubType newInstance()
   {
      return new TrianglePubSubType();
   }
}

package ros_msgs.msg.dds;

/**
* 
* Topic data type of the struct "CustomBoi" defined in "CustomBoi_.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from CustomBoi_.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit CustomBoi_.idl instead.
*
*/
public class CustomBoiPubSubType implements us.ihmc.pubsub.TopicDataType<us.ihmc.CustomBoi>
{
   public static final java.lang.String name = "ros_msgs::msg::dds_::CustomBoi_";
   
   @Override
   public final java.lang.String getDefinitionChecksum()
   {
   		return "73d3714c68508d18728661f861dec4d5f9457168b72341b5395d7f474099a55a";
   }
   
   @Override
   public final java.lang.String getDefinitionVersion()
   {
   		return "local";
   }

   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   private static AbstractCustomBoiPubSubTypeImplementation impl = new us.ihmc.CustomBoiPubSubTypeImpl();
   
   /**
    * Abstract implementation of CustomBoiPubSubType.
    *
    * Extend this class to create a custom PubSubType for @Abstract idl datatypes.
    *
    */
   public static abstract class AbstractCustomBoiPubSubTypeImplementation
   {
   /**
    * Copy src into dest.
    *
    * @param src Source object to copy data from
    * @param dest Destination object to copy data to
    */
   protected abstract void copy(us.ihmc.CustomBoi src, us.ihmc.CustomBoi dest);
   /**
    * Getter for X
    *
    * @param data object to read from
    * @return value of X
    */
   protected abstract float getX(us.ihmc.CustomBoi data);
   /**
    * Setter for X
    *
    * @param data object to write to
    * @param x value
    */
   protected abstract void setX(us.ihmc.CustomBoi data, float x);
   /**
    * Getter for Y
    *
    * @param data object to read from
    * @return value of X
    */
   protected abstract float getY(us.ihmc.CustomBoi data);
   /**
    * Setter for Y
    *
    * @param data object to write to
    * @param y value
    */
   protected abstract void setY(us.ihmc.CustomBoi data, float y);
   /**
    * Getter for Z
    *
    * @param data object to read from
    * @return value of X
    */
   protected abstract float getZ(us.ihmc.CustomBoi data);
   /**
    * Setter for Z
    *
    * @param data object to write to
    * @param z value
    */
   protected abstract void setZ(us.ihmc.CustomBoi data, float z);
      public abstract us.ihmc.CustomBoi createData();
   }

   private static AbstractCustomBoiPubSubTypeImplementation getImpl()
   {
     if(impl == null)
     {
      throw new RuntimeException("Abstract pub/sub type implementation not set. Call setImplementation(AbstractCustomBoiPubSubTypeImplementation implementation) before using this type.");
     }
     return impl;
   }
   
   public static void setImplementation(AbstractCustomBoiPubSubTypeImplementation implementation)
   {
     CustomBoiPubSubType.impl = implementation;
   }

   public static int getMaxCdrSerializedSize()
   {
     return getMaxCdrSerializedSize(0);
   }

   public static int getMaxCdrSerializedSize(int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(us.ihmc.CustomBoi data)
   {
     return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(us.ihmc.CustomBoi data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);


      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);



      return current_alignment - initial_alignment;
   }

   @Override
   public void serialize(us.ihmc.CustomBoi data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, us.ihmc.CustomBoi data) throws java.io.IOException
   {
      deserializeCDR.deserialize(serializedPayload);
      read(data, deserializeCDR);
      deserializeCDR.finishDeserialize();
   }

   public static void write(us.ihmc.CustomBoi data, us.ihmc.idl.CDR cdr)
   {
      cdr.write_type_5(getImpl().getX(data));

      cdr.write_type_5(getImpl().getY(data));

      cdr.write_type_5(getImpl().getZ(data));

   }

   public static void read(us.ihmc.CustomBoi data, us.ihmc.idl.CDR cdr)
   {
      getImpl().setX(data,cdr.read_type_5());
      	
      getImpl().setY(data,cdr.read_type_5());
      	
      getImpl().setZ(data,cdr.read_type_5());
      	
   }

   @Override
   public final void serialize(us.ihmc.CustomBoi data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_5("x", getImpl().getX(data));
      ser.write_type_5("y", getImpl().getY(data));
      ser.write_type_5("z", getImpl().getZ(data));
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, us.ihmc.CustomBoi data)
   {
      getImpl().setX(data, ser.read_type_5("x"));
      getImpl().setY(data, ser.read_type_5("y"));
      getImpl().setZ(data, ser.read_type_5("z"));
   }

   public static void staticCopy(us.ihmc.CustomBoi src, us.ihmc.CustomBoi dest)
   {
      getImpl().copy(src, dest);
   }

   @Override
   public us.ihmc.CustomBoi createData()
   {
      return getImpl().createData();
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
   
   public void serialize(us.ihmc.CustomBoi data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(us.ihmc.CustomBoi data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }
   
   public void copy(us.ihmc.CustomBoi src, us.ihmc.CustomBoi dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public CustomBoiPubSubType newInstance()
   {
      return new CustomBoiPubSubType();
   }
}

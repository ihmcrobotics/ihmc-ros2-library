package us.ihmc.idl.generated.Geometry;

/**
* 
* Topic data type of the struct "Vector" defined in "Vector.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from Vector.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit Vector.idl instead.
*
*/
public class VectorPubSubType implements us.ihmc.pubsub.TopicDataType<java.lang.Object>
{
	public static final java.lang.String name = "Geometry::Vector";
	
	
	
    public VectorPubSubType()
    {
        
    }


	private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
	private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();



	private static AbstractVectorPubSubTypeImplementation impl = null;
	
	/**
	 * Abstract implementation of VectorPubSubType. 
	 * 
	 * Extend this class to create a custom PubSubType for @Abstract idl datatypes. 
	 *
	 */
	public static abstract class AbstractVectorPubSubTypeImplementation
	{

		
		/**
		 * Copy src into dest. 
		 * 
		 * @param src Source object to copy data from
		 * @param dest Destination object to copy data to
		 */
		protected abstract void copy(java.lang.Object src, java.lang.Object dest);
		
		
		
	    /**
        * Getter for Frame 
        * 
        * @param data object to read from
        * @return value of X
        */
		protected abstract java.lang.StringBuilder getFrame(java.lang.Object data);

		
		
	    /**
        * Getter for X 
        * 
        * @param data object to read from
        * @return value of X
        */
		protected abstract double getX(java.lang.Object data);
	    /**
        * Setter for X 
        * 
        * @param data object to write to
        * @param x value
        */
		protected abstract void setX(java.lang.Object data, double x);

		
		
	    /**
        * Getter for Y 
        * 
        * @param data object to read from
        * @return value of X
        */
		protected abstract double getY(java.lang.Object data);
	    /**
        * Setter for Y 
        * 
        * @param data object to write to
        * @param y value
        */
		protected abstract void setY(java.lang.Object data, double y);

		
		
	    /**
        * Getter for Z 
        * 
        * @param data object to read from
        * @return value of X
        */
		protected abstract double getZ(java.lang.Object data);
	    /**
        * Setter for Z 
        * 
        * @param data object to write to
        * @param z value
        */
		protected abstract void setZ(java.lang.Object data, double z);

		
		
	    /**
        * Getter for Bla 
        * 
        * @param data object to read from
        * @return value of X
        */
		protected abstract us.ihmc.idl.IDLSequence.Double  getBla(java.lang.Object data);

		
		
	    /**
        * Getter for Waa 
        * 
        * @param data object to read from
        * @return value of X
        */
		protected abstract double[] getWaa(java.lang.Object data);

		


   		public abstract java.lang.Object createData();
	}

	private static AbstractVectorPubSubTypeImplementation getImpl()
	{
		if(impl == null)
		{
			throw new RuntimeException("Abstract pub/sub type implementation not set. Call setImplementation(AbstractVectorPubSubTypeImplementation implementation) before using this type.");
		}
		return impl;
	}
	
	public static void setImplementation(AbstractVectorPubSubTypeImplementation implementation)
	{
		VectorPubSubType.impl = implementation;
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

	    current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
	    current_alignment += (100 * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);


	    current_alignment += ((3) * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);

	
	    return current_alignment - initial_alignment;
	}


	public final static int getCdrSerializedSize(java.lang.Object data)
	{
		return getCdrSerializedSize(data, 0);
	}

	public final static int getCdrSerializedSize(java.lang.Object data, int current_alignment)
	{
		int initial_alignment = current_alignment;
	            
	    	current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4) + getImpl().getFrame(data).length() + 1;

	    	current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

	    	current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

	    	current_alignment += 8 + us.ihmc.idl.CDR.alignment(current_alignment, 8);

	    	current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);
	    	current_alignment += (getImpl().getBla(data).size() * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);


	    	current_alignment += ((3) * 8) + us.ihmc.idl.CDR.alignment(current_alignment, 8);
	
	    	return current_alignment - initial_alignment;
	}


       @Override
   public void serialize(java.lang.Object data, us.ihmc.pubsub.common.SerializedPayload serializedPayload) throws java.io.IOException
   {
   		
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();

   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, java.lang.Object data) throws java.io.IOException
   {
	 deserializeCDR.deserialize(serializedPayload);
     read(data, deserializeCDR);
	 deserializeCDR.finishDeserialize();
   }
   

   public static void write(java.lang.Object data, us.ihmc.idl.CDR cdr)
   {

   		if(getImpl().getFrame(data).length() <= 128)
   		cdr.write_type_d(getImpl().getFrame(data));else
   		    throw new RuntimeException("frame field exceeds the maximum length");

   		cdr.write_type_6(getImpl().getX(data));

   		cdr.write_type_6(getImpl().getY(data));

   		cdr.write_type_6(getImpl().getZ(data));

   		if(getImpl().getBla(data).size() <= 100)
   		cdr.write_type_e(getImpl().getBla(data));else
   		    throw new RuntimeException("bla field exceeds the maximum length");

   		for(int a = 0; a < getImpl().getWaa(data).length; ++a)
   		{
   		    	cdr.write_type_6(getImpl().getWaa(data)[a]);	
   		}

   }

   public static void read(java.lang.Object data, us.ihmc.idl.CDR cdr)
   {

			cdr.read_type_d(getImpl().getFrame(data));	

			getImpl().setX(data,cdr.read_type_6());
			

			getImpl().setY(data,cdr.read_type_6());
			

			getImpl().setZ(data,cdr.read_type_6());
			

			cdr.read_type_e(getImpl().getBla(data));	

			for(int a = 0; a < getImpl().getWaa(data).length; ++a)
			{
			    	getImpl().getWaa(data)[a] = cdr.read_type_6();
			    	
			}
			
   }
   
	@Override
	public final void serialize(java.lang.Object data, us.ihmc.idl.InterchangeSerializer ser)
	{
			    ser.write_type_d("frame", getImpl().getFrame(data));
			    
			    ser.write_type_6("x", getImpl().getX(data));
			    
			    ser.write_type_6("y", getImpl().getY(data));
			    
			    ser.write_type_6("z", getImpl().getZ(data));
			    
			    ser.write_type_e("bla", getImpl().getBla(data));
			    
				    	ser.write_type_f("waa", getImpl().getWaa(data));	    
	}
	
	@Override
	public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, java.lang.Object data)
	{
	    			ser.read_type_d("frame", getImpl().getFrame(data));	
	    	    
	    			getImpl().setX(data, ser.read_type_6("x"));	
	    	    
	    			getImpl().setY(data, ser.read_type_6("y"));	
	    	    
	    			getImpl().setZ(data, ser.read_type_6("z"));	
	    	    
	    			ser.read_type_e("bla", getImpl().getBla(data));	
	    	    
	    		    	ser.read_type_f("waa", getImpl().getWaa(data));			
	    	
	    	    
	}


   public static void staticCopy(java.lang.Object src, java.lang.Object dest)
   {
   		getImpl().copy(src, dest);
   }
   
   
   @Override
   public java.lang.Object createData()
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
   
   public void serialize(java.lang.Object data, us.ihmc.idl.CDR cdr)
	{
		write(data, cdr);
	}

   public void deserialize(java.lang.Object data, us.ihmc.idl.CDR cdr)
   {
        read(data, cdr);
   }
   
   public void copy(java.lang.Object src, java.lang.Object dest)
   {
      staticCopy(src, dest);
   }	

   
   @Override
   public VectorPubSubType newInstance()
   {
   	  return new VectorPubSubType();
   }
}
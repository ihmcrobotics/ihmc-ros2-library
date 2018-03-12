package us.ihmc.idl.generated.IDLNestedElement;

import java.io.IOException;

import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.common.SerializedPayload;
import us.ihmc.idl.InterchangeSerializer;
import us.ihmc.idl.CDR;
import us.ihmc.idl.IDLSequence;

/**
* 
* Topic data type of the struct "NestedElement" defined in "NestedElement.idl". Use this class to provide the TopicDataType to a Participant. 
*
* This file was automatically generated from NestedElement.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit NestedElement.idl instead.
*
*/
public class NestedElementPubSubType implements TopicDataType<us.ihmc.idl.generated.IDLNestedElement.NestedElement>
{
	public static final String name = "IDLNestedElement::NestedElement";
	
	
	
    public NestedElementPubSubType()
    {
        
    }

	private final CDR serializeCDR = new CDR();
	private final CDR deserializeCDR = new CDR();

    
    @Override
   public void serialize(us.ihmc.idl.generated.IDLNestedElement.NestedElement data, SerializedPayload serializedPayload) throws IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }
   @Override
   public void deserialize(SerializedPayload serializedPayload, us.ihmc.idl.generated.IDLNestedElement.NestedElement data) throws IOException
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
	            
	    current_alignment += 4 + CDR.alignment(current_alignment, 4) + 255 + 1;

	    current_alignment += 4 + CDR.alignment(current_alignment, 4);

	
	    return current_alignment - initial_alignment;
	}


	public final static int getCdrSerializedSize(us.ihmc.idl.generated.IDLNestedElement.NestedElement data)
	{
		return getCdrSerializedSize(data, 0);
	}

	public final static int getCdrSerializedSize(us.ihmc.idl.generated.IDLNestedElement.NestedElement data, int current_alignment)
	{
	    int initial_alignment = current_alignment;
	            
	    current_alignment += 4 + CDR.alignment(current_alignment, 4) + data.getStringTest().length() + 1;

	    current_alignment += 4 + CDR.alignment(current_alignment, 4);

	
	    return current_alignment - initial_alignment;
	}
	
   public static void write(us.ihmc.idl.generated.IDLNestedElement.NestedElement data, CDR cdr)
   {

	    if(data.getStringTest().length() <= 255)
	    cdr.write_type_d(data.getStringTest());else
	        throw new RuntimeException("stringTest field exceeds the maximum length");

	    cdr.write_type_2(data.getLongTest());
   }

   public static void read(us.ihmc.idl.generated.IDLNestedElement.NestedElement data, CDR cdr)
   {

	    	cdr.read_type_d(data.getStringTest());	

	    	data.setLongTest(cdr.read_type_2());
	    	
   }
   
	@Override
	public final void serialize(us.ihmc.idl.generated.IDLNestedElement.NestedElement data, InterchangeSerializer ser)
	{
			    ser.write_type_d("stringTest", data.getStringTest());
			    
			    ser.write_type_2("longTest", data.getLongTest());
			    
	}
	
	@Override
	public final void deserialize(InterchangeSerializer ser, us.ihmc.idl.generated.IDLNestedElement.NestedElement data)
	{
	    			ser.read_type_d("stringTest", data.getStringTest());	
	    	    
	    			data.setLongTest(ser.read_type_2("longTest"));	
	    	    
	}

   public static void staticCopy(us.ihmc.idl.generated.IDLNestedElement.NestedElement src, us.ihmc.idl.generated.IDLNestedElement.NestedElement dest)
   {
      dest.set(src);
   }
   
   
   @Override
   public us.ihmc.idl.generated.IDLNestedElement.NestedElement createData()
   {
      return new us.ihmc.idl.generated.IDLNestedElement.NestedElement();
   }
      

   @Override
   public int getTypeSize()
   {
      return getMaxCdrSerializedSize();
   }

   @Override
   public String getName()
   {
      return name;
   }
   
   public void serialize(us.ihmc.idl.generated.IDLNestedElement.NestedElement data, CDR cdr)
	{
		write(data, cdr);
	}

   public void deserialize(us.ihmc.idl.generated.IDLNestedElement.NestedElement data, CDR cdr)
   {
        read(data, cdr);
   }
   
   public void copy(us.ihmc.idl.generated.IDLNestedElement.NestedElement src, us.ihmc.idl.generated.IDLNestedElement.NestedElement dest)
   {
      staticCopy(src, dest);
   }	

   
   @Override
   public NestedElementPubSubType newInstance()
   {
   	  return new NestedElementPubSubType();
   }
}
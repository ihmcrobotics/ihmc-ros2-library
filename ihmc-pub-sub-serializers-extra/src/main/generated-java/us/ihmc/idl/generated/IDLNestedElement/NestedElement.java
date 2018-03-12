package us.ihmc.idl.generated.IDLNestedElement;
import us.ihmc.idl.IDLSequence;
import us.ihmc.idl.CDR;
import us.ihmc.idl.InterchangeSerializer;
import java.util.Arrays;

/**
* 
* Definition of the class "NestedElement" defined in NestedElement.idl. 
*
* This file was automatically generated from NestedElement.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit NestedElement.idl instead.
*
*/
public class NestedElement
{
    public NestedElement()
    {
        	stringTest_ = new StringBuilder(255); 
        
        
    }

    public void set(NestedElement other)
    {
        	stringTest_.setLength(0);
        	stringTest_.append(other.stringTest_);
        	longTest_ = other.longTest_;

    }

        public void setStringTest(String stringTest)
        {
        	stringTest_.setLength(0);
        	stringTest_.append(stringTest);
        }
        
        public String getStringTestAsString()
        {
        	return getStringTest().toString();
        }

    public StringBuilder getStringTest()
    {
        return stringTest_;
    }

        
    public void setLongTest(int longTest)
    {
        longTest_ = longTest;
    }

    public int getLongTest()
    {
        return longTest_;
    }

        




    @Override
    public boolean equals(Object other)
    {
        if(other == null) return false;
        if(other == this) return true;
        if(!(other instanceof NestedElement)) return false;
        NestedElement otherMyClass = (NestedElement)other;
        boolean returnedValue = true;

        returnedValue &= us.ihmc.idl.IDLTools.equals(this.stringTest_, otherMyClass.stringTest_);
                
        returnedValue &= this.longTest_ == otherMyClass.longTest_;

                

        return returnedValue;
    }
    
     @Override
    public String toString()
    {
		StringBuilder builder = new StringBuilder();
		
      	builder.append("NestedElement {");
        builder.append("stringTest=");
        builder.append(this.stringTest_);

                builder.append(", ");
        builder.append("longTest=");
        builder.append(this.longTest_);

                
        builder.append("}");
		return builder.toString();
    }

    private StringBuilder stringTest_; 
    private int longTest_; 

}
package us.ihmc.idl.generated.IDLElement;
import us.ihmc.idl.IDLSequence;
import us.ihmc.idl.CDR;
import us.ihmc.idl.InterchangeSerializer;
import java.util.Arrays;

/**
* 
* Definition of the class "IDLElementTest" defined in IDLElementTest.idl. 
*
* This file was automatically generated from IDLElementTest.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit IDLElementTest.idl instead.
*
*/
public class IDLElementTest
{
    public IDLElementTest()
    {
        	nestedElementTest_ = new us.ihmc.idl.generated.IDLNestedElement.NestedElement();stringTest_ = new StringBuilder(255); 
        	longArray_ = new int[10];
        	nestedArray_ = new us.ihmc.idl.generated.IDLNestedElement.NestedElement[5][3];
        	for(int b = 0; b < nestedArray_.length; ++b)
        	{
        	    for(int c = 0; c < nestedArray_[b].length; ++c)
        	    {
        	        	nestedArray_[b][c] = new us.ihmc.idl.generated.IDLNestedElement.NestedElement();	
        	    }
        	}
        	stringArray_ = new StringBuilder[4];
        	for(int e = 0; e < stringArray_.length; ++e)
        	{
        	    	stringArray_[e] = new StringBuilder();	
        	}
        	charSeqTest_ = new IDLSequence.Char (25, "type_8");
        	wcharSeqTest_ = new IDLSequence.Char (25, "type_14");
        	octetSeqTest_ = new IDLSequence.Byte (25, "type_9");
        	shortSeqTest_ = new IDLSequence.Short (25, "type_1");
        	ushortSeqTest_ = new IDLSequence.Integer (25, "type_3");
        	longSeqTest_ = new IDLSequence.Integer (25, "type_2");
        	ulongSeqTest_ = new IDLSequence.Long (25, "type_4");
        	longlongSeqtest_ = new IDLSequence.Long (25, "type_11");
        	ulonglongSeqTest_ = new IDLSequence.Long (25, "type_12");
        	floatSeqTest_ = new IDLSequence.Float (25, "type_5");
        	doubleSeqTest_ = new IDLSequence.Double (25, "type_6");
        	booleanSeqTest_ = new IDLSequence.Boolean (25, "type_7");
        	nestedSeqTest_ = new IDLSequence.Object<us.ihmc.idl.generated.IDLNestedElement.NestedElement> (25, us.ihmc.idl.generated.IDLNestedElement.NestedElement.class, new us.ihmc.idl.generated.IDLNestedElement.NestedElementPubSubType());

        	stringSeqTest_ = new IDLSequence.StringBuilderHolder (25, "type_d");   
        
        
    }

    public void set(IDLElementTest other)
    {
        	charTest_ = other.charTest_;
        	wcharTest_ = other.wcharTest_;
        	octetTest_ = other.octetTest_;
        	shortTest_ = other.shortTest_;
        	ushortTest_ = other.ushortTest_;
        	longTest_ = other.longTest_;
        	ulongTest_ = other.ulongTest_;
        	longlongTest_ = other.longlongTest_;
        	ulonglongTest_ = other.ulonglongTest_;
        	floatTest_ = other.floatTest_;
        	doubleTest_ = other.doubleTest_;
        	booleanTest_ = other.booleanTest_;
        	colorTest_ = other.colorTest_;
           	us.ihmc.idl.generated.IDLNestedElement.NestedElementPubSubType.staticCopy(nestedElementTest_, other.nestedElementTest_);stringTest_.setLength(0);
        	stringTest_.append(other.stringTest_);
        	for(int g = 0; g < longArray_.length; ++g)
        	{
        	    	longArray_[g] = other.longArray_[g];	

        	}
        	
        	for(int i = 0; i < nestedArray_.length; ++i)
        	{
        	    for(int j = 0; j < nestedArray_[i].length; ++j)
        	    {
        	        	us.ihmc.idl.generated.IDLNestedElement.NestedElementPubSubType.staticCopy(nestedArray_[i][j], other.nestedArray_[i][j]);        	}
        	}
        	
        	for(int l = 0; l < stringArray_.length; ++l)
        	{
        	    	stringArray_[l].setLength(0);
        	    	stringArray_[l].append(other.stringArray_[l]);
        	}
        	
            charSeqTest_.set(other.charSeqTest_);	wcharSeqTest_.set(other.wcharSeqTest_);	octetSeqTest_.set(other.octetSeqTest_);	shortSeqTest_.set(other.shortSeqTest_);	ushortSeqTest_.set(other.ushortSeqTest_);	longSeqTest_.set(other.longSeqTest_);	ulongSeqTest_.set(other.ulongSeqTest_);	longlongSeqtest_.set(other.longlongSeqtest_);	ulonglongSeqTest_.set(other.ulonglongSeqTest_);	floatSeqTest_.set(other.floatSeqTest_);	doubleSeqTest_.set(other.doubleSeqTest_);	booleanSeqTest_.set(other.booleanSeqTest_);	nestedSeqTest_.set(other.nestedSeqTest_);	stringSeqTest_.set(other.stringSeqTest_);	
    }

    public void setCharTest(char charTest)
    {
        charTest_ = charTest;
    }

    public char getCharTest()
    {
        return charTest_;
    }

        
    public void setWcharTest(char wcharTest)
    {
        wcharTest_ = wcharTest;
    }

    public char getWcharTest()
    {
        return wcharTest_;
    }

        
    public void setOctetTest(byte octetTest)
    {
        octetTest_ = octetTest;
    }

    public byte getOctetTest()
    {
        return octetTest_;
    }

        
    public void setShortTest(short shortTest)
    {
        shortTest_ = shortTest;
    }

    public short getShortTest()
    {
        return shortTest_;
    }

        
    public void setUshortTest(int ushortTest)
    {
        ushortTest_ = ushortTest;
    }

    public int getUshortTest()
    {
        return ushortTest_;
    }

        
    public void setLongTest(int longTest)
    {
        longTest_ = longTest;
    }

    public int getLongTest()
    {
        return longTest_;
    }

        
    public void setUlongTest(long ulongTest)
    {
        ulongTest_ = ulongTest;
    }

    public long getUlongTest()
    {
        return ulongTest_;
    }

        
    public void setLonglongTest(long longlongTest)
    {
        longlongTest_ = longlongTest;
    }

    public long getLonglongTest()
    {
        return longlongTest_;
    }

        
    public void setUlonglongTest(long ulonglongTest)
    {
        ulonglongTest_ = ulonglongTest;
    }

    public long getUlonglongTest()
    {
        return ulonglongTest_;
    }

        
    public void setFloatTest(float floatTest)
    {
        floatTest_ = floatTest;
    }

    public float getFloatTest()
    {
        return floatTest_;
    }

        
    public void setDoubleTest(double doubleTest)
    {
        doubleTest_ = doubleTest;
    }

    public double getDoubleTest()
    {
        return doubleTest_;
    }

        
    public void setBooleanTest(boolean booleanTest)
    {
        booleanTest_ = booleanTest;
    }

    public boolean getBooleanTest()
    {
        return booleanTest_;
    }

        
    public void setColorTest(us.ihmc.idl.generated.IDLElement.Color colorTest)
    {
        colorTest_ = colorTest;
    }

    public us.ihmc.idl.generated.IDLElement.Color getColorTest()
    {
        return colorTest_;
    }

        

    public us.ihmc.idl.generated.IDLNestedElement.NestedElement getNestedElementTest()
    {
        return nestedElementTest_;
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

        

    public int[] getLongArray()
    {
        return longArray_;
    }

        

    public us.ihmc.idl.generated.IDLNestedElement.NestedElement[][] getNestedArray()
    {
        return nestedArray_;
    }

        

    public StringBuilder[] getStringArray()
    {
        return stringArray_;
    }

        

    public IDLSequence.Char  getCharSeqTest()
    {
        return charSeqTest_;
    }

        

    public IDLSequence.Char  getWcharSeqTest()
    {
        return wcharSeqTest_;
    }

        

    public IDLSequence.Byte  getOctetSeqTest()
    {
        return octetSeqTest_;
    }

        

    public IDLSequence.Short  getShortSeqTest()
    {
        return shortSeqTest_;
    }

        

    public IDLSequence.Integer  getUshortSeqTest()
    {
        return ushortSeqTest_;
    }

        

    public IDLSequence.Integer  getLongSeqTest()
    {
        return longSeqTest_;
    }

        

    public IDLSequence.Long  getUlongSeqTest()
    {
        return ulongSeqTest_;
    }

        

    public IDLSequence.Long  getLonglongSeqtest()
    {
        return longlongSeqtest_;
    }

        

    public IDLSequence.Long  getUlonglongSeqTest()
    {
        return ulonglongSeqTest_;
    }

        

    public IDLSequence.Float  getFloatSeqTest()
    {
        return floatSeqTest_;
    }

        

    public IDLSequence.Double  getDoubleSeqTest()
    {
        return doubleSeqTest_;
    }

        

    public IDLSequence.Boolean  getBooleanSeqTest()
    {
        return booleanSeqTest_;
    }

        

    public IDLSequence.Object<us.ihmc.idl.generated.IDLNestedElement.NestedElement>  getNestedSeqTest()
    {
        return nestedSeqTest_;
    }

        

    public IDLSequence.StringBuilderHolder  getStringSeqTest()
    {
        return stringSeqTest_;
    }

        




    @Override
    public boolean equals(Object other)
    {
        if(other == null) return false;
        if(other == this) return true;
        if(!(other instanceof IDLElementTest)) return false;
        IDLElementTest otherMyClass = (IDLElementTest)other;
        boolean returnedValue = true;

        returnedValue &= this.charTest_ == otherMyClass.charTest_;

                
        returnedValue &= this.wcharTest_ == otherMyClass.wcharTest_;

                
        returnedValue &= this.octetTest_ == otherMyClass.octetTest_;

                
        returnedValue &= this.shortTest_ == otherMyClass.shortTest_;

                
        returnedValue &= this.ushortTest_ == otherMyClass.ushortTest_;

                
        returnedValue &= this.longTest_ == otherMyClass.longTest_;

                
        returnedValue &= this.ulongTest_ == otherMyClass.ulongTest_;

                
        returnedValue &= this.longlongTest_ == otherMyClass.longlongTest_;

                
        returnedValue &= this.ulonglongTest_ == otherMyClass.ulonglongTest_;

                
        returnedValue &= this.floatTest_ == otherMyClass.floatTest_;

                
        returnedValue &= this.doubleTest_ == otherMyClass.doubleTest_;

                
        returnedValue &= this.booleanTest_ == otherMyClass.booleanTest_;

                
        returnedValue &= this.colorTest_ == otherMyClass.colorTest_;

                
        returnedValue &= this.nestedElementTest_.equals(otherMyClass.nestedElementTest_);
                
        returnedValue &= us.ihmc.idl.IDLTools.equals(this.stringTest_, otherMyClass.stringTest_);
                
                	for(int n = 0; n < longArray_.length; ++n)
                	{
                	    returnedValue &= this.longArray_[n] == otherMyClass.longArray_[n];

                	}        
                	for(int p = 0; p < nestedArray_.length; ++p)
                	{
                	    for(int q = 0; q < nestedArray_[p].length; ++q)
                	    {
                	        returnedValue &= nestedArray_[p][q].equals(otherMyClass.nestedArray_[p][q]);
                	    }
                	}        
                	for(int s = 0; s < stringArray_.length; ++s)
                	{
                	    returnedValue &= us.ihmc.idl.IDLTools.equals(this.stringArray_[s], otherMyClass.stringArray_[s]);}        
        returnedValue &= this.charSeqTest_.equals(otherMyClass.charSeqTest_);
                
        returnedValue &= this.wcharSeqTest_.equals(otherMyClass.wcharSeqTest_);
                
        returnedValue &= this.octetSeqTest_.equals(otherMyClass.octetSeqTest_);
                
        returnedValue &= this.shortSeqTest_.equals(otherMyClass.shortSeqTest_);
                
        returnedValue &= this.ushortSeqTest_.equals(otherMyClass.ushortSeqTest_);
                
        returnedValue &= this.longSeqTest_.equals(otherMyClass.longSeqTest_);
                
        returnedValue &= this.ulongSeqTest_.equals(otherMyClass.ulongSeqTest_);
                
        returnedValue &= this.longlongSeqtest_.equals(otherMyClass.longlongSeqtest_);
                
        returnedValue &= this.ulonglongSeqTest_.equals(otherMyClass.ulonglongSeqTest_);
                
        returnedValue &= this.floatSeqTest_.equals(otherMyClass.floatSeqTest_);
                
        returnedValue &= this.doubleSeqTest_.equals(otherMyClass.doubleSeqTest_);
                
        returnedValue &= this.booleanSeqTest_.equals(otherMyClass.booleanSeqTest_);
                
        returnedValue &= this.nestedSeqTest_.equals(otherMyClass.nestedSeqTest_);
                
        returnedValue &= this.stringSeqTest_.equals(otherMyClass.stringSeqTest_);
                

        return returnedValue;
    }
    
     @Override
    public String toString()
    {
		StringBuilder builder = new StringBuilder();
		
      	builder.append("IDLElementTest {");
        builder.append("charTest=");
        builder.append(this.charTest_);

                builder.append(", ");
        builder.append("wcharTest=");
        builder.append(this.wcharTest_);

                builder.append(", ");
        builder.append("octetTest=");
        builder.append(this.octetTest_);

                builder.append(", ");
        builder.append("shortTest=");
        builder.append(this.shortTest_);

                builder.append(", ");
        builder.append("ushortTest=");
        builder.append(this.ushortTest_);

                builder.append(", ");
        builder.append("longTest=");
        builder.append(this.longTest_);

                builder.append(", ");
        builder.append("ulongTest=");
        builder.append(this.ulongTest_);

                builder.append(", ");
        builder.append("longlongTest=");
        builder.append(this.longlongTest_);

                builder.append(", ");
        builder.append("ulonglongTest=");
        builder.append(this.ulonglongTest_);

                builder.append(", ");
        builder.append("floatTest=");
        builder.append(this.floatTest_);

                builder.append(", ");
        builder.append("doubleTest=");
        builder.append(this.doubleTest_);

                builder.append(", ");
        builder.append("booleanTest=");
        builder.append(this.booleanTest_);

                builder.append(", ");
        builder.append("colorTest=");
        builder.append(this.colorTest_);

                builder.append(", ");
        builder.append("nestedElementTest=");
        builder.append(this.nestedElementTest_);

                builder.append(", ");
        builder.append("stringTest=");
        builder.append(this.stringTest_);

                builder.append(", ");
        builder.append("longArray=");
        builder.append(Arrays.toString(this.longArray_));

                builder.append(", ");
        builder.append("nestedArray=");
        builder.append(Arrays.deepToString(this.nestedArray_));

                builder.append(", ");
        builder.append("stringArray=");
        builder.append(Arrays.toString(this.stringArray_));

                builder.append(", ");
        builder.append("charSeqTest=");
        builder.append(this.charSeqTest_);

                builder.append(", ");
        builder.append("wcharSeqTest=");
        builder.append(this.wcharSeqTest_);

                builder.append(", ");
        builder.append("octetSeqTest=");
        builder.append(this.octetSeqTest_);

                builder.append(", ");
        builder.append("shortSeqTest=");
        builder.append(this.shortSeqTest_);

                builder.append(", ");
        builder.append("ushortSeqTest=");
        builder.append(this.ushortSeqTest_);

                builder.append(", ");
        builder.append("longSeqTest=");
        builder.append(this.longSeqTest_);

                builder.append(", ");
        builder.append("ulongSeqTest=");
        builder.append(this.ulongSeqTest_);

                builder.append(", ");
        builder.append("longlongSeqtest=");
        builder.append(this.longlongSeqtest_);

                builder.append(", ");
        builder.append("ulonglongSeqTest=");
        builder.append(this.ulonglongSeqTest_);

                builder.append(", ");
        builder.append("floatSeqTest=");
        builder.append(this.floatSeqTest_);

                builder.append(", ");
        builder.append("doubleSeqTest=");
        builder.append(this.doubleSeqTest_);

                builder.append(", ");
        builder.append("booleanSeqTest=");
        builder.append(this.booleanSeqTest_);

                builder.append(", ");
        builder.append("nestedSeqTest=");
        builder.append(this.nestedSeqTest_);

                builder.append(", ");
        builder.append("stringSeqTest=");
        builder.append(this.stringSeqTest_);

                
        builder.append("}");
		return builder.toString();
    }

    private char charTest_; 
    private char wcharTest_; 
    private byte octetTest_; 
    private short shortTest_; 
    private int ushortTest_; 
    private int longTest_; 
    private long ulongTest_; 
    private long longlongTest_; 
    private long ulonglongTest_; 
    private float floatTest_; 
    private double doubleTest_; 
    private boolean booleanTest_; 
    private us.ihmc.idl.generated.IDLElement.Color colorTest_; 
    private us.ihmc.idl.generated.IDLNestedElement.NestedElement nestedElementTest_; 
    private StringBuilder stringTest_; 
    private int[] longArray_; 
    private us.ihmc.idl.generated.IDLNestedElement.NestedElement[][] nestedArray_; 
    private StringBuilder[] stringArray_; 
    private IDLSequence.Char  charSeqTest_; 
    private IDLSequence.Char  wcharSeqTest_; 
    private IDLSequence.Byte  octetSeqTest_; 
    private IDLSequence.Short  shortSeqTest_; 
    private IDLSequence.Integer  ushortSeqTest_; 
    private IDLSequence.Integer  longSeqTest_; 
    private IDLSequence.Long  ulongSeqTest_; 
    private IDLSequence.Long  longlongSeqtest_; 
    private IDLSequence.Long  ulonglongSeqTest_; 
    private IDLSequence.Float  floatSeqTest_; 
    private IDLSequence.Double  doubleSeqTest_; 
    private IDLSequence.Boolean  booleanSeqTest_; 
    private IDLSequence.Object<us.ihmc.idl.generated.IDLNestedElement.NestedElement>  nestedSeqTest_; 
    private IDLSequence.StringBuilderHolder  stringSeqTest_; 

}
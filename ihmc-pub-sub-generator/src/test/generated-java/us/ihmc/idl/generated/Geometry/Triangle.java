package us.ihmc.idl.generated.Geometry;
/**
* 
* Definition of the class "Triangle" defined in Vector.idl. 
*
* This file was automatically generated from Vector.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit Vector.idl instead.
*
*/
public class Triangle
{
    public Triangle()
    {
        	points_ = new java.lang.Object[3];
        	for(int b = 0; b < points_.length; ++b)
        	{
        	    	points_[b] = new java.lang.Object();	
        	}
        
        
    }

    public void set(Triangle other)
    {
        	for(int d = 0; d < points_.length; ++d)
        	{
        	    	us.ihmc.idl.generated.Geometry.VectorPubSubType.staticCopy(other.points_[d], points_[d]);        	}
        	
    }


    public java.lang.Object[] getPoints()
    {
        return points_;
    }

        




    @Override
    public boolean equals(java.lang.Object other)
    {
        if(other == null) return false;
        if(other == this) return true;
        if(!(other instanceof Triangle)) return false;
        Triangle otherMyClass = (Triangle)other;
        boolean returnedValue = true;

                	for(int f = 0; f < points_.length; ++f)
                	{
                	    returnedValue &= points_[f].equals(otherMyClass.points_[f]);
                	}        

        return returnedValue;
    }
    
     @Override
    public java.lang.String toString()
    {
		StringBuilder builder = new StringBuilder();
		
      	builder.append("Triangle {");
        builder.append("points=");
        builder.append(java.util.Arrays.toString(this.points_));

                
        builder.append("}");
		return builder.toString();
    }

    private java.lang.Object[] points_; 

}
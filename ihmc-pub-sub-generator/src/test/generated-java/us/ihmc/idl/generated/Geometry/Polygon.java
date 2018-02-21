package us.ihmc.idl.generated.Geometry;
/**
* 
* Definition of the class "Polygon" defined in Vector.idl. 
*
* This file was automatically generated from Vector.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit Vector.idl instead.
*
*/
public class Polygon
{
    public Polygon()
    {
        	points_ = new us.ihmc.idl.IDLSequence.Object<java.lang.Object> (100, java.lang.Object.class, new us.ihmc.idl.generated.Geometry.VectorPubSubType());


        
        
    }

    public void set(Polygon other)
    {
            points_.set(other.points_);	
    }


    public us.ihmc.idl.IDLSequence.Object<java.lang.Object>  getPoints()
    {
        return points_;
    }

        




    @Override
    public boolean equals(java.lang.Object other)
    {
        if(other == null) return false;
        if(other == this) return true;
        if(!(other instanceof Polygon)) return false;
        Polygon otherMyClass = (Polygon)other;
        boolean returnedValue = true;

        returnedValue &= this.points_.equals(otherMyClass.points_);
                

        return returnedValue;
    }
    
     @Override
    public java.lang.String toString()
    {
		StringBuilder builder = new StringBuilder();
		
      	builder.append("Polygon {");
        builder.append("points=");
        builder.append(this.points_);

                
        builder.append("}");
		return builder.toString();
    }

    private us.ihmc.idl.IDLSequence.Object<java.lang.Object>  points_; 

}
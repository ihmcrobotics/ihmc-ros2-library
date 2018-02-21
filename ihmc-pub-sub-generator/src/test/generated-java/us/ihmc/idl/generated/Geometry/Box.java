package us.ihmc.idl.generated.Geometry;
/**
* 
* Definition of the class "Box" defined in Vector.idl. 
*
* This file was automatically generated from Vector.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit Vector.idl instead.
*
*/
public class Box
{
    public Box()
    {
        	center_ = new java.lang.Object();        
        
    }

    public void set(Box other)
    {
           	us.ihmc.idl.generated.Geometry.VectorPubSubType.staticCopy(other.center_, center_);w_ = other.w_;
        	l_ = other.l_;
        	h_ = other.h_;

    }


    public java.lang.Object getCenter()
    {
        return center_;
    }

        
    public void setW(double w)
    {
        w_ = w;
    }

    public double getW()
    {
        return w_;
    }

        
    public void setL(double l)
    {
        l_ = l;
    }

    public double getL()
    {
        return l_;
    }

        
    public void setH(double h)
    {
        h_ = h;
    }

    public double getH()
    {
        return h_;
    }

        




    @Override
    public boolean equals(java.lang.Object other)
    {
        if(other == null) return false;
        if(other == this) return true;
        if(!(other instanceof Box)) return false;
        Box otherMyClass = (Box)other;
        boolean returnedValue = true;

        returnedValue &= this.center_.equals(otherMyClass.center_);
                
        returnedValue &= this.w_ == otherMyClass.w_;

                
        returnedValue &= this.l_ == otherMyClass.l_;

                
        returnedValue &= this.h_ == otherMyClass.h_;

                

        return returnedValue;
    }
    
     @Override
    public java.lang.String toString()
    {
		StringBuilder builder = new StringBuilder();
		
      	builder.append("Box {");
        builder.append("center=");
        builder.append(this.center_);

                builder.append(", ");
        builder.append("w=");
        builder.append(this.w_);

                builder.append(", ");
        builder.append("l=");
        builder.append(this.l_);

                builder.append(", ");
        builder.append("h=");
        builder.append(this.h_);

                
        builder.append("}");
		return builder.toString();
    }

    private java.lang.Object center_; 
    private double w_; 
    private double l_; 
    private double h_; 

}
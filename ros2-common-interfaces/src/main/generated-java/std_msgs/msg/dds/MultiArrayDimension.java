package std_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Definition of the class "MultiArrayDimension" defined in MultiArrayDimension_.idl.
 *
 * This file was automatically generated from MultiArrayDimension_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit MultiArrayDimension_.idl instead.
 */
public class MultiArrayDimension implements Settable<MultiArrayDimension>, EpsilonComparable<MultiArrayDimension>
{
   private java.lang.StringBuilder label_;
   private long size_;
   private long stride_;

   public MultiArrayDimension()
   {
      label_ = new java.lang.StringBuilder(255);
   }

   public MultiArrayDimension(MultiArrayDimension other)
   {
      set(other);
   }

   public void set(MultiArrayDimension other)
   {
      label_.setLength(0);
      label_.append(other.label_);

      size_ = other.size_;

      stride_ = other.stride_;
   }

   public java.lang.String getLabelAsString()
   {
      return getLabel().toString();
   }

   public java.lang.StringBuilder getLabel()
   {
      return label_;
   }

   public void setLabel(String label)
   {
      label_.setLength(0);
      label_.append(label);
   }

   public long getSize()
   {
      return size_;
   }

   public void setSize(long size)
   {
      size_ = size;
   }

   public long getStride()
   {
      return stride_;
   }

   public void setStride(long stride)
   {
      stride_ = stride;
   }

   @Override
   public boolean epsilonEquals(MultiArrayDimension other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(this.label_, other.label_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.size_, other.size_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.stride_, other.stride_, epsilon))
         return false;

      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;
      if (!(other instanceof MultiArrayDimension))
         return false;

      MultiArrayDimension otherMyClass = (MultiArrayDimension) other;

      if (!us.ihmc.idl.IDLTools.equals(this.label_, otherMyClass.label_))
         return false;

      if (this.size_ != otherMyClass.size_)
         return false;

      if (this.stride_ != otherMyClass.stride_)
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("MultiArrayDimension {");
      builder.append("label=");
      builder.append(this.label_);

      builder.append(", ");
      builder.append("size=");
      builder.append(this.size_);

      builder.append(", ");
      builder.append("stride=");
      builder.append(this.stride_);

      builder.append("}");
      return builder.toString();
   }
}
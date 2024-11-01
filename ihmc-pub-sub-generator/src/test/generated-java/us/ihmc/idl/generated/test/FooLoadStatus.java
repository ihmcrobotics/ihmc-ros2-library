package us.ihmc.idl.generated.test;

/**
* 
* Definition of the enum "FooLoadStatus" defined in FooHandshake.idl. 
*
* This file was automatically generated from FooHandshake.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit FooHandshake.idl instead.
*
*/
import us.ihmc.idl.IDLTools;

public enum FooLoadStatus
{
         FooNoParameter,
      
         FooUnloaded,
      
         FooDefault,
      
         FooLoaded,
      
   ;
   public static FooLoadStatus[] values = values();

   public boolean epsilonEquals(FooLoadStatus other, double epsilon)
   {
      return IDLTools.epsilonEqualsEnum(this, other, epsilon);
   }
}
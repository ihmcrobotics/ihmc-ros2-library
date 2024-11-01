package us.ihmc.idl.generated.test;

/**
* 
* Definition of the enum "FooYoType" defined in FooHandshake.idl. 
*
* This file was automatically generated from FooHandshake.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit FooHandshake.idl instead.
*
*/
import us.ihmc.idl.IDLTools;

public enum FooYoType
{
         FooDoubleYoVariable,
      
         FooBooleanYoVariable,
      
         FooIntegerYoVariable,
      
         FooLongYoVariable,
      
         FooEnumYoVariable,
      
   ;
   public static FooYoType[] values = values();

   public boolean epsilonEquals(FooYoType other, double epsilon)
   {
      return IDLTools.epsilonEqualsEnum(this, other, epsilon);
   }
}
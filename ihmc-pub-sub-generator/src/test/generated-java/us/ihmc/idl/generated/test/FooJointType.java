package us.ihmc.idl.generated.test;

/**
* 
* Definition of the enum "FooJointType" defined in FooHandshake.idl. 
*
* This file was automatically generated from FooHandshake.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit FooHandshake.idl instead.
*
*/
import us.ihmc.idl.IDLTools;

public enum FooJointType
{
         FooSiXDoFJoint,
      
         FooOneDoFJoint,
      
   ;
   public static FooJointType[] values = values();

   public boolean epsilonEquals(FooJointType other, double epsilon)
   {
      return IDLTools.epsilonEqualsEnum(this, other, epsilon);
   }
}
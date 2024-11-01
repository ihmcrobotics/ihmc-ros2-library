package us.ihmc.idl.generated.test;

/**
* 
* Definition of the enum "Color" defined in IDLElementTest.idl. 
*
* This file was automatically generated from IDLElementTest.idl by us.ihmc.idl.generator.IDLGenerator. 
* Do not update this file directly, edit IDLElementTest.idl instead.
*
*/
import us.ihmc.idl.IDLTools;

public enum Color
{
         red,
      
         green,
      
         blue,
      
   ;
   public static Color[] values = values();

   public boolean epsilonEquals(Color other, double epsilon)
   {
      return IDLTools.epsilonEqualsEnum(this, other, epsilon);
   }
}
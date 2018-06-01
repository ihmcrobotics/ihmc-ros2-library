package us.ihmc.idl;

import org.junit.Test;
import us.ihmc.idl.IDLSequence;

import static org.junit.Assert.*;

public class StringBuilderHolderTest
{
   @Test(timeout = 30000)
   public void testStringBuilderHolder()
   {
      IDLSequence.StringBuilderHolder a = new IDLSequence.StringBuilderHolder(10, "type_d");
      IDLSequence.StringBuilderHolder b = new IDLSequence.StringBuilderHolder(10, "type_d");

      a.add("a1");
      a.add("a2");
      a.add("a3");
      a.add("a4");
      a.add("a5");

      b.add("b1");
      b.add("b2");
      b.add("b3");
      b.add("b4");
      b.add("b5");
      b.add("b6");

      a.set(b);

      System.out.println(a);

      assertTrue(a.get(0).toString().equals("b1"));
      assertTrue(a.get(1).toString().equals("b2"));
      assertTrue(a.get(2).toString().equals("b3"));
      assertTrue(a.get(3).toString().equals("b4"));
      assertTrue(a.get(4).toString().equals("b5"));
      assertTrue(a.get(5).toString().equals("b6"));
   }
}
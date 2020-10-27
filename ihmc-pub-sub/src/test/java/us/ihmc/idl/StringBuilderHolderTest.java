package us.ihmc.idl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringBuilderHolderTest
{
   @Test// timeout = 30000
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

      assertEquals("b1", a.get(0).toString());
      assertEquals("b2", a.get(1).toString());
      assertEquals("b3", a.get(2).toString());
      assertEquals("b4", a.get(3).toString());
      assertEquals("b5", a.get(4).toString());
      assertEquals("b6", a.get(5).toString());
   }
}
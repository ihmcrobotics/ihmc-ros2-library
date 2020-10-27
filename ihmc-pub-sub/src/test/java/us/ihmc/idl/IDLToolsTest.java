package us.ihmc.idl;

import org.junit.jupiter.api.Test;
import us.ihmc.commons.MutationTestFacilitator;
import us.ihmc.idl.IDLSequence.Byte;
import us.ihmc.idl.IDLSequence.Char;
import us.ihmc.idl.IDLSequence.Double;
import us.ihmc.idl.IDLSequence.Enum;
import us.ihmc.idl.IDLSequence.Float;
import us.ihmc.idl.IDLSequence.Integer;
import us.ihmc.idl.IDLSequence.Long;
import us.ihmc.idl.IDLSequence.Short;
import us.ihmc.idl.IDLSequence.StringBuilderHolder;
import us.ihmc.idl.IDLSequence.Boolean;

import static org.junit.jupiter.api.Assertions.*;

public class IDLToolsTest
{
   @Test// timeout = 30000
   public void testStringBuilderEquals()
   {
      assertTrue(IDLTools.equals(new StringBuilder("hi"), new StringBuilder("hi")), "StringBuilders not equal");
      assertTrue(IDLTools.equals(new StringBuilder("a"), new StringBuilder("a")), "StringBuilders not equal");
      assertFalse(IDLTools.equals(new StringBuilder("hi"), new StringBuilder("bye")), "StringBuilders equal");
      assertFalse(IDLTools.equals(new StringBuilder("bii"), new StringBuilder("bye")), "StringBuilders equal");
      assertFalse(IDLTools.equals(new StringBuilder("hii"), new StringBuilder("bye")), "StringBuilders equal");
      assertFalse(IDLTools.equals(new StringBuilder("a"), new StringBuilder("b")), "StringBuilders equal");
   }

   @Test// timeout = 30000
   public void testStringBuilderEpsilonEquals()
   {
      assertTrue(IDLTools.epsilonEqualsStringBuilder(new StringBuilder("hi"), new StringBuilder("hi"), 0.0),
                                                  "StringBuilders not equal");
      assertFalse(IDLTools.epsilonEqualsStringBuilder(new StringBuilder("hi"), new StringBuilder("bye"), 0.0),
                                                   "StringBuilders equal");
   }

   @Test// timeout = 30000
   public void testEpsilonEqualsBoolean()
   {
      assertTrue(IDLTools.epsilonEqualsBoolean(true, true, 0.0), "Booleans not equal");
      assertTrue(IDLTools.epsilonEqualsBoolean(false, false, 0.0), "Booleans not equal");
      assertFalse(IDLTools.epsilonEqualsBoolean(true, false, 0.0), "Booleans equal");
   }

   @Test// timeout = 30000
   public void testEpsilonEquals()
   {
      assertTrue(IDLTools.epsilonEquals(0.0, 0.0, 0.0), "Doubles not equal");
      assertTrue(IDLTools.epsilonEquals(0.1, 0.2, 0.1), "Doubles not equal");
      assertFalse(IDLTools.epsilonEquals(0.0, 0.1, 0.05), "Doubles equal");
      assertFalse(IDLTools.epsilonEquals(0.0, 5.0, 1.0), "Doubles equal");
      assertFalse(IDLTools.epsilonEquals(0.0, 5.0, 0.0), "Doubles equal");
      assertTrue(IDLTools.epsilonEqualsPrimitive(0.0, 0.0, 0.0), "Doubles not equal");
      assertTrue(IDLTools.epsilonEqualsPrimitive(0.1, 0.2, 0.1), "Doubles not equal");
      assertFalse(IDLTools.epsilonEqualsPrimitive(0.0, 0.1, 0.05), "Doubles equal");
      assertFalse(IDLTools.epsilonEqualsPrimitive(0.0, 5.0, 1.0), "Doubles equal");
      assertFalse(IDLTools.epsilonEqualsPrimitive(0.0, 5.0, 0.0), "Doubles equal");
   }

   private enum SampleEnum { ONE, TWO }

   @Test// timeout = 30000
   public void testEpsilonEqualsEnum()
   {
      assertTrue(IDLTools.epsilonEqualsEnum(SampleEnum.ONE, SampleEnum.ONE, 0.0), "Enums not equal");
      assertTrue(IDLTools.epsilonEqualsEnum(SampleEnum.TWO, SampleEnum.TWO, 0.0), "Enums not equal");
      assertFalse(IDLTools.epsilonEqualsEnum(SampleEnum.ONE, SampleEnum.TWO, 0.0), "Enums equal");
   }

   @Test// timeout = 30000
   public void testStringBuilderEpsilonEqualsSequence()
   {
      StringBuilderHolder a;
      StringBuilderHolder b;

      a = new StringBuilderHolder(10, "type_d");
      b = new StringBuilderHolder(10, "type_d");
      assertTrue(IDLTools.epsilonEqualsStringBuilderSequence(a, b, 0.0), "Sequences not equal");

      a = new StringBuilderHolder(5, "type_d");
      b = new StringBuilderHolder(10, "type_d");
      assertTrue(IDLTools.epsilonEqualsStringBuilderSequence(a, b, 0.0), "Sequences not equal");

      a = new StringBuilderHolder(5, "type_d");
      b = new StringBuilderHolder(10, "type_d");
      a.add("blah");
      assertFalse(IDLTools.epsilonEqualsStringBuilderSequence(a, b, 0.0), "Sequences equal");

      a = new StringBuilderHolder(10, "type_d");
      b = new StringBuilderHolder(10, "type_d");
      a.add("one");
      b.add("one");
      assertTrue(IDLTools.epsilonEqualsStringBuilderSequence(a, b, 0.0), "Sequences not equal");

      a = new StringBuilderHolder(5, "type_d");
      b = new StringBuilderHolder(10, "type_d");
      a.add("one");
      b.add("two");
      assertFalse(IDLTools.epsilonEqualsStringBuilderSequence(a, b, 0.0), "Sequences equal");

      a = new StringBuilderHolder(10, "type_d");
      b = new StringBuilderHolder(10, "type_d");
      a.add("one");
      a.add("two");
      a.add("thr");
      b.add("one");
      b.add("two");
      b.add("thr");
      assertTrue(IDLTools.epsilonEqualsStringBuilderSequence(a, b, 0.0), "Sequences not equal");

      a = new StringBuilderHolder(5, "type_d");
      b = new StringBuilderHolder(10, "type_d");
      a.add("one");
      a.add("one");
      b.add("one");
      b.add("two");
      assertFalse(IDLTools.epsilonEqualsStringBuilderSequence(a, b, 0.0), "Sequences equal");
   }

   @Test// timeout = 30000
   public void testEpsilonEqualsEnumSequence()
   {
      Enum<SampleEnum> a;
      Enum<SampleEnum> b;

      a = new Enum<>(10, SampleEnum.class, SampleEnum.values());
      b = new Enum<>(10, SampleEnum.class, SampleEnum.values());
      assertTrue(IDLTools.epsilonEqualsEnumSequence(a, b, 0.0), "Sequences not equal");

      a = new Enum<>(5, SampleEnum.class, SampleEnum.values());
      b = new Enum<>(10, SampleEnum.class, SampleEnum.values());
      assertTrue(IDLTools.epsilonEqualsEnumSequence(a, b, 0.0), "Sequences not equal");

      a = new Enum<>(5, SampleEnum.class, SampleEnum.values());
      b = new Enum<>(10, SampleEnum.class, SampleEnum.values());
      a.add(SampleEnum.ONE);
      assertFalse(IDLTools.epsilonEqualsEnumSequence(a, b, 0.0), "Sequences equal");

      a = new Enum<>(10, SampleEnum.class, SampleEnum.values());
      b = new Enum<>(10, SampleEnum.class, SampleEnum.values());
      a.add(SampleEnum.ONE);
      b.add(SampleEnum.ONE);
      assertTrue(IDLTools.epsilonEqualsEnumSequence(a, b, 0.0), "Sequences not equal");

      a = new Enum<>(5, SampleEnum.class, SampleEnum.values());
      b = new Enum<>(10, SampleEnum.class, SampleEnum.values());
      a.add(SampleEnum.ONE);
      b.add(SampleEnum.TWO);
      assertFalse(IDLTools.epsilonEqualsEnumSequence(a, b, 0.0), "Sequences equal");

      a = new Enum<>(10, SampleEnum.class, SampleEnum.values());
      b = new Enum<>(10, SampleEnum.class, SampleEnum.values());
      a.add(SampleEnum.ONE);
      a.add(SampleEnum.TWO);
      a.add(SampleEnum.TWO);
      b.add(SampleEnum.ONE);
      b.add(SampleEnum.TWO);
      b.add(SampleEnum.TWO);
      assertTrue(IDLTools.epsilonEqualsEnumSequence(a, b, 0.0), "Sequences not equal");

      a = new Enum<>(5, SampleEnum.class, SampleEnum.values());
      b = new Enum<>(10, SampleEnum.class, SampleEnum.values());
      a.add(SampleEnum.ONE);
      a.add(SampleEnum.ONE);
      b.add(SampleEnum.ONE);
      b.add(SampleEnum.TWO);
      assertFalse(IDLTools.epsilonEqualsEnumSequence(a, b, 0.0), "Sequences equal");
   }

   @Test// timeout = 30000
   public void testEpsilonEqualsSequenceBoolean()
   {
      Boolean a;
      Boolean b;

      a = new Boolean(10, "type_7");
      b = new Boolean(10, "type_7");
      assertTrue(IDLTools.epsilonEqualsBooleanSequence(a, b, 0.0), "Sequences not equal");

      a = new Boolean(5, "type_7");
      b = new Boolean(10, "type_7");
      assertTrue(IDLTools.epsilonEqualsBooleanSequence(a, b, 0.0), "Sequences not equal");

      a = new Boolean(5, "type_7");
      b = new Boolean(10, "type_7");
      a.add(true);
      assertFalse(IDLTools.epsilonEqualsBooleanSequence(a, b, 0.0), "Sequences equal");

      a = new Boolean(10, "type_7");
      b = new Boolean(10, "type_7");
      a.add(true);
      b.add(true);
      assertTrue(IDLTools.epsilonEqualsBooleanSequence(a, b, 0.0), "Sequences not equal");

      a = new Boolean(5, "type_7");
      b = new Boolean(10, "type_7");
      a.add(true);
      b.add(false);
      assertFalse(IDLTools.epsilonEqualsBooleanSequence(a, b, 0.0), "Sequences equal");

      a = new Boolean(10, "type_7");
      b = new Boolean(10, "type_7");
      a.add(true);
      a.add(false);
      a.add(true);
      b.add(true);
      b.add(false);
      b.add(true);
      assertTrue(IDLTools.epsilonEqualsBooleanSequence(a, b, 0.0), "Sequences not equal");

      a = new Boolean(5, "type_7");
      b = new Boolean(10, "type_7");
      a.add(true);
      a.add(true);
      b.add(true);
      b.add(false);
      assertFalse(IDLTools.epsilonEqualsBooleanSequence(a, b, 0.0), "Sequences equal");
   }

   @Test// timeout = 30000
   public void testEpsilonEqualsSequenceByte()
   {
      Byte a;
      Byte b;

      a = new Byte(10, "type_9");
      b = new Byte(10, "type_9");
      assertTrue(IDLTools.epsilonEqualsByteSequence(a, b, 0.0), "Sequences not equal");

      a = new Byte(5, "type_9");
      b = new Byte(10, "type_9");
      assertTrue(IDLTools.epsilonEqualsByteSequence(a, b, 0.0), "Sequences not equal");

      a = new Byte(5, "type_9");
      b = new Byte(10, "type_9");
      a.add((byte) 0);
      assertFalse(IDLTools.epsilonEqualsByteSequence(a, b, 0.0), "Sequences equal");

      a = new Byte(10, "type_9");
      b = new Byte(10, "type_9");
      a.add((byte) 0);
      b.add((byte) 0);
      assertTrue(IDLTools.epsilonEqualsByteSequence(a, b, 0.0), "Sequences not equal");

      a = new Byte(5, "type_9");
      b = new Byte(10, "type_9");
      a.add((byte) 0);
      b.add((byte) 255);
      assertFalse(IDLTools.epsilonEqualsByteSequence(a, b, 0.0), "Sequences equal");

      a = new Byte(10, "type_9");
      b = new Byte(10, "type_9");
      a.add((byte) 0);
      a.add((byte) 255);
      a.add((byte) 255);
      b.add((byte) 0);
      b.add((byte) 255);
      b.add((byte) -1);
      assertTrue(IDLTools.epsilonEqualsByteSequence(a, b, 0.0), "Sequences not equal");

      a = new Byte(5, "type_9");
      b = new Byte(10, "type_9");
      a.add((byte) 0);
      a.add((byte) 0);
      b.add((byte) 0);
      b.add((byte) 255);
      assertFalse(IDLTools.epsilonEqualsByteSequence(a, b, 0.0), "Sequences equal");
   }

   @Test// timeout = 30000
   public void testEpsilonEqualsSequenceChar()
   {
      Char a;
      Char b;
      a = new Char(10, "type_8");
      b = new Char(10, "type_8");
      a.add('a');
      a.add('b');
      a.add('c');
      b.add('a');
      b.add('b');
      b.add('c');
      assertTrue(IDLTools.epsilonEqualsCharSequence(a, b, 0.0), "Sequences not equal");

      a = new Char(5, "type_8");
      b = new Char(10, "type_8");
      a.add('a');
      a.add('a');
      b.add('a');
      b.add('b');
      assertFalse(IDLTools.epsilonEqualsCharSequence(a, b, 0.0), "Sequences equal");
   }

   @Test// timeout = 30000
   public void testEpsilonEqualsSequenceShort()
   {
      Short a;
      Short b;
      a = new Short(10, "type_1");
      b = new Short(10, "type_1");
      a.add((short) 0);
      a.add((short) 4);
      a.add((short) -1);
      b.add((short) 0);
      b.add((short) 4);
      b.add((short) -1);
      assertTrue(IDLTools.epsilonEqualsShortSequence(a, b, 0.0), "Sequences not equal");

      a = new Short(5, "type_1");
      b = new Short(10, "type_1");
      a.add((short) 0);
      a.add((short) 0);
      b.add((short) 0);
      b.add((short) 4);
      assertFalse(IDLTools.epsilonEqualsShortSequence(a, b, 0.0), "Sequences equal");
   }

   @Test// timeout = 30000
   public void testEpsilonEqualsSequenceInteger()
   {
      Integer a;
      Integer b;
      a = new Integer(10, "type_2");
      b = new Integer(10, "type_2");
      a.add(0);
      a.add(4);
      a.add(-1);
      b.add(0);
      b.add(4);
      b.add(-1);
      assertTrue(IDLTools.epsilonEqualsIntegerSequence(a, b, 0.0), "Sequences not equal");

      a = new Integer(5, "type_2");
      b = new Integer(10, "type_2");
      a.add(0);
      a.add(0);
      b.add(0);
      b.add(4);
      assertFalse(IDLTools.epsilonEqualsIntegerSequence(a, b, 0.0), "Sequences equal");
   }

   @Test// timeout = 30000
   public void testEpsilonEqualsSequenceLong()
   {
      Long a;
      Long b;
      a = new Long(10, "type_11");
      b = new Long(10, "type_11");
      a.add((long) 0);
      a.add((long) 4);
      a.add((long) -1);
      b.add((long) 0);
      b.add((long) 4);
      b.add((long) -1);
      assertTrue(IDLTools.epsilonEqualsLongSequence(a, b, 0.0), "Sequences not equal");

      a = new Long(5, "type_11");
      b = new Long(10, "type_11");
      a.add((long) 0);
      a.add((long) 0);
      b.add((long) 0);
      b.add((long) 4);
      assertFalse(IDLTools.epsilonEqualsLongSequence(a, b, 0.0), "Sequences equal");
   }

   @Test// timeout = 30000
   public void testEpsilonEqualsSequenceFloat()
   {
      Float a;
      Float b;
      a = new Float(10, "type_5");
      b = new Float(10, "type_5");
      a.add((float) 0);
      a.add((float) 4);
      a.add((float) -1);
      b.add((float) 0);
      b.add((float) 4);
      b.add((float) -1);
      assertTrue(IDLTools.epsilonEqualsFloatSequence(a, b, 0.0), "Sequences not equal");

      a = new Float(5, "type_5");
      b = new Float(10, "type_5");
      a.add((float) 0);
      a.add((float) 0);
      b.add((float) 0);
      b.add((float) 4);
      assertFalse(IDLTools.epsilonEqualsFloatSequence(a, b, 0.0), "Sequences equal");
   }

   @Test// timeout = 30000
   public void testEpsilonEqualsSequenceDouble()
   {
      Double a;
      Double b;
      a = new Double(10, "type_6");
      b = new Double(10, "type_6");
      a.add(0.0);
      a.add(1.5);
      a.add(-3.0);
      b.add(0.0);
      b.add(1.5);
      b.add(-3.0);
      assertTrue(IDLTools.epsilonEqualsDoubleSequence(a, b, 0.0), "Sequences not equal");

      a = new Double(5, "type_6");
      b = new Double(10, "type_6");
      a.add(0.0);
      a.add(0.0);
      b.add(0.0);
      b.add(1.5);
      assertFalse(IDLTools.epsilonEqualsDoubleSequence(a, b, 0.0), "Sequences equal");
   }

   public static void main(String[] args)
   {
      MutationTestFacilitator.facilitateMutationTestForClass(IDLTools.class, IDLToolsTest.class);
   }
}

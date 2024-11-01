package us.ihmc.pubsub.test;

import org.junit.jupiter.api.Test;
import us.ihmc.idl.generated.test.Color;
import us.ihmc.idl.generated.test.IDLElementTest;

import static org.junit.jupiter.api.Assertions.*;

public class MessageEqualsTest
{
   @Test// timeout = 30000
   public void testEmptyMessagesEqual()
   {
      IDLElementTest a = new IDLElementTest();
      IDLElementTest b = new IDLElementTest();

      assertTrue(a.equals(b), "not equal");
      assertTrue(a.epsilonEquals(b, 0.0), "not equal");
   }

   @Test// timeout = 30000
   public void testMessagesNotEqual1()
   {
      IDLElementTest a = new IDLElementTest();
      IDLElementTest b = new IDLElementTest();

      a.setBooleanTest(true);
      b.setBooleanTest(false);

      assertFalse(a.equals(b), "is equal");
      assertFalse(a.epsilonEquals(b, 0.0), "is equal");
   }

   @Test// timeout = 30000
   public void testFullMessagesEqual()
   {
      IDLElementTest a = new IDLElementTest();
      IDLElementTest b = new IDLElementTest();

      createFullMessage(a);
      createFullMessage(b);

      assertTrue(a.equals(b), "not equal");
      assertTrue(a.epsilonEquals(b, 0.0), "not equal");
   }

   @Test// timeout = 30000
   public void testMessagesNotEqual2()
   {
      IDLElementTest a = new IDLElementTest();
      IDLElementTest b = new IDLElementTest();

      createFullMessage(a);
      createFullMessage(b);

      a.getEnumSeqTest().remove();
      a.getEnumSeqTest().add(Color.green);

      assertFalse(a.equals(b), "is equal");
      assertFalse(a.epsilonEquals(b, 0.0), "is equal");
   }

   @Test// timeout = 30000
   public void testMessagesNotEqual3()
   {
      IDLElementTest a = new IDLElementTest();
      IDLElementTest b = new IDLElementTest();

      createFullMessage(a);
      createFullMessage(b);

      a.getNestedArray()[1][2].setLongTest(1);
      b.getNestedArray()[1][2].setLongTest(2);

      assertFalse(a.equals(b), "is equal");
      assertFalse(a.epsilonEquals(b, 0.5), "is equal");
   }

   @Test// timeout = 30000
   public void testMessagesEqual3()
   {
      IDLElementTest a = new IDLElementTest();
      IDLElementTest b = new IDLElementTest();

      createFullMessage(a);
      createFullMessage(b);

      a.getNestedArray()[1][2].setLongTest(1);
      b.getNestedArray()[1][2].setLongTest(2);

      assertFalse(a.equals(b), "not equal");
      assertTrue(a.epsilonEquals(b, 1.0), "not equal");
   }

   @Test// timeout = 30000
   public void testCopyConstructor()
   {
      IDLElementTest a = new IDLElementTest();
      createFullMessage(a);
      IDLElementTest b = new IDLElementTest(a);
      assertTrue(a.equals(b), "not equal");
      assertTrue(a.epsilonEquals(b, 0.0), "not equal");
   }

   private void createFullMessage(IDLElementTest a)
   {
      a.setCharTest('a');
      a.setWcharTest('b');
      a.setOctetTest((byte) -1);
      a.setShortTest((short) -2);
      a.setUshortTest(3);
      a.setLongTest(-4);
      a.setUlongTest(5);
      a.setLonglongTest(-6L);
      a.setUlonglongTest(7L);
      a.setFloatTest(8f);
      a.setDoubleTest(9.1);
      a.setBooleanTest(true);
      a.setColorTest(Color.red);
      a.getNestedElementTest().setStringTest("hi");
      a.getNestedElementTest().setLongTest(5);
      a.setStringTest("hi");
      for (int i = 0; i < a.getLongArray().length; i++)
      {
         a.getLongArray()[i] = i;
      }
      for (int i = 0; i < a.getNestedArray().length; i++)
      {
         for (int j = 0; j < a.getNestedArray()[i].length; j++)
         {
            a.getNestedArray()[i][j].setStringTest("foo");
            a.getNestedArray()[i][j].setLongTest(j * i);
         }
      }
      for (int i = 0; i < a.getStringArray().length; i++)
      {
         a.getStringArray()[i] = new StringBuilder("hello");
      }
      for (int i = 0; i < a.getEnumArray().length; i++)
      {
         a.getEnumArray()[i] = Color.blue;
      }
      a.getCharSeqTest().add('d');
      a.getWcharSeqTest().add('e');
      a.getOctetSeqTest().add((byte) 2);
      a.getShortSeqTest().add((short) 5);
      a.getUshortSeqTest().add(7);
      a.getLongSeqTest().add(-8);
      a.getUlongSeqTest().add(9);
      a.getLonglongSeqtest().add(-10L);
      a.getUlonglongSeqTest().add(11L);
      a.getFloatSeqTest().add(12.0f);
      a.getDoubleSeqTest().add(-13.0);
      a.getBooleanSeqTest().add(true);
      a.getNestedSeqTest().add();
      a.getNestedSeqTest().get(0).setStringTest("help");
      a.getEnumSeqTest().add(Color.blue);
      a.getEnumSeqTest().add(Color.red);
      a.getStringSeqTest().add("yoyo");
   }
}

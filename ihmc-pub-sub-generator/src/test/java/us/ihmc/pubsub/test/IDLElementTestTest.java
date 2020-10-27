package us.ihmc.pubsub.test;

import java.io.IOException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import us.ihmc.idl.generated.nested.NestedElement;
import us.ihmc.idl.generated.test.Color;
import us.ihmc.idl.generated.test.IDLElementTest;
import us.ihmc.idl.generated.test.IDLElementTestPubSubType;
import us.ihmc.pubsub.common.SerializedPayload;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test cases for the IDLElementTest type. 
 * 
 * IDLElementTest contains all supported types, this class makes sure it gets correctly serialized, the equals and set methods works
 * and the serialized byte stream corresponds to one serialized using the c++ classes created by fastrtpsgen. 
 * 
 * @author Jesper Smith
 *
 */
public class IDLElementTestTest
{
   private void populateIDLElementTest(IDLElementTest test)
   {

      test.setCharTest('3');
      test.setWcharTest('\u03a9');
      test.setOctetTest((byte) 0xa);
      test.setShortTest((short) -16);
      test.setUshortTest(15);
      test.setLongTest(-58102);
      test.setUlongTest(914);
      test.setLonglongTest(-90224141);
      test.setUlonglongTest(582142);
      test.setFloatTest(258145.2143f);
      test.setDoubleTest(9184289051.1241);
      test.setBooleanTest(true);
      test.setColorTest(Color.blue);
      test.getNestedElementTest().setLongTest(518);
      test.getNestedElementTest().getStringTest().append("Nested");
      test.getStringTest().append("Wolololo");

      for (int i = 0; i < 10; i++)
      {
         test.getLongArray()[i] = i * 124;
      }

      for (int a = 0; a < 5; a++)
      {
         for (int b = 0; b < 3; b++)
         {
            test.getNestedArray()[a][b].setLongTest(a + a * b * 3 + b + 24);
            test.getNestedArray()[a][b].getStringTest().append("arrayDim:" + a + b);
         }
      }

      for (int i = 0; i < 4; i++)
      {
         test.getStringArray()[i].append("arrayDim:" + i);
      }

      for (int s = 1; s < 4; s++)
      {
         for (int w = 0; w < 5; w++)
         {
            int i = s + s * w;

            switch (s)
            {
            case 1:
               test.getCharSeqTest().add(String.valueOf(i).charAt(0));
               test.getWcharSeqTest().add('\u03a9');
               test.getOctetSeqTest().add((byte) (i * 2));
               test.getShortSeqTest().add((short) (-2 * i + 1));
               test.getBooleanSeqTest().add(i % 2 == 0);
            case 2:
               test.getUshortSeqTest().add(i + 4);
               test.getLongSeqTest().add(i * 124 - 98);
               test.getUlongSeqTest().add(i * 11561);
               test.getLonglongSeqtest().add(-2143125l + i * 1251);
            case 3:
               test.getUlonglongSeqTest().add(241l + i * 100421410l);
               test.getFloatSeqTest().add(325.25f * i);
               test.getDoubleSeqTest().add(15095.921 * i);
               NestedElement elem = test.getNestedSeqTest().add();
               elem.setLongTest(i * 541);
               elem.getStringTest().append("dim:" + s + w);
               StringBuilder builder = test.getStringSeqTest().add();
               builder.append("sdim:" + s + w);

            }
         }
      }
   }

   public IDLElementTest createPopulatedIDLElementTest()
   {
      IDLElementTest idlElementTest = new IDLElementTest();
      populateIDLElementTest(idlElementTest);
      return idlElementTest;
   }

   @Test// timeout = 30000
   public void testIDLElementEquals()
   {
      IDLElementTest orig = createPopulatedIDLElementTest();

      IDLElementTest test = createPopulatedIDLElementTest();
      assertEquals(orig, test);
      test.setCharTest('4');
      assertNotEquals(orig, test);
      test = createPopulatedIDLElementTest();
      assertEquals(orig, test);
      test.setWcharTest('z');
      assertNotEquals(orig, test);
      test = createPopulatedIDLElementTest();
      assertEquals(orig, test);
      test.setOctetTest((byte) 0xb);
      assertNotEquals(orig, test);
      test = createPopulatedIDLElementTest();
      assertEquals(orig, test);
      test.setShortTest((short) -1);
      assertNotEquals(orig, test);
      test = createPopulatedIDLElementTest();
      assertEquals(orig, test);
      test.setUshortTest(1);
      assertNotEquals(orig, test);
      test = createPopulatedIDLElementTest();
      assertEquals(orig, test);
      test.setLongTest(-5102);
      assertNotEquals(orig, test);
      test = createPopulatedIDLElementTest();
      assertEquals(orig, test);
      test.setUlongTest(14);
      assertNotEquals(orig, test);
      test = createPopulatedIDLElementTest();
      assertEquals(orig, test);
      test.setLonglongTest(-9024141);
      assertNotEquals(orig, test);
      test = createPopulatedIDLElementTest();
      assertEquals(orig, test);
      test.setUlonglongTest(58142);
      assertNotEquals(orig, test);
      test = createPopulatedIDLElementTest();
      assertEquals(orig, test);
      test.setFloatTest(25814.2143f);
      assertNotEquals(orig, test);
      test = createPopulatedIDLElementTest();
      assertEquals(orig, test);
      test.setDoubleTest(918289051.1241);
      assertNotEquals(orig, test);
      test = createPopulatedIDLElementTest();
      assertEquals(orig, test);
      test.setBooleanTest(false);
      assertNotEquals(orig, test);
      test = createPopulatedIDLElementTest();
      assertEquals(orig, test);
      test.setColorTest(Color.green);
      assertNotEquals(orig, test);
      test = createPopulatedIDLElementTest();
      assertEquals(orig, test);
      test.getNestedElementTest().setLongTest(58);
      assertNotEquals(orig, test);
      test = createPopulatedIDLElementTest();
      assertEquals(orig, test);
      test.getNestedElementTest().getStringTest().setLength(0);
      test.getNestedElementTest().getStringTest().append("Wested");
      assertNotEquals(orig, test);
      test = createPopulatedIDLElementTest();
      assertEquals(orig, test);
      test.getStringTest().setLength(0);
      test.getStringTest().append("Lolololo");
      assertNotEquals(orig, test);
      test = createPopulatedIDLElementTest();
      assertEquals(orig, test);

      for (int i = 0; i < 10; i++)
      {
         test.getLongArray()[i] = i * 14 + 1;
         assertNotEquals(orig, test);
         test = createPopulatedIDLElementTest();
         assertEquals(orig, test);
      }

      for (int a = 0; a < 5; a++)
      {
         for (int b = 0; b < 3; b++)
         {
            test.getNestedArray()[a][b].setLongTest(a + a * b * 3 + b + 25);
            assertNotEquals(orig, test);
            test = createPopulatedIDLElementTest();
            assertEquals(orig, test);
            test.getNestedArray()[a][b].getStringTest().setLength(0);
            test.getNestedArray()[a][b].getStringTest().append("arrayDim:" + a + b + "invalid");
            assertNotEquals(orig, test);
            test = createPopulatedIDLElementTest();
            assertEquals(orig, test);
         }
      }

      for (int i = 0; i < 4; i++)
      {
         test.getStringArray()[i].setLength(0);
         ;
         test.getStringArray()[i].append("arrayDimNew:" + i);
         assertNotEquals(orig, test);
         test = createPopulatedIDLElementTest();
         assertEquals(orig, test);
      }
      int c1 = 0, c2 = 0, c3 = 0;
      for (int s = 1; s < 4; s++)
      {
         for (int w = 0; w < 5; w++)
         {
            int i = s + s * w;

            switch (s)
            {
            case 1:
               test.getCharSeqTest().set(c1, String.valueOf(i * 2).charAt(0));
               assertNotEquals(orig, test);
               test = createPopulatedIDLElementTest();
               assertEquals(orig, test);
               test.getWcharSeqTest().set(c1, 'b');
               assertNotEquals(orig, test);
               test = createPopulatedIDLElementTest();
               assertEquals(orig, test);
               test.getOctetSeqTest().set(c1, (byte) (i * 3));
               assertNotEquals(orig, test);
               test = createPopulatedIDLElementTest();
               assertEquals(orig, test);
               test.getShortSeqTest().set(c1, (short) (-4 * i + 1));
               assertNotEquals(orig, test);
               test = createPopulatedIDLElementTest();
               assertEquals(orig, test);
               test.getBooleanSeqTest().set(c1, !test.getBooleanSeqTest().getBoolean(c1));
               assertNotEquals(orig, test);
               test = createPopulatedIDLElementTest();
               assertEquals(orig, test);
               c1++;
            case 2:
               test.getUshortSeqTest().set(c2, i + 5);
               assertNotEquals(orig, test);
               test = createPopulatedIDLElementTest();
               assertEquals(orig, test);
               test.getLongSeqTest().set(c2, i * 124 - 99);
               assertNotEquals(orig, test);
               test = createPopulatedIDLElementTest();
               assertEquals(orig, test);
               test.getUlongSeqTest().set(c2, i * 1161);
               assertNotEquals(orig, test);
               test = createPopulatedIDLElementTest();
               assertEquals(orig, test);
               test.getLonglongSeqtest().set(c2, -243125l + i * 1251);
               assertNotEquals(orig, test);
               test = createPopulatedIDLElementTest();
               assertEquals(orig, test);
               c2++;
            case 3:
               test.getUlonglongSeqTest().set(c3, 242l + i * 100421410l);
               assertNotEquals(orig, test);
               test = createPopulatedIDLElementTest();
               assertEquals(orig, test);
               test.getFloatSeqTest().set(c3, 525.25f * i);
               assertNotEquals(orig, test);
               test = createPopulatedIDLElementTest();
               assertEquals(orig, test);
               test.getDoubleSeqTest().set(c3, 19095.921 * i);
               assertNotEquals(orig, test);
               test = createPopulatedIDLElementTest();
               assertEquals(orig, test);
               NestedElement elem = test.getNestedSeqTest().add();
               assertNotEquals(orig, test);
               test = createPopulatedIDLElementTest();
               assertEquals(orig, test);
               elem = test.getNestedSeqTest().get(c3);
               elem.setLongTest(i * 541 + 18);
               assertNotEquals(orig, test);
               test = createPopulatedIDLElementTest();
               assertEquals(orig, test);
               elem = test.getNestedSeqTest().get(c3);
               elem.getStringTest().setLength(0);
               elem.getStringTest().append("dimnew:" + s + w);
               assertNotEquals(orig, test);
               test = createPopulatedIDLElementTest();
               assertEquals(orig, test);
               StringBuilder builder = test.getStringSeqTest().add();
               assertNotEquals(orig, test);
               test = createPopulatedIDLElementTest();
               assertEquals(orig, test);
               builder = test.getStringSeqTest().get(c3);
               builder.append("newsdim:" + s + w);
               assertNotEquals(orig, test);
               test = createPopulatedIDLElementTest();
               assertEquals(orig, test);
               c3++;
            }
         }
      }

   }

   @Test// timeout = 30000
   public void testIDLElementTestSet()
   {
      IDLElementTest a = createPopulatedIDLElementTest();
      IDLElementTest b = new IDLElementTest();

      assertNotEquals(a, b);

      b.set(a);

      assertEquals(a, b);
   }

   @Test// timeout = 30000
   public void testIDLElementSerializeDeserialize() throws IOException
   {
      IDLElementTest test = new IDLElementTest();
      populateIDLElementTest(test);

      IDLElementTestPubSubType type = new IDLElementTestPubSubType();
      SerializedPayload payload = new SerializedPayload(type.getTypeSize());
      type.serialize(test, payload);

      IDLElementTest other = new IDLElementTest();
      type.deserialize(payload, other);
      assertEquals(test, other);
   }

   @Disabled // TODO Recompile cpp soon
   @Test// timeout = 30000
   public void testIDLElementWithFastRTPSGenCPPCode() throws IOException
   {
      IDLElementTest test = new IDLElementTest();
      populateIDLElementTest(test);

      IDLElementTestPubSubType type = new IDLElementTestPubSubType();
      SerializedPayload payload = new SerializedPayload(type.getTypeSize());
      
      type.serialize(test, payload);

      byte[] javadata = new byte[payload.getLength()];
      payload.getData().get(javadata);

      IDLElementTest cppElement = new IDLElementTest();

      SerializedPayload cppPayload = new SerializedPayload(type.getTypeSize());
      cppPayload.getData().put(IDLElementTestCPPData.cppData);
      cppPayload.getData().flip();
      cppPayload.setLength(IDLElementTestCPPData.cppData.length);
      type.deserialize(cppPayload, cppElement);

      assertArrayEquals(IDLElementTestCPPData.cppData, javadata);
      assertEquals(cppElement, test);
   }
}

/**
 * Copyright 2018 Florida Institute for Human and Machine Cognition (IHMC)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package us.ihmc.idl.serializers.extra;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

import us.ihmc.idl.generated.IDLElement.Color;
import us.ihmc.idl.generated.IDLElement.IDLElementTest;
import us.ihmc.idl.generated.IDLElement.IDLElementTestPubSubType;
import us.ihmc.idl.generated.IDLNestedElement.NestedElement;
import us.ihmc.idl.serializers.extra.JSONSerializer;

public class JSONSerializerTest
{
   public static void populateIDLElementTest(IDLElementTest test)
   {

      test.setCharTest('3');
      test.setWcharTest('Ω');
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
      test.getStringTest().append("Wolololo</StringTest>");

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
               test.getWcharSeqTest().add('Ω');
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

   public static IDLElementTest createPopulatedIDLElementTest()
   {
      IDLElementTest idlElementTest = new IDLElementTest();
      populateIDLElementTest(idlElementTest);
      return idlElementTest;
   }

   @Test
   public void testEmpty() throws IOException
   {
      IDLElementTestPubSubType type = new IDLElementTestPubSubType();
      JSONSerializer<IDLElementTest> serializer = new JSONSerializer<>(type);

      IDLElementTest idlElementTest = new IDLElementTest();

      byte[] data = serializer.serializeToBytes(idlElementTest);
      IDLElementTest res = serializer.deserialize(data);

      assertEquals(idlElementTest, res);

   }

   @Test
   public void testWithData() throws IOException
   {
      IDLElementTestPubSubType type = new IDLElementTestPubSubType();
      JSONSerializer<IDLElementTest> serializer = new JSONSerializer<>(type);

      IDLElementTest idlElementTest = createPopulatedIDLElementTest();

      byte[] data = serializer.serializeToBytes(idlElementTest);
      IDLElementTest res = serializer.deserialize(data);


      assertEquals(idlElementTest, res);

   }

   @Test
   public void testWithMissingData() throws IOException
   {
      IDLElementTestPubSubType type = new IDLElementTestPubSubType();
      JSONSerializer<IDLElementTest> serializer = new JSONSerializer<>(type);

      IDLElementTest empty = serializer.deserialize("{\"IDLElement::IDLElementTest\":{}}");
      assertEquals(type.createData(), empty);
      
      InputStream dataStream = getClass().getResourceAsStream("IDLElementTest.incomplete.json");
      IDLElementTest incomplete = serializer.deserialize(dataStream);
      assertNotNull(incomplete);
   }

}

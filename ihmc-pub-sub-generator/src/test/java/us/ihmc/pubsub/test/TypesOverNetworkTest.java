package us.ihmc.pubsub.test;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.mutable.MutableInt;
import org.junit.Test;
import us.ihmc.idl.generated.nested.NestedElement;
import us.ihmc.idl.generated.test.Color;
import us.ihmc.idl.generated.test.IDLElementTest;
import us.ihmc.pubsub.tools.PubSubTester;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.assertTrue;

public class TypesOverNetworkTest
{
   @Test(timeout = 30000)
   public void testSerializationOfAllTypesOverRealNetwork() throws IOException
   {
      PubSubTester<IDLElementTest> tester = new PubSubTester<>(IDLElementTest::new);

      int NUMBER_MESSAGES_TO_SEND = 10;
      Random random = new Random(2934810948124L);

      IDLElementTest[] messageArray = new IDLElementTest[NUMBER_MESSAGES_TO_SEND];

      for (int i = 0; i < NUMBER_MESSAGES_TO_SEND; i++)
         messageArray[i] = populateIDLElementTest(new IDLElementTest(), random);

      MutableInt receiveIndex = new MutableInt();
      ArrayList<AssertionError> errors = new ArrayList<>();
      tester.callbacks.add(((data, info) -> {
         try
         {
            assertTrue("not equal", messageArray[receiveIndex.incrementAndGet()].epsilonEquals(data, 0.0));
         }
         catch (AssertionError e)
         {
            e.printStackTrace();
            errors.add(e);
         }
      }));

      for (int i = 0; i < NUMBER_MESSAGES_TO_SEND; i++)
      {
         try
         {
            tester.publisher.write(messageArray[i]);

            System.out.println("Publishing: " + messageArray[i].toString());
            Thread.sleep(1000);
            ++i;
         }
         catch (InterruptedException e)
         {
         }
      }

      tester.domain.stopAll();

      for (AssertionError error : errors)
         throw error;
   }

   public boolean epsilonEquals(IDLElementTest msg, IDLElementTest other, double epsilon)
   {
      if(other == null) return false;
      if(other == msg) return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(msg.charTest_, other.charTest_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(msg.wcharTest_, other.wcharTest_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(msg.octetTest_, other.octetTest_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(msg.shortTest_, other.shortTest_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(msg.ushortTest_, other.ushortTest_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(msg.longTest_, other.longTest_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(msg.ulongTest_, other.ulongTest_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(msg.longlongTest_, other.longlongTest_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(msg.ulonglongTest_, other.ulonglongTest_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(msg.floatTest_, other.floatTest_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(msg.doubleTest_, other.doubleTest_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(msg.booleanTest_, other.booleanTest_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsEnum(msg.colorTest_, other.colorTest_, epsilon)) return false;

      if (!msg.nestedElementTest_.epsilonEquals(other.nestedElementTest_, epsilon)) return false;
      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(msg.stringTest_, other.stringTest_, epsilon)) return false;

      for(int i15 = 0; i15 < msg.longArray_.length; ++i15)
      {
         if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(msg.longArray_[i15], other.longArray_[i15], epsilon)) return false;
      }

      for(int i17 = 0; i17 < msg.nestedArray_.length; ++i17)
      {
         for(int i18 = 0; i18 < msg.nestedArray_[i17].length; ++i18)
         {
            if (!msg.nestedArray_[i17][i18].epsilonEquals(other.nestedArray_[i17][i18], epsilon)) return false;
         }
      }

      for(int i20 = 0; i20 < msg.stringArray_.length; ++i20)
      {
         if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(msg.stringArray_[i20], other.stringArray_[i20], epsilon)) return false;}

      for(int i22 = 0; i22 < msg.enumArray_.length; ++i22)
      {
         if (!us.ihmc.idl.IDLTools.epsilonEqualsEnum(msg.enumArray_[i22], other.enumArray_[i22], epsilon)) return false;
      }

      if (!us.ihmc.idl.IDLTools.epsilonEqualsCharSequence(msg.charSeqTest_, other.charSeqTest_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsCharSequence(msg.wcharSeqTest_, other.wcharSeqTest_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsByteSequence(msg.octetSeqTest_, other.octetSeqTest_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsShortSequence(msg.shortSeqTest_, other.shortSeqTest_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsIntegerSequence(msg.ushortSeqTest_, other.ushortSeqTest_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsIntegerSequence(msg.longSeqTest_, other.longSeqTest_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsLongSequence(msg.ulongSeqTest_, other.ulongSeqTest_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsLongSequence(msg.longlongSeqtest_, other.longlongSeqtest_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsLongSequence(msg.ulonglongSeqTest_, other.ulonglongSeqTest_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsFloatSequence(msg.floatSeqTest_, other.floatSeqTest_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsDoubleSequence(msg.doubleSeqTest_, other.doubleSeqTest_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBooleanSequence(msg.booleanSeqTest_, other.booleanSeqTest_, epsilon)) return false;

      if (msg.nestedSeqTest_.size() != other.nestedSeqTest_.size()) { return false; }
      else
      {
         for (int i = 0; i < msg.nestedSeqTest_.size(); i++)
         {  if (!msg.nestedSeqTest_.get(i).epsilonEquals(other.nestedSeqTest_.get(i), epsilon)) return false; }
      }

      if (!us.ihmc.idl.IDLTools.epsilonEqualsEnumSequence(msg.enumSeqTest_, other.enumSeqTest_, epsilon)) return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilderSequence(msg.stringSeqTest_, other.stringSeqTest_, epsilon)) return false;


      return true;
   }

   private IDLElementTest populateIDLElementTest(IDLElementTest test, Random random)
   {
      test.setCharTest(RandomStringUtils.random(1, 32, 127, false, false, null, random).charAt(0));
      test.setWcharTest(RandomStringUtils.random(1, 32, 127, false, false, null, random).charAt(0));
      test.setOctetTest(nextByte(random));
      test.setShortTest((short) random.nextInt(Short.MAX_VALUE + 1));
      test.setUshortTest(random.nextInt());
      test.setLongTest(random.nextInt());
      test.setUlongTest(random.nextLong());
      test.setLonglongTest(random.nextLong());
      test.setUlonglongTest(random.nextLong());
      test.setFloatTest(random.nextFloat());
      test.setDoubleTest(random.nextDouble());
      test.setBooleanTest(random.nextBoolean());
      test.setColorTest(Color.values[random.nextInt(Color.values.length - 1)]);
      test.getNestedElementTest().setLongTest(random.nextInt());
      test.getNestedElementTest().getStringTest().append(RandomStringUtils.random(20, 32, 127, false, false, null, random));
      test.getStringTest().append(RandomStringUtils.random(20, 32, 127, false, false, null, random));

      for (int i = 0; i < 10; i++)
      {
         test.getLongArray()[i] = random.nextInt();
      }

      for (int a = 0; a < 5; a++)
      {
         for (int b = 0; b < 3; b++)
         {
            test.getNestedArray()[a][b].setLongTest(random.nextInt());
            test.getNestedArray()[a][b].getStringTest().append(RandomStringUtils.random(20, 32, 127, false, false, null, random));
         }
      }

      for (int i = 0; i < 4; i++)
      {
         test.getStringArray()[i].append(RandomStringUtils.random(20, 32, 127, false, false, null, random));
      }

      for (int s = 1; s < 4; s++)
      {
         for (int w = 0; w < 5; w++)
         {
            int i = s + s * w;

            switch (s)
            {
            case 1:
               test.getCharSeqTest().add(RandomStringUtils.random(1, 32, 127, false, false, null, random).charAt(0));
               test.getWcharSeqTest().add(RandomStringUtils.random(1, 32, 127, false, false, null, random).charAt(0));
               test.getOctetSeqTest().add(nextByte(random));
               test.getShortSeqTest().add((short) random.nextInt(Short.MAX_VALUE + 1));
               test.getBooleanSeqTest().add(random.nextBoolean());
            case 2:
               test.getUshortSeqTest().add(random.nextInt());
               test.getLongSeqTest().add(random.nextInt());
               test.getUlongSeqTest().add(random.nextLong());
               test.getLonglongSeqtest().add(random.nextLong());
            case 3:
               test.getUlonglongSeqTest().add(random.nextLong());
               test.getFloatSeqTest().add(random.nextFloat());
               test.getDoubleSeqTest().add(random.nextDouble());
               NestedElement elem = test.getNestedSeqTest().add();
               elem.setLongTest(random.nextInt());
               elem.getStringTest().append(RandomStringUtils.random(20, 32, 127, false, false, null, random));
               StringBuilder builder = test.getStringSeqTest().add();
               builder.append(RandomStringUtils.random(20, 32, 127, false, false, null, random));
            }
         }
      }

      return test;
   }

   private byte nextByte(Random random)
   {
      byte[] bytes = new byte[1];
      random.nextBytes(bytes);
      return bytes[0];
   }
}

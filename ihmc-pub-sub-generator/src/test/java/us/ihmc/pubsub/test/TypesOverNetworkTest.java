package us.ihmc.pubsub.test;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import us.ihmc.idl.CDR;
import us.ihmc.idl.generated.test.Color;
import us.ihmc.idl.generated.test.IDLElementTest;
import us.ihmc.pubsub.tools.PubSubTester;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * This test shows that passing invalid values of signed java types does not work.
 */
public class TypesOverNetworkTest
{
   @Test// timeout = 30000
   public void testSerializationOfAllTypesOverRealNetwork() throws IOException
   {
      PubSubTester<IDLElementTest> tester = new PubSubTester<>(IDLElementTest::new);

      int NUMBER_MESSAGES_TO_SEND = 10;
      Random random = new Random(2934810948124L);

      IDLElementTest[] messageArray = new IDLElementTest[NUMBER_MESSAGES_TO_SEND];

      for (int i = 0; i < NUMBER_MESSAGES_TO_SEND; i++)
      {
         messageArray[i] = populateIDLElementTest(new IDLElementTest(), random, i);
      }

      ArrayList<AssertionError> errors = new ArrayList<>();
      tester.callbacks.add(((data, info) -> {

         System.out.println("Receiving: " + data.getStringTestAsString());

         // use string to match up messages, allowing for out of order or dropped messages
         for (int i = 0; i < NUMBER_MESSAGES_TO_SEND; i++)
         {
            if (messageArray[i].getStringTestAsString().equals(data.getStringTestAsString()))
            {
               System.out.println("Looking for errors...");
               ArrayList<AssertionError> localErrors = epsilonEquals(messageArray[i], data, 0.0);
               errors.addAll(localErrors);

               for (AssertionError error : localErrors)
                  error.printStackTrace();
            }
         }

      }));

      for (int i = 0; i < NUMBER_MESSAGES_TO_SEND; i++)
      {
         try
         {
            tester.publisher.write(messageArray[i]);

            System.out.println("Publishing: " + messageArray[i].getStringTestAsString());
            Thread.sleep(200);
         }
         catch (InterruptedException e)
         {
         }
      }

      tester.domain.stopAll();

      System.out.println("Num errors: " + errors.size());

      for (AssertionError error : errors)
         throw error;
   }

   private IDLElementTest populateIDLElementTest(IDLElementTest test, Random random, int index)
   {
      test.setCharTest(RandomStringUtils.random(1, 32, 127, false, false, null, random).charAt(0));
      test.setWcharTest(RandomStringUtils.random(1, 32, 127, false, false, null, random).charAt(0));
      test.setOctetTest(nextByte(random));
      test.setShortTest((short) random.nextInt(Short.MAX_VALUE + 1));
      test.setUshortTest(random.nextInt(CDR.UNSIGNED_SHORT_MAX));
      test.setLongTest(random.nextInt());
      long uint32 = random.nextLong();
      test.setUlongTest((uint32 < 0 ? -uint32 : uint32) % CDR.UNSIGNED_INT_MAX);
      test.setLonglongTest(random.nextLong());
      test.setUlonglongTest(random.nextLong());
      test.setFloatTest(random.nextFloat());
      test.setDoubleTest(random.nextDouble());
      test.setBooleanTest(random.nextBoolean());
      test.setColorTest(Color.values[random.nextInt(Color.values.length - 1)]);
      test.getNestedElementTest().setLongTest(random.nextInt());
      test.getNestedElementTest().getStringTest().append(RandomStringUtils.random(20, 32, 127, false, false, null, random));
      test.getStringTest().append(index);

      return test;
   }

   private byte nextByte(Random random)
   {
      byte[] bytes = new byte[1];
      random.nextBytes(bytes);
      return bytes[0];
   }

   public ArrayList<AssertionError> epsilonEquals(IDLElementTest msg, IDLElementTest other, double epsilon)
   {
      ArrayList<AssertionError> errors = new ArrayList<>();

      if (other == null)
      {
         errors.add(new AssertionError(other + " was null"));
      }
      if (other == msg)
         return errors;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(msg.charTest_, other.charTest_, epsilon))
      {
         errors.add(new AssertionError("charTest_: msg: " + msg.charTest_ + " other:" + other.charTest_));
      }

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(msg.wcharTest_, other.wcharTest_, epsilon))
      {
         errors.add(new AssertionError("wcharTest_: msg: " + msg.wcharTest_ + " other:" + other.wcharTest_));
      }

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(msg.octetTest_, other.octetTest_, epsilon))
      {
         errors.add(new AssertionError("octetTest_: msg: " + msg.octetTest_ + " other:" + other.octetTest_));
      }

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(msg.shortTest_, other.shortTest_, epsilon))
      {
         errors.add(new AssertionError("shortTest_: msg: " + msg.shortTest_ + " other:" + other.shortTest_));
      }

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(msg.ushortTest_, other.ushortTest_, epsilon))
      {
         errors.add(new AssertionError("ushortTest_: msg: " + msg.ushortTest_ + " other:" + other.ushortTest_));
      }

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(msg.longTest_, other.longTest_, epsilon))
      {
         errors.add(new AssertionError("longTest_: msg: " + msg.longTest_ + " other:" + other.longTest_));
      }

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(msg.ulongTest_, other.ulongTest_, epsilon))
      {
         errors.add(new AssertionError("ulongTest_: msg: " + msg.ulongTest_ + " other:" + other.ulongTest_));
      }

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(msg.longlongTest_, other.longlongTest_, epsilon))
      {
         errors.add(new AssertionError("longlongTest_: msg: " + msg.longlongTest_ + " other:" + other.longlongTest_));
      }

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(msg.ulonglongTest_, other.ulonglongTest_, epsilon))
      {
         errors.add(new AssertionError("ulonglongTest_: msg: " + msg.ulonglongTest_ + " other:" + other.ulonglongTest_));
      }

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(msg.floatTest_, other.floatTest_, epsilon))
      {
         errors.add(new AssertionError("floatTest_: msg: " + msg.floatTest_ + " other:" + other.floatTest_));
      }

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(msg.doubleTest_, other.doubleTest_, epsilon))
      {
         errors.add(new AssertionError("doubleTest_: msg: " + msg.doubleTest_ + " other:" + other.doubleTest_));
      }

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(msg.booleanTest_, other.booleanTest_, epsilon))
      {
         errors.add(new AssertionError("booleanTest_: msg: " + msg.booleanTest_ + " other:" + other.booleanTest_));
      }

      if (!us.ihmc.idl.IDLTools.epsilonEqualsEnum(msg.colorTest_, other.colorTest_, epsilon))
      {
         errors.add(new AssertionError("colorTest_: msg: " + msg.colorTest_ + " other:" + other.colorTest_));
      }

      if (!msg.nestedElementTest_.epsilonEquals(other.nestedElementTest_, epsilon))
      {
         errors.add(new AssertionError("nestedElementTest_: msg: " + msg.nestedElementTest_ + " other:" + other.nestedElementTest_));
      }
      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(msg.stringTest_, other.stringTest_, epsilon))
      {
         errors.add(new AssertionError("stringTest_: msg: " + msg.stringTest_ + " other:" + other.stringTest_));
      }

      for (int i15 = 0; i15 < msg.longArray_.length; ++i15)
      {
         if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(msg.longArray_[i15], other.longArray_[i15], epsilon))
         {
            errors.add(new AssertionError("longArray_[i15]: msg: " + msg.longArray_[i15] + " other:" + other.longArray_[i15]));
         }
      }

      for (int i17 = 0; i17 < msg.nestedArray_.length; ++i17)
      {
         for (int i18 = 0; i18 < msg.nestedArray_[i17].length; ++i18)
         {
            if (!msg.nestedArray_[i17][i18].epsilonEquals(other.nestedArray_[i17][i18], epsilon))
            {
               errors.add(new AssertionError("nestedArray_[i17][i18]: msg: " + msg.nestedArray_[i17][i18] + " other:" + other.nestedArray_[i17][i18]));
            }
         }
      }

      for (int i20 = 0; i20 < msg.stringArray_.length; ++i20)
      {
         if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilder(msg.stringArray_[i20], other.stringArray_[i20], epsilon))
         {
            errors.add(new AssertionError("stringArray_[i20]: msg: " + msg.stringArray_[i20] + " other:" + other.stringArray_[i20]));
         }
      }

      for (int i22 = 0; i22 < msg.enumArray_.length; ++i22)
      {
         if (!us.ihmc.idl.IDLTools.epsilonEqualsEnum(msg.enumArray_[i22], other.enumArray_[i22], epsilon))
         {
            errors.add(new AssertionError("enumArray_[i22]: msg: " + msg.enumArray_[i22] + " other:" + other.enumArray_[i22]));
         }
      }

      if (!us.ihmc.idl.IDLTools.epsilonEqualsCharSequence(msg.charSeqTest_, other.charSeqTest_, epsilon))
      {
         errors.add(new AssertionError("charSeqTest_: msg: " + msg.charSeqTest_ + " other:" + other.charSeqTest_));
      }

      if (!us.ihmc.idl.IDLTools.epsilonEqualsCharSequence(msg.wcharSeqTest_, other.wcharSeqTest_, epsilon))
      {
         errors.add(new AssertionError("wcharSeqTest_: msg: " + msg.wcharSeqTest_ + " other:" + other.wcharSeqTest_));
      }

      if (!us.ihmc.idl.IDLTools.epsilonEqualsByteSequence(msg.octetSeqTest_, other.octetSeqTest_, epsilon))
      {
         errors.add(new AssertionError("octetSeqTest_: msg: " + msg.octetSeqTest_ + " other:" + other.octetSeqTest_));
      }

      if (!us.ihmc.idl.IDLTools.epsilonEqualsShortSequence(msg.shortSeqTest_, other.shortSeqTest_, epsilon))
      {
         errors.add(new AssertionError("shortSeqTest_: msg: " + msg.shortSeqTest_ + " other:" + other.shortSeqTest_));
      }

      if (!us.ihmc.idl.IDLTools.epsilonEqualsIntegerSequence(msg.ushortSeqTest_, other.ushortSeqTest_, epsilon))
      {
         errors.add(new AssertionError("ushortSeqTest_: msg: " + msg.ushortSeqTest_ + " other:" + other.ushortSeqTest_));
      }

      if (!us.ihmc.idl.IDLTools.epsilonEqualsIntegerSequence(msg.longSeqTest_, other.longSeqTest_, epsilon))
      {
         errors.add(new AssertionError("longSeqTest_: msg: " + msg.longSeqTest_ + " other:" + other.longSeqTest_));
      }

      if (!us.ihmc.idl.IDLTools.epsilonEqualsLongSequence(msg.ulongSeqTest_, other.ulongSeqTest_, epsilon))
      {
         errors.add(new AssertionError("ulongSeqTest_: msg: " + msg.ulongSeqTest_ + " other:" + other.ulongSeqTest_));
      }

      if (!us.ihmc.idl.IDLTools.epsilonEqualsLongSequence(msg.longlongSeqtest_, other.longlongSeqtest_, epsilon))
      {
         errors.add(new AssertionError("longlongSeqtest_: msg: " + msg.longlongSeqtest_ + " other:" + other.longlongSeqtest_));
      }

      if (!us.ihmc.idl.IDLTools.epsilonEqualsLongSequence(msg.ulonglongSeqTest_, other.ulonglongSeqTest_, epsilon))
      {
         errors.add(new AssertionError("ulonglongSeqTest_: msg: " + msg.ulonglongSeqTest_ + " other:" + other.ulonglongSeqTest_));
      }

      if (!us.ihmc.idl.IDLTools.epsilonEqualsFloatSequence(msg.floatSeqTest_, other.floatSeqTest_, epsilon))
      {
         errors.add(new AssertionError("floatSeqTest_: msg: " + msg.floatSeqTest_ + " other:" + other.floatSeqTest_));
      }

      if (!us.ihmc.idl.IDLTools.epsilonEqualsDoubleSequence(msg.doubleSeqTest_, other.doubleSeqTest_, epsilon))
      {
         errors.add(new AssertionError("doubleSeqTest_: msg: " + msg.doubleSeqTest_ + " other:" + other.doubleSeqTest_));
      }

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBooleanSequence(msg.booleanSeqTest_, other.booleanSeqTest_, epsilon))
      {
         errors.add(new AssertionError("booleanSeqTest_: msg: " + msg.booleanSeqTest_ + " other:" + other.booleanSeqTest_));
      }

      if (msg.nestedSeqTest_.size() != other.nestedSeqTest_.size())
      {
         errors.add(new AssertionError("nestedSeqTest_.size(): msg: " + msg.nestedSeqTest_.size() + " other:" + other.nestedSeqTest_.size()));
      }
      else
      {
         for (int i = 0; i < msg.nestedSeqTest_.size(); i++)
         {
            if (!msg.nestedSeqTest_.get(i).epsilonEquals(other.nestedSeqTest_.get(i), epsilon))
               errors.add(new AssertionError("nestedSeqTest_.get(i): msg: " + msg.nestedSeqTest_.get(i) + " other:" + other.nestedSeqTest_.get(i)));
         }
      }

      if (!us.ihmc.idl.IDLTools.epsilonEqualsEnumSequence(msg.enumSeqTest_, other.enumSeqTest_, epsilon))
      {
         errors.add(new AssertionError("enumSeqTest_: msg: " + msg.enumSeqTest_ + " other:" + other.enumSeqTest_));
      }

      if (!us.ihmc.idl.IDLTools.epsilonEqualsStringBuilderSequence(msg.stringSeqTest_, other.stringSeqTest_, epsilon))
      {
         errors.add(new AssertionError("stringSeqTest_: msg: " + msg.stringSeqTest_ + " other:" + other.stringSeqTest_));
      }

      return errors;
   }
}

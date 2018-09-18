package us.ihmc.pubsub.test;

import org.junit.Test;
import us.ihmc.commons.Assertions;
import us.ihmc.idl.generated.test.IDLFeatureMessage;

import java.io.IOException;

public class IntraprocessOverfillTest
{
   @Test(timeout = 30000)
   public void testOverfillThrowsException() throws IOException
   {
      IDLFeatureMessage idlFeatureMessage = new IDLFeatureMessage();

      for (int i = 0; i < idlFeatureMessage.num4_.getMaxCapacity(); i++)
      {
         idlFeatureMessage.num4_.add();
      }

      Assertions.assertExceptionThrown(OutOfMemoryError.class, () -> {
         idlFeatureMessage.num4_.add();
      });
   }
}

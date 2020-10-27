package us.ihmc.pubsub.test;

import org.junit.jupiter.api.Test;
import us.ihmc.idl.generated.test.IDLElementTest;

import static org.junit.jupiter.api.Assertions.*;

public class MessageCopyTest
{
   @Test// timeout = 30000
   public void testObjectSequencesCopy()
   {
      IDLElementTest a = new IDLElementTest();
      IDLElementTest b = new IDLElementTest();

      a.nestedSeqTest_.add();
      a.nestedSeqTest_.add();
      a.nestedSeqTest_.add();

      b.set(a);

      assertTrue(a.equals(b), "not equal");
      assertTrue(a.epsilonEquals(b, 0.0), "not equal");

      IDLElementTest c = new IDLElementTest();
      IDLElementTest d = new IDLElementTest();

      c.nestedSeqTest_.add();
      c.nestedSeqTest_.add();
      c.nestedSeqTest_.add();

      c.set(d);

      assertTrue(c.equals(d), "not equal");
      assertTrue(c.epsilonEquals(d, 0.0), "not equal");
   }
}

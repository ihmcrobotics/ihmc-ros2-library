package us.ihmc.pubsub.test;

import org.junit.Test;
import us.ihmc.idl.generated.test.Color;
import us.ihmc.idl.generated.test.IDLElementTest;

import static org.junit.Assert.*;

public class MessageCopyTest
{
   @Test(timeout = 30000)
   public void testObjectSequencesCopy()
   {
      IDLElementTest a = new IDLElementTest();
      IDLElementTest b = new IDLElementTest();

      a.nestedSeqTest_.add();
      a.nestedSeqTest_.add();
      a.nestedSeqTest_.add();

      b.set(a);


      assertTrue("not equal", a.equals(b));
      assertTrue("not equal", a.epsilonEquals(b, 0.0));

      IDLElementTest c = new IDLElementTest();
      IDLElementTest d = new IDLElementTest();

      c.nestedSeqTest_.add();
      c.nestedSeqTest_.add();
      c.nestedSeqTest_.add();

      c.set(d);


      assertTrue("not equal", c.equals(d));
      assertTrue("not equal", c.epsilonEquals(d, 0.0));
   }
}

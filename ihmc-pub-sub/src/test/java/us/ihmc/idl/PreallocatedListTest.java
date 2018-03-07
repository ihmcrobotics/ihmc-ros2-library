package us.ihmc.idl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import org.apache.commons.lang3.mutable.MutableInt;
import org.junit.Test;

public class PreallocatedListTest
{
   @Test(timeout = 30000)
   public void testConstructor()
   {
      PreallocatedList<Object> list = new PreallocatedList<>(Object.class, Object::new, 10);
      assertTrue(list.isEmpty());
      assertTrue(list.size() == 0);
      assertTrue(list.getLast() == null);
   }

   @Test(timeout = 30000)
   public void testAddAndGet()
   {
      PreallocatedList<Object> list = new PreallocatedList<>(Object.class, Object::new, 20);
      ArrayList<Object> expectedList = new ArrayList<>();

      int finalSize = 10;
      for (int i = 0; i < finalSize; i++)
      {
         Object lastObject = list.add();
         expectedList.add(lastObject);
      }

      assertFalse(list.isEmpty());
      assertTrue(list.size() == finalSize);
      for (int i = 0; i < finalSize; i++)
      {
         assertTrue(list.get(i) == expectedList.get(i));
      }

      assertTrue(list.getLast() == expectedList.get(finalSize - 1));

      try
      {
         list.get(finalSize);
         fail();
      }
      catch (IndexOutOfBoundsException e)
      {
         // Good
      }

      list.clear();
      expectedList.clear();
      assertTrue(list.getLast() == null);

      finalSize = 8;
      for (int i = 0; i < finalSize; i++)
      {
         Object lastObject = list.add();
         expectedList.add(lastObject);
      }

      assertFalse(list.isEmpty());
      assertTrue(list.size() == finalSize);
      for (int i = 0; i < finalSize; i++)
      {
         assertTrue(list.get(i) == expectedList.get(i));
      }

      assertTrue(list.getLast() == expectedList.get(finalSize - 1));

      list.clear();
      expectedList.clear();
      assertTrue(list.getLast() == null);

      finalSize = 20;
      for (int i = 0; i < finalSize; i++)
      {
         Object lastObject = list.add();
         expectedList.add(lastObject);
      }

      assertFalse(list.isEmpty());
      assertTrue(list.size() == finalSize);
      for (int i = 0; i < finalSize; i++)
      {
         assertTrue(list.get(i) == expectedList.get(i));
      }

      assertTrue(list.getLast() == expectedList.get(finalSize - 1));
   }

   @Test(timeout = 30000)
   public void testRemove()
   {
      PreallocatedList<MutableInt> list = new PreallocatedList<>(MutableInt.class, MutableInt::new, 10);
      int currentSize = 10;
      while (list.size() < currentSize)
         list.add().setValue(10 + list.size());

      System.out.println(list);

      ArrayList<MutableInt> expectedList = new ArrayList<>();
      for (int i = 0; i < currentSize; i++)
         expectedList.add(list.get(i));

      int indexOfRemovedOject = 3;
      list.remove(indexOfRemovedOject);
      expectedList.remove(indexOfRemovedOject);
      currentSize--;
      assertTrue(list.size() == currentSize);

      for (int i = 0; i < currentSize; i++)
      {
         assertTrue(list.get(i) == expectedList.get(i));
      }

      indexOfRemovedOject = currentSize - 1;
      list.remove(indexOfRemovedOject);
      expectedList.remove(indexOfRemovedOject);
      currentSize--;
      assertTrue(list.size() == currentSize);

      for (int i = 0; i < currentSize; i++)
      {
         assertTrue(list.get(i) == expectedList.get(i));
      }

      try
      {
         list.remove(currentSize);
         fail();
      }
      catch (IndexOutOfBoundsException e)
      {
         // Good
      }
   }

   @Test(timeout = 30000)
   public void testSwap()
   {
      Random rand = new Random(541964L);
      PreallocatedList<MutableInt> list = new PreallocatedList<>(MutableInt.class, MutableInt::new, 10);
      int currentSize = 10;
      while (list.size() < currentSize)
         list.add().setValue(10 + list.size());

      ArrayList<MutableInt> expectedList = new ArrayList<>();
      for (int i = 0; i < currentSize; i++)
         expectedList.add(list.get(i));

      for (int k = 0; k < 20; k++)
      {
         int indexA = rand.nextInt(currentSize);
         int indexB = rand.nextInt(currentSize);
         list.swap(indexA, indexB);
         Collections.swap(expectedList, indexA, indexB);
         assertTrue(list.size() == currentSize);

         for (int i = 0; i < currentSize; i++)
         {
            assertTrue(list.get(i) == expectedList.get(i));
         }
      }

      try
      {
         list.swap(0, currentSize);
         fail();
      }
      catch (IndexOutOfBoundsException e)
      {
         // Good
      }

      try
      {
         list.swap(currentSize, 0);
         fail();
      }
      catch (IndexOutOfBoundsException e)
      {
         // Good
      }
   }
}

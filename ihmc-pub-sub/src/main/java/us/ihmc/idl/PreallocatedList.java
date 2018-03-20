/**
 * Copyright 2017 Florida Institute for Human and Machine Cognition (IHMC)
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
package us.ihmc.idl;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.Supplier;

/**
 * Preallocated list of Objects or Enums.
 * 
 * This object preallocates the maximum number of instances. 
 * No setter is provided, use add(), remove() and get(i) to add, remove or get elements and change them in place. 
 * 
 * @author Jesper Smith
 *
 * @param <T>
 */
public class PreallocatedList<T>
{
   private final Class<T> clazz;
   private final T[] values;
   private int pos = -1;

   /**
    * Temporarily needed to enable Kryo to serialize DDS messages.
    */
   @Deprecated
   public PreallocatedList()
   {
      clazz = null;
      values = null;
   }

   @SuppressWarnings("unchecked")
   public PreallocatedList(Class<T> clazz, Supplier<T> allocator, int maxSize)
   {
      this.clazz = clazz;
      this.values = (T[]) Array.newInstance(clazz, maxSize);
      for (int i = 0; i < maxSize; i++)
      {
         values[i] = allocator.get();
      }
   }

   /**
    * Returns the elements in this list as array
    * 
    * This method allocates a new array
    * 
    * @return new array of length size();
    */
   public T[] toArray()
   {
      @SuppressWarnings("unchecked")
      T[] array = (T[]) Array.newInstance(clazz, size());
      System.arraycopy(values, 0, array, 0, size());
      return array;
   }

   /**
    * Copies the elements in this list to dest
    * 
    * @param dest Destination array. Has to be at least length size()
    * @throws IndexOutOfBoundsException if the destination array is smaller than size()
    */
   public void toArray(T[] dest)
   {
      if (dest.length < size())
      {
         throw new IndexOutOfBoundsException("Cannot copy data in destination array, insufficient space.");
      }
      System.arraycopy(values, 0, dest, 0, size());

   }

   /**
    * Clears the list.
    * 
    * This function just resets the size to 0. The underlying data objects are not emptied or removed.
    */

   public void resetQuick()
   {
      pos = -1;
   }

   /**
    * Add a value and return a handle to the object.
    * 
    * Do not use for Enum sequences.
    * 
    * @return value at the last position. This object can still hold data.
    */
   public T add()
   {
      maxCapacityCheck(pos + 1);
      return values[++pos];
   }

   /**
    * Removes the last element in the list. The underlying data object is not emptied or removed
    */
   public void remove()
   {
      nonEmptyCheck();
      --pos;
   }

   /**
    * Removes the element at the specified position in this list.
    * Shifts any subsequent elements to the left (subtracts one from their
    * indices).
    *
    * @param index the index of the element to be removed
    */
   public void remove(int i)
   {
      if (i == pos)
      {
         remove();
         return;
      }

      rangeCheck(i);

      T t = values[i];

      while (i < pos)
      {
         values[i] = values[++i];
      }

      // Do not throw away the removed element, put it at the end of the list instead.
      values[pos] = t;
      --pos;
      return;
   }

   /**
    * Swap two objects of this list.
    *
    * @param i index of the first object to swap
    * @param j index of the second object to swap
    * @throws ArrayIndexOutOfBoundsException if either of the indices is out of range
    *            (<tt>i &lt; 0 || i &gt;= size() || j &lt; 0 || j &gt;= size()</tt>)
    */
   public void swap(int i, int j)
   {
      rangeCheck(i);
      rangeCheck(j);

      if (i == j)
      {
         return;
      }

      unsafeSwap(i, j);
   }

   private void unsafeSwap(int i, int j)
   {
      T t = values[i];
      values[i] = values[j];
      values[j] = t;
   }

   /**
    * Get the element at position i. To change the element, use get() and
    * 
    * @param i Position to get element at
    * @return Element at position i.
    */
   public T get(int i)
   {
      rangeCheck(i);
      return values[i];
   }

   /**
    * Returns the first element of this list. If the list is empty, it returns {@code null}.
    *
    * @return the first element of this list.
    */
   public T getFirst()
   {
      if (isEmpty())
      {
         return null;
      }
      else
      {
         return values[0];
      }
   }

   /**
    * Returns the last element of this list. If the list is empty, it returns {@code null}.
    *
    * @return the last element of this list.
    */
   public T getLast()
   {
      if (isEmpty())
      {
         return null;
      }
      else
      {
         return values[pos];
      }
   }

   /**
    * Clears the list
    * 
    * This function just resets the size to 0.
    * 
    * The underlying data objects are not emptied or removed, however this may change in future
    * releases
    * 
    */
   public void clear()
   {
      resetQuick();
   }

   /**
    * Returns the number of active elements in this list
    */
   public int size()
   {
      return pos + 1;
   }

   /**
    * Returns {@code true} if this list contains no elements.
    *
    * @return {@code true} if this list contains no elements.
    */
   public boolean isEmpty()
   {
      return size() == 0;
   }

   /**
    * @return the maximum capacity of this list
    */
   public int capacity()
   {
      return values.length;
   }

   /**
    * 
    * @return the remaining space in this sequence (capacity() - size())
    */
   public int remaining()
   {
      return capacity() - size();
   }

   private void nonEmptyCheck()
   {
      if (pos < 0)
      {
         throw new ArrayIndexOutOfBoundsException("List is empty");
      }
   }

   private void rangeCheck(int i)
   {
      if (i < 0 || i > pos)
      {
         throw new ArrayIndexOutOfBoundsException("Position is not valid in the list, size is " + size() + ", requested element is " + i);
      }
   }

   private void maxCapacityCheck(int newSize)
   {
      if (newSize >= this.values.length)
      {
         throw new ArrayIndexOutOfBoundsException("Cannot add element to sequence, max size is violated");
      }
   }

   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((clazz == null) ? 0 : clazz.hashCode());
      result = prime * result + 1237;
      result = prime * result + pos;
      result = prime * result + Arrays.hashCode(values);
      return result;
   }

   @Override
   public boolean equals(Object obj)
   {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      PreallocatedList<?> other = (PreallocatedList<?>) obj;
      if (clazz == null)
      {
         if (other.clazz != null)
            return false;
      }
      else if (!clazz.equals(other.clazz))
         return false;
      if (pos != other.pos)
         return false;
      for (int i = 0; i < size(); i++)
      {
         if (!values[i].equals(other.values[i]))
            return false;
      }
      return true;
   }

   @Override
   public String toString()
   {
      String s = "";
      s += clazz.getSimpleName();
      s += " pos: " + pos;
      s += " [";
      for (int i = 0; i < size(); i++)
      {
         if (i > 0)
            s += ", ";
         s += values[i].toString();
      }
      s += "]";
      return s;
   }
}

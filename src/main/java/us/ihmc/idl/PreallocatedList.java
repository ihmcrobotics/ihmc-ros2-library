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

   @SuppressWarnings("rawtypes")
   private final Enum[] constants;
   private final boolean isEnum;

   @SuppressWarnings("unchecked")
   public PreallocatedList(Class<T> clazz, ListAllocator<T> allocator, int maxSize)
   {
      this.clazz = clazz;
      this.values = (T[]) Array.newInstance(clazz, maxSize);
      this.isEnum = false;
      this.constants = null;
      for (int i = 0; i < maxSize; i++)
      {
         values[i] = allocator.createInstance();
      }
   }

   @SuppressWarnings({"unchecked", "rawtypes"})
   public PreallocatedList(Class<T> clazz, Enum[] constants, int maxSize)
   {
      this.clazz = clazz;
      this.values = (T[]) Array.newInstance(clazz, maxSize);
      this.isEnum = true;
      this.constants = constants;
   }

   public interface ListAllocator<T>
   {
      T createInstance();
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
      if(dest.length < size())
      {
         throw new IndexOutOfBoundsException("Cannot copy data in destination array, insufficient space.");
      }
      System.arraycopy(values, 0, dest, 0, size());

   }
   
   /**
    * 
    * @return true if this is a List of enums
    */
   public boolean isEnum()
   {
      return isEnum;
   }

   /**
    * 
    * @return the enum constants of the underlying enum
    * @throws RuntimeException if isEnum() is false
    */
   @SuppressWarnings("rawtypes")
   public Enum[] getEnumConstants()
   {
      if (!isEnum)
      {
         throw new RuntimeException("This list is not filled with Enums");
      }
      return constants;
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
      if (isEnum)
      {
         throw new RuntimeException("Cannot add() enum to enum sequences. Use add(T) instead.");
      }
      if (pos + 1 >= this.values.length)
      {
         throw new ArrayIndexOutOfBoundsException("Cannot add element to sequence, max size is violated");
      }
      return values[++pos];
   }

   /**
    * Add an enum value.
    * 
    * Use for enum sequences 
    * 
    * @param Enum value
    */
   public void add(T value)
   {
      if (!isEnum)
      {
         throw new RuntimeException("Cannot add(T value) to object sequences. Use T add() instead");
      }
      if (pos + 1 >= this.values.length)
      {
         throw new ArrayIndexOutOfBoundsException("Cannot add element to sequence, max size is violated");
      }
      values[++pos] = value;
   }

   /**
    * Removes the last element in the list. The underlying data object is not emptied or removed
    */
   public void remove()
   {
      if (pos < 0)
      {
         throw new ArrayIndexOutOfBoundsException("List is empty");
      }
      --pos;
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
    * Returns the first element of this list.
    * If the list is empty, it returns {@code null}.
    *
    * @return the first element of this list.
    */
   public T getFirst()
   {
      if (isEmpty())
         return null;
      else
         return values[0];
   }

   /**
    * Returns the last element of this list.
    * If the list is empty, it returns {@code null}.
    *
    * @return the last element of this list.
    */
   public T getLast()
   {
      if (isEmpty())
         return null;
      else
         return values[pos];
   }

   /**
    * Set the Enum value at position i. 
    * 
    * @param i
    * @param value
    */
   public void setEnum(int i, T value)
   {
      if (!isEnum)
      {
         throw new RuntimeException("Cannot set() object sequences. Use T get(int i) instead");
      }
      rangeCheck(i);
      values[i] = value;
   }

   private void rangeCheck(int i)
   {
      if (i < 0 || i > pos)
      {
         throw new ArrayIndexOutOfBoundsException("Position is not valid in the list, size is " + size() + ", requested element is " + i);
      }
   }

   /**
    * Clears the list
    * 
    * This function just resets the size to 0. 
    * 
    * The underlying data objects are not emptied or removed, however this may change in future releases
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
   
   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((clazz == null) ? 0 : clazz.hashCode());
      result = prime * result + Arrays.hashCode(constants);
      result = prime * result + (isEnum ? 1231 : 1237);
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
      if (!Arrays.equals(constants, other.constants))
         return false;
      if (isEnum != other.isEnum)
         return false;
      if (pos != other.pos)
         return false;
      if (!Arrays.equals(values, other.values))
         return false;
      return true;
   }

}

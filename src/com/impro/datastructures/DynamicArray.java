package com.impro.datastructures;

import java.util.Iterator;


@SuppressWarnings("unchecked")
public class DynamicArray<T> implements Iterable <T> {

    private T[] array;
    private int length   = 0;       // length of the array for user
    private int capacity = 0;       // actual size

    public DynamicArray() {
        this(8);
    }

    public DynamicArray(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity smaller than zero");
        }
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }

    public int size() {
        return length;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T get(int index) {
        if (index > capacity || index < 0) {
            throw new IndexOutOfBoundsException("Index is too large");
        }
        return array[index];
    }

    public void set(int index, T elem) {
        if (index > capacity || index < 0) {
            throw new IndexOutOfBoundsException("Index is too big for this array");
        }
        array[index] = elem;
    }

    // set all elements to null and length to 0
    public void clear() {
        for (int i = 0; i < length; i++) {
            array[i] = null;
        }
        length = 0;
    }

    public void add(T element) {
        // check for capacity
        if (length + 1 > capacity) {
            // two cases a. capacity is zero, increment by 1, b. double the size
            if (capacity == 0) {
                capacity = 1;
            } else {
                capacity *= 2;
            }
            // create new array with new capacity
            T[] new_array = (T[]) new Object[capacity];
            /* copy each element from previous array
               system.arraycopy <=> for loop new_array[i] = array[i] */
            if (length >= 0) {
                System.arraycopy(array, 0, new_array, 0, length);
            }
            array = new_array;
        }
        // add element to the end
        array[length++] = element;
    }

    public void removeAt(int removable_index) {
        if (removable_index >= length && removable_index < 0) {
            throw new IndexOutOfBoundsException("Check your removable index");
        }

        T[] new_array = (T[]) new Object[length-1];
        for (int i = 0, j = 0; i < length; i++, j++) {
            // skip over removable index using j
            if (i == removable_index) {
                j--;
            } else {
                new_array[j] = array[i];
            }
        }
        array = new_array;
        capacity = length--;
    }
    
    public boolean remove(Object o) {
        for (int i = 0; i < length; i++) {
            if (array[i].equals(o)) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    public int indexOf(Object o) {
        for (int i = 0; i < length; i++) {
            if (array[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            int index = 0;
            @Override
            public boolean hasNext() { return index < length; }
            @Override
            public T next() { return array[index++]; }
            @Override
            public void remove() { throw new UnsupportedOperationException("Method not supported"); }
        };
    }

    @Override
    public String toString() {
        if (length == 0) {
            return "[]";
        } else {
            StringBuilder builder = new StringBuilder(length).append("[");
            for (int i = 0; i < length-1; i++) {
                builder.append(array[i]).append(", ");
            }
            return builder.append(array[length - 1]).append("]").toString();
        }
    }

    // demo
    public static void main(String[] args) {
        DynamicArray<Integer> arr = new DynamicArray<>();
        arr.add(5);
        arr.add(6);
        System.out.println(arr);

        assert arr.length == 2;
        arr.removeAt(1);

        assert arr.length == 1;

        arr.clear();
        assert arr.length == 0;
    }
}

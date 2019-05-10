package ru.academit.IvanVishnevsky.Garage.Garage.HashTable.HashTable.HashTable;

import java.util.*;

public class HashTable<T> implements Collection<T> {
    private int size;
    private T[] items;


    public HashTable() {
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    class MyIterator implements Iterator<T> {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            return null;
        }
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(items, size);
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a.length <= size) { //noinspection unchecked
            return (T1[]) toArray();
        }
        //noinspection SuspiciousSystemArraycopy
        System.arraycopy(items, 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    @Override
    public boolean add(T t) {

        items[size] = t;
        size++;
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (size == 0) {
            return false;
        }
        return false;
    }

    private void shiftCopy(int index, int newSize) {
        if (items.length < newSize) {
            Object[] newArray = new Object[newSize + size];
            System.arraycopy(items, 0, newArray, 0, size);
            //noinspection unchecked
            items = (T[]) newArray;
        }

        if (index < size) {
            System.arraycopy(items, index, items, newSize - (size - index), size - index);
        }
        size = newSize;
    }


    @Override
    public boolean remove(Object o) {
        if (size == 0) {
            return false;
        }
        int index = indexOf(o);
        if (size > 0) {
            shiftCopy(index + 1, size + 1);
            return true;
        }
        return false;
    }

    private int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(items[i], o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object e : c) {
            if (!contains(e)) {
                return false;
            }
        }
        return false;
    }


    @Override
    public boolean removeAll(Collection<?> c) {
        clear();
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        for (int i = 0; i < size; i++) {
            if (!c.contains(items[i])) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            items[i] = null;
            i -= 0;
        }
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            str.append(", ");
        }
        str.append("]");
        return str.toString();
    }
}

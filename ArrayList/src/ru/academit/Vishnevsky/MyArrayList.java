package ru.academit.Vishnevsky;

import java.util.*;

public class MyArrayList<T> implements List<T> {
    private T[] items;
    private int size;
    private int modCount = 0;


    public MyArrayList() {
        //noinspection unchecked
        items = (T[]) new Object[10];
    }

    public void increaseCapacity(int sizeItem) {
        int newSize = Math.max(sizeItem, size);
        items = Arrays.copyOf(items, items.length + newSize);
    }

    MyArrayList(T[] array) {
        //noinspection unchecked
        items = (T[]) new Object[array.length];
        increaseCapacity(array.length);
        System.arraycopy(array, 0, items, 0, array.length);
        size = array.length;
    }

    public void ensureCapacity(int capasity) {
        if (items.length >= capasity) {
            return;
        }
        items = Arrays.copyOf(items, capasity);
    }

    public void trimToSize() {
        if (items.length == size) {
            return;
        }
        items = Arrays.copyOf(items, size);
    }

    int getCapacity() {
        return items.length;
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
        for (int i = 0; i < size; i++) {
            if (Objects.equals(items[i], o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyListIterator();
    }

    private class MyListIterator implements Iterator<T> {
        private int currentIndex = -1;

        public boolean hasNext() {
            return currentIndex + 1 < size;
        }

        public T next() {
            ++currentIndex;
            return items[currentIndex];
        }
    }


    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}

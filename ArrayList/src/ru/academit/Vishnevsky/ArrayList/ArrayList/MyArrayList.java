package ru.academit.Vishnevsky.ArrayList.ArrayList;

import java.util.*;

public class MyArrayList<T> implements List<T> {
    private int size;
    private T[] items;
    private int modCount;


    public MyArrayList(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Неверный аргумент!");
        //noinspection unchecked
        items = (T[]) new Object[capacity];
    }


    private void increaseCapacity(int sizeItem) {
        int newItem = Math.max(sizeItem, size);
        items = Arrays.copyOf(items, items.length + newItem);
    }

    public void trimToSize() {
        if (items.length == size) {
            return;
        }
        items = Arrays.copyOf(items, size);
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
    public Object[] toArray() {
        return Arrays.copyOf(items, size);
    }

    @SuppressWarnings({"SuspiciousSystemArraycopy", "TypeParameterHidesVisibleType"})
    @Override
    public <T> T[] toArray(T[] array) {
        if (array.length <= size) {
            //noinspection unchecked
            return (T[]) toArray();
        }
        System.arraycopy(items, 0, array, 0, size);
        if (array.length > size) {
            array[size] = null;
        }
        return array;
    }

    private void checkIndex(int index, int size) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Неверный индекс!");
        }
    }

    public void ensureCapacity(int capacity) {
        if (items.length >= capacity) {
            return;
        }
        items = Arrays.copyOf(items, capacity);
    }

    @Override
    public boolean add(T element) {
        if (size + 1 >= items.length) {
            increaseCapacity(1);
        }
        items[size] = element;
        size++;
        modCount++;
        return true;
    }

    private void shiftAndCopy(int index, int newSize) {
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
    public void add(int index, T element) {
        checkIndex(index, size + 1);
        System.arraycopy(items, index, items, index + 1, items.length - index - 1);
        items[index] = element;
        ++size;
        ++modCount;
    }


    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (c.size() == 0) {
            return false;
        }
        if (size + c.size() >= items.length) {
            increaseCapacity(c.size());
        }
        for (T e : c) {
            add(e);
        }
        modCount++;
        return true;
    }


    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        checkIndex(index, size);
        if (c.size() == 0) {
            return false;
        }

        if (index < size) {
            int p = 0;
            for (T e : c) {
                add(index + p, e);
                p++;
            }
            return true;
        } else if (index == size) {
            addAll(c);
            return true;
        } else {
            size = index;
            addAll(c);
        }
        modCount++;
        return true;
    }

    @Override
    public T remove(int index) {
        checkIndex(index, size);
        T element = items[index];
        shiftAndCopy(index + 1, size - 1);
        modCount++;
        return element;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index >= 0) {
            shiftAndCopy(index + 1, size - 1);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if (c.size() == 0) {
            return false;
        }
        clear();
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object e : c) {
            if (!contains(e)) {
                return false;
            }
        }
        return true;
    }


    @Override
    public boolean retainAll(Collection<?> c) {
        for (int i = 0; i < size; i++) {
            if (!c.contains(items[i])) {
                remove(i);
                return true;
            }
            i++;
        }
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size - 1; i++) {
            items[i] = null;
            i -= 0;
        }
        size = 0;
    }

    @Override
    public T get(int index) {
        checkIndex(index, size);
        return items[index];
    }

    @Override
    public T set(int index, T element) {
        checkIndex(index, size);
        T tmp = items[index];
        items[index] = element;
        return tmp;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(items[i], o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i > 0; i--) {
            if (Objects.equals(items[i], o)) {
                return i;
            }
        }
        return -1;
    }


    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public ListIterator<T> listIterator() {
        return listIterator(0);
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        //noinspection ConstantConditions
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyListIterator();
    }

    public class MyListIterator implements Iterator<T> {
        private int currentIndex = -1;
        private int myModCount = modCount;

        @Override
        public boolean hasNext() {
            return currentIndex + 1 < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Коллекция кончилась!");
            }
            if (myModCount != modCount) {
                throw new ConcurrentModificationException("Список изменился!");
            }
            return items[currentIndex];
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                str.append(", ");
            }
            str.append(items[i]);
        }
        str.append("]");
        return str.toString();
    }
}

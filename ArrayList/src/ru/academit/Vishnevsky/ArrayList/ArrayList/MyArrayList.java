package ru.academit.Vishnevsky.ArrayList.ArrayList;

import java.util.*;

public class MyArrayList<T> implements List<T> {
    private int size;
    private T[] items;
    private int modCount;

    public MyArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Неверный аргумент!");
        }
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
        if (array == null) {
            throw new NullPointerException("Пустой массив!");
        }
        if (array.length < size) {
            //noinspection unchecked
            return (T[]) Arrays.copyOf(items, size, array.getClass());
        }
        System.arraycopy(items, 0, array, 0, size);
        if (array.length > size) {
            array[size] = null;
        }
        return array;
    }

    private void checkIndex(int index, int newSize) {
        if (index < 0 || index >= newSize) {
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

    @Override
    public void add(int index, T element) {
        checkIndex(index, size + 1);
        if (items.length == size) {
            increaseCapacity(1);
        }

        System.arraycopy(items, index, items, index + 1, size - index);
        items[index] = element;
        size++;
        modCount++;
    }


    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (c.size() == 0) {
            return false;
        }
        ensureCapacity(size + c.size());
        int index = size;
        for (T e : c) {
            items[index] = e;
            index++;
        }
        size += c.size();
        modCount++;
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        checkIndex(index, size + 1);
        if (c.size() == 0) {
            return false;
        }
        ensureCapacity(size + c.size());
        System.arraycopy(items, index, items, index + c.size(), size - index);
        int i = index;
        for (T e : c) {
            items[i] = e;
            i++;
        }
        size += c.size();
        modCount++;
        return true;
    }

    @Override
    public T remove(int index) {
        checkIndex(index, size);
        T tmp = items[index];
        System.arraycopy(items, index + 1, items, index, size - (index + 1));
        --size;
        ++modCount;
        return tmp;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if (c == null) {
            throw new NullPointerException("Список коллекций пуст!");
        }

        if (c.isEmpty()) {
            return false;
        }
        int tmp = modCount;
        for (Object e : c) {
            //noinspection StatementWithEmptyBody
            while (remove(e)) {
            }
        }
        return modCount != tmp;
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
        int tmp = modCount;
        for (int i = 0; i < size; i++) {
            if (!c.contains(items[i])) {
                remove(i);
                i--;
            }
        }
        return modCount != tmp;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            items[i] = null;
        }
        size = 0;
        modCount++;
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
        for (int i = size - 1; i >= 0; i--) {
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
            currentIndex++;
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


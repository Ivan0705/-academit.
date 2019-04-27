package ru.academit.Vishnevsky.ArrayList.ArrayList;

import java.util.*;

public class MyArrayList<T> implements List<T> {
    private int size;
    private T[] items;
    private int modCount;

    public MyArrayList(int capacity) {//noinspection unchecked
        items = (T[]) new Object[capacity];
    }

    public void trimToSize() {
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
        for (int i = 0; i < size; i++) {
            if (Objects.equals(items[i], o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        //noinspection unchecked
        return new MyListIterator();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(items, size);
    }

    @Override
    public <T> T[] toArray(T[] array) {
        //noinspection SuspiciousSystemArraycopy
        System.arraycopy(items, 0, array, 0, size);
        return array;
    }

    private void ensureCapacity() {
        items = Arrays.copyOf(items, items.length * 2);
    }

    @Override
    public boolean add(T element) {
        if (size >= items.length) {
            ensureCapacity();
        }
        items[size] = element;
        size++;
        modCount++;
        return true;
    }

    @Override
    public void add(int index, T element) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Неверный индекс!");
        }
        if (size == index) {
            add(element);
            return;
        }
        ensureCapacity();
        System.arraycopy(items, index, items, index + 1, size - index - 1);
        items[index] = element;
        size++;
        modCount++;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (c.size() == 0) {
            return false;
        }
        for (Object e : c) {
            //noinspection unchecked
            add((T) e);
        }

        modCount++;
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Индекс неверный!");
        }
        if (c.size() == 0) {
            return false;
        }
        if (index < size) {
            int p = 0;
            for (Object e : c) {
                //noinspection unchecked
                add(index + p, (T) e);
                p++;
            }
            return true;
        } else //noinspection ConstantConditions
            if (size == index) {
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
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Неверный индекс!");

        }
        T element = items[index];
        System.arraycopy(items, index + 1, items, index, size - index - 1);
        items[index] = element;
        size--;
        modCount++;
        return element;
    }

    @Override
    public boolean remove(Object o) {
        int myModCount = modCount;
        remove(indexOf(o));
        return myModCount != modCount;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        int myModCount = modCount;
        for (Object e : c) {
            remove(e);
        }
        return myModCount != modCount;
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
            }
            i++;
        }
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            items[i] = null;
        }
        size = 0;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Неверный индекс!");
        }

        return items[index];
    }

    @Override
    public T set(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Неверный индекс!");
        }
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
        for (int i = size - 1; i > size; i--) {
            if (Objects.equals(items[i], o)) {
                return i;
            }
        }
        return -1;
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

    public class MyListIterator implements Iterator {
        private int currentIndex = -1;
        private int MyModCount = modCount;

        @Override
        public boolean hasNext() {
            return currentIndex + 1 < size;
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Коллекция кончилась!");
            }
            if (MyModCount != modCount) {
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
                str.append(i).append(", ");
            }
            str.append(items[i]);
        }
        str.append("]");
        return str.toString();
    }
}

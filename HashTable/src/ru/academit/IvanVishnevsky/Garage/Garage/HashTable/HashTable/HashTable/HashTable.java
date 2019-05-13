package ru.academit.IvanVishnevsky.Garage.Garage.HashTable.HashTable.HashTable;

import java.util.*;

public class HashTable<T> implements Collection<T> {
    private int size;
    private ArrayList<T>[] list;
    private int modCount;


    public HashTable(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Отрицательное число!");
        }
        //noinspection unchecked
        list = (ArrayList<T>[]) new ArrayList[capacity];
    }

    private int getIndexElement(Object element) {
        if (element == null) {
            return 0;
        }
        return Math.abs(element.hashCode() % list.length);
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
        private int currentIndex = 0;
        private int myModCount = modCount;
        private int currentListElementIndex = -1;
        private int elementCounter = 0;

        @Override
        public boolean hasNext() {
            return elementCounter != size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Коллекция кончилась!");
            }
            if (myModCount != modCount) {
                throw new ConcurrentModificationException("Список изменился!");
            }
            if (list[currentIndex] != null && (currentListElementIndex < list[currentIndex].size() - 1)) {
                currentListElementIndex++;
            } else {
                currentIndex++;
                while (list[currentIndex] == null) {
                    currentIndex++;
                }
                currentListElementIndex = 0;
            }
            elementCounter++;
            return list[currentIndex].get(currentListElementIndex);
        }

    }

    @Override
    public Object[] toArray() {
        Iterator it = iterator();
        Object[] items = new Object[size];
        for (int i = 0; it.hasNext(); i++) {
            items[i] = it.next();
        }
        return items;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a == null) {
            throw new NullPointerException("Массив пустой!");
        }
        if (a.length < size) { //noinspection unchecked
            return (T1[]) Arrays.copyOf(list, size, a.getClass());
        }
        //noinspection SuspiciousSystemArraycopy
        System.arraycopy(list, 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    @Override
    public boolean add(T t) {
        int index = getIndexElement(t);
        if (list[index] == null) {
            list[index] = new ArrayList<>();
        }
        list[index].add(t);
        size++;
        modCount++;
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (size == 0) {
            return false;
        }

        for (T e : c) {
            add(e);
            size++;
        }
        size += c.size();
        return true;
    }


    @Override
    public boolean remove(Object o) {
        boolean isDeleted = false;

        int index = getIndexElement(o);
        if (list[index] != null) {
            isDeleted = list[index].remove(o);
        }
        size--;
        modCount++;

        return isDeleted;
    }

    private int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(list[i], o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        if (c == null) {
            throw new NullPointerException("Пустая коллекция!");
        }
        for (Object e : c) {
            if (!contains(e)) {
                return false;
            }
        }
        return false;
    }


    @Override
    public boolean removeAll(Collection<?> c) {
        if (c == null) {
            throw new NullPointerException("Пустая коллекция!");
        }
        int tmp = modCount;
        int index = getIndexElement(c);
        while (list[index] != null) {
            for (int i = 0; i < list[index].size() - 1; i++) {
                if (Objects.equals(list[index].get(i), c)) {
                    remove(list[index].get(i));
                    i--;
                }
            }
        }
        return tmp != modCount;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        if (c == null) {
            throw new NullPointerException("Пустая коллекция!");
        }

        for (int i = 0; i < size; i++) {
            if (!c.contains(list[i])) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < list.length; i++) {
            list[i] = null;
        }
        size = 0;
        modCount++;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                str.append("Ключ ")
                        .append(i).append(": ")
                        .append(list[i].toString())
                        .append(System.lineSeparator());
            }
        }
        return str.toString();

    }
}

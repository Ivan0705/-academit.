package ru.academit.IvanVishnevsky.Garage.Garage.HashTable.HashTable.HashTable;

import java.util.*;

public class HashTable<T> implements Collection<T> {
    private int size;
    private ArrayList<T>[] arrayLists;
    private int modCount;


    public HashTable(int capacity) {
        //noinspection unchecked
        arrayLists = (ArrayList<T>[]) new ArrayList[capacity];
    }

    private int getElementIndex(Object element) {
        if (element == null) {
            return 0;
        }
        return Math.abs(element.hashCode() % arrayLists.length);
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
        int index = getElementIndex(o);
        if (arrayLists[index] != null) {
            return arrayLists[index].contains(o);
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    class MyIterator implements Iterator<T> {
        private int currentIndex = 0;
        private int myModCount = modCount;
        private int currentListIndex = -1;
        private int countElement = 0;

        @Override
        public boolean hasNext() {
            return countElement != size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Коллекция кончилась!");
            }
            if (myModCount != modCount) {
                throw new ConcurrentModificationException("Список изменился!");
            }
            if (arrayLists[currentIndex] != null && currentListIndex < arrayLists[currentIndex].size() - 1) {
                currentListIndex++;
            } else {
                currentIndex++;
                while (arrayLists[currentIndex] == null) {
                    currentIndex++;
                }
                currentListIndex = 0;
            }
            countElement++;
            return arrayLists[currentIndex].get(currentListIndex);
        }
    }

    @Override
    public Object[] toArray() {

        Object[] items = new Object[size];
        int index = 0;
        for (T element : this) {
            items[index] = element;
            index++;
        }
        return items;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a == null) {
            throw new NullPointerException("Массив пустой!");
        }
        if (a.length < size) { //noinspection unchecked
            return (T1[]) Arrays.copyOf(arrayLists, size, a.getClass());
        }
        Object items = toArray();
        //noinspection SuspiciousSystemArraycopy
        System.arraycopy(items, 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    @Override
    public boolean add(T t) {
        int index = getElementIndex(t);
        if (arrayLists[index] == null) {
            arrayLists[index] = new ArrayList<>();
        }
        arrayLists[index].add(t);
        size++;
        modCount++;
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (c == null) {
            throw new IllegalArgumentException("Список коллекций пуст!");
        }
        if (size == 0) {
            return false;
        }

        for (T e : c) {
            add(e);
        }
        return true;
    }


    @Override
    public boolean remove(Object o) {
        if (o == null) {
            throw new IllegalArgumentException("Список пуст!");
        }
        boolean isDeleted = false;
        int index = getElementIndex(o);


        if (arrayLists[index].size() != 0) {
            isDeleted = arrayLists[index].remove(o);
        }

        if (arrayLists[index].size() == 0) {
            arrayLists[index] = null;
        }
        size--;
        modCount++;
        return isDeleted;
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
        return true;
    }


    @Override
    public boolean removeAll(Collection<?> c) {
        if (c == null) {
            throw new NullPointerException("Пустая коллекция!");
        }
        if (c.size() == 0) {
            return false;
        }
        int tmp = modCount;
        for (Object e : c) {
            int index = getElementIndex(e);
            //noinspection SuspiciousMethodCalls
            while (arrayLists[index] != null && arrayLists[index].remove(c)) {
                size--;
                modCount++;
            }
        }
        return modCount != tmp;
    }


    @Override
    public boolean retainAll(Collection<?> c) {
        if (c == null) {
            throw new NullPointerException("Пустая коллекция!");
        }
        int tmp = modCount;
        for (ArrayList<T> p : arrayLists) {
            int currentSize = arrayLists.length;
            if (p != null) {
                while (p.retainAll(c)) {
                    size--;
                    size -= currentSize - p.size();
                    modCount++;
                }
            }
        }
        return modCount != tmp;
    }

    @Override
    public void clear() {
        for (int i = 0; i < arrayLists.length; i++) {
            arrayLists[i] = null;
        }
        size = 0;
        modCount++;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < arrayLists.length; i++) {
            if (arrayLists[i] != null) {
                str.append("Ключ ")
                        .append(i).append(": ")
                        .append(arrayLists[i].toString())
                        .append(System.lineSeparator());
            }
        }
        return str.toString();
    }
}

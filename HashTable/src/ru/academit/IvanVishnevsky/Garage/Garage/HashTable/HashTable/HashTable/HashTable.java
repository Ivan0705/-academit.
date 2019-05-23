package ru.academit.IvanVishnevsky.Garage.Garage.HashTable.HashTable.HashTable;

import java.util.*;

public class HashTable<T> implements Collection<T> {
    private int size;
    private ArrayList<T>[] lists;
    private int modCount;

    public HashTable() {
        //noinspection unchecked
        lists = (ArrayList<T>[]) new ArrayList[10];
    }

    public HashTable(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Вместимость списка должна быть  больше нуля!");
        }
        //noinspection unchecked
        lists = (ArrayList<T>[]) new ArrayList[capacity];
    }

    private int getElementIndex(Object element) {
        if (element == null) {
            return 0;
        }
        return Math.abs(element.hashCode() % lists.length);
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
        if (lists[index] != null) {
            return lists[index].contains(o);
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
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
            if ((lists[currentIndex] != null) && (currentListIndex != lists[currentIndex].size() - 1)) {
                currentListIndex = -1;
                currentListIndex++;
            } else {
                currentIndex++;
                while (lists[currentIndex] == null) {
                    currentIndex++;
                }
                currentListIndex = 0;
            }
            countElement++;
            return lists[currentIndex].get(currentListIndex);
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
        Object[] items = toArray();
        if (a.length < size) { //noinspection unchecked
            return (T1[]) Arrays.copyOf(items, size, a.getClass());
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
        int index = getElementIndex(t);
        if (lists[index] == null) {
            lists[index] = new ArrayList<>();
        }
        //noinspection
        lists[index].add(t);
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
        }
        return true;
    }


    @Override
    public boolean remove(Object o) {
        boolean isDeleted = false;
        int index = getElementIndex(o);

        if (lists[index] != null) {
            isDeleted = lists[index].remove(o);
        }

        if (lists[index].size() == 0) {
            lists[index] = null;
        }
        if (isDeleted) {
            size--;
            modCount++;
        }
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
            while (lists[index] != null && lists[index].remove(c)) {
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
        //noinspection
        for (ArrayList<T> p : lists) {
            if (p != null) {
                int currentSize = p.size();
                if (p.retainAll(c)) {
                    size -= currentSize - p.size();
                    modCount++;
                }
            }
        }
        return modCount != tmp;
    }

    @Override
    public void clear() {
        for (int i = 0; i < lists.length; i++) {
            lists[i] = null;
        }
        size = 0;
        modCount++;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                str.append("Ключ ")
                        .append(i).append(": ")
                        .append(lists[i].toString())
                        .append(System.lineSeparator());
            }
        }
        return str.toString();
    }
}

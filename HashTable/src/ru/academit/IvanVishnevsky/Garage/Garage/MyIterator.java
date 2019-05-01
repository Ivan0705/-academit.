package ru.academit.IvanVishnevsky.Garage.Garage;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyIterator<T> implements Iterator<T> {
    int currentIndex = -1;
    private int size;
    private T[] item;
    private int modCopunt;

    @Override
    public boolean hasNext() {
        return currentIndex + 1 < size;
    }

    @Override
    public T next() {
        int myModCount = modCopunt;
        if (myModCount != modCopunt) {
            throw new ConcurrentModificationException("Список изменился!");
        }
        if (!hasNext()) {
            throw new NoSuchElementException("Коллекция кончилась!");
        }
        currentIndex++;
        return item[currentIndex];
    }
}

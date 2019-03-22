package ru.academit.Vishnevsky.List;

public class LinkedList<T> {
    private int count;
    private ListItem<T> head;
    private ListItem<T> last;

    public LinkedList() {
    }

    public void sizeList(int count) {
        count++;
    }

    public T getFirstElement() {
        if (count == 0) {
            throw new IllegalArgumentException("Список пустой");
        }
        return head.getData();
    }



}

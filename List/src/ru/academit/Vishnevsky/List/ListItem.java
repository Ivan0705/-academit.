package ru.academit.Vishnevsky.List;

public class ListItem<T> {
    private ListItem<T> next;
    private T data;

    public ListItem() {
    }

    public ListItem(ListItem<T> next, T data) {
        this.data = data;
        this.next = next;
    }

    public ListItem(ListItem<T> next) {
        this.next = next;
    }

    public ListItem(T data) {
        this.data = data;
    }

    public ListItem<T> getNext() {
        return next;
    }


    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setNext(ListItem<T> next) {
        this.next = next;
    }

}

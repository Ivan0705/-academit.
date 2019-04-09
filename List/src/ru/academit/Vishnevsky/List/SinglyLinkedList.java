package ru.academit.Vishnevsky.List;

import java.util.Objects;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public int getSize() {
        return count;
    }

    public T getFirstElement() {
        return head.getData();
    }

    private ListItem<T> getElement(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Неверный индекс!");
        }
        ListItem<T> element = head;
        int countElement = 0;
        while (countElement != index) {
            countElement++;
            element = element.getNext();
        }
        return element;
    }

    public T getElementData(int index) {
        return getElement(index).getData();
    }

    public void addFirstElement(T data) {
        ListItem<T> element = new ListItem<>(data, head);
        head = element;
        count++;
        if (count == 0) {
            head.setNext(element);
            head = element;
        }
    }

    public void addElement(T data) {
        ListItem<T> element = new ListItem<>(data, head);
        if (head == null) {
            head = element;
            count++;
        } else {
            element.setNext(head);
            head = element;
            count++;
        }
    }

    public void addElement(int index, T data) {
        if (index > count) {
            throw new IndexOutOfBoundsException("Неверный индекс!");
        }
        ListItem<T> element = new ListItem<>(data);
        if (index == 0) {
            addFirstElement(data);
        } else if (index == count) {
            element.setNext(head);
            head = element;
            count++;

        } else {
            ListItem<T> tmp = getElement(index - 1);
            element.setNext(tmp.getNext());
            tmp.setNext(element);
            count++;
        }
    }

    public T deleteFirstElement() {
        T tmp1 = head.getData();
        head = head.getNext();
        if (count == 0) {
            tmp1 = null;
        }
        count--;
        return tmp1;
    }

    public T deleteElement(int index) {
        if (index > count) {
            throw new IndexOutOfBoundsException("Неверный индекс!");
        }
        ListItem<T> tmp;
        if (index == 0) {
            deleteFirstElement();
        }
        if (index + 1 == count) {
            tmp = getElement(index - 1);
            tmp = tmp.getNext();
            tmp.setNext(null);
        } else {
            ListItem<T> tmp2 = getElement(index - 1);
            tmp = tmp2.getNext();
            tmp2.setNext(tmp.getNext());
        }
        --count;
        return tmp.getData();
    }

    public boolean deleteValue(T data) {
        if (Objects.equals(head.getData(), data)) {
            head = head.getNext();
            count--;
            if (count == 0) {
                head = null;
            }
            return true;
        }

        for (ListItem<T> p = head; p != null && p.getNext() != null; p = p.getNext()) {
            if (Objects.equals(p.getData(), data)) {
                if (p.getNext() == head.getNext()) {
                    p = head;
                }
                p.setNext(p.getNext().getNext());
                count--;
                return true;
            }
            if (p.getNext().getNext() == null) {
                return false;
            }
        }
        return false;
    }

    public T set(T data, int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Неверный индекс!");
        }
        ListItem<T> tmp = getElement(index);
        T oldData = tmp.getData();
        tmp.setData(data);
        return oldData;
    }

    public void reverse() {
        if (head == null) {
            System.out.println("Разворот невозможен!");
        }
        ListItem<T> lastElement = head;
        for (ListItem<T> p = head, prev = null, prevPrev = null; p != null; prev = p, p = p.getNext()) {
            if (p == head) {
                p = lastElement;
                continue;
            }
            prev.setNext(prevPrev);
            prevPrev = prev;
            if (p.getNext() == null) {
                head = p;
                head.setNext(prev);
                break;
            }
        }
    }

    public SinglyLinkedList copyList() {
        SinglyLinkedList<T> newList = new SinglyLinkedList<>();

        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            newList.addElement(p.getData());
        }
        return newList;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            str.append(p.getData()).append(System.lineSeparator());
        }
        return str.toString();
    }
}
package ru.academit.Vishnevsky.List;
import java.util.Objects;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private ListItem<T> tail;
    private int count;

    public int getSizeList() {
        return count;
    }

    public T getFirstElement() {
        if (count == 0) {
            throw new IllegalArgumentException("Список пустой");
        }
        return head.getData();
    }

    public ListItem<T> getElement(int index) {
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
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Неверный индекс!");
        }
        return getElement(index).getData();
    }

    public void addFirstElement(T data) {
        ListItem<T> element = new ListItem<>(data);
        head = element;
        if (count==0) {
            tail = element;
        }
        count++;
    }

    public void addElement(T data) {
        ListItem<T> element = new ListItem<>(data);
        if (head == null) {
            head = element;
            tail = element;
            count++;
        } else {
            tail.setNext(element);
            tail = element;
            count++;
        }
    }

    public void addElement(T data, int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Неверный индекс!");
        }
        ListItem<T> element = new ListItem<>(data);
        if (count == 0) {
            addFirstElement(data);
        } else if (count == index) {
            tail.setNext(element);
            tail = element;
            count++;
        } else {
            ListItem<T> tmp = getElement(index - 1);
            element.setNext(tmp.getNext());
            tmp.setNext(element);
            count++;
        }
    }

    public T deleteFirstElement() {
        if (head == null) {
            throw new IndexOutOfBoundsException("еверный индекс!");
        }
        T tmp1 = head.getData();
        head = head.getNext();
        if (count == 0) {
            tail = null;
        }
        count--;
        return tmp1;
    }

    public T deleteElement(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Неверный индекс!");
        }
        ListItem<T> tmp;
        if (index == 0) {
            deleteFirstElement();
        }
        if (count == index + 1) {
            tail = getElement(index - 1);
            tmp = tail.getNext();
            tail.setNext(null);
        } else {
            ListItem<T> tmp2 = getElement(index - 1);
            tmp = tmp2.getNext();
            tail.setNext(tmp.getNext());
        }
        count--;
        return tmp.getData();
    }

    public boolean isDeleteValue(T data) {
        if (count == 0) {
            throw new IllegalArgumentException("Список пустой!!");
        }
        if (Objects.equals(head.getData(), data)) {
            head = head.getNext();
            count--;
            if (count == 0) {
                tail = null;
            }
            return true;
        }

        for (ListItem<T> p = head; p != null && p.getNext() != null; p = p.getNext()) {
            if (Objects.equals(p.getData(), data)) {
                if (p.getNext() == tail) {
                    p = tail;
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

    public void reverce() {
        if (head != null) {
            for (ListItem<T> p = head, prev = null, prevPrev = null; p != null; prev = p, p = p.getNext()) {
                if (p == head) {
                    tail = p;
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
    }

    public SinglyLinkedList<T> copyList() {
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

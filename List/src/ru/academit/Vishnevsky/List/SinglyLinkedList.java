package ru.academit.Vishnevsky.List;

import java.util.Objects;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public int getSize() {
        return count;
    }

    public T getFirstElement() {
        if (count == 0) {
            throw new NullPointerException("Список пуст!");
        }
        return head.getData();
    }

    private ListItem<T> getElement(int index) {
        ListItem<T> element = head;
        int i = 0;
        while (i != index) {
            i++;
            element = element.getNext();
        }
        return element;
    }

    public T getElementData(int index) {
        return getElement(index).getData();
    }

    public void addFirstElement(T data) {
        head = new ListItem<>(data, head);
        count++;
    }

    public void addElement(T data) {
        ListItem<T> element = new ListItem<>(data);
        if (head == null) {
            head = element;
        } else {
            ListItem<T> tail = getElement(count - 1);
            tail.setNext(element);
        }
        count++;
    }

    public void addElement(int index, T data) {
        if (index > count || index < 0) {
            throw new IndexOutOfBoundsException("Не верный индекс");
        }

        if (index == 0) {
            addFirstElement(data);
        } else {
            ListItem<T> element = new ListItem<>(data);
            ListItem<T> tmp = getElement(index - 1);
            element.setNext(tmp.getNext());
            tmp.setNext(element);
            count++;
        }
    }

    public T deleteFirstElement() {
        if (count == 0) {
            throw new NullPointerException("Список пуст!");
        }
        T tmp1 = head.getData();
        head = head.getNext();
        count--;
        return tmp1;
    }

    public T deleteElement(int index) {
        if (index >= count || index < 0) {
            throw new IndexOutOfBoundsException("Не верный индекс!");
        }
        if (index == 0) {
            return deleteFirstElement();
        }
        ListItem<T> tmpElement2 = getElement(index - 1);
        ListItem<T> tmpElement1 = tmpElement2.getNext();
        tmpElement2.setNext(tmpElement1.getNext());
        --count;
        return tmpElement1.getData();
    }

    public boolean deleteValue(T data) {
        for (ListItem<T> p = head, prev = null; p != null; prev = p, p = p.getNext()) {
            if (Objects.equals(p.getData(), data)) {
                if (prev == null) {
                    head = p.getNext();
                } else {
                    prev.setNext(p.getNext());
                }
                count--;
                return true;
            }
        }
        return false;
    }

    public T set(int index, T data) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Неверный индекс!");
        }
        ListItem<T> tmp = getElement(index);
        T oldData = tmp.getData();
        tmp.setData(data);
        return oldData;
    }

    public void reverse() {
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

    public SinglyLinkedList<T> cloneList() {
        SinglyLinkedList<T> copyList = new SinglyLinkedList<>();
        if (head == null) {
            return copyList;
        }
        ListItem<T> item = new ListItem<>(head.getData(), null);

        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            if (p == head) {
                copyList.head = head;
            } else {
                ListItem<T> copyItem = new ListItem<>(p.getData(), p.getNext());
                item.setNext(copyItem);
                item = copyItem;
                p = p.getNext();
            }
        }
        copyList.count = count;
        return copyList;
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
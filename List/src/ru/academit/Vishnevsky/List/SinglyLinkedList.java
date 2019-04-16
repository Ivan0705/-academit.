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
            throw new IllegalArgumentException("Список пуст!");
        }
        return head.getData();
    }

    private ListItem<T> getElement(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Неверный индекс!");
        }
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
        ListItem<T> element = new ListItem<>(data, head);
        head = element;
        count++;
        if (count == 0) {
            head.setNext(element);
        }
    }

    public void addElement(T data) {
        ListItem<T> element = new ListItem<>(data);

        if (head == null) {
            head = element;
        } else {
            ListItem<T> tmp = getElement(count - 1);
            tmp.setNext(element);
            count++;
        }
    }

    public void addElement(int index, T data) {
        if (index > count || index < 0) {
            throw new IndexOutOfBoundsException("Неверный индекс!");
        }
        if (index == 0) {
            addFirstElement(data);
        } else if (index == count) {
            ListItem<T> tail = getElement(count);
            head.setNext(tail);
            head = tail;
            count++;
        } else {
            ListItem<T> element = new ListItem<>(data);
            ListItem<T> tmp = getElement(index);
            element.setNext(tmp.getNext());
            tmp.setNext(element);
            count++;
        }
    }

    public T deleteFirstElement() {
        if (count == 0) {
            throw new IllegalArgumentException("Список пуст!");
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
        ListItem<T> tmpElements1;
        if (index + 1 == count) {
            ListItem<T> lastElements = getElement(index - 1);
            tmpElements1 = lastElements.getNext();
            lastElements.setNext(null);
        } else {
            ListItem<T> tmpElements2 = getElement(index - 1);
            tmpElements1 = tmpElements2.getNext();
            tmpElements2.setNext(tmpElements1.getNext());
        }
        --count;
        return tmpElements1.getData();
    }

    public boolean deleteValue(T data) {
        if (count == 0) {
            throw new IllegalArgumentException("Список пуст!");
        }
        if (Objects.equals(head.getData(), data)) {
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
            throw new IllegalArgumentException("Список пуст!");
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

    public SinglyLinkedList<T> copyList() {
        ListItem<T> lastElement = getElement(count - 1);
        for (ListItem<T> p = head, prev = null; p != null; prev = p, p = p.getNext()) {
            if (p == head) {
                p = lastElement;
                continue;
            }
            prev.setNext(lastElement);
            lastElement = prev;
            if (p.getNext() == null) {
                head = p;
                head.setNext(prev);
                break;
            }
        }
        return new SinglyLinkedList<>();
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
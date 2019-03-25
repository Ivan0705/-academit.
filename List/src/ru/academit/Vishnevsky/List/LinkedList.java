package ru.academit.Vishnevsky.List;

import java.util.List;

public class LinkedList<T> {
    private int count;
    private ListItem<T> head;
    private ListItem<T> last;

    public LinkedList() {
    }

    public int sizeList(int count) {
      return  count;
    }

    public T getFirstElement() {
        if (count == 0) {
            throw new IllegalArgumentException("Список пустой");
        }
        return head.getData();
    }

    public T deleteFirst() {
        if (head == null) {
            throw new IllegalArgumentException("Неверный индекс!");
        }
        T tmp = head.getData();
        head = head.getNext();
        count--;
        if (count == 0) {
            last = null;
        }
        return tmp;
    }


    public T deleteElement(int index) {
        if(index<0 || index>=count)
        {throw new IllegalArgumentException("Неверный индекс!");}
        if (count == 0) {
            return deleteFirst();
        }

        ListItem<T> tmp1;
        if (index + 1 == count) {
            last = getElement(index - 1);
            tmp1 = last.getNext();
            last.setNext(null);
        } else {
            ListItem<T> tmp2=getElement(index-1);
            tmp1=tmp2.getNext();
            last.setNext(tmp1.getNext());
        }
        count--;
        return tmp1.getData();
    }

    public T getElementData(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("неверный индекс!");
        }
        return getElement(index).getData();
    }

    public ListItem<T> getElement(int index) {
        int countElement = 0;
        ListItem<T> tmpE = head;
        while (countElement != index) {
            countElement++;
            tmpE = tmpE.getNext();
        }
        return tmpE;
    }

    public void addEFirstlement(T data) {
        ListItem<T> element = new ListItem<>(head, data);
        head = element;
        count++;
        if (last == null) {
            last = head;
        }
    }

    public void addElement(T data) {
        ListItem<T> element = new ListItem<>(data);
        if (head == null) {
            head = element;
            last = element;
            count++;
        } else {
            last.setNext(element);
            last = element;
            count++;
        }
    }

    public void reverce() {
        if (head == null) {
            for (ListItem<T> p = head, prev = null, prevPrev = null; p != null; prev = p, p = p.getNext()) {
                if (p == head) {
                    last = p;
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

}

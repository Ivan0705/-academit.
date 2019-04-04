package ru.academit.Vishnevsky.Main;

import ru.academit.Vishnevsky.List.SinglyLinkedList;


public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addElement(1);
        list.addElement(1);
        list.addElement(5);
        list.addElement(null, 1);
        System.out.println(list);
        System.out.println(list.set(2, 3));
        System.out.println();

        list.reverce();
        System.out.println(list);
        list.deleteFirstElement();

        System.out.println(list.toString());
        System.out.println();

        System.out.println(list.copyList());
        System.out.println();

        list.deleteFirstElement();
        System.out.println(list);
        System.out.println();

        System.out.println(list.deleteElement(1));
        System.out.println();

        System.out.println(list.getFirstElement());
        System.out.println();

        System.out.println("Размер текущего списка: " + list.getSizeList());
        System.out.println();
        try {
            System.out.println("Значение по индексу 1: " + list.getElementData(1));
            System.out.println();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Неверный индекс!");
        }
        try {
            System.out.println("Удаление по индексу 1: " + list.deleteElement(1));
            System.out.println();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Неверный индекс!");
        }
        System.out.println();
        System.out.println("Разменр списка: " + list.getSizeList());

        System.out.println();
        System.out.println("Получение первый элемент: " + list.getFirstElement());

        System.out.println();
        list.addFirstElement(1);
        System.out.println(list.toString());

        System.out.println();
        list.addElement(6);
        System.out.println(list.toString());

        System.out.println();
        list.isDeleteValue(1);
        System.out.println(list.toString());

        System.out.println();
        list.addElement(1);
        list.addElement(1);
        list.addElement(5);
        System.out.println(list);
        System.out.println();

        list.set(1, 2);
        System.out.println(list);
        System.out.println();

        System.out.println(list.toString());
        list.addElement(9, 1);
        System.out.println(list.toString());
        System.out.println();

        list.getElement(1);
        System.out.println(list.toString());
    }

}

package ru.academit.Vishnevsky.Main;

import ru.academit.Vishnevsky.List.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addFirstElement(1);
        System.out.println("Первый элемент: " + list);

        list.addElement(1);
        list.addElement(1);
        list.addElement(5);
        System.out.println(list);

        System.out.println("Копирование списка:" + System.lineSeparator() + list.copyList());
        System.out.println();

        list.addElement(4, null);
        System.out.println("Добавление элемента null по индексу 4: " + System.lineSeparator() + list);
        System.out.println();

        System.out.println("Замена элемента по индексу: " + list.set(2, 1));
        System.out.println();

        System.out.println("Новый список: " + System.lineSeparator() + list);
        System.out.println();

        list.reverse();
        System.out.println("Разворот списка: " + System.lineSeparator() + list);
        System.out.println();

        System.out.println("Удаление первого элемента: " + list.deleteFirstElement());
        System.out.println();

        System.out.println("Удаление элемента по индексу 1: " + list.deleteElement(1));
        System.out.println();

        System.out.println(list);
        System.out.println();

        System.out.println("Получение первого элемента из списка по индексу: " + list.getFirstElement());
        System.out.println();

        System.out.println("Размер текущего списка: " + list.getSize());
        System.out.println();
        try {
            System.out.println("Значение по индексу 0: " + list.getElementData(0));
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
        System.out.println("Размер списка: " + list.getSize());


        System.out.println();
        list.addElement(1);

        System.out.println("Новый список: " + System.lineSeparator() + list.toString());
        System.out.println();

        list.addElement(6);
        System.out.println("Добавление элемента " + list.toString());
        System.out.println();

        System.out.println("Новый список: " + System.lineSeparator() + list.toString());
        System.out.println();

        System.out.println("Удаление элемета 6 : " + list.deleteValue(6));
        System.out.println();

        list.addElement(0, 1);
        list.addElement(1);
        list.addElement(5);
        System.out.println("Получаем совершенно новый список: " + System.lineSeparator() + list);
        System.out.println();

        System.out.println("Получение первого элемента: " + list.getFirstElement());
        System.out.println();

        list.set(8, 3);
        System.out.println("Меняем элемент " + "8" + " по индексу 3: " + System.lineSeparator() + list);
        System.out.println();

        list.addElement(1, 33);
        System.out.println("Добавление по индексу 1: " + System.lineSeparator() + list.toString());
        System.out.println();

        System.out.println("Удаление последнего индекса: " + list.deleteElement(6));
    }
}

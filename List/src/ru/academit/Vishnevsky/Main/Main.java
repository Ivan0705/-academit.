package ru.academit.Vishnevsky.Main;

import ru.academit.Vishnevsky.List.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addFirstElement(1);
        System.out.println("Первый элемент: " + list);

        list.addFirstElement(1);
        list.addFirstElement(1);
        list.addFirstElement(5);
        System.out.println(list);

        list.reverse();
        System.out.println("Разворот списка: " + System.lineSeparator() + list);

        list.addElement(4, null);
        System.out.println("Добавление элемента null по индексу 3: " + System.lineSeparator() + list);
        System.out.println();
/*
        list.set(2, 1);
        System.out.println("Замена элемента по индексу 1: " + System.lineSeparator() + list);
        System.out.println();

        System.out.println("Новый список: " + System.lineSeparator() + list);
        System.out.println();

        list.reverse();
        System.out.println("Разворот списка: " + System.lineSeparator() + list);
        System.out.println();

        list.deleteFirstElement();
        System.out.println("Удаление первого элемента: " + System.lineSeparator() + list);
        System.out.println();

        System.out.println("Удаление элемета 6 : " + System.lineSeparator() + list.deleteValue(1));
        System.out.println();

        list.deleteElement(2);
        System.out.println("Удаление элемента по индексу 2: " + System.lineSeparator() + list);
        System.out.println();

        list.getFirstElement();
        System.out.println("Получение первого элемента из списка по индексу: " + list);
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
        list.addElement(6);

        System.out.println("Новый список: " + System.lineSeparator() + list);
        System.out.println();

        list.addElement(6);
        System.out.println("Добавление элемента " + list.toString());
        System.out.println();

        System.out.println("Новый список: " + System.lineSeparator() + list);
        System.out.println();

        System.out.println("Удаление элемета 6 : " + System.lineSeparator() + list.deleteValue(6));
        System.out.println();

        System.out.println("После удаления элемента по назначению: " + System.lineSeparator() + list);
        list.addElement(0, 1);
        list.addElement(1);
        list.addElement(5);
        System.out.println("Получаем совершенно новый список: " + System.lineSeparator() + list);
        System.out.println();

        list.getFirstElement();
        System.out.println("Получение первого элемента: " + list);
        System.out.println();

        list.set(8, 3);
        System.out.println("Меняем элемент " + "8" + " по индексу 3: " + System.lineSeparator() + list);
        System.out.println();

        list.addElement(1, 33);
        System.out.println("Добавление по индексу 1: " + System.lineSeparator() + list);
        System.out.println();

        list.deleteElement(5);
        System.out.println("Удаление последнего индекса: " + System.lineSeparator() + list);

        list.cloneList();
        System.out.println("Копирует список: " + System.lineSeparator() + list);*/
    }
}

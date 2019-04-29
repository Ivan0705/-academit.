package ru.academit.Vishnevsky.ArrayList.Main;

import ru.academit.Vishnevsky.ArrayList.ArrayList.MyArrayList;

public class Main {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>(10);
        list.add("1 element");
        list.add("2 element");
        list.add("3 element");
        System.out.println(list);

        list.add("9 element");
        System.out.println(list);

        list.remove("1 element");
        System.out.println(list);

        list.trimToSize();
        System.out.println( list);

        System.out.println(list.contains("2 element"));
        System.out.println("\"3 element\" входит в список: " + list.contains("3 element"));

        list.clear();
        System.out.println(list);

        System.out.println("Длина списка: " + list.size());
        System.out.println("Список пуст: " + list.isEmpty());

        System.out.println("Элемент \"2 element\" находится на " + list.lastIndexOf("2 element") + " позиции");
        System.out.println("Элемент \"9 element\" находится на " + list.indexOf("9 element") + " позиции");

        System.out.println();

    }
}
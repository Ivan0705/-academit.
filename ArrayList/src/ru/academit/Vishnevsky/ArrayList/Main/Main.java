package ru.academit.Vishnevsky.ArrayList.Main;

import ru.academit.Vishnevsky.ArrayList.ArrayList.MyArrayList;

public class Main {
    public static void main(String[] args) {
        MyArrayList<String> list1 = new MyArrayList<>(10);

        list1.add("1 element");
        list1.add("2 element");
        list1.add("3 element");
        list1.add(3, "33");
        System.out.println(list1);


        MyArrayList<String> list2 = new MyArrayList<>(10);
        list2.add("1 ");
        list2.add("2 ");
        list2.add("3 ");
        System.out.println(list2);

        System.out.println( list1);
        list1.retainAll(list2);
        System.out.println("1" + list2);
        System.out.println("2" + list2);
        list1.removeAll(list2);
        System.out.println(list1);
        System.out.println(list2);

        System.out.println("\"3 element\" входит в список: " + list1.contains("3 element"));
        list1.trimToSize();

        System.out.println(list1.contains("2 element"));
        System.out.println("\"3 element\" входит в список: " + list1.contains("3 element"));

        list1.clear();
        System.out.println(list1);

        System.out.println("Длина списка: " + list1.size());
        System.out.println("Список пуст: " + list1.isEmpty());

        System.out.println("Элемент \"2 element\" находится на " + list1.lastIndexOf("2 element") + " позиции");
        System.out.println("Элемент \"9 element\" находится на " + list1.indexOf("9 element") + " позиции");
        list1.ensureCapacity(2);
        System.out.println(list1);


    }
}
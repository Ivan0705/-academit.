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
        list2.add("1");
        list2.add("2");
        list2.add("3");
        list2.add(3, "4");
        System.out.println(list2);
    }
}
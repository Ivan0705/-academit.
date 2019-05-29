package ru.academit.IvanVishnevsky.Garage.Garage.HashTable.HashTable.Main;

import ru.academit.IvanVishnevsky.Garage.Garage.HashTable.HashTable.HashTable.HashTable;

public class Main {
    public static void main(String[] args) {
        HashTable<String> table1 = new HashTable<>(10);
        table1.add("");
        table1.add("cat1");
        table1.add("cat2");
        table1.add("cat3");
        table1.remove("cat1");
        System.out.println(table1);

        HashTable<String> table2 = new HashTable<>();
        table2.add("");
        table2.add("");
        table2.add("");
        table2.add("dog1");
        table2.add("dog2");
        table2.add("dog3");
        System.out.println(table2);
        table1.addAll(table2);
        System.out.println(table1);
    }
}

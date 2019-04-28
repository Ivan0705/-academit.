package ru.academit.IvanVishnevsky.Main.Person;

public class Person {
    private double age;
    private String name;

    public Person(String name, double age) {
        this.name = name;
        this.age = age;
    }

    public double getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

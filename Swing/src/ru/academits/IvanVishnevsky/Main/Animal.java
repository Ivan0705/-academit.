package ru.academits.IvanVishnevsky.Main;

import ru.academits.IvanVishnevsky.Temperature.Dog;

public class Animal {
    public static void main(String[] args) {
        Dog dog = new Dog();
        go(dog);
        System.out.println(dog);
    }

    private static void go(Dog dog) {
        String dogName = "Rex";
        dog.setName(dogName);
    }
}

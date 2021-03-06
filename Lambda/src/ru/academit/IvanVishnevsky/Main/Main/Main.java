package ru.academit.IvanVishnevsky.Main.Main;

import ru.academit.IvanVishnevsky.Main.Person.Person;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.averagingDouble;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("Анна", 24),
                new Person("Мария", 32),
                new Person("Владимир", 23),
                new Person("Мария", 15),
                new Person("Владимир", 17),
                new Person("Василий", 55));

        List<Person> allName1 = persons.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Список уникальных имен: " + allName1);
        System.out.println();

        String allName2 = persons.stream()
                .map(Person::getName)
                .distinct()
                .collect(Collectors.joining(", "));
        System.out.println("Список уникальных имен в новом формате: " + allName2);
        System.out.println();

        Map<String, Double> personByMiddleAge = persons
                .stream()
                .collect(Collectors.groupingBy(Person::getName, averagingDouble(Person::getAge)));
        personByMiddleAge.forEach((k, v) -> System.out.println("Средний возраст: " + k + " - " + v));

        List<Person> personUnder18 = persons
                .stream()
                .filter(p -> p.getAge() < 18)
                .collect(Collectors.toList());
        Double averageAgeOfPersonUnder18 = personUnder18
                .stream()
                .filter(p -> p.getAge() < 18)
                .collect(Collectors.averagingDouble(Person::getAge));
        System.out.println("Средний возраст до 18 лет: " + averageAgeOfPersonUnder18 + " - " + personUnder18);

        List<Person> personsByAgeFrom20To45 = persons
                .stream()
                .filter(p -> p.getAge() >= 20 && p.getAge() <= 45)
                .sorted((p1, p2) -> (p2.getAge() - p1.getAge()))
                .collect(Collectors.toList());

        personsByAgeFrom20To45.stream()
                .map(p -> p.getAge() + ": " + p.getName())
                .forEach(System.out::println);
    }
}



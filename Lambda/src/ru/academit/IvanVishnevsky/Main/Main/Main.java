package ru.academit.IvanVishnevsky.Main.Main;

import ru.academit.IvanVishnevsky.Main.Person.Person;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("Анна", 24),
                new Person("Мария", 32),
                new Person("Владимир", 23),
                new Person("Мария", 15),
                new Person("Владимир", 17),
                new Person("Василий", 55));

        List allName1 = persons.stream()
                .map(Person::getName)
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

        /*Map<String, Double> ps1 = persons
                .stream()
                .collect(Collectors.toMap(Person::getName, Person::getAge));
        ps1.forEach((k, v) -> System.out.println(k + " - " + v));*/

        Map<Double, List<Person>> personsByMiddleAge = persons
                .stream()
                .collect(Collectors.groupingBy(Person::getAge));
        Double averageAge = persons
                .stream()
                .filter(p -> p.getAge() < 18)
                .collect(Collectors.averagingDouble(Person::getAge));
        personsByMiddleAge.forEach((age, p) ->
                System.out.println("Средний возраст до 18 лет:" + p + ": " + averageAge));
        System.out.println();

        List personsByAge = persons
                .stream().filter(p -> p.getAge() >= 20 && p.getAge() <= 45)
                .map(p -> p.getAge() + ": " + p.getName())
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(personsByAge);
    }
}



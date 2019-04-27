package ru.academit.IvanVishnevsky.Main.Main;

import com.sun.xml.internal.bind.v2.util.CollisionCheckStack;
import ru.academit.IvanVishnevsky.Main.Person.Person;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.reverseOrder;
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

        Map<String, Double> personByMiddleAge = persons
                .stream()
                .collect(Collectors.groupingBy(Person::getName, averagingDouble(Person::getAge)));
        personByMiddleAge.forEach((k, v) -> System.out.println("Средний возраст: " + k + " - " + v));


        Map<Integer, List<Person>> personsByMiddleAge = persons
                .stream()
                .collect(Collectors.groupingBy(Person::getAge));
        Double averageAge = persons
                .stream()
                .filter(p -> p.getAge() < 18)
                .collect(averagingDouble(Person::getAge));
        personsByMiddleAge.forEach((age, p) ->
                System.out.println("Средний возраст до 18 лет:" + p + ": " + averageAge));
        System.out.println();
/*
       List personsByAge = persons
                .stream()
                .filter(p -> p.getAge() >= 20 && p.getAge() <= 45)
                .map(p -> p.getAge() + ": " + p.getName())
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(personsByAge);*/


        List<String> list = new ArrayList<>();
        for (Person p : persons) {
            if (p.getAge() >= 20 && p.getAge() <= 45) {
                String s = p.getAge() + ": " + p.getName();
                list.add(s);
            }
        }
        list.sort(reverseOrder());
        System.out.println(list);

    }
}



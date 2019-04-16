package ru.academit.IvanVishnevsky.Main.Main;

import ru.academit.IvanVishnevsky.Main.Person.Person;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
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

        System.out.println(persons.toString());
        System.out.println();

        String allName = persons.stream().map(Person::getName).collect(Collectors.joining(", "));
        System.out.println("Список уникальных имен: " + allName);
        System.out.println();

        Map<String, List<Person>> personsByMiddleAge = persons.stream().collect(Collectors.groupingBy(Person::getName));
        Double middleAge = persons.stream().collect(Collectors.averagingDouble(Person::getAge));
        personsByMiddleAge.forEach((name, p) ->
                System.out.println("Средний возраст: " + middleAge + ": " + p));
        System.out.println();

        Double averageAge = persons.stream().filter(p -> p.getAge() < 18).collect(Collectors.averagingInt(Person::getAge));
        personsByMiddleAge.forEach((age, p) ->
                System.out.println("Средний возраст до 18 лет:" + p + ": " + averageAge));
        System.out.println();

        Map<Integer, List<Person>> personsByAge = persons.stream().filter(p -> p.getAge() > 20 && p.getAge() < 45)
                .sorted(Comparator.comparingInt(Person::getAge).reversed()).collect(Collectors.groupingBy(Person::getAge));
        System.out.println("Список людей, возраст которых от 20 до 45: " + personsByAge);

    }
}

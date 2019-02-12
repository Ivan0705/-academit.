package ru.academit.ivanvish.main.Range.Main;

import ru.academit.ivanvish.main.Range.Range.Range;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Range range = new Range(2, 4);
        Range range1 = new Range(4, 8);

        range.print();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите точку, лежащей на отрезке АВ: ");
        double enterPointC = scanner.nextDouble();
        System.out.println(range.isInside(enterPointC) ? "Точка С лежит на отрезка АВ" : "Точка С не лежит на отрезке АВ");

        Range intersection = range.getIntersection(range1);
        Range[] summing = range.getMerge(range1);
        Range[] difference = range.getDifference(range1);

        if (intersection == null) {
            System.out.println((Range) null);
        } else {
            System.out.println("Сумма двух интервалов = " + summing[0].getFrom() + " : " + summing[0].getTo());
            if (difference.length == 0) {
                System.out.println("ОбъектА - ОбъектВ = интервал пустой");
            } else if (difference.length == 1) {
                System.out.println("Длина  диапазона равна = " + difference[0].getFrom() + " : " + difference[0].getTo());
                System.out.println("Интервал пустой ");
            } else if (difference.length == 2) {
                System.out.println("Длина первого диапазона равна = " + difference[0].getFrom() + " : " + difference[0].getTo());
                System.out.println("Длина второго диапазона равна = " + difference[1].getFrom() + " : " + difference[1].getTo());
            }
        }
    }
}

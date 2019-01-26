package ru.academit.ivanvish.main.Range.Range;

import java.util.Scanner;

public class Range {
    private double to;
    private double from;

    private Range(double to, double from) {
        this.to = to;
        this.from = from;
    }

    private void setTo(double to) {
        this.to = to;
    }

    private double getTo() {
        return to;
    }

    private void setFrom(double from) {
        this.from = from;
    }

    private double getFrom() {
        return from;
    }

    private double getLength() {
        return (from - to);
    }

    private boolean isInside(double enterPointC) {
        if (enterPointC >= to && enterPointC <= from) {
            return true;
        }
        return false;
    }

    private void print() {
        System.out.println("Длина отрезка AB: " + getLength());
        System.out.println("Точка A: " + getTo());
        System.out.println("Точка B: " + getFrom());
    }

    private void scanner() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите точку C: ");
        double enterPointC = scanner.nextDouble();
        System.out.println(isInside(enterPointC) ? "Точка C лежит на отрезке AB" : "Точка C не лежит на отрезке AB");
    }

   /* public static void main(String[] args) {
        Range range = new Range(3, 13);
        range.print();
        range.scanner();
    }*/
}
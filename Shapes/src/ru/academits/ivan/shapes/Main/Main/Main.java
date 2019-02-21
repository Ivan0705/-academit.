package ru.academits.ivan.shapes.Main.Main;

import ru.academits.ivan.shapes.Main.Shapes.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Square square = new Square(5);
        Rectangle rectangle = new Rectangle(5, 6);
        Rectangle rectangle1 = new Rectangle(7, 9);
        Triangle triangle = new Triangle(8, 1, 4, 6, 7, 1);
        Triangle triangle1 = new Triangle(5, 2, 6, 3, 9, 11);
        Circle circle = new Circle(2);

        Shape[] array = {triangle, rectangle, square, triangle1, circle, rectangle1};
        System.out.println("Площадь всех фигур: " + getSumArea(array));
        System.out.println();
        System.out.println("Максимальная площадь: " + getMaxArea(array));
        System.out.println("Площади всех фигур: ");
        for (Shape s : array) {
            System.out.println("S: " + s.getArea());
        }
        System.out.println();
        System.out.println("Фигура со вторым по величине периметром " + getSecondMaxPerimeter(array));
        System.out.println();
        System.out.println("Периметры фигур:");
        for (Shape p : array) {
            System.out.println("P: " + p.getPerimeter());
        }
        System.out.println();
        System.out.println("Сравниваем 2 прямоугольника");
        if (rectangle.equals(rectangle1)) {
            System.out.println("Фигуры одинаковы");
        } else {
            System.out.println("Фигуры разные");
        }
    }

    public static double getSumArea(Shape[] arr) {
        double result = 0;
        for (Shape e : arr) {
            result += e.getArea();
        }
        return result;
    }

    public static Shape getMaxArea(Shape[] arr) {
        Arrays.sort(arr, new SortedByAreaComparator());
        return arr[0];
    }

    public static Shape getSecondMaxPerimeter(Shape[] arr) {
        Arrays.sort(arr, new SortedByPerimeterComparator());
        return arr[1];
    }
}







package ru.academits.ivan.shapes.Main.Main;

import ru.academits.ivan.shapes.Main.Shapes.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Square square = new Square(5);

        Rectangle rectangle = new Rectangle(5, 6);
        Rectangle rectangle1 = new Rectangle(7, 9);

        Triangle triangle = new Triangle(8, 1, 4, 6, 7, 1);
        Triangle triangle1 = new Triangle(5, 2, 6, 3, 9, 11);

        Circle circle = new Circle(2);

        Shape[] shapes = {triangle, rectangle, square, triangle1, circle, rectangle1};
        System.out.println("Сумма всех S: " + getSumArea(shapes));
        System.out.println();

        System.out.println("Максимальная площадь: " + getFirstByArea(shapes));
        System.out.println("Площади всех фигур: ");
        for (Shape s : shapes) {
            System.out.println("S: " + s.getArea());
        }
        System.out.println();

        System.out.println("Фигура со вторым по величине периметром " + getSecondByPerimeter(shapes));
        System.out.println("Периметры фигур:");
        for (Shape p : shapes) {
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

    private static double getSumArea(Shape[] array) {
        double result = 0;
        for (Shape e : array) {
            result += e.getArea();
        }
        return result;
    }

    private static Shape getFirstByArea(Shape[] array) {
        Arrays.sort(array, new SortedByAreaComparator());
        return array[0];
    }

    private static Shape getSecondByPerimeter(Shape[] array) {
        Arrays.sort(array, new SortedByPerimeterComparator());
        return array[1];
    }
}

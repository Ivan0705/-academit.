package ru.academits.ivan.shapes.Main.Main;

import ru.academits.ivan.shapes.Main.Shapes.*;
import ru.academits.ivan.shapes.Main.Shapes.Comparator;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Square sq = new Square(5);
        System.out.println("Площадь квадрата: " + sq.getArea());
        System.out.println("Периметр квадрата: " + sq.getPerimeter());

        Rectangle rc = new Rectangle(5, 6);
        System.out.println("Площадь прямоугольника: " + rc.getArea());
        System.out.println("Периметр прямоугольника: " + rc.getPerimeter());

        Triangle tr = new Triangle(8, 1, 4, 6, 7, 1);
        System.out.println("Ширина треугольника: " + tr.getWidth());
        System.out.println("Высота треугольника: " + tr.getHeight());
        System.out.println("Площадь треугольника:" + tr.getArea());
        System.out.println("периметр треугольника: " + tr.getPerimeter());

        Circle crl = new Circle(2, 3);
        System.out.println("Площадь круга :" + crl.getArea());
        System.out.println("Периметр круга: " + crl.getPerimeter());

        double[] array = {sq.getArea(), rc.getArea(), tr.getPerimeter(), crl.getArea()};

        /*Arrays.sort(array, new sortedByArea());

        for (double i : array)
            System.out.print(i + " ");*/
    }
}






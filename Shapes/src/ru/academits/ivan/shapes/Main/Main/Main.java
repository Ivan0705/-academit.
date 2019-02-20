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

        Shapes[] array = new Shapes[]{triangle, rectangle, square, triangle1, circle, rectangle1};
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(getMaxArea(array).toString())
                .append("\n")
                .append(getSecondMaxPerimeter(array).toString());

        String result = stringBuilder.toString();
        System.out.println(result);
    }

    public static Shapes getMaxArea(Shapes[] arrayShapes) {
        Arrays.sort(arrayShapes, new sortedByArea());
        return ((arrayShapes[arrayShapes.length - 1]));
    }

    public static Shapes getSecondMaxPerimeter(Shapes[] arrayShape) {
        Arrays.sort(arrayShape, new sortedByPerimeter());
        return ((arrayShape[arrayShape.length - (arrayShape.length - 1)]));
    }
}







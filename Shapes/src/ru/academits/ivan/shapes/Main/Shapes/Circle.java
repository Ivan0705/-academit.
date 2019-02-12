package ru.academits.ivan.shapes.Main.Shapes;

public class Circle implements Shapes {
    private double width;
    private double height;

    public Circle(double width, double height) {
        this.height = height;
        this.width = width;
    }

    @Override
    public double getWidth() {
        return 0;
    }

    @Override
    public double getHeight() {
        return 0;
    }

    @Override
    public double getArea() {
        double area = 0.0;
        if (width == height) {
            area = Math.PI * width * height;
        } else {
            area = Math.PI * width * width;
        }
        return area;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * width;
    }
}

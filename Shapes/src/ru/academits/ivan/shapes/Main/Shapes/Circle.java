package ru.academits.ivan.shapes.Main.Shapes;

public class Circle implements Shape {
    private double width;

    public Circle(double width) {
        this.width = width;
    }

    @Override
    public double getWidth() {
        return 2 * width;
    }

    @Override
    public double getHeight() {
        return 2 * width;
    }

    @Override
    public double getArea() {
        return Math.PI * width * width;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * width;
    }

    @Override
    public String toString() {
        return "[Круг (R= " + this.width + "), (" + "S = " + getArea() + ", P = " + getPerimeter() + ")]";
    }

    @Override
    public int hashCode() {
        return Double.hashCode(width);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != getClass()) {
            return false;
        }
        Circle p = (Circle) o;
        return width == p.width;
    }
}

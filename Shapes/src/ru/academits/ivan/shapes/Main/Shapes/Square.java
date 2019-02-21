package ru.academits.ivan.shapes.Main.Shapes;

public class Square implements Shape {
    private double width;

    public Square(double width) {
        this.width = width;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return width;
    }

    @Override
    public double getArea() {
        return width * width;
    }

    @Override
    public double getPerimeter() {
        return 4 * width;
    }

    @Override
    public String toString() {
        return "[Квадрат ( " + this.width + "), (P = " + getPerimeter() + " , S = " + getArea() + ", Side = " + getWidth() + ")]";
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
        Square p = (Square) o;
        return width == p.width;
    }
}

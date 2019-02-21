package ru.academits.ivan.shapes.Main.Shapes;

public class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.height = height;
        this.width = width;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return height * width;
    }

    @Override
    public double getPerimeter() {
        return 2 * (height + width);
    }

    @Override
    public String toString() {
        return "[Прямоугольник (S = " + this.height + " * " + this.width + " = " + getArea() + ", P = " + getPerimeter() + ", Height = " + getHeight() + ", Width = " + getWidth() + ")]";
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + Double.hashCode(width);
        result = prime * result + Double.hashCode(height);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != getClass()) {
            return false;
        }
        Rectangle p = (Rectangle) o;
        return width == p.width && height == p.height;
    }
}

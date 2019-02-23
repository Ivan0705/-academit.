package ru.academits.ivan.shapes.Main.Shapes;

public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getWidth() {
        return 2 * radius;
    }

    @Override
    public double getHeight() {
        return 2 * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "[Круг (Радиус = "+this.radius+")]";
        /*
        String circle = "[Круг (R= " + this.radius + " ), ( " + " S = " + getArea() + ", P =  " + getPerimeter() + ")]";
        return circle+System.lineSeparator();*/
    }

    @Override
    public int hashCode() {
        return Double.hashCode(radius);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Circle p = (Circle) o;
        return radius == p.radius;
    }
}

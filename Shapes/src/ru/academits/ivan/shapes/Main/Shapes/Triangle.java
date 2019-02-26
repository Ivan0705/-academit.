package ru.academits.ivan.shapes.Main.Shapes;

public class Triangle implements Shape {
    private double x1;
    private double y1;

    private double x2;
    private double y2;

    private double x3;
    private double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;

        this.x2 = x2;
        this.y2 = y2;

        this.x3 = x3;
        this.y3 = y3;
    }

    private static double getSideLength(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    private static double getMax(double coordinatePoint1, double coordinatePoint2, double coordinatePoint3) {
        if (coordinatePoint1 > Math.max(coordinatePoint2, coordinatePoint3)) {
            return coordinatePoint1;
        }
        return Math.max(coordinatePoint2, coordinatePoint3);
    }

    private static double getMin(double coordinatePoint1, double coordinatePoint2, double coordinatePoint3) {
        if (coordinatePoint1 < Math.min(coordinatePoint2, coordinatePoint3)) {
            return coordinatePoint1;
        }
        return Math.min(coordinatePoint2, coordinatePoint3);
    }

    @Override
    public double getWidth() {
        return getMax(x1, x2, x3) - getMin(x1, x2, x3);
    }

    @Override
    public double getHeight() {
        return getMax(y1, y2, y3) - getMin(y1, y2, y3);
    }

    @Override
    public double getArea() {
        double halfPerimeter = getPerimeter() / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - getSideLength(x1, y1, x2, y2)) * (halfPerimeter - getSideLength(x2, y2, x3, y3)) * (halfPerimeter - getSideLength(x3, y3, x1, y1)));
    }

    @Override
    public double getPerimeter() {
        return getSideLength(x1, y1, x2, y2) + getSideLength(x2, y2, x3, y3) + getSideLength(x3, y3, x1, y1);
    }

    @Override
    public String toString() {
        String trianglePath1 = "[Треугольник (" + this.x1 + "-" + this.y1 + "), (" + this.x2 + "-" + this.y2 + "), (" + this.x3 + "-" + this.y3 + ")";
        String trianglePath2 = ", (S = " + getArea() + ", P = " + getPerimeter() + ", Width = " + getWidth() + ", Height = " + getHeight() + ")]";
        return (trianglePath1 + System.lineSeparator() + trianglePath2);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + Double.hashCode(x1);
        result = prime * result + Double.hashCode(x2);
        result = prime * result + Double.hashCode(x3);
        result = prime * result + Double.hashCode(y1);
        result = prime * result + Double.hashCode(y2);
        result = prime * result + Double.hashCode(y3);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Triangle p = (Triangle) o;

        return x1 == p.x1 && x2 == p.x2 && x3 == p.x3 && y1 == p.y1 && y2 == p.y2 && y3 == p.y3;
    }
}

package ru.academits.ivan.shapes.Main.Shapes;

public class Triangle implements Shapes {
    private double x1;
    private double x2;
    private double x3;

    private double y1;
    private double y2;
    private double y3;

    public Triangle(double x1, double x2, double x3, double y1, double y2, double y3) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;

        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public void setX21(double x2) {
        this.x2 = x2;
    }

    public void setX3(double x3) {
        this.x3 = x3;
    }

    private double getMax(double coordinatePoint1, double coordinatePoint2, double coordinatePoint3) {
        if (coordinatePoint1 > Math.max(coordinatePoint2, coordinatePoint3)) {
            double max = coordinatePoint1;
            return max;
        } else {
            return Math.max(coordinatePoint2, coordinatePoint3);
        }
    }

    private double getMin(double coordinatePoint1, double coordinatePoint2, double coordinatePoint3) {
        if (coordinatePoint1 < Math.min(coordinatePoint2, coordinatePoint3)) {
            double min = coordinatePoint1;
            return min;
        } else {
            return Math.min(coordinatePoint2, coordinatePoint3);
        }
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
        return (Math.abs((x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1))) / 2;
    }

    @Override
    public double getPerimeter() {
        double a = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        double b = Math.sqrt(Math.pow((x3 - 2), 2) + Math.pow((y3 - y2), 2));
        double c = Math.sqrt(Math.pow((x3 - x1), 2) + Math.pow((y3 - y1), 2));
        return (a + b + c);
    }

    @Override
    public String toString() {
        return "Треугольник : Площадь: " + getArea() + "\n" + " Периметр: " + getPerimeter() + "\n" + " Высота:" + getHeight() + "\n" + " Ширина: " + getWidth() + "\n";
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
        if (!(o instanceof Triangle))
            return false;
        Triangle p = (Triangle) o;
        return (o == this) || (x1 == p.x1 && x2 == p.x2 && x3 == p.x3 && y1 == p.y1 && y2 == p.y2 && y3 == p.y3);
    }
}

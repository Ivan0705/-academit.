package ru.academits.ivan.shapes.Main.Shapes;

public class Circle implements Shapes {
    private double width;

    public Circle(double width) {
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
        double area = Math.PI * width * width;
        return area;
    }

    @Override
    public double getPerimeter() {
        return (2 * Math.PI * width);
    }

    @Override
    public String toString() {
        return "Круг " + "\n" + "Площадь:" + getArea() + "\n" + "Периметр: " + getPerimeter() + "\n" + "Круг с радиусом:" + 2 * width + "\n";
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + Double.hashCode(width);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Circle))
            return false;
        Circle p = (Circle) o;
        return (o == this) || (width == p.width);
    }
}

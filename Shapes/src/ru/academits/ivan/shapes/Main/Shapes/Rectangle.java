package ru.academits.ivan.shapes.Main.Shapes;

public class Rectangle implements Shapes {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.height = height;
        this.width = width;
    }

    @Override
    public double getWidth() {
        return 0;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getHeight() {
        return 0;
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
        return "Прямоугольник " + "\n" + "Площадь: " + getArea() + "\n" + "Периметр:" + getPerimeter() + "\n" + "Ширина:" + width + "\n" + "Высота:" + height + "\n";
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
        if (!(o instanceof Rectangle))
            return false;
        Rectangle p = (Rectangle) o;
        return (o == this) || (width == p.width && height == p.height);
    }
}

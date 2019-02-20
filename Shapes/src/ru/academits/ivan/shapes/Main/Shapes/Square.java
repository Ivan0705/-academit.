package ru.academits.ivan.shapes.Main.Shapes;

public class Square implements Shapes {
    private double width;

    public Square(double width) {
        this.width = width;
    }

    public void setWidth() {
        this.width = width;
    }

    @Override
    public double getWidth() {
        return this.width;
    }

    @Override
    public double getHeight() {
        return 0;
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
        return "Квадрат  " + "\n" + "Периметр: " + getPerimeter() + "\n" + "Площадь: " + getArea() + "\n" + "Длина стороны: " + width + "\n";
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
        if (!(o instanceof Square))
            return false;
        Square p = (Square) o;
        return (o == this) || (width == p.width);
    }
}

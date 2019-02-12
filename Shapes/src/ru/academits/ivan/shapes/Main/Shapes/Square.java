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
        return width*width;
    }

    @Override
    public double getPerimeter() {
        return 4*width;
    }
}

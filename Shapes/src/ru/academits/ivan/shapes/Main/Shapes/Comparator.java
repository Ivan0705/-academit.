package ru.academits.ivan.shapes.Main.Shapes;

public interface Comparator<T> {

    public default double compare(Shapes sh1, Shapes sh2) {

        double area1 = sh1.getArea();
        double area2 = sh2.getArea();

        if (area1 > area2) {
            return 1;
        } else if (area1 < area2) {
            return -1;
        } else {
            return 0;
        }
    }
}


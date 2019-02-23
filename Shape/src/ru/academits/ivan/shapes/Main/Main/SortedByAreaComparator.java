package ru.academits.ivan.shapes.Main.Main;

import ru.academits.ivan.shapes.Main.Shapes.Shape;

import java.util.Comparator;

public class SortedByAreaComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape o1, Shape o2) {
        return Double.compare(o2.getArea(), o1.getArea());
    }
}

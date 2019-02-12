package ru.academits.ivan.shapes.Main.Shapes;

import java.util.Comparator;

public class sortedByArea implements Comparator<Shapes> {


    @Override
    public int compare(Shapes sh1, Shapes sh2) {
        //  return 0;
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

    @Override
    public Comparator<Shapes> reversed() {
        return null;
    }


}

package ru.academit.ivanvish.main.Range.Main;

import ru.academit.ivanvish.main.Range.Range.Range;

public class Main {
    public static void main(String[] args) {
        Range range = new Range(4, 13);
        Range range1 = new Range(7, 19);

        Range interSectionResult = range.getIntersection(range1);
        if (interSectionResult == null) {
            System.out.println((Range) null);
        } else {
            System.out.println("Объединение двух интервалов = " + range.getFrom() + ";" + interSectionResult.getTo());
            System.out.println("Разность двух интервалов = " + range.getFrom() + ";" + interSectionResult.getFrom());
            System.out.println("Разность двух интервалов = " + range.getTo() + ";" + interSectionResult.getTo());
            System.out.println("Область пересечения двух интервалов = " + interSectionResult.getFrom() + ";" + range.getTo());
        }
    }
}

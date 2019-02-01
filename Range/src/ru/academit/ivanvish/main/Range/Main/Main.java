package ru.academit.ivanvish.main.Range.Main;

import ru.academit.ivanvish.main.Range.Range.Range;

public class Main {
    public static void main(String[] args) {
        Range range = new Range(4, 13);
        Range range1 = new Range(6, 18);

        range.print();
        range.scanner();

        Range intersection = range.getIntersection(range1);
        Range[] summing = range.getMerge(range1);
        Range[] difference = range.getDifference(range1);

        if (intersection == null) {
            System.out.println((Range) null);
        } else {
            System.out.println("Сумма двух интервалов = " + summing[0].getFrom() + " : " + summing[0].getTo());
            if ((difference[0].getFrom() != difference[0].getTo()) && (difference[1].getFrom() != difference[1].getTo())) {
                System.out.println("ОбъектА - ОбъектВ = " + difference[0].getFrom() + " : " + difference[0].getTo());
                System.out.println("ОбъектВ - ОбъектА = " + difference[1].getFrom() + " : " + difference[1].getTo());
            } else if ((difference[0].getFrom() == difference[0].getTo()) && (difference[1].getTo() == difference[1].getFrom())) {
                System.out.println("ОбъектА - ОбъектВ = ");
                System.out.println("ОбъектВ - ОбъектА = ");
            } else if (difference[0].getFrom() == difference[0].getTo()) {
                System.out.println("ОбъектА - ОбъектВ = ");
                System.out.println("ОбъектВ - ОбъектА = " + difference[1].getFrom() + " : " + difference[1].getTo());
            } else {
                System.out.println("ОбъектА - ОбъектВ = " + difference[0].getFrom() + " : " + difference[0].getTo());
                System.out.println("ОбъектВ - ОбъектА = ");
            }
        }
    }
}

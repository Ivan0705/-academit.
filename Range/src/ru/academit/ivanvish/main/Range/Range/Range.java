package ru.academit.ivanvish.main.Range.Range;

public class Range {

    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;

    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getTo() {
        return (this.to);
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getFrom() {
        return (this.from);
    }


    private double getLength1() {
        return Math.abs((from - to));
    }

    private boolean isInside(double enterPointC) {
        if ((enterPointC <= to && enterPointC >= from)) {
            return true;
        }
        return false;
    }

    public Range getIntersection(Range range) {
        if (Math.max(from, range.from) >= Math.min(to, range.to)) {
            return null;
        } else {
            new Range(Math.max(from, range.from), Math.min(to, range.to));
        }
        return range;
    }
}


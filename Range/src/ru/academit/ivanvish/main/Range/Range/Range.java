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
        return this.to;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getFrom() {
        return this.from;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double enterPointC) {
        return (enterPointC <= to && enterPointC >= from);
    }

    public void print() {
        System.out.println("Длина отрезка АB: " + getLength());
    }

    public Range getIntersection(Range range) {
        double from = Math.max(this.from, range.from);
        double to = Math.min(this.to, range.to);
        if (from >= to) {
            return null;
        } else {
            return new Range(from, to);
        }
    }

    public Range[] getMerge(Range range) {
        if (Math.max(from, range.from) <= Math.min(range.to, to)) {
            Range union = new Range(Math.min(from, range.from), Math.max(to, range.to));
            return new Range[]{union};
        } else {
            Range object1 = new Range(Math.min(from, range.from), Math.min(to, range.to));
            Range object2 = new Range(Math.max(from, range.from), Math.max(to, range.to));
            return new Range[]{object1, object2};
        }
    }

    public Range[] getDifference(Range range) {
        if ((range.from > from) && (to > range.to)) {
            return new Range[]{new Range(from, range.from), new Range(range.to, to)};
        } else if ((from >= range.from) && (range.to >= to)) {
            return new Range[]{};
        } else if (range.from >= to || from >= range.to) {
            return new Range[]{new Range(from, to)};
        } else if ((from >= range.from) && (to > range.to)) {
            return new Range[]{new Range(range.to, to)};
        } else {
            return new Range[]{new Range(from, range.from)};
        }
    }
}


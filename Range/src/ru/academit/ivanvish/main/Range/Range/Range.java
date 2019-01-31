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
        return (enterPointC <= to && enterPointC >= from);
    }

    public Range getIntersection(Range range) {
        if (Math.max(from, range.from) > Math.min(to, range.to)) {
            return null;
        } else {
            new Range(Math.max(from, range.from), Math.min(to, range.to));
        }
        return range;
    }

    public Range[] getMerge(Range range) {
     /*   if ((range.from >= from) && (range.to >= to)) {
            return new Range[]{new Range(from, range.to)};
        } else if ((from >= range.from) && (to >= range.to)) {
            return new Range[]{new Range(range.from, to)};
        } else if ((range.from >= from) && (range.to >= to) && (range.from >= to)) {
            return new Range[]{new Range(from, to), new Range(range.from, range.to)};
        } else if ((from >= range.from) && (to >= range.to) && (from >= range.to)) {
            return new Range[]{new Range(range.from, range.to), new Range(from, to)};
        } else if ((range.from >= from) && (range.to >= to) && (to == range.from)) {
            return new Range[]{new Range(from, range.to)};
        } else if ((from >= range.from) && (to >= range.to) && (range.to == from)) {
            return new Range[]{new Range(range.from, to)};
        } else if ((range.from >= from) && (to >= range.to)) {
            return new Range[]{new Range(from, to)};
        } else if ((from >= range.from) && (range.to >= to)) {
            return new Range[]{new Range(range.from, range.to)};//8
        } else if ((from == range.from) && (range.to == to)) {
            return new Range[]{new Range(from, to)};
        } else if ((from == range.from) && (to >= range.to)) {
            return new Range[]{new Range(range.from, to)};
        } else if ((from == range.from) && (to <= range.to)) {
            return new Range[]{new Range(from, range.to)};
        } else if ((range.from >= from) && (to == range.to)) {
            return new Range[]{new Range(range.from, to)};
        } else if ((from >= range.from) && (to == range.to)) {
            return new Range[]{new Range(from, range.to)};
        }
        return new Range[]{};*/
        if (((Math.max(from, to) > Math.min(range.from, range.to)) || (Math.max(range.from, range.to) > Math.min(from, to)))) {
            return new Range[]{new Range(Math.min(from, range.from), Math.max(to, range.to))};
        } else {
            return null;
        }
    }

    public Range[] getDifference(Range range) {
      /*  if ((range.from >= from) && (range.to >= to)) {
            return new Range[]{new Range(from, range.from), new Range(to, range.to)};
        } else if ((from >= range.from) && (to >= range.to)) {
            return new Range[]{new Range(range.from, from), new Range(range.to, to)};
        } else if ((range.from >= from) && (range.to >= to) && (range.from >= to)) {
            return null;
        } else if ((from >= range.from) && (to >= range.to) && (from >= range.to)) {
            return null;
        } else if ((range.from >= from) && (range.to >= to) && (to == range.from)) {
            return new Range[]{new Range(from, to), new Range(to, range.to)};
        } else if ((from >= range.from) && (to >= range.to) && (range.to == from)) {
            return new Range[]{new Range(range.from, range.to), new Range(range.to, to)};
        } else if ((range.from >= from) && (range.to <= to)) {
            return new Range[]{new Range(from, range.from), new Range(range.to, to)};
        } else if ((range.from <= from) && (range.to >= to)) {
            return new Range[]{new Range(range.from, from), new Range(to, range.to)};
        } else if ((range.from == from) && (range.to == to)) {
            return new Range[]{};
        } else if ((range.from == from) && (to >= range.to)) {
            return new Range[]{new Range(range.from, range.to), new Range(range.to, to)};
        } else if ((range.from == from) && (to <= range.to)) {
            return new Range[]{new Range(range.from, to), new Range(to, range.to)};
        } else if ((range.from >= from) && (range.to == to)) {
            return new Range[]{new Range(from, range.from), new Range(range.from, range.to)}
        } else if ((range.from <= from) && (range.to == to)) {
            return new Range[]{new Range(range.from, from), new Range(from, range.to)};
        }
        return new Range[]{};*/
        if (((Math.max(from, to) > Math.min(range.from, range.to)) || (Math.max(range.from, range.to) > Math.min(from, to)))) {
            return new Range[]{new Range(Math.min(range.from, from), Math.max(from, range.from)), new Range(Math.min(to, range.to), Math.max(range.to, to))};
        }
        return null;
    }
}


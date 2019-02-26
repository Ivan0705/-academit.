package ru.academit.ivanvish.main.Vector.Vector;

import java.util.Arrays;

public class Vector {
    private double[] coordinates;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Размерность пространства равна нулю или отрицательна!");
        }
        coordinates = new double[n];
    }

    public Vector(Vector vector) {
        coordinates = Arrays.copyOf(vector.coordinates, vector.coordinates.length);
    }

    public double getSizeVector() {
        double sum = 0;
        for (double e : coordinates) {
            sum += e * e;
        }
        return Math.sqrt(sum);
    }

    public Vector(double... a) {
        if (a.length == 0) {
            throw new IllegalArgumentException("Размерность пространства равна нулю или отрицательна!");
        }
        coordinates = Arrays.copyOf(a, a.length);
    }

    public Vector(int n, double... a) {
        if (a.length == 0 || n == 0) {
            throw new IllegalArgumentException("Размерность пространства равна нулю или отрицательна!");
        }
        coordinates = Arrays.copyOf(a, n);
    }

    public double getLength() {
        return coordinates.length;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("{");
        for (int i = 0; i < coordinates.length - 1; i++) {
            str.append(coordinates[i]).append(", ");
        }
        return str.append(coordinates[coordinates.length - 1]).append("}").toString();
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(coordinates);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Vector p = (Vector) o;
        return Arrays.equals(p.coordinates, this.coordinates);
    }

    public void add(Vector vector2) {
        if (coordinates.length > vector2.coordinates.length) {
            coordinates = Arrays.copyOf(coordinates, vector2.coordinates.length);
        }
        for (int i = 0; i < coordinates.length; ++i) {
            coordinates[i] += vector2.coordinates[i];
        }
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector vector = new Vector(vector1);
        vector.add(vector2);
        return vector;
    }

    public void subtraction(Vector vector2) {
        if (vector2.coordinates.length < coordinates.length) {
            coordinates = Arrays.copyOf(coordinates, vector2.coordinates.length);
        }
        for (int i = 0; i < coordinates.length; i++) {
            coordinates[i] -= vector2.coordinates[i];
        }
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        Vector vector = new Vector(vector1);
        vector.subtraction(vector2);
        return vector;
    }

    public void getMultiByScalar(double scalar) {
        for (double e : coordinates) {
            scalar *= e;
        }
    }

    public static double getScalar(Vector vector1, Vector vector2) {
        double scalar = 0;
        double nMin = Math.min(vector1.coordinates.length, vector2.coordinates.length);
        for (int i = 0; i < nMin; i++) {
            scalar += i * i;
        }
        return scalar;
    }


    public void reversal() {
        for (int i = 0; i < coordinates.length; i++) {
            coordinates[i] = (coordinates[i] == 0) ? 0 : coordinates[i] * (-1);
        }
    }

    public void setElement(int index, int e) {
        this.coordinates[index] = e;
    }

    public double getElement(int index) {
        return this.coordinates[index];
    }
}
package ru.academit.ivanvish.main.Vector.Vector;

import java.util.Arrays;

public class Vector {
    private double[] coordinates;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Размерность пространства равна нулю или отрицательная!");
        }
        coordinates = new double[n];
    }

    public Vector(Vector vector) {
        Arrays.copyOf(coordinates, coordinates.length);
    }

    public Vector(double... a) {
        if (a.length == 0) {
            throw new IllegalArgumentException("Размерность пространства равна нулю или отрицательная!");
        }
        coordinates = Arrays.copyOf(a, a.length);
    }

    public Vector(int n, double... a) {
        if (a.length == 0 || n == 0) {
            throw new IllegalArgumentException("Размерность пространства равна нулю или отрицательная");
        }
        coordinates = Arrays.copyOf(a, n);
    }

    public double getSize() {
        return coordinates.length;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("{");
        for (int i = 0; i < coordinates.length; i++) {
            str.append(coordinates[i]).append(", ");
        }
        return str.append(coordinates[coordinates.length - 1]).append("}").toString();
    }

    public void getSum(Vector vector2) {
        if (coordinates.length < vector2.coordinates.length) {
            coordinates = Arrays.copyOf(coordinates, vector2.coordinates.length);
        }
        for (int i = 0; i < coordinates.length - 1; i++) {
            coordinates[i] += vector2.coordinates[i];
        }
    }

    public void getDiff(Vector vector2) {
        if (coordinates.length < vector2.coordinates.length) {
            coordinates = Arrays.copyOf(coordinates, vector2.coordinates.length);
        }
        for (int i = 0; i < coordinates.length - 1; i++) {
            coordinates[i] -= vector2.coordinates[i];
        }
    }

    public void invert() {
        for (int i = 0; i < coordinates.length - 1; i++) {
            coordinates[i] = (this.coordinates[i] == 0) ? 0 : this.coordinates[i] * (-1);
        }
    }

}

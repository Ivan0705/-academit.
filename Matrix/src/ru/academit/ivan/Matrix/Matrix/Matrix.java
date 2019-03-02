package ru.academit.ivan.Matrix.Matrix;


import ru.academit.ivanvish.main.Vector.Vector.Vector;

import java.util.Arrays;

public class Matrix {
    private Vector[] rows;

    public Matrix(int colsCount, int rowsCount) {
        if (colsCount <= 0 || rowsCount <= 0) {
            throw new IllegalArgumentException("Размер матрицы отрицательный или равен 0! ");
        }
        rows = new Vector[rowsCount];
        for (int i = 0; i < rowsCount; i++) {
            rows[i] = new Vector(colsCount);
        }

    }

    public Matrix(Matrix matrix) {
        rows = new Vector[matrix.rows.length];
        for (int i = 0; i < matrix.rows.length; i++) {
            rows[i] = new Vector(matrix.rows.length);
        }

    }

    public Matrix(double[][] a) {
        int colsCount = a.length;
        int rowsCount = 0;
        for (double[] r : a) {
            if (colsCount < r.length)
                colsCount = r.length;
        }
        if (colsCount <= 0) {
            throw new IllegalArgumentException("Размер матрицы отрицательный или равен 0! ");
        }
        rows = new Vector[rowsCount];
        for (int i = 0; i < colsCount; i++) {
            double[] m = Arrays.copyOf(a[i], colsCount);
            rows[i] = new Vector(m);
        }
    }

    public Matrix(Vector[] vectors) {
        if (vectors == null || vectors.length <= 0) {
            throw new IllegalArgumentException("Размер матрицы отрицательный или равен 0! ");
        }
        int colsCount = 0;
        for (Vector vector : vectors) {
            if (vector.getSize() > colsCount) {
                colsCount = vector.getSize();
            }
        }

        int rowsCount = vectors.length;
        rows = new Vector[rowsCount];
        for (int i = 0; i < rowsCount; i++) {
            rows[i] = new Vector(colsCount);
            int size = vectors[i].getSize();
            for (int j = 0; j < size; j++) {
                vectors[i].setElement(j, vectors[i].getElement(j));
            }
        }

    }
}

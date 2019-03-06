package ru.academit.ivan.Matrix.Matrix;

import ru.academit.ivanvish.main.Vector.Vector.Vector;

import java.util.Arrays;

public class Matrix {
    private Vector[] rows;

    public Matrix(int colsCount, int rowsCount) {
        if (colsCount == 0 || rowsCount == 0) {
            throw new IllegalArgumentException("Размер матрицы равен нулю!");
        }
        rows = new Vector[rowsCount];
        for (int i = 0; i < rowsCount; i++) {
            rows[i] = new Vector(colsCount);
        }
    }

    public Matrix(Matrix matrix) {
        rows = new Vector[matrix.rows.length];
        for (int i = 0; i < matrix.rows.length; i++) {
            rows[i] = matrix.getRows(i);
        }
    }

    public Matrix(double[][] a) {
        int rowsCount = a.length;
        int colsCount = 0;
        for (double[] r : a) {
            if (colsCount < r.length) {
                colsCount = r.length;
            }
        }

        if (colsCount == 0) {
            throw new IllegalArgumentException("Размер матрицы равен нулю!");
        }
        rows = new Vector[rowsCount];
        for (int i = 0; i < rowsCount; i++) {
            double[] m = Arrays.copyOf(a[i], colsCount);
            rows[i] = new Vector(m);
        }
    }

    public Matrix(Vector[] vector) {
        if (vector == null || vector.length <= 0) {
            throw new IllegalArgumentException("Размер матрицы равен нулю или отрицательный!");
        }
        int colsCount = 0;
        int rowsCount = vector.length;

        for (Vector vectors : vector) {
            if (colsCount < vectors.getSize()) {
                colsCount = vectors.getSize();
            }
        }
        rows = new Vector[rowsCount];
        for (int i = 0; i < rowsCount; i++) {
            rows[i] = new Vector(colsCount);
            double size = vector[i].getSize();
            for (int j = 0; j < size; j++) {
                rows[i].setElement(j, vector[i].getElement(j));
            }
        }
    }

    public int getRowsCount() {
        return rows.length;
    }

    public int getColmCount() {
        return rows[0].getSize();
    }

    public Vector getRows(int i) {
        if (i < 0 || i > rows.length) {
            throw new IndexOutOfBoundsException("Не соотвествует индекс вектора размерам матрицы!");
        }
        return new Vector(rows[i]);
    }

    public void setIndex(int i, Vector vector) {
        if (i < 0 || i > rows.length) {
            throw new IndexOutOfBoundsException("Не соотвествует индекс вектора размерам матрицы!");
        }
        if (vector.getSize() != getColmCount()) {
            throw new IllegalArgumentException("Размер матрицы не совпадает!");
        }
        rows[i] = new Vector(vector);
    }

    public void transportation() {
        int rowsCount = getColmCount();
        Vector[] vector = new Vector[rowsCount];
        for (int i = 0; i < rowsCount; i++) {
            vector[i] = getColumn(i);
        }
        rows = vector;
    }

    public Vector getColumn(int i) {
        if (i < 0 || i > getColmCount()) {
            throw new IndexOutOfBoundsException("Не соотвествует индекс вектора размерам матрицы!");
        }
        double[] tmp = new double[rows.length];
        for (int j = 0; j < rows.length; j++) {
            tmp[j] = rows[j].getElement(i);
        }
        return new Vector(tmp);
    }

    public void multiplicationByScalar(int scal) {
        for (Vector vector : rows) {
            vector.multiByScalar(scal);
        }
    }

    public double determinant() {
        int rowsCount = rows.length;
        int colsCount = getColmCount();
        double det = 0;

        if (colsCount == 1) {
            return rows[0].getElement(0);
        } else if (colsCount == 2) {
            return rows[0].getElement(0) * rows[1].getElement(1) - rows[0].getElement(1) * rows[1].getElement(0);
        } else {

            Matrix tmpM = new Matrix(this);

            for (int i = 0; i < rowsCount; i++) {
                double[][] arrayTmp = new double[rowsCount - 1][colsCount - 1];
                for (int j = 1; j < rowsCount; j++) {
                    int colunmCount = 0;
                    for (int k = 0; k < colsCount; k++) {
                        if (k == i) {
                            continue;
                        }
                        arrayTmp[j - 1][colunmCount] = tmpM.rows[j].getElement(k);
                        colunmCount++;
                    }
                }
                det = det + tmpM.rows[0].getElement(i) * (new Matrix(arrayTmp)).determinant() * Math.pow(-1, i);
            }
        }
        return det;
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("{");
        for (int i = 0; i < rows.length; i++) {
            if (i > 0) {
                str.append(", ");
            }
            str.append(rows[i].toString());
        }
        return str.append("}").toString();
    }

    public Vector multyScalarByVector(Vector vector) {
        if (vector.getSize() != getColmCount()) {
            throw new IllegalArgumentException("Длина вектора должна равна числу столбцов в матрице!");
        }
        int rowsCount = rows.length;
        double arrayCount[] = new double[rowsCount];
        for (int i = 0; i < rowsCount; i++) {
            arrayCount[i] = Vector.getScalarProduct(rows[i], vector);
        }
        return new Vector(arrayCount);
    }

    public void addMatrix(Matrix matrix) {
        int colsCount = getColmCount();
        int rowsCount = rows.length;
        int colsCountMatrix = matrix.getColmCount();
        int rowsCountMatrix = matrix.rows.length;

        if (colsCount != colsCountMatrix || rowsCount != rowsCountMatrix) {
            throw new IllegalArgumentException("Размеры матрицы должны совпадать!");
        }
        for (int i = 0; i < rowsCount; i++) {
            rows[i].add(matrix.rows[i]);
        }
    }

    public void diffMatrix(Matrix matrix) {
        int colsCount = getColmCount();
        int rowsCount = rows.length;
        int colsCountMatrix = matrix.getColmCount();
        int rowsCountMatrix = matrix.rows.length;

        if (colsCount != colsCountMatrix || rowsCount != rowsCountMatrix) {
            throw new IllegalArgumentException("Размеры матрицы должны совпадать!");
        }
        for (int i = 0; i < rowsCount; i++) {
            rows[i].subtraction(matrix.rows[i]);
        }
    }

    public static Matrix getAddMatrix(Matrix matrix, Matrix matrix1) {

        int colsCountMatrix = matrix.getColmCount();
        int rowsCountMatrix = matrix.rows.length;
        int colsCountMatrix1 = matrix1.getColmCount();
        int rowsCountMatrix1 = matrix1.rows.length;

        if (colsCountMatrix1 != colsCountMatrix || rowsCountMatrix1 != rowsCountMatrix) {
            throw new IllegalArgumentException("Размеры матрицы должны совпадать!");
        }
        matrix.addMatrix(matrix1);
        return matrix;
    }

    public static Matrix getDiffMatrix(Matrix matrix, Matrix matrix1) {

        int colsCountMatrix = matrix.getColmCount();
        int rowsCountMatrix = matrix.rows.length;
        int colsCountMatrix1 = matrix1.getColmCount();
        int rowsCountMatrix1 = matrix1.rows.length;

        if (colsCountMatrix1 != colsCountMatrix || rowsCountMatrix1 != rowsCountMatrix) {
            throw new IllegalArgumentException("Размеры матрицы должны совпадать!");
        }
        matrix.diffMatrix(matrix1);
        return matrix;
    }

    public static Matrix multiProduction(Matrix matrix, Matrix matrix1) {
        int colsCountMatrix = matrix.getColmCount();
        int rowsCountMatrix = matrix.rows.length;
        int colsCountMatrix1 = matrix1.getColmCount();
        int rowsCountMatrix1 = matrix1.rows.length;

        double arrayM[][] = new double[rowsCountMatrix][colsCountMatrix];
        if (colsCountMatrix1 != colsCountMatrix || matrix1.rows.length != matrix.rows.length) {
            throw new IllegalArgumentException("Размеры матрицы должны совпадать!");
        }
        for (int i = 0; i < rowsCountMatrix; i++) {
            for (int j = 0; j < rowsCountMatrix1; j++)
                for (int k = 0; k < colsCountMatrix; k++) {
                    arrayM[i][j] += matrix.rows[i].getElement(i) * matrix1.rows[j].getElement(j);
                }
        }
        return new Matrix(arrayM);
    }
}




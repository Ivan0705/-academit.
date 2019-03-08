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
            rows[i] = matrix.getRow(i);
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

    public int getColumnCount() {
        return rows[0].getSize();
    }

    public Vector getRow(int i) {
        if (i < 0 || i >= rows.length) {
            throw new IndexOutOfBoundsException("Не соотвествует индекс вектора размерам матрицы!");
        }
        return new Vector(rows[i]);
    }

    public void setRow(int i, Vector vector) {
        if (i < 0 || i >= rows.length) {
            throw new IndexOutOfBoundsException("Не соотвествует индекс вектора размерам матрицы!");
        }
        if (vector.getSize() != getColumnCount()) {
            throw new IllegalArgumentException("Размер матрицы не совпадает!");
        }
        rows[i] = new Vector(vector);
    }

    public void transposition() {
        int rowsCount = getColumnCount();
        Vector[] vector = new Vector[rowsCount];
        for (int i = 0; i < rowsCount; i++) {
            vector[i] = getColumn(i);
        }
        rows = vector;
    }

    public Vector getColumn(int i) {
        if (i < 0 || i >= getColumnCount()) {
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
        int colsCount = getColumnCount();
        double det = 0;
        if (rowsCount != colsCount) {
            throw new IllegalArgumentException("Матрица должна квадратной!");
        }
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

    public Vector multiplicationScalarByVector(Vector vector) {
        if (vector.getSize() != getColumnCount()) {
            throw new IllegalArgumentException("Длина вектора должна равна числу столбцов в матрице!");
        }
        int rowsCount = rows.length;
        double[] arrayCount = new double[rowsCount];
        for (int i = 0; i < rowsCount; i++) {
            arrayCount[i] = Vector.getScalarProduct(rows[i], vector);
        }
        return new Vector(arrayCount);
    }

    public void addMatrix(Matrix matrix1) {
        int colsCount = getColumnCount();
        int rowsCount = rows.length;
        int colsCountMatrix1 = matrix1.getColumnCount();
        int rowsCountMatrix1 = matrix1.rows.length;

        if (colsCount != colsCountMatrix1 || rowsCount != rowsCountMatrix1) {
            throw new IllegalArgumentException("Размеры матрицы должны совпадать!");
        }
        for (int i = 0; i < rowsCount; i++) {
            rows[i].add(matrix1.rows[i]);
        }
    }

    public void diffMatrix(Matrix matrix1) {
        int colsCount = getColumnCount();
        int rowsCount = rows.length;
        int colsCountMatrix1 = matrix1.getColumnCount();
        int rowsCountMatrix1 = matrix1.rows.length;

        if (colsCount != colsCountMatrix1 || rowsCount != rowsCountMatrix1) {
            throw new IllegalArgumentException("Размеры матрицы должны совпадать!");
        }
        for (int i = 0; i < rowsCount; i++) {
            rows[i].subtraction(matrix1.rows[i]);
        }
    }

    public static Matrix getAddMatrix(Matrix matrix1, Matrix matrix2) {
        int colsCountMatrix1 = matrix1.getColumnCount();
        int rowsCountMatrix1 = matrix1.rows.length;
        int colsCountMatrix2 = matrix2.getColumnCount();
        int rowsCountMatrix2 = matrix2.rows.length;

        if (colsCountMatrix1 != colsCountMatrix2 || rowsCountMatrix1 != rowsCountMatrix2) {
            throw new IllegalArgumentException("Размеры матрицы должны совпадать!");
        }
        matrix1.addMatrix(matrix2);
        return matrix1;
    }

    public static Matrix getDiffMatrix(Matrix matrix1, Matrix matrix2) {
        int colsCountMatrix1 = matrix1.getColumnCount();
        int rowsCountMatrix1 = matrix1.rows.length;
        int colsCountMatrix2 = matrix2.getColumnCount();
        int rowsCountMatrix2 = matrix2.rows.length;

        if (colsCountMatrix1 != colsCountMatrix2 || rowsCountMatrix1 != rowsCountMatrix2) {
            throw new IllegalArgumentException("Размеры матрицы должны совпадать!");
        }
        matrix1.diffMatrix(matrix2);
        return matrix1;
    }

    public static Matrix multiplicationOfMatrix(Matrix matrix1, Matrix matrix2) {
        int colsCountMatrix1 = matrix1.getColumnCount();
        int rowsCountMatrix1 = matrix1.rows.length;
        int colsCountMatrix2 = matrix2.getColumnCount();
        int rowsCountMatrix2 = matrix2.rows.length;

        if (colsCountMatrix1 != rowsCountMatrix2) {
            throw new IllegalArgumentException("Количество столбцов первой матрицы должно быть равны кол-ву строк втрой матрицы!");
        }
        double[][] arrayM = new double[rowsCountMatrix1][colsCountMatrix1];
        for (int i = 0; i < rowsCountMatrix1; i++) {
            for (int j = 0; j < colsCountMatrix2; j++)
                for (int k = 0; k < colsCountMatrix1; k++) {
                    arrayM[i][j] += matrix1.rows[i].getElement(i) * matrix1.rows[j].getElement(j);
                }
        }
        return new Matrix(arrayM);
    }
}




package ru.academit.ivan.Matrix.Main;

import ru.academit.ivan.Matrix.Matrix.Matrix;
import ru.academit.ivanvish.main.Vector.Vector.Vector;

public class Main {
    public static void main(String[] args) {
        double[] c1 = {2, -5, 4};
        Vector vector = new Vector(c1);

        double[] c2 = {-3, 7, -8};
        Vector vector1 = new Vector(c2);

        double[] c3 = {3, -4, 3};
        Vector vector3 = new Vector(c3);

        Vector[] array = {vector, vector1, vector3};
        Matrix m = null;

        try {
            m = new Matrix(array);
            System.out.println(m.toString());
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! Размер матрицы нулевой или не создан!");
            System.out.println();
        }

        Matrix m1 = new Matrix(m);
        System.out.println("Копируем матрицу m в матрицу m1: " + m1);
        System.out.println();

        System.out.println("Получаем размер матрицы m1: " + m1.getRowsCount());
        System.out.println();

        try {
            System.out.println("Получаем вектора по индексу 1: " + m1.getRow(1));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Не соотвествует индекс вектора размерам матрицы");
            System.out.println();
        }

        System.out.println("Столбец матрицы m1 равен: " + m1.getColumnsCount());
        System.out.println();
        try {
            Vector vector4 = new Vector(c1);
            m1.setRow(2, vector4);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Не соотвествует индекс вектора размерам матрицы!");
            System.out.println();
        }
        Matrix matrix = new Matrix(3, 3);
        System.out.println("Размер матрицы: " + matrix);
        System.out.println();

        System.out.println("До траспортирования матрицы m1: " + m1);
        m1.transposition();
        System.out.println("После траспортирования матрицы m1: " + m1);

        try {
            vector3 = m1.getColumn(1);
            System.out.println("Поучение вектора-столбца по индексу " + vector3);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Не соотвествует индекс вектора размерам матрицы!");
            System.out.println();
        }

        m1.multiplicationByScalar(3);
        System.out.println("Умножение на 3: " + m1);

        System.out.println("Определитель матрицы m1 равен:" + m1.determinant());

        System.out.println("Умножение матрицы на вектор: " + m1.multiplicationScalar(vector1));
        Matrix m2 = new Matrix(m1);
        m2.addMatrix(m);
        System.out.println("Сложение матрицы(Первый вариант): " + m2);

        Matrix m3 = new Matrix(m1);
        m2.diffMatrix(m);
        System.out.println("Вычитание матрицы(Первый вариант): " + m3);

        System.out.println("Сложение матрицы(Второй вариант): " + Matrix.getAddMatrix(m1, m));

        System.out.println("Вычитание матрицы(Второй вариант): " + Matrix.getDiffMatrix(m1, m));

        System.out.println("Умножение матрицы на матрицу:" + Matrix.multiplicationOfMatrix(m1, m));
    }
}

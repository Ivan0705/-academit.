package ru.academit.ivanvish.main.Vector.Main;

import ru.academit.ivanvish.main.Vector.Vector.Vector;


public class Main {
    public static void main(String[] args) {
        double[] c1 = {2, 4, 6, 3};
        Vector vector1 = new Vector(c1);
        try {
            System.out.println(vector1);
            System.out.println();
        } catch (IllegalAccessError e) {
            System.out.println("EXCEPTION!Размерность пространства равна нулю или отрицательна!");
            System.out.println();
        }
        double[] c2 = {5, 8, 7};
        Vector vector2 = new Vector(c2);
        try {
            System.out.println(vector2);
            System.out.println();
        } catch (IllegalAccessError e) {
            System.out.println("EXCEPTION!Размерность пространства равна нулю или отрицательна!");
            System.out.println();
        }

        try {
            int n = 3;
            Vector vector3 = new Vector(n);
            System.out.println(vector3);
            System.out.println();
        } catch (IllegalAccessError e) {
            System.out.println("EXCEPTION!Размерность пространства равна нулю или отрицательна!");
            System.out.println();
        }
       /* try {
            int n = -2;
            Vector vector3 = new Vector(n);
            System.out.println(vector3);
            System.out.println();
        } catch (IllegalAccessError e) {
            System.out.println("EXCEPTION!Размерность пространства равна нулю или отрицательна!");
            System.out.println();
        }*/
        try {
            System.out.println("Копируем вектор");
            Vector vector4 = new Vector(vector1);
            System.out.println(vector4);
            System.out.println();
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION!Размерность пространства равна нулю или отрицательна!");
            System.out.println();
        }

        Vector vector5;
        try {
            vector5 = new Vector(8, c1);
            System.out.println("Координаты вектора5 - " + vector5);
            System.out.println();
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION!Размерность пространства равна нулю или отрицательна!");
            System.out.println();
        }

        try {
            System.out.println("Длина массива вектора: " + vector1 + ": " + vector1.getSize());
            System.out.println();
        } catch (NullPointerException e) {
            System.out.println("EXCEPTION!Размерность вектора  равна нулю!");
            System.out.println();
        }

        try {
            System.out.println("Длина вектора: " + vector1.getLength());
            System.out.println();
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION!Размерность вектора  равна нулю!");
            System.out.println();
        }

        Vector vector3 = Vector.getSum(vector1, vector2);
        System.out.println("Сумма двух ветровов (первый вариант): " + vector1 + " + " + vector2 + " = " + vector3);
        vector1.add(vector2);
        System.out.println("Сумма двух ветровов (второй вариант): " + vector1);
        System.out.println();

        Vector vector4 = Vector.getDifference(vector1, vector2);
        System.out.println("Вычитание векторов (первый вариант): " + vector1 + " - " + vector2 + " = " + vector4);
        vector1.subtraction(vector2);
        System.out.println("Вычитание векторов (второй вариант): " + vector1);
        System.out.println();

        Vector vector6 = new Vector(vector2);
        vector6.getMultiByScalar(7);
        System.out.println("Скалярное произведение на 7: " + vector6);
        System.out.println("Скалярное произведение векторов : " + vector1 + " и " + vector2 + " = " + Vector.getScalarProduct(vector1, vector2));
        System.out.println();

        vector1.turn();
        System.out.println("Разворот вектора: " + vector1);
        System.out.println();

        System.out.println("Сравниваем 2 векторов: ");
        if (vector1.equals(vector2)) {
            System.out.println("Вектора одинаковые");
        } else {
            System.out.println("Вектора разные");
        }

        vector2.setElement(0, 17);
        System.out.println("Замена точки по индексу: " + vector2);
        Vector vector7 = new Vector(c1);
        System.out.println("Элемент по индексу равен: " + vector7.getElement(2));
    }
}

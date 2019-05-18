package ru.academit;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        char convertTo = JOptionPane.showInputDialog("Введите букву 'C' для преобразования в градусы Цельсия и букву 'F' для преобразования в градусы Фаренгейта").charAt(0);
        double temperature = Double.parseDouble(JOptionPane.showInputDialog("Введите значение градусов"));

        temp t = new temp();
        JOptionPane.showMessageDialog(null, t.convertTemp(temperature, convertTo));
    }
}

package ru.academits.IvanVishnevsky.Main;

import ru.academits.IvanVishnevsky.Temperature.ConvertTemperature;

import javax.swing.*;

public class Temp {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        new ConvertTemperature();
    }
}

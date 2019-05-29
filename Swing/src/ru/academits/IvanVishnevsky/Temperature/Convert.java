package ru.academits.IvanVishnevsky.Temperature;

import javax.swing.*;
import java.awt.*;

public class Convert {
    private JTextField enterTemperature;
    private double temperature;
    private JLabel temperatureCalculationResult;

    public Convert() {
        JFrame frame = new JFrame("Перевод температур");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JButton fahrenheitButton = new JButton("Фаренгейт");
        JButton kelvinButton = new JButton("Келвин");
        temperatureCalculationResult = new JLabel();
        enterTemperature = new JTextField(10);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(fahrenheitButton);
        panel.add(kelvinButton);
        panel.add(enterTemperature);
        panel.add(temperatureCalculationResult);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setSize(300, 200);
        frame.setContentPane(panel);
        frame.setVisible(true);

        kelvinButton.addActionListener(e -> tempKelvin());

        fahrenheitButton.addActionListener(e -> tempFahr());
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e1) {
            e1.printStackTrace();
        }
    }

    private void tempKelvin() {
        convertKelvin();
    }

    private void tempFahr() {
        convertFar();
    }

    private void convertKelvin() {
        JPanel panelKelvin = new JPanel();
        try {
            temperature = Double.parseDouble(enterTemperature.getText());
            double result = temperature * 9 / 5 + 32;
            String str = result + "градусов по Кельвину";
            temperatureCalculationResult.setText(str);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(panelKelvin, "Нужно вводить только цифры!");
        }
    }

    private void convertFar() {
        JPanel panelFahrenheit = new JPanel();
        try {
            temperature = Double.parseDouble(enterTemperature.getText());
            double result = (temperature - 32) * 5 / 9;
            String str = result + " градусов по Фаренгейту";
            temperatureCalculationResult.setText(str);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(panelFahrenheit, "Нужно вводить только цифры!");
        }
    }
}

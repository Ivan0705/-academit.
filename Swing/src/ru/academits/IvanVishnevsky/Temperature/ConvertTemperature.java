package ru.academits.IvanVishnevsky.Temperature;

import javax.swing.*;
import java.awt.*;

public class ConvertTemperature extends JFrame {
    private JButton fahrenheitButton;
    private JButton kelvinButton;
    private JTextField enterTemperature;
    private double temperature;
    private JLabel temperatureCalculationResult;

    public ConvertTemperature() {
        JFrame frame = new JFrame("Перевод температур");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fahrenheitButton = new JButton("Фаренгейт");
        kelvinButton = new JButton("Келвин");
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
        frame.setSize(300, 100);
        frame.setContentPane(panel);
        frame.setVisible(true);

        kelvinButton.addActionListener(e -> {
            try {
                if (kelvinButton == e.getSource()) {
                    temperature = Double.parseDouble(enterTemperature.getText());
                    double kelvinTemperature = (temperature * 9 / 5 + 32);
                    String kelvinString = kelvinTemperature + " градусов по Кельвину";
                    temperatureCalculationResult.setText(kelvinString);

                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(panel, "Нужно вводить только цифры!");
            }
        });

        fahrenheitButton.addActionListener(e -> {
            try {
                if (fahrenheitButton == e.getSource()) {
                    temperature = Double.parseDouble(enterTemperature.getText());
                    double fahrenheitTemperature = temperature = ((temperature - 32) * 5 / 9);
                    String fahrenheitString = fahrenheitTemperature + " градусов по Фаренгейту";
                    temperatureCalculationResult.setText(fahrenheitString);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(panel, "Нужно вводить  только цифры!");
            }
        });
    }
}

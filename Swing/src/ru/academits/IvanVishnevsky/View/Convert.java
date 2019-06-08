package ru.academits.IvanVishnevsky.View;

import ru.academits.IvanVishnevsky.Models.CelsiusConverter;
import ru.academits.IvanVishnevsky.Models.FahrenheitConverter;
import ru.academits.IvanVishnevsky.Models.KelvinConverter;

import javax.swing.*;
import java.awt.*;

public class Convert {
    public Convert() {
        JFrame frame = new JFrame("Перевод температур");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel temperatureCalculationResult = new JLabel();
        JLabel inputFieldTemperature = new JLabel("Введите температуру!");
        JTextField outputFieldTemperature = new JTextField(10);
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton fahrenheitButton = new JButton("Перевести в шкалу Фаренгейта");
        JButton kelvinButton = new JButton("Перевести в шкалу Кельвина");
        JButton celsiusButton = new JButton("Перевести в шкалу Цельсия");
        panel.add(inputFieldTemperature);
        panel.add(outputFieldTemperature);
        panel.add(fahrenheitButton);
        panel.add(kelvinButton);
        panel.add(celsiusButton);
        panel.add(temperatureCalculationResult);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setSize(300, 300);
        Dimension dimensionMinimum = new Dimension(250, 200);
        frame.setMinimumSize(dimensionMinimum);
        frame.setContentPane(panel);
        frame.setVisible(true);

        kelvinButton.addActionListener(e -> {
            try {
                double temperature = Double.parseDouble(outputFieldTemperature.getText());
                temperatureCalculationResult.setText(String.valueOf(new KelvinConverter(temperature)));
            } catch (NumberFormatException ew) {
                JPanel kelvinPanel = new JPanel();
                JOptionPane.showMessageDialog(kelvinPanel, "Нужно вводить только цифры!");
            }
        });
        fahrenheitButton.addActionListener(e -> {
            try {
                double temperature = Double.parseDouble(outputFieldTemperature.getText());
                temperatureCalculationResult.setText(String.valueOf(new FahrenheitConverter(temperature)));
            } catch (NumberFormatException ew) {
                JPanel FahrenheitPanel = new JPanel();
                JOptionPane.showMessageDialog(FahrenheitPanel, "Нужно вводить только цифры!");
            }
        });
        celsiusButton.addActionListener(e -> {
            try {
                double temperature = Double.parseDouble(outputFieldTemperature.getText());
                temperatureCalculationResult.setText(String.valueOf(new CelsiusConverter(temperature)));
            } catch (NumberFormatException ew) {
                JPanel CelsiusPanel = new JPanel();
                JOptionPane.showMessageDialog(CelsiusPanel, "Нужно вводить только цифры!");
            }
        });
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e1) {
            e1.printStackTrace();
        }
    }
}


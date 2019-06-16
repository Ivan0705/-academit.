package ru.academits.IvanVishnevsky.View;

import ru.academits.IvanVishnevsky.Models.CelsiusConverter;
import ru.academits.IvanVishnevsky.Models.FahrenheitConverter;
import ru.academits.IvanVishnevsky.Models.KelvinConverter;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Converter {
    public Converter() {
        JFrame frame = new JFrame("Перевод температур");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JLabel enterTemperature = new JLabel("Введите температуру:");
        JLabel selectScaleTemperature = new JLabel("Выберите шкалу температур: ");

        JTextField inputFieldTemperature = new JTextField(12);
        JLabel outputFieldTemperature = new JLabel();

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JComboBox<Object> fromTypeTemperature = new JComboBox<>();
        fromTypeTemperature.addItem("Цельсий");
        fromTypeTemperature.addItem("Фаренгейт");
        fromTypeTemperature.addItem("Кельвин");
        panel.add(enterTemperature);
        panel.add(inputFieldTemperature);
        panel.add(outputFieldTemperature);
        panel.add(selectScaleTemperature);
        panel.add(fromTypeTemperature);

        JButton KelvinButton = new JButton("Перевести в шкалу Кельвина");
        JButton CelsiusButton = new JButton("Перевести в шкалу  Цельсия");
        JButton FahrenheitButton = new JButton("Перевести в шкалу Фаренгейта");
        panel.add(KelvinButton);
        panel.add(CelsiusButton);
        panel.add(FahrenheitButton);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setSize(300, 300);

        frame.setResizable(false);
        Dimension dimensionMinimum = new Dimension(300, 300);
        frame.setMinimumSize(dimensionMinimum);
        frame.setContentPane(panel);
        frame.setVisible(true);

        KelvinButton.addActionListener(e -> {
            try {
                double temperature = Double.parseDouble(inputFieldTemperature.getText());
                double result;
                String strOption = Objects.requireNonNull(fromTypeTemperature.getSelectedItem()).toString();

                if ("Цельсий".equals(strOption)) {
                    result = CelsiusConverter.convertFromCelsiusToKelvin(temperature);
                } else if ("Фаренгейт".equals(strOption)) {
                    result = FahrenheitConverter.converterFromFahrenheitToKelvin(temperature);
                } else {
                    result = KelvinConverter.converterFromKelvinToKelvin(temperature);
                }
                outputFieldTemperature.setText(String.format("%.4g%n" + result + " градусов по Кельвину"));
            } catch (NumberFormatException ew) {
                JPanel CelsiusPanel = new JPanel();
                JOptionPane.showMessageDialog(CelsiusPanel, "Нужно вводить только цифры!");
            }
        });
        CelsiusButton.addActionListener(e -> {
            try {
                double temperature = Double.parseDouble(inputFieldTemperature.getText());
                double result;
                String strOption2 = Objects.requireNonNull(fromTypeTemperature.getSelectedItem()).toString();

                if ("Цельсий".equals(strOption2)) {
                    result = CelsiusConverter.convertFromCelsiusToCelsius(temperature);
                } else if ("Фаренгейт".equals(strOption2)) {
                    result = FahrenheitConverter.converterFromFahrenheitToCelsius(temperature);
                } else {
                    result = KelvinConverter.convertFromKelvinToCelsius(temperature);
                }
                outputFieldTemperature.setText(String.format("%.4g%n" + result + " градусов по Цельсию "));
            } catch (NumberFormatException ew) {
                JPanel CelsiusPanel = new JPanel();
                JOptionPane.showMessageDialog(CelsiusPanel, "Нужно вводить только цифры!");
            }
        });

        FahrenheitButton.addActionListener(e -> {
            try {
                double temperature = Double.parseDouble(inputFieldTemperature.getText());
                double result;
                String strOption = Objects.requireNonNull(fromTypeTemperature.getSelectedItem()).toString();

                if ("Цельсий".equals(strOption)) {
                    result = CelsiusConverter.converterFromCelsiusToFahrenheit(temperature);

                } else if ("Фаренгейт".equals(strOption)) {
                    result = FahrenheitConverter.converterFromFahrenheitToFahrenheit(temperature);
                } else {
                    result = KelvinConverter.converterFromKelvinToFahrenheit(temperature);
                }
                outputFieldTemperature.setText(String.format("%.4g%n" + result + " градусов по Фаренгейту"));
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

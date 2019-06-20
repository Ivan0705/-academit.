package ru.academits.IvanVishnevsky.View;

import ru.academits.IvanVishnevsky.Models.CelsiusConverter;
import ru.academits.IvanVishnevsky.Models.FahrenheitConverter;
import ru.academits.IvanVishnevsky.Models.KelvinConverter;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Objects;

public class Converter {
    public Converter() {
        JFrame frame = new JFrame("Перевод температур");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JLabel enterTemperature = new JLabel("Введите температуру:");
        JLabel selectScaleTemperature = new JLabel("Выберите шкалу температур: ");
        JLabel convertScaleTemperature = new JLabel("Перевести в  шкалу температур");
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
        panel.add(selectScaleTemperature);


        JButton KelvinButton = new JButton("Перевести в шкалу Кельвина");
        JButton CelsiusButton = new JButton("Перевести в шкалу  Цельсия");
        JButton FahrenheitButton = new JButton("Перевести в шкалу Фаренгейта");


        String[] typeTemperature = {"Цельсий", "Фаренгейт", "Кельвин"};
        JComboBox<String> toTypeTemperature = new JComboBox<>(typeTemperature);

        panel.add(toTypeTemperature);
        panel.add(convertScaleTemperature);

        panel.add(fromTypeTemperature);
        JButton convert = new JButton("Вычислить");
        panel.add(convert);
        panel.add(KelvinButton);
        panel.add(CelsiusButton);
        panel.add(FahrenheitButton);
        panel.add(outputFieldTemperature);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setSize(300, 300);

        frame.setResizable(false);
        Dimension dimensionMinimum = new Dimension(300, 300);
        frame.setMinimumSize(dimensionMinimum);
        frame.setContentPane(panel);
        frame.setVisible(true);
        convert.addActionListener(e -> {
            try {
                double temperature = Double.parseDouble(inputFieldTemperature.getText());
                double result;
                String strResult = null;
                String fromOption = Objects.requireNonNull(fromTypeTemperature.getSelectedItem()).toString();
                String toOption = Objects.requireNonNull(toTypeTemperature.getSelectedItem()).toString();
                NumberFormat formatter = new DecimalFormat("#0.00");
                if (Objects.equals(fromOption, toOption)) {
                    result = temperature;
                    strResult = formatter.format(result);
                } else {
                    if (Objects.equals(toOption.compareTo("Кельвин"), fromOption.compareTo("Цельсий"))) {
                        result = CelsiusConverter.toCelsius(temperature);
                        strResult = formatter.format(result);
                    } else if (Objects.equals(fromOption.compareTo("Цельсий"), toOption.compareTo("Фаренгейт"))) {
                        result = CelsiusConverter.converterFromCelsiusToFahrenheit(temperature);
                        strResult = formatter.format(result);
                    } else if (Objects.equals(fromOption.compareTo("Кельвин"), toOption.compareTo("Цельсий"))) {
                        result = KelvinConverter.convertFromKelvinToCelsius(temperature);
                        strResult = formatter.format(result);
                    } else if (Objects.equals(fromOption.compareTo("Кельвин"), toOption.compareTo("Фаренгейт"))) {
                        result = KelvinConverter.converterFromKelvinToFahrenheit(temperature);
                        strResult = formatter.format(result);
                    } else if (Objects.equals(fromOption.compareTo("Фаренгейт"), toOption.compareTo("Цельсий"))) {
                        result = FahrenheitConverter.converterFromFahrenheitToCelsius(temperature);
                        strResult = formatter.format(result);
                    } else if (Objects.equals(fromOption.compareTo("Фаренгейт"), toOption.compareTo("Кельвин"))) {
                        result = FahrenheitConverter.converterFromFahrenheitToKelvin(temperature);
                        strResult = formatter.format(result);
                    }
                }

                outputFieldTemperature.setText("Результат перевода температур: " + strResult);
            } catch (NumberFormatException ex) {
                JPanel panel1 = new JPanel();
                JOptionPane.showMessageDialog(panel1, "Нужно вводить только цифры!");
            }


        });
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
                NumberFormat formatter = new DecimalFormat("#0.00");
                outputFieldTemperature.setText(formatter.format(result) + " градусов по Кельвину");
            } catch (NumberFormatException ew) {
                JPanel CelsiusPanel = new JPanel();
                JOptionPane.showMessageDialog(CelsiusPanel, "Нужно вводить только цифры!");
            }
        });
        CelsiusButton.addActionListener(e -> {
            try {
                double temperature = Double.parseDouble(inputFieldTemperature.getText());
                double result;
                String strOption = Objects.requireNonNull(fromTypeTemperature.getSelectedItem()).toString();

                if ("Цельсий".equals(strOption)) {
                    result = CelsiusConverter.convertFromCelsiusToCelsius(temperature);
                } else if ("Фаренгейт".equals(strOption)) {
                    result = FahrenheitConverter.converterFromFahrenheitToCelsius(temperature);
                } else {
                    result = KelvinConverter.convertFromKelvinToCelsius(temperature);
                }
                NumberFormat formatter = new DecimalFormat("#0.00");
                outputFieldTemperature.setText(formatter.format(result) + " градусов по Цельсию ");
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
                NumberFormat formatter = new DecimalFormat("#0.00");
                outputFieldTemperature.setText(formatter.format(result) + " градусов по Фаренгейту");
            } catch (NumberFormatException ew) {
                JPanel CelsiusPanel = new JPanel();
                JOptionPane.showMessageDialog(CelsiusPanel, "Нужно вводить только цифры!");
            }
        });
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException |
                UnsupportedLookAndFeelException e1) {
            e1.printStackTrace();
        }
    }
}

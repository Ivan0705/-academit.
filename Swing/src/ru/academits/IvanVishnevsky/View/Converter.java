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
        JLabel convertScaleTemperature = new JLabel("Перевести в  шкалу температур: ");
        JTextField inputFieldTemperature = new JTextField(12);
        JLabel outputFieldTemperature = new JLabel();

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JComboBox<Object> fromTypeTemperature = new JComboBox<>();
        fromTypeTemperature.addItem("Цельсий");
        fromTypeTemperature.addItem("Фаренгейт");
        fromTypeTemperature.addItem("Кельвин");

        String[] typeTemperature = {"Цельсий", "Фаренгейт", "Кельвин"};
        JComboBox<String> toTypeTemperature = new JComboBox<>(typeTemperature);
        JButton convert = new JButton("Вычислить");

        panel.add(enterTemperature);
        panel.add(inputFieldTemperature);
        panel.add(outputFieldTemperature);
        panel.add(convertScaleTemperature);
        panel.add(toTypeTemperature);
        panel.add(selectScaleTemperature);
        panel.add(fromTypeTemperature);
        panel.add(outputFieldTemperature);
        panel.add(convert);

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
                double result = 0;
                String strResult;

                String fromOption = Objects.requireNonNull(fromTypeTemperature.getSelectedItem()).toString();
                String toOption = Objects.requireNonNull(toTypeTemperature.getSelectedItem()).toString();
                NumberFormat formatter = new DecimalFormat("#0.00");

                if (Objects.equals(fromOption, toOption)) {
                    result = temperature;
                } else {
                    if (Objects.equals(toOption.compareTo("Кельвин"), fromOption.compareTo("Цельсий"))) {
                        result = KelvinConverter.convertFromKelvinToCelsius(temperature);//tested

                    } else if (Objects.equals(fromOption.compareTo("Цельсий"), toOption.compareTo("Фаренгейт"))) {
                        result = FahrenheitConverter.converterFromFahrenheitToCelsius(temperature);//tested
                    } else if (Objects.equals(fromOption.compareTo("Кельвин"), toOption.compareTo("Цельсий"))) {
                        result = CelsiusConverter.convertFromCelsiusToKelvin(temperature);//tested

                    } else if (Objects.equals(fromOption.compareTo("Кельвин"), toOption.compareTo("Фаренгейт"))) {
                        result = FahrenheitConverter.converterFromFahrenheitToKelvin(temperature);//tested

                    } else if (Objects.equals(fromOption.compareTo("Фаренгейт"), toOption.compareTo("Цельсий"))) {
                        result = CelsiusConverter.converterFromCelsiusToFahrenheit(temperature);//tested
                    } else if (Objects.equals(fromOption.compareTo("Фаренгейт"), toOption.compareTo("Кельвин"))) {
                        result = KelvinConverter.converterFromKelvinToFahrenheit(temperature);//tested0
                    }
                }
                strResult = formatter.format(result);
                outputFieldTemperature.setText("Результат перевода температур: " + strResult);
            } catch (NumberFormatException ex) {
                JPanel panel1 = new JPanel();
                JOptionPane.showMessageDialog(panel1, "Нужно вводить только цифры!");
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

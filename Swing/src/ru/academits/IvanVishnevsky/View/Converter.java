package ru.academits.IvanVishnevsky.View;

import ru.academits.IvanVishnevsky.Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Objects;

public class Converter {
    public Converter() {
        SwingUtilities.invokeLater(() -> {
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

            JComboBox<Object> toTypeTemperature = new JComboBox<>();
            toTypeTemperature.addItem("Цельсий");
            toTypeTemperature.addItem("Фаренгейт");
            toTypeTemperature.addItem("Кельвин");

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
                    double result;
                    java.lang.String strResult;
                    NumberFormat formatter = new DecimalFormat("#0.00");
                    java.lang.String fromOption = Objects.requireNonNull(fromTypeTemperature.getSelectedItem()).toString();
                    java.lang.String toOption = Objects.requireNonNull(toTypeTemperature.getSelectedItem()).toString();
                    if (Objects.equals(fromOption, toOption)) {
                        result = temperature;
                    } else {
                        Controller controller = new Controller(fromOption, toOption, temperature);
                        result = controller.getConvertFromCelsius();
                    }
                    strResult = formatter.format(result);
                    outputFieldTemperature.setText("Результат перевода температур: " + strResult);
                } catch (NumberFormatException ex) {
                    JPanel panel1 = new JPanel();
                    JOptionPane.showMessageDialog(panel1, "Нужно вводить только цифры!");
                }
            });
        });

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException |
                UnsupportedLookAndFeelException e1) {
            e1.printStackTrace();
        }
    }
}

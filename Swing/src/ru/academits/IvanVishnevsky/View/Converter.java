package ru.academits.IvanVishnevsky.View;

import ru.academits.IvanVishnevsky.Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Objects;

public class Converter {


    public Converter() {
        JFrame frame = new JFrame("Перевод температур");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JLabel enterTemperature = new JLabel("Введите температуру ");
        JLabel selectScaleTemperature = new JLabel("Выберите шкалу температур: ");
        JLabel transferTemperature = new JLabel("Перевести в другую шкалу: ");

        JTextField inputFieldTemperature = new JTextField(12);
        JTextField outputFieldTemperature = new HintTextField("Результат перевода температур");

        outputFieldTemperature.setEditable(false);
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));


        final String[] temperatureType = {"Цельсий", "Фаренгейт", "Кельвин"};
        JComboBox<String> fromTypeTemperature = new JComboBox<>(temperatureType);
        JComboBox<String> toTypeTemperature = new JComboBox<>(temperatureType);

        panel.add(enterTemperature);
        panel.add(inputFieldTemperature);
        panel.add(outputFieldTemperature);
        panel.add(selectScaleTemperature);
        panel.add(fromTypeTemperature);
        panel.add(transferTemperature);
        panel.add(toTypeTemperature);
        JButton calculationButton = new JButton("Вычислить");
        panel.add(calculationButton);


        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setSize(300, 300);

        frame.setResizable(false);
        Dimension dimensionMinimum = new Dimension(300, 300);
        frame.setMinimumSize(dimensionMinimum);
        frame.setContentPane(panel);
        frame.setVisible(true);

        calculationButton.addActionListener(e -> {
            try {
                double temperature = Double.parseDouble(inputFieldTemperature.getText());
                double result;
                String fromTypeValue = (String) fromTypeTemperature.getSelectedItem();
                String toTypeValue = (String) toTypeTemperature.getSelectedItem();
                if (Objects.equals(fromTypeValue, toTypeValue)) {
                    result = temperature;
                } else {
                    result = Controller.toConvert(temperature, fromTypeValue, toTypeValue);
                }
                outputFieldTemperature.setText(String.valueOf(String.format("%.4g%n", result)));
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

    private class HintTextField extends JTextField implements FocusListener {
        private final String text;
        private boolean showingText;

        HintTextField(final String text) {
            super(text);
            this.text = text;
            this.showingText = true;
            super.addFocusListener(this);
            super.getPreferredSize();
        }

        @Override
        public void focusGained(FocusEvent e) {
            if (this.getText().isEmpty()) {
                super.setText("");
                showingText = false;
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (this.getText().isEmpty()) {
                super.setText(text);
                showingText = true;
            }
        }

        @Override
        public String getText() {
            return showingText ? "" : super.getText();
        }
    }
}

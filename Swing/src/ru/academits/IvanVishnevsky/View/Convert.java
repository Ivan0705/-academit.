package ru.academits.IvanVishnevsky.View;


import ru.academits.IvanVishnevsky.Models.FahrenheitConverter;
import ru.academits.IvanVishnevsky.Models.KelvinConverter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Convert {
    public Convert() {
        JFrame frame = new JFrame("Перевод температур");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel temperatureCalculationResult = new JLabel();
        JTextField inputFieldTemperature = new PointerTextField("Введите температуру!");
        JTextField outputFieldTemperature = new JTextField(10);
        inputFieldTemperature.setEditable(false);
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton fahrenheitButton = new JButton("градус Фаренгейта");
        JButton kelvinButton = new JButton("градус Кельвина");

        panel.add(inputFieldTemperature);
        panel.add(outputFieldTemperature);
        panel.add(fahrenheitButton);
        panel.add(kelvinButton);
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
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e1) {
            e1.printStackTrace();
        }
    }

    private class PointerTextField extends JTextField implements FocusListener {
        private String text;
        private boolean showText;

        PointerTextField(String text) {
            super(text);
            this.text = text;
            this.showText = true;
            super.addFocusListener(this);
        }

        @Override
        public void focusGained(FocusEvent e) {
            if (this.getText().isEmpty()) {
                super.setText("");
                showText = false;
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (this.getText().isEmpty()) {
                super.setText(text);
                showText = true;
            }
        }

        @Override
        public String toString() {
            return showText ? "" : super.getText();
        }
    }
}


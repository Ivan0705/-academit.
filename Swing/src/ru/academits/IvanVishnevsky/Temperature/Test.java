package ru.academits.IvanVishnevsky.Temperature;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test {
    private JButton fahrenheitButton;
    private JButton kelvinButton;
    private JTextField enterTemperature;
    private double temperature;
    private JLabel temperatureCalculationResult;

    public Test() {
        JFrame frame = new JFrame("Перевод температур");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
        frame.setSize(300, 200);
        frame.setContentPane(panel);
        frame.setVisible(true);

        ActionListener listener1 = new FahrenheitListener();
        fahrenheitButton.addActionListener(listener1);

        ActionListener listener2 = new KelvinListener();
        kelvinButton.addActionListener(listener2);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e1) {
            e1.printStackTrace();
        }
    }

    public class FahrenheitListener implements ActionListener {
        JPanel panelFahrenheit = new JPanel();
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (fahrenheitButton == e.getSource()) {
                    temperature = Double.parseDouble(enterTemperature.getText());
                    double result = (temperature - 32) * 5 / 9;
                    String str = result + " градусов по Фаренгейту!";
                    temperatureCalculationResult.setText(str);
                }
            } catch (NumberFormatException ep) {
                JOptionPane.showMessageDialog(panelFahrenheit, "Нужно вводить только цифры!");
            }
        }
    }

    public class KelvinListener implements ActionListener {
        JPanel panelKelvin = new JPanel();
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (kelvinButton == e.getSource()) {
                    temperature = Double.parseDouble(enterTemperature.getText());
                    double result = temperature * 9 / 5 + 32;
                    String str = result + " градусов по Кельвину!";
                    temperatureCalculationResult.setText(str);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(panelKelvin, "Нужно вводить только цифры!");
            }
        }
    }
}

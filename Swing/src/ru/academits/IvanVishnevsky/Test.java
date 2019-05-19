package ru.academits.IvanVishnevsky;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test extends JFrame {
    private JButton fahrenheitButton;
    private JButton kelvinButton;
    private JTextField enterTemperature;
    private double temperature;
    private JLabel temperatureCalculationResult;

    private boolean isNumber(JTextField enterTemperature) {
        temperature = Double.parseDouble(enterTemperature.getText());
        return false;
    }

    public Test() {
        super("Перевод температур");
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
        setContentPane(panel);
        setVisible(true);
        kelvinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isNumber(enterTemperature)) {
                    // throw new IllegalArgumentException("Ввели неверный аргумент!");
                    String error = "Ввели неверный аргумент!";
                    temperatureCalculationResult.setText(error);
                }
                if (kelvinButton == e.getSource()) {
                    temperature = Double.parseDouble(enterTemperature.getText());
                    double kelvinTemperature = (temperature * 9 / 5 + 32);
                    String kelvinString = kelvinTemperature + " градусов по Кельвину";
                    temperatureCalculationResult.setText(kelvinString);
                }
            }
        });
        fahrenheitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fahrenheitButton == null) {
                    throw new NullPointerException("Вы ничего не ввели!");
                }
                if (fahrenheitButton == e.getSource()) {
                    temperature = Double.parseDouble(enterTemperature.getText());
                    double fahrenheitTemperature = temperature = ((temperature - 32) * 5 / 9);
                    String fahrenheitString = fahrenheitTemperature + " градусов по Фаренгейту";
                    temperatureCalculationResult.setText(fahrenheitString);
                }
            }
        });
    }
}

package ru.academits.IvanVishnevsky;

import javax.swing.*;
import java.awt.*;

public class ConvertTemperature extends JFrame {
    private JButton fahrenheitButton;
    private JButton kelvinButton;
    private JTextField enterTemperature;
    private double temperature;
    private JLabel temperatureCalculationResult;

    public ConvertTemperature() {
        super("Перевод температур");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fahrenheitButton = new JButton("Фаренгейт");
        kelvinButton = new JButton("Келвин");
        temperatureCalculationResult = new JLabel();

        enterTemperature = new JTextField(10);
        enterTemperature.setHorizontalAlignment(JTextField.CENTER);
        enterTemperature.setCaretColor(Color.RED);
        enterTemperature.setEditable(true);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(fahrenheitButton);
        panel.add(kelvinButton);
        panel.add(enterTemperature);
        panel.add(temperatureCalculationResult);
        setContentPane(panel);
        setSize(400,400);
        setMaximumSize(new Dimension(300, 800));
        setMinimumSize(new Dimension(180, 250));
        setVisible(true);

        kelvinButton.addActionListener(e -> {
            if (kelvinButton == e.getSource()) {
                temperature = Double.parseDouble(enterTemperature.getText());
                double kelvinTemperature = (temperature * 9 / 5 + 32);
                String kelvinString = kelvinTemperature + " градусов по Кельвину";
                temperatureCalculationResult.setText(kelvinString);
            }
        });

        fahrenheitButton.addActionListener(e -> {
            if (fahrenheitButton == e.getSource()) {
                temperature = Double.parseDouble(enterTemperature.getText());
                double fahrenheitTemperature = temperature = ((temperature - 32) * 5 / 9);
                String fahrenheitString = fahrenheitTemperature + " градусов по Фаренгейту";
                temperatureCalculationResult.setText(fahrenheitString);
            }
        });
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 600);
    }
}

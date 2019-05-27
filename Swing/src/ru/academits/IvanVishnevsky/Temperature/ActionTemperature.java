package ru.academits.IvanVishnevsky.Temperature;

import javax.swing.*;
import java.awt.event.ActionEvent;

public abstract class ActionTemperature extends AbstractAction {
    private Temperature temperature;

    public ActionTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double value = temperature.getValue();
        temperature.setFahrenheit(toFahrenheit(value));
        temperature.setKelvin(toKelvin(value));
    }

    public abstract double toKelvin(double value);

    public abstract double toFahrenheit(double value);
}

package ru.academits.IvanVishnevsky.Models;


public class FahrenheitConverter implements ConverterTemperature {
    static final String NAME = "Фаренгейт";

    @Override
    public double toCelsius(double value) {
        return (value - 32) * 5 / 9;
    }

    @Override
    public double fromCelsius(double value) {
        return (value * 1.8) + 32;
    }
 /*   private double value;

    public FahrenheitConverter(double value) {
        this.value = value;
    }

    private double convertFahrenheit() {
        return (value - 32) * 5 / 9;
    }

    @Override
    public String toString() {
        return String.format("%.4g%n", convertFahrenheit()) + " градусов по Фаренгейту!";
    }*/
}

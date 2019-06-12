package ru.academits.IvanVishnevsky.Models;

public class KelvinConverter implements ConverterTemperature{
    static final String NAME = "Кельвин";

    @Override
    public double toCelsius(double value) {
        return value - 273.15;
    }

    @Override
    public double fromCelsius(double value) {
        return value + 273.15;
    }
 /*   private double value;

    public KelvinConverter(double value) {
        this.value = value;
    }

    private double convertKelvin() {
        return value * 9 / 5 + 32;
    }

    @Override
    public String toString() {
        return String.format("%.4g%n", convertKelvin()) + " градусов по Кельвину!";
    }*/
}

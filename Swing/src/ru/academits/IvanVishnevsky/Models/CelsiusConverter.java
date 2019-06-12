package ru.academits.IvanVishnevsky.Models;

public class CelsiusConverter implements ConverterTemperature{
    static final String NAME = "Цельсий";

    @Override
    public double toCelsius(double value) {
        return value;
    }

    @Override
    public double fromCelsius(double value) {
        return value;
    }
   /* private double value;

    public CelsiusConverter(double value) {
        this.value = value;
    }

    private double convertCelsius() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("%.4g%n", convertCelsius()) + " градусов по Цельсию!";
    }*/
}

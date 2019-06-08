package ru.academits.IvanVishnevsky.Models;

public class CelsiusConverter {
    private double value;

    public CelsiusConverter(double value) {
        this.value = value;
    }

    private double convertCelsius() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("%.4g%n", convertCelsius()) + " градусов по Цельсию!";
    }
}

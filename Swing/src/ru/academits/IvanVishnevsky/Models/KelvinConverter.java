package ru.academits.IvanVishnevsky.Models;

public class KelvinConverter {
    private double value;

    public KelvinConverter(double value) {
        this.value = value;
    }

    private double convertKelvin() {
        return value * 9 / 5 + 32;
    }

    @Override
    public String toString() {
        return String.format("%.4g%n", convertKelvin()) + " градусов по Кельвину!";
    }
}

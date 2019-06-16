package ru.academits.IvanVishnevsky.Models;

public class FahrenheitConverter {
    public FahrenheitConverter() {
    }

    public static double converterFromFahrenheitToCelsius(double value) {
        return value - 273.15;
    }

    public static double converterFromFahrenheitToKelvin(double value) {
        return 1.8 * (value - 273.15) + 32;
    }

    public static double converterFromFahrenheitToFahrenheit(double value) {
        return value;
    }
}

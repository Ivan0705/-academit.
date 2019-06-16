package ru.academits.IvanVishnevsky.Models;

public class FahrenheitConverter {
    public FahrenheitConverter() {
    }

    public static double converterFromFahrenheitToCelsius(double value) {
        return (value - 32) * 5 / 9;
    }

    public static double converterFromFahrenheitToKelvin(double value) {
        return (value - 32) * 5 / 9 + 273.15;
    }

    public static double converterFromFahrenheitToFahrenheit(double value) {
        return value;
    }
}

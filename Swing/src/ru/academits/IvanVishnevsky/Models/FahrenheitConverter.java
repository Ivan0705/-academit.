package ru.academits.IvanVishnevsky.Models;

public class FahrenheitConverter {
    public static double toCelsius(double value) {
        return (value - 32) * 5 / 9;
    }


    public static double fromCelsius(double value) {
        return (value * 1.8) + 32;
    }

    public static double converterFromFahrenheitToCelsius(double value) {
        return (value - 32) / 1.8;
    }

    public static double converterFromFahrenheitToKelvin(double value) {
        return (value + 459.67) / 1.8;
    }

    public static double converterFromFahrenheitToFahrenheit(double value) {
        return value;
    }
}

package ru.academits.IvanVishnevsky.Models;

public class FahrenheitConverter {
    public static double fromCelsiusToFahrenheit(double value) {
        return (value * 1.8) + 32;
    }

    public static double toCelsius(double value) {
        return (value - 32) * 5 / 9;
    }

}

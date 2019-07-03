package ru.academits.IvanVishnevsky.Models;

public class KelvinConverter {
    public static double fromCelsiusToKelvin(double value) {
        return value + 273.15;
    }

    public static double toCelsius(double value) {
        return value - 273.15;
    }
}

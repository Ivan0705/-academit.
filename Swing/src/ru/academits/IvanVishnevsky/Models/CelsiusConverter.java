package ru.academits.IvanVishnevsky.Models;

public class CelsiusConverter {
    public static double convertFromCelsiusToCelsius(double value) {
        return value;
    }

    public static double convertFromCelsiusToKelvin(double value) {
        return value + 273.15;
    }

    public static double converterFromCelsiusToFahrenheit(double value) {
        return (value * 9 / 5) + 32;
    }

    public static double toCelsius(double value) {
        return value;
    }


    public static double fromCelsius(double value) {
        return value;
    }
}

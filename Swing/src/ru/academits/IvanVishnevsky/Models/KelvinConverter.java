package ru.academits.IvanVishnevsky.Models;

public class KelvinConverter {
    public KelvinConverter() {
    }

    public static double convertFromKelvinToCelsius(double value) {
        return value * 9 / 5 + 32;
    }

    public static double converterFromKelvinToKelvin(double value) {
        return value;
    }

    public static double converterFromKelvinToFahrenheit(double value) {
        return (value - 32) * 5 / 9 + 273.15;
    }
}

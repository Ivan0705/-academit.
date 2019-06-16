package ru.academits.IvanVishnevsky.Models;

public class KelvinConverter {
    public KelvinConverter() {
    }

    public static double convertFromKelvinToCelsius(double value) {
        return value + 273.15;
    }

    public static double converterFromKelvinToKelvin(double value) {
        return value;
    }

    public static double converterFromKelvinToFahrenheit(double value) {
        return (value - 32) * 5 / 9 + 273.15;
    }
}

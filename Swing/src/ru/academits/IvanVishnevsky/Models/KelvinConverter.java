package ru.academits.IvanVishnevsky.Models;

public class KelvinConverter {
    public static double convertFromKelvinToCelsius(double value) {
        return value - 273.15;
    }

    public static double converterFromKelvinToKelvin(double value) {
        return value;
    }

    public static double converterFromKelvinToFahrenheit(double value) {
        return (value * 1.8) - 469.67;
    }

    public static double toCelsius(double value) {
        return value - 273.15;
    }


    public static double fromCelsius(double value) {
        return value + 273.15;
    }
}

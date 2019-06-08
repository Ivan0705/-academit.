package ru.academits.IvanVishnevsky.Models;

public class FahrenheitConverter {
    private double value;

    public FahrenheitConverter(double value) {
        this.value = value;
    }

    private double convertFahrenheit() {
        return (value - 32) * 5 / 9;
    }

    @Override
    public String toString() {
        return String.format("%.4g%n", convertFahrenheit()) + " градусов по Фаренгейту!";
    }

}

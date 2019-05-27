package ru.academits.IvanVishnevsky.Temperature;



public class FahrenheitListener extends ActionTemperature {

    public FahrenheitListener(Temperature temperature) {
        super(temperature);
        putValue(NAME, "Fahrenheit");
    }

    @Override
    public double toKelvin(double value) {
        return 0;
    }

    @Override
    public double toFahrenheit(double value) {
        return (value - 32) * 5 / 9;
    }
}


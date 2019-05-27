package ru.academits.IvanVishnevsky.Temperature;


public class KelvinListener extends ActionTemperature {

    public KelvinListener(Temperature temperature) {
        super(temperature);
        putValue(NAME,"Kelvin");
    }

    @Override
    public double toKelvin(double value) {
        return value * 9 / 5 + 32;
    }

    @Override
    public double toFahrenheit(double value) {
        return 0;
    }
}

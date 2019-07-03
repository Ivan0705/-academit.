package ru.academits.IvanVishnevsky.Controller;

import ru.academits.IvanVishnevsky.Models.CelsiusConverter;
import ru.academits.IvanVishnevsky.Models.FahrenheitConverter;
import ru.academits.IvanVishnevsky.Models.KelvinConverter;

public class Controller {
    private java.lang.String fromOption;
    private java.lang.String toOption;
    private double value;

    public Controller(String fromOption, String toOption, double value) {
        this.fromOption = fromOption;
        this.toOption = toOption;
        this.value = value;
    }

    private double getConvertToCelsius() {
        double tmp1 = 0;
        switch (toOption) {
            case "Цельсий":
                tmp1 = CelsiusConverter.toCelsius(value);
                break;
            case "Кельвин":
                tmp1 = KelvinConverter.toCelsius(value);
                break;
            case "Фаренгейт":
                tmp1 = FahrenheitConverter.toCelsius(value);
                break;
        }
        return tmp1;
    }

    public double getConvertFromCelsius() {
        double tmp2 = getConvertToCelsius();
        double tmp3 = 0;
        switch (fromOption) {
            case "Цельсий":
                tmp3 = CelsiusConverter.fromCelsius(tmp2);
                break;
            case "Кельвин":
                tmp3 = KelvinConverter.fromCelsiusToKelvin(tmp2);
                break;
            case "Фаренгейт":
                tmp3 = FahrenheitConverter.fromCelsiusToFahrenheit(tmp2);
                break;
        }
        return tmp3;
    }
}

package ru.academits.IvanVishnevsky.Controller;

import ru.academits.IvanVishnevsky.Models.Converters;

public class Controller {
    public static double toConvert(double value, String fromTypeValue, String toTypeValue) {
        Converters converters = new Converters();
        double tmp = converters.getConverter(fromTypeValue).toCelsius(value);
        return converters.getConverter(toTypeValue).fromCelsius(tmp);
    }
}

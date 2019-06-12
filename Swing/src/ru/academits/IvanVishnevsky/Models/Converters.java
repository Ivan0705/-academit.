package ru.academits.IvanVishnevsky.Models;



import java.util.HashMap;

public class Converters {
    private static final HashMap<String, ConverterTemperature> CONVERTERS = new HashMap<>();

    public Converters() {
        CONVERTERS.put(CelsiusConverter.NAME, new CelsiusConverter());
        CONVERTERS.put(FahrenheitConverter.NAME, new FahrenheitConverter());
        CONVERTERS.put(KelvinConverter.NAME, new KelvinConverter());
    }

    public ConverterTemperature getConverter(String key) {
        return CONVERTERS.get(key);
    }
}

package ru.academit;

public class temp {
    private double temperature;

    public String convertTemp(double temperature, char convertTo) {
        if (convertTo == 'F' || convertTo == 'f') {
            this.temperature = (temperature * 9 / 5 + 32);
            return this.temperature + " градусов по Фаренгейту";
        } else if (convertTo == 'C' || convertTo == 'c') {
            this.temperature = ((temperature - 32) * 5 / 9);
            return this.temperature + " градусов по Цельсию";
        } else {
            return "Неверно выбран аргумент";
        }

    }
}

package ru.academits.IvanVishnevsky.Temperature;

public class Dog {
    private String name;
    private Collar collar;

    public void setName(String name) {
        this.name = name;
    }

    private class Collar {
    }

    @Override
    public String toString() {
        return name;
    }
}

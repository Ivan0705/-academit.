package ru.academit.IvanVishnevsky.Garage.Garage.Garage;

public class Motorcycle<T> implements Collection<T> {
    private int speed;
    private String name;
    private int weight;
    private boolean condition;

    public Motorcycle(String name, int speed, int weight, boolean condition) {
        this.name = name;
        this.speed = speed;
        this.weight = weight;
        this.condition = condition;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public boolean isCondition() {
        return condition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Motorcycle p = (Motorcycle) o;
        return name.equals(p.name) && speed == p.speed && weight == p.weight && condition == p.condition;
    }

    @Override
    public int hashCode() {
        int prime = 37;
        int hash = 1;
        hash = prime * hash + Boolean.hashCode(condition);
        hash = prime * hash + name.hashCode();
        hash = prime * hash + weight;
        hash = prime * hash + speed;
        return hash;
    }

    @Override
    public String toString() {
        return "Мотоцикл: " + name + ", скорость: " + speed + ", масса: " + weight + ", состояние:" + ((condition) ? " уд" : " неуд");
    }
}

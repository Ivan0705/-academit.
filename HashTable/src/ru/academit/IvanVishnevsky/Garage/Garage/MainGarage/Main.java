package ru.academit.IvanVishnevsky.Garage.Garage.MainGarage;

import ru.academit.IvanVishnevsky.Garage.Garage.Garage.Car;
import ru.academit.IvanVishnevsky.Garage.Garage.Garage.Collection;
import ru.academit.IvanVishnevsky.Garage.Garage.Garage.Motorcycle;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("BMW", 250, 35000, true);

        Motorcycle motorcycle1 = new Motorcycle("Honda", 150, 900, false);
        ArrayList<Collection> names = new ArrayList<>();
        names.add(car1);
        names.add(motorcycle1);
        System.out.println(names);

        Hashtable<Motorcycle, Car> motor = new Hashtable<>();
        motor.put(new Motorcycle("Honda", 120, 1200, true), new Car("BMW", 250, 35000, true));
        Iterator<Map.Entry<Motorcycle, Car>> it = motor.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Motorcycle, Car> m = it.next();
            System.out.println(m);
        }
    }
}

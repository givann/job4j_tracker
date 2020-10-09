package ru.job4j.oop;

public class Vehicle {
    public void move() {
    }

    public static void main(String[] args) {
        Vehicle vehicle = new Bus();
        Vehicle vehicle1 = new Plane();
        Vehicle vehicle2 = new Train();

        Vehicle[] vehicles = new Vehicle[]{vehicle, vehicle1, vehicle2};

        for (Vehicle vehicle3 : vehicles) {
            vehicle3.move();

        }
    }
}

package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void go() {
        System.out.println("go");
    }

    @Override
    public void passengers(int number) {
        System.out.println(number);
    }

    @Override
    public int amountForGas(int liters) {
        return liters * 30;
    }
}

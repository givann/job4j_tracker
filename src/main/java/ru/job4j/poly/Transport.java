package ru.job4j.poly;

public interface Transport {
    void go();
    void passengers(int number);
    int amountForGas(int liters);
}

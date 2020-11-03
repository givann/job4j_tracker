package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctReal {
    static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> l = new ArrayList<>();
        for (int i = start; i < end; i++) {
            l.add(func.apply((double) i));
        }
        return l;
    }
}

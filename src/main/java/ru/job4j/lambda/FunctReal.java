package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctReal {
    static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> l = new ArrayList<>();
        for (int i = start; i < end; i++) {
            l.add(func.apply((double) i));
        }
        return l;
    }


    public static <T, U> Function<T, U> ternaryOperator(Predicate<? super T> condition, Function<? super T,
            ? extends U> ifTrue, Function<? super T, ? extends U> ifFalse) {
        Function<T, U> nF = x -> condition.test(x) ? ifTrue.apply(x) : ifFalse.apply(x);
        return nF;
    }
}

package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MtxInteger {
    public static void main(String[] args) {
        Integer[][] var = {
                {0, 3},
                {1, 4}
        };
        Stream.of(var);
        List<Integer> list = Stream.of(var)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        System.out.println(list.toString());
    }
}

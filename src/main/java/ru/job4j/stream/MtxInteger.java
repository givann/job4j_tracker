package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MtxInteger {
    static List<Integer> arrDToLst(Integer[][] in) {
        List<Integer> list = Stream.of(in)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        return list;
    }
}

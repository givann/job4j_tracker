package ru.job4j.search;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MoreThenZero {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, -2, 29, -12, 1211, -231132);
        List<Integer> list1 = list.stream()
                .filter(s -> s > 0)
                .collect(Collectors.toList());
    }
}

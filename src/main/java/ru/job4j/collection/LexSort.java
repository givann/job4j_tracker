package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] arl = left.split("\\D");
        String[] arr = right.split("\\D");
        return Integer.valueOf(arl[0]).compareTo(Integer.valueOf(arr[0]));
    }
}

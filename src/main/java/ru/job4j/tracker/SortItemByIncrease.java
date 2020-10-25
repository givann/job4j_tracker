package ru.job4j.tracker;

import java.util.Comparator;

public class SortItemByIncrease implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        return (Integer.valueOf(o1.getId()).compareTo(Integer.valueOf(o2.getId())));
    }
}

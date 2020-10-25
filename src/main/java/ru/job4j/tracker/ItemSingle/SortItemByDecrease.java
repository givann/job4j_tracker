package ru.job4j.tracker.ItemSingle;

import ru.job4j.tracker.Item;

import java.util.Comparator;

public class SortItemByDecrease implements Comparator<Item> {

    @Override
    public int compare(Item o1, Item o2) {
        return Integer.valueOf(o2.getId()).compareTo(Integer.valueOf(o1.getId()));
    }
}

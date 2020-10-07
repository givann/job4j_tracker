package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Item item = new Item(1, "New");
        Item item1 = new Item(2, "New");
        Item item2 = new Item(3, "New");
        Item item3 = new Item(4, "New");
        tracker.add(item);
//        System.out.println(tracker.findByName("New"));
        System.out.println(Arrays.toString(tracker.findAll()));

    }
}

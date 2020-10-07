package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Item item = new Item("one");
        Item item1 = new Item(null);
        Item item2 = new Item("two");
        Item item3 = new Item("one");
        tracker.add(item);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        System.out.println(Arrays.toString(tracker.findByName("one")));
    }
}

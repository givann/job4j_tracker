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
        Item item4 = new Item("eleven");
        tracker.add(item);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
//        tracker.add(item4);
//        System.out.println(Arrays.toString(tracker.findByName("one")));
//        System.out.println(tracker.findById(1));
//        System.out.println(tracker.replace(1, new Item("three")));
        System.out.println(Arrays.toString(tracker.findAll()));

//        String[] names = {"Petr", null, "Ivan", "Stepan", "Fedor"};
//        System.arraycopy(names, 4, names, 1, 1);
//        System.out.println(Arrays.toString(names));

        tracker.delete(1);
        System.out.println(Arrays.toString(tracker.findAll()));




    }
}

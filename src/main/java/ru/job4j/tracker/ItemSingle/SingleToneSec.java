package ru.job4j.tracker.ItemSingle;

import ru.job4j.tracker.Item;

public class SingleToneSec {
    private static SingleToneSec instance;

    private SingleToneSec() {
    }

    public static SingleToneSec getInstance() {
        if (instance == null) {
            instance = new SingleToneSec();
        }
        return instance;
    }

    public Item add(Item model) {
        return model;
    }

}

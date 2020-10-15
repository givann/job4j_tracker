package ru.job4j.tracker.ItemSingle;

import ru.job4j.tracker.Item;

public enum SingleTonEnum {
    INSTANCE;

    public Item add(Item model) {
        return model;
    }
}

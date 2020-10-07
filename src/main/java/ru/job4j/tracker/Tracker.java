package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        Item[] withoutNull = new Item[this.items.length];
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null) {
                withoutNull[size] = this.items[i];
                size++;
            }
        }
        return Arrays.copyOf(withoutNull, size);
    }

    public Item[] findByName(String key) {
        Item[] keys = new Item[this.items.length];
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i].getName().equals(key)) {
                keys[size] = items[i];
                size++;
            }
        }
        return Arrays.copyOf(keys, size);
    }
}
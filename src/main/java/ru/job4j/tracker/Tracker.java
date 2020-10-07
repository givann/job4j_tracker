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
        Item[] withoutNull = new Item[size];
        size = 0;
        for (int i = 0; i < withoutNull.length; i++) {
            if (this.items[i].getName() != null) {
                withoutNull[size] = this.items[i];
                size++;
            }
        }
        return Arrays.copyOf(withoutNull, size);
    }

    public Item[] findByName(String key) {
        Item[] keys = new Item[ids-1];
        size = 0;
        for (int i = 0; i < keys.length ; i++) {
            if (items[i].getName()!=null){
                if (items[i].getName().equals(key)){
                    keys[size] =items[i];
                    size++;
                }
            }
        }
        return Arrays.copyOf(keys,size);
    }
}
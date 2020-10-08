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
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }


    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] keys = new Item[size];
        int newSize = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].getName() != null) {
                if (items[i].getName().equals(key)) {
                    keys[newSize] = items[i];
                    newSize++;
                }
            }
        }
        return Arrays.copyOf(keys, newSize);
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int ind = indexOf(id);
        items[ind].setName(item.getName());
        return items[ind].getName().equals(item.getName());
    }

//    public boolean delete(int id) {
//        Item[] afterDelete = new Item[size-1];
//        int index = indexOf(id);
//        System.arraycopy(items, index+1, afterDelete, index, size-1);
//    }


}
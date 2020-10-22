package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    int ids = 1;


    public Item add(Item item) {
        items.add(item);
        item.setId(ids++);
        return item;
    }

    public int indexOf(int id) {
        int rsl = 0;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        return items.get(indexOf(id));
    }


    public List<Item> findAll() {
        return items;
    }


    public List<Item> findByName(String key) {
        ArrayList<Item> arrayList = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().contains(key)) {
                arrayList.add(item);
            }
        }
        return arrayList;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        items.set(index, item);
        int ind = item.getId();
        return ind != -1;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        items.remove(index);
        return id > 0;
    }


}
package ru.job4j.tracker.ItemSingle;

import ru.job4j.tracker.Item;

public class SingleFour {
    private SingleFour() {
    }

    public static SingleFour getInstance() {
        return Holder.SINGLE_FOUR;
    }

    private static final class Holder {
        private static final SingleFour SINGLE_FOUR = new SingleFour();
    }

    public Item add(Item model) {
        return model;
    }
}

package ru.job4j.tracker.ItemSingle;

import ru.job4j.tracker.Item;

public class SinglThree {
    private static final SinglThree SINGL_THREE = new SinglThree();

    private SinglThree() {
    }

    public static SinglThree getInstance() {
        return SINGL_THREE;
    }

    public Item add(Item model) {
        return model;
    }
}

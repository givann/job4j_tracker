package ru.job4j.tracker;

public class SingleFour {
    private Tracker tracker;

    private SingleFour() {
        tracker = new Tracker();
    }

    public Tracker getTracker() {
        return tracker;
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

package ru.job4j.tracker;

public class SingleToneSec {
    private static SingleToneSec instance;
    private Tracker tracker = new Tracker();

    private SingleToneSec() {
    }

    public Tracker getTracker() {
        return tracker;
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

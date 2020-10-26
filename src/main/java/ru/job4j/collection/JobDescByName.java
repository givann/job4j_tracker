package ru.job4j.collection;

import java.util.Comparator;

public class JobDescByName implements Comparator<Job> {
    @Override
    public int compare(Job o1, Job o2) {
        return Integer.valueOf(o2.getName().length()).compareTo(Integer.valueOf(o1.getName().length()));
    }
}

package ru.job4j.collection;

import java.util.Comparator;

public class JobIncrByPrior implements Comparator<Job> {
    @Override
    public int compare(Job o1, Job o2) {
        return Integer.valueOf(o1.getPriority()).compareTo(Integer.valueOf(o2.getPriority()));
    }
}

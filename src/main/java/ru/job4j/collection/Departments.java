package ru.job4j.collection;

import java.awt.geom.Area;
import java.util.*;

public class Departments {
    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String[] arr = value.split("/");
            String ss = arr[0];
            tmp.add(ss);
            for (int i = 1; i < arr.length; i++) {
                ss += "/" + arr[i];
                tmp.add(ss);
            }
        }
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs, Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> orgs) {
        Collections.sort(orgs, new DepDescComp());
    }

    public static void main(String[] args) {
        Set<String> strings = new TreeSet<>();

        strings.add("er");
        strings.add("era");
        strings.add("erat");
        strings.add("erata");

    }

}

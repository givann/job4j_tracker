package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        for (int i = 0; i < o1.length() && i < o2.length(); i++) {
            if (o1.charAt(i) == o2.charAt(i)) {
                continue;
            } else {
                return o1.charAt(i) - o2.charAt(i);
            }
        }
        if (o1.length() != o2.length()) {
            return o1.length() - o2.length();
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        String on = "";
        String tw = "";
        StringCompare stringCompare = new StringCompare();

        System.out.println(stringCompare.compare(on, tw));

    }
}

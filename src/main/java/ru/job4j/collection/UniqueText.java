package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        int count = 0;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String s : origin) {
            check.add(s);
        }
        for (String s : text) {
            if (check.contains(s)) {
                count++;
            }

        }
        return count == check.size();
    }


    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("My cat eats a mouse and milk");
        String one = ("My cat eats a mouse and milk");
        String two = ("My eats cat  a mouse and milk");
        System.out.println(isEquals(one, two));
    }
}


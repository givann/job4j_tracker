package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        map.put("ivanov@mail.ru", "Ivanov Ivan");
        map.put("petrov@mail.ru", "Petrov Oleg");
        map.put("sidorov@mail.ru", "Sidorov Sergey");

        for (String s : map.keySet()) {
            System.out.println(map.get(s));
        }
    }
}

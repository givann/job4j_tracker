package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (String s : value) {
            if (s != key) {
                throw new ElementNotFoundException();
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] strings = new String[0];
        try {
            indexOf(strings,"rt");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}

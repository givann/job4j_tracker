package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book = new Book("Clean code", 302);
        Book book1 = new Book("Harry Potter", 1200);
        Book book2 = new Book("Onegin", 432);
        Book book3 = new Book("Ognivo", 75);
        Book[] arr = new Book[4];
        arr[0] = book;
        arr[1] = book1;
        arr[2] = book2;
        arr[3] = book3;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].getName() + " " + arr[i].getQuantityOfPages());
        }
        System.out.println();
        Book[] tmp = new Book[1];
        tmp[0] = arr[0];
        arr[0] = arr[3];
        arr[3] = tmp[0];
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].getName() + " " + arr[i].getQuantityOfPages());
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getName().equals("Clean code")) {
                System.out.println(arr[i].getName() + " " + arr[i].getQuantityOfPages());
            }
        }


    }
}

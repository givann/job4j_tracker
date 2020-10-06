package ru.job4j.pojo;

public class Book {
    private String name;
    private int quantityOfPages;

    public Book(String name, int quantityOfPages) {
        this.name = name;
        this.quantityOfPages = quantityOfPages;
    }

    public String getName() {
        return name;
    }

    public int getQuantityOfPages() {
        return quantityOfPages;
    }
}

package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student numOne = new Student();
        numOne.setName("Ivan");
        numOne.setGroup("614");
        numOne.setDate("01.09.20");
        System.out.println(numOne.getName());
        System.out.println(numOne.getGroup());
        System.out.println(numOne.getDate());
    }
}

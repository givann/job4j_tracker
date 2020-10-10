package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        int spic = 11;
        System.out.println("11 Спичек");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name: ");
        String nameOne = scanner.nextLine();
        System.out.println("Enter name: ");
        String nameTwo = scanner.nextLine();
        int count = 0;
        while (spic != 0) {
            System.out.println("Введите количество от 1 до 3:");
            int num = scanner.nextInt();
            if (num == 1 || num == 2 || num == 3) {
                spic -= num;
                count++;
            } else {
                System.out.println("Введите правильное число");
            }
            if (count % 2 != 0) {
                if (spic > 0) {
                    System.out.println("Осталось спичек: " + spic);
                } else {
                    System.out.println("Вы выйграли " + nameOne);
                }

            } else{
                if (spic > 0) {
                    System.out.println("Осталось спичек: " + spic);
                } else {
                    System.out.println("Вы выйграли " + nameTwo);
                }

            }


        }
    }
}

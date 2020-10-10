package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        int spic = 11;
        System.out.println("11 Спичек");
        Scanner scanner = new Scanner(System.in);
        while (spic != 0) {
            System.out.println("Введите количество от 1 до 3:");
            int num = scanner.nextInt();
            if (num == 1 || num == 2 || num == 3) {
                spic -= num;
            } else {
                System.out.println("Введите правильное число");
            }
            if (spic > 0) {
                System.out.println("Осталось спичек: " + spic);
            } else {
                System.out.println("Вы выйграли");
            }

        }
    }
}

package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        Scanner scanner = new Scanner(System.in);
        String quest = scanner.nextLine();
        System.out.println();
        int answer = new Random().nextInt(3);
        if (answer == 0) {
            System.out.println("да");
        } else if (answer == 1) {
            System.out.println("нет");
        } else {
            System.out.println("Может быть");
        }
    }
}

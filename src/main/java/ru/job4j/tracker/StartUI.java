package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;


public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println(Arrays.toString(tracker.findAll()));
            } else if (select == 2) {
                System.out.println("Enter id:");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter item:");
                if (tracker.replace(id, new Item(scanner.nextLine()))) {
                    System.out.println("Succesful");
                } else System.out.println("Unseccesful");
            } else if (select == 3) {
                System.out.println("Enter id");
                int id = scanner.nextInt();
                scanner.nextLine();
                if (tracker.delete(id)){
                    System.out.println("Succesful");
                } else System.out.println("Unseccesful");
            } else if (select == 4) {
                System.out.println("Enter id:");
                int id = scanner.nextInt();
                scanner.nextLine();
                Item item = tracker.findById(id);
                if (item.getId() != -1) {
                    System.out.println(item.getName());
                } else {
                    System.out.println("Not exist");
                }
            } else if (select == 5) {
                System.out.println("Enter name: ");
                String newName = scanner.next();
                scanner.nextLine();
                if (tracker.findByName(newName).length == 0) {
                    System.out.println("Not exist");
                } else
                    System.out.println(Arrays.toString(tracker.findByName(newName)));

            } else if (select == 6) {
                run = false;
            }
        }

    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item\n" +
                "1. Show all items\n" +
                "2. Edit item\n" +
                "3. Delete item\n" +
                "4. Find item by Id\n" +
                "5. Find items by name\n" +
                "6. Exit Program\n");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}

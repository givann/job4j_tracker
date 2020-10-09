package ru.job4j.tracker;

import java.util.Arrays;



public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(input.askInt("Select: "));
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println(Arrays.toString(tracker.findAll()));
            } else if (select == 2) {
                int id = input.askInt("Enter id:");
                if (tracker.replace(id, new Item(input.askStr("Enter item:")))) {
                    System.out.println("Succesful");
                } else System.out.println("Unseccesful");
            } else if (select == 3) {
                int id = input.askInt("Enter id");
                if (tracker.delete(id)){
                    System.out.println("Succesful");
                } else System.out.println("Unseccesful");
            } else if (select == 4) {
                int id = input.askInt("Enter id:");
                Item item = tracker.findById(id);
                if (item.getId() != -1) {
                    System.out.println(item.getName());
                } else {
                    System.out.println("Not exist");
                }
            } else if (select == 5) {
                String newName = input.askStr("Enter name: ");
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
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}

package ru.job4j.tracker;

import java.sql.SQLOutput;
import java.util.Arrays;

import static java.lang.Integer.valueOf;


public class StartUI {
    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu:");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].name());
        }
    }


    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void showAllItem(Tracker tracker) {
        for (Item item : tracker.findAll()) {
            System.out.println(item.getId() + " " + item.getName());
        }
    }

    public static void editItem(Input input, Tracker tracker) {
        String id = input.askStr("Enter id:");
        if (tracker.replace(valueOf(id), new Item(input.askStr("Enter item:")))) {
            System.out.println("Succesful");
        } else System.out.println("Unseccesful");
    }

    public static void deleteItem(Input input, Tracker tracker) {
        int id = input.askInt("Enter id");
        if (tracker.delete(id)) {
            System.out.println("Succesful");
        } else System.out.println("Unseccesful");
    }

    public static void findById(Input input, Tracker tracker) {
        int id = input.askInt("Enter id:");
        Item item = tracker.findById(id);
        if (item.getId() != -1) {
            System.out.println(item.getName());
        } else {
            System.out.println("Not exist");
        }
    }

    public static void findByName(Input input, Tracker tracker) {
        String newName = input.askStr("Enter name: ");
        if (tracker.findByName(newName).length == 0) {
            System.out.println("Not exist");
        } else
            for (Item item : tracker.findByName(newName)) {
                System.out.println(item.getName() + " " + item.getId());

            }
        ;

    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = new UserAction[]{new CreateAction(), new ShowAllAction(),
                new EditItemAction(), new DeleteAction(), new FindByIdAction(), new FindByNameAction(), new ExitAction()};


        new StartUI().init(input, tracker, actions);

    }
}

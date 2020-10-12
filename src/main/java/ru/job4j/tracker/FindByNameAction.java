package ru.job4j.tracker;

import java.util.Arrays;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "Find by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String newName = input.askStr("Enter name: ");
        if (tracker.findByName(newName).length == 0) {
            System.out.println("Not exist");
        } else
            System.out.println(Arrays.toString(tracker.findByName(newName)));

        return true;
    }
}

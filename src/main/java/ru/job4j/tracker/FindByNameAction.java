package ru.job4j.tracker;

import java.util.Arrays;

public class FindByNameAction implements UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String newName = input.askStr("Enter name: ");
        if (tracker.findByName(newName).size() == 0) {
            this.out.println("Not exist");
        } else
            for (Item item : tracker.findByName(newName)) {
                this.out.println("id=" + item.getId() + " Name=" + item.getName());
            }
        return true;
    }
}

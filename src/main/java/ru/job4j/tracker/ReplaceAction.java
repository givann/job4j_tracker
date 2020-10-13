package ru.job4j.tracker;

import static java.lang.Integer.valueOf;

public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }
    @Override
    public String name() {
        return "Replace item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter id: ");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        if (tracker.replace(valueOf(id), item)) {
            System.out.println("Succesful");
        } else System.out.println("Unseccesful");
        return true;
    }
}

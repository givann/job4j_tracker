package ru.job4j.tracker;

public class FindByIdAction  implements UserAction{
    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find by Id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id:");
        Item item = tracker.findById(id);
        if (item.getId() != -1) {
            System.out.println(item.getName());
        } else {
            System.out.println("Not exist");
        }
        return true;
    }
}

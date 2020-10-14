package ru.job4j.tracker;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"tre", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(0));
    }

    @Test
    public void whenOut() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "1", "1"}
        );
        UserAction[] actions = {
                new FindByIdAction(out),
                new Exit()
        };
        Tracker tracker = new Tracker();
        tracker.add(new Item("One"));
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        new StartUI(out).init(input, tracker, actions);
        assertThat(out.toString(), Is.is(
                "Menu." + System.lineSeparator() +
                        "0. Find by Id" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator()
        ));
    }
}

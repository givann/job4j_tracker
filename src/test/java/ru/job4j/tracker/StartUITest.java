package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new Exit());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenShowAllAction() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ShowAllAction(out));
        actions.add(new Exit());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Show all items" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. Show all items" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator()
        ));
    }


    @Test
    public void whenFindByNameAction() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "One", "1"}
        );
        Tracker tracker = new Tracker();
        Item item = new Item("One");
        tracker.add(item);
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByNameAction(out));
        actions.add(new Exit());

        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Find by name" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        "id=" + item.getId() + " Name=" + item.getName() + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. Find by name" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByIdAction() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "1", "1"}
        );
        Tracker tracker = new Tracker();
        Item item = new Item("One");
        tracker.add(item);
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByIdAction(out));
        actions.add(new Exit());
        new StartUI(out).init(in, tracker, actions);

        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Find by Id" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        item.getName() + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. Find by Id" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator()
        ));
    }


    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"3", "0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new Exit());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. Exit%n"
                                + "Wrong input, you can select: 0 .. 0%n"
                                + "Menu.%n"
                                + "0. Exit%n"
                )
        ));
    }
}

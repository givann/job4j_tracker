package ru.job4j.tracker;

import org.junit.Test;

import static java.lang.String.valueOf;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class StartUITest {


    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Replaced item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(),
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat((tracker.findById(item.getId()).getName()), is(replacedName));


//    @Test
//    public void whenExit() {
//        Output out = new StubOutput();
//        Input in = new StubInput(
//                new String[]{"0"}
//        );
//        Tracker tracker = new Tracker();
//        UserAction[] actions = {
//                new Exit()
//        };
//        new StartUI(out).init(in, tracker, actions);
//        assertThat(out.toString(), is(
//                "Menu." + System.lineSeparator() +
//                        "0. Exit" + System.lineSeparator()
//        ));
//    }
//
//    @Test
//    public void whenShowAllAction() {
//        Output out = new StubOutput();
//        Input in = new StubInput(
//                new String[]{"0", "1"}
//        );
//        Tracker tracker = new Tracker();
//        UserAction[] actions = {
//                new ShowAllAction(),
//                new Exit()
//        };
//        new StartUI(out).init(in, tracker, actions);
//        assertThat(out.toString(), is(
//                "Menu." + System.lineSeparator() +
//                        "0. Show all items" + System.lineSeparator() +
//                        "1. Exit" + System.lineSeparator() +
//                        "Menu." + System.lineSeparator() +
//                        "0. Show all items" + System.lineSeparator() +
//                        "1. Exit" + System.lineSeparator()
//        ));
//    }
//
//
//    @Test
//    public void whenFindByNameAction() {
//        Output out = new StubOutput();
//        Input in = new StubInput(
//                new String[]{"0", "One", "1"}
//        );
//        Tracker tracker = new Tracker();
//        Item item = new Item("One");
//        tracker.add(item);
//        UserAction[] actions = {
//                new FindByNameAction(),
//                new Exit()
//        };
//        new StartUI(out).init(in, tracker, actions);
//        assertThat(out.toString(), is(
//                "Menu." + System.lineSeparator() +
//                        "0. Find by name" + System.lineSeparator() +
//                        "1. Exit" + System.lineSeparator() +
//                        "Menu." + System.lineSeparator() +
//                        "0. Find by name" + System.lineSeparator() +
//                        "1. Exit" + System.lineSeparator()
//        ));
//    }
//
//    @Test
//    public void whenFindByIdAction() {
//        Output out = new StubOutput();
//        Input in = new StubInput(
//                new String[]{"0", "1", "1"}
//        );
//        Tracker tracker = new Tracker();
//        Item item = new Item("One");
//        tracker.add(item);
//        UserAction[] actions = {
//                new FindByIdAction(),
//                new Exit()
//        };
//        new StartUI(out).init(in, tracker, actions);
//        assertThat(out.toString(), is(
//                "Menu." + System.lineSeparator() +
//                        "0. Find by Id" + System.lineSeparator() +
//                        "1. Exit" + System.lineSeparator() +
//                        "Menu." + System.lineSeparator() +
//                        "0. Find by Id" + System.lineSeparator() +
//                        "1. Exit" + System.lineSeparator()
//        ));
//    }
    }
}

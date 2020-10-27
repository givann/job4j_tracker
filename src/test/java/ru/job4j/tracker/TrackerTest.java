package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is(bugWithDesc.getName()));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findAll().isEmpty(), is(tracker.findAll().size() == 0));
    }

    @Test
    public void whenSortIncr() {
        Tracker tracker = new Tracker();
        Item item = new Item("One");
        Item item1 = new Item("Three");
        Item item2 = new Item("Two");
        tracker.add(item);
        tracker.add(item1);
        tracker.add(item2);
        Collections.sort(tracker.findAll(), new SortItemByIncrease());
        List<Integer> llst = new ArrayList<>();
        for (Item item3 : tracker.findAll()) {
            llst.add(item3.getId());
        }
        assertThat(llst, is(Arrays.asList(1, 2, 3)));

    }

    @Test
    public void whenSortDcr() {
        Tracker tracker = new Tracker();
        Item item = new Item("One");
        Item item1 = new Item("Three");
        Item item2 = new Item("Two");
        tracker.add(item);
        tracker.add(item1);
        tracker.add(item2);
        Collections.sort(tracker.findAll(), new SortItemByDecrease());
        List<Integer> llst = new ArrayList<>();
        for (Item item3 : tracker.findAll()) {
            llst.add(item3.getId());
        }
        assertThat(llst, is(Arrays.asList(3, 2, 1)));

    }
}
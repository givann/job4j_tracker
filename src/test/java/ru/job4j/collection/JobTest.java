package ru.job4j.collection;

import org.junit.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {

    @Test
    public void whenCompatorByName() {
        List<Job> al = new ArrayList<>();
        Job job = new Job("One", 0);
        Job job1 = new Job("Three", 0);
        al.add(job);
        al.add(job1);
        Collections.sort(al, new JobDescByName());
        Job jRes = al.get(0);
        assertThat(jRes.getName(), is("Three"));
    }

    @Test
    public void whenCompatorByNameIncr() {
        List<Job> al = new ArrayList<>();
        Job job = new Job("One", 0);
        Job job1 = new Job("Three", 0);
        al.add(job);
        al.add(job1);
        Collections.sort(al, new JobIncrByNameLn());
        Job jRes = al.get(0);
        assertThat(jRes.getName(), is("One"));
    }

    @Test
    public void whenCompatorByPrIncr() {
        List<Job> al = new ArrayList<>();
        Job job = new Job("One", 2);
        Job job1 = new Job("Three", 1);
        al.add(job);
        al.add(job1);
        Collections.sort(al, new JobIncrByPrior());
        Job jRes = al.get(0);
        assertThat(jRes.getPriority(), is(1));
    }

    @Test
    public void whenCompatorByPrDesc() {
        List<Job> al = new ArrayList<>();
        Job job = new Job("One", 2);
        Job job1 = new Job("Three", 1);
        al.add(job);
        al.add(job1);
        Collections.sort(al, new JobDescByPriority());
        Job jRes = al.get(0);
        assertThat(jRes.getPriority(), is(2));
    }

    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorIncByNameAndIncByPrority() {
        Comparator<Job> cmpNamePriority = new JobIncrByNameLn().thenComparing(new JobIncrByPrior());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 2),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(2));
    }

    @Test
    public void whenCompatorIncByNameAndDescByPrority() {
        Comparator<Job> cmpNamePriority = new JobIncrByNameLn().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 2),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(2));
    }
}

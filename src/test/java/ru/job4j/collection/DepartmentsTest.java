package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DepartmentsTest {
    @Test
    public void whenMissed() {
        List<String> input = List.of("k1/sk1");
        List<String> expect = List.of("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenNonChange() {
        List<String> input = List.of("k1", "k1/sk1");
        List<String> expect = List.of("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void fillGaps() {
        List<String> input = List.of("k1/sk1/ssk2");
        List<String> expect = List.of("k1", "k1/sk1", "k1/sk1/ssk2");
        List<String> rsl = Departments.fillGaps(input);
        assertThat(rsl, is(expect));

    }

    @Test
    public void sortAsc() {
        ArrayList<String> input = new ArrayList<>();
        input.add("K1/SK1/SSK1");
        input.add("K1/SK1");
        input.add("K1/SK1/SSK2");
        Departments.sortAsc(input);
        ArrayList<String> expect = new ArrayList<>();
        expect.add("K1/SK1");
        expect.add("K1/SK1/SSK1");
        expect.add("K1/SK1/SSK2");
        assertThat(input, is(expect));
    }

    @Test
    public void sortDesc() {
        ArrayList<String> input = new ArrayList<>();
        input.add("K1/SK1/SSK1");
        input.add("K2");
        input.add("K1/SK1/SSK2");
        Departments.sortDesc(input);
        ArrayList<String> expect = new ArrayList<>();
        expect.add("K2");
        expect.add("K1/SK1/SSK1");
        expect.add("K1/SK1/SSK2");
        assertThat(input, is(expect));
    }
}
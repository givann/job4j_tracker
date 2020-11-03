package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FunctRealTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = FunctReal.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQFunctionThenQResults() {
        List<Double> result = FunctReal.diapason(5, 8, x -> x * x + 1);
        List<Double> expected = Arrays.asList(26D, 37D, 50D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenPFunctionThenPResults() {
        List<Double> result = FunctReal.diapason(5, 8, x -> Math.pow(x, x) + 1);
        List<Double> expected = Arrays.asList(3126D, 46657D, 823544D);
        assertThat(result, is(expected));
    }

}
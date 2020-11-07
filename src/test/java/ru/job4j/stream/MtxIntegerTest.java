package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static ru.job4j.stream.MtxInteger.arrDToLst;

public class MtxIntegerTest {

    @Test
    public void arrDToLstChk() {
        Integer[][] nArr = {
                {0, 1},
                {3, 4}
        };
        List<Integer> actual = arrDToLst(nArr);
        List<Integer> exp = Arrays.asList(0, 1, 3, 4);
        assertThat(actual, is(exp));


    }
}
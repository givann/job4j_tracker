package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.SinglThree;
import ru.job4j.tracker.SingleFour;
import ru.job4j.tracker.SingleTonEnum;
import ru.job4j.tracker.SingleToneSec;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SingletoneTest {

    @Test
    public void whenEn() {
        SingleTonEnum singleTonEnum = SingleTonEnum.INSTANCE;
        SingleTonEnum singleTonEnum1 = SingleTonEnum.INSTANCE;
        assertThat(singleTonEnum.hashCode(), is(singleTonEnum1.hashCode()));
    }

    @Test
    public void whenST2() {
        SingleToneSec singleToneSec = SingleToneSec.getInstance();
        SingleToneSec singleToneSec1 = SingleToneSec.getInstance();
        assertThat(singleToneSec.hashCode(), is(singleToneSec1.hashCode()));
    }

    @Test
    public void whenST3() {
        SinglThree singlThree = SinglThree.getInstance();
        SinglThree singlThree1 = SinglThree.getInstance();
        assertThat(singlThree.hashCode(), is(singlThree1.hashCode()));
    }

    @Test
    public void whenST4() {
        SingleFour singleFour = SingleFour.getInstance();
        SingleFour singleFour1 = SingleFour.getInstance();
        assertThat(singleFour.hashCode(), is(singleFour1.hashCode()));
    }
}
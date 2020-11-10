package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void collectAdr() {
        List<Profile> list = new ArrayList<>();
        list.add(new Profile(new Address("Msk", "hhh", 4, 1)));
        list.add(new Profile(new Address("Spb", "yyy", 1, 7)));
        List<Address> actual = Profiles.collect(list);
        List<Address> exp = Arrays.asList(new Address("Msk", "hhh", 4, 1),
                new Address("Spb", "yyy", 1, 7));
        assertThat(actual, is(exp));
    }
}
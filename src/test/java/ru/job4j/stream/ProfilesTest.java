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

    @Test
    public void collectUniqAdr() {
        List<Profile> list = new ArrayList<>();
        Profile profile = new Profile(new Address("Msk", "hhh", 4, 1));
        Profile profile1 = new Profile(new Address("Msk", "hhh", 4, 1));
        Profile profile2 = new Profile(new Address("Msk", "hhh", 4, 1));
        Profile profile3 = new Profile(new Address("Spb", "yyy", 1, 7));
        list.add(profile);
        list.add(profile1);
        list.add(profile2);
        list.add(profile3);
        List<Address> act = Profiles.collect(list);
        List<Address> exp = List.of(new Address("Msk", "hhh", 4, 1),
                new Address("Spb", "yyy", 1, 7));
        assertThat(act, is(exp));


    }
}
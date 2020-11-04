package ru.job4j.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> name = x -> x.getName().contains(key);
        Predicate<Person> adr = x -> x.getAddress().contains(key);
        Predicate<Person> phn = x -> x.getPhone().contains(key);
        Predicate<Person> sNam = x -> x.getSurname().contains(key);
        Predicate<Person> combine = name.or(adr).or(phn).or(sNam);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}


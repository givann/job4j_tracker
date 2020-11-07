package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        List<Address> addressList = profiles.stream()
                .map(Profile::getAddress)
                .sorted()
                .distinct()
                .collect(Collectors.toList());
        return addressList;
    }
}
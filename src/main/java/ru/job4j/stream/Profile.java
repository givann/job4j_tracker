package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Profile {
    private Address address;

    public Address getAddress() {
        return address;
    }
}

class Address {
    private String city;
    private String street;
    private int home;
    private int apartment;
}

class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        List<Address> addressList = profiles.stream()
                .map(Profile::getAddress)
                .collect(Collectors.toList());
        return addressList;
    }
}

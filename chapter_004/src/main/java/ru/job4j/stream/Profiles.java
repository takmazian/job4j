package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    static List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(Profile::getAddress).distinct().sorted().collect(Collectors.toList());
    }
}

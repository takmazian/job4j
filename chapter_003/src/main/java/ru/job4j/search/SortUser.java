package ru.job4j.search;

import java.util.*;

public class SortUser {
    public Set<User> sort(List<User> list) {
        SortedSet<User> result = new TreeSet<>(list);
        return result;
    }
}

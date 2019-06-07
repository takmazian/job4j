package ru.job4j.search;

import java.util.*;

public class SortUser {
    public Set<User> sort(List<User> list) {
        SortedSet<User> result = new TreeSet<>(list);
        return result;
    }

    public List<User> sortNameLength(List<User> list) {
        Comparator<User> comparatorUser = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.compareTo(o2);
            }
        };
        list.sort(comparatorUser);
        return list;
    }

    public List<User> sortByAllFields(List<User> list) {
        Comparator<User> comparatorUser = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int result = o1.compareTo(o2);
                return result == 0 ? Integer.compare(o1.getAge(), o2.getAge()) : result;
            }
        };
        list.sort(comparatorUser);
        return list;
    }

}


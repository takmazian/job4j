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
                return Integer.compare(o1.getName().length(), o2.getName().length());
            }
        };
        list.sort(comparatorUser);
        return list;
    }

    public List<User> sortByAllFields(List<User> list) {
        Comparator<User> comparatorUser = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int result = 0;
                int minLength = o1.getName().length() > o2.getName().length() ? o2.getName().length() : o1.getName().length();
                int i;
                for (i = 0; i < minLength; i++) {
                    int leftSymb = o1.getName().charAt(i);
                    int rightSymb = o2.getName().charAt(i);
                    if (leftSymb != rightSymb) {
                        result = Integer.compare(leftSymb, rightSymb);
                        break;
                    }
                }
                if (result == 0 && o1.getName().length() != o2.getName().length()) {
                    result = o1.compareTo(o2);
                }
                return result;
            }
        };
        list.sort(comparatorUser);
        return list;
    }


}


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
                int maxLength = o1.getName().length() > o2.getName().length() ? o1.getName().length() : o2.getName().length();
                for(int i = 0; i < maxLength; i++){
                    int char1 = 'Z' + 1;
                    int char2 = 'Z' + 1;
                    try {
                        char1 = o1.getName().charAt(i);
                    }catch (Exception e){}
                    try {
                        char2 = o2.getName().charAt(i);
                    }catch (Exception e){}
                    if(char1 != char2){
                        result = Integer.compare(char1,char2);
                        break;
                    }
                }
                return result == 0 ? Integer.compare(o1.getAge(), o2.getAge()) : result;
            }
        };
        list.sort(comparatorUser);
        return list;
    }

}


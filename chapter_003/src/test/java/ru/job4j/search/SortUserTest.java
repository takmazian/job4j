package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;
import java.util.TreeSet;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void whenAddThreeElemenGetSortedSetWithThree() {
        SortUser sortUser = new SortUser();
        ArrayList<User> users = new ArrayList<>();
        User user = new User("Vasya", 15);
        users.add(user);
        user = new User("Petya", 16);
        users.add(user);
        user = new User("Kolya", 18);
        users.add(user);
        TreeSet<User> userTreeSet = new TreeSet<>(users);
        userTreeSet.add(user);
        assertEquals(sortUser.sort(users), userTreeSet);
    }
}

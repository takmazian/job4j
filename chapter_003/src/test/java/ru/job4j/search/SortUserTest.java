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

    @Test
    public void testSortByLength() {
        SortUser sortUser = new SortUser();
        ArrayList<User> users = new ArrayList<>();
        ArrayList<User> checkList = new ArrayList<>();
        User user1 = new User("Vasya", 15);
        User user2 = new User("Petyan", 16);
        User user3 = new User("Kolyan", 18);
        users.add(user2);
        users.add(user1);
        users.add(user3);
        checkList.add(user1);
        checkList.add(user2);
        checkList.add(user3);
        sortUser.sortNameLength(users);
        assertEquals(users, checkList);
    }

    @Test
    public void testSortByAll() {
        SortUser sortUser = new SortUser();
        ArrayList<User> users = new ArrayList<>();
        ArrayList<User> checkList = new ArrayList<>();
        User user1 = new User("Vasya", 15);
        User user2 = new User("Petyan", 16);
        User user3 = new User("Kolyan", 18);
        users.add(user2);
        users.add(user1);
        users.add(user3);
        checkList.add(user1);
        checkList.add(user2);
        checkList.add(user3);
        sortUser.sortByAllFields(users);
        assertEquals(users, checkList);
    }
}

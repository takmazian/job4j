package ru.job4j.search;

import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void whenAddThreeElemenGetSortedSetWithThree() {
        SortUser sortUser = new SortUser();
        List<User> users = List.of(new User("Vasya", 15),new User("Petya", 16),new User("Kolya", 18));
        TreeSet<User> userTreeSet = new TreeSet<>(Set.of(new User("Vasya", 15),new User("Petya", 16),new User("Kolya", 18),new User("Kolya", 18)));
        assertEquals(sortUser.sort(users), userTreeSet);
    }

    @Test
    public void testSortByLength() {
        SortUser sortUser = new SortUser();
        User user1 = new User("Petyan", 16);
        User user2 = new User("Vasya", 15);
        User user3 = new User("Kolyan", 18);
        ArrayList<User> users = new ArrayList<>(List.of(user1,user2,user3));
        ArrayList<User> checkList = new ArrayList<>(List.of(user2,user1,user3));
        sortUser.sortNameLength(users);
        assertEquals(users, checkList);
    }

    @Test
    public void testSortByAll() {
        SortUser sortUser = new SortUser();
        User user1 = new User("Vasya", 15);
        User user2 = new User("Petyan", 16);
        User user3 = new User("Kolyan", 18);
        User user4 = new User("Petyan", 25);
        List<User> users = new ArrayList<>(List.of(user2,user1,user3,user4));
        List<User> checkList = new ArrayList<>(List.of(user3,user2,user4,user1));
        sortUser.sortByAllFields(users);
        assertEquals(users, checkList);
    }
}

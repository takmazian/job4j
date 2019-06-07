package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1", "testDescription", created);
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenDeleteItemThenTrackerReturnBoolean() {
        Tracker tracker = new Tracker();

        Item one = new Item("test1", "testDescription", 123L);
        Item two = new Item("test2", "testDescription2", 1234L);
        Item three = new Item("test3", "testDescription3", 1234L);

        tracker.add(one);
        tracker.add(two);
        tracker.add(three);
        assertTrue(tracker.delete(one.getId()));
    }

    @Test
    public void whenFindAllThenGetArrayWithoutNull() {
        Tracker tracker = new Tracker();

        Item one = new Item("test1", "testDescription", 123L);
        Item two = new Item("test2", "testDescription2", 1234L);
        Item three = new Item("test3", "testDescription3", 1234L);

        tracker.add(one);
        tracker.add(two);
        tracker.add(three);

        List<Item> list = new ArrayList<>();
        list.add(one);
        list.add(two);
        list.add(three);
        assertThat(tracker.findAll(), is(list));
    }

    @Test
    public void whenFindItemWithDefiniteNameThenGetItemWithTheName() {
        Tracker tracker = new Tracker();

        Item one = new Item("test1", "testDescription", 123L);
        Item two = new Item("test2", "testDescription2", 1234L);
        Item three = new Item("test3", "testDescription3", 1234L);

        tracker.add(one);
        tracker.add(two);
        tracker.add(three);

        List<Item> list = new ArrayList<>();
        list.add(two);
        assertTrue(tracker.findByName("test2").containsAll(list));
    }

    @Test
    public void whenFindItemWithDefiniteIdThenGetItemWithTheId() {
        Tracker tracker = new Tracker();

        Item one = new Item("test1", "testDescription", 123L);
        Item two = new Item("test2", "testDescription2", 1234L);
        Item three = new Item("test3", "testDescription3", 1234L);

        tracker.add(one);
        tracker.add(two);
        tracker.add(three);

        assertThat(tracker.findById(two.getId()), is(two));
    }
}
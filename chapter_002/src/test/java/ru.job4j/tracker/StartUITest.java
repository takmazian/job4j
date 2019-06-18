package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.StringJoiner;
import java.util.function.Consumer;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class StartUITest {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final Consumer<String> output = new Consumer<>() {
        @Override
        public void accept(String s) {
            stdout.println(s);
        }

        private final PrintStream stdout = new PrintStream(out);
    };

    private String menu = new StringJoiner(System.lineSeparator())
            .add("Menu.")
            .add("0. Add new item")
            .add("1. Show all items")
            .add("2. Edit item")
            .add("3. Delete item")
            .add("4. Find item by Id")
            .add("5. Find items by name")
            .add("6. Exit Program" + System.lineSeparator())
            .toString();

    @Test
    public void whenUserAddItemThenCheckOutStream() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker, output).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(this.out.toString(), is(menu
                + "------------ Edit item --------------"
                + System.lineSeparator() + "Element was replaced!"
                + System.lineSeparator() + "------------ New Item with Id : " + item.getId()
                + System.lineSeparator() + "------------ New Item with Name : test replace"
                + System.lineSeparator() + "------------ New Item with Description : заменили заявку"
                + System.lineSeparator() + menu));

    }

    @Test
    public void whenUserDeleteItemThenCheckOutStream() {
        Tracker tracker = new Tracker();

        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker, output).init();
        assertThat(this.out.toString(), is(menu + "Item was removed!" + System.lineSeparator() + menu));
    }


    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker, output).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll().get(0).getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker, output).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenDeleteThenTrackerHasNoValues() {
        Tracker tracker = new Tracker();

        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker, output).init();
        assertThat(tracker.findAll(), is(new ArrayList<Item>()));
    }

    @Test
    public void whenFindByIdThenHasItemWithId() {
        Tracker tracker = new Tracker();

        Item item = new Item("test name", "desc");
        tracker.add(item);
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker, output).init();
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenFindByNameThenHasItemWithId() {
        Tracker tracker = new Tracker();
        ArrayList<Item> result = new ArrayList<>();
        Item item = new Item("test name", "desc");
        result.add(item);
        tracker.add(item);
        item = new Item("test name", "desc");
        tracker.add(item);
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker, output).init();

        result.add(item);
        assertTrue(tracker.findByName(item.getName()).containsAll(result));
    }

}

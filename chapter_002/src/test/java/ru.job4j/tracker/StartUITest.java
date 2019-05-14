package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    // поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    @Test
    public void whenUserAddItemThenCheckOutStream() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(this.out.toString(), is("Меню.\r\n" +
                "0. Add new Item\r\n" +
                "1. Show all items\r\n" +
                "2. Edit item\r\n" +
                "3. Delete item\r\n" +
                "4. Find item by Id\r\n" +
                "5. Find items by name\r\n" +
                "6. Exit Program\r\n" +
                "Элемент заменен!\r\n" +
                "Меню.\r\n" +
                "0. Add new Item\r\n" +
                "1. Show all items\r\n" +
                "2. Edit item\r\n" +
                "3. Delete item\r\n" +
                "4. Find item by Id\r\n" +
                "5. Find items by name\r\n" +
                "6. Exit Program\r\n"));
    }

    @Test
    public void whenUserDeleteItemThenCheckOutStream() {
        Tracker tracker = new Tracker();

        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();
        assertThat(this.out.toString(), is("Меню.\r\n" +
                "0. Add new Item\r\n" +
                "1. Show all items\r\n" +
                "2. Edit item\r\n" +
                "3. Delete item\r\n" +
                "4. Find item by Id\r\n" +
                "5. Find items by name\r\n" +
                "6. Exit Program\r\n" +
                "Элемент был удален\r\n" +
                "Меню.\r\n" +
                "0. Add new Item\r\n" +
                "1. Show all items\r\n" +
                "2. Edit item\r\n" +
                "3. Delete item\r\n" +
                "4. Find item by Id\r\n" +
                "5. Find items by name\r\n" +
                "6. Exit Program\r\n"));
    }


    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
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
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenDeleteThenTrackerHasNoValues() {
        Tracker tracker = new Tracker();

        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll(), is(new Item[]{}));
    }

    @Test
    public void whenFindByIdThenHasItemWithId() {
        Tracker tracker = new Tracker();

        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenFindByNameThenHasItemWithId() {
        Tracker tracker = new Tracker();

        tracker.add(new Item("test name", "desc"));
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName(item.getName()), is(new Item[]{tracker.findAll()[0], tracker.findAll()[1]}));
    }

}

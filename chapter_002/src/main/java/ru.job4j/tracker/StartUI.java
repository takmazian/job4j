package ru.job4j.tracker;

import java.util.StringJoiner;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";

    private static final String SHOW = "1";

    private static final String EDIT = "2";

    private static final String DELETE = "3";

    private static final String FINDBYID = "4";

    private static final String FINDBYNAME = "5";

    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                //добавление заявки вынесено в отдельный метод.
                this.createItem();
            } else if (SHOW.equals(answer)) {
                this.showItems();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FINDBYID.equals(answer)) {
                this.findByID();
            } else if (FINDBYNAME.equals(answer)) {
                this.findByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    private void showItems() {
        Item[] items = tracker.findAll();
        if (items.length != 0) {
            System.out.println("------------------- Элементы ----------------------");
            for (Item item : items) {
                System.out.printf("[%s] %s %s\n", item.getId(), item.getName(), item.getDecs());
            }
        } else {
            System.out.println("Нет элементов!");
        }
    }

    private void editItem() {
        String idItem = this.input.ask("Введите номер id item-а: ");
        String nameItem = this.input.ask("Введите имя item-а: ");
        String descItem = this.input.ask("Введите описание: ");
        Item item = new Item(nameItem, descItem);
        if (tracker.replace(idItem, item)) {
            System.out.println("Элемент заменен!");
        } else {
            System.out.println("Не удалось найти элемент с таким id");
        }
    }

    private void findByID() {
        String idItem = this.input.ask("Введите номер id item-а: ");
        Item item = this.tracker.findById(idItem);
        if (item != null) {
            System.out.printf("[%s] %s %s\n", item.getId(), item.getName(), item.getDecs());
        } else {
            System.out.println("Элемент не найден!");
        }
    }

    private void findByName() {
        String nameItem = this.input.ask("Введите имя item-а: ");
        Item[] items = this.tracker.findByName(nameItem);
        if (items.length != 0) {
            for (Item item : items) {
                System.out.printf("[%s] %s %s\n", item.getId(), item.getName(), item.getDecs());
            }
        } else {
            System.out.println("Не найдено элементов с таким именем!");
        }
    }

    private void deleteItem() {
        String idItem = this.input.ask("Введите номер id item-а: ");
        boolean result = this.tracker.delete(idItem);
        if (result) {
            System.out.println("Элемент был удален");
        } else {
            System.out.println("Не удалось удалить!");
        }
    }

    private void showMenu() {
        String menu = new StringJoiner(System.lineSeparator())
                .add("Меню.")
                .add("0. Add new Item")
                .add("1. Show all items")
                .add("2. Edit item")
                .add("3. Delete item")
                .add("4. Find item by Id")
                .add("5. Find items by name")
                .add("6. Exit Program")
                .toString();
        System.out.print(menu);
    }

    /**
     * Запускт программы.
     *
     * @param args - не используются
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
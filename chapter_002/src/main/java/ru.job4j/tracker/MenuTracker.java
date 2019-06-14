package ru.job4j.tracker;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MenuTracker {
    /**
     * @param хранит ссылку на объект .
     */
    private Input input;
    /**
     * @param хранит ссылку на объект .
     */
    private Tracker tracker;
    Consumer<String> output;
    /**
     * @param хранит ссылку на массив типа UserAction.
     */
    private List<UserAction> actions = new ArrayList<>();

    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker,Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLentgh() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions(StartUI ui) {
        this.actions.add(new AddItem(0, "Add new item",output));
        this.actions.add(new ShowItems(1, "Show all items",output));
        this.actions.add(new UpdateItem(2, "Edit item",output));
        this.actions.add(new DeleteItem(3, "Delete item",output));
        this.actions.add(new FindItemById(4, "Find item by Id",output));
        this.actions.add(new FindItemsByName(5, "Find items by name",output));
        this.actions.add(new ExitProgram(6, "Exit Program", output, ui));
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        output.accept("Menu.");
        for (UserAction action : this.actions) {
            if (action != null) {
                output.accept(action.info());
            }
        }
    }
}
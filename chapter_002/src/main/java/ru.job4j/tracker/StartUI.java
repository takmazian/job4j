package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /**
     * Получение данных от пользователя.
     */
    private final Input input;
    private final Consumer<String> output;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    private boolean working = true;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker, this.output);
        ArrayList<Integer> range = new ArrayList<>();
        menu.fillActions(this);
        for (int i = 0; i < menu.getActionsLentgh(); i++) {
            range.add(i);
        }
        Integer[] rangeArray = new Integer[range.size()];
        range.toArray(rangeArray);
        do {
            menu.show();
            menu.select(input.ask("Select: ", rangeArray));
        } while (this.working);
    }

    /**
     * Запускт программы.
     *
     * @param args - не используются
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker(), System.out::println).init();
    }

    public void stop() {
        this.working = false;
    }
}
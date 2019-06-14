package ru.job4j.tracker;

import java.util.function.Consumer;

public class ExitProgram extends BaseAction {
    private final StartUI ui;


    ExitProgram(int key, String name, Consumer<String> output, StartUI ui) {
        super(key, name, output);
        this.ui = ui;
    }

    /**
     * Метод реализует добавление новой заявки в хранилище.
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        this.ui.stop();
    }

}

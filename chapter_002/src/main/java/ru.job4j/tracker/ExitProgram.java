package ru.job4j.tracker;

public class ExitProgram extends BaseAction {
    private final StartUI ui;


    ExitProgram(int key, String name, StartUI ui) {
        super(key, name);
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

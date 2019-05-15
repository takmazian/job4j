package ru.job4j.tracker;

public class ExitProgram implements UserAction {
    Integer key;
    String info;

    ExitProgram(int key, String info) {
        this.key = key;
        this.info = info;
    }

    @Override
    public int key() {
        return key;
    }

    /**
     * Метод реализует добавление новой заявки в хранилище.
     */
    @Override
    public void execute(Input input, Tracker tracker) {

    }

    @Override
    public String info() {
        return info;
    }
}

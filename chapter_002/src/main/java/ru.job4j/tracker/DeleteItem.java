package ru.job4j.tracker;

import java.util.function.Consumer;

public class DeleteItem extends BaseAction {
    Integer key;
    String info;

    DeleteItem(int key, String info, Consumer<String> output) {
        super(key, info, output);
    }

    /**
     * Метод реализует добавление новой заявки в хранилище.
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        String idItem = input.ask("Pleas, enter item's id: ");
        boolean result = tracker.delete(idItem);
        if (result) {
            output.accept("Item was removed!");
        } else {
            output.accept("Could not remove item with id!");
        }
    }

}

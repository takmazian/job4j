package ru.job4j.tracker;

import java.util.function.Consumer;

public class FindItemById extends BaseAction {
    Integer key;
    String info;

    FindItemById(int key, String info, Consumer<String> output) {
        super(key, info,output);
    }

    /**
     * Метод реализует добавление новой заявки в хранилище.
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        output.accept("------------ Find item by Id --------------");
        String idItem = input.ask("Please, provide item id: ");
        Item item = tracker.findById(idItem);
        if (item != null) {
            output.accept("------------ Item with Id : " + item.getId());
            output.accept("------------ Item with Name : " + item.getName());
            output.accept("------------ Item with Description : " + item.getDesc());
        } else {
            output.accept("Could not find item with id!");
        }
    }

}

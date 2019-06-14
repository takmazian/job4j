package ru.job4j.tracker;

import java.util.function.Consumer;

public class UpdateItem extends BaseAction {
    Integer key;
    String info;

    UpdateItem(int key, String info, Consumer<String> output) {
        super(key, info,output);
    }

    /**
     * Метод реализует добавление новой заявки в хранилище.
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        output.accept("------------ Edit item --------------");
        String idItem = input.ask("Please, provide item id: ");
        String name = input.ask("Please, provide item name:");
        String desc = input.ask("Please, provide item description:");
        Item item = new Item(name, desc);
        if (tracker.replace(idItem, item)) {
            output.accept("Element was replaced!");
            output.accept("------------ New Item with Id : " + item.getId());
            output.accept("------------ New Item with Name : " + item.getName());
            output.accept("------------ New Item with Description : " + item.getDesc());
        } else {
            output.accept("Could not find item with id!");
        }
    }

}

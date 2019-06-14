package ru.job4j.tracker;

import java.util.function.Consumer;

public class AddItem extends BaseAction {

    Integer key;
    String info;

    AddItem(int key, String info, Consumer<String> output) {
        super(key, info,output);
    }

    /**
     * Метод реализует добавление новой заявки в хранилище.
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        output.accept("------------ Adding new item --------------");
        String name = input.ask("Please, provide item name:");
        String desc = input.ask("Please, provide item description:");
        Item item = new Item(name, desc);
        tracker.add(item);
        output.accept("------------ New Item with Id : " + item.getId());
        output.accept("------------ New Item with Name : " + item.getName());
        output.accept("------------ New Item with Description : " + item.getDesc());
    }

}
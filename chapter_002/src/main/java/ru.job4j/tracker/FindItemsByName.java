package ru.job4j.tracker;

import java.util.List;
import java.util.function.Consumer;

public class FindItemsByName extends BaseAction {
    Integer key;
    String info;

    FindItemsByName(int key, String info, Consumer<String> output) {
        super(key, info, output);
    }

    /**
     * Метод реализует добавление новой заявки в хранилище.
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        String nameItem = input.ask("Please, enter item's name: ");
        List<Item> items = tracker.findByName(nameItem);
        if (items.size() != 0) {
            for (Item item : items) {
                System.out.printf("[%s] %s %s\n", item.getId(), item.getName(), item.getDesc());
            }
        } else {
            output.accept("Could not find item(s)!");
        }
    }

}

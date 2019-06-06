package ru.job4j.tracker;

import java.util.List;

public class ShowItems extends BaseAction {
    Integer key;
    String info;

    ShowItems(int key, String info) {
        super(key, info);
    }

    /**
     * Метод реализует добавление новой заявки в хранилище.
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        List<Item> items = tracker.findAll();
        if (items.size() != 0) {
            System.out.println("------------------- Elements ----------------------");
            for (Item item : items) {
                System.out.printf("[%s] %s %s\n", item.getId(), item.getName(), item.getDesc());
            }
        } else {
            System.out.println("Нет элементов!");
        }
    }

}

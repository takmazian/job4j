package ru.job4j.tracker;

public class FindItemsByName extends BaseAction {
    Integer key;
    String info;

    FindItemsByName(int key, String info) {
        super(key, info);
    }

    /**
     * Метод реализует добавление новой заявки в хранилище.
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        String nameItem = input.ask("Please, enter item's name: ");
        Item[] items = tracker.findByName(nameItem);
        if (items.length != 0) {
            for (Item item : items) {
                System.out.printf("[%s] %s %s\n", item.getId(), item.getName(), item.getDesc());
            }
        } else {
            System.out.println("Could not find item(s)!");
        }
    }

}
package ru.job4j.tracker;

public class ShowItems implements UserAction {
    Integer key;
    String info;

    ShowItems(int key, String info) {
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
        Item[] items = tracker.findAll();
        if (items.length != 0) {
            System.out.println("------------------- Elements ----------------------");
            for (Item item : items) {
                System.out.printf("[%s] %s %s\n", item.getId(), item.getName(), item.getDesc());
            }
        } else {
            System.out.println("Нет элементов!");
        }
    }

    @Override
    public String info() {
        return info;
    }
}

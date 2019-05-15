package ru.job4j.tracker;

public class DeleteItem implements UserAction {
    Integer key;
    String info;

    DeleteItem(int key, String info) {
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
        String idItem = input.ask("Pleas, enter item's id: ");
        boolean result = tracker.delete(idItem);
        if (result) {
            System.out.println("Item was removed!");
        } else {
            System.out.println("Could not remove item with id!");
        }
    }

    @Override
    public String info() {
        return info;
    }
}

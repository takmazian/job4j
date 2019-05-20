package ru.job4j.tracker;

public class DeleteItem extends BaseAction {
    Integer key;
    String info;

    DeleteItem(int key, String info) {
        super(key, info);
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

}

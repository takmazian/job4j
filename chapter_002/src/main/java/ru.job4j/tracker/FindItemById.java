package ru.job4j.tracker;

public class FindItemById implements UserAction {
    Integer key;
    String info;

    FindItemById(int key, String info) {
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
        System.out.println("------------ Find item by Id --------------");
        String idItem = input.ask("Please, provide item id: ");
        Item item =tracker.findById(idItem);
        if (item != null) {
            System.out.println("------------ Item with Id : " + item.getId());
            System.out.println("------------ Item with Name : " + item.getName());
            System.out.println("------------ Item with Description : " + item.getDesc());
        } else {
            System.out.println("Could not find item with id!");
        }
    }

    @Override
    public String info() {
        return info;
    }
}

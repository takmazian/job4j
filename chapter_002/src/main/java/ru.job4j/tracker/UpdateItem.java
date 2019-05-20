package ru.job4j.tracker;

public class UpdateItem extends BaseAction {
    Integer key;
    String info;

    UpdateItem(int key, String info) {
        super(key, info);
    }

    /**
     * Метод реализует добавление новой заявки в хранилище.
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Edit item --------------");
        String idItem = input.ask("Please, provide item id: ");
        String name = input.ask("Please, provide item name:");
        String desc = input.ask("Please, provide item description:");
        Item item = new Item(name, desc);
        if (tracker.replace(idItem, item)) {
            System.out.println("Element was replaced!");
            System.out.println("------------ New Item with Id : " + item.getId());
            System.out.println("------------ New Item with Name : " + item.getName());
            System.out.println("------------ New Item with Description : " + item.getDesc());
        } else {
            System.out.println("Could not find item with id!");
        }
    }

}

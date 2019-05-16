package ru.job4j.tracker;

import java.util.List;

public class ValidateInput extends ConsoleInput {
    @Override
    public int ask(String request, List<Integer> range) {
        boolean valid = false;
        Integer itemMenu = null;
        do {
            try {
                itemMenu = super.ask(request, range);
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Please enter valid item.");
            }
            catch (MenuOutException e){
                System.out.println("Please enter number in range.");
            }
        }while (!valid);
        return itemMenu;
    }
}
